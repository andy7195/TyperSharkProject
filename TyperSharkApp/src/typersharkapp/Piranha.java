package typersharkapp;

import java.util.Queue;
import javafx.application.Platform;


public class Piranha extends AnimalesMarinos //implements Runnable
{
    private String caracter;
    private int iterator;
    private Buceador buzo;
     private Queue<AnimalesMarinos> animales;

    public Piranha(String nombreImagen, String letra, Buceador jugador, Queue<AnimalesMarinos> animales) 
    {
        super(nombreImagen, letra, 1);
        
        this.caracter = letra;
        this.buzo = jugador;
        this.animales = animales;
    }

    
    @Override
    public void run() 
    {
         try 
        {
            while(this.getPosicionX() > 50 && this.getIterator() < this.caracter.length() && this.buzo.getVidas() > 0 && this.getBandera() == 0)
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
            //this.setIterator(0);
            
            if(this.getPosicionX() <= 50)
            {
                this.buzo.setNumPiranhas(this.buzo.getNumPiranhas() + 1);
                if(this.buzo.getNumPiranhas() == 3)
                {
                    this.buzo.setNumPiranhas(0);
                    this.buzo.setVidas(this.buzo.getVidas() - 1);
                    this.buzo.setPuntaje(this.buzo.getPuntaje() + 10);
                    this.buzo.setPoder(this.buzo.getPoder() + 10);
                }
            }
            else if (this.getIterator() == 1)
            {
                this.buzo.setPuntaje(this.buzo.getPuntaje() + 10);
                this.buzo.setPoder(this.buzo.getPoder() + 10);
                this.buzo.setCriaturasAsesinadas(this.buzo.getCriaturasAsesinadas() + 1);
            }
        }
        catch(Exception ex)
        {
                System.out.println("Error");
                ex.printStackTrace();
        }
    }
    
    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }
}