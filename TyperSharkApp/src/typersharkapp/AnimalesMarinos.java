package typersharkapp;

import java.io.File;
import java.util.Random;
import javafx.scene.layout.Pane;

/**
 * Una clase abstracta para representar a los animales marinos.
 * @version 1.0
 * @author Dennise Guizado
 * @author Edward Pino
 * @author Xavier Pesantes
 */
public abstract class AnimalesMarinos extends Thread
{
    private Pane figura;
    private double posicionX;
    private double posicionY;
    private int velocidad;
    
    public AnimalesMarinos()
    {
        this.figura = new Pane();
        this.generarPosicion();
        this.velocidad = 0;
    }

    public AnimalesMarinos(Pane pane, double posicionX, double posicionY, int velocidad, File listadoPalabras) 
    {
        this.figura = pane;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.velocidad = velocidad;
    }
    
    /**
     * Método que generar la posición aletoria en Y de los animales marinos.
     */
    public void generarPosicion()
    {
        Random rand = new Random();
        
        this.posicionY = rand.nextInt(450);
        this.posicionX = 900;    
    }

    /**
     * Método que devuelve el panel de los animales marinos.
     * @return Pane
     */
    public Pane getFigura() {
        return figura;
    }

    /**
     * Método que modifica el panel de los animales marinos.
     * @param figura de tipo Pane que representa el panel de los animales marinos.
     */
    public void setFigura(Pane figura) {
        this.figura = figura;
    }
    
    /**
     * Método que devuelve la posicion en X de los animales marinos.
     * @return double
     */
    public double getPosicionX() {
        return posicionX;
    }

    /**
     * Método que modifica la posicion en X de los animales marinos.
     * @param posicionX de tipo double que representa la posicion en X de los animales marinos. 
     */
    public void setPosicionX(double posicionX) {
        this.posicionX = posicionX;
    }

    /**
     * Método que devuelve la posicion en Y de los animales marinos.
     * @return double
     */
    public double getPosicionY() {
        return posicionY;
    }

    /**
     * Método que modifica la posicion en Y de los animales marinos.
     * @param posicionY de tipo double que representa la posicion en y de los animales marinos.
     */
    public void setPosicionY(double posicionY) {
        this.posicionY = posicionY;
    }

    /**
     * Método que devuelve la velocidad de los animales marinos.
     * @return int
     */
    public int getVelocidad() {
        return velocidad;
    }

    /** 
     * Método que modifica la velocidad de los animales marinos.
     * @param velocidad de tipo int que representa la velocidad de los animales marinos.
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
}
