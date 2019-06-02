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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dom
 */
public class FilretingController implements Initializable {
    
    private MainViewFXMLDocumentController mainController;

    public MainViewFXMLDocumentController getMainControler() {
        return mainController;
    }

    public void setMainControler(MainViewFXMLDocumentController mainControler) {
        this.mainController = mainControler;
    }
    
    @FXML
    private ChoiceBox choiceBoxFilter=new ChoiceBox();

    @FXML
    private TextField textFieldFilter;

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonFilter;
    @FXML
    private void buttonCancelAction(ActionEvent event){
    Stage stage=(Stage)buttonCancel.getScene().getWindow();
    stage.close();
        
    }
    @FXML
    private void buttonFilterAction(ActionEvent event){
        
    Model.setFilter(textFieldFilter.getText());
    //Model.setFname("Adam");
    this.getMainControler().refreshAction(choiceBoxFilter.getSelectionModel().getSelectedIndex());
    Stage stage=(Stage)buttonCancel.getScene().getWindow();
    stage.close();
    
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Platform.runLater(() -> {
             System.out.println(this.getMainControler());
             choiceBoxFilter.getItems().add("Imię");
             choiceBoxFilter.getItems().add("Nazwisko");
             choiceBoxFilter.getItems().add("Stanowisko");
             choiceBoxFilter.getItems().add("Dział");
         });
    }    
    
}
