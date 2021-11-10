package model;

public interface ProjectModel
{
  //Projects//
  public ProjectList getProjectsList();
  public Project getProjectByID(int ID);
  public Project getProjectByIndex(int index);
  public int getNumberOfProjects();
  public String getProjectByTitle(String title);
  public void addProject(Project project);
  public Project removeProjectByTitle(String title);
  public void removeProjectByID(int ID);
  public void removeProject(Project project);
  public String getProjectNameByID(int ID);
  public String getProjectDescByID(int ID);
  public Requirement getProjectRequirementByID(int ID, int reqID);
  public TeamMember getProjectTeamMemberByID(int ID, int tmID);
  public Task getProjectTaskByID(int ID, int taskID);
  public void editProjectNameByID(int ID, String title);
  public void editProjectDescByID(int ID, String description);
  //Requirements//
  public void setProject(Project project);
  public Project getProject();
  public TaskList getReqTaskListByID(int ID);
  public void removeReqTaskListByID(int ID);
  public int getReqTaskNumber(int ID);
  public RequirementList getRequirementsList();
  public Requirement getReqByID(int ID);
  public Requirement getReqByIndex(int index);
  public int getNumberOfRequirements();
  public void addRequirement(Requirement requirement);
  public void removeRequirement(Requirement requirement);
  public void removeRequirement(int ID);
  public String getReqNameByID(int ID);
  public String getReqDescByID(int ID);
  public MyDate getReqDeadlineByID(int ID);
  public String getReqStatusByID(int ID);
  public Time getReqEstimateTimeByID(int ID);
  public RegisterTime getReqSpentTimeByID(int ID);
  public void editReqNameByID(int ID, String name);
  public void editReqDescByID(int ID, String description);
  public void editReqDeadlineByID(int ID, MyDate deadline);
  public void editReqStatusByID(int ID, String status);
  public void editReqEstimateTimeByID(int ID, Time estimateTime);
  public void editReqSpentTimeByID(int ID, RegisterTime registerTime);
  public Team getReqTeam(int ID);
  public int getReqTeamNumber(int ID);
  public void editReqTeamByID(int ID, Team team);
  public void addResponsibleTeamMember(int ID, TeamMember teamMember);
  public void addTaskOnReqID(int ID, Task task);
  public Task getTaskOnReqID(int ID, int taskID);
  public Task removeTaskOnReqID(int ID, int taskID);
  public void removeTaskOnReqID(int ID, Task task);
  public void removeReqTeam(int ID);
  //Team//
  public void setTeamProject(Project project);
  public Project getTeamProject();
  public boolean isTeamMateAvailable(int ID);
  public Team getTeamList();
  public TeamMember getTeamMemberByID(int ID);
  public TeamMember getTeamMemberByIndex(int index);
  public TeamMember getTeamMemberByFullName(String fullName);
  public int getNumberOfTeamMembers();
  public void addTeamMember(TeamMember teamMember);
  public void removeTeamMember(int ID);
  public void removeTeamMember(TeamMember teamMember);
  public String getTeamMemberNameByID(int ID);
  public RegisterTime getTeamMemberSpentTimeByID(int ID);
  public String getTeamMemberRoleByID(int ID);
  public void editTeamMemberNameByID(int ID, String name);
  public void editTeamSpentTimeByID(int ID, RegisterTime registerTime);
  public void removeTeamMemberRoleByID(int ID);
  public void setTeamMemberRoleByID(int ID, String role);

  //Tasks//
  public void setTasksRequirement(Requirement requirement);
  public Requirement getTasksRequirement();


  public TaskList getTaskList();
  public Task getTaskByIndex(int index);
  public Task getTaskByID(int ID);
  public int getNumberOfTasks();
  public void addTask(Task task);
  public void removeTask(int ID);
  public void removeTask(Task task);
  public String getTaskNameByID(int ID);
  public String getTaskDescByID(int ID);
  public String getTaskStatusByID(int ID);
  public Time getTaskEstimateTimeByID(int ID);
  public RegisterTime getTaskSpentTimeByID(int ID);
  public int getTaskTeamMemberByID(int ID);
  public void editTaskNameByID(int ID, String name);
  public void editTaskDescByID(int ID, String description);
  public void editTaskStatusByID(int ID, String status);
  public void editTaskEstimateTimeByID(int ID, Time estimateTime);
  public void editTaskSpentTimeByID(int ID, RegisterTime registerTime);
  public boolean isTaskAvailable(int ID);
  public void assignTM(int ID, int teamMemberID);
  public void removeTaskTeamMemberByID(int ID);
  public String getAvailableTasks();
  public String getTasks();
  public String getRequirements();
  public String getTeam();
  public String getProjects();
}
