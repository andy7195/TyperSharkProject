/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typersharkapp;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author Andy
 */
public class Boton {
    private Button btn;
    
    public Boton(String nombre, String estilo, double ancho, double alto, double posX, double posY,double borde, Color color)
    {
       btn = new Button(nombre);
       btn.setPrefSize(ancho, alto);
       btn.setLayoutX(posX);
       btn.setLayoutY(posY);
       btn.setStyle(estilo);
       btn.setOpacity(borde);
       btn.setTextFill(color);
       btn.addEventHandler(MouseEvent.MOUSE_MOVED, new MouseHandlerMove());
       btn.addEventHandler(MouseEvent.MOUSE_EXITED, new MouseHandlerExited());
    
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
    
    private class MouseHandlerMove implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent event) {
            btn.setTextFill(Color.DARKSALMON);
         }
    }
    
    private class MouseHandlerExited implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent event) {
            btn.setTextFill(Color.AQUA);
        }
    }
    
 
}
