package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.*;
import view.ViewHandler;
import view.ViewState;

public class RegisterTimeController
{
  @FXML private TextField hourTextField;
  @FXML private TextField minutesTextField;
  @FXML private Label errorLabel;
  private ViewHandler viewHandler;
  private Region root;
  private ProjectModel model;
  private ViewState state;
  public RegisterTimeController(){}
  public void init(ViewHandler viewHandler, ProjectModel model, Region root, ViewState state)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    this.state = state;
    resetTime();
  }
  public void resetTime(){
    this.hourTextField.setText("");
    this.minutesTextField.setText("");
    this.errorLabel.setText("");
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void setTime(){
    try
    {
      RegisterTime regTime = new RegisterTime();
      if(hourTextField.getText().equals(""))
        regTime.setHours(0);
        else
      regTime.setHours(Integer.parseInt(hourTextField.getText()));
      if(minutesTextField.getText().equals(""))
        regTime.setMinutes(0);
      else
        regTime.setMinutes(Integer.parseInt(minutesTextField.getText()));
      if (state.getSelectedTask() != -1)
      {
        Task task = model.getTaskByID(state.getSelectedTask());
        if(task.getTeamMemberID()!=-1)
        {
          task.setSpentTime(regTime);
          errorLabel.setText("Changes saved");
        }
        else errorLabel.setText("Nobody working on this task");
      }
      if (state.getSelectedReq() != -1)
      {
        Requirement requirement = model.getReqByID(state.getSelectedReq());
        Team team = model.getReqTeam(requirement.getID());
        if(team.getNumberOfTeamMembers()!=0)
        {
          requirement.getResponsibleTeam().setRegTime(regTime);
          errorLabel.setText("Changes saved");
          if(regTime.getTimeInSeconds()>=requirement.getEstimateTime().getTimeInSeconds())
            requirement.setStatus("Completed");
        }
        else errorLabel.setText("No team working on this requirement");
      }
    }
    catch (Exception e)
    {
      errorLabel.setText("Please input valid values");
    }
  }
  @FXML private void cancelRegTime(){
    if(state.getSelectedReq()==-1)
    viewHandler.openView("Modify a task");
    else viewHandler.openView("Modify a requirement");
  }
}
