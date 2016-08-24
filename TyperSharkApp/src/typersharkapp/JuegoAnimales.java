
package typersharkapp;

import java.util.Queue;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.layout.Pane;


public class JuegoAnimales extends Thread
{
    private Queue animales;
    private Buceador buzo;
    private Pane pane;
    private AnimalesMarinos animal;
    
    public JuegoAnimales(Queue animales, Buceador jugador, Pane pane)
    {
        this.animales = animales;
        this.buzo = jugador;
        this.pane = pane;
    }
    
    public void run()
    {
        try
        {
            while (this.buzo.getVidas() > 0)
            {
                if(this.animales.isEmpty() )//< this.buzo.getNivel()*3)
                {
                    Random rand = new Random();
                    int op = rand.nextInt(2);
                    switch (op)
                    {
                        case 0:
                        {
                            for(int i = 0; i <= this.buzo.getNivel(); i++)
                            {
                                animal = new Tiburon("HOLA", this.buzo);
                                animales.add(animal);
                            }
                            break;
                        }
                        case 1:
                        {
                            for(int i = 0; i <= this.buzo.getNivel(); i++)
                            {
                                animal = new TiburonNegro("MUNDO", this.buzo);
                                animales.add(animal);
                            }
                            break;
                        }
                        case 2:
                        {
                            for(int i = 0; i <= this.buzo.getNivel(); i++)
                            {
                                animal = new Piranha("S", this.buzo);
                                animales.add(animal);
                            }
                            break;
                        }
                    }
                }

                Platform.runLater(new Runnable() 
                {
                    @Override
                    public void run() 
                    { 
                        try
                        {
                            if(!animal.isAlive())
                            {
                                if (animales.peek() instanceof Tiburon)
                                {
                                    for(int i = 0; i <= buzo.getNivel(); i++)
                                    {
                                        Tiburon t = (Tiburon)animales.poll();
                                        t.adjuntarTiburon(pane, 2);
                                        t.start();
                                        Thread.sleep(5000);
                                    }
                                }
                                else if (animales.peek() instanceof TiburonNegro)
                                {
                                    for(int i = 0; i <= buzo.getNivel(); i++)
                                    {
                                        TiburonNegro t = (TiburonNegro)animales.poll();
                                        t.adjuntarTiburonNegro(pane, 3);
                                        t.start();
                                        Thread.sleep(5000);
                                    }

                                }
                                if (animales.peek() instanceof Piranha)
                                {
                                    for(int i = 0; i <= buzo.getNivel(); i++)
                                    {
                                        Piranha t = (Piranha)animales.poll();
                                        t.adjuntarPiranha(pane, 1);
                                        t.start();
                                        Thread.sleep(3000);
                                    }

                                }
                            }
                        }
                        catch(InterruptedException ex)
                        {
                            Logger.getLogger(JuegoAnimales.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                
                Thread.sleep(10000/this.buzo.getNivel());    
            }
        }catch (InterruptedException ex) 
        {
            Logger.getLogger(JuegoAnimales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
