/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektinterfejsumain;

import static java.lang.String.valueOf;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dom
 */
public class EmplDataInputController implements Initializable {
    
    //pole dla wymiany pracownika dla edycji na liście
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    @FXML
    private TextField emplName;

    @FXML
    private TextField emplSurname;

    @FXML
    private TextField emplAddressStreet;

    @FXML
    private TextField emplAddressCity;

    @FXML
    private TextField emplAddressPostalCode;
    /*
    @FXML
    private TextField emplSection;

    @FXML
    private TextField emplPosition;

    @FXML
    private DatePicker emplStartDate;
    
    @FXML
    private TextField emplContractPeriod;
    */
    @FXML
    private CheckBox emplActive;
    
    @FXML
    private TextField emplPersId;

    @FXML
    private ChoiceBox<String> emplMaritalStatus;

    @FXML
    private TextField emplNumberChildren;

    @FXML
    private DatePicker emplBirthDate;

    @FXML
    private ChoiceBox<String> emplSex;

    @FXML
    private TextField emplAccountNumber;
    
   @FXML
   private Button emplSave;
    @FXML
   private Button emplExit;
    //akcja dla zamknięcia okna dodawania/edycji danych pracownika
   @FXML
    private void emplExitButtonAction(ActionEvent event){
       
        //Model.addEmployeeToList(emplName.getText(), emplSurname.getText(), emplSection.getText(), emplPosition.getText(), emplStartDate.getText(), emplActive.isSelected());
         Stage stage = (Stage) emplExit.getScene().getWindow();
         stage.close();
     }
    //akcja dla edycji/dodania pracownika do listy
    //zrobic dodanie do db i odswiezenie listy
    @FXML
    private void emplAddButtonAction(ActionEvent event){
       if(this.getEmployee()!=null)
       {
         // Model.removeEmployee(this.getEmployee());
          updateEmployeeToDB();
       }
       
        //Model.addEmployeeToList(emplName.getText(), emplSurname.getText(), emplSection.getText(), emplPosition.getText(), emplStartDate.getText(), emplActive.isSelected());
       //Model.addEmployeeToList(emplName.getText(), emplSurname.getText(), emplAddressStreet.getText(), emplAddressCity.getText(), emplAddressPostalCode.getText(), emplPersId.getText(), emplSection.getText(),emplPosition.getText(), String.valueOf(emplStartDate.getValue()) ,emplActive.isSelected(),0/*children*/, emplMaritalStatus.getSelectionModel().getSelectedItem(), emplBirthDate.getValue().toString(), emplSex.getSelectionModel().getSelectedItem(), emplAccountNumber.getText());
       else
       addEmployeeToDB();
       Stage stage = (Stage) emplSave.getScene().getWindow();
       stage.close();  
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       {

    Platform.runLater(() -> { // TODO
        /* TextField emplName=new TextField();  
         TextField emplSurname=new TextField();
         TextField emplSection=new TextField();
         TextField emplPosition=new TextField();
         TextField emplStartDate=new TextField();
         CheckBox emplActive=new CheckBox();//sprawdzic po co to było!
         */
             emplMaritalStatus.getItems().add("Wybierz..");
             emplMaritalStatus.getItems().add("Panna");
             emplMaritalStatus.getItems().add("Kawaler");
             emplMaritalStatus.getItems().add("Zamężna");
             emplMaritalStatus.getItems().add("Żonaty");
             emplSex.getItems().add("Wybierz..");
             emplSex.getItems().add("WOMEN");
             emplSex.getItems().add("MEN");
         //System.out.println("tu się utworzył");
         if(this.getEmployee()!=null) 
         setEditEmployee();
        });
    } }  
    //ustawienie pól GUI na dane edytowaniego pracownika
   public void setEditEmployee(){
         
     emplName.setText(employee.getName());
     emplSurname.setText(employee.getSurname());
     emplAddressStreet.setText(employee.getAddressStreet());
     emplAddressCity.setText(employee.getAddressCity());
     emplAddressPostalCode.setText(employee.getPostal());
     /*
     if(employee.getSection()!=null)
     emplSection.setText(employee.getSection());
     if(employee.getPosition()!=null)
     emplPosition.setText(employee.getPosition());
     if(employee.getStartDate()!=null)
     emplStartDate.setValue(LocalDate.parse(employee.getStartDate().substring(0,10), DateTimeFormatter.ISO_LOCAL_DATE));  
     */
     //emplContractPeriod.setText(employee.getContractPeriod());
     emplActive.setSelected(employee.isActive());
     emplPersId.setText(employee.getPersonalId());    
     emplMaritalStatus.setValue(employee.getMaritalStatus());
     emplNumberChildren.setText(valueOf(employee.getChildren()));
     System.out.println(employee.getDateOfBirth());
     emplBirthDate.setValue(LocalDate.parse(employee.getDateOfBirth().substring(0,10), DateTimeFormatter.ISO_LOCAL_DATE));
     
     emplSex.setValue(employee.getSex()); //(employee.getSex());
     emplAccountNumber.setText(employee.getAccountNo());
       
   } 
   
