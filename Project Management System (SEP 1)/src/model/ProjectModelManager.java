package model;

public class ProjectModelManager implements ProjectModel
{
  private ProjectList projects;
  private Team team;
  private RequirementList requirements;
  private TaskList tasks;
  public ProjectModelManager(){
    projects = new ProjectList();
    team = new Team();
    requirements = new RequirementList();
    tasks = new TaskList();
    sampleData();
  }
  public void sampleData(){
    Time estTime1 = new Time(23123);
    Time estTime2 = new Time(12321);
    Time estTime3 = new Time(3123);
    Time estTime4 = new Time(223);
    Time estTime5 = new Time(23);
    Time estTime6 = new Time(231223);
    Time estTime7 = new Time(2312213);
    MyDate deadline1 = new MyDate(23,12,2000);
    MyDate deadline2 = new MyDate(23,12,2001);
    MyDate deadline3 = new MyDate(23,12,2002);
    MyDate deadline4 = new MyDate(23,12,2003);
    MyDate deadline5 = new MyDate(23,12,2004);
    MyDate deadline6 = new MyDate(23,12,2005);
    MyDate deadline7 = new MyDate();
    Task task1 = new Task(1, "Task 1", estTime1);
    Task task2 = new Task(3, "Task 2", estTime2);
    Task task3 = new Task(5, "Task 3", estTime3);
    Task task4 = new Task(7, "Task 4", estTime4);
    Task task5 = new Task(9, "Task 5", estTime5);
    tasks.addTask(task1);
    tasks.addTask(task2);
    tasks.addTask(task3);
    tasks.addTask(task4);
    tasks.addTask(task5);
    TeamMember teamMember1 = new TeamMember(2, "Stefan", "Georgiev", "Manager" );
    TeamMember teamMember2 = new TeamMember(4, "Florin", "Plaesu", "Ideas machine");
    TeamMember teamMember3 = new TeamMember(6, "Alexandru", "Ionescu", "Programming guru");
    TeamMember teamMember4 = new TeamMember(8, "Pierantonio", "Berto", "Snacks bringer");
    TeamMember teamMember5 = new TeamMember(10, "Cao", "Xuanyuan", "SCRUM Master");
    TeamMember teamMember6 = new TeamMember(12, "Max", "Gerald", "Code addict");
    TeamMember teamMember7 = new TeamMember(20, "William", "Phips", "Designer master");
    Task task6 = new Task(60, "Task 6", estTime6, teamMember6.getTeamMemberID());
    Task task7 = new Task(79, "Task 7","Description 1", estTime7, teamMember7.getTeamMemberID());
    tasks.addTask(task6);
    tasks.addTask(task7);
    team.addTeamMember(teamMember1);
    team.addTeamMember(teamMember2);
    team.addTeamMember(teamMember3);
    team.addTeamMember(teamMember4);
    team.addTeamMember(teamMember5);
    team.addTeamMember(teamMember6);
    team.addTeamMember(teamMember7);
    Requirement requirement1 = new Requirement(1, "Requirement 1", deadline1);
    Requirement requirement2 = new Requirement(2, "Requirement 2", deadline2, estTime5);
    Requirement requirement3 = new Requirement(3, "Requirement 3", deadline3, estTime6, tasks);
    Requirement requirement5 = new Requirement(5, "Requirement 4", deadline5, estTime4, tasks);
    Requirement requirement6 = new Requirement(8, "Requirement 5", deadline6, estTime3, team, tasks);
    Requirement requirement7 = new Requirement(70, "Requirement 6", deadline7);
    requirements.addRequirement(requirement1);
    requirements.addRequirement(requirement2);
    requirements.addRequirement(requirement3);
    requirements.addRequirement(requirement5);
    requirements.addRequirement(requirement6);
    requirements.addRequirement(requirement7);
    Project project1 = new Project(1,"Project 1", "Description 1", requirements, team, tasks);
    Project project2 = new Project(12, "Project 2", requirements);
    Project project3 = new Project(8, "Project 3", "Description 3");
    projects.addProject(project1);
    projects.addProject(project2);
    projects.addProject(project3);
  }


  // Projects //

