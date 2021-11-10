package view;

import javafx.beans.property.*;
import model.MyDate;
import model.Requirement;

public class RequirementViewModel
{
  private IntegerProperty idProperty;
  private StringProperty nameProperty;
  private ObjectProperty<MyDate> deadlineProperty;
  private StringProperty statusProperty;
  private StringProperty descProperty;
  private IntegerProperty estProperty;
  private IntegerProperty tasksProperty;
  private IntegerProperty teamProperty;
  public RequirementViewModel(Requirement requirement)
  {
    this.idProperty = new SimpleIntegerProperty(requirement.getID());
    this.nameProperty = new SimpleStringProperty(requirement.getName());
    this.deadlineProperty = new SimpleObjectProperty<>(requirement.getDeadline());
    this.statusProperty = new SimpleStringProperty(requirement.getStatus());
    this.descProperty = new SimpleStringProperty(requirement.getDescription());
    this.estProperty = new SimpleIntegerProperty(requirement.getEstimateTime().getHour()*60+requirement.getEstimateTime().getMinute());
    this.tasksProperty = new SimpleIntegerProperty(requirement.getTasks().getNumberOfTasks());
    this.teamProperty = new SimpleIntegerProperty(requirement.getResponsibleTeam().getNumberOfTeamMembers());
  }

  public IntegerProperty getIdProperty(){return idProperty;}
  public StringProperty getNameProperty(){return nameProperty;}
  public StringProperty getDescProperty(){return descProperty;}
  public ObjectProperty<MyDate> getDeadlineProperty(){return deadlineProperty;}
  public StringProperty getStatusProperty(){return statusProperty;}
  public IntegerProperty getEstProperty(){return estProperty;}
  public IntegerProperty getTasksProperty(){return tasksProperty;}
  public IntegerProperty getTeamProperty(){return teamProperty;}

}
