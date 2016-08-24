package typersharkapp;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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
public class Buceador extends Thread
{
    
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
    private int nivel;

     public Buceador(Pane pane ,String nombre) {
        this.figuraBuceador= new Pane();
        this.nombre = nombre;
        this.puntaje = 0;
        this.vidas = 3;
        this.numPiranhas = 0;
        this.nivel = 1;
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
        
        
        
        
        
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
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
   
    private void puntosDescenso(){
        this.puntaje++;
    }

    @Override
    public void run() 
    {
        try
        {
            while(this.getVidas() > 0)
            {
                this.setPosicionY(this.getPosicionY() + 1);
                this.puntosDescenso();
                if(this.getPosicionY() == 450)
                {
                    this.nivel++;
                    this.setPosicionY(40);
                }

                Platform.runLater(new Runnable() 
                {
                    @Override
                    public void run() 
                    { 
                        Buceador.this.getFiguraBuceador().setLayoutY(Buceador.this.getPosicionY());
                    }
                });
                
                Thread.sleep(100);
            }
        }
        catch (InterruptedException ex) 
        {
            Logger.getLogger(Buceador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void adjuntarBuceador(Pane panel)
    {
        this.figuraBuceador.getChildren().addAll(ivBuceador);
        this.getFiguraBuceador().setLayoutX(this.getPosicionX());
        this.getFiguraBuceador().setLayoutY(this.getPosicionY());
        
        panel.getChildren().add(this.getFiguraBuceador());
    }
            
    
}
