package typersharkapp;


import java.util.ArrayList;
import java.util.Queue;
import javafx.application.Platform;


public class TiburonNegro extends AnimalesMarinos //implements Runnable
{
    private ArrayList<String> palabras;
    private int numroAlt;
    private int iterator;
    private Buceador buzo;
    Queue<AnimalesMarinos> animales;
    
    
    public TiburonNegro(String nombreImagen, ArrayList<String> Palabras, Buceador jugador, Queue<AnimalesMarinos> animales)//[]) 
    {
        super(nombreImagen, Palabras.get(0), 3);
        
        this.palabras = Palabras;
        this.iterator = 0;
        this.buzo = jugador;
        this.animales = animales;
    }

    
    @Override
    public void run() 
    {
         try 
        {
            while(this.getPosicionX() > 50 && !this.palabras.isEmpty() && this.buzo.getVidas() > 0)
            {
            
                this.setPosicionX(this.getPosicionX() - 1);
                
                Platform.runLater(new Runnable() 
                {
                    @Override
                    public void run() 
                    { 
                        TiburonNegro.this.getFigura().setLayoutX(TiburonNegro.this.getPosicionX());
                    }
                });

                Thread.sleep(this.getVelocidad()*10); 
            }
            TiburonNegro.this.getFigura().setVisible(false);
            this.iterator = 0;
            
            if(this.getPosicionX() <= 50)
            {
                this.buzo.setVidas(this.buzo.getVidas() - 1);
            }
            else if (this.iterator == this.palabras.get(this.palabras.size()-1).length())
            {
                this.buzo.setPuntaje(this.buzo.getPuntaje() + 3);
                //this.animales.remove();
            }
        }
        catch(Exception ex)
        {
                System.out.println("Error");
                ex.printStackTrace();
        }
    }
    
    public int getNumroAlt() {
        return numroAlt;
    }

    public void setNumroAlt(int numroAlt) {
        this.numroAlt = numroAlt;
    }
    
    public int getIterator() {
        return iterator;
    }

    public void setIterator(int iterator) {
        this.iterator = iterator;
    }
    
    
}
