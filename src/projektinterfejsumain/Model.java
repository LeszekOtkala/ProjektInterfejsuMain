/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// todo koniecznie zająć się obsługą wyjątków związanych z sql
package projektinterfejsumain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TableView;

/**
 *
 * @author Dom
 */
public class Model extends java.util.Observable {

    private static String filter;
    private static boolean activeFilter;
    private static String conString="jdbc:sqlserver://localhost;databaseName=kadry2;selectMethod=cursor";
    private static String dbUser="TestUser";
    private static String dbPassword="mypass";

   
private static ObservableList<Employee> employeesList= FXCollections.observableArrayList();
private static ObservableList<EmployeePresence> attendanceList= FXCollections.observableArrayList();    
private static ObservableList<Contract> contractsList= FXCollections.observableArrayList(); 


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
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } 
                   
        
    }
    
    public static void clearEmployeesList(){
        employeesList.clear();
    }
    
    /**
     * list of presence of employees
     * 
     */    


    public static void createAttendanceList(){
    //     attendanceList.add(new EmployeePresence(new Employee("Jan", "Kowalski", "stolarnia", "stolarz","02.02.2018",true),30,"Styczeń" ));
         //attendanceList.add(new EmployeePresence(new Employee("Adam", "Nowak", "stolarnia", "stolarz","03.03.2018",true ),30,"Styczeń" ));  

    }    
    public static ObservableList<EmployeePresence> getAttendanceList(){

            return attendanceList;

        }

    public static void createContractsList(){
        
        //todo -> all things to create list
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