/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektinterfejsumain;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Dom
 */
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StartController implements Initializable {

    @FXML
    private TextField serverNameTextField;

    @FXML
    private TextField serverUserNameTextField;

    @FXML
    private TextField serverUserPasswordField;

    @FXML
    private Button startOkBt;

    @FXML
    private Button startConnectBt;

    @FXML
    private Button startCancelBt;

    
    @FXML
    private ProgressBar progressBar=new ProgressBar();
    
    @FXML
    private void startOkButtonAction(ActionEvent event){
        
        
        boolean validCredentials=false;
        progressBar.setDisable(false);
        progressBar.setVisible(true);
        
        //przeniesc tę weryfikację do modelu!!!   
     // dokończyć widok: zrobić labelki i jeszcze nazwę bazy danych, 
     // najlepiej zrobic połączenie z serwerem, wczuytanie nazw baz danych, wybór bazy i dopiero połączenie
     try{    
            //show information "Testowanie połączenia z serwerem..."
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con=DriverManager.getConnection("jdbc:sqlserver:"+serverNameTextField.getText()+";databaseName=kadry2;selectMethod=cursor",
                    serverUserNameTextField.getText(),serverUserPasswordField.getText());
            Statement statement=con.createStatement();
            con.close();
            validCredentials=true;
            Model.setServerName(serverNameTextField.getText());
            Model.setDbUser(serverUserNameTextField.getText());
            Model.setDbPassword(serverUserPasswordField.getText());
            //close information "Testowanie połączenia z serwerem..."
     }
     catch(Exception e){
        progressBar.setVisible(false);
        Alert startAlert = new Alert(AlertType.WARNING);
        startAlert.setTitle("Uwaga!");
        startAlert.setHeaderText("Nieprawidłowe dane!");
        startAlert.setContentText("Spróbuj jeszcze raz!");
        startAlert.showAndWait();
         //System.out.println("Nieprawidłowe dane! Spróbuj ponownie");
        } 
    
    if(validCredentials){   
    try{    
        Stage stage1 = (Stage) startOkBt.getScene().getWindow();
        
        //show information "Ładowanie danych..."
        Parent root = FXMLLoader.load(getClass().getResource("MainViewFXMLDocument.fxml"));
        Scene scene=new Scene(root);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.setTitle("Hej! Witaj w programie!");
        stage.show();
        //Stage stage1 = (Stage) startOkBt.getScene().getWindow();
        //close information "Ładowanie danych..."
        stage1.close();
        
         }
        catch(Exception e){
            e.printStackTrace();
        System.out.println("Cant load new window 0");
        } 
     }
    }
      /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //progressBar=new ProgressBar();
        //progressBar.setVisible(false);
       progressBar.setDisable(true); //add new tread for progressBar, maybe progresBar should be in new windows (with only the progressBar)
       serverUserPasswordField.setText("mypass"); // do usuniecia - wstawione zeby za kazdym razem hasla nie wpisywac przy kodowaniu
    }    
    
}
