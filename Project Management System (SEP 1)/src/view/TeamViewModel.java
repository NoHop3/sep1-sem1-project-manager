package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ProjectModel;
import model.TeamMember;

public class TeamViewModel
{
  private ProjectModel model;
  private ObservableList<TeamMemberViewModel> list;
  public TeamViewModel(ProjectModel model)
  {
    this.model = model;
    this.list = FXCollections.observableArrayList();
    update();
  }

  public ObservableList<TeamMemberViewModel> getList()
  {
    return list;
  }

  public void update()
  {
    list.clear();
    for (int i = 0; i < model.getNumberOfTeamMembers(); i++)
    {
      list.add(new TeamMemberViewModel(model.getTeamMemberByIndex(i)));
    }
  }
  public void addTeamMember(TeamMember teamMember){
    list.add(new TeamMemberViewModel(teamMember));
  }
  public void removeTeamMember(TeamMember teamMember){
    for (int i = 0; i < model.getNumberOfTeamMembers(); i++)
    {
      if (list.get(i).getIdProperty().get() == teamMember.getTeamMemberID())
      {
        model.removeTeamMember(teamMember.getTeamMemberID());
        list.remove(i);
        break;
      }
    }
  }
}
