/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;


import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Andy
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

    public Label getL() {
        return l;
    }

}
