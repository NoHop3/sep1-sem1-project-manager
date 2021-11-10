package model;

import java.util.ArrayList;

public class ProjectList
{
  private ArrayList<Project> projects;
  public ProjectList()
  {
    this.projects = new ArrayList<>();
  }
  public Project getProjectByID(int ID){
    for (int i = 0; i < projects.size(); i++)
    {
      if(projects.get(i).getProjectID()==ID)return projects.get(i);
    }
    return null;
  }
  public Project getProjectByIndex(int index){return projects.get(index);}
  public int getAllProjects(){return projects.size();}
  public String getProjectByTitle(String title)
  {
    for (int i = 0; i < projects.size(); i++)
    {
      if(projects.get(i).getTitle().equals(title))return projects.get(i).getTitle();
    }
    return  null;
  }
  public void addProject(Project project){projects.add(project);}
  public Project removeProjectByTitle(String title){
    for (int i = 0; i < projects.size(); i++)
      if(projects.get(i).getTitle().equals(title))return projects.remove(i);
    return null;
  }
  public void removeProjectByID(int ID){
    for (int i = 0; i < projects.size(); i++)
    if(projects.get(i).getProjectID()==ID)projects.remove(projects.get(i));
  }
  public void removeProject(Project project){
    projects.remove(project);
  }
  public String getProjectNameByID(int ID){return projects.get(ID).getTitle();}
  public String getProjectDescByID(int ID){return projects.get(ID).getDescription();}
  public Requirement getProjectRequirementByID(int ID, int reqID){return projects.get(ID).getRequirements().getReqByID(reqID);}
  public TeamMember getProjectTeamMemberByID(int ID, int tmID){return projects.get(ID).getTeam().getTeamMemberByID(tmID);}
  public Task getProjectTaskByID(int ID, int taskID){return projects.get(ID).getTasks().getTaskByID(taskID);}

  public void editProjectNameByID(int ID, String title){projects.get(ID).setTitle(title);}
  public void editProjectDescByID(int ID, String description){projects.get(ID).setDescription(description);}

  public String toString(){
    int counter=1;
    String returnString="";
    for(Project project : projects)
    {
      returnString += counter + ") " + project + "\n";
      counter++;
    }
    return returnString;
  }
}