  public ProjectList getProjectsList()
  {
    return projects;
  }
  public Project getProjectByID(int ID)
  {
    return projects.getProjectByID(ID);
  }
  public Project getProjectByIndex(int index){return projects.getProjectByIndex(index);}
  public String getProjectByTitle(String title){
    return projects.getProjectByTitle(title);
  }
  public void removeProject(Project project){
    projects.removeProject(project);
  }
  public int getNumberOfProjects()
  {
    return projects.getAllProjects();
  }
  public void addProject(Project project)
  {
    projects.addProject(project);
  }
  public Project removeProjectByTitle(String title){
    return projects.removeProjectByTitle(title);
  }
  public void removeProjectByID(int ID)
  {
    projects.removeProjectByID(ID);
  }
  public String getProjectNameByID(int ID){
    return projects.getProjectNameByID(ID);
  }
  public String getProjectDescByID(int ID){
    return projects.getProjectDescByID(ID);
  }
  public Requirement getProjectRequirementByID(int ID, int reqID){
    return projects.getProjectRequirementByID(ID, reqID);
  }
  public TeamMember getProjectTeamMemberByID(int ID, int tmID){
    return projects.getProjectTeamMemberByID(ID, tmID);
  }
  public Task getProjectTaskByID(int ID, int taskID){
    return projects.getProjectTaskByID(ID, taskID);
  }
  public void editProjectNameByID(int ID, String title){
    projects.editProjectNameByID(ID, title);
  }
  public void editProjectDescByID(int ID, String description){
    projects.editProjectDescByID(ID, description);
  }

  // Requirements //

  public void setProject(Project project){requirements.setProject(project);}
  public Project getProject()
  {
    return requirements.getProject();
  }
  public TaskList getReqTaskListByID(int ID){return requirements.getReqTaskListByID(ID);}
  public void removeReqTaskListByID(int ID){requirements.removeReqTaskListByID(ID);}
  public int getReqTaskNumber(int ID){
    return requirements.getReqTaskNumberByID(ID);
  }
  public Requirement getReqByID(int ID)
  {
    return requirements.getReqByID(ID);
  }
  public Requirement getReqByIndex(int index){return requirements.getReqByIndex(index);}
  public int getNumberOfRequirements(){
    return requirements.getNumberOfRequirements();
  }
  public RequirementList getRequirementsList()
  {
    return requirements;
  }
  public void addRequirement(Requirement requirement){
    requirements.addRequirement(requirement);
  }
  public void removeRequirement(Requirement requirement){
    requirements.removeRequirement(requirement);
  }
  public void removeRequirement(int ID){
    requirements.removeRequirement(getReqByID(ID));
  }
  public String getReqNameByID(int ID){
    return requirements.getReqNameByID(ID);
  }
  public String getReqDescByID(int ID){
    return requirements.getReqDescByID(ID);
  }
  public MyDate getReqDeadlineByID(int ID){
    return requirements.getReqDeadlineByID(ID);
  }
  public String getReqStatusByID(int ID){
    return requirements.getReqStatusByID(ID);
  }
  public Time getReqEstimateTimeByID(int ID){
    return requirements.getReqEstimateTimeByID(ID);
  }
  public RegisterTime getReqSpentTimeByID(int ID){
    return requirements.getReqSpentTimeByID(ID);
  }
  public void editReqNameByID(int ID, String name){
    requirements.editReqNameByID(ID, name);
  }
  public void editReqDescByID(int ID, String description){
    requirements.editReqDescByID(ID, description);
  }
  public void editReqDeadlineByID(int ID, MyDate deadline){
    requirements.editReqDeadlineByID(ID, deadline);
  }
  public void editReqStatusByID(int ID, String status){
    requirements.editReqStatusByID(ID, status);
  }
  public void editReqEstimateTimeByID(int ID, Time estimateTime){
    requirements.editReqEstimateTimeByID(ID, estimateTime);
  }
  public void editReqSpentTimeByID(int ID, RegisterTime registerTime){
    requirements.editReqSpentTimeByID(ID, registerTime);
  }
  public Team getReqTeam(int ID)
  {
    return requirements.getReqTeam(ID);
  }
  public int getReqTeamNumber(int ID){
    return requirements.getReqTeamNumber(ID);
  }
  public void editReqTeamByID(int ID, Team team){
    requirements.editReqTeamByID(ID, team);
    for (int i = 0; i < team.getNumberOfTeamMembers(); i++)
    {
      team.getTeamMemberByIndex(i).occupyTM();
    }
  }
  public void addResponsibleTeamMember(int ID, TeamMember teamMember){requirements.addResponsibleTeamMember(ID, teamMember);}
  public void addTaskOnReqID(int ID, Task task){
    requirements.addTaskOnReqID(ID, task);
  }
  public Task getTaskOnReqID(int ID, int taskID){
    return requirements.getTaskOnReqID(ID, taskID);
  }
  public Task removeTaskOnReqID(int ID, int taskID){
    return requirements.removeTaskOnReqID(ID, taskID);
  }
  public void removeTaskOnReqID(int ID, Task task){
    requirements.removeTaskOnReqID(ID, task);
  }
  public void removeReqTeam(int ID){
    for (int i = 0; i < requirements.getReqByID(ID).getResponsibleTeam().getNumberOfTeamMembers(); i++)
    {
      requirements.getReqByID(ID).getResponsibleTeam().getTeamMemberByIndex(i).reliveTM();
    }
    requirements.removeReqTeam(ID);
  }

  //Team//

