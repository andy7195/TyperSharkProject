package typersharkapp;


import java.util.Queue;
import javafx.application.Platform;

/**
 * Una clase para representar al tiburon negro del juego.
 * @version 1.0
 * @author Dennise Guizado
 * @author Edward Pino
 * @author Xavier Pesantes
 */
public class TiburonNegro extends AnimalesMarinos //implements Runnable
{
    private String palabra1,palabra2 ;
    private int numroAlt;
    private Buceador buzo;
    private Queue<AnimalesMarinos> animales;
    private boolean conEndTN;
    
    
    public TiburonNegro(String nombreImagen,String palabra1,String palabra2, Buceador jugador, Queue<AnimalesMarinos> animalesz,boolean conEnd) 
    {
        super(nombreImagen, palabra1,palabra2, 3);
        System.out.println(palabra2);
        
        this.palabra1 = palabra1;
        this.palabra2 = palabra2;
        this.buzo = jugador;
        this.animales = animales;
        this.conEndTN= conEnd;
    }

    
    @Override
    public void run() 
    {
         try 
        {
            while(this.getPosicionX() > 50 && !(this.getPalabra().isEmpty() && this.getPalabra2().isEmpty() ) && this.buzo.getVidas() > 0 && this.getBandera() == 0 && conEndTN == false)
            {
            
                this.setPosicionX(this.getPosicionX() - 1);
                
                Platform.runLater(new Runnable() 
                {
                    @Override
                    public void run() 
                    { 
                        TiburonNegro.this.getFigura().setLayoutX(TiburonNegro.this.getPosicionX());
                        if(getPalabra().isEmpty()){
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
            
            
            if(this.getPosicionX() <= 50)
            {
                this.buzo.setVidas(this.buzo.getVidas() - 1);
            }
            
            else if (this.getPalabra().isEmpty())
            {
                this.buzo.setPuntaje(this.buzo.getPuntaje() + 100);
                this.buzo.setPoder(this.buzo.getPoder() + 100);
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
     * Método que devuelve el numero aleatorio de la cantidad de palabras que tendra le tiburon negro;
     * @return int
     */
    public int getNumroAlt() {
        return numroAlt;
    }

    /**
     * Método que modifica el numero aleatorio de la cantidad de palabras que tendra le tiburon negro;
     * @param numroAlt de tipo int que representa el numero aleatorio de la cantidad de palabras que tendra le tiburon negro;
     */
    public void setNumroAlt(int numroAlt) {
        this.numroAlt = numroAlt;
    }

    /**
     * Método que devuelve la palabra 1 del tiburon negro.
     * @return palabra1
     */
    public String getPalabra1() {
        return palabra1;
    }

    /**
     * Método que modifica la palabra 1 del tiburon negro.
     * @param palabra1 de tipo String que representa la palabra 1 del tiburon negro.
     */
    public void setPalabra1(String palabra1) {
        this.palabra1 = palabra1;
    }

    /**
     * Método que devuelve la palabra 2 del tiburon negro.
     * @return palabra2
     */
    public String getPalabra2() {
        return palabra2;
    }

    /**
     * Método que modifica la palabra 2 del tiburon negro.
     * @param palabra2 de tipo String que representa la palabra 2 del tiburon negro.
     */
    public void setPalabra2(String palabra2) {
        this.palabra2 = palabra2;
    }


    
    
}
