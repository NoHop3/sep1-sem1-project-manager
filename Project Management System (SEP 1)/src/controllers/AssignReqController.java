package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import model.*;
import view.ViewHandler;
import view.ViewState;

public class AssignReqController
{
  @FXML private Label reqLabel;
  @FXML private Label tmLabel;
  @FXML private Label errorLabel;
  private ViewState viewState;
  private ViewHandler viewHandler;
  private Region root;
  private ProjectModel model;
  public AssignReqController(){}
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
    if(viewState.getSelectedTM()!=-1)
    {
      TeamMember teamMember = model.getTeamMemberByID(viewState.getSelectedTM());
      Requirement requirement = model.getReqByID(viewState.getSelectedReq());
      reqLabel.setText(requirement.getID() + " " + requirement.getName());
      tmLabel.setText(teamMember.getTeamMemberID() + " " + teamMember.getFullName());
    }
    else errorLabel.setText("No team member assigned");
    errorLabel.setText("");
  }
  @FXML private void assignBtn(){
    if(viewState.getSelectedTM()!=-1)
    {
      Requirement requirement = model.getReqByID(viewState.getSelectedReq());
      TeamMember teamMember = model.getTeamMemberByID(viewState.getSelectedTM());
      requirement.addResponsibleTM(teamMember);
      errorLabel.setText("This requirement was assigned");
    }
    else errorLabel.setText("No team member selected");
  }
  @FXML private void backBtn(){
    viewHandler.openView("Start Window");
  }
}