  public void setTeamProject(Project project)
  {
    team.setProject(project);
  }
  public Project getTeamProject()
  {
    return team.getProject();
  }
  public boolean isTeamMateAvailable(int ID){
    return team.getTeamMemberByID(ID).isAvailable();}
  public Team getTeamList()
  {
    return team;
  }
  public TeamMember getTeamMemberByID(int ID){
    return team.getTeamMemberByID(ID);
  }
  public TeamMember getTeamMemberByIndex(int index){return team.getTeamMemberByIndex(index);}
  public TeamMember getTeamMemberByFullName(String fullName){
    return team.getTeamMemberByFullName(fullName);
  }
  public int getNumberOfTeamMembers()
  {
    return team.getNumberOfTeamMembers();
  }
  public void addTeamMember(TeamMember teamMember){
    team.addTeamMember(teamMember);
  }
  public void removeTeamMember(int ID){
    team.removeTeamMember(getTeamMemberByID(ID));
  }
  public void removeTeamMember(TeamMember teamMember){
    team.removeTeamMember(teamMember);
  }
  public String getTeamMemberNameByID(int ID){
    return team.getTeamMemberNameByID(ID);
  }
  public RegisterTime getTeamMemberSpentTimeByID(int ID){
    return team.getTeamMemberSpentTimeByID(ID);
  }
  public String getTeamMemberRoleByID(int ID){
    return team.getTeamMemberRoleByID(ID);
  }
  public void editTeamMemberNameByID(int ID, String name){
    team.editTeamMemberNameByID(ID, name);
  }
  public void editTeamSpentTimeByID(int ID, RegisterTime registerTime){
    team.editTeamSpentTimeByID(ID, registerTime);
  }
  public void removeTeamMemberRoleByID(int ID){
    team.removeTeamMemberRoleByID(ID);
  }
  public void setTeamMemberRoleByID(int ID, String role){
    team.setTeamMemberRoleByID(ID, role);
  }

  // Tasks //

  public void setTasksRequirement(Requirement requirement){
    tasks.setRequirement(requirement);
  }
  public Requirement getTasksRequirement()
  {
    return tasks.getRequirement();
  }
  public TaskList getTaskList()
  {
    return tasks;
  }
  public Task getTaskByIndex(int index)
  {
    return tasks.getTaskByIndex(index);
  }
  public Task getTaskByID(int ID){return tasks.getTaskByID(ID);}
  public int getNumberOfTasks()
  {
    return tasks.getNumberOfTasks();
  }
  public void addTask(Task task)
  {
    tasks.addTask(task);
  }
  public void removeTask(int ID)
  {
    tasks.removeTask(getTaskByID(ID));
  }
  public void removeTask(Task task){
    tasks.removeTask(task);
  }
  public String getTaskNameByID(int ID){
    return tasks.getTaskNameByID(ID);
  }
  public String getTaskDescByID(int ID){
    return tasks.getTaskDescByID(ID);
  }
  public String getTaskStatusByID(int ID){
    return tasks.getTaskStatusByID(ID);
  }
  public Time getTaskEstimateTimeByID(int ID){
    return tasks.getTaskEstimateTimeByID(ID);
  }
  public RegisterTime getTaskSpentTimeByID(int ID){
    return tasks.getTaskSpentTimeByID(ID);
  }
  public int getTaskTeamMemberByID(int ID){
    return tasks.getTaskTeamMemberIDByID(ID);
  }
  public void editTaskNameByID(int ID, String name){
    tasks.editTaskNameByID(ID, name);
  }
  public void editTaskDescByID(int ID, String description){
    tasks.editTaskDescByID(ID, description);
  }
  public void editTaskStatusByID(int ID, String status){
    tasks.editTaskStatusByID(ID, status);
  }
  public void editTaskEstimateTimeByID(int ID, Time estimateTime){
    tasks.editTaskEstimateTimeByID(ID, estimateTime);
  }
  public void editTaskSpentTimeByID(int ID, RegisterTime registerTime){
    tasks.editTaskSpentTimeByID(ID, registerTime);
  }
  public boolean isTaskAvailable(int ID){
    return tasks.isTaskAvailable(ID);
  }
  public void assignTM(int ID, int teamMemberID){
    tasks.assignTM(ID, teamMemberID);
    team.getTeamMemberByID(teamMemberID).occupyTM();
  }
  public void removeTaskTeamMemberByID(int ID){
    team.getTeamMemberByID(tasks.getTaskByID(ID).getTeamMemberID()).reliveTM();
    tasks.removeTaskTeamMemberByID(ID);
  }
  public String getAvailableTasks(){
    return tasks.getAvailableTasks();
  }

  //To string//

  public String getTasks(){
    return tasks.toString();
  }
  public String getRequirements(){
    return requirements.toString();
  }
  public String getTeam(){
    return team.toString();
  }
  public String getProjects(){
    return projects.toString();
  }
}
