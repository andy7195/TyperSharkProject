package typersharkapp;

import java.util.Queue;
import javafx.application.Platform;

/**
 * Una clase para representar al tiburon del juego.
 * @version 1.0
 * @author Dennise Guizado
 * @author Edward Pino
 * @author Xavier Pesantes
 */
public class Tiburon extends AnimalesMarinos //implements Runnable
{
    private String palabra;
    private Buceador buzo;
    private Queue<AnimalesMarinos> animales;
    private int bandera;
    private boolean conEndT;

    public Tiburon(String nombreImagen, String palabra, Buceador jugador, Queue<AnimalesMarinos> animales,boolean conEnd) 
    {
        super(nombreImagen, palabra, 2);
        
        this.palabra = palabra;
        this.buzo = jugador;
        this.animales = animales;
        this.conEndT= conEnd;
    }

    
    @Override
    public void run() 
    {
         try 
        {
            while(this.getPosicionX() > 50 && !this.getPalabra().isEmpty() && this.buzo.getVidas() > 0 && this.getBandera() == 0 && conEndT== false)
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

                Thread.sleep(this.getVelocidad()*10/this.buzo.getNivel()); 
            }
            Tiburon.this.getFigura().setVisible(false);

            if(this.getPosicionX() <= 50)
            {
                this.buzo.setVidas(this.buzo.getVidas() - 1);

            }
            else if (this.getPalabra().isEmpty())
            {
                
                this.buzo.setPuntaje(this.buzo.getPuntaje() + 50);
                this.buzo.setPoder(this.buzo.getPoder() + 50);
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
    
    /**
     * Método que devuelve la palabra del tiburon.
     * @return String
     */
    public String getPalabra() {
        return palabra;
    }

    /**
     * Método que modifica la palabra del tiburon.
     * @param palabra de tipo String que representa la palabra del tiburon.
     */
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

}