package model;

import java.util.ArrayList;

public class RequirementList
{
  private ArrayList<Requirement> requirements;
  private Project project;
  public RequirementList()
  {
    this.requirements = new ArrayList<>();
  }
  public Requirement getReqByID(int ID){
    for (int i = 0; i < getNumberOfRequirements(); i++)
    {
      if(requirements.get(i).getID()==ID)return requirements.get(i);
    }
    return null;
  }
  public Requirement getReqByIndex(int index){return requirements.get(index);}
  public int getNumberOfRequirements(){return requirements.size();}
  public void setProject(Project project){this.project = project;}
  public Project getProject()
  {
    return project;
  }
  public TaskList getReqTaskListByID(int ID){return getReqByID(ID).getTasks();}
  public void removeReqTaskListByID(int ID){ getReqByID(ID).removeTasks();}
  public int getReqTaskNumberByID(int ID){return getReqByID(ID).getTasksNumber();}
  public void addRequirement(Requirement requirement){
    requirements.add(requirement);
  }
  public void removeRequirement(Requirement requirement){
    requirements.remove(requirement);
  }
  public Requirement removeRequirement(int ID){
    return requirements.remove(ID);
  }
  public String getReqNameByID(int ID){return getReqByID(ID).getName();}
  public String getReqDescByID(int ID){return getReqByID(ID).getDescription();}
  public MyDate getReqDeadlineByID(int ID){return getReqByID(ID).getDeadline();}
  public String getReqStatusByID(int ID){return getReqByID(ID).getStatus();}
  public Time getReqEstimateTimeByID(int ID){return getReqByID(ID).getEstimateTime();}
  public RegisterTime getReqSpentTimeByID(int ID){return getReqByID(ID).getSpentTime();}
  public Team getReqTeam(int ID){return  getReqByID(ID).getResponsibleTeam();}
  public int getReqTeamNumber(int ID){return getReqByID(ID).getResponsibleTeamNumber();}
  public void editReqNameByID(int ID, String name){getReqByID(ID).setName(name);}
  public void editReqDescByID(int ID, String description){getReqByID(ID).setDescription(description);}
  public void editReqDeadlineByID(int ID, MyDate deadline){getReqByID(ID).setDeadline(deadline);}
  public void editReqStatusByID(int ID, String status){getReqByID(ID).setStatus(status);}
  public void editReqEstimateTimeByID(int ID, Time estimateTime){getReqByID(ID).setEstimateTime(estimateTime);}
  public void editReqSpentTimeByID(int ID, RegisterTime registerTime){getReqByID(ID).setSpentTime(registerTime);}
  public void editReqTeamByID(int ID, Team team){getReqByID(ID).setResponsibleTeam(team);}
  public void addResponsibleTeamMember(int ID, TeamMember teamMember){getReqByID(ID).addResponsibleTM(teamMember);}
  public void addTaskOnReqID(int ID, Task task){
    getReqByID(ID).getTasks().addTask(task);
  }
  public Task getTaskOnReqID(int ID, int taskID){return getReqByID(ID).getTasks()
      .getTaskByID(taskID);}
  public Task removeTaskOnReqID(int ID, int taskID){return getReqByID(ID).getTasks().removeTask(taskID);}
  public void removeTaskOnReqID(int ID, Task task){getReqByID(ID).getTasks().removeTask(task);}
  public void removeReqTeam(int ID){getReqByID(ID).removeResponsibleTeam();}
  public String toString()
  {
    int counter=1;
    String returnString="";
    for(Requirement requirement : requirements)
    {
      returnString += counter + ") " + requirement + "\n";
      counter++;
    }
    return returnString;
  }
}
