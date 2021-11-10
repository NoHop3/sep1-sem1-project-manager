package model;

public class Requirement
{
  private int ID;
  private String name;
  private String status;
  private String description;
  private MyDate deadline;
  private TaskList tasks = new TaskList();
  private Time estimateTime = new Time(0);
  private RegisterTime spentTime = new RegisterTime(new Time(0));
  private Team team = new Team();
  public Requirement(){
    this.ID = -1;
    setName("No name");
    setDescription("No desc");
    setStatus("Waiting");
    setDeadline(new MyDate());
  }
  public Requirement(int ID, String name){
    this.ID = ID;
    setName(name);
    this.deadline = new MyDate();
    this.status="Waiting";
    this.description="No desc";
  }
  public Requirement(int ID, String name, MyDate deadline){
    this.ID = ID;
    setName(name);
    setDeadline(deadline);
    setEstimateTime(new Time(0));
    this.status="Waiting";
    this.description="No desc";
  }
  public Requirement(int ID, String name, MyDate deadline, String description, Time estimateTime, TaskList tasks){
    this(ID,name, deadline, estimateTime, tasks);
    setDescription(description);
    setStatus("Started");
  }
  public Requirement(int ID, String name, MyDate deadline, Time estimateTime){
    this(ID, name, deadline);
    setEstimateTime(estimateTime);
    this.description="No desc";
  }
  public Requirement(int ID, String name, MyDate deadline, Time estimateTime, TaskList tasks){
    this(ID, name, deadline, estimateTime);
    this.description="No desc";
    this.status = "Waiting";
    setTasks(tasks);
  }
  public Requirement(int ID, String name, MyDate deadline, Time estimateTime, Team team, TaskList tasks){
    this(ID,name, deadline, estimateTime, tasks);
    this.status="Started";
    this.description="No desc";
    setResponsibleTeam(team);
  }
  public Requirement(int ID, String name, MyDate deadline, String description, Time estimateTime, Team team, TaskList tasks){
    this(ID,name, deadline, estimateTime, team, tasks);
    setStatus("Started");
    setDescription(description);
  }
  public void removeResponsibleTeam(){this.team=new Team();}
  public void removeTasks(){this.tasks=new TaskList();}
  public int getID()
  {
    return ID;
  }
  public Team getResponsibleTeam(){return team;}
  public String getName()
  {
    return name;
  }
  public TaskList getTasks()
  {
    return tasks;
  }
  public int getTasksNumber(){return tasks.getNumberOfTasks();}
  public String getStatus()
  {
    return status;
  }
  public String getDescription()
  {
    return description;
  }
  public MyDate getDeadline()
  {
    return deadline;
  }
  public Time getEstimateTime()
  {
    return estimateTime;
  }
  public RegisterTime getSpentTime()
  {
    return spentTime;
  }
  public void setStatus(String status)
  {
    if(status.equals("Started") || status.equals("Completed"))
    this.status = status;
    else this.status = "Waiting";
  }
  public void setDeadline(MyDate deadline)
  {
    this.deadline = deadline.copy();
  }
  public void setSpentTime(RegisterTime spentTime){
    if(spentTime==null)
    {
      this.spentTime = new RegisterTime(new Time(0));
    }
    else
    {
      this.spentTime = spentTime;
      if (this.spentTime.getTimeInSeconds() == this.getEstimateTime().getTimeInSeconds() && this.estimateTime.getTimeInSeconds()
          != 0)
        this.status = "Finished";
      else
        this.status = "Started";
    }
  }
  public void setName(String name){
  this.name = name;
}
  public void setDescription(String description){
    this.description = description;
  }
  public void setTasks(TaskList tasks){
    this.tasks = tasks;
  }
  public void setEstimateTime(Time estimateTime){
    this.estimateTime = estimateTime;
  }
  public void setResponsibleTeam(Team team){
    this.team = team;
  }
  public void addResponsibleTM(TeamMember teamMember){team.addTeamMember(teamMember);}
  public int getResponsibleTeamNumber(){return team.getNumberOfTeamMembers();}
  public String toString(){
    String returnString = "Name: " + getName();
    if (getDescription() != null)
      returnString += " Description: " + getDescription();
    returnString += " Status: " + getStatus();
    if (getSpentTime() != null)
      returnString += " Time spent: " + getSpentTime();
    if (getEstimateTime() != null)
      returnString += " Task's estimated time: " + getEstimateTime();
    if(getResponsibleTeam().getNumberOfTeamMembers()!=0)returnString+=" Team members assigned: " + getResponsibleTeam().getNumberOfTeamMembers();
    return returnString;
  }
}
