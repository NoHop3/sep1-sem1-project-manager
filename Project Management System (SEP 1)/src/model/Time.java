package model;

public class Time
{
  private int hour;
  private int minute;
  public Time(int hour, int minute)
  {
    set(hour, minute);
  }
  public Time(int timeInSeconds)
  {
    set(timeInSeconds);
  }
  public void setMinute(int minute)
  {
    this.minute = minute;
  }
  public void setHour(int hour)
  {
    this.hour = hour;
  }
  public void set(int timeInSeconds){
    if (timeInSeconds < 0){timeInSeconds = 0;}
    this.hour = timeInSeconds / 3600;
    this.minute = (timeInSeconds % 3600) / 60;
  }
  public void set(int h, int m)
  {
    set(getTimeInSeconds(h, m));
  }
  public int getHour(){return hour;}
  public int getMinute(){return minute;}
  public int getTimeInSeconds(){return hour*3600 + minute*60;}
  public int getTimeInSeconds(int h, int m){return h*3600 + m*60;}
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Time))return false;
    Time another = (Time) obj;
    return this.getTimeInSeconds()==another.getTimeInSeconds();
  }
  public String toString(){return String.format("%02d:%02d", hour, minute);}
}