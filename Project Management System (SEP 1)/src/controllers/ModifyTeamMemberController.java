package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.ProjectModel;
import model.TeamMember;
import view.ViewHandler;
import view.ViewState;

public class ModifyTeamMemberController
{
  @FXML private Label idLabel;
  @FXML private TextField firstNameTextField;
  @FXML private TextField lastNameTextField;
  @FXML private TextField roleTextField;
  @FXML private Label regTimeTaskLabel;
  @FXML private Label regTimeReqLabel;
  @FXML private Label taskIdLabel;
  @FXML private Label reqIdLabel;
  @FXML private Label taskErrorLabel;
  @FXML private Label reqErrorLabel;
  @FXML private Label errorLabel;
  @FXML private Label regTimeTaskErrorLabel;
  @FXML private Label regTimeReqErrorLabel;
  private ViewHandler viewHandler;
  private Region root;
  private ProjectModel model;
  private ViewState state;
  public ModifyTeamMemberController(){}
  public void init(ViewHandler viewHandler,  ProjectModel model,Region root, ViewState state)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    this.state = state;
    reset();
  }
  public void reset(){
    TeamMember teamMember = model.getTeamMemberByID(state.getSelectedTM());
    idLabel.setText(teamMember.getTeamMemberID()+"");
    firstNameTextField.setText(teamMember.getFirstName());
    lastNameTextField.setText(teamMember.getLastName());
    if(teamMember.getRole()!=null)roleTextField.setText(teamMember.getRole());
    else roleTextField.setText("");


    errorLabel.setText("");
  }
  public Region getRoot()
  {
    return root;
  }
  @FXML private void doneBtn(){
    try{
      TeamMember teamMember = model.getTeamMemberByID(state.getSelectedTM());
      if(!teamMember.getFirstName().equals(firstNameTextField.getText()) && firstNameTextField.getText()!=null)
      teamMember.setFirstName(firstNameTextField.getText());
      if(!teamMember.getLastName().equals(lastNameTextField.getText()) && lastNameTextField.getText()!=null)
      teamMember.setLastName(lastNameTextField.getText());
      if(!teamMember.getRole().equals(roleTextField.getText()) && roleTextField.getText()!=null)
      teamMember.setRole(roleTextField.getText());
    }
    catch (Exception e)
    {
        errorLabel.setText(e.getMessage());
    }
  }
  @FXML private void cancelMod(){
    viewHandler.openView("Team");
  }
}
