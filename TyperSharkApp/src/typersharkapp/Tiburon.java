package typersharkapp;

import java.util.Queue;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;


public class Tiburon extends AnimalesMarinos //implements Runnable
{
    private String palabra;
    private int iterator;
    private Buceador buzo;
    Queue<AnimalesMarinos> animales;

    public Tiburon(String nombreImagen, String palabra, Buceador jugador, Queue<AnimalesMarinos> animales) 
    {
        super(nombreImagen, palabra, 2);
        
        this.palabra = palabra;
        this.iterator = 0;
        this.buzo = jugador;
        this.animales = animales;
    }

    
    @Override
    public void run() 
    {
         try 
        {
            while(this.getPosicionX() > 50 && this.iterator < this.palabra.length())
            {
                this.setPosicionX(this.getPosicionX() - 1);
                
                Platform.runLater(new Runnable() 
                {
                    @Override
                    public void run() 
                    { 
                        Tiburon.this.getFigura().setLayoutX(Tiburon.this.getPosicionX());  
                    }
                });

                Thread.sleep(this.getVelocidad()*10); 
            }
            Tiburon.this.getFigura().setVisible(false);
            this.iterator = 0;
            
            if(this.getPosicionX() <= 50)
            {
                this.buzo.setVidas(this.buzo.getVidas() - 1);
            }
            else if (this.iterator == this.palabra.length())
            {
                this.buzo.setPuntaje(this.buzo.getPuntaje() + 2);
                //this.animales.remove();
                //this.animales.poll();
            }
        }
        catch(Exception ex)
        {
                System.out.println("Error");
                ex.printStackTrace();
        }  
    }
    
    private class KeyHandler implements EventHandler<KeyEvent>
    {
        
        @Override
        public void handle(KeyEvent event)
        {
            if(Tiburon.this.palabra.charAt(iterator)== event.getCode().toString().charAt(0))
            {
                iterator++;
            }
        }
     }
    
    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
}