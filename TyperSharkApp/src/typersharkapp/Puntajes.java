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
 * Una clase para representar la ventana de los 10 mejores jugadores.
 * @version 1.0
 * @author Dennise Guizado
 * @author Edward Pino
 * @author Xavier Pesantes
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
        textArea.setPrefSize(180, 270);
        
        
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

    /**
     * Método que devuelve el stage del juego.
     * @return Stage
     */
    public Stage getS() {
        return s;
    }

    /**
     * Método que modifica el stage del juego.
     * @param s de tipo Stage que representa el stage del juego.
     */
    public void setS(Stage s) {
        this.s = s;
    }

    /**
     * Método que devuelve la escena de la ventana Puntajes.
     * @return Scene
     */
    public Scene getSc() {
        return sc;
    }

    /**
     * Método que modifica la escena de la ventana Puntajes.
     * @param sc de tipo Scene que representa la escena de la ventana Reglas.
     */
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

    /**
     * Método que devuelve el panel de la ventana Puntajes.
     * @return
     */
    public Pane getWindowPuntajes() {
        return windowPuntajes;
    }

    /**
     * Método que modifica el panel de la ventana Puntajes.
     * @param windowPuntajes
     */
    public void setWindowPuntajes(Pane windowPuntajes) {
        this.windowPuntajes = windowPuntajes;
    }

    /**
     * Método que devuelve la imagen de fondo de la ventana Puntajes.
     * @return Image
     */
    public Image getImagen() {
        return imagen;
    }

    /**
     * Método que devuelve la imagen de fondo de la ventana Puntajes.
     * @param imagen de tipo Image que representa la imagen de fondo de la ventana Puntajes.
     */
    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    /**
     * Método que devuelve la vista de la imagen de fondo de la ventana Puntajes.
     * @return ImageView
     */
    public ImageView getVi() {
        return vi;
    }

    /**
     * Método que devuelve la vista de la imagen de fondo de la ventana Puntajes.
     * @param vi de tipo ImageView que representa la vista de la imagen de fondo de la ventana Puntajes.
     */
    public void setVi(ImageView vi) {
        this.vi = vi;
    }

    /**
     * Método que devuelve el area de texto de la ventana Puntajes.
     * @return TextArea
     */
    public TextArea getTextArea() {
        return textArea;
    }

    /**
     * Método que modifica el area de texto de la ventana Puntajes.
     * @param textArea
     */
    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }

    /**
     * Método que devuelve el titulo de la ventana Puntajes.
     * @return String
     */

    public String getTexto() {
        return texto;
    }

    /**
     * Método que modifica el titulo de la ventana Puntajes.
     * @param texto de tipo String que representa el titulo de la ventana Puntajes.
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
}