package model;

public class RegisterTime
{
  private Time time;
  public RegisterTime(Time time)
  {
    this.time = time;
  }
  public RegisterTime()
  {
    this.time = new Time(0);
  }
  public int getMinutes(){return time.getMinute();}
  public int getHours(){return time.getHour();}
  public Time getTime()
  {
    return time;
  }
  public void setMinutes(int minutes)
  {
    this.time.setMinute(minutes);
  }
  public void setHours(int hours)
  {
    this.time.setHour(hours);
  }
  public int getTimeInSeconds(){return getHours()*3600 + getMinutes()*60;}
  public boolean equals(Object obj){
    if(!(obj instanceof RegisterTime))return false;
    RegisterTime another = (RegisterTime) obj;
    return this.getTimeInSeconds()==another.getTimeInSeconds();
  }
  public void validateTime(int timeInSeconds){
    int hours;
    int minutes;
    hours = timeInSeconds/3600; //13 chasa//
    minutes = timeInSeconds%3600/60; //53 min//
    setHours(hours);
    setMinutes(minutes);
  }
  public String toString(){
    String returnString = "";
    validateTime(getTimeInSeconds());
    returnString = getHours() + ":" + getMinutes();
    return returnString;
  }
}
