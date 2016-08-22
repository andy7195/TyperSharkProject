/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typersharkapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Andy
 */
public class Puntajes {
    private Pane windowPuntajes;
    private Image imagen;
    private ImageView vi; 
    private Stage s;
    private Scene sc;
    private TextArea textArea;
    private File file;
    FileReader fr = null;
    BufferedReader br = null;
    String texto = "";
    public Puntajes() {
         try{
            imagen= new Image("Menu.png");
        
        }
        catch(Exception e){System.out.println("No lee imagen");}
        vi=new ImageView(imagen);
        vi.setFitHeight(510);
        vi.setFitWidth(900);
        vi.setImage (imagen);
        
        
        textArea= new TextArea();
        textArea.setLayoutX(400);
        textArea.setLayoutY(150);
        textArea.setStyle("-fx-font: 18 century;-fx-background-color: transparent;-fx-background-radius: 30;");
        textArea.setPrefSize(120, 270);
        
        
        file= new File("C:/Users/Andy/Documents/NetBeansProjects/TyperSharkProject/TyperSharkApp/src/Top10.txt");
        
         try {
        fr = new FileReader(file);
	br = new BufferedReader(fr);
	String st = br.readLine();
            while (st != null) {
		texto = texto + st + "\n";
		st = br.readLine();
		}
		} catch (Exception e) {
                    System.out.println("no sale");
		textArea.appendText(e.toString());
		} finally {
		try {
		fr.close();
		} catch (Exception e2) {
		textArea.appendText(e2.toString());
		}
		}
		textArea.appendText(texto);
			
        
        windowPuntajes= new Pane();
        
        TitulosLabel titulo1= new TitulosLabel("TOP 10 MEJORES","-fx-font: 20 elephant",250,10,360,20, Color.DARKGRAY);
        TitulosLabel titulo2= new TitulosLabel("PUNTAJES","-fx-font: 20 elephant;",150,10,400,50, Color.DARKGRAY);
        Boton regreso= new Boton("Regresar","-fx-font: 20 century; -fx-background-color: transparent;-fx-background-radius: 30;", 150, 60, 580, 438, 10, Color.AQUA);
        windowPuntajes.getChildren().addAll(vi);
        windowPuntajes.getChildren().addAll(titulo1.getL(),titulo2.getL(),regreso.getBtn(), textArea);
        regreso.getBtn().setOnAction(new regresar());
    
    
    }

    public Stage getS() {
        return s;
    }

    public void setS(Stage s) {
        this.s = s;
    }

    public Scene getSc() {
        return sc;
    }

    public void setSc(Scene sc) {
        this.sc = sc;
    }
    
    
    private class regresar implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e){
            s.setTitle("TyperShark!...");
            s.setScene(getSc());
            s.show();
            
        }
    }
    public Pane getWindowPuntajes() {
        return windowPuntajes;
    }
}