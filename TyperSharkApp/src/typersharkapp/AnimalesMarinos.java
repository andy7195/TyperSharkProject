package typersharkapp;

import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

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
    private int iterator;
    protected Text p;
    protected Text p2;
    private int bandera;
    
    public AnimalesMarinos(String nombreImagen, String palabra, int velocidad)
    {
        this.generarPosicion();
        this.velocidad = velocidad;
        this.bandera = 0;
        this.palabra = palabra;
        this.iterator = 0;
        
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
        this.iterator = 0;
        
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
    
    
    public Pane getFigura() {
        return figura;
    }

    public void setFigura(Pane figura) {
        this.figura = figura;
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

    public int getBandera() {
        return bandera;
    }

    public void setBandera(int bandera) {
        this.bandera = bandera;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getIterator() {
        return iterator;
    }

    public void setIterator(int iterator) {
        this.iterator = iterator;
    }
    
}
