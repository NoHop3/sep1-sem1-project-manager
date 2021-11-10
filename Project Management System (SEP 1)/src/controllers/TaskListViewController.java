package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.ProjectModel;
import model.Task;
import view.TaskListViewModel;
import view.TasksViewModel;
import view.ViewHandler;
import view.ViewState;

import java.util.Optional;

public class TaskListViewController
{
  @FXML private TableView<TasksViewModel> taskListTable;
  @FXML private TableColumn<TasksViewModel, Number> idColumn;
  @FXML private TableColumn<TasksViewModel, String> nameColumn;
  @FXML private TableColumn<TasksViewModel, String> descColumn;
  @FXML private TableColumn<TasksViewModel, String> statusColumn;
  @FXML private TableColumn<TasksViewModel, Number> resTeamMemberColumn;
  @FXML private TableColumn<TasksViewModel, Number> estTimeColumn;
  @FXML private TableColumn<TasksViewModel, Number> spentTimeColumn;
  @FXML private TableColumn<TasksViewModel, String> availabilityColumn;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private ProjectModel model;
  private TaskListViewModel view;
  private ViewState state;
  public TaskListViewController(){}
  public void init(ViewHandler viewHandler,ProjectModel model, Region root,   ViewState viewState)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    this.view = new TaskListViewModel(model);
    this.state= viewState;
    taskListTable.setItems(view.getList());
    idColumn.setCellValueFactory(cellData-> cellData.getValue().getIdProperty());
    nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    descColumn.setCellValueFactory(cellData-> cellData.getValue().getDescProperty());
    statusColumn.setCellValueFactory(cellData-> cellData.getValue().getStatusProperty());
    resTeamMemberColumn.setCellValueFactory(cellData-> cellData.getValue().getResTeamMember());
    estTimeColumn.setCellValueFactory(cellData-> cellData.getValue().getEstTime());
    spentTimeColumn.setCellValueFactory(cellData-> cellData.getValue().getSpentTime());
    availabilityColumn.setCellValueFactory(cellData -> cellData.getValue().getAvailabilityProperty());
    reset();
  }
  public void reset()
  {
    errorLabel.setText("");
    view.update();
  }
  public Region getRoot(){
    return root;
  }
  @FXML private void addTask()
  {
    viewHandler.openView("Add a task");
  }
  @FXML private void removeTask()
  {
    errorLabel.setText("");
    try{
      TasksViewModel selectedItem = taskListTable.getSelectionModel().getSelectedItem();
      boolean remove = confirmation();
      if (remove){
        Task task= new Task(selectedItem.getIdProperty().get(),selectedItem.getDescProperty().get());
        model.removeTask(task.getTaskID());
        view.remove(task);
        taskListTable.getSelectionModel().clearSelection();
      }
    }catch (Exception e){
      errorLabel.setText("Item not found: " + e.getMessage());
    }
  }
  private boolean confirmation(){
    int index = taskListTable.getSelectionModel().getSelectedIndex();
    TasksViewModel selectedItem = taskListTable.getItems().get(index);
    if (index < 0 || index >= taskListTable.getItems().size()){
      return false;
    }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("Removing task {" + selectedItem.getIdProperty().get() + selectedItem.getDescProperty().get() + "}");
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent())&&(result.get()==ButtonType.OK);
  }
  @FXML private void modifyTask()
  {
    try
    {
      state.setSelectedTask(
          taskListTable.getSelectionModel().getSelectedItem().getIdProperty().get());
      viewHandler.openView("Modify a task");
    }
    catch (Exception e)
    {
      errorLabel.setText("Wrong/No Selection");
    }
  }
  @FXML private void assignTask(){
      if(state.getSelectedTM()==-1)
      {
        viewHandler.openView("Team");
      }
      else
      {
        if (taskListTable.getSelectionModel().getSelectedItem().getAvailabilityProperty().get().equals("Yes"))
        {
          state.setSelectedTask(
              taskListTable.getSelectionModel().getSelectedItem().getIdProperty().get());
          viewHandler.openView("Assign a task");
          state.setSelectedReq(-1);
        }
        else
          errorLabel.setText("Task is not available");
      }
  }
  @FXML private void backBtn(){
    viewHandler.openView("Start Window");
  }
}
