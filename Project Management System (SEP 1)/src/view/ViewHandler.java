package view;

import controllers.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.ProjectModel;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private ProjectModel model;
  private ViewState state;
  private AddProjectController addProjectController;
  private AddRequirementController addRequirementController;
  private AddTaskController addTaskController;
  private AddTeamMemberController addTeamMemberController;
  private AssignReqController assignReqController;
  private AssignTaskController assignTaskController;
  private AssignTMController assignTMController;
  private ModifyProjectController modifyProjectController;
  private ModifyRequirementController modifyRequirementController;
  private ModifyTaskController modifyTaskController;
  private ModifyTeamMemberController modifyTeamMemberController;
  private ProjectListViewController projectListViewController;
  private RequirementListViewController requirementListViewController;
  private TaskListViewController taskListViewController;
  private TeamViewController teamViewController;
  private RegisterTimeController registerTimeController;
  private setDeadlineController setDeadlineController;
  private StartWindowController startWindowController;

  public ViewHandler(ProjectModel model){
    this.model = model;
    this.currentScene = new Scene(new Region());
    this.state = new ViewState();
  }
  public void start(Stage primaryStage){
    this.primaryStage = primaryStage;
    openView("Start Window");
  }
  public void openView(String id){
    Region root = null;

    switch (id)
    {
      case "Start Window":
        root = loadStartWindow("StartWindow.fxml");
        break;
      case "Project":
        root = loadProjectView("Project.fxml");
        break;
      case "Add a project":
        root = loadAddProjectView("AddProject.fxml");
        break;
      case "Modify a project":
        root = loadModifyProjectView("ModifyProject.fxml");
        break;
      case "Add a requirement":
        root = loadAddRequirementView("AddRequirement.fxml");
        break;
      case "Add a task":
        root = loadAddTaskView("AddTask.fxml");
        break;
      case "Modify a task":
        root = loadModifyTaskView("ModifyTask.fxml");
        break;
      case "Set deadline":
        root = loadSetDeadlineView("setDeadline.fxml");
        break;
      case "Requirement":
        root = loadRequirementsView("Requirements.fxml");
        break;
      case "Tasks":
        root = loadTasksView("Tasks.fxml");
        break;
      case "Team":
        root = loadTeamView("Team.fxml");
        break;
      case "Add a team member":
        root = loadAddTeamMemberView("AddTeamMember.fxml");
        break;
      case "Assign a team member":
        root = loadAssignTeamMemberView("AssignTM.fxml");
        break;
      case "Modify a team member":
        root = loadModifyTeamMemberView("ModifyTeamMember.fxml");
        break;
      case "Modify a requirement":
        root = loadModifyRequirementsView("ModifyRequirement.fxml");
        break;
      case "Register time":
        root = loadRegisterTimeView("RegisterTime.fxml");
        break;
      case "Assign a task":
        root = loadAssignTaskView("AssignTask.fxml");
        break;
      case "Assign a requirement":
        root = loadAssignReqView("AssignReq.fxml");
        break;
    }
    currentScene.setRoot(root);
    String title = "PMS 1.0v";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  private Region loadStartWindow(String fxmlFile){
    {
      if (startWindowController == null) {
        try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          startWindowController = loader.getController();
          startWindowController.init(this,model,root, state);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }else {
        startWindowController.reset();
      }
      return startWindowController.getRoot();
    }
  }
  private Region loadModifyRequirementsView(String fxmlFile){
    {
      if (modifyRequirementController == null) {
        try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          modifyRequirementController = loader.getController();
          modifyRequirementController.init(this,model,root, state);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }else {
        modifyRequirementController.reset();
      }
      return modifyRequirementController.getRoot();
    }
  }
  private Region loadModifyTeamMemberView(String fxmlFile){
    {
      if (modifyTeamMemberController == null) {
        try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          modifyTeamMemberController = loader.getController();
          modifyTeamMemberController.init(this,model,root, state);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }else {
        modifyTeamMemberController.reset();
      }
      return modifyTeamMemberController.getRoot();
    }
  }
  private Region loadAssignTeamMemberView(String fxmlFile){
    {
      if (assignTMController == null) {
        try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          assignTMController = loader.getController();
          assignTMController.init(this,model,root, state);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }else {
        assignTMController.reset();
      }
      return assignTMController.getRoot();
    }
  }
  private Region loadAssignReqView(String fxmlFile){
    {
      if (assignReqController == null) {
        try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          assignReqController = loader.getController();
          assignReqController.init(this,model,root, state);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }else {
        assignReqController.reset();
      }
      return assignReqController.getRoot();
    }
  }
  private Region loadAssignTaskView(String fxmlFile){
    {
      if (assignTaskController == null) {
        try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          assignTaskController = loader.getController();
          assignTaskController.init(this,model,root, state);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }else {
        assignTaskController.reset();
      }
      return assignTaskController.getRoot();
    }
  }
  private Region loadModifyTaskView(String fxmlFile){
    {
      if (modifyTaskController == null) {
        try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          modifyTaskController = loader.getController();
          modifyTaskController.init(this,model,root, state);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }else {
        modifyTaskController.reset();
      }
      return modifyTaskController.getRoot();
    }
  }
  private Region loadRegisterTimeView(String fxmlFile){
    {
      if (registerTimeController == null) {
        try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          registerTimeController = loader.getController();
          registerTimeController.init(this,model,root, state);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }else {
        registerTimeController.resetTime();
      }
      return registerTimeController.getRoot();
    }
  }
  private Region loadAddTeamMemberView(String fxmlFile){
    {
      if (addTeamMemberController == null) {
        try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          addTeamMemberController = loader.getController();
          addTeamMemberController.init(this,model,root, state);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }else {
        addTeamMemberController.reset();
      }
      return addTeamMemberController.getRoot();
    }
  }
  private Region loadTeamView(String fxmlFile){
    {
      if (teamViewController == null) {
        try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          teamViewController = loader.getController();
          teamViewController.init(this,model,root,state);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }else {
        teamViewController.reset();
      }
      return teamViewController.getRoot();
    }
  }
  private Region loadTasksView(String fxmlFile){
    {
      if (taskListViewController == null) {
        try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          taskListViewController = loader.getController();
          taskListViewController.init(this,model,root, state);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }else {
        taskListViewController.reset();
      }
      return taskListViewController.getRoot();
    }
  }
  private Region loadRequirementsView(String fxmlFile){
    {
      if (requirementListViewController == null) {
        try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          requirementListViewController = loader.getController();
          requirementListViewController.init(this,model,root, state);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }else {
        requirementListViewController.reset();
      }
      return requirementListViewController.getRoot();
    }
  }
  private Region loadSetDeadlineView(String fxmlFile){
    {
      if (setDeadlineController == null) {
        try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          setDeadlineController = loader.getController();
          setDeadlineController.init(this,model,root, state);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }else {
        setDeadlineController.reset();
      }
      return setDeadlineController.getRoot();
    }
  }
  private Region loadAddTaskView(String fxmlFile){
    {
      if (addTaskController == null) {
        try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          addTaskController = loader.getController();
          addTaskController.init(this,model,root, state);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }else {
        addTaskController.reset();
      }
      return addTaskController.getRoot();
    }
  }
  private Region loadAddRequirementView(String fxmlFile){
    {
      if (addRequirementController == null) {
        try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          addRequirementController = loader.getController();
          addRequirementController.init(this,model,root, state);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }else {
        addRequirementController.reset();
      }
      return addRequirementController.getRoot();
    }
  }
  private Region loadModifyProjectView(String fxmlFile){
    {
      if (modifyProjectController == null) {
        try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          modifyProjectController = loader.getController();
          modifyProjectController.init(this,model,root, state);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }else {
        modifyProjectController.reset();
      }
      return modifyProjectController.getRoot();
    }
  }
  private Region loadAddProjectView(String fxmlFile){
    {
      if (addProjectController == null) {
        try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          addProjectController = loader.getController();
          addProjectController.init(this,model,root, state);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }else {
        addProjectController.reset();
      }
      return addProjectController.getRoot();
    }
  }
  private Region loadProjectView(String fxmlFile){
    {
      if (projectListViewController == null) {
        try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          projectListViewController = loader.getController();
          projectListViewController.init(this,model,root, state);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }else {
        projectListViewController.reset();
      }
      return projectListViewController.getRoot();
    }
  }
  public void closeView()
  {
    primaryStage.close();
  }}