package model;

public class TeamMember
{
  private int ID;
  private String firstName;
  private String lastName;
  private String role;
  private boolean isAvailable;
  private RegisterTime registerTime = new RegisterTime(new Time(0));
  public TeamMember(int ID, String firstName, String lastName){
    this.ID = ID;
    setFirstName(firstName);
    setLastName(lastName);
    this.role = "No Role";
  }
  public TeamMember(int ID, String firstName, String lastName, String role){
    this(ID, firstName, lastName);
    setRole(role);
  }
  public int getTeamMemberID()
{
  return ID;
}
  public void setFullName(String fullName){
    int i=0;
    while(fullName.charAt(i)!=' ')
    {
      i++;
    }
    this.firstName = fullName.substring(0,i);
    this.lastName = fullName.substring(i);
  }
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }
  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }
  public String getFullName(){return this.firstName+" "+this.lastName;}
  public String getFirstName()
  {
    return firstName;
  }
  public String getLastName()
  {
    return lastName;
  }
  public boolean isAvailable()
  {
    return isAvailable;
  }
  public void occupyTM(){this.isAvailable = false;}
  public void reliveTM(){this.isAvailable = true;}
  public RegisterTime getRegisterTime()
  {
    return registerTime;
  }
  public void setRegisterTime(RegisterTime registerTime){
    this.registerTime = registerTime;
  }
  public void setRole(String role){this.role=role;}
  public void removeRole(){this.role="No Role";}
  public String getRole(){return role;}
  public String toString() {
  String returnString="Name: " + getFullName();
  if(getRole()!=null)returnString+=" Role: " + getRole();
  return returnString;}
}
