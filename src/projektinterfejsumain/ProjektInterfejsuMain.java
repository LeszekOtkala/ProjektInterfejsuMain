/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektinterfejsumain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Leszek Otkała
 */
public class ProjektInterfejsuMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        //tutaj dodac uruchamianie okna z polaczeniem do bazy danych - po połączeniu nazwa serwera, nazwa użytkownika  i hasło mogą być wykorzystane 
        //do komunikacji z bazą - done
        //napisac klasę z takim oknem (done) + mozliwosc utworzenia nowej DB (todo)
        //Parent root = FXMLLoader.load(getClass().getResource("MainViewFXMLDocument.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
