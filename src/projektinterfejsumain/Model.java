/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// todo koniecznie zająć się obsługą wyjątków związanych z sql i jak nie jest to klopot to przeniesc filtruy do osobnych klas
package projektinterfejsumain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TableView;

/**
 *
 * @author Leszek Otkała
 */
public class Model extends java.util.Observable {

    private static String filter;
    private static boolean activeFilter;
    
    private static Month currentMonth;
    private static int currentYear;
    
    public static Month getCurrentMonth() {
        return currentMonth;
    }

    public static void setCurrentMonth(Month _currentMonth) {
        currentMonth = _currentMonth;
    }

    public static int getCurrentYear() {
        return currentYear;
    }

    public static void setCurrentYear(int _currentYear) {
        currentYear = _currentYear;
    }
    
    private static String serverName="//localhost";
    private static String dbName="kadry2";
    private static String dbUser="";
    private static String dbPassword="";
    private static String conString="jdbc:sqlserver:"+serverName+";databaseName="+dbName+";selectMethod=cursor";
    //private static String conString="jdbc:sqlserver://localhost;databaseName=kadry2;selectMethod=cursor";
    //private static String dbUser="TestUser";
    //private static String dbPassword="mypass";

    public static void setServerName(String _serverName) {
        serverName = _serverName;
    }
    
    public static String getDbName() {
        return dbName;
    }

    public static void setDbName(String dbName) {
        Model.dbName = dbName;
    }
    
    

    public static void setDbUser(String _dbUser) {
        dbUser = _dbUser;
    }

   
    public static void setDbPassword(String _dbPassword) {
        dbPassword = _dbPassword;
    }
    
     
    
private static ObservableList<Employee> employeesList= FXCollections.observableArrayList();
private static ObservableList<EmployeeAttendanceList> attendanceList= FXCollections.observableArrayList();    
private static ObservableList<Contract> contractsList= FXCollections.observableArrayList(); 

//type of presence 
    
      private static  ObservableList<String> typeOfPresence = FXCollections.observableArrayList();

    public static ObservableList<String> getTypeOfPresence() {
        return typeOfPresence;
    }

    public static void setTypeOfPresence(ObservableList<String> typeOfPresence) {
        Model.typeOfPresence = typeOfPresence;
    }
        
   
/**
 * 
 *  employeesList
 */


    public static boolean isActiveFilter() {
        return activeFilter;
    }

    public static void setActiveFilter(boolean activeFilter) {
        Model.activeFilter = activeFilter;
    }
    public static String getFilter() {
        return filter;
    }
    public static void setFilter(String filter) {
        Model.filter = filter;
        System.out.println("Zmieniono filtrowanie na "+filter);
    }
    public static FilteredList<Employee> getFilteredEmployeesList(int filterNumber) {
        switch(filterNumber){
            case 0: return new FilteredList<Employee>(employeesList, new Filter1());
            case 1: return new FilteredList<Employee>(employeesList, new Filter2());
            case 2: return new FilteredList<Employee>(employeesList, new Filter3());
            case 3: return new FilteredList<Employee>(employeesList, new Filter4());
            case 6: return new FilteredList<Employee>(employeesList, new Filter5());
            default: return new FilteredList<Employee>(employeesList);
        }
        
    }
        
