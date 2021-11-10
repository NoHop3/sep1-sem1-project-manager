package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.Project;
import model.ProjectModel;
import view.ViewHandler;
import view.ViewState;

public class AddProjectController
{
  @FXML private TextField idTextField;
  @FXML private TextField titleTextField;
  @FXML private TextArea descTextArea;
  @FXML private Label errorLabel;
  private ViewHandler viewHandler;
  private Region root;
  private ProjectModel model;
  private ViewState viewState;
  public AddProjectController(){}
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
    titleTextField.setText("");
    descTextArea.setText("");
    errorLabel.setText("");
  }
  public Region getRoot()
  {
    return root;
  }
  @FXML private void doneBtn(){
    try
    {
      if(model.getProjectByID(Integer.parseInt(idTextField.getText()))==null)
      {
        Project project = new Project(Integer.parseInt(idTextField.getText()),
            titleTextField.getText());
        project.setDescription(descTextArea.getText());
        model.addProject(project);
        errorLabel.setText("Project added");
      }
      else errorLabel.setText("ID must be unique");
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }
  @FXML private void backBtn(){
    viewHandler.openView("Project");
  }
}
