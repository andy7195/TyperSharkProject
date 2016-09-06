/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    public Reglas() {
        windowReglas= new Pane();
        windowReglas.setStyle("-fx-background-color: aqua;");
        TitulosLabel titulo1= new TitulosLabel("REGLAS","-fx-font: 20 ravie",150,10,300,10, Color.BLUE);
        TitulosLabel titulo2= new TitulosLabel("TYPERSHARK","-fx-font: 20 ravie;",210,10,260,40, Color.BLUE);
        Boton regreso= new Boton("Regresar","-fx-font: 12 ravie; -fx-base: #79ABFA;-fx-background-radius: 30;", 100, 60, 580, 438, 10, Color.BLACK);
        Text t= new Text(10,100,"OBJETIVO: TyperShark es un juego cuyo objetivo es que el usuario aprenda a utilizar todos sus\n"
                + "dedos para tipiar.\n\n"
                + "ACERCA DE: El juego consiste de un buceador el cual ira descendiendo en el mar.\n"
                + "A medida que descendiende \n"
                + "apareceran diferentes tipos de animales marinos como tiburones, piranas y tiburones negros.\n"
                + "Los tiburones tendran una palabra, las piranas un caracter y los tiburones negros pueden contener\n"
                + "2 o 3 palabaras\n"
                + "seleccionadas aleatoriamente\n\n"
                + "COMO JUGAR: A medida que los animales marinos salgan el jugador debera tipiar la o\n"
                + "las palabras o caracteres que salgan en cada uno.\n"
                + "A medida que avanze descendiendo el buceador, el nivel de velocidad\n"
                + "de los animales aumentara\n\n"
                + "PUNTAJE:El jugador gana puntos:\n"
                + "\t\t\tPor cada tiburon que mate el jugador obtendra 3 puntos\n"
                + "\t\t\tPor cada pirana que mate 2 puntos\n"
                + "\t\t\tPor cada tiburon negro 5 puntos\n"
                + "\t\t\tA medida que descienda en el mar\n\n"
                + "VIDAS: Al comenzar el juego el jugador tendra 3 vidas las cuales las puede perder si:\n"
                + "\t\t\tSi un tiburon o tiburon negro toca al buceador o al cabo que lo sostiene pierde 1 vida\n"
                + "\t\t\tSi las piranas ya han tocado 3 veces al buceador o a su cabo pierde 1 vida\n\n"
                + "BONO: Si el jugador ya ha acumulado 50 puntos o mas podra matar a un combo marino dando ENTER.\n"
                + "Este combo marino incluye todos los animales marinos que se encuentren\n"
                + "en ese momento a su alrededor.\n"
                + "Perdera la mitad de sus puntos y luego se le asignaran mas por cada animal matado");
        t.setFill(Color.BLACK);
        t.setStyle("-fx-font: 10 ravie;");
        
        windowReglas.getChildren().addAll(titulo1.getL(),titulo2.getL(),t,regreso.getBtn());
        regreso.getBtn().setOnAction(new regresar());
    }

    private class regresar implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e){
            Stage s= new Stage();
            TyperShark ts= new TyperShark();
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
