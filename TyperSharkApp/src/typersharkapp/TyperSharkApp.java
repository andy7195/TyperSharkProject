/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typersharkapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author COMPAQ
 */
public class TyperSharkApp extends Application {
    
    @Override
    public void start(Stage stage) {
        PaneOrganize po = new PaneOrganize();
        Scene scene = new Scene(po.getInicio(), 700, 500);
        stage.setTitle("TyperShark!...");
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
