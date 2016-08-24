package typersharkapp;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
/**
 * Una clase para representar a la piraña del juego.
 * @version 1.0
 * @author Dennise Guizado
 * @author Edward Pino
 * @author Xavier Pesantes
 */

public class Piranha extends AnimalesMarinos //implements Runnable
{
    private char caracter;
    private Image piranha;
    private ImageView iv;
    private Text texto;
    private TextFlow t;

    public Piranha(char letra) 
    {
        super();
        try{
            piranha = new Image("Piranha.png");
            
        }
        catch(Exception e)
        {
            System.out.println("No lee imagen");
        }
        
        this.iv = new ImageView(piranha);
        this.iv.setFitHeight(25);
        this.iv.setFitWidth(50);
        
        this.texto = new Text(130, 50, "S");
        this.texto.setFill(Color.LIGHTCYAN);
        this.texto.setStyle("-fx-font: 18 century;");
        
        this.t = new TextFlow(this.texto);
        this.t.setLayoutX(15);
        this.t.setLayoutY(0);
        
        this.caracter = letra;
    }

    
    @Override
    public void run() 
    {
         try 
        {
            while(this.getPosicionX() != 50)
            {
            
                this.setPosicionX(this.getPosicionX() - 1);
                
                Platform.runLater(new Runnable() 
                {
                    @Override
                    public void run() 
                    { 
                        Piranha.this.getFigura().setLayoutX(Piranha.this.getPosicionX());
                    }
                });

                Thread.sleep(this.getVelocidad()*10); 
            }
            Piranha.this.getFigura().setVisible(false);
        }
        catch(Exception ex)
        {
                System.out.println("Error");
                ex.printStackTrace();
        }
    }

    /**
     * Método que añade la imagen al panel de la piraña.
     * @param panel de tipo Pane que representa el panel de la piraña.
     * @param velocidad de tipo int que representa la velocidad de la piraña.
     */
    public void adjuntarPiranha(Pane panel, int velocidad)
    {
        getFigura().getChildren().addAll(getIv(), getT());
        
        getFigura().setLayoutX(this.getPosicionX());
        getFigura().setLayoutY(this.getPosicionY());
        panel.getChildren().add(this.getFigura());
        
        this.setVelocidad(velocidad);
    }
    
    /**
     * Método que devuelve el el caracter de piraña.
     * @return char
     */
    public char getCaracter() {
        return caracter;
    }

    /**
     * Método que modifica el el caracter de piraña.
     * @param caracter
     */
    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    /**
     * Método que devuelve la imagen de la piraña.
     * @return Image
     */
    public Image getPiranha() {
        return piranha;
    }

    /**
     * Método que modifica la imagen de la piraña.
     * @param piranha de tipo Image que representa la imagen de la piraña.
     */
    public void setPiranha(Image piranha) {
        this.piranha = piranha;
    }

    /**
     * Método que devuelve la vista de la imagen de la piraña.
     * @return ImageView
     */
    public ImageView getIv() {
        return iv;
    }

    /**
     * Método que modifica la vista de la imagen de la piraña.
     * @param iv de tipo ImageView que representa la vista de la imagen de la piraña.
     */
    public void setIv(ImageView iv) {
        this.iv = iv;
    }

    /**
     * Método que devuelve el texto de la piraña.
     * @return Text
     */
    public Text getTexto() {
        return texto;
    }

    /**
     * Método que modifica el texto de la piraña.
     * @param texto de tipo Text que representa el texto de la piraña.
     */
    public void setTexto(Text texto) {
        this.texto = texto;
    }

    /**
     * Método que devuelve el TextFlow de la piraña.
     * @return TextFlow
     */
    public TextFlow getT() {
        return t;
    }

    /**
     * Método que modifica el TextFlow de la piraña.
     * @param t de tipo TextFlow
     */
    public void setT(TextFlow t) {
        this.t = t;
    }   
}