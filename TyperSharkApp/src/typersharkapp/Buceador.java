package typersharkapp;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edward Pino
 */
public class Buceador implements Runnable{
    
    private Pane figuraBuceador;
    private String nombre;
    private int puntaje;
    private int vidas;
    private int numPiranhas;
    private int tiempo;
    private Image imBuceador;
    private ImageView ivBuceador;
    private int posicionX;
    private int posicionY;

     public Buceador(Pane pane ,String nombre) {
        this.figuraBuceador= new Pane();
        this.nombre = nombre;
        this.puntaje = 0;
        this.vidas = 3;
        this.numPiranhas = 0;
        try{
            imBuceador = new Image("Buceador.png");
            
        }
        catch(Exception e)
        {
            System.out.println("No lee imagen");
        }
        this.ivBuceador = new ImageView(imBuceador);
        this.ivBuceador.setFitHeight(75);
        this.ivBuceador.setFitWidth(130);
        this.setPosicionX(50);
        this.setPosicionY(50);
        
        this.figuraBuceador.getChildren().addAll(ivBuceador);
        this.getFiguraBuceador().setLayoutX(this.getPosicionX());
        this.getFiguraBuceador().setLayoutY(this.getPosicionY());
        
        pane.getChildren().add(this.getFiguraBuceador());
        
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
        return imBuceador;
    }

    public void setImBuceador(Image ImBuceador) {
        this.imBuceador = ImBuceador;
    }

    public ImageView getIvBuceador() {
        return ivBuceador;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public void setIvBuceador(ImageView IvBuceador) {
        this.ivBuceador = IvBuceador;
    }

    public Pane getFiguraBuceador() {
        return figuraBuceador;
    }

    public void setFiguraBuceador(Pane figuraBuceador) {
        this.figuraBuceador = figuraBuceador;
    }
    
        
    private void descender(){
        this.setPosicionY(this.getPosicionY() + 4);
        this.getFiguraBuceador().setLayoutY(this.getPosicionY());
    }
    
//       
    private void puntosDescenso(){
        this.puntaje++;
    }

    @Override
    public void run() {
        while(this.getPosicionY() <= 200)
        {
            this.descender();
            this.puntosDescenso();
            
            Platform.runLater(new Runnable() 
            {
                @Override
                public void run() 
                { 
                    Buceador.this.setPosicionY(Buceador.this.getPosicionY());
                }
            });
            try 
            {
                Thread.sleep(200); 
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(Buceador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
            
    
}
