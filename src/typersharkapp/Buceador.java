package typersharkapp;

import java.io.FileWriter;
import java.io.PrintWriter;
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
 * Una clase que representa al Buceador del juego.
 * @version 1.0
 * @author Dennise Guizado
 * @author Edward Pino
 * @author Xavier Pesantes
 */
public class Buceador extends Thread
{
    
    private Pane figuraBuceador;
    private String nombre;
    private int puntaje;
    private int vidas;
    private int numPiranhas;
    private Image imBuceador;
    private ImageView ivBuceador;
    private int posicionX;
    private int posicionY;
    private int nivel;
    private int poder;
    private int criaturasAsesinadas;
    
    private Label lb_nombre;
    private Label lb_vidas;
    private Label lb_puntaje;
    private Label lb_nivel;
    private boolean conEndB;
    
    public Buceador(Pane pane, String nombre, int puntaje, int vidas, int numPiranhas, int nivel)
    {
        this.figuraBuceador= new Pane();
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.vidas = vidas;
        this.numPiranhas = numPiranhas;
        this.nivel = nivel;
        this.poder = 0;
        this.criaturasAsesinadas = 0;
        
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
    
    public Buceador(Pane pane ,String nombre,boolean conEnd) 
    {
        this.figuraBuceador= new Pane();
        this.nombre = nombre;
        this.puntaje = 0;
        this.vidas = 3;
        this.numPiranhas = 0;
        this.nivel = 1;
        this.poder = 0;
        this.criaturasAsesinadas = 1;
        this.conEndB= conEnd;
        
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
        //try
        {
        int k=1;
        int j=1;
            while((this.getVidas() > 0) && (this.conEndB==false) )
            {
                if(k%100==0)
                    this.setPosicionY(this.getPosicionY() + 1);
                k++;
                j++;
                //System.out.println(this.puntaje+" "+this.vidas);
                this.puntosDescenso(j);
                this.verificarPuntosPoder();
                
                if(this.getPosicionY() == 450)
                {
                    //this.nivel++;
                    this.setPosicionY(40);
                }
                if(this.criaturasAsesinadas%15 == 0)
                {
                    this.setCriaturasAsesinadas(1);
                    this.setNivel(this.getNivel()+1);
                }


                Thread a=new Thread(new Runnable(){

                    @Override
                    public void run() {
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
                    }
                    
                });
                a.start();


            }
            this.figuraBuceador.setVisible(false);
        }
        
        this.guardarinfo();
        //catch (InterruptedException ex) 
        //{
        //    Logger.getLogger(Buceador.class.getName()).log(Level.SEVERE, null, ex);
        //}
    }
    /**
     * Método para guardar los datos del jugador para el top.
     */
    private void guardarinfo(){
        FileWriter fichero=null;
        PrintWriter pw= null;
        try
            {

                fichero = new FileWriter("Nivel "+Integer.toString(this.getNivel())+".txt",true);
                pw = new PrintWriter(fichero); 
                pw.println("\n"+this.getNombre()+","+this.getPuntaje()+"\n");
                conEndB=true;
                //stageInicioJuego.close();
                //stagePrincipal.show();
                fichero.close();
                System.out.println("Se guardo Correctamente");

        } catch (Exception e2) {
                e2.printStackTrace();

        }
    
    }
    
    /**
     * Método que permite poner al Buceador en el pane del juego.
     * @param panel parámetro de tipo Pane que representa un pane del juego.
     */
    public void adjuntarBuceador(Pane panel)
    {
        this.figuraBuceador.getChildren().addAll(ivBuceador);
        this.getFiguraBuceador().setLayoutX(this.getPosicionX());
        this.getFiguraBuceador().setLayoutY(this.getPosicionY());
        
        panel.getChildren().add(this.getFiguraBuceador());
    }
    /**
     * Método que acumula puntos por descenso del Buceador.
     */
    private void puntosDescenso(int a){
        if(a%1000==0)
            this.puntaje++;

    }
    
    /**
     * Método que verifica que los puntos de poder no sean negativos.
     */
    private void verificarPuntosPoder()
    {
        if(this.poder > 500)
        {
            this.poder = 500;
        }
    }
    
    /**
     * Método que verifica que el puntaje no sea negativo.
     */
    public void verificarPuntajes(){
        if(this.puntaje<0){
            this.puntaje=0;
        }
    }
    
    /**
     * Método que verifica que las vidas no sean negativas.
     */
    public void verificarVidas(){
        if(this.puntaje<0){
            this.puntaje=0;
        }
    }
    
    /**
     * Método que devuelve el label del nombre del buceador.
     * @return lb_nombre
     */
    public Label getLb_nombre() {
        return lb_nombre;
    }

    /**
     * Método que modifica el label del nombre del buceador.
     * @param lb_nombre de tipo Label que representa el label del nombre del buceador.
     */
    public void setLb_nombre(Label lb_nombre) {
        this.lb_nombre = lb_nombre;
    }
    
    /**
     * Método que devuelve el pane del juego.
     * @return figuraBuceador
     */
    public Pane getFiguraBuceador() {
        return figuraBuceador;
    }

    /**
     * Método que modifica el pane del juego.
     * @param figuraBuceador de tipo Pane que representa el pane del juego.
     */
    public void setFiguraBuceador(Pane figuraBuceador) {
        this.figuraBuceador = figuraBuceador;
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
        this.verificarPuntajes();
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
        this.verificarVidas();
    }
    
    /**
     * Método que devuelve el número de pirañas que han atacado al buceador.
     * @return int numPiranhas
     */
    public int getNumPiranhas() {
        return numPiranhas;
    }
    
    /**
     * Método que modifica el número de pirañas que han atacado al buceador.
     * @param numPiranhas de tipo int que representa el número de pirañas que han atacado al buceador.
     */
    public void setNumPiranhas(int numPiranhas) {
        this.numPiranhas = numPiranhas;
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
     * @param  imBuceador de tipo Imagen que representa la imagen del Buceador.
     */
    public void setImBuceador(Image imBuceador) {
        this.imBuceador = imBuceador;
    }
    
    /**
     * Método que devuelve la vista de la imagen del Buceador.
     * @return ivBuceador
     */
    public ImageView getIvBuceador() {
        return ivBuceador;
    }
    
    /**
     * Método que modifica la vista de la imagen del Buceador.
     * @param ivBuceador de tipo ImageView que representa la vista de la imagen del Buceador.
     */
    public void setIvBuceador(ImageView ivBuceador) {
        this.ivBuceador = ivBuceador;
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
     * Método que devuelve el nivel del buceador.
     * @return nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Método que modifica el nivel del buceador.
     * @param nivel de tipo int que representa el nivel del buceador.
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Método que devuelve el label de vidas del buceador.
     * @return lb_vidas
     */
    public Label getLb_vidas() {
        return lb_vidas;
    }

    /**
     * Método que modifica el label de vidas del buceador.
     * @param lb_vidas de tipo Label que representa el label de vidas del buceador.
     */
    public void setLb_vidas(Label lb_vidas) {
        this.lb_vidas = lb_vidas;
    }

    /**
     * Método que devuelve el label de puntaje del buceador.
     * @return lb_puntaje
     */
    public Label getLb_puntaje() {
        return lb_puntaje;
    }

    /**
     * Método que modifica el label de puntaje del buceador.
     * @param lb_puntaje de tipo Label que representa el label de puntaje del buceador.
     */
    public void setLb_puntaje(Label lb_puntaje) {
        this.lb_puntaje = lb_puntaje;
    }

    /**
     * Método que devuelve el label del nivel del buceador.
     * @return lb_nivel
     */
    public Label getLb_nivel() {
        return lb_nivel;
    }

    /**
     * Método que modifica el label del nivel del buceador.
     * @param lb_nivel de tipo Label que representa el label del nivel del buceador.
     */
    public void setLb_nivel(Label lb_nivel) {
        this.lb_nivel = lb_nivel;
    }

    /**
     * Método que devuelve el combo marino del buceador.
     * @return poder
     */
    public int getPoder() {
        return poder;
    }

    /**
     * Método que modifica el combo marino del buceador.
     * @param poder de tippo int que representa el combo marino del buceador
     */
    public void setPoder(int poder) {
        this.poder = poder;
    }

    /**
     * Método que devuelve el numero de criaturas asesinadas.
     * @return criaturasAsesinadas
     */
    public int getCriaturasAsesinadas() {
        return criaturasAsesinadas;
    }

    /**
     * Método que modifica el numero de criaturas asesinadas.
     * @param criaturasAsesinadas de tipo int que representa el numero de criaturas asesinadas.
     */
    public void setCriaturasAsesinadas(int criaturasAsesinadas) {
        this.criaturasAsesinadas = criaturasAsesinadas;
    }

    /**
     * Método que devuelve el contador de finalizado de hilos.
     * @return conEndB
     */
    public boolean isConEndB() {
        return conEndB;
    }

    /**
     * Método que modifica el contador de finalizado de hilos.
     * @param conEndB de tipo boolean que representa el contador de finalizado de hilos.
     */
    public void setConEndB(boolean conEndB) {
        this.conEndB = conEndB;
    }
    
}