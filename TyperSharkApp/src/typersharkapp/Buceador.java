package typersharkapp;

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
 * @version 1.0
 * @author Dennise Guizado
 * @author Edward Pino
 * @author Xavier Pesantes
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

    
    public Buceador() {
    }

    
     public Buceador(Pane pane) {
        this.figuraBuceador= new Pane();
        this.nombre = "";
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
    
    /**
     * Método que devuelve el nombre del buceador.
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que modica el nombre del buceador.
     * @param nombre de tipo String que representa el nombre del buceador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve el puntaje del buceador.
     * @return int
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * Método que modifica el puntaje del buceador.
     * @param puntaje de tipo int que representa el puntaje del buceador.
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * Método que devuelve el número de vidas del buceador.
     * @return int
     */
    public int getVidas() {
        return vidas;
    }

    /**
     * Método que modifica el número de vidas del buceador.
     * @param vidas de tipo int que representa el número de vidas del buceador.
     */
    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    /**
     * Método que devuelve el número de pirañas que han atacado al buceador.
     * @return int
     */
    public int getNumPiranhas() {
        return numPiranhas;
    }

    /**
     * Método que modifica el número de pirañas que han atacado al buceador.
     * @param numPiranhas
     */
    public void setNumPiranhas(int numPiranhas) {
        this.numPiranhas = numPiranhas;
    }

    /**
     * Método que devuelve el tiempo dese que empieza la partida.
     * @return int
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * Método que modifica el tiempo desde que empieza la partida.
     * @param tiempo de tipo int que representa el tiempo dese que empieza la partida.
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * Método que devuelve la imagen del Buceador.
     * @return Image
     */
    public Image getImBuceador() {
        return imBuceador;
    }

    /**
     * Método que modifica la imagen del Buceador.
     * @param ImBuceador de tipo Imagen que representa la imagen del Buceador.
     */
    public void setImBuceador(Image ImBuceador) {
        this.imBuceador = ImBuceador;
    }

    /**
     * Método que devuelve la vista de la imagen del Buceador.
     * @return
     */
    public ImageView getIvBuceador() {
        return ivBuceador;
    }
    
    /**
     * Método que modifica la vista de la imagen del Buceador.
     * @param IvBuceador de tipo ImageView que representa la vista de la imagen del Buceador.
     */
    public void setIvBuceador(ImageView IvBuceador) {
        this.ivBuceador = IvBuceador;
    }
    
    /**
     * Método que devuelve la posicion en X del Buceador.
     * @return int
     */
    public int getPosicionX() {
        return posicionX;
    }

    /**
     * Método que modifica la posicion en X del Buceador.
     * @param posicionX de tipo int que representa la posicion en X del Buceador.
     */
    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    /**
     * Método que devuelve la posicion en Y del Buceador.
     * @return int
     */
    public int getPosicionY() {
        return posicionY;
    }

    /**
     * Método que modifica la posicion en Y del Buceador.
     * @param posicionY de tipo int que representa la posicion en Y del Buceador.
     */
    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    

    /**
     * Método que devuelve lel panel del Buceador.
     * @return Pane
     */
    public Pane getFiguraBuceador() {
        return figuraBuceador;
    }

    /**
     * Método que modifica el panel del Buceador.
     * @param figuraBuceador de tipo Pane que representa el panel del Buceador.
     */
    public void setFiguraBuceador(Pane figuraBuceador) {
        this.figuraBuceador = figuraBuceador;
    }
    
    /**
     * Método que permite moverse al Buceador
     */
    public void descender(){
        this.setPosicionY(this.getPosicionY() + 4);
        this.getFiguraBuceador().setLayoutY(this.getPosicionY());
    }
    
    /**
     * Método que acumula puntos por descenso del Buceador.
     */
    public void puntosDescenso(){
        this.puntaje++;
    }

    @Override
    public void run() {
        
        try{
            while(this.getPosicionY() <= 200)
            {
                this.descender();
                this.puntosDescenso();
                System.out.println("score: "+this.puntaje);
                Platform.runLater(new Runnable() 
                {
                    @Override
                    public void run() 
                    { 
                        Buceador.this.setPosicionY(Buceador.this.getPosicionY());
                    }
                });
               Thread.sleep(1000); 
            }
        
        }
        catch(Exception ex)
        {
                System.out.println("Error");
                ex.printStackTrace();
        }  
    }
            
    
}
