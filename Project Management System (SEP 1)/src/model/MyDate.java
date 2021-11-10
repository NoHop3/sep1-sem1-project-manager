package model;

import java.time.LocalDate;

public class MyDate
{
  private int day;
  private int month;
  private int year;
  public MyDate(int day, int month, int year)
  {
    this.set(day, month, year);
  }
  public MyDate(int day, String monthName, int year){
    this(day, convertToMonthNumber(monthName), year);
  }
  public MyDate(){
    LocalDate today = LocalDate.now();
    this.day = today.getDayOfMonth();
    this.month = today.getMonthValue();
    this.year = today.getYear();
  }
  public void set(int day, int month, int year){
    setDay(day);
    setMonth(month);
    setYear(year);
  }
  public void setDay(int day){
    if(day<1)this.day = 1;
    else if(day>31) {this.day = day%31; stepForward(day%31);}
    else this.day = day;
  }
  public void setMonth(int month){
    if(month<1)this.month = 1;
    else this.month = month;
    if(month>12)this.month = 12;
    else this.month = month;
  }
  public void setMonth(String month){
    this.month = convertToMonthNumber(month);
  }
  public void setYear(int year){
    if(year<0)this.year = Math.abs(year);
    else this.year = year;
  }
  public int getDay()
  {
    return day;
  }
  public int getMonth()
  {
    return month;
  }
  public int getYear()
  {
    return year;
  }
  public boolean isLeapYear(){
    boolean returnValue;
    returnValue =
        (this.year % 4 == 0 && this.year % 100 != 0) || this.year % 400 == 0;
    return  returnValue;
  }
  public void stepForwardOneDay(){
    this.day++;
    if (this.month == 2 && this.day == 29 && this.isLeapYear())
    {
      this.month = 3;
      this.day = 1;
    }
    else
    if ((this.day == 32) && (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 9
        || this.month == 10 || this.month == 12))
    {
      this.day = 1;
      this.month++;
    }
    else
    if(this.day == 31)
    {
      this.day = 1;
      this.month++;
    }
    if (this.month > 12)
    {
      this.month = 1;
      this.year++;
    }
  }
  public void stepForward(int days){
    for(int i = 1; i <= days; i++)
      stepForwardOneDay();
  }
  public static int convertToMonthNumber(String monthName){
    int number;
    switch (monthName)
    {
      case "January": number = 1;break;
      case "February": number = 2;break;
      case "March": number = 3;break;
      case "April": number = 4;break;
      case "May": number = 5;break;
      case "June": number = 6;break;
      case "July": number = 7;break;
      case "August": number = 8;break;
      case "September": number = 9;break;
      case "October": number = 10;break;
      case "November": number = 11;break;
      case "December": number = 12;break;
      default: number = 1;
    }
    return number;
  }
  public boolean equals(Object obj){
    if(!(obj instanceof MyDate))return false;

    MyDate other = (MyDate)obj;
    return this.getDay() == other.getDay() && this.getMonth() == other.getMonth() && this.getYear() == other.getYear();
  }
  public MyDate copy(){
    MyDate other = new MyDate(this.getDay(), this.getMonth(), this.getYear());
    return other;
  }
  public String toString(){
    String returnString;

    returnString = this.year + "/" + this.month + "/" + this.day;
    return returnString;
  }
}
