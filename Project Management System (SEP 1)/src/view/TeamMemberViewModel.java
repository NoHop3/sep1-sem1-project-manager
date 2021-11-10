package view;

import javafx.beans.property.*;
import model.TeamMember;

public class TeamMemberViewModel
{
  private IntegerProperty idProperty;
  private StringProperty firstNameProperty;
  private StringProperty lastNameProperty;
  private StringProperty roleProperty;
  private StringProperty availableProperty;

  public TeamMemberViewModel(TeamMember teamMember)
  {
    this.idProperty = new SimpleIntegerProperty(teamMember.getTeamMemberID());
    this.firstNameProperty = new SimpleStringProperty(teamMember.getFirstName());
    this.lastNameProperty = new SimpleStringProperty(teamMember.getLastName());
    this.roleProperty = new SimpleStringProperty(teamMember.getRole());
    if(teamMember.isAvailable())
    this.availableProperty = new SimpleStringProperty("Yes");
    else this.availableProperty = new SimpleStringProperty("No");
  }
  public IntegerProperty getIdProperty(){return idProperty;}
  public StringProperty getFirstNameProperty(){return firstNameProperty;}
  public StringProperty getLastNameProperty(){return lastNameProperty;}
  public StringProperty getRoleProperty(){return roleProperty;}
  public StringProperty getAvailableProperty(){return availableProperty;}
}
