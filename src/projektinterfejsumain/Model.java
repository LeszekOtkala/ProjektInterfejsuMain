/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektinterfejsumain;

import java.util.function.Predicate;
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

    public static boolean isActiveFilter() {
        return activeFilter;
    }

    public static void setActiveFilter(boolean activeFilter) {
        Model.activeFilter = activeFilter;
    }
    
private static ObservableList<Employee> employeesList= FXCollections.observableArrayList();
private static ObservableList<EmployeePresence> attendanceList= FXCollections.observableArrayList();    

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
        
public static void createEmployeesList()
    {
        
        employeesList.add(new Employee("Jan", "Kowalski", "stolarnia", "stolarz","02.02.2018",true ));
        employeesList.add(new Employee("Adam", "Nowak", "stolarnia", "stolarz","03.03.2018",true ));
        
    } 

    public static void addEmployeeToList(){
        employeesList.add(new Employee("Marian","Paździoch","księgowośc","księgowy","01.01.2017",false));
    }
    public static void addEmployeeToList(String name, String surname, String section, String position, String startDate, boolean active){
           employeesList.add(new Employee(name,surname,section,position,startDate,active));
       }

    public static ObservableList<Employee> getEmployersList(){
        
    return employeesList;
    
    }
    public static void removeEmployee(Employee employee){
        employeesList.removeAll(employee);
    }
public static void createAttendanceList(){
     attendanceList.add(new EmployeePresence(new Employee("Jan", "Kowalski", "stolarnia", "stolarz","02.02.2018",true),30,"Styczeń" ));
}

}

class Filter1 implements Predicate<Employee>{
    @Override
    public boolean test(Employee t){
        return t.getName().equals(Model.getFilter());
    }
}

class Filter2 implements Predicate<Employee>{
    @Override
    public boolean test(Employee t){
        return t.getSurname().equals(Model.getFilter());
    }
}

class Filter3 implements Predicate<Employee>{
    @Override
    public boolean test(Employee t){
        return t.getPosition().equals(Model.getFilter());
    }
}

class Filter4 implements Predicate<Employee>{
    @Override
    public boolean test(Employee t){
        return t.getSection().equals(Model.getFilter());
    }
}    
    class Filter5 implements Predicate<Employee>{
    @Override
    public boolean test(Employee t){
        return t.isActive()==Model.isActiveFilter();
    }
}