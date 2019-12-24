/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektinterfejsumain;

/**
 *
 * @author Dom
 */
public class EmployeePresence {
   private Employee employee;
   private String salary_Id;
   private String Employee_Id;
   private String typeOfPresence; //please change name of column in DB
   private String start_time;
   private String end_time;
   private String hourly_rate;
   private int day_of_entry; //please change name of column in DB
   private String month;
   //private int dayOfMonth;
   private int year;
  // private double[] numberOfBasicHours, overtime50, overtime100, totalHours;
   private int monthNumberOfDays;

    
   public EmployeePresence(){
       monthNumberOfDays=31;
       employee = null;
       month="";
       
       for(int i=0; i<monthNumberOfDays; i++){
       typeOfPresence="";    
       //dayOfMonth=;
      /* numberOfBasicHours[i]=0;
       overtime100[i]=0;
       overtime50[i]=0;
       totalHours[i]=0;*/
       }
       
       
   }
   public EmployeePresence(Employee employee, int day_of_entry, String month){
       monthNumberOfDays=31;
       this.employee = employee;
       this.month="month";
       
       {
       this.typeOfPresence="Normal";    
       this.day_of_entry=day_of_entry;
       /*
       if(i%7==0||(i+1)%7==0)
         numberOfBasicHours[i]=0;
       else
       numberOfBasicHours[i]=8;
       overtime100[i]=0;
       overtime50[i]=0;
       totalHours[i]=0;*/
       }
   }   
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTypeOfPresence(int i) {
        return typeOfPresence;
    }

    public void setTypeOfPresence(String typeOfPresence) {
        this.typeOfPresence = typeOfPresence;
    }

    public int getDay_of_entry() {
        return day_of_entry;
    }

    public void setDayOfMonth(int day_of_entry) {
        this.day_of_entry = day_of_entry;
    }
/*
    public double[] getNumberOfBasicHours() {
        return numberOfBasicHours;
    }

    public void setNumberOfBasicHours(double[] numberOfBasicHours) {
        this.numberOfBasicHours = numberOfBasicHours;
    }

    public double[] getOvertime50() {
        return overtime50;
    }

    public void setOvertime50(double[] overtime50) {
        this.overtime50 = overtime50;
    }

    public double[] getOvertime100() {
        return overtime100;
    }

    public void setOvertime100(double[] overtime100) {
        this.overtime100 = overtime100;
    }

    public double[] getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(double[] totalHours) {
        this.totalHours = totalHours;
    } */
  public void setMonthNumberOfDays(int monthNumberOfDays) {
        this.monthNumberOfDays = monthNumberOfDays;
    } 
   
    
}
