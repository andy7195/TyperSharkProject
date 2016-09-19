package typersharkapp;

import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
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
    private ImageView imagenCriaturaMarina;
    protected TextFlow texto;
    protected TextFlow texto2;
    private String palabra;
    protected Text p;
    protected Text p2;
    private int bandera;
    
    public AnimalesMarinos(String nombreImagen, String palabra, int velocidad)
    {
        this.generarPosicion();
        this.velocidad = velocidad;
        this.bandera = 0;
        this.palabra = palabra;
        
        p = new Text(130, 50, palabra);
        p.setFill(Color.GREENYELLOW);
        p.setStyle("-fx-font: 18 century;");
       
        this.texto = new TextFlow(p);
       
        this.texto.setLayoutX(70);
        this.texto.setLayoutY(10);
        
        this.imagenCriaturaMarina = new ImageView(new Image(nombreImagen));
        this.imagenCriaturaMarina.setFitHeight(50);
        this.imagenCriaturaMarina.setFitWidth(130);
        
        this.figura = new Pane();
        this.figura.getChildren().addAll(this.imagenCriaturaMarina, this.texto);
        
        
    }
    
        public AnimalesMarinos(String nombreImagen, String palabra, String palabra2, int velocidad)
    {
        this.generarPosicion();
        this.velocidad = velocidad;
        this.bandera = 0;
        this.palabra = palabra;
        
        p = new Text(130, 50, palabra);
        p2 = new Text(130, 50, palabra2);
        p.setFill(Color.GREENYELLOW);
        p.setStyle("-fx-font: 18 century;");
        p2.setFill(Color.GREENYELLOW);
        p2.setStyle("-fx-font: 18 century;");
        this.texto = new TextFlow(p);
        this.texto2=new TextFlow(p2);
        this.texto2.setVisible(false);
        this.texto.setLayoutX(70);
        this.texto.setLayoutY(10);
        this.texto2.setLayoutX(70);
        this.texto2.setLayoutY(10);
        this.imagenCriaturaMarina = new ImageView(new Image(nombreImagen));
        this.imagenCriaturaMarina.setFitHeight(50);
        this.imagenCriaturaMarina.setFitWidth(130);
        
        this.figura = new Pane();
        this.figura.getChildren().addAll(this.imagenCriaturaMarina, this.texto,this.texto2);
        
        
    }
    /**
     * Método que generar la posición aletoria en Y de los animales marinos.
     */
    public final void generarPosicion()
    {
        Random rand = new Random();
        
        this.posicionY = rand.nextInt(400);
        this.posicionX = 900;    
    }

    public void adjuntarCriatura(Pane panel)
    {
        this.figura.setLayoutX(this.getPosicionX());
        this.figura.setLayoutY(this.getPosicionY());
        panel.getChildren().add(this.figura);
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

    /**
     * Método que devuelve la bandera de los animales marinos.
     * @return int
     */
    public int getBandera() {
        return bandera;
    }

    /**
     * Método que modifica la bandera de los animales marinos.
     * @param bandera de tipo int que representa la bandera de los animales marinos.
     */
    public void setBandera(int bandera) {
        this.bandera = bandera;
    }

    /**
     * Método que devuelve la palabra principal de los animales marinos.
     * @return String
     */
    public String getPalabra() {
        return palabra;
    }

    /**
     * Método que modifica la palabra principal de los animales marinos.
     * @param palabra de tipo String que representa la palabra principal de los animales marinos.
     */
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public ImageView getImagenCriaturaMarina() {
        return imagenCriaturaMarina;
    }

    public void setImagenCriaturaMarina(ImageView imagenCriaturaMarina) {
        this.imagenCriaturaMarina = imagenCriaturaMarina;
    }

    
}
