/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektinterfejsumain;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Dom
 */
public class MainViewFXMLDocumentController implements Initializable {
    
   //elementy GUI 
    @FXML
    private Label label;
     
     @FXML
    private TabPane tabPane= new TabPane();
    
     @FXML
    private Tab tabAttendanceList= new Tab();
        
     @FXML
    private Tab tabEmployees= new Tab();    
    
     
     @FXML
    private TableView<Employee> employeesTable= new TableView<>();

     @FXML
    private TableColumn<Employee, Boolean> activeColumn=new TableColumn<>();

    @FXML
    private TableColumn<Employee, String> surnameColumn=new TableColumn<>();

    @FXML
    private TableColumn<Employee, String> nameColumn=new TableColumn<>();

    @FXML
    private TableColumn<Employee, String> addressStreetColumn=new TableColumn<>();

    @FXML
    private TableColumn<Employee, String> addressCityColumn=new TableColumn<>();

    @FXML
    private TableColumn<Employee, String> birthDateColumn=new TableColumn<>();
    
    @FXML
    private ChoiceBox employeeEmployesChoiceBox=new ChoiceBox();
    
    @FXML
    private ChoiceBox<?> employeeAttedanceListChoiceBox;
     
    @FXML
    private ChoiceBox<?> employeePayrollChoiceBox; 
    
    @FXML
    private TableView<Employee>attendanceListTable= new TableView<>();
    
    //@FXML
  //  private TableColumn<EmployeePresence, String> dayNumberColumn=new TableColumn<>();
    //@FXML
  //  private TableColumn<EmployeePresence, String> presenceTypeColumn=new TableColumn<>();
     //@FXML
  //  private TableColumn<EmployeePresence, String> basicHoursColumn=new TableColumn<>();
    //@FXML
  //  private TableColumn<EmployeePresence, String> overtime50Column=new TableColumn<>();
      //@FXML
  //  private TableColumn<EmployeePresence, String> overtime100Column=new TableColumn<>();
      //@FXML
  //  private TableColumn<EmployeePresence, String> totalHoursColumn=new TableColumn<>();
    @FXML
    private void handleButtonAction(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
    
    //metody, akcje itd
    @FXML
    private void addButtonAction(ActionEvent event){
      try{
                                   
        FXMLLoader fxmlLoader=new FXMLLoader();//(getClass().getResource("EmplDataInput.fxml"));
        fxmlLoader.setLocation(getClass().getResource("EmplDataInput.fxml"));
        //Parent root1= (Parent)fxmlLoader.load();
        Scene scene=new Scene(fxmlLoader.load());
        Stage stage= new Stage();
        stage.setScene(scene);
        //stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Dodaj pracownika");
        stage.show();
    
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                   @Override
		   public void handle(WindowEvent we) {
                      stage.close();
                      
		   }
	   }); 
       
        //temporary solutions to add new employer :(
        //addEmployerToList();
        }
        catch(Exception e){
        System.out.println("Cant load new window");
        } 
    }
     
    @FXML
    private void editButtonAction(ActionEvent event){
       try{
        if(employeesTable.getSelectionModel().getSelectedItem()==null) 
            showAlert();//tu można zrobić wyświetlenie komunikatu "Wybierz pracownika"
        else{
        FXMLLoader fxmlLoader=new FXMLLoader();//(getClass().getResource("EmplDataInput.fxml"));
        fxmlLoader.setLocation(getClass().getResource("EmplDataInput.fxml"));
        Parent root3= (Parent)fxmlLoader.load();
        EmplDataInputController controller = fxmlLoader.getController();
        
        Scene scene=new Scene(root3);
        Stage stage= new Stage();
        stage.setScene(scene);
        //stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Edytuj pracownika");
        controller.setEmployee(employeesTable.getSelectionModel().getSelectedItem());      
        stage.show();
        }
        }
        catch(Exception e){
        System.out.println("Cant load new window");
        } 
    }
    //akcja dla otwarcia panelu do filtrowania
    @FXML
    private void filterButtonAction(ActionEvent event){
       try{
        refreshAction(5);   
        FXMLLoader fxmlLoader=new FXMLLoader();
         fxmlLoader.setLocation(getClass().getResource("filreting.fxml"));
        Parent root2= (Parent)fxmlLoader.load();
        FilretingController fController=fxmlLoader.getController();
        fController.setMainControler(this);
        Scene scene=new Scene(root2);
        Stage stage= new Stage();
        stage.setScene(scene);
        //stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Wyszukaj/filtruj");
        stage.show();
        
        }
        catch(Exception e){
        System.out.println("Cant load new window");
        } 
    }
    //akcja dla wyczyszsczenia filtrów
    @FXML
    private void clearFilterButtonAction(ActionEvent event){
        employeesTable.getItems().clear();
        employeesTable.getItems().addAll(Model.getEmployersList()); 
     }
    
   //akcja dla odświeżenia tabeli pracowników 
    public void refreshAction(int filterNumber){
        employeesTable.getItems().clear();
        employeesTable.getItems().addAll(Model.getFilteredEmployeesList(filterNumber));
        
    }
    
    @FXML
    private void removeEmployeeAction(){
        if(employeesTable.getSelectionModel().getSelectedItem()!=null)
         showConfirmationAlert();
        else
         showAlert();
    }
    
    @FXML
    private void employesChoiceBoxAction(ActionEvent event){
        int choice=employeeEmployesChoiceBox.getSelectionModel().getSelectedIndex();
        if(choice==2)
        Model.setActiveFilter(false);
        else
        Model.setActiveFilter(true);
        
        refreshAction(6);
    }
    
    @FXML
    private ListView<String> months = new ListView<>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //utworzenie listy pracowników        
        Model.createEmployeesList();
        //utworzenie listy miesięcy i dodanie do widoku !!!zrobić to na observable!!!
        months.getItems().addAll(createMonthList());
        //powiązanie kolumn z polami obiektów klasy Employee
        activeColumn.setCellValueFactory(new PropertyValueFactory<Employee,Boolean>("active"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("name") );
        surnameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("surname") );
        addressStreetColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("addressStreet") );
        addressCityColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("addressCity") );
        birthDateColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("dateOfBirth") );
        //"załadowanie" listy pracowników do ListView
        employeesTable.getItems().addAll(Model.getEmployersList());
        
        /*
        dayNumberColumn.setCellValueFactory(new PropertyValueFactory<EmployeePresence,String>("dayOfMonth"));
        
        presenceType.setCellValueFactory(new PropertyValueFactory<EmployeePresence,String>("typeOfPresence") );
        surnameColumn.setCellValueFactory(new PropertyValueFactory<EmployeePresence,String>("surname") );
        sectionColumn.setCellValueFactory(new PropertyValueFactory<EmployeePresence,String>("section") );
        positionColumn.setCellValueFactory(new PropertyValueFactory<EmployeePresence,String>("position") );
        startDateColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("startDate") );
        */
        
        //dodanie słuchacza dla listy pracowników, zmiana listy spowoduje odświeżenie widoku,
        //skasowane też zostana filtry jeżeli były ustawione
        Model.getEmployersList().addListener((ListChangeListener<Employee>) c->{
            while(c.next()){
                //if(c.wasAdded()){
                  employeesTable.getItems().clear();
                  employeesTable.getItems().addAll(Model.getEmployersList());  
                //}
            }
              
        });
    employeeEmployesChoiceBox.getItems().add(0, "Wszyscy");
    employeeEmployesChoiceBox.getItems().add(1, "Aktywny");
    employeeEmployesChoiceBox.getItems().add(2, "Nieaktywny");
    /*
    
    */
    
       
 
      

    }    
 private ArrayList<String> createMonthList()
    {
        ArrayList<String> months = new ArrayList<String>();
         
        months.add("Styczeń");
        months.add("Luty");
        months.add("Marzec");
        months.add("Kwiecień");
        months.add("Maj");
        months.add("Czerwiec");
        months.add("Lipiec");
        months.add("Sierpień");
        months.add("Wrzesień");
        months.add("Październik");
        months.add("Listopad");
        months.add("Grudzień");
         
        return months;
    }

 public void showAlert(){
Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Uwaga!");
alert.setHeaderText("Nie wybrano pracownika!");
alert.setContentText("Żeby wykonać tę operację zaznacz pracownika, którego dane chcesz edytować!");

alert.showAndWait();
 }
 
 public void showConfirmationAlert(){
     
     Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Usuń pracownika");
alert.setHeaderText("Jesteś pewien?");
alert.setContentText("Czy chcesz usunąć pracownika "+employeesTable.getSelectionModel().getSelectedItem().getName()+" "
                        +employeesTable.getSelectionModel().getSelectedItem().getSurname()+"?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    Model.removeEmployee(employeesTable.getSelectionModel().getSelectedItem());
    
} else {
    alert.close();
}
 }
}
