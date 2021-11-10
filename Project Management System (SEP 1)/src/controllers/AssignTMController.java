package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import model.ProjectModel;
import model.Requirement;
import model.Task;
import model.TeamMember;
import view.ViewHandler;
import view.ViewState;


public class AssignTMController
{
  @FXML private Label teamMemberLabel;
  @FXML private Label warningLabel;
  private ViewHandler viewHandler;
  private Region root;
  private ViewState viewState;
  private ProjectModel model;
  public AssignTMController(){}
  public void init(ViewHandler viewHandler, ProjectModel model, Region root, ViewState viewState)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    this.viewState = viewState;
    reset();
  }
  public void reset(){
    teamMemberLabel.setText(model.getTeamMemberByID(viewState.getSelectedTM()).getTeamMemberID()+" "+model.getTeamMemberByID(viewState.getSelectedTM()).getFullName());
    if(!model.getTeamMemberByID(viewState.getSelectedTM()).isAvailable())
      warningLabel.setText("Warning! This team member is not available");
    else warningLabel.setText("Great! This team member is currently available");
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void assignTask(){
    if(viewState.getSelectedTask()==-1)
    viewHandler.openView("Tasks");
    else {
      Task task = model.getTaskByID(viewState.getSelectedTask());
      if(task.isAvailable())task.setTeamMemberID(viewState.getSelectedTM());
      else warningLabel.setText("This task is not available");
    }
  }
  @FXML private void assignReq(){

    if(viewState.getSelectedReq()==-1)
      viewHandler.openView("Requirement");
    else {
      Requirement requirement = model.getReqByID(viewState.getSelectedReq());
      TeamMember teamMember = model.getTeamMemberByID(viewState.getSelectedTM());
      requirement.addResponsibleTM(teamMember);
      warningLabel.setText("Requirement assigned");
    }
  }
  @FXML private void doneBtn(){
    warningLabel.setText("Changes saved");
  }
  @FXML private void cancelBtn(){
    viewHandler.openView("Start window");
  }
}
