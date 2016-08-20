package typersharkapp;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Piranha extends AnimalesMarinos
{
    private char caracter;
    private Image piranha;
    private ImageView iv;

    public Piranha(char caracter, Image piranha, ImageView iv, double posicionX, double posicionY, double velocidad, File listadoPalabras) {
        super(posicionX, posicionY, velocidad, listadoPalabras);
        this.caracter = caracter;
        this.piranha = piranha;
        this.iv = iv;
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
    
    @Override
    public void moverse() 
    {
        
    }

    @Override
    public void atacar() 
    {
        
    }
    
    
    
}
