package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.MyDate;
import model.ProjectModel;
import model.Requirement;
import view.ViewHandler;
import view.ViewState;

public class setDeadlineController {
  @FXML private TextField idTextField;
  @FXML private TextField dayTextField;
  @FXML private TextField monthTextField;
  @FXML private TextField yearTextField;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private ProjectModel model;
  private ViewState viewState;

  public setDeadlineController(){}
  public void init(ViewHandler viewHandler,ProjectModel model,Region root, ViewState viewState){
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    this.viewState = viewState;
    reset();
  }
  public Region getRoot()
  {
    return root;
  }
  public void reset(){
    Requirement requirement = model.getReqByID(viewState.getSelectedReq());
    idTextField.setText(requirement.getID()+"");
    if(requirement.getDeadline()!=null)
    {
      dayTextField.setText(requirement.getDeadline().getDay()+"");
      monthTextField.setText(requirement.getDeadline().getMonth()+"");
      yearTextField.setText(requirement.getDeadline().getYear()+"");
    }
    else{
      dayTextField.setText("");
      monthTextField.setText("");
      yearTextField.setText("");
    }
    errorLabel.setText("");
  }
  @FXML private void setButton(){
    Requirement requirement = model.getReqByID(viewState.getSelectedReq());
    MyDate deadline = new MyDate();
    deadline.set(Integer.parseInt(dayTextField.getText()), Integer.parseInt(monthTextField.getText()), Integer.parseInt(yearTextField.getText()));
    requirement.setDeadline(deadline);
    errorLabel.setText("Deadline updated");
  }
  @FXML private void cancelButton(){
    viewHandler.openView("Modify a requirement");
  }
}
