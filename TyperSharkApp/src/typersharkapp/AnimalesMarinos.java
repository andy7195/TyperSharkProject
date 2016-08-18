package typersharkapp;

import java.util.Random;

public abstract class AnimalesMarinos 
{
    private double posicionX;
    private double posicionY;
    private double velocidad;
    
    public AnimalesMarinos()
    {
        this.posicionX = 0;
        this.posicionY = 0;
        this.velocidad = 0;
    }
    public AnimalesMarinos(double X, double Y, double V)
    {
        this.posicionX = X;
        this.posicionY = Y;
        this.velocidad = V;
    }
    
    public abstract void moverse();
    public abstract void atacar();
    
    public void generarPosicion()
    {
        Random rand = new Random();
        
        this.posicionY = rand.nextInt(500);
        this.posicionX = 700;
        
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

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }
    
    
    
}
