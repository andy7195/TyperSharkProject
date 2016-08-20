/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typersharkapp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Andy
 */
public class Reglas {
    
    private Pane windowReglas;
    private Image imagen;
    private ImageView vi; 
     
    public Reglas() {
        
         try{
            imagen= new Image("Shark.jpeg");
        
        }
        catch(Exception e){System.out.println("No lee imagen");}
        vi=new ImageView(imagen);
        vi.setFitHeight(510);
        vi.setFitWidth(710);
        vi.setImage (imagen);
        
        windowReglas= new Pane();
        windowReglas.setStyle("-fx-background-color: aqua;");
        TitulosLabel titulo1= new TitulosLabel("REGLAS","-fx-font: 20 elephant",150,10,300,10, Color.DARKGRAY);
        TitulosLabel titulo2= new TitulosLabel("TYPERSHARK","-fx-font: 20 elephant;",210,10,260,40, Color.DARKGRAY);
        Boton regreso= new Boton("Regresar","-fx-font: 20 century; -fx-background-color: transparent;-fx-background-radius: 30;", 150, 60, 580, 438, 10, Color.AQUA);
        Text t= new Text(10,100,"OBJETIVO: TyperShark es un juego cuyo objetivo es que el usuario aprenda a utilizar todos sus\n"
                + "dedos para tipiar.\n\n"
                + "ACERCA DE: El juego consiste de un buceador el cual ira descendiendo en el mar.\n"
                + "A medida que descendiende \n"
                + "apareceran diferentes tipos de animales marinos como tiburones, piranas y tiburones negros.\n"
                + "Los tiburones tendran una palabra, las piranas un caracter y los tiburones negros pueden contener\n"
                + "2 o 3 palabaras seleccionadas aleatoriamente\n\n"
                + "COMO JUGAR: A medida que los animales marinos salgan el jugador debera tipiar la o\n"
                + "las palabras o caracteres que salgan en cada uno.\n"
                + "A medida que avanze descendiendo el buceador, el nivel de velocidad de los animales aumentara\n\n"
                + "PUNTAJE:El jugador gana puntos:\n"
                + "\t\t\tPor cada tiburon que mate el jugador obtendra 3 puntos\n"
                + "\t\t\tPor cada pirana que mate 2 puntos\n"
                + "\t\t\tPor cada tiburon negro 5 puntos\n"
                + "\t\t\tA medida que descienda en el mar\n\n"
                + "VIDAS: Al comenzar el juego el jugador tendra 3 vidas las cuales las puede perder si:\n"
                + "\t\t\tSi un tiburon o tiburon negro toca al buceador o al cabo que lo sostiene pierde 1 vida\n"
                + "\t\t\tSi las piranas ya han tocado 3 veces al buceador o a su cabo pierde 1 vida\n\n"
                + "BONO: Si el jugador ya ha acumulado 50 puntos o mas podra matar a un combo marino dando ENTER.\n"
                + "Este combo marino incluye todos los animales marinos que se encuentren en ese momento a su alrededor.\n"
                + "Perdera la mitad de sus puntos y luego se le asignaran mas puntos por cada animal matado");
        t.setFill(Color.WHITE);
        t.setStyle("-fx-font: 12 century;");
        
        windowReglas.getChildren().addAll(vi);
        windowReglas.getChildren().addAll(titulo1.getL(),titulo2.getL(),t,regreso.getBtn());
        regreso.getBtn().setOnAction(new regresar());
        
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public ImageView getVi() {
        return vi;
    }

    public void setVi(ImageView vi) {
        this.vi = vi;
    }

    
    private class regresar implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            Stage s= new Stage();
            TyperSharkApp ts= new TyperSharkApp();
            s.setResizable(false);
            ts.start(s);
        }
    }
    public Pane getWindowReglas() {
        return windowReglas;
    }
    
    public void setWindowReglas(Pane windowReglas) {
        this.windowReglas = windowReglas;
    }
    
}
