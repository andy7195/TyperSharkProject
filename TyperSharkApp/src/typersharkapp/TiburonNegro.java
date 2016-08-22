package typersharkapp;

import java.io.File;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


public class TiburonNegro extends AnimalesMarinos implements Runnable
{
    private String palabras[];
    private int numroAlt;
    private Image tiburon_negro;
    private ImageView iv;
    private Text texto;
    private TextFlow t;

    public TiburonNegro() {
        
    }

    
    public TiburonNegro(Pane pane, int velocidad, String palabra[]) 
    {
        super();
        
        try{
            tiburon_negro = new Image("BlackShark.png");
            
        }
        catch(Exception e)
        {
            System.out.println("No lee imagen");
        }
        
        iv = new ImageView(tiburon_negro);
        iv.setFitHeight(75);
        iv.setFitWidth(150);
        
        this.texto = new Text(130, 50, "Mundo");
        this.texto.setFill(Color.CYAN);
        this.texto.setStyle("-fx-font: 18 century;");
        
        this.t = new TextFlow(this.texto);
        this.t.setLayoutX(35);
        this.t.setLayoutY(30);
        
        this.palabras = palabra;
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
                    TiburonNegro.this.setPosicionX(TiburonNegro.this.getPosicionX());
                }
            });
            try 
            {
                Thread.sleep(this.getVelocidad()*10); 
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(TiburonNegro.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void generarPalabras(){
    
    }
    
    
    public TextFlow getT() {
        return t;
    }

    public void setT(TextFlow t) {
        this.t = t;
    }
    
    public Text getTexto() {
        return texto;
    }

    public void setTexto(Text texto) {
        this.texto = texto;
    }

    
    public String[] getPalabras() {
        return palabras;
    }

    public void setPalabras(String[] palabras) {
        this.palabras = palabras;
    }

    public int getNumroAlt() {
        return numroAlt;
    }

    public void setNumroAlt(int numroAlt) {
        this.numroAlt = numroAlt;
    }

    public Image getTiburon_negro() {
        return tiburon_negro;
    }

    public void setTiburon_negro(Image tiburon_negro) {
        this.tiburon_negro = tiburon_negro;
    }

    public ImageView getIv() {
        return iv;
    }

    public void setIv(ImageView iv) {
        this.iv = iv;
    }
    
}
