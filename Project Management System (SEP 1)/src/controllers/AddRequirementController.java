package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.ProjectModel;
import model.Requirement;
import model.Time;
import view.ViewHandler;
import view.ViewState;

public class AddRequirementController
{
  @FXML private TextField idTextField;
  @FXML private TextField nameTextField;
  @FXML private TextField descTextField;
  @FXML private TextField statusTextField;
  @FXML private TextField hoursTextField;
  @FXML private TextField minutesTextField;
  @FXML private Label errorLabel;
  @FXML private Label dateErrorLabel;
  private ViewHandler viewHandler;
  private Region root;
  private ProjectModel model;
  private ViewState viewState;
  public AddRequirementController(){}
  public void init(ViewHandler viewHandler, ProjectModel model, Region root, ViewState viewState)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    this.viewState = viewState;
    reset();
  }
  public void reset(){
    idTextField.setText("");
    nameTextField.setText("");
    descTextField.setText("");
    statusTextField.setText("");
    hoursTextField.setText("");
    minutesTextField.setText("");
    errorLabel.setText("");
    dateErrorLabel.setText("");
  }
  public Region getRoot()
  {
    return root;
  }
  @FXML private void doneBtn(){
    try
    {
      if(model.getReqByID(Integer.parseInt(idTextField.getText()))==null)
      {
        Requirement requirement = new Requirement(Integer.parseInt(idTextField.getText()), nameTextField.getText());
        if (descTextField.getText() != null)
          requirement.setDescription(descTextField.getText());
        if (statusTextField.getText() != null)
          requirement.setStatus(statusTextField.getText());
        Time time = new Time(0);
        time.setHour(Integer.parseInt(hoursTextField.getText()));
        time.setMinute(Integer.parseInt(minutesTextField.getText()));
        requirement.setEstimateTime(time);
        model.addRequirement(requirement);
        errorLabel.setText("Requirement added");
      }
      else errorLabel.setText("ID must be unique");
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }
  @FXML private void deadline(){
    if(viewState.getSelectedReq()==-1)dateErrorLabel.setText("To add deadline you must insert ID");
    else
    {
      viewState.setSelectedReq(Integer.parseInt(idTextField.getText()));
      doneBtn();
      viewHandler.openView("Set deadline");
    }
  }
  @FXML private void backBtn1(){
    viewState.setSelectedReq(-1);
    viewHandler.openView("Requirement");
  }
}
