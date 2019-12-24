/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektinterfejsumain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dom
 */
public class EmployeeAttendanceList {
    
    private static String conString="jdbc:sqlserver://localhost;databaseName=kadry2;selectMethod=cursor";
    private static String dbUser="TestUser";
    private static String dbPassword="mypass";
    private int monthLenght;//dopasowac dlugosc miesiaca do miesiaca
    private Employee employee;
    private String name;
    private String surname;
    private String workTimeDay1;
    private String workTimeDay2;
    private String workTimeDay3;
    private String workTimeDay4;
    private String workTimeDay5;
    private String workTimeDay6;
    private String workTimeDay7;
    private String workTimeDay8;
    private String workTimeDay9;
    private String workTimeDay10;
    private String workTimeDay11;
    private String workTimeDay12;
    private String workTimeDay13;
    private String workTimeDay14;
    private String workTimeDay15;
    private String workTimeDay16;
    private String workTimeDay17;
    private String workTimeDay18;
    private String workTimeDay19;
    private String workTimeDay20;
    private String workTimeDay21;
    private String workTimeDay22;
    private String workTimeDay23;
    private String workTimeDay24;
    private String workTimeDay25;
    private String workTimeDay26;
    private String workTimeDay27;
    private String workTimeDay28;
    private String workTimeDay29;
    private String workTimeDay30;
    private String workTimeDay31;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    


    public String getWorkTimeDay1() {
        return workTimeDay1;
    }

    public void setWorkTimeDay1(String workTimeDay1) {
        this.workTimeDay1 = workTimeDay1;
    }

    public String getWorkTimeDay2() {
        return workTimeDay2;
    }

    public void setWorkTimeDay2(String workTimeDay2) {
        this.workTimeDay2 = workTimeDay2;
    }

    public String getWorkTimeDay3() {
        return workTimeDay3;
    }

    public void setWorkTimeDay3(String workTimeDay3) {
        this.workTimeDay3 = workTimeDay3;
    }

    public String getWorkTimeDay4() {
        return workTimeDay4;
    }

    public void setWorkTimeDay4(String workTimeDay4) {
        this.workTimeDay4 = workTimeDay4;
    }

    public String getWorkTimeDay5() {
        return workTimeDay5;
    }

    public void setWorkTimeDay5(String workTimeDay5) {
        this.workTimeDay5 = workTimeDay5;
    }

    public String getWorkTimeDay6() {
        return workTimeDay6;
    }

    public void setWorkTimeDay6(String workTimeDay6) {
        this.workTimeDay6 = workTimeDay6;
    }

    public String getWorkTimeDay7() {
        return workTimeDay7;
    }

    public void setWorkTimeDay7(String workTimeDay7) {
        this.workTimeDay7 = workTimeDay7;
    }

    public String getWorkTimeDay8() {
        return workTimeDay8;
    }

    public void setWorkTimeDay8(String workTimeDay8) {
        this.workTimeDay8 = workTimeDay8;
    }

    public String getWorkTimeDay9() {
        return workTimeDay9;
    }

    public void setWorkTimeDay9(String workTimeDay9) {
        this.workTimeDay9 = workTimeDay9;
    }

    public String getWorkTimeDay10() {
        return workTimeDay10;
    }

    public void setWorkTimeDay10(String workTimeDay10) {
        this.workTimeDay10 = workTimeDay10;
    }

    public String getWorkTimeDay11() {
        return workTimeDay11;
    }

    public void setWorkTimeDay11(String workTimeDay11) {
        this.workTimeDay11 = workTimeDay11;
    }

    public String getWorkTimeDay12() {
        return workTimeDay12;
    }

    public void setWorkTimeDay12(String workTimeDay12) {
        this.workTimeDay12 = workTimeDay12;
    }

    public String getWorkTimeDay13() {
        return workTimeDay13;
    }

    public void setWorkTimeDay13(String workTimeDay13) {
        this.workTimeDay13 = workTimeDay13;
    }

    public String getWorkTimeDay14() {
        return workTimeDay14;
    }

    public void setWorkTimeDay14(String workTimeDay14) {
        this.workTimeDay14 = workTimeDay14;
    }

    public String getWorkTimeDay15() {
        return workTimeDay15;
    }

    public void setWorkTimeDay15(String workTimeDay15) {
        this.workTimeDay15 = workTimeDay15;
    }

    public String getWorkTimeDay16() {
        return workTimeDay16;
    }

    public void setWorkTimeDay16(String workTimeDay16) {
        this.workTimeDay16 = workTimeDay16;
    }

