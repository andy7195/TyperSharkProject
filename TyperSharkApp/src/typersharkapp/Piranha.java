package typersharkapp;

import java.util.Queue;
import javafx.application.Platform;


public class Piranha extends AnimalesMarinos //implements Runnable
{
    private String caracter;
    private int iterator;
    private Buceador buzo;
    Queue<AnimalesMarinos> animales;

    public Piranha(String nombreImagen, String letra, Buceador jugador, Queue<AnimalesMarinos> animales) 
    {
        super(nombreImagen, letra, 1);
        
        this.caracter = letra;
        this.iterator = 0;
        this.buzo = jugador;
        this.animales = animales;
    }

    
    @Override
    public void run() 
    {
         try 
        {
            while(this.getPosicionX() > 50 && this.iterator < this.caracter.length())
            {
            
                this.setPosicionX(this.getPosicionX() - 1);
                
                Platform.runLater(new Runnable() 
                {
                    @Override
                    public void run() 
                    { 
                        Piranha.this.getFigura().setLayoutX(Piranha.this.getPosicionX());
                    }
                });

                Thread.sleep(this.getVelocidad()*10); 
            }
            Piranha.this.getFigura().setVisible(false);
            this.iterator = 0;
            
            if(this.getPosicionX() <= 50)
            {
                this.buzo.setNumPiranhas(this.buzo.getNumPiranhas() + 1);
                if(this.buzo.getNumPiranhas() == 3)
                {
                    this.buzo.setNumPiranhas(0);
                    this.buzo.setVidas(this.buzo.getVidas() - 1);
                }
            }
            else if (this.iterator == 1)
            {
                this.buzo.setPuntaje(this.buzo.getPuntaje() + 1);
                //this.animales.remove();
            }
        }
        catch(Exception ex)
        {
                System.out.println("Error");
                ex.printStackTrace();
        }
    }
    
    
    public int getIterator() {
        return iterator;
    }

    public void setIterator(int iterator) {
        this.iterator = iterator;
    }
    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }
}