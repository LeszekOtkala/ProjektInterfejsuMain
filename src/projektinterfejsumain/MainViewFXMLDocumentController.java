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
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
    private TableView<EmployeeAttendanceList>attendanceListTable= new TableView<>();
    
    @FXML
    private TableColumn<EmployeeAttendanceList, String>  attendanceListSurname=new TableColumn<>() ;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceListName;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList1;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList2;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList3;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList4;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList5;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList6;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList7;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList8;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList9;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList10;

    @FXML
    private TableColumn<EmployeeAttendanceList, String>attendanceList11;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList12;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList13;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList14;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList15;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList16;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList17;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList18;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList19;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList20;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList21;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList22;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList23;

    @FXML
    private TableColumn<EmployeeAttendanceList,String> attendanceList24;

    @FXML
    private TableColumn<EmployeeAttendanceList, String> attendanceList25;

    @FXML
    private TableColumn<EmployeeAttendanceList,String> attendanceList26;

    @FXML
    private TableColumn<EmployeeAttendanceList,String> attendanceList27;

    @FXML
    private TableColumn<EmployeeAttendanceList,String> attendanceList28;

    @FXML
    private TableColumn<EmployeeAttendanceList,String> attendanceList29;

    @FXML
    private TableColumn<EmployeeAttendanceList,String> attendanceList30;

    @FXML
    private TableColumn<EmployeeAttendanceList,String> attendanceList31;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
    
    //metody, akcje itd
