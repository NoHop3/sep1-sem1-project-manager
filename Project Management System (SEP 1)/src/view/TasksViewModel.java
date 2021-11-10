package view;

import javafx.beans.property.*;
import model.Task;

public class TasksViewModel
{
  private IntegerProperty idProperty;
  private StringProperty nameProperty;
  private StringProperty descProperty;
  private StringProperty statusProperty;
  private IntegerProperty resTeamMember;
  private IntegerProperty estTime;
  private IntegerProperty spentTime;
  private StringProperty availabilityProperty;

  public TasksViewModel(Task task)
  {
    this.idProperty = new SimpleIntegerProperty(task.getTaskID());
    this.nameProperty = new SimpleStringProperty(task.getName());
    this.descProperty = new SimpleStringProperty(task.getDescription());
    this.statusProperty = new SimpleStringProperty(task.getTaskStatus());
    this.resTeamMember = new SimpleIntegerProperty(task.getTeamMemberID());
    this.estTime = new SimpleIntegerProperty(task.getEstimateTime().getHour()*60+task.getEstimateTime().getMinute());
    this.spentTime = new SimpleIntegerProperty(task.getTimeSpent().getHours()*60+task.getTimeSpent().getMinutes());
    if(task.isAvailable())this.availabilityProperty = new SimpleStringProperty("Yes");
    else this.availabilityProperty = new SimpleStringProperty("No");
  }

  public IntegerProperty getIdProperty(){return idProperty;}
  public StringProperty getNameProperty(){return nameProperty;}
  public StringProperty getDescProperty(){return  descProperty;}
  public StringProperty getStatusProperty(){return statusProperty;}
  public IntegerProperty getResTeamMember(){return resTeamMember;}
  public IntegerProperty getEstTime(){return estTime;}
  public IntegerProperty getSpentTime(){return spentTime;}
  public StringProperty getAvailabilityProperty(){return availabilityProperty;}
}
