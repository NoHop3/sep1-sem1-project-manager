package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.Project;
import model.ProjectModel;
import model.Task;
import view.*;
import view.ProjectViewModel;

import java.util.Optional;

public class ProjectListViewController
{
  @FXML private TableView<ProjectViewModel> projectTable;
  @FXML private TableColumn<ProjectViewModel, Number> idColumn;
  @FXML private TableColumn<ProjectViewModel, String> titleColumn;
  @FXML private TableColumn<ProjectViewModel, String> descColumn;
  @FXML private TableColumn<ProjectViewModel, Number> teamColumn;
  @FXML private TableColumn<ProjectViewModel, Number> reqsColumn;
  @FXML private TableColumn<ProjectViewModel, Number> tasksColumn;
  @FXML private Label errorLabel;
  private ViewHandler viewHandler;
  private Region root;
  private ProjectModel model;
  private ProjectListViewModel viewModel;
  private ViewState viewState;
  public ProjectListViewController(){}
  public void init(ViewHandler viewHandler, ProjectModel model, Region region, ViewState viewState){
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = region;
    this.viewModel = new ProjectListViewModel(model);
    this.viewState = viewState;
    this.projectTable.setItems(viewModel.getList());
    this.idColumn.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
    this.titleColumn.setCellValueFactory(cellData -> cellData.getValue().getTitleProperty());
    this.descColumn.setCellValueFactory(cellData -> cellData.getValue().getDescProperty());
    this.teamColumn.setCellValueFactory(cellData -> cellData.getValue().getTeamProperty());
    this.reqsColumn.setCellValueFactory(cellData -> cellData.getValue().getReqsProperty());
    this.tasksColumn.setCellValueFactory(cellData -> cellData.getValue().getTasksProperty());
    reset();
  }
  public Region getRoot()
  {
    return root;
  }
  public void reset(){
    errorLabel.setText("");
    viewModel.update();
  }
  @FXML private void addProject(){
    viewHandler.openView("Add a project");
  }
  @FXML private void modifyProject(){
    try
    {
      viewState.setSelectedProject(
          projectTable.getSelectionModel().getSelectedItem().getIdProperty().get());
      viewHandler.openView("Modify a project");
    }
    catch (Exception e)
    {
      errorLabel.setText("Wrong/No Selection");
    }
  }
  @FXML private void removeProject(){
    errorLabel.setText("");
    try{
      ProjectViewModel selectedItem = projectTable.getSelectionModel().getSelectedItem();
      boolean remove = confirmation();
      if (remove){
        Project project= new Project(selectedItem.getIdProperty().get(),selectedItem.getTitleProperty().get());
        model.removeProject(project);
        viewModel.removeProject(project);
        projectTable.getSelectionModel().clearSelection();
      }
    }catch (Exception e){
      errorLabel.setText("Wrong/No Selection");
    }
  }
  private boolean confirmation(){
    int index = projectTable.getSelectionModel().getSelectedIndex();
    ProjectViewModel selectedItem = projectTable.getItems().get(index);
    if (index < 0 || index >= projectTable.getItems().size()){
      return false;
    }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("Removing project {" + selectedItem.getIdProperty().get() + selectedItem.getTitleProperty().get() + "}");
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent())&&(result.get()==ButtonType.OK);
  }
  @FXML private void backBtn(){
    viewHandler.openView("Start Window");
  }
}