//actions for employee list tab
    //akcja dla przycisku dodawania
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
        System.out.println("Cant load new window 1!");
        } 
    }
    
    //akcja dla edycji danych pracownika
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
        
        stage.setTitle("Edytuj pracownika");
        controller.setEmployee(employeesTable.getSelectionModel().getSelectedItem());  
        
        stage.show();
        }
        }
        catch(Exception e){
        System.out.println("Cant load new window 2");
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
        stage.setTitle("Wyszukaj/filtruj");
        stage.show();
        
        }
        catch(Exception e){
        System.out.println("Cant load new window 3");
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
//actions for Attendance list tab 
   @FXML
    private void editPresenceEntriesButtonAction(ActionEvent event){
       try{
           
        if(attendanceListTable.getSelectionModel().getSelectedItem()==null||attendanceListTable.getSelectionModel().getSelectedCells().get(0).getColumn()<2)
            
            showAlertWithText("Nie wybrano komórki", "Wbierz komórkę do edycji");//tu można zrobić wyświetlenie komunikatu "Wybierz pracownika"
        else{
           //napisac kontroler i przekazac dane z tableView do kontrolera, obsługę logiki przekazac do modelu jak sie da
        System.out.println("Wiersz: "+attendanceListTable.getSelectionModel().getSelectedItem().getEmployee().getEmpl_Id());
        System.out.println("Kolumna: "+(attendanceListTable.getSelectionModel().getSelectedCells().get(0).getColumn()-1));    
        FXMLLoader fxmlLoader=new FXMLLoader();//(getClass().getResource("EmplDataInput.fxml"));
        fxmlLoader.setLocation(getClass().getResource("EmployeePresenceEntriesFXML.fxml"));
        Parent root4= (Parent)fxmlLoader.load();
        EmployeePresenceEntriesFXMLController controller = fxmlLoader.getController();
        
        Scene scene=new Scene(root4);
        Stage stage= new Stage();
        stage.setScene(scene);
        //stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Edytuj wpis o obecnosci");
        controller.setEmployeeIdTextFieldText(""+attendanceListTable.getSelectionModel().getSelectedItem().getEmployee().getEmpl_Id());
        controller.getMonthTextField().setText(months.getSelectionModel().getSelectedItem().getMonthEnName());
        controller.getDayTextField().setText(""+(attendanceListTable.getSelectionModel().getSelectedCells().get(0).getColumn()-1));
        controller.getYearTextField().setText("2019"); // should be changed to variable
        controller.setViewData();
        stage.show();
        }
        }
        catch(Exception e){
            e.printStackTrace();
        System.out.println("Cant load new window: Presence edit");
        } 
    } 
    
       
// ListView months     
    @FXML
    private ListView<Month> months = new ListView<>();
    
    @FXML
    private void saveButtonAction(ActionEvent event){
        //Model.createContractsList();
        
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Model.setCurrentMonth("november");
        Model.setCurrentYear(2019);
        createMonthList();
        months.getItems().addAll(createMonthList());
        months.setCellFactory(param -> new ListCell<Month>() {
            @Override
            protected void updateItem(Month item, boolean empty) {
                super.updateItem(item, empty);

                if (empty||item == null) {
                    setText(null);
                } else {
                    setText(item.getMonthPlName());
                }
            }
        });
        
        
        months.getSelectionModel().select(10);
        Model.setCurrentMonth(months.getSelectionModel().getSelectedItem());
        //utworzenie listy pracowników        
        Model.createEmployeesList();
        //utworzenie listy miesięcy i dodanie do widoku !!!zrobić to na observable!!!
       
        //months.setDisable(true);
        //powiązanie kolumn z polami obiektów klasy Employee
        activeColumn.setCellValueFactory(new PropertyValueFactory<Employee,Boolean>("active"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("name") );
        surnameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("surname") );
        addressStreetColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("addressStreet") );
        addressCityColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("addressCity") );
        birthDateColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("dateOfBirth") );
        //"załadowanie" listy pracowników do ListView - loading list of employees to ListView
        employeesTable.getItems().addAll(Model.getEmployersList());
        
        // change listener for employeeList 
         Model.getEmployersList().addListener((ListChangeListener<Employee>) c->{
            while(c.next()){
                //if(c.wasAdded()){
                  employeesTable.getItems().clear();
                  employeesTable.getItems().addAll(Model.getEmployersList());  
                //}
            }
              
        });
        
        //right mouse button menu
        ContextMenu cm = new ContextMenu();
        MenuItem mi1 = new MenuItem("Ustaw pracownika do edycji");
        cm.getItems().add(mi1);
        mi1.setOnAction(e->{
        try{
        if(employeesTable.getSelectionModel().getSelectedItem()==null) 
            showAlert();//tu można zrobić wyświetlenie komunikatu "Wybierz pracownika"
        else{
           System.out.println("Wybrales pracownika "+employeesTable.getSelectionModel().getSelectedItem().getSurname()+" "+employeesTable.getSelectionModel().getSelectedItem().getName());
        }
        
        }
        catch(Exception ex){
        System.out.println("Cant load new window 4");
        }
        });
        MenuItem mi2 = new MenuItem("Dodaj");
        cm.getItems().add(mi2);
        mi2.setOnAction(e->addButtonAction(e));
        MenuItem mi3 = new MenuItem("Edytuj");
        cm.getItems().add(mi3);
        mi3.setOnAction(e->editButtonAction(e));
        
        MenuItem mi4 = new MenuItem("Usuń");
        cm.getItems().add(mi4);
        mi4.setOnAction(e->removeEmployeeAction());
        
        

        employeesTable.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    if(t.getButton() == MouseButton.SECONDARY) {
                        cm.show(employeesTable, t.getScreenX(), t.getScreenY());
                    }
                }
            });
     //tworzenie listy typow obecnosci
    Model.createTypeOfPresenceList();
    //tworzenie listy obecnosci dla wszystkich pracownikow
    Model.createCurrentAttendanceList(); // mozna zmienic metode na np createCurrentAttendanceList() i na stale przypisac te parametry
    //powiazanie kolumn w widoku listy obecnosci z polami listy obecnosci 
    attendanceListTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    attendanceListTable.getSelectionModel().setCellSelectionEnabled(true);
    attendanceListName.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("name"));
    attendanceListSurname.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("surname"));
      //attendanceList1.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,Integer>("workTimeDay1"));
    attendanceList1.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay1"));
    attendanceList2.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay2"));
    attendanceList3.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay3"));
    attendanceList4.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay4"));
    attendanceList5.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay5"));
    attendanceList6.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay6"));
    attendanceList7.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay7"));
    attendanceList8.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay8"));
    attendanceList9.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay9"));
    attendanceList10.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay10"));
    attendanceList11.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay11"));
    attendanceList12.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay12"));
    attendanceList13.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay13"));
    attendanceList14.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay14"));
    attendanceList15.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay15"));
    attendanceList16.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay16"));
    attendanceList17.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay17"));
    attendanceList18.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay18"));
    attendanceList19.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay19"));
    attendanceList20.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay20"));
    attendanceList21.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay21"));
    attendanceList22.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay22"));
    attendanceList23.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay23"));
    attendanceList24.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay24"));
    attendanceList25.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay25"));
    attendanceList26.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay26"));
    attendanceList27.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay27"));
    attendanceList28.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay28"));
    attendanceList29.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay29"));
    attendanceList30.setCellValueFactory(new PropertyValueFactory<EmployeeAttendanceList,String>("workTimeDay30"));
    attendanceList31.setCellValueFactory(new PropertyValueFactory<>("workTimeDay31"));
    
    
       //attendanceList1.setText("1 "+"Pon");
    attendanceListTable.getItems().addAll(Model.getAttendanceList());
    
     Model.getAttendanceList().addListener((ListChangeListener<EmployeeAttendanceList>) c->{
            while(c.next()){
             
                  attendanceListTable.getItems().clear();
                  attendanceListTable.getItems().addAll(Model.getAttendanceList());  
                
            }
              
        });
    
        //skasowane też zostana filtry jeżeli były ustawione
       
    employeeEmployesChoiceBox.getItems().add(0, "Wszyscy");
    employeeEmployesChoiceBox.getItems().add(1, "Aktywny");
    employeeEmployesChoiceBox.getItems().add(2, "Nieaktywny");
        

    }   
    
    
 //lista miesiecy todo: przeniesc do modelu
    
 private ArrayList<Month> createMonthList()
    {
        ArrayList<Month> months = new ArrayList<Month>();
         
        months.add(new Month("Styczeń", "january", 1, 31));
        months.add(new Month("Luty", "february", 2, 29));
        months.add(new Month("Marzec", "march", 3, 31));
        months.add(new Month("Kwiecień", "april", 4, 30));
        months.add(new Month("Maj", "may", 5, 31));
        months.add(new Month("Czerwiec", "june", 6, 30));
        months.add(new Month("Lipiec", "july", 7, 31));
        months.add(new Month("Sierpień", "august", 8, 31));
        months.add(new Month("Wrzesień", "september", 9, 30));
        months.add(new Month("Październik", "october", 10,31));
        months.add(new Month("Listopad", "november", 11, 30));
        months.add(new Month("Grudzień", "december", 12, 31));
                     
        return months;
    }
 
 public void setActualMonth(){
     Model.setCurrentMonth(months.getSelectionModel().getSelectedItem());
     Model.clearAttendanceList();
     Model.createCurrentAttendanceList();
 }
 
 

 public void showAlert(){
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Uwaga!");
    alert.setHeaderText("Nie wybrano pracownika!");
    alert.setContentText("Żeby wykonać tę operację zaznacz pracownika, którego dane chcesz edytować!");

    alert.showAndWait();
 }
 
 
 
public void showAlertWithText(String alertHeaderText, String alertContentText){
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Uwaga!");
    alert.setHeaderText(alertHeaderText);
    alert.setContentText(alertContentText);

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