    public String getWorkTimeDay17() {
        return workTimeDay17;
    }

    public void setWorkTimeDay17(String workTimeDay17) {
        this.workTimeDay17 = workTimeDay17;
    }

    public String getWorkTimeDay18() {
        return workTimeDay18;
    }

    public void setWorkTimeDay18(String workTimeDay18) {
        this.workTimeDay18 = workTimeDay18;
    }

    public String getWorkTimeDay19() {
        return workTimeDay19;
    }

    public void setWorkTimeDay19(String workTimeDay19) {
        this.workTimeDay19 = workTimeDay19;
    }

    public String getWorkTimeDay20() {
        return workTimeDay20;
    }

    public void setWorkTimeDay20(String workTimeDay20) {
        this.workTimeDay20 = workTimeDay20;
    }

    public String getWorkTimeDay21() {
        return workTimeDay21;
    }

    public void setWorkTimeDay21(String workTimeDay21) {
        this.workTimeDay21 = workTimeDay21;
    }

    public String getWorkTimeDay22() {
        return workTimeDay22;
    }

    public void setWorkTimeDay22(String workTimeDay22) {
        this.workTimeDay22 = workTimeDay22;
    }

    public String getWorkTimeDay23() {
        return workTimeDay23;
    }

    public void setWorkTimeDay23(String workTimeDay23) {
        this.workTimeDay23 = workTimeDay23;
    }

    public String getWorkTimeDay24() {
        return workTimeDay24;
    }

    public void setWorkTimeDay24(String workTimeDay24) {
        this.workTimeDay24 = workTimeDay24;
    }

    public String getWorkTimeDay25() {
        return workTimeDay25;
    }

    public void setWorkTimeDay25(String workTimeDay25) {
        this.workTimeDay25 = workTimeDay25;
    }

    public String getWorkTimeDay26() {
        return workTimeDay26;
    }

    public void setWorkTimeDay26(String workTimeDay26) {
        this.workTimeDay26 = workTimeDay26;
    }

    public String getWorkTimeDay27() {
        return workTimeDay27;
    }

    public void setWorkTimeDay27(String workTimeDay27) {
        this.workTimeDay27 = workTimeDay27;
    }

    public String getWorkTimeDay28() {
        return workTimeDay28;
    }

    public void setWorkTimeDay28(String workTimeDay28) {
        this.workTimeDay28 = workTimeDay28;
    }

    public String getWorkTimeDay29() {
        return workTimeDay29;
    }

    public void setWorkTimeDay29(String workTimeDay29) {
        this.workTimeDay29 = workTimeDay29;
    }

    public String getWorkTimeDay30() {
        return workTimeDay30;
    }

    public void setWorkTimeDay30(String workTimeDay30) {
        this.workTimeDay30 = workTimeDay30;
    }

    public String getWorkTimeDay31() {
        return workTimeDay31;
    }

