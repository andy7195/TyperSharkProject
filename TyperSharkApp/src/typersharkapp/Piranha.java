package typersharkapp;

import java.util.Queue;
import javafx.application.Platform;


public class Piranha extends AnimalesMarinos //implements Runnable
{
    private String caracter;
    private int iterator;
    private Buceador buzo;
     private Queue<AnimalesMarinos> animales;
    private boolean conEndPi;

    public Piranha(String nombreImagen, String letra, Buceador jugador, Queue<AnimalesMarinos> animales, boolean conEnd) 
    {
        super(nombreImagen, letra, 1);
        
        this.caracter = letra;
        this.buzo = jugador;
        this.animales = animales;
        this.conEndPi= conEnd;
    }

    
    @Override
    public void run() 
    {
         try 
        {
            while(this.getPosicionX() > 50 && !this.getPalabra().isEmpty() && this.buzo.getVidas() > 0 && this.getBandera() == 0 && conEndPi == false)
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

            if(this.getPosicionX() <= 50)
            {
                this.buzo.setNumPiranhas(this.buzo.getNumPiranhas() + 1);
                if(this.buzo.getNumPiranhas() == 3)
                {
                    this.buzo.setNumPiranhas(0);
                    this.buzo.setVidas(this.buzo.getVidas() - 1);
                }
            }
            else if (this.getPalabra().isEmpty())
            {
                this.buzo.setPuntaje(this.buzo.getPuntaje() + 10);
                this.buzo.setPoder(this.buzo.getPoder() + 10);
                this.buzo.setCriaturasAsesinadas(this.buzo.getCriaturasAsesinadas() + 1);
                System.out.println("Criaturas Asesinadas: "+this.buzo.getCriaturasAsesinadas());
                
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