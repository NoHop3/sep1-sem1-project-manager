package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import model.ProjectModel;
import view.ViewHandler;
import view.ViewState;

public class StartWindowController
{
  @FXML private Label errorLabel;
  private ViewHandler viewHandler;
  private Region root;
  private ProjectModel model;
  private ViewState viewState;
  public StartWindowController(){}
  public void init(ViewHandler viewHandler, ProjectModel model, Region root, ViewState viewState)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    this.viewState = viewState;
    reset();
  }
  public void reset(){
    errorLabel.setText("");
  }
  public Region getRoot()
  {
    return root;
  }

  @FXML private void projectBtn(){
    viewHandler.openView("Project");
  }
  @FXML private void reqsBtn(){  viewHandler.openView("Requirement"); }
  @FXML private void teamBtn(){
    viewHandler.openView("Team");
  }
  @FXML private void tasksBtn(){
    viewHandler.openView("Tasks");
  }
  @FXML private void exitBtn(){
    viewHandler.closeView();
  }
}
