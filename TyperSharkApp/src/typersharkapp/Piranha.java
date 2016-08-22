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


public class Piranha extends AnimalesMarinos implements Runnable
{
    private char caracter;
    private Image piranha;
    private ImageView iv;
    private Text texto;
    private TextFlow t;

    public Piranha(Pane pane, int velocidad, char letra) 
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
        this.generarPosicion();
        this.setVelocidad(velocidad);
        
        this.getFigura().getChildren().addAll(iv, t);
        
        this.getFigura().setLayoutX(this.getPosicionX());
        this.getFigura().setLayoutY(this.getPosicionY());
        
        pane.getChildren().add(this.getFigura());
    }

    
    @Override
    public void run() 
    {
        while(this.getPosicionX() != 50)
        {
            this.moverse();
            
            Platform.runLater(new Runnable() 
            {
                @Override
                public void run() 
                { 
                    Piranha.this.setPosicionX(Piranha.this.getPosicionX());
                }
            });
            try 
            {
                Thread.sleep(this.getVelocidad()*10); 
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(Piranha.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
    
    @Override
    public void moverse() 
    {
        this.setPosicionX(this.getPosicionX() - 1);
        this.getFigura().setLayoutX(this.getPosicionX());
    }

    @Override
    public void atacar() 
    {
        
    }
    
    
    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public Image getPiranha() {
        return piranha;
    }

    public void setPiranha(Image piranha) {
        this.piranha = piranha;
    }

    public ImageView getIv() {
        return iv;
    }

    public void setIv(ImageView iv) {
        this.iv = iv;
    }

    public Text getTexto() {
        return texto;
    }

    public void setTexto(Text texto) {
        this.texto = texto;
    }

    public TextFlow getT() {
        return t;
    }

    public void setT(TextFlow t) {
        this.t = t;
    }   
}
