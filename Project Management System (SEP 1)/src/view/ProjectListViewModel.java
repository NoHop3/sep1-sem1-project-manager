package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Project;
import model.ProjectModel;

public class ProjectListViewModel
{
  private ProjectModel model;
  private ObservableList<ProjectViewModel> list;
  public ProjectListViewModel(ProjectModel model)
  {
    this.model = model;
    this.list = FXCollections.observableArrayList();
    update();
  }
  public void update(){
    list.clear();
    for (int i = 0; i < model.getNumberOfProjects(); i++)
    {
      list.add(new ProjectViewModel(model.getProjectByIndex(i)));
    }
  }
  public ObservableList<ProjectViewModel> getList()
  {
    return list;
  }
  public void addProject(Project project){
    list.add(new ProjectViewModel((project)));
  }
  public void removeProject(Project project)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getIdProperty().get()==project.getProjectID())
      {
        model.removeProjectByID(project.getProjectID());
        list.remove(i);
        break;
      }
    }
  }
}
