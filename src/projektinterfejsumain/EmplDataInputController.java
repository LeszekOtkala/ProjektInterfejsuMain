/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektinterfejsumain;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dom
 */
public class EmplDataInputController implements Initializable {
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    /**
     * Initializes the controller class.
     */
       @FXML
    private TextField emplName;

    @FXML
    private TextField emplSurname;

    @FXML
    private TextField emplSection;

    @FXML
    private TextField emplPosition;

    @FXML
    private TextField emplStartDate;

    @FXML
    private CheckBox emplActive;
    
   @FXML
   private Button emplSave;
    @FXML
   private Button emplExit;
   @FXML
    private void emplExitButtonAction(ActionEvent event){
       
        //Model.addEmployeeToList(emplName.getText(), emplSurname.getText(), emplSection.getText(), emplPosition.getText(), emplStartDate.getText(), emplActive.isSelected());
        
       
         Stage stage = (Stage) emplExit.getScene().getWindow();
         stage.close();
        
     }
    @FXML
    private void emplAddButtonAction(ActionEvent event){
       if(this.getEmployee()!=null)
       {
          Model.removeEmployee(this.getEmployee());
       }
       
        Model.addEmployeeToList(emplName.getText(), emplSurname.getText(), emplSection.getText(), emplPosition.getText(), emplStartDate.getText(), emplActive.isSelected());
        
      Stage stage = (Stage) emplSave.getScene().getWindow();
       stage.close();  
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       {

    Platform.runLater(() -> { // TODO
      TextField emplName=new TextField();  
      TextField emplSurname=new TextField();
      TextField emplSection=new TextField();
      TextField emplPosition=new TextField();
      TextField emplStartDate=new TextField();
      CheckBox emplActive=new CheckBox();
      
      System.out.println("tu się utworzył");
      if(this.getEmployee()!=null) 
      setEditEmployee();
      System.out.println(this.getEmployee());
      });
    } }   
   public void setEditEmployee(){
       emplName.setText(employee.getName());
       emplSurname.setText(employee.getSurname());
       emplSection.setText(employee.getSection());
       emplPosition.setText(employee.getPosition());
       emplStartDate.setText(employee.getStartDate());
       emplActive.setSelected(employee.isActive());
   } 
}
