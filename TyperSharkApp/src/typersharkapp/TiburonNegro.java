package typersharkapp;

import java.io.File;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class TiburonNegro extends AnimalesMarinos
{
    private String palabras[];
    private int numroAlt;
    private Image tiburon_negro;
    private ImageView iv;

    public TiburonNegro() {
        
    }

    
    public TiburonNegro(String[] palabras, int numroAlt, Image tiburon_negro, ImageView iv, double posicionX, double posicionY, double velocidad, File listadoPalabras) {
        super(posicionX, posicionY, velocidad, listadoPalabras);
        this.palabras = palabras;
        this.numroAlt = numroAlt;
        this.tiburon_negro = tiburon_negro;
        this.iv = iv;
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
        
    }

    @Override
    public void atacar() 
    {
        
    }
    
    public void generarPalabras(){
    
    }
    
}
