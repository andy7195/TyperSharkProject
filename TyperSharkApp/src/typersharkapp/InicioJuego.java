package typersharkapp;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyEvent;

public class InicioJuego 
{
    private Pane juego;
    private Image fondo;
    private ImageView iv;
    private Boton regresar;
    private KeyHandler teclado;
    
    public InicioJuego()
    {
        teclado = new KeyHandler();
        juego = new Pane();
        regresar = new Boton("Regresar","-fx-font: 20 century; -fx-background-color: transparent;-fx-background-radius: 30;", 150, 60, 580, 438, 10, Color.AQUA);
        try{
            fondo = new Image("FondoJuego.jpg");
            
        }
        catch(Exception e)
        {
            System.out.println("No lee imagen");
        }
        iv = new ImageView(fondo);
        iv.setFitHeight(360);
        iv.setFitWidth(640);
        iv.setImage (fondo);
        
        juego.getChildren().addAll(iv, regresar.getBtn());
        
        
    }

    
    private class KeyHandler implements EventHandler<KeyEvent>
    {
        public void handle(KeyEvent event)
        {
            
        }
    }

    public KeyHandler getTeclado() {
        return teclado;
    }
    
    
    
    
    
    
    public Pane getPaneJuego() {
        return juego;
    }

    public Image getFondo() {
        return fondo;
    }

    public ImageView getIv() {
        return iv;
    }

    public Boton getRegresar() {
        return regresar;
    }
    
    
    
    
}
