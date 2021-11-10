package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.MyDate;
import model.ProjectModel;
import model.Requirement;
import model.Task;
import view.RequirementListViewModel;
import view.RequirementViewModel;
import view.ViewHandler;
import view.ViewState;

import java.util.Optional;

public class RequirementListViewController
{
  @FXML private TableView<RequirementViewModel> requirementTable;
  @FXML private TableColumn<RequirementViewModel, Number> idColumn;
  @FXML private TableColumn<RequirementViewModel, String> nameColumn;
  @FXML private TableColumn<RequirementViewModel, MyDate> deadlineColumn;
  @FXML private TableColumn<RequirementViewModel, String> descColumn;
  @FXML private TableColumn<RequirementViewModel, String> statusColumn;
  @FXML private TableColumn<RequirementViewModel, Number> estTimeColumn;
  @FXML private TableColumn<RequirementViewModel, Number> tasksColumn;
  @FXML private TableColumn<RequirementViewModel, Number> teamColumn;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private ProjectModel model;
  private RequirementListViewModel viewModel;
  private ViewState viewState;

  public RequirementListViewController()
  {
  }

  public void init(ViewHandler viewHandler, ProjectModel model, Region root,
      ViewState viewState)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    this.viewModel = new RequirementListViewModel(model);
    this.viewState = viewState;
    requirementTable.setItems(viewModel.getList());
    idColumn.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
    nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    deadlineColumn.setCellValueFactory(cellData -> cellData.getValue().getDeadlineProperty());
    descColumn.setCellValueFactory(cellData -> cellData.getValue().getDescProperty());
    statusColumn.setCellValueFactory(cellData -> cellData.getValue().getStatusProperty());
    estTimeColumn.setCellValueFactory(cellData -> cellData.getValue().getEstProperty());
    tasksColumn.setCellValueFactory(cellData -> cellData.getValue().getTasksProperty());
    teamColumn.setCellValueFactory(cellData -> cellData.getValue().getTeamProperty());
    reset();
  }

  public void reset()
  {
    errorLabel.setText("");
    viewModel.update();
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void addReq()
  {
    viewHandler.openView("Add a requirement");
  }

  @FXML private void modifyReq()
  {
    try
    {
      viewState.setSelectedReq(
          requirementTable.getSelectionModel().getSelectedItem().getIdProperty()
              .get());
      viewHandler.openView("Modify a requirement");
    }
    catch (Exception e)
    {
      errorLabel.setText("Wrong/No Selection");
    }
  }
  @FXML private void assignReq(){
    viewState.setSelectedReq(
        requirementTable.getSelectionModel().getSelectedItem().getIdProperty()
            .get());
    viewState.setSelectedTask(-1);
    if(viewState.getSelectedTM()==-1)
    {
      viewHandler.openView("Team");
    }
    else
    {
      viewHandler.openView("Assign a requirement");
    }
  }
  @FXML private void removeReq()
    {
      errorLabel.setText("");
      try{
        RequirementViewModel selectedItem = requirementTable.getSelectionModel().getSelectedItem();
        boolean remove = confirmation();
        if (remove){
          Requirement requirement= new Requirement(selectedItem.getIdProperty().get(), selectedItem.getNameProperty()
              .get(), (MyDate) selectedItem.getDeadlineProperty().get());
          model.removeRequirement(requirement);
          viewModel.removeRequirement(requirement);
          requirementTable.getSelectionModel().clearSelection();
        }
      }catch (Exception e){
        errorLabel.setText("Wrong/No Selection");
      }
    }
    private boolean confirmation(){
      int index = requirementTable.getSelectionModel().getSelectedIndex();
      RequirementViewModel selectedItem = requirementTable.getItems().get(index);
      if (index < 0 || index >= requirementTable.getItems().size()){
        return false;
      }
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Confirmation");
      alert.setHeaderText("Removing Requirement {" + selectedItem.getIdProperty().get() + selectedItem.getNameProperty().get() + "}");
      Optional<ButtonType> result = alert.showAndWait();
      return (result.isPresent())&&(result.get()==ButtonType.OK);
    }
  @FXML private void backBtn(){
    viewHandler.openView("Start Window");
  }
}
