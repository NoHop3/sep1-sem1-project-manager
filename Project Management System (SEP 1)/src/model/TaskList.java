package model;

import java.util.ArrayList;

public class TaskList
{
  private ArrayList<Task> tasks;
  private Requirement requirement;
  public TaskList()
  {
    this.tasks = new ArrayList<>();
  }
  // Question: Is the line below correct? //
  public void setRequirement(Requirement requirement){
    this.requirement=requirement;
  }
  public Requirement getRequirement()
  {
    return requirement;
  }
  //
  public Task getTaskByIndex(int index){return tasks.get(index);}
  public Task getTaskByID(int ID){
    for (int i = 0; i < tasks.size(); i++)
    {
      if(tasks.get(i).getTaskID()==ID)return tasks.get(i);
    }
    return null;
  }
  public int getNumberOfTasks(){return tasks.size();}
  public void addTask(Task task){tasks.add(task);}
  public Task removeTask(int ID){
    for (int i = 0; i < tasks.size(); i++)
    {
      if(tasks.get(i).getTaskID()==ID)return tasks.remove(ID);
    }
    return null;
    }
  public void removeTask(Task task)
  {
    tasks.remove(task);
  }
  public String getTaskNameByID(int ID){return getTaskByID(ID).getName();}
  public String getTaskDescByID(int ID){return getTaskByID(ID).getDescription();}
  public String getTaskStatusByID(int ID){return getTaskByID(ID).getTaskStatus();}
  public Time getTaskEstimateTimeByID(int ID){return getTaskByID(ID).getEstimateTime();}
  public RegisterTime getTaskSpentTimeByID(int ID){return getTaskByID(ID).getTimeSpent();}
  public int getTaskTeamMemberIDByID(int ID){return getTaskByID(ID).getTeamMemberID();}
  public void editTaskNameByID(int ID, String name){getTaskByID(ID).setName(name);}
  public void editTaskDescByID(int ID, String description){getTaskByID(ID).setDescription(description);}
  public void editTaskStatusByID(int ID, String status){getTaskByID(ID).setStatus(status);}
  public void editTaskEstimateTimeByID(int ID, Time estimateTime){getTaskByID(ID).setEstimateTime(estimateTime);}
  public void editTaskSpentTimeByID(int ID, RegisterTime registerTime){getTaskByID(ID).setSpentTime(registerTime);}
  public void assignTM(int ID, int teamMemberID){
    getTaskByID(ID).setTeamMemberID(teamMemberID);
  }
  public void removeTaskTeamMemberByID(int ID){getTaskByID(ID).removeTeamMember();}
  public boolean isTaskAvailable(int ID){return getTaskByID(ID).isAvailable();}
  public String getAvailableTasks(){
    String returnString = "";
    for (int i = 0; i < tasks.size(); i++)
    {
      if(tasks.get(i).isAvailable())
      returnString += i + ") " + tasks.get(i) + "\n";
    }
    return returnString;
  }
  public String toString()
  {
    int counter=1;
    String returnString="";
    for(Task task : tasks)
    {
      returnString += counter + ") " + task + "\n";
      counter++;
    }
    return returnString;
  }
}
