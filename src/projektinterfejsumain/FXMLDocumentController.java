/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektinterfejsumain;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

/**
 *
 * @author Dom
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        //System.out.println("You clicked me!");
        //label.setText("Hello World!");
        Platform.exit();
        System.exit(0);
    }
    @FXML
    private ListView<String> months = new ListView<>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // label.setText("Test kontrolera");
         
        // Add the items to the List 
        
        months.getItems().addAll(createMonthList());
        // Set the size of the ListView
        //months.setPrefSize(200, 280);
        // Enable multiple selection
        //months.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
         
        // Update the message Label when the selected item changes
       /* months.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
        {
            public void changed(ObservableValue<? extends String> ov,
                    final String oldvalue, final String newvalue) 
            {
                //monthChanged(ov, oldvalue, newvalue);
        }});*/
 
      

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
}
