package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import model.ProjectModel;
import model.Task;
import model.TeamMember;
import view.ViewHandler;
import view.ViewState;

public class AssignTaskController
{
  @FXML private Label taskLabel;
  @FXML private Label tmLabel;
  @FXML private Label errorLabel;
  private ViewState viewState;
  private ViewHandler viewHandler;
  private Region root;
  private ProjectModel model;
  public AssignTaskController(){}
  public void init(ViewHandler viewHandler, ProjectModel model, Region root, ViewState viewState){
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
    TeamMember teamMember = model.getTeamMemberByID(viewState.getSelectedTM());
    Task task = model.getTaskByID(viewState.getSelectedTask());
    taskLabel.setText(task.getTaskID()+" "+task.getName());
    tmLabel.setText(teamMember.getTeamMemberID()+" "+teamMember.getFullName());
    errorLabel.setText("");
  }
  @FXML private void assignBtn(){
    TeamMember teamMember = model.getTeamMemberByID(viewState.getSelectedTM());
    Task task = model.getTaskByID(viewState.getSelectedTask());
    task.setTeamMemberID(teamMember.getTeamMemberID());
    errorLabel.setText("Task " + task.getTaskID() + " " + task.getName() + " was assigned");
  }
  @FXML private void backBtn(){
    viewHandler.openView("Tasks");
  }
}