   public void addEmployeeToDB(){
       String query="insert into Pracownicy (Nazwisko, Imie, Aktywny, Adres_Ulica_Nr, Adres_Miasto, Adres_Kod_Poczt, PESEL, Nr_konta, Stan_cywilny, Liczba_dzieci, Rok_urodzenia, Plec) values ('"
               +emplSurname.getText()+"', '"+emplName.getText()+"', '"+emplActive.isSelected()+"', '"+emplAddressStreet.getText()+"', '"+emplAddressCity.getText()+"',"+emplAddressPostalCode.getText()
               +","+emplPersId.getText()+","+emplAccountNumber.getText()+", '"+emplMaritalStatus.getSelectionModel().getSelectedItem().toString()+"',"+Integer.valueOf(emplNumberChildren.getText())+",'"
               +emplBirthDate.getValue().format(DateTimeFormatter.BASIC_ISO_DATE)+"', '"+emplSex.getSelectionModel().getSelectedItem()+"')";
       System.out.println(query);
       System.out.println(emplBirthDate.getValue());
       
        String conString="jdbc:sqlserver://localhost;databaseName=kadry1;selectMethod=cursor";
        String dbUser="TestUser";
        String dbPassword="mypass";
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con=DriverManager.getConnection(conString,dbUser,dbPassword);
            Statement statement=con.createStatement();
            statement.executeUpdate(query);
            
          con.close();
          Model.clearEmployeesList();
          Model.createEmployeesList();
        } catch (Exception ex) {
            System.out.println("Cos sie wysypalo!");
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    //update Pracownicy set Rok_urodzenia='1997-02-03' where Imie='Jan' and Nazwisko='Kowalski'    
   }
   
    public void updateEmployeeToDB(){
       String query="update Pracownicy set Nazwisko='"+emplSurname.getText()+"', Imie='"+emplName.getText()+"', Aktywny='"+String.valueOf(emplActive.isSelected())+"', Adres_Ulica_Nr='"+emplAddressStreet.getText()+"', Adres_Miasto='"+emplAddressCity.getText()+"', Adres_Kod_Poczt="+emplAddressPostalCode.getText()+", PESEL="+emplPersId.getText()+", Nr_konta="+emplAccountNumber.getText()+", Stan_cywilny='"+emplMaritalStatus.getSelectionModel().getSelectedItem().toString()+"', Liczba_dzieci="+Integer.valueOf(emplNumberChildren.getText())+", Rok_urodzenia='"+emplBirthDate.getValue().format(DateTimeFormatter.BASIC_ISO_DATE)+"', Plec='"+emplSex.getSelectionModel().getSelectedItem()+
                    "'where Imie='"+emplName.getText()+"'AND Nazwisko='"+emplSurname.getText()+"'";
       System.out.println(query);
       System.out.println(emplBirthDate.getValue());
       
        String conString="jdbc:sqlserver://localhost;databaseName=kadry1;selectMethod=cursor";
        String dbUser="TestUser";
        String dbPassword="mypass";
         try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             Connection con=DriverManager.getConnection(conString,dbUser,dbPassword);
                Statement statement=con.createStatement();
                statement.executeUpdate(query);
            
                con.close();
           Model.clearEmployeesList();
           Model.createEmployeesList();
        } catch (Exception ex) {
            System.out.println("Cos sie wysypalo!");
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
