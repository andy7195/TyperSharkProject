/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typersharkapp;

/**
 *
 * @author Andy
 */
public class Jugador implements Comparable<Jugador>{
    private String nombre;
    private int puntaje;

    public Jugador(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public int compareTo(Jugador o) {
        if(this.puntaje> o.getPuntaje())
            return -1;
        else if (this.puntaje< o.getPuntaje())
            return 1;
        else
            return 0;
    }
    
    
}