    public void setWorkTimeDay31(String workTimeDay31) {
        this.workTimeDay31 = workTimeDay31;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    
    
  /*  
    private IntegerProperty[] presence=new IntegerProperty[31];//cos tu sie wysypuje

    public void setPresence(int day_of_presence, Integer _presence) {
       this.presence[day_of_presence].set(_presence);
    }

    public Integer getPresence(int day_of_presence) {
        return presence[day_of_presence].get();
    }*/
    
   public EmployeeAttendanceList(Employee employee, String month, int year){ 
   //monthLenght=returnMonthLenght(month, year);
   this.employee=employee;
   name=employee.getName();
   surname=employee.getSurname();
   monthLenght=31;
    //setPresence(0,1);
   // workTimeDay1= "0"; 
   // workTimeDay2= "0"; 
//    workTimeDay3= "0";     
//    workTimeDay4= "0"; 
//    workTimeDay5= "0"; 
//    workTimeDay6= "0"; 
//    workTimeDay7= "0"; 
//    workTimeDay8= "0"; 
//    workTimeDay9= "0"; 
//    workTimeDay10= "0"; 
//    workTimeDay11= "0"; 
//    workTimeDay12= "0"; 
//    workTimeDay13= "0"; 
//    workTimeDay14= "0"; 
//    workTimeDay15= "0"; 
//    workTimeDay16= "0"; 
//    workTimeDay17= "0"; 
//    workTimeDay18= "0"; 
//    workTimeDay19= "0"; 
//    workTimeDay20= "0"; 
//    workTimeDay21= "0"; 
//    workTimeDay22= "0"; 
//    workTimeDay23= "0"; 
//    workTimeDay24= "0"; 
//    workTimeDay25= "0"; 
//    workTimeDay26= "0"; 
//    workTimeDay27= "0"; 
//    workTimeDay28= "0"; 
//    workTimeDay29= "0"; 
//    workTimeDay30= "0"; 
//    workTimeDay31= "0";
    System.out.println("Utworzono obiekt "+employee.getName()+" "+employee.getSurname());
   try{
            Connection con=DriverManager.getConnection(conString,dbUser,dbPassword);
            Statement statement=con.createStatement();
            
             
    //for (int i=1; i<=monthLenght; i++){ //Employee_Id, , Typ_Obecnosci
       String query="SELECT Date_of_entry, SUM(DATEDIFF(minute, Start_time , End_time ))as workTime, Typ_Obecnosci "
               + "from Presence_entries "
               + "WHERE Employee_ID='"+employee.getEmpl_Id()+"' AND Month_='"+month+"' AND Year_of_presence='"+year+"' Group By Date_of_entry, Typ_Obecnosci" ; // tu teraz dzialam
    System.out.println(query);
    ResultSet rs= statement.executeQuery(query);
    //dodac ifa ze sprawdzeniem typu obecnosci
    while(rs.next()){
    //System.out.println(rs.getInt("Date_of_entry"));
    System.out.println("Dnia: "+rs.getInt("Date_of_entry")+" pracowano: "+rs.getString("workTime"));
    
    switch(rs.getInt("Date_of_entry")){
    case(1):workTimeDay1= setDayData(rs);break;//minutesToHours(rs.getInt("workTime"));break; //setDayData(rs, workTimeDay1)
    case(2):workTimeDay2= setDayData(rs);break;  
    case(3):workTimeDay3= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(4):workTimeDay4= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(5):workTimeDay5= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(6):workTimeDay6= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(7):workTimeDay7= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(8):workTimeDay8= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(9):workTimeDay9= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(10):workTimeDay10= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(11):workTimeDay11= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(12):workTimeDay12= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(13):workTimeDay13= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(14):workTimeDay14= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(15):workTimeDay15= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(16):workTimeDay16= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(17):workTimeDay17= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(18):workTimeDay18= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(19):workTimeDay19= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(20):workTimeDay20= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(21):workTimeDay21= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(22):workTimeDay22= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(23):workTimeDay23= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(24):workTimeDay24= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(25):workTimeDay25= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(26):workTimeDay26= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(27):workTimeDay27= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(28):workTimeDay28= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(29):workTimeDay29= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(30):workTimeDay30= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    case(31):workTimeDay31= setDayData(rs);break;//=minutesToHours(rs.getInt("workTime"));break;
    default: break;

         }
     }
    con.close();
     }
     catch (Exception e){
         e.printStackTrace();
       System.out.println("cos sie ryplo");
     }
   
    }                                                                                                                               //i tak dortd
   private String setDayData(ResultSet rs) throws SQLException{
    //System.out.println(rs.getInt("Typ_Obecnosci"));
        if(rs.getInt("Typ_Obecnosci")==1){
           return minutesToHours(rs.getInt("workTime"));
        }

        else if(rs.getInt("Typ_Obecnosci")==2){  
            return "UP";                   //Urlop Platny
        }

        else if(rs.getInt("Typ_Obecnosci")==3){  
            return "ZL";                   //Zwolnienie Lekarskie
        }

         else if(rs.getInt("Typ_Obecnosci")==4){  
            return "UB";                   //Urlop Bezplatny
        }

        else if(rs.getInt("Typ_Obecnosci")==4){  
            return "DW";                   //Delegacja Wyjazd
        }

        else{
            return "XX";                   //Inne
           // setPresence(0,-1);
        }
    }

   public String minutesToHours(int minutes){
       String hour=String.format("%d", minutes/60);
       String min=String.format("%02d", minutes%60);
       return hour+":"+min;
   }
   
   // na razie nie potrzebne
   /*
   public int returnMonthLenght(String month, int year){
       
       
       switch(month){
           
           case("january"):     return 31;
           case("february"):    if(year%4==0)return 29;
                                else 
                                return 28;
           case("march"):       return 31;
           case("april"):       return 30;
           case ("may"):        return 31;
           case("june"):        return 31;
           case("july"):        return 31;
           case("august"):      return 30;
           case("september"):   return 31;
           case ("october"):    return 30;
           case ("november"):   return 31;
           default: return 0;
             
     
       }
   }*/
   
   //end of class
}
