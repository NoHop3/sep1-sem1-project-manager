package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.*;
import view.ViewHandler;
import view.ViewState;

public class ModifyTaskController
{
  @FXML private TextField nameTextField;
  @FXML private TextField descTextField;
  @FXML private TextField hoursTextField;
  @FXML private TextField minutesTextField;
  @FXML private Label regTimeLabel;
  @FXML private Label errorTeamMemberLabel;
  @FXML private Label errorLabel;
  @FXML private Label idLabel;
  private ViewHandler viewHandler;
  private ViewState viewState;
  private Region root;
  private ProjectModel model;
  public ModifyTaskController(){}
  public void init(ViewHandler viewHandler, ProjectModel model, Region root, ViewState viewState)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    this.viewState = viewState;
    reset();
  }
  public Region getRoot()
  {
    return root;
  }

  public void reset(){
    Task task = model.getTaskByID(viewState.getSelectedTask());
    idLabel.setText(task.getTaskID()+"");
    nameTextField.setText(task.getName());
    descTextField.setText(task.getDescription());
    if(task.getEstimateTime()!=null)
    {
      hoursTextField.setText(task.getEstimateTime().getHour()+"");
      minutesTextField.setText(task.getEstimateTime().getMinute()+"");
    }
    else
    {
      hoursTextField.setText(0+"");
      minutesTextField.setText(0+"");
    }
    if(task.getTimeSpent().getTimeInSeconds()==0)
    regTimeLabel.setText("");
    else regTimeLabel.setText(task.getTimeSpent().toString());
    if(task.getTeamMemberID()==-1)
    errorTeamMemberLabel.setText("No task");
    else {
      TeamMember teamMember = model.getTeamMemberByID(task.getTeamMemberID());
      errorTeamMemberLabel.setText("ID: "+task.getTeamMemberID()+", Name: "+teamMember.getFullName());
    }
    errorLabel.setText("");
  }
  @FXML private void editRegTime(){
    viewState.setSelectedTM(-1);
    viewState.setSelectedReq(-1);
    viewHandler.openView("Register time");
  }
  @FXML private void assignTM(){
    viewState.setSelectedTM(-1);
    viewState.setSelectedReq(-1);
    viewHandler.openView("Team");
  }
  @FXML private void removeTM(){
    Task task = model.getTaskByID(viewState.getSelectedTask());
    task.removeTeamMember();
    errorTeamMemberLabel.setText("Team Member Removed");
  }
  @FXML private void doneBtn(){
    Task task = model.getTaskByID(viewState.getSelectedTask());
    Time time = new Time(0);
    try{
      task.setName(nameTextField.getText());
      task.setDescription(descTextField.getText());
      time.set(Integer.parseInt(hoursTextField.getText()), Integer.parseInt(minutesTextField.getText()));
      task.setEstimateTime(time);
      if(task.getTimeSpent().getTimeInSeconds()>=task.getEstimateTime().getTimeInSeconds())task.setStatus("Completed");
      errorLabel.setText("Changes Saved");
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }
  @FXML private void cancelTask(){
    viewHandler.openView("Tasks");
  }
}
