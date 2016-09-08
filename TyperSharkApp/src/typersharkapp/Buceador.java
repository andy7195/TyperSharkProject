package typersharkapp;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

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
    
    private Label lb_nombre;
    private Label lb_vidas;
    private Label lb_puntaje;
    private Label lb_nivel;

    
    public Buceador(Pane pane, String nombre, int puntaje, int vidas, int numPiranhas, int tiempo, int nivel)
    {
        this.figuraBuceador= new Pane();
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.vidas = vidas;
        this.numPiranhas = numPiranhas;
        this.tiempo = tiempo;
        this.nivel = nivel;
        
        this.lb_nombre = new Label(nombre);
        this.lb_nombre.setStyle("-fx-font: 14 elephant");
        this.lb_nombre.setTextFill(Color.WHITE);
        this.lb_vidas = new Label(Integer.toString(vidas));
        this.lb_vidas.setStyle("-fx-font: 14 elephant");
        this.lb_vidas.setTextFill(Color.WHITE);
        this.lb_puntaje = new Label(Integer.toString(puntaje));
        this.lb_puntaje = new Label(Integer.toString(this.puntaje));
        this.lb_puntaje.setStyle("-fx-font: 14 elephant");
        this.lb_nivel = new Label(Integer.toString(nivel));
        this.lb_nivel.setStyle("-fx-font: 14 elephant");
        this.lb_nivel.setTextFill(Color.WHITE);
        
        try
        {
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
    
    public Buceador(Pane pane ,String nombre) 
    {
        this.figuraBuceador= new Pane();
        this.nombre = nombre;
        this.puntaje = 0;
        this.vidas = 3;
        this.numPiranhas = 0;
        this.nivel = 0;
        
        this.lb_nombre = new Label(this.nombre);
        this.lb_nombre.setStyle("-fx-font: 14 elephant");
        this.lb_nombre.setTextFill(Color.WHITE);
        this.lb_vidas = new Label(Integer.toString(this.vidas));
        this.lb_vidas.setStyle("-fx-font: 14 elephant");
        this.lb_vidas.setTextFill(Color.WHITE);
        this.lb_puntaje = new Label(Integer.toString(this.puntaje));
        this.lb_puntaje.setStyle("-fx-font: 14 elephant");
        this.lb_puntaje.setTextFill(Color.WHITE);
        this.lb_nivel = new Label(Integer.toString(this.nivel));
        this.lb_nivel.setStyle("-fx-font: 14 elephant");
        this.lb_nivel.setTextFill(Color.WHITE);
        
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
                    //this.nivel++;
                    this.setPosicionY(40);
                }

                Platform.runLater(new Runnable() 
                {
                    @Override
                    public void run() 
                    { 
                        Buceador.this.getFiguraBuceador().setLayoutY(Buceador.this.getPosicionY());
                        lb_vidas.setText(Integer.toString(vidas));
                        lb_puntaje.setText(Integer.toString(puntaje));
                        lb_nivel.setText(Integer.toString(nivel));
                    }
                });
                
                Thread.sleep(100);
            }
            this.figuraBuceador.setVisible(false);
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
    
    private void puntosDescenso(){
        this.puntaje++;
    } 

    
    
    public Label getLb_nombre() {
        return lb_nombre;
    }

    public void setLb_nombre(Label lb_nombre) {
        this.lb_nombre = lb_nombre;
    }
    
    public Pane getFiguraBuceador() {
        return figuraBuceador;
    }

    public void setFiguraBuceador(Pane figuraBuceador) {
        this.figuraBuceador = figuraBuceador;
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

    public void setImBuceador(Image imBuceador) {
        this.imBuceador = imBuceador;
    }

    public ImageView getIvBuceador() {
        return ivBuceador;
    }

    public void setIvBuceador(ImageView ivBuceador) {
        this.ivBuceador = ivBuceador;
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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Label getLb_vidas() {
        return lb_vidas;
    }

    public void setLb_vidas(Label lb_vidas) {
        this.lb_vidas = lb_vidas;
    }

    public Label getLb_puntaje() {
        return lb_puntaje;
    }

    public void setLb_puntaje(Label lb_puntaje) {
        this.lb_puntaje = lb_puntaje;
    }

    public Label getLb_nivel() {
        return lb_nivel;
    }

    public void setLb_nivel(Label lb_nivel) {
        this.lb_nivel = lb_nivel;
    }
    
}