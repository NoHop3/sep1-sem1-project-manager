package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.Project;
import model.ProjectModel;
import view.ViewHandler;
import view.ViewState;


public class ModifyProjectController
{
  @FXML private TextField titleTextField;
  @FXML private TextField descTextField;
  @FXML private Label idLabel;
  @FXML private Label errorLabel;
  private ViewHandler viewHandler;
  private Region root;
  private ViewState viewState;
  private ProjectModel projectModel;
  public ModifyProjectController(){}
  public void init(ViewHandler viewHandler, ProjectModel model, Region root, ViewState viewState)
  {
    this.viewHandler = viewHandler;
    this.projectModel = model;
    this.root = root;
    this.viewState = viewState;
    reset();
  }
  public void reset(){
    Project project = projectModel.getProjectByID(viewState.getSelectedProject());
    titleTextField.setText(project.getTitle());
    descTextField.setText(project.getDescription());
    idLabel.setText(project.getProjectID()+"");
    errorLabel.setText("");
  }

  public Region getRoot()
  {
    return root;
  }
  @FXML private void modifyTeam(){
    viewHandler.openView("Team");
  }
  @FXML private void modifyRequirement(){
    viewHandler.openView("Requirements");
  }
  @FXML private void modifyTasks(){
    viewHandler.openView("Tasks");
  }
  @FXML private void doneBtn()
  {
    try
    {
      Project project = projectModel.getProjectByID(viewState.getSelectedProject());
      project.setTitle(titleTextField.getText());
      project.setDescription(descTextField.getText());
      errorLabel.setText("Changes saved.");
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }
  @FXML private void cancelProject(){
    viewHandler.openView("Project");
  }
}
