
package typersharkapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.layout.Pane;


public class JuegoAnimales extends Thread
{
    private Queue<AnimalesMarinos> animalesAlmacenados;
    private ArrayList<AnimalesMarinos> animalesEnJuego;
    private Buceador buzo;
    private Pane pane;
    private AnimalesMarinos animal;
    private ArrayList<String> listaPalabras;
    private String[] abecedario;
    
    public JuegoAnimales(Queue<AnimalesMarinos> animales, Buceador jugador, Pane pane, String nombreArchivo)
    {
        this.animalesAlmacenados = animales;
        this.animalesEnJuego = new ArrayList<>();
        this.buzo = jugador;
        this.pane = pane;
        this.listaPalabras = new ArrayList<>();
        this.abecedario = new String[]{"a", "b","c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        
        String cadena;
        try
        {
            FileReader fr = new FileReader(nombreArchivo);
            BufferedReader br = new BufferedReader(fr);
            while((cadena = br.readLine()) != null)
            {
                this.listaPalabras.add(cadena);
            }
            br.close();
        }
        catch(FileNotFoundException fnfe)
        {
            fnfe.printStackTrace();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    
    public void run()
    {
        try
        {
            while (this.buzo.getVidas() > 0)
            {
                if(this.animalesAlmacenados.isEmpty())
                {
                    for (int i = 0; i < 4*(this.buzo.getNivel()+1); i++)
                    {
                        Random rand = new Random();
                        int op = rand.nextInt(3);
                        switch (op)
                        {
                            case 0:
                            {
                                animal = new Tiburon("Shark.png",this.listaPalabras.get(rand.nextInt(205)), this.buzo, animalesAlmacenados);
                                animalesAlmacenados.add(animal);

                                break;
                            }
                            case 1:
                            {
                                ArrayList<String> Palabras = new ArrayList<>();
                                //rand.nextInt(max - min + 1) + min
                                for (int j = 0; j < (rand.nextInt(2)+2); j++)
                                {
                                    Palabras.add(this.listaPalabras.get(rand.nextInt(205)));
                                }
                                animal = new TiburonNegro("BlackShark.png", Palabras, this.buzo, animalesAlmacenados);
                                animalesAlmacenados.add(animal);
                                break;
                            }
                            case 2:
                            {
                                animal = new Piranha("Piranha.png", this.abecedario[rand.nextInt(24)], this.buzo, this.animalesAlmacenados);
                                animalesAlmacenados.add(animal);
                                break;
                            }
                        }
                        
                    }
                    this.buzo.setNivel(this.buzo.getNivel() + 1);
                }
                
                Platform.runLater(new Runnable() 
                {
                    @Override
                    public void run() 
                    { 
                        try
                        {
                            if(animalesEnJuego.isEmpty())
                            {
                                animalesEnJuego.add(animalesAlmacenados.poll());
                                animalesEnJuego.add(animalesAlmacenados.poll());
                                animalesEnJuego.add(animalesAlmacenados.poll());
                                animalesEnJuego.add(animalesAlmacenados.poll());
                                
                                for(int i = 0; i < (animalesEnJuego.size()); i++)
                                {
                                    animalesEnJuego.get(i).adjuntarCriatura(pane);
                                    animalesEnJuego.get(i).start();
                                }
                            }
                            else if (!animalesEnJuego.get(0).isAlive() && !animalesEnJuego.get(1).isAlive() && !animalesEnJuego.get(2).isAlive() && !animalesEnJuego.get(3).isAlive())
                            {
                                animalesEnJuego.clear();
                            }
                            
                            
                           /* if(!animal.isAlive())
                            {
                                if (animales.peek() instanceof Tiburon)
                                {
                                    for(int i = 0; i <= buzo.getNivel(); i++)
                                    {
                                        Tiburon t = (Tiburon)animales.peek();
                                        t.adjuntarTiburon(pane, 2);
                                        t.start();
                                        Thread.sleep(5000);
                                    }
                                }
                                else if (animales.peek() instanceof TiburonNegro)
                                {
                                    for(int i = 0; i <= buzo.getNivel(); i++)
                                    {
                                        TiburonNegro t = (TiburonNegro)animales.peek();
                                        t.adjuntarTiburonNegro(pane, 3);
                                        t.start();
                                        Thread.sleep(5000);
                                    }

                                }
                                if (animales.peek() instanceof Piranha)
                                {
                                    for(int i = 0; i <= buzo.getNivel(); i++)
                                    {
                                        Piranha t = (Piranha)animales.peek();
                                        t.adjuntarPiranha(pane, 1);
                                        t.start();
                                        Thread.sleep(3000);
                                    }

                                }
                            }*/
                        }
                        catch(Exception ex)
                        {
                            Logger.getLogger(JuegoAnimales.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                
                Thread.sleep(10000/this.buzo.getNivel());    
            }
        }
        catch (InterruptedException ex) 
        {
            Logger.getLogger(JuegoAnimales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
