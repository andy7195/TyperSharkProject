package typersharkapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Una clase para representar el juego
 * @version 1.0
 * @author Dennise Guizado
 * @author Edward Pino
 * @author Xavier Pesantes
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
