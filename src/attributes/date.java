/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attributes;


/**
 *
 * @author shehab
 */
public class date
  {
    
    private int day,month,year, hours,min;

    public date()
      {
      }

    
    public date(int day, int month, int year)
      {
        this.day = day;
        this.month = month;
        this.year = year;
      }

    public date(int day, int month, int year, int hours, int min)
      {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hours = hours;
        this.min = min;
      }

    public void setHours(int hours)
      {
        this.hours = hours;
      }

    public void setMin(int min)
      {
        this.min = min;
      }

    public int getHours()
      {
        return hours;
      }

    public int getMin()
      {
        return min;
      }
    
    

    public void setDay(int day)
      {
        this.day = day;
      }

    public void setMonth(int month)
      {
        this.month = month;
      }

    public void setYear(int year)
      {
        this.year = year;
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
    
    
   
    
  }
