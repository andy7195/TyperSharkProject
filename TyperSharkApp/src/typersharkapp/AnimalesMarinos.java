package typersharkapp;

import java.io.File;
import java.util.Random;

public abstract class AnimalesMarinos 
{
    private double posicionX;
    private double posicionY;
    private int velocidad;
    private File listadoPalabras;
    
    public AnimalesMarinos()
    {
        this.posicionX = 0;
        this.posicionY = 0;
        this.velocidad = 0;
    }

    public AnimalesMarinos(double posicionX, double posicionY, int velocidad, File listadoPalabras) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.velocidad = velocidad;
        this.listadoPalabras = listadoPalabras;
    }
    
    public abstract void moverse();
    public abstract void atacar();
    
    public void generarPosicion()
    {
        Random rand = new Random();
        
        this.posicionY = rand.nextInt(500);
        this.posicionX = 900;
        
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
