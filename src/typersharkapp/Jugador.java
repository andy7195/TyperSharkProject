/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typersharkapp;

/**
 * Una clase para representar un comparador de jugadores.
 * @version 1.0
 * @author Dennise Guizado
 * @author Edward Pino
 * @author Xavier Pesantes
 */
public class Jugador implements Comparable<Jugador>{
    private String nombre;
    private int puntaje;

    public Jugador(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }
    
    /**
     * Método que devuelve el nombre del comparador.
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que modifica  el nombre del comparador.
     * @param nombre de tipo String que representa el nombre del comparador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve el puntaje del comparador.
     * @return puntaje
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * Método que modifica el puntaje del comparador.
     * @param puntaje de tipo int que representa el puntaje del comparador.
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * Método que compara el puntaje de jugador y comparador.
     * @param o de tipo Jugador que representa el comparador del juego
     * @return -1 si es es mayor,1 si es menor y 0 si son iguales
     */
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
