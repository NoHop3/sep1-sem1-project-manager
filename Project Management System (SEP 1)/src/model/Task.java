package model;

public class Task
{
  private int taskID=-1;
  private String name;
  private String taskStatus;
  private String taskDescription;
  private RegisterTime taskTimeSpent = new RegisterTime(new Time(0));
  private Time estimateTime = new Time(0);
  private int teamMemberID=-1;
  public Task(){
    this.name = "No Name";
    this.taskDescription = "No desc";
    this.taskStatus = "Waiting";
  }
  public Task(int taskID, String name){
    setName(name);
    setDescription("No name");
    this.taskID=taskID;
    this.taskStatus = "Waiting";
  }
  public Task(int taskID, String name, String taskDescription, Time estimateTime, int teamMemberID){
    this(taskID, name, taskDescription, estimateTime);
    setStatus("Started");
    this.teamMemberID=teamMemberID;
  }
  public Task(int taskID, String name, String taskDescription){
    this.taskID = taskID;
    setName(name);
    setDescription(taskDescription);
    setStatus("Waiting");
  }
  public Task(int taskID, String name, String taskDescription, Time estimateTime){
      this(taskID,name, taskDescription);
      setEstimateTime(estimateTime);
      setStatus("Waiting");
  }
  public Task(int taskID, String name, Time estimateTime){
    setName(name);
    setEstimateTime(estimateTime);
    this.taskID=taskID;
    this.taskDescription = "No Desc";
    this.taskStatus = "Waiting";
  }
  public Task(int taskID, String name, Time estimateTime, int teamMemberID){
    this(taskID,name, estimateTime);
    this.teamMemberID = teamMemberID;
    this.taskDescription = "No Desc";
    this.taskStatus = "Started";
  }
  public int getTaskID()
  {
    return taskID;
  }
  public String getName(){return name;}
  public String getTaskStatus()
  {
    return taskStatus;
  }
  public RegisterTime getTimeSpent()
  {
    return taskTimeSpent;
  }
  public String getDescription()
  {
    return taskDescription;
  }
  public Time getEstimateTime()
  {
    return estimateTime;
  }
  public void setSpentTime(RegisterTime taskTimeSpent){
    this.taskTimeSpent = taskTimeSpent;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public void setDescription(String taskDescription){
    this.taskDescription = taskDescription;
  }
  public void setStatus(String taskStatus){
    try{
      if(taskStatus.equals("Waiting") || taskStatus.equals("Started") || taskStatus.equals("Finished"))
        this.taskStatus = taskStatus;
      else throw new Exception("Not a string");
    }
    catch (Exception e)
    {
      System.out.println("Please input STRING value{\"Waiting\",\"Started\" or \"Finished\"}");
    }
  }
  public void setEstimateTime(Time estimateTime){
    this.estimateTime = estimateTime;
  }

  public int getTeamMemberID()
  {
    return teamMemberID;
  }

  public void setTeamMemberID(int teamMemberID)
  {
    this.teamMemberID = teamMemberID;
  }

  public boolean isAvailable()
  {
    return teamMemberID==-1;
  }
  public void removeTeamMember(){
    this.teamMemberID = -1;
    this.taskStatus = "Waiting";
  }
  public String toString(){
    String returnString = "Name: " + getName();
    if(getDescription()!=null)returnString += " Description: " + getDescription();
    returnString+=" Status: " + getTaskStatus();
    if(getTimeSpent()!=null)returnString+=" Time spent: " + getTimeSpent();
    if(getEstimateTime()!=null)returnString+=" Task's estimated time: " + getEstimateTime();
    if(getTeamMemberID()!=-1)returnString+=" Team member assigned: " + getTeamMemberID();
    return returnString;
  }
}
