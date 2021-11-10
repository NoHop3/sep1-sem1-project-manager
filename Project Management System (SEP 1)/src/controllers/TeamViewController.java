package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.ProjectModel;
import model.TeamMember;
import view.TeamMemberViewModel;
import view.TeamViewModel;
import view.ViewHandler;
import view.ViewState;

import java.util.Optional;

public class TeamViewController
{
  @FXML private TableView<TeamMemberViewModel> teamTable;
  @FXML private TableColumn<TeamMemberViewModel, Number> idColumn;
  @FXML private TableColumn<TeamMemberViewModel, String> firstNameColumn;
  @FXML private TableColumn<TeamMemberViewModel, String> lastNameColumn;
  @FXML private TableColumn<TeamMemberViewModel, String> roleColumn;
  @FXML private TableColumn<TeamMemberViewModel, String> availabilityColumn;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private ProjectModel model;
  private TeamViewModel view;
  private ViewState state;
  public TeamViewController(){}
  public void init(ViewHandler viewHandler, ProjectModel model, Region root, ViewState state) {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    this.state = state;
    this.view = new TeamViewModel(model);
    teamTable.setItems(view.getList());
    idColumn.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
    firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProperty());
    lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getLastNameProperty());
    roleColumn.setCellValueFactory(cellData -> cellData.getValue().getRoleProperty());
    availabilityColumn.setCellValueFactory(cellData-> cellData.getValue().getAvailableProperty());
    reset();
  }

  public Region getRoot()
  {
    return root;
  }
  public void reset()
  {
    view.update();
  }
  @FXML private void addMember(){
    viewHandler.openView("Add a team member");
  }
  @FXML private void assignMember(){
    try
    {
      state.setSelectedTM(
          teamTable.getSelectionModel().getSelectedItem().getIdProperty().get());
      if (state.getSelectedReq() != -1)
      {
        state.setSelectedTask(-1);
        viewHandler.openView("Assign a requirement");
      }
      else if (state.getSelectedTask() != -1)
      {
        state.setSelectedReq(-1);
        viewHandler.openView("Assign a task");
      }
      else
      {
        state.setSelectedReq(-1);
        state.setSelectedTask(-1);
        viewHandler.openView("Assign a team member");
      }
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }
  @FXML private void modifyMember()
  {
    try{
    state.setSelectedTM(
        teamTable.getSelectionModel().getSelectedItem().getIdProperty().get());
    viewHandler.openView("Modify a team member");
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }
  @FXML private void deleteMember(){
    errorLabel.setText("");
    try{
      TeamMemberViewModel selectedItem = teamTable.getSelectionModel().getSelectedItem();
      boolean remove = confirmation();
      if (remove){
        TeamMember teamMember = new TeamMember(selectedItem.getIdProperty().get(),selectedItem.getFirstNameProperty().get(),selectedItem.getLastNameProperty().get());
        model.removeTeamMember(teamMember);
        view.removeTeamMember(teamMember);
        teamTable.getSelectionModel().clearSelection();
      }
    }catch (Exception e){
      errorLabel.setText("Item not found: " + e.getMessage());
    }
  }
  private boolean confirmation(){
    int index = teamTable.getSelectionModel().getSelectedIndex();
    TeamMemberViewModel selectedItem = teamTable.getItems().get(index);
    if (index < 0 || index >= teamTable.getItems().size()){
      return false;
    }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("Removing team member {" + selectedItem.getFirstNameProperty().get() + selectedItem.getLastNameProperty().get() + "}");
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent())&&(result.get()==ButtonType.OK);
  }
  @FXML private void backBtn(){
    viewHandler.openView("Start Window");
  }
}
