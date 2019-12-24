/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektinterfejsumain;

import java.net.URL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.DateTimeStringConverter;

/**
 * FXML Controller class
 *
 * @author Dom
 */
public class EmployeePresenceEntriesFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    SimpleDateFormat format;
    String[] startTime1, endTime1; 
    String[] startTime2, endTime2;
    String[] startTime3, endTime3;
    String[] startTime4, endTime4;
    
    @FXML
    private TextField employeeIdTextField;

    @FXML
    private TextField monthTextField;

    @FXML
    private TextField dayTextField;

    @FXML
    private TextField yearTextField;

    @FXML
    private Label presenceIdLabel1;

    
    @FXML
    private ChoiceBox<String> typeOfPresence1ChoiceBox1;

    @FXML
    private TextField startTimeTB1;

    @FXML
    private TextField endTimeBT1;

    @FXML
    private TextField hourlyRate1;

    @FXML
    private TextField pieceworkPaymentTB1;

    @FXML
    private Label presenceIdLabel2;

    @FXML
    private ChoiceBox<String> typeOfPresence1ChoiceBox2;

    @FXML
    private TextField startTimeTB2;

    @FXML
    private TextField endTimeBT2;

    @FXML
    private TextField hourlyRate2;

    @FXML
    private TextField pieceworkPaymentTB2;

    @FXML
    private Label presenceIdLabel3;

    @FXML
    private ChoiceBox<String> typeOfPresence1ChoiceBox3;

    @FXML
    private TextField startTimeTB3;

    @FXML
    private TextField endTimeBT3;

    @FXML
    private TextField hourlyRate3;

    @FXML
    private TextField pieceworkPaymentTB3;

    @FXML
    private Label presenceIdLabel4;

    @FXML
    private ChoiceBox<String> typeOfPresence1ChoiceBox4;

    @FXML
    private TextField startTimeTB4;

    @FXML
    private TextField endTimeBT4;

    @FXML
    private TextField hourlyRate4;

    @FXML
    private TextField pieceworkPaymentTB4;

    @FXML
    private Button employeePresenceSaveBt;

    @FXML
    private Button employePresenceLoadBt;

    @FXML
    private Button employePresenceCancelBt;
    
    @FXML
    private void saveButtonAction(){
        savePresenceEntry();
    }
        
    public TextField getEmployeeIdLabel() {
        return employeeIdTextField;
    }

        
    public void setEmployeeIdTextFieldText(String text) {
        this.employeeIdTextField.setText(text);
    }
    
    public TextField getMonthTextField() {
        return monthTextField;
    }

   
    public TextField getDayTextField() {
        return dayTextField;
    }

       
    public TextField getYearTextField() {
        return yearTextField;
    }

       
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    employeeIdTextField.setDisable(true);
    monthTextField.setDisable(true);
    dayTextField.setDisable(true);
    yearTextField.setDisable(true);
    typeOfPresence1ChoiceBox1.getItems().addAll(Model.getTypeOfPresence());
    typeOfPresence1ChoiceBox1.getSelectionModel().select(0);
    typeOfPresence1ChoiceBox2.getItems().addAll(Model.getTypeOfPresence());
    typeOfPresence1ChoiceBox2.getSelectionModel().select(0);
    typeOfPresence1ChoiceBox3.getItems().addAll(Model.getTypeOfPresence());
    typeOfPresence1ChoiceBox3.getSelectionModel().select(0);
    typeOfPresence1ChoiceBox4.getItems().addAll(Model.getTypeOfPresence());
    typeOfPresence1ChoiceBox4.getSelectionModel().select(0);
    
    setDisableFields(true,startTimeTB2,endTimeBT2,hourlyRate2,pieceworkPaymentTB2); 
    setDisableFields(true,startTimeTB3,endTimeBT3,hourlyRate3,pieceworkPaymentTB3);
    setDisableFields(true,startTimeTB4,endTimeBT4,hourlyRate4,pieceworkPaymentTB4);
    
    format = new SimpleDateFormat("HH:mm");
    startTimeTB1.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(format)));
    endTimeBT1.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(format)));           
    }   
    
    public void setDisableFields(Boolean disable, TextField startTimeTB, TextField endTimeBT, TextField hourlyRate,TextField pieceworkPaymentTB ){
    startTimeTB.setDisable(disable);
    endTimeBT.setDisable(disable);
    hourlyRate.setDisable(disable);
    pieceworkPaymentTB.setDisable(disable);
    }
    
    public void loadDataToView(ResultSet rs, Label presenceIdLabel, TextField startTimeTB, TextField endTimeBT,TextField hourlyRate,TextField pieceworkPaymentTB){
        try{
        presenceIdLabel.setText(rs.getString("Presence_Id"));
                        if((rs.getInt("Typ_Obecnosci")==1)&&(rs.getString("Start_time")!=null)&&((rs.getString("End_time")!=null))){
                        setDisableFields(false,startTimeTB,endTimeBT,hourlyRate,pieceworkPaymentTB); 
                        startTimeTB.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(format), format.parse("00:00")));
                        endTimeBT.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(format), format.parse("00:00")));    
                        startTimeTB.setText(rs.getString("Start_time").substring(11, 16));
                        endTimeBT.setText(rs.getString("End_time").substring(11, 16));
                        }
                        
                        /*if(rs.getInt("Typ_obecnosci")==2){
                            startTimeTB.setText("00:00");
                            endTimeBT.setText("00:00");
                        }
                        */
                        else{
                          startTimeTB.setText("00:00");
                          endTimeBT.setText("00:00");  
                        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void setViewData(){
        
        
        ResultSet rs= Model.loadPresenceDataFromDB(employeeIdTextField.getText(), dayTextField.getText(), "november", 2019);
         startTimeTB2.setDisable(true);
        try{
          int i=0;
            while(rs.next()){
                   //System.out.println(rs.getString("Start_time"));
                   if(i==0){    //Employee_Id, Presence_Id, Typ_Obecnosci, Date_of_entry, Start_time, End_time
                       loadDataToView(rs,presenceIdLabel1,startTimeTB1,endTimeBT1, hourlyRate1,pieceworkPaymentTB1); 
                       typeOfPresence1ChoiceBox1.getSelectionModel().select(rs.getInt("Typ_Obecnosci"));
                       /*
                       typeOfPresence1ChoiceBox1.getItems().addAll(Model.getTypeOfPresence());
                       typeOfPresence1ChoiceBox1.getSelectionModel().select(rs.getInt("Typ_Obecnosci"));
                       presenceIdLabel1.setText(rs.getString("Presence_Id"));
                        if((rs.getInt("Typ_Obecnosci")==1)&&(rs.getString("Start_time")!=null)&&((rs.getString("End_time")!=null))){
                        startTimeTB1.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(format), format.parse("00:00")));
                        endTimeBT1.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(format), format.parse("00:00")));    
                        startTimeTB1.setText(rs.getString("Start_time").substring(11, 16));
                        endTimeBT1.setText(rs.getString("End_time").substring(11, 16));
                        }
                        else{
                          startTimeTB1.setText("00:00");
                          endTimeBT1.setText("00:00");  
                        }
                        */
                   }
                   if(i==1){    //Employee_Id, Presence_Id, Typ_Obecnosci, Date_of_entry, Start_time, End_time
                       loadDataToView(rs,presenceIdLabel2,startTimeTB2,endTimeBT2,hourlyRate2,pieceworkPaymentTB2);
                       typeOfPresence1ChoiceBox2.getSelectionModel().select(rs.getInt("Typ_Obecnosci"));
                   /*    
                   startTimeTB2.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(format), format.parse("00:00")));
                   endTimeBT2.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(format), format.parse("00:00")));    
                   startTimeTB2.setDisable(false);    
                   endTimeBT2.setDisable(false);
                   hourlyRate2.setDisable(false);
                   pieceworkPaymentTB2.setDisable(false);
                   presenceIdLabel2.setText(rs.getString("Presence_Id"));
                   startTimeTB2.setText(rs.getString("Start_time").substring(11, 16));
                   endTimeBT2.setText(rs.getString("End_time").substring(11, 16));*/
                   }
                    if(i==2){    //Employee_Id, Presence_Id, Typ_Obecnosci, Date_of_entry, Start_time, End_time
                       loadDataToView(rs,presenceIdLabel3,startTimeTB3,endTimeBT3,hourlyRate3,pieceworkPaymentTB3);
                       typeOfPresence1ChoiceBox3.getSelectionModel().select(rs.getInt("Typ_Obecnosci"));
                   /*
                   startTimeTB3.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(format), format.parse("00:00")));
                   endTimeBT3.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(format), format.parse("00:00")));     
                   presenceIdLabel3.setText(rs.getString("Presence_Id"));
                   startTimeTB3.setDisable(false);    
                   endTimeBT3.setDisable(false);
                   hourlyRate3.setDisable(false);
                   pieceworkPaymentTB3.setDisable(false);
                   startTimeTB3.setText(rs.getString("Start_time").substring(11, 16));
                   endTimeBT3.setText(rs.getString("End_time").substring(11, 16)); */
                   }
                    if(i==3){    //Employee_Id, Presence_Id, Typ_Obecnosci, Date_of_entry, Start_time, End_time
                        loadDataToView(rs,presenceIdLabel4,startTimeTB4,endTimeBT4,hourlyRate2,pieceworkPaymentTB2);
                        typeOfPresence1ChoiceBox4.getSelectionModel().select(rs.getInt("Typ_Obecnosci"));
                   /*
                   startTimeTB4.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(format), format.parse("00:00")));
                   endTimeBT4.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(format), format.parse("00:00")));     
                   presenceIdLabel4.setText(rs.getString("Presence_Id"));
                   startTimeTB4.setText(rs.getString("Start_time").substring(11, 16));
                   endTimeBT4.setText(rs.getString("End_time").substring(11, 16));
                   startTimeTB4.setDisable(false);    
                   endTimeBT4.setDisable(false);
                   hourlyRate2.setDisable(false);
                   pieceworkPaymentTB2.setDisable(false);*/
                   }
         
           i++;
         }    
         }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Danych nie wyswietlono");
        }
    }
    
   public void savePresenceEntry(){
       if(startTimeTB1!=null&&endTimeBT1!=null){
            
           startTime1 = startTimeTB1.getText().split( ":" );
            int startHour = Integer.parseInt ( startTime1[0].trim() );
            int startMin = Integer.parseInt ( startTime1[1].trim() ); 
            
            endTime1 = endTimeBT1.getText().split( ":" );
            int endHour = Integer.parseInt ( endTime1[0].trim() );
            int endMin = Integer.parseInt ( endTime1[1].trim() ); 
            
                 if((startHour>=endHour)&&(startMin>=endMin)){ //czy zapisywac null czy nie pozwolic zapisac czy zapisac start 00:00 i end 00:00, zrobic zapisywanie typu obecnosci i wczytywanie wybierajac po typie obecnosci
                   System.out.println(""+startHour+":"+startMin); 
                   System.out.println("Sie cos godziny nie zgadzaja"); //jakos to obsluzyc lepiej
                  }  
                 
                 else{
                     //wywołanie metody zapisującej dane do bazy danych
                    Model.addPresenceEntryToDB(presenceIdLabel1.getText(),employeeIdTextField.getText(), startTimeTB1.getText(), endTimeBT1.getText(),dayTextField.getText(), Model.getCurrentMonth().getMonthEnName(), String.valueOf(Model.getCurrentYear()), String.valueOf(typeOfPresence1ChoiceBox1.getSelectionModel().getSelectedIndex()));
                 }
       } 
   
   
   
   }
 
   
   //end of class
}
