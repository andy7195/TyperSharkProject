package typersharkapp;

import java.util.Queue;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;


public class Tiburon extends AnimalesMarinos //implements Runnable
{
    private String palabra;
    private Buceador buzo;
    private Queue<AnimalesMarinos> animales;
    private int bandera;

    public Tiburon(String nombreImagen, String palabra, Buceador jugador, Queue<AnimalesMarinos> animales) 
    {
        super(nombreImagen, palabra, 2);
        
        this.palabra = palabra;
        this.buzo = jugador;
        this.animales = animales;
    }

    
    @Override
    public void run() 
    {
         try 
        {
            while(this.getPosicionX() > 50 && this.getIterator() < this.palabra.length() && this.buzo.getVidas() > 0 && this.getBandera() == 0)
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
            //this.setIterator(0);
            
            if(this.getPosicionX() <= 50)
            {
                this.buzo.setVidas(this.buzo.getVidas() - 0);
                this.buzo.setPuntaje(this.buzo.getPuntaje() + 50);
                this.buzo.setPoder(this.buzo.getPoder() + 50);
            }
            else if (this.getIterator() == this.palabra.length())
            {
                this.buzo.setPuntaje(this.buzo.getPuntaje() + 50);
                this.buzo.setPoder(this.buzo.getPoder() + 50);
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
    
    /*private class KeyHandler implements EventHandler<KeyEvent>
    {
        
        @Override
        public void handle(KeyEvent event)
        {
            if(Tiburon.this.palabra.charAt(iterator)== event.getCode().toString().charAt(0))
            {
                iterator++;
            }
        }
     }*/
    
    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
}