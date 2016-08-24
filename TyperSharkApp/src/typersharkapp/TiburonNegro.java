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


public class TiburonNegro extends AnimalesMarinos //implements Runnable
{
    private String palabras;//[];
    private int numroAlt;
    private Image tiburon_negro;
    private ImageView iv;
    private Text texto;
    private TextFlow t;
    private int iterator;
    private Buceador buzo;

    public TiburonNegro() {
        
    }

    
    public TiburonNegro(String palabra, Buceador jugador)//[]) 
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
        
        this.palabras = palabra;
        this.iterator = 0;
        this.buzo = jugador;
        
        this.texto = new Text(130, 50, this.palabras);
        this.texto.setFill(Color.CYAN);
        this.texto.setStyle("-fx-font: 18 century;");
        
        this.t = new TextFlow(this.texto);
        this.t.setLayoutX(35);
        this.t.setLayoutY(30);
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
                        TiburonNegro.this.getFigura().setLayoutX(TiburonNegro.this.getPosicionX());
                    }
                });

                Thread.sleep(this.getVelocidad()*10); 
            }
            TiburonNegro.this.getFigura().setVisible(false);
            this.iterator = 0;
            
            if(this.getPosicionX() <= 50)
            {
                this.buzo.setVidas(this.buzo.getVidas() - 1);
            }
            else if (this.iterator == this.palabras.length())
            {
                this.buzo.setPuntaje(this.buzo.getPuntaje() + 3);
            }
        }
        catch(Exception ex)
        {
                System.out.println("Error");
                ex.printStackTrace();
        }
    }

    public void adjuntarTiburonNegro(Pane panel, int velocidad)
    {
        getFigura().getChildren().addAll(getIv(), getT());
        
        getFigura().setLayoutX(this.getPosicionX());
        getFigura().setLayoutY(this.getPosicionY());
        panel.getChildren().add(this.getFigura());
        
        this.setVelocidad(velocidad);
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

    
    public String getPalabras() {
        return palabras;
    }

    public void setPalabras(String palabras) {
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

    public int getIterator() {
        return iterator;
    }

    public void setIterator(int iterator) {
        this.iterator = iterator;
    }
    
    
}
