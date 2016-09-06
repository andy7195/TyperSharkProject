package typersharkapp;

import java.io.File;
import java.util.Random;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public abstract class AnimalesMarinos extends Thread
{
    private Pane figura;
    private double posicionX;
    private double posicionY;
    private int velocidad;
    private ImageView imagenCriaturaMarina;
    private TextFlow texto;
    
    public AnimalesMarinos(String nombreImagen, String palabra, int velocidad)
    {
        this.generarPosicion();
        this.velocidad = velocidad;
        
        Text p = new Text(130, 50, palabra);
        p.setFill(Color.GREENYELLOW);
        p.setStyle("-fx-font: 18 century;");
        
        this.texto = new TextFlow(p);
        this.texto.setLayoutX(70);
        this.texto.setLayoutY(10);
        
        this.imagenCriaturaMarina = new ImageView(new Image(nombreImagen));
        this.imagenCriaturaMarina.setFitHeight(50);
        this.imagenCriaturaMarina.setFitWidth(130);
        
        this.figura = new Pane();
        this.figura.getChildren().addAll(this.imagenCriaturaMarina, this.texto);
        
        
    }
    
    public final void generarPosicion()
    {
        Random rand = new Random();
        
        this.posicionY = rand.nextInt(450);
        this.posicionX = 900;    
    }

    public void adjuntarCriatura(Pane panel)
    {
        this.figura.setLayoutX(this.getPosicionX());
        this.figura.setLayoutY(this.getPosicionY());
        panel.getChildren().add(this.figura);
        
        //this.figura.addEventHandler(KeyEvent.KEY_TYPED, new KeyHandler());
    }
    
    
    public Pane getFigura() {
        return figura;
    }

    public void setFigura(Pane figura) {
        this.figura = figura;
    }
    
    public double getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(double posicionX) {
        this.posicionX = posicionX;
    }

    public double getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(double posicionY) {
        this.posicionY = posicionY;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    
    
}
