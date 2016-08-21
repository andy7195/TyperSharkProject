package typersharkapp;

import java.io.File;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class TiburonNegro extends AnimalesMarinos
{
    private String palabras[];
    private int numroAlt;
    private Image tiburon_negro;
    private ImageView iv;

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
        
        this.palabras = palabra;
        this.generarPosicion();
        this.setVelocidad(velocidad);
        
        iv.setLayoutX(this.getPosicionX());
        iv.setLayoutY(this.getPosicionY());
        
        pane.getChildren().add(iv);
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
    
    
        
    @Override
    public void moverse() 
    {
        this.setPosicionX(this.getPosicionX() - 1);
        this.iv.setLayoutX(this.getPosicionX());
    }

    @Override
    public void atacar() 
    {
        
    }
    
    public void generarPalabras(){
    
    }
    
}
