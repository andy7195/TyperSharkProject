/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typersharkapp;


import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 * Una clase para representar los labels del juego
 * @version 1.0
 * @author Dennise Guizado
 * @author Edward Pino
 * @author Xavier Pesantes
 */
public class TitulosLabel {
    private Label l;
      public TitulosLabel(String nombre, String estilo, double ancho, double alto, double posX, double posY, Color color)
    {
       l = new Label(nombre);
       l.setPrefSize(ancho, alto);
       l.setLayoutX(posX);
       l.setLayoutY(posY);
       l.setStyle(estilo);
       l.setTextFill(color);
       
    }

    /**
     * Método que devuelve el label.
     * @return l
     */
    public Label getL() {
        return l;
    }

    /**
     * Método que modifica el label.
     * @param l de tipo Label que representa el label
     */
    public void setL(Label l) {
        this.l = l;
    }
    
    
}