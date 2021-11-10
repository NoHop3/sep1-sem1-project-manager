package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ProjectModel;
import model.Requirement;

public class RequirementListViewModel
{
  private ProjectModel model;
  private ObservableList<RequirementViewModel> list;
  public RequirementListViewModel(ProjectModel model)
  {
    this.model = model;
    this.list = FXCollections.observableArrayList();
    update();
  }
  public void update()
  {
    list.clear();
    for (int i = 0; i < model.getNumberOfRequirements(); i++)
    {
      list.add(new RequirementViewModel(model.getReqByIndex(i)));
    }
  }

  public ObservableList<RequirementViewModel> getList()
  {
    return list;
  }
  public void addRequirement(Requirement requirement)
  { list.add(new RequirementViewModel(requirement));}

  public void removeRequirement(Requirement requirement)
  {
    for (int i = 0; i < model.getNumberOfRequirements(); i++)
    {
      if(list.get(i).getIdProperty().get()==requirement.getID())
      {
        model.removeRequirement(requirement.getID());
        list.remove(i);break;
      }
    }
  }
}
