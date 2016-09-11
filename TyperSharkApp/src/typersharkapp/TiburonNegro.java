package typersharkapp;


import java.util.ArrayList;
import java.util.Queue;
import javafx.application.Platform;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


public class TiburonNegro extends AnimalesMarinos //implements Runnable
{
    private String palabra1,palabra2 ;
    private int numroAlt;
    private Buceador buzo;
    private Queue<AnimalesMarinos> animales;
    
    
    public TiburonNegro(String nombreImagen,String palabra1,String palabra2, Buceador jugador, Queue<AnimalesMarinos> animalesz)//[]) 
    {
        super(nombreImagen, palabra1,palabra2, 3);
        System.out.println(palabra2);
        
        this.palabra1 = palabra1;
        this.palabra2 = palabra2;
        this.buzo = jugador;
        this.animales = animales;
    }

    
    @Override
    public void run() 
    {
         try 
        {
            while(this.getPosicionX() > 50 && !(this.getPalabra().isEmpty() && this.getPalabra2().isEmpty() ) && this.buzo.getVidas() > 0 && this.getBandera() == 0)
            {
            
                this.setPosicionX(this.getPosicionX() - 1);
                //System.out.println(getPalabra() + palabra2 );
                Platform.runLater(new Runnable() 
                {
                    @Override
                    public void run() 
                    { 
                        TiburonNegro.this.getFigura().setLayoutX(TiburonNegro.this.getPosicionX());
                        if(getPalabra().isEmpty()){
                            System.out.println("sadf");


                                texto.setVisible(false);
                                texto2.setVisible(true);
                                setPalabra(palabra2);
                                setPalabra2("");
                            }
                  
                        }
                });
                


                Thread.sleep(this.getVelocidad()*10/buzo.getNivel()); 
            }
            TiburonNegro.this.getFigura().setVisible(false);
            //this.setIterator(0);
            
            if(this.getPosicionX() <= 50)
            {
                this.buzo.setVidas(this.buzo.getVidas() - 0);
                this.buzo.setPuntaje(this.buzo.getPuntaje() + 100);
                this.buzo.setPoder(this.buzo.getPoder() + 100);
            }
            
            else if (this.getPalabra().isEmpty())
            {
                this.buzo.setPuntaje(this.buzo.getPuntaje() + 100);
                this.buzo.setPoder(this.buzo.getPoder() + 100);
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

    public String getPalabra1() {
        return palabra1;
    }

    public void setPalabra1(String palabra1) {
        this.palabra1 = palabra1;
    }

    public String getPalabra2() {
        return palabra2;
    }

    public void setPalabra2(String palabra2) {
        this.palabra2 = palabra2;
    }


    
    
}
