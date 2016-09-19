/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typersharkapp;

import java.util.Queue;
import javafx.application.Platform;

/**
 *
 * @author COMPAQ
 */
public class Pulpo extends AnimalesMarinos {
    private String palabra;
    private Buceador buzo;
    private Queue<AnimalesMarinos> animales;
    private int bandera;
    private boolean conEndP;

    public Pulpo(String nombreImagen, String palabra,Buceador jugador,Queue<AnimalesMarinos> animales,boolean conEnd) {
        super(nombreImagen, palabra, 4);
        
        this.palabra = palabra;
        this.buzo = jugador;
        this.animales = animales;
        this.conEndP= conEnd;
    }
    
     @Override
    public void run() 
    {
         try 
        {
            while(this.getPosicionX() > 50 && !this.getPalabra().isEmpty() && this.buzo.getVidas() > 0 && this.getBandera() == 0 && conEndP==false)
            {
                this.setPosicionX(this.getPosicionX() - 1);
                
                Platform.runLater(new Runnable() 
                {
                    @Override
                    public void run() 
                    { 
                        Pulpo.this.getFigura().setLayoutX(Pulpo.this.getPosicionX());  
                    }
                });

                Thread.sleep(this.getVelocidad()*10/this.buzo.getNivel()); 
            }
            Pulpo.this.getFigura().setVisible(false);
            
            if(this.getPosicionX() <= 50)
            {
                this.buzo.setVidas(this.buzo.getVidas() - 1);
             
            }
            else if (this.getPalabra().isEmpty())
            {
                
                this.buzo.setPuntaje(this.buzo.getPuntaje() + 50);
                this.buzo.setPoder(this.buzo.getPoder() + 500);
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
  
    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public Buceador getBuzo() {
        return buzo;
    }

    public void setBuzo(Buceador buzo) {
        this.buzo = buzo;
    }

    public Queue<AnimalesMarinos> getAnimales() {
        return animales;
    }

    public void setAnimales(Queue<AnimalesMarinos> animales) {
        this.animales = animales;
    }

    public int getBandera() {
        return bandera;
    }

    public void setBandera(int bandera) {
        this.bandera = bandera;
    }

    public boolean isConEndP() {
        return conEndP;
    }

    public void setConEndP(boolean conEndP) {
        this.conEndP = conEndP;
    }
    
    
}
