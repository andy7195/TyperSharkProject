package typersharkapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author COMPAQ
 */
public class TyperSharkApp extends Application 
{
    @Override
    public void start(Stage stage) 
    {
        PaneOrganize po = new PaneOrganize(stage);
        Scene scene = new Scene(po.getInicio(), 890, 500);
        stage.setTitle("TyperShark");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
