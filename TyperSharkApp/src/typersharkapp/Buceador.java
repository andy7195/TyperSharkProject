package typersharkapp;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edward Pino
 */
public class Buceador {
    private String nombre;
    private int puntaje;
    private int vidas;
    private int numPiranhas;
    private int tiempo;
    private Image ImBuceador;
    private ImageView IvBuceador;

    public Buceador() {
        this.nombre="";
        this.puntaje=0;
        this.vidas=0;
        this.numPiranhas=0;
        this.tiempo=0;
    }

    public Buceador(String nombre, int puntaje, int vidas, int numPiranhas, Image ImBuceador, ImageView IvBuceador) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.vidas = vidas;
        this.numPiranhas = numPiranhas;
        this.ImBuceador = ImBuceador;
        this.IvBuceador = IvBuceador;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getNumPiranhas() {
        return numPiranhas;
    }

    public void setNumPiranhas(int numPiranhas) {
        this.numPiranhas = numPiranhas;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public Image getImBuceador() {
        return ImBuceador;
    }

    public void setImBuceador(Image ImBuceador) {
        this.ImBuceador = ImBuceador;
    }

    public ImageView getIvBuceador() {
        return IvBuceador;
    }

    public void setIvBuceador(ImageView IvBuceador) {
        this.IvBuceador = IvBuceador;
    }
    
        
    private void EliminarAnimalMarino(){
    
    }
    
    private void EliminarTodo(){
        
        
    }
    
    private void puntosDescenso(){
        
        this.puntaje++;
    }
            
    
}
