package model;

public class Project
{
  private String title;
  private String description;
  private Team team;
  private RequirementList requirements;
  private TaskList tasks;
  private int projectID;
  public Project(int projectID, String title){
    setTitle(title);
    this.projectID = projectID;
    setRequirements(new RequirementList());
    setTeam(new Team());
    setTasks(new TaskList());
    setDescription("No desc");
  }
  public Project(int projectID, String title, String description){
    setTitle(title);
    this.projectID = projectID;
    setRequirements(new RequirementList());
    setTeam(new Team());
    setTasks(new TaskList());
    setDescription(description);
  }
  public Project(int projectID, String title, String description, RequirementList requirements, Team team){
    this(projectID, title, requirements);
    setDescription(description);
    setTeam(team);
  }
  public Project(int projectID, String title,  String description, RequirementList requirements, Team team, TaskList tasks){
    this(projectID, title, requirements, team, tasks);
    setDescription(description);

  }
  public Project(int projectID, String title, RequirementList requirements, Team team, TaskList tasks){
    this(projectID, title, requirements, tasks);
    setTeam(team);
    setDescription("No desc");
  }
  public Project(int projectID, String title, RequirementList requirements){
    setTitle(title);
    this.projectID = projectID;
    setRequirements(requirements);
    setTeam(new Team());
    setTasks(new TaskList());
    setDescription("No desc");
  }
  public Project(int projectID, String title, RequirementList requirements, TaskList tasks){
    this(projectID, title, requirements);
    setTasks(tasks);
    setDescription("No desc");
  }
  public String getTitle()
  {
    return title;
  }
  public String getDescription()
  {
    return description;
  }
  public TaskList getTasks()
  {
    return tasks;
  }
  public int getProjectID()
  {
    return projectID;
  }
  public RequirementList getRequirements()
  {
    return requirements;
  }
  public Team getTeam()
  {
    return team;
  }
  public void setTitle(String title)
  {
    this.title = title;
  }
  public void setDescription(String description){
    this.description = description;
  }
  public void setTeam(Team team)
  {
    this.team = team;
  }
  public void setTasks(TaskList tasks)
  {
    this.tasks = tasks;
  }
  public void setRequirements(RequirementList requirements){
    this.requirements = requirements;
  }
  public String toString()
  {
    String returnString = "Title: " + getTitle();
    if(getDescription()!=null)returnString += " Description: " + getDescription();
    if(getTeam()!=null)returnString+=" Assigned team: " + getTeam().getNumberOfTeamMembers();
    if(getRequirements()!=null)returnString+=" Requirements: " + getRequirements().getNumberOfRequirements();
    if(getTasks()!=null)returnString+=" Tasks: " + getTasks().getNumberOfTasks();
    return returnString;
  }
}
