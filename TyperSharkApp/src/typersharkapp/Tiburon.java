package typersharkapp;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Tiburon extends AnimalesMarinos
{
    private String palabra;
    private Image tiburon;
    private ImageView iv;

    public Tiburon(String palabra, Image tiburon, ImageView iv, double posicionX, double posicionY, double velocidad, File listadoPalabras) {
        super(posicionX, posicionY, velocidad, listadoPalabras);
        this.palabra = palabra;
        this.tiburon = tiburon;
        this.iv = iv;
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

      
    
    @Override
    public void moverse() 
    {
        
    }

    @Override
    public void atacar() 
    {
        
    }
    
    
    
    
}
