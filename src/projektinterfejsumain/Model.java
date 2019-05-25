/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektinterfejsumain;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

/**
 *
 * @author Dom
 */
public class Model extends java.util.Observable {
    
private static ObservableList<Employee> employeesList= FXCollections.observableArrayList();
//static activeTab; //- żeby przyciski działały na aktywnym tabie

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


}

