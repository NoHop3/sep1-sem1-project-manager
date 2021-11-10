package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.ProjectModel;
import model.Task;
import model.Time;
import view.ViewHandler;
import view.ViewState;

public class AddTaskController {
  @FXML private TextField idTextField;
  @FXML private TextField nameTextField;
  @FXML private TextField descriptionTextField;
  @FXML private TextField statusTextField;
  @FXML private TextField hoursTextField;
  @FXML private TextField minutesTextField;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private ProjectModel model;
  private ViewState viewState;

  public AddTaskController(){}
  public void init(ViewHandler viewHandler,ProjectModel model,Region root, ViewState viewState){
    this.root = root;
    this.viewHandler = viewHandler;
    this.model = model;
    this.viewState = viewState;
    reset();
  }
  public void reset(){
    idTextField.setText("");
    nameTextField.setText("");
    descriptionTextField.setText("");
    errorLabel.setText("Fields with \"*\" must be filled");
    statusTextField.setText("");
    hoursTextField.setText("");
    minutesTextField.setText("");
  }

  public Region getRoot() {
    return root;
  }

  @FXML private void addTask(){
   try
   {
     if(model.getTaskByID(Integer.parseInt(idTextField.getText()))==null)
     {
       Task task = new Task(Integer.parseInt(idTextField.getText()),
           nameTextField.getText());
       if (descriptionTextField.getText() != null)
         task.setDescription(descriptionTextField.getText());
       if (statusTextField.getText() != null)
         task.setStatus(statusTextField.getText());
       Time estTime = new Time(Integer.parseInt(hoursTextField.getText()),
           Integer.parseInt(minutesTextField.getText()));
       task.setEstimateTime(estTime);
       model.addTask(task);
       errorLabel.setText("Task added");
     }
     else errorLabel.setText("ID must be unique");
   }
      catch(Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }
  @FXML private void assignTM(){
    viewState.setSelectedTM(Integer.parseInt(idTextField.getText()));
    viewHandler.openView("Assign a team member");
  }
  @FXML private void cancelTask(){
    viewHandler.openView("Tasks");
  }
}
