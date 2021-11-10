package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.ProjectModel;
import model.TeamMember;
import view.ViewHandler;
import view.ViewState;

public class AddTeamMemberController{
  @FXML private TextField firstNameTextField;
  @FXML private TextField lastNameTextField;
  @FXML private TextField roleTextField;
  @FXML private TextField IDTextField;
  @FXML private Label errorLabel;
  private Region root;
  private ProjectModel model;
  private ViewHandler viewHandler;
  private ViewState viewState;

  public AddTeamMemberController(){}
  public void init(ViewHandler viewHandler,ProjectModel model,Region root, ViewState viewState){
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    this.viewState = viewState;
    reset();
  }
  public void reset(){
    firstNameTextField.setText("");
    lastNameTextField.setText("");
    roleTextField.setText("");
    IDTextField.setText("");
    errorLabel.setText("");
  }

  public Region getRoot() {
    return root;
  }

  @FXML private void cancelButton(){
    viewHandler.openView("Team");
  }
  @FXML private void setButton(){
    try {
      if(model.getTeamMemberByID(Integer.parseInt(IDTextField.getText()))==null)
      {
        TeamMember member = new TeamMember(Integer.parseInt(IDTextField.getText()),
            firstNameTextField.getText(), lastNameTextField.getText());
        member.setRole(roleTextField.getText());
        model.addTeamMember(member);
        errorLabel.setText("Team member added");
      }
      else errorLabel.setText("ID must be unique");
    }catch (Exception e){
      errorLabel.setText(e.getMessage());
    }
  }
}


