package typersharkapp;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyEvent;


public class InicioJuego 
{
    private Pane juego;
    private Image fondo;
    private ImageView iv;
    private KeyHandler teclado;
    private Buceador jugador;
    
    public InicioJuego()
    {
        teclado = new KeyHandler();
        juego = new Pane();
        jugador= new Buceador();
        try{
            fondo = new Image("FondoJuego.jpg");
            
        }
        catch(Exception e)
        {
            System.out.println("No lee imagen");
        }
        iv = new ImageView(fondo);
        iv.setFitHeight(510);
        iv.setFitWidth(710);
        iv.setImage (fondo);
        
        juego.getChildren().addAll(iv);
        
       
    }

   
    private class KeyHandler implements EventHandler<KeyEvent>
    {
        @Override
        public void handle(KeyEvent event)
        {
            switch(event.getCode())
            {
                case ENTER:
                {
                    if(jugador.getPuntaje()<=50){
                        System.out.println("No puedo usar poder especial");
                        break;
                    }
                    else{
                        jugador.setPuntaje(jugador.getPuntaje()/2);
                        break;
                    }
                  
                }        
                default:  {
                    break;
                }      
            }
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
       
}
