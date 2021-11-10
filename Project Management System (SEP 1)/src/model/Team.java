package model;

import java.util.ArrayList;

public class Team
{
  private ArrayList<TeamMember> team;
  private RegisterTime regTime;
  private Project project;
  public Team(){
    this.team = new ArrayList<>();
    this.regTime=new RegisterTime(new Time(0));
  }
  public void setProject(Project project)
  {
    this.project = project;
  }
  public Project getProject()
  {
    return project;
  }

  public TeamMember getTeamMemberByID(int ID){
    for (int i = 0; i < team.size(); i++)
    {
      if(team.get(i).getTeamMemberID()==ID)return team.get(i);
    }
    return null;
  }
  public boolean isAvailableByID(int ID){return getTeamMemberByID(ID).isAvailable();}
  public TeamMember getTeamMemberByIndex(int index){return team.get(index);}
  public TeamMember getTeamMemberByFullName(String fullName){
    for (int i = 0; i < team.size(); i++)
    {
      if(team.get(i).getFullName().equals(fullName))return team.get(i);
    }
    return null;
  }
  public RegisterTime getRegTime()
  {
    return regTime;
  }
  public int getNumberOfTeamMembers(){
    return team.size();
  }
  public void addTeamMember(TeamMember teamMember){
    team.add(teamMember);
  }
  public TeamMember removeTeamMember(int ID){return team.remove(ID);}
  public void removeTeamMember(TeamMember teamMember){team.remove(teamMember);}
  public String getTeamMemberNameByID(int ID){return getTeamMemberByID(ID).getFullName();}
  public RegisterTime getTeamMemberSpentTimeByID(int ID){return getTeamMemberByID(ID).getRegisterTime();}
  public String getTeamMemberRoleByID(int ID){return getTeamMemberByID(ID).getRole();}
  public void editTeamMemberNameByID(int ID, String name){getTeamMemberByID(ID).setFullName(name);}
  public void editTeamSpentTimeByID(int ID, RegisterTime registerTime){getTeamMemberByID(ID).setRegisterTime(registerTime);}
  public void removeTeamMemberRoleByID(int ID){getTeamMemberByID(ID).removeRole();}
  public void setTeamMemberRoleByID(int ID, String role){getTeamMemberByID(ID).setRole(role);}
  public void setRegTime(RegisterTime regTime)
  {
    this.regTime = regTime;
  }
  public String toString(){
    int counter=1;
    String returnString="";
    for(TeamMember teamMember : team)
    {
      returnString += counter + ") " + teamMember + "\n";
      counter++;
    }
    return returnString;
  }
}