    public static void createEmployeesList(){  
        //tworzenie listy pracowników oraz test połączenia z bazą mssql
        
         String queryString="SELECT Employee_ID, FirstName, LastName, Address_Street_No, Address_City, Address_Postal, PESEL,  Active, Number_of_Children, Marital_status, Birth_date, Sex, Account_No from Employees";// left join Contracts ON Employees.Employee_ID=Contracts.Employee_ID";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con=DriverManager.getConnection(conString,dbUser,dbPassword);
            Statement statement=con.createStatement();
            ResultSet rs= statement.executeQuery(queryString);
           
            while(rs.next()){
                
                employeesList.add(new Employee(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), rs.getBoolean(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12), rs.getString(13)));                   
                //employeesList.add(new Employee(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getBoolean(10),rs.getInt(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15)));                   
            
            }
            
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
        
    } 
    
    public static void addEmployeeToList(){
        employeesList.add(new Employee());
    }
    public static void addEmployeeToList(String emplId, String name, String surname, String addressStreet, String addressCity, String postal, String personalId, String section, String position, String startDate, boolean active, int children, String maritalStatus, String dateOfBirth, String sex, String accountNo){
           
           employeesList.add(new Employee(emplId, name, surname,addressStreet, addressCity, postal, personalId, /*section,position, startDate,*/ active, children, maritalStatus, dateOfBirth, sex, accountNo));
           //employeesList.add(new Employee());
       }
      
    public static ObservableList<Employee> getEmployersList(){
        
    return employeesList;
    
    }
    public static void removeEmployee(Employee employee){
        //employeesList.removeAll(employee);
        
       try {
           
            String queryString= "DELETE from Employees WHERE Employee_ID= "+employee.getEmpl_Id();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con=DriverManager.getConnection(conString,dbUser,dbPassword);
            Statement statement=con.createStatement();
            statement.executeUpdate(queryString);
            clearEmployeesList(); 
            createEmployeesList();
            
            
            
            con.close();
        } catch (Exception ex) {
            System.out.println("Nie mozna usunąć pracownika! Leszek zrob do tego okienko z powiadomieniem ");
            //Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } 
                   
        
    }
    
    public static void clearEmployeesList(){
        employeesList.clear();
    }
    
    /**
     * list of presence of employees
     * 
     */    

    
    public static void createAttendanceList(Employee employee, String month, int year){
     //EmployeeAttendanceList employeeAttList=new EmployeeAttendanceList(employee,month, year);
     attendanceList.add(new EmployeeAttendanceList(employee,month, year));
     attendanceList.add(new EmployeeAttendanceList(employee,month, year));
     attendanceList.add(new EmployeeAttendanceList(employee,month, year));
         //attendanceList.add(new EmployeePresence(new Employee("Adam", "Nowak", "stolarnia", "stolarz","03.03.2018",true ),30,"Styczeń" ));  

    }    
    
    public static void createCurrentAttendanceList(){
      for(Employee employee:Model.getEmployersList()){  
      addEmployeeAttendanceList(employee, currentMonth.getMonthEnName(), currentYear); // todo month and year should be variables 
      }
     } 
    
    /*
     public static void createAttendanceList(){
      for(Employee employee:Model.getEmployersList()){  
      addEmployeeAttendanceList(employee, "november",2019); // todo month and year should be variables 
      }
     } */
    
     public static void clearAttendanceList(){
         attendanceList.clear();
     }
    
    public static void addEmployeeAttendanceList(Employee employee, String month, int year){
     //EmployeeAttendanceList employeeAttList=new EmployeeAttendanceList(employee,month, year);
     attendanceList.add(new EmployeeAttendanceList(employee,month, year));
     
 

    }    
    public static ObservableList<EmployeeAttendanceList> getAttendanceList(){
            System.out.println("zwrocono liste obecnosci");
            //System.out.println(attendanceList);
            return attendanceList;
            

        }
    
    
    //data for employeePresenceEntriesControler
    
    //load presence data from DB 
    public static ResultSet loadPresenceDataFromDB(String employee_id, String day, String month, int year){
        String presenceLoadQuery="SELECT Employee_Id, Presence_Id, Typ_Obecnosci, Date_of_entry, Start_time, End_time " 
        + "from Presence_entries " +
         "WHERE Employee_ID='"+employee_id+"' AND Month_='"+currentMonth.getMonthEnName()+"' AND Year_of_presence='"+year+"'and Date_of_entry='"+day+"'";
        System.out.println(presenceLoadQuery);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con=DriverManager.getConnection(conString,dbUser,dbPassword);
            Statement statement=con.createStatement();
            ResultSet rs= statement.executeQuery(presenceLoadQuery);
            return rs;
        }
       catch(Exception e){
           e.printStackTrace();
           System.out.println("Nie pobrano danych obecności z bazy danych! Leszek zrób do tego okienko z powiadomieniem");
           return null;
       } 
    }
    
    
    //add or update presence entry to DB
    public static void addPresenceEntryToDB(String presenceId, String employee_ID, String start_time, String end_time, String date_of_entry,String month_,String year_of_presence,String typ_Obecnosci){
        
    String addPresenceEntryQuery;
               
    if(presenceId.equals("<auto>")){
        
       addPresenceEntryQuery="INSERT INTO Presence_entries (Employee_ID, Start_time, End_time, Date_of_entry, Month_, Year_of_presence, Typ_Obecnosci) "+  
       "VALUES ("+employee_ID+", '"+currentYear+"-"+date_of_entry+"-"+currentMonth.getMonthId()+" "+start_time+":00.000'"+",'"+currentYear+"-"+date_of_entry+"-"+currentMonth.getMonthId()+" "+end_time+":00.000',"+date_of_entry+",'"+currentMonth.getMonthEnName()+"',"+year_of_presence+", "+typ_Obecnosci+" )";
    }   
    
    else{
        if(start_time.equals(end_time)){
        addPresenceEntryQuery="UPDATE Presence_entries "+
        "SET Start_time=NULL, End_time=NULL, Typ_Obecnosci='"+typ_Obecnosci+"' "+
        "WHERE Presence_Id='"+presenceId+"'"; 
        }
        else{
        addPresenceEntryQuery="UPDATE Presence_entries "+
        "SET Start_time='"+currentYear+"-"+date_of_entry+"-"+currentMonth.getMonthId()+" "+start_time+":00.000', End_time='"+currentYear+"-"+date_of_entry+"-"+currentMonth.getMonthId()+" "+end_time+":00.000', Typ_Obecnosci='"+typ_Obecnosci+"' "+
        "WHERE Presence_Id='"+presenceId+"'";
        }
    }
     System.out.println(addPresenceEntryQuery);
     
    //connecting to data base and executing query 
    try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con=DriverManager.getConnection(conString,dbUser,dbPassword);
            Statement statement=con.createStatement();
            statement.executeUpdate(addPresenceEntryQuery);
            
            clearAttendanceList();
            createCurrentAttendanceList();
       }
       catch(Exception e){
           e.printStackTrace();
           System.out.println("Nie zapisano danych obecności do bazy danych. Leszek zrorb do tego okienko z powiadomieniem");
           
       } 
    
    
    }           
  //end of part for Atttendance/presence list    
    
     
    
     /**
     * list of contracts of employee(s)
     * 
     */    

    
    public static void createContractsList(){
        
        //todo -> all things to create list
         String queryString="SELECT" +
                    " Contract_Id" +
                    ", Section" +
                    ", Position" +
                    ", Contract_Start_Date" +
                    ", Contract_End_Date" +
                    ", Basic_Hourly_Rate" +
                    ", Basic_salary" +
                    ", Type_Of_Contract" +
                    ", Type_Of_Settlement" +
                    "  FROM Contracts";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con=DriverManager.getConnection(conString,dbUser,dbPassword);
            Statement statement=con.createStatement();
            ResultSet rs= statement.executeQuery(queryString);
           
            while(rs.next()){
                System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)); // checking what is loading from db
                contractsList.add(new Contract(rs.getString(1), rs.getString(2), rs.getString(3),rs.getDate(4),rs.getDate(5),rs.getFloat(6),rs.getFloat(7), rs.getString(8),rs.getString(9)));                   
               //String contractId, String section, String position, Date endDate, Date startDate, float basicHourlyRate, float basicSalary, String typeOfContract, String typeOfSettlement                   
            
            }
            
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void createEmployeeContractList(Employee employee){
        
    }
   
   public static void createTypeOfPresenceList(){
       typeOfPresence.addAll("Wybierz...","Normalny", "Urlop płatny", "Zwolnienie Lekarskie", "Delegacja", "Inne");
   }
    
    
    
    
    
    
//end of class    
}






/**
 * filters for employeeList
*/
class Filter1 implements Predicate<Employee>{
    @Override
    public boolean test(Employee t){
        return t.getName().contains(Model.getFilter());
    }
}

class Filter2 implements Predicate<Employee>{
    @Override
    public boolean test(Employee t){
        return t.getSurname().contains(Model.getFilter());
    }
}

class Filter3 implements Predicate<Employee>{
    @Override
    public boolean test(Employee t){
        return t.getAddressCity().contains(Model.getFilter());
    }
}

class Filter4 implements Predicate<Employee>{
    @Override
    public boolean test(Employee t){
        return t.getAddressStreet().contains(Model.getFilter());
    }
}    
    class Filter5 implements Predicate<Employee>{
    @Override
    public boolean test(Employee t){
        return t.isActive()==Model.isActiveFilter();
    }
}