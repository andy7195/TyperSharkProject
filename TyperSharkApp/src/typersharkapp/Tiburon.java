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


public class Tiburon extends AnimalesMarinos implements Runnable
{
    private String palabra;
    private Image tiburon;
    private ImageView iv;
    private Text texto;
    private TextFlow t;

    public Tiburon(Pane pane, int velocidad, String palabra) 
    {
        super();
        
        try{
            tiburon = new Image("Shark.png");
            
        }
        catch(Exception e)
        {
            System.out.println("No lee imagen");
        }
        
        this.iv = new ImageView(tiburon);
        this.iv.setFitHeight(50);
        this.iv.setFitWidth(130);
        
        this.texto = new Text(130, 50, "Hola");
        this.texto.setFill(Color.GREENYELLOW);
        this.texto.setStyle("-fx-font: 18 century;");
        
        this.t = new TextFlow(this.texto);
        this.t.setLayoutX(60);
        this.t.setLayoutY(8);
        
        this.palabra = palabra;
        this.generarPosicion();
        this.setVelocidad(velocidad);
        
        this.getFiguraAnimalesMarinos().getChildren().addAll(iv, t);
        
        this.getFiguraAnimalesMarinos().setLayoutX(this.getPosicionX());
        this.getFiguraAnimalesMarinos().setLayoutY(this.getPosicionY());
        
        pane.getChildren().add(this.getFiguraAnimalesMarinos());
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
                    Tiburon.this.setPosicionX(Tiburon.this.getPosicionX());
                }
            });
            try 
            {
                Thread.sleep(100); 
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(Tiburon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
    
    @Override
    public void moverse() 
    {
        this.setPosicionX(this.getPosicionX() - 1);
        this.getFiguraAnimalesMarinos().setLayoutX(this.getPosicionX());
    }

    @Override
    public void atacar() 
    {
        
    }
    
    
    
    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public Image getTiburon() {
        return tiburon;
    }

    public void setTiburon(Image tiburon) {
        this.tiburon = tiburon;
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
