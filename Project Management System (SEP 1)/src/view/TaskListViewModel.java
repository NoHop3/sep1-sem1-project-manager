package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ProjectModel;
import model.Task;

public class TaskListViewModel
{
  private ProjectModel model;
  private ObservableList<TasksViewModel> list;
  public TaskListViewModel(ProjectModel model)
  {
    this.model = model;
    this.list = FXCollections.observableArrayList();
    update();
  }
  public ObservableList<TasksViewModel> getList(){return list;}


  public void update()
  {
    list.clear();
    for (int i = 0; i < model.getNumberOfTasks(); i++)
    {
      list.add(new TasksViewModel(model.getTaskByIndex(i)));
    }
  }
  public void addTask(Task task)
  {
    list.add(new TasksViewModel(task));
  }
  public void remove(Task task)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (task.getTaskID()==list.get(i).getIdProperty().get())
      {
        model.removeTask(task.getTaskID());
        list.remove(i);
        break;
      }
    }
  }
}
