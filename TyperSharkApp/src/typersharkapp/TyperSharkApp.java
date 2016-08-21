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

    //private PaneOrganize po;
    private Reglas reglas;
    
    @Override
    public void start(Stage stage) 
    {
        PaneOrganize po = new PaneOrganize();
        Scene scene = new Scene(po.getInicio(), 890, 500);
        po.setStage(stage);
        po.setSc(scene);
        stage.setTitle("TyperShark!...");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
    }

    /*public PaneOrganize getPo() {
        return po;
    }

    public void setPo(PaneOrganize po) {
        this.po = po;
    }*/

    public Reglas getReglas() {
        return reglas;
    }

    public void setReglas(Reglas reglas) {
        this.reglas = reglas;
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
