package view;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Project;

public class ProjectViewModel
{
  private IntegerProperty idProperty;
  private StringProperty titleProperty;
  private StringProperty descProperty;
  private IntegerProperty teamProperty;
  private IntegerProperty reqsProperty;
  private IntegerProperty tasksProperty;
  public ProjectViewModel(Project project)
  {
    this.idProperty = new SimpleIntegerProperty(project.getProjectID());
    this.titleProperty = new SimpleStringProperty(project.getTitle());
    this.descProperty = new SimpleStringProperty(project.getDescription());
    this.teamProperty = new SimpleIntegerProperty(project.getTeam().getNumberOfTeamMembers());
    this.reqsProperty = new SimpleIntegerProperty(project.getRequirements().getNumberOfRequirements());
    this.tasksProperty = new SimpleIntegerProperty(project.getTasks().getNumberOfTasks());
  }
  public IntegerProperty getIdProperty(){return idProperty;}
  public StringProperty getTitleProperty(){return titleProperty;}
  public StringProperty getDescProperty(){return descProperty;}
  public IntegerProperty getTeamProperty(){return teamProperty;}
  public IntegerProperty getReqsProperty(){return reqsProperty;}
  public IntegerProperty getTasksProperty(){return tasksProperty;}
}
