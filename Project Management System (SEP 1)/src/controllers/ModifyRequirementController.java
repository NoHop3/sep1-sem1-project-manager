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

public class ModifyRequirementController
{
  @FXML private TextField nameTextField;
  @FXML private TextField descTextField;
  @FXML private TextField hoursTextField;
  @FXML private TextField minutesTextField;
  @FXML private Label deadlineLabel;
  @FXML private Label estTimeErrorLabel;
  @FXML private Label regTimeLabel;
  @FXML private Label teamMemberErrorLabel;
  @FXML private Label teamErrorLabel;
  @FXML private Label errorLabel;
  @FXML private Label idLabel;
  @FXML private Label taskListLabel;
  private ViewHandler viewHandler;
  private Region root;
  private ViewState viewState;
  private ProjectModel model;
  public ModifyRequirementController(){}
  public void init(ViewHandler viewHandler, ProjectModel model, Region root, ViewState viewState){
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    this.viewState = viewState;
    reset();
  }
  public void reset(){
    Requirement requirement = model.getReqByID(viewState.getSelectedReq());
    idLabel.setText(requirement.getID()+"");
    nameTextField.setText(requirement.getName());
    descTextField.setText(requirement.getDescription());
    deadlineLabel.setText(requirement.getDeadline().toString());
    if(requirement.getEstimateTime()!=null)
    {
      hoursTextField.setText(requirement.getEstimateTime().getHour()+"");
      minutesTextField.setText(requirement.getEstimateTime().getMinute()+"");
      estTimeErrorLabel.setText("");
    }
    else{
      hoursTextField.setText(0+"");
      minutesTextField.setText(0+"");
      estTimeErrorLabel.setText("No est. time");
    }
    if(requirement.getResponsibleTeam().getRegTime().getTimeInSeconds()==0)
    {
      regTimeLabel.setText("No registered time");
    }
    else regTimeLabel.setText(requirement.getResponsibleTeam().getRegTime().toString());
    if(requirement.getResponsibleTeam().getNumberOfTeamMembers()==0)
      teamErrorLabel.setText("No responsible team");
    else teamErrorLabel.setText("Current TMs working:" + requirement.getResponsibleTeam().getNumberOfTeamMembers());
    if(requirement.getTasks().getNumberOfTasks()!=0)
      taskListLabel.setText("Current tasks in list:"+ requirement.getTasks().getNumberOfTasks());
    else taskListLabel.setText("No tasks in list");
    errorLabel.setText("");
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void setDeadline(){
    viewHandler.openView("Set deadline");
  }
  @FXML private void registerTime(){
    viewState.setSelectedTM(-1);
    viewState.setSelectedTask(-1);
    viewHandler.openView("Register time");
  }
  @FXML private void assignTeam(){
    Requirement requirement = model.getReqByID(viewState.getSelectedReq());
    if(requirement.getResponsibleTeam().getNumberOfTeamMembers()!=0)
      teamErrorLabel.setText("Team already assigned");
    else{
    requirement.setResponsibleTeam(model.getTeamList());
    teamErrorLabel.setText("Team assigned");}
  }
  @FXML private void removeTeam(){
    Requirement requirement = model.getReqByID(viewState.getSelectedReq());
    if(requirement.getResponsibleTeam().getNumberOfTeamMembers()!=0)
    {
      requirement.removeResponsibleTeam();
      teamErrorLabel.setText("Team Removed");
    }
    else teamErrorLabel.setText("No responsible team");
  }
  @FXML private void assignTasks(){
    Requirement requirement = model.getReqByID(viewState.getSelectedReq());
    if(requirement.getTasks().getNumberOfTasks()!=0)
      taskListLabel.setText("Task list already assigned");
    else{
      requirement.setTasks(model.getTaskList());
      taskListLabel.setText("Tasks assigned");}
  }
  @FXML private void removeTasks(){
    Requirement requirement = model.getReqByID(viewState.getSelectedReq());
    if(requirement.getTasks().getNumberOfTasks()!=0)
    {
      requirement.removeTasks();
      taskListLabel.setText("Tasks Removed");
    }
    else taskListLabel.setText("No current tasks");
  }
  @FXML private void doneBtn(){
    try{
      Requirement requirement = model.getReqByID(viewState.getSelectedReq());
      requirement.setName(nameTextField.getText());
      requirement.setDescription(descTextField.getText());
      Time time = new Time(Integer.parseInt(hoursTextField.getText()), Integer.parseInt(minutesTextField.getText()));
      requirement.setEstimateTime(time);
      errorLabel.setText("Requirement edited");
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }
  @FXML private void backBtn(){
    viewHandler.openView("Requirement");
  }
}
