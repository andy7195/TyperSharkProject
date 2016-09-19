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
    private ArrayList<String> listaPalabras,listaPalabrasPulpo;
    private String[] abecedario;
    private boolean conEndAn;
    
    public JuegoAnimales(Queue<AnimalesMarinos> animales, Buceador jugador, Pane pane, String nombreArchivo,String nombreArchivoPulpo,boolean con)
    {
        this.animalesAlmacenados = animales;
        this.animalesEnJuego = new ArrayList<>();
        this.buzo = jugador;
        this.pane = pane;
        this.listaPalabras = new ArrayList<>();
        this.listaPalabrasPulpo= new ArrayList<>();
        this.abecedario = new String[]{"a", "b","c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        this.conEndAn= con;
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
        try
        {
            FileReader frP = new FileReader(nombreArchivoPulpo);
            BufferedReader brP = new BufferedReader(frP);
            while((cadena = brP.readLine()) != null)
            {
                this.listaPalabrasPulpo.add(cadena);
            }
            brP.close();
        }
        catch(FileNotFoundException fnfeP)
        {
            fnfeP.printStackTrace();
        }
        catch(IOException ioeP)
        {
            ioeP.printStackTrace();
        }
    }
    
    public void run()
    {
        try
        {
            while ((this.buzo.getVidas() > 0) && (conEndAn== false))
            {
                if(this.animalesAlmacenados.isEmpty())
                {
                    for (int i = 0; i < 4*(this.buzo.getNivel()+1); i++)
                    {
                        Random rand = new Random();
                        int op = rand.nextInt(4);
                        switch (op)
                        {
                            case 0:
                            {
                                animal = new Tiburon("Shark.png",this.listaPalabras.get(rand.nextInt(205)), this.buzo, animalesAlmacenados,conEndAn);
                                animalesAlmacenados.add(animal);

                                break;
                            }
                            case 1:
                            {
                                animal = new TiburonNegro("BlackShark.png", this.listaPalabras.get(rand.nextInt(205)),this.listaPalabras.get(rand.nextInt(205)), this.buzo, animalesAlmacenados,conEndAn);
                                animalesAlmacenados.add(animal);
                                break;
                            }
                            case 2:
                            {
                                animal = new Piranha("Piranha.png", this.abecedario[rand.nextInt(24)], this.buzo, this.animalesAlmacenados,conEndAn);
                                animalesAlmacenados.add(animal);
                                break;
                            }
                            case 3:
                            {
                                
                                animal = new Pulpo("Pulpo.png", this.listaPalabrasPulpo.get(rand.nextInt(this.listaPalabrasPulpo.size())), this.buzo, this.animalesAlmacenados,conEndAn);
                                animalesAlmacenados.add(animal);
                                break;
                            }
                        }
                        
                    }
                    //this.buzo.setNivel(this.buzo.getNivel() + 1);
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
                                
                                //for(int i = 0; i < (animalesAlmacenados.size()); i++)
                                
                                
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
                        }
                        catch(ArrayIndexOutOfBoundsException ex)
                        {
                            Logger.getLogger(JuegoAnimales.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                
                Thread.sleep(1000);
            }
            System.out.println("SE MUEREN");
        }
        catch (InterruptedException ex) 
        {
            Logger.getLogger(JuegoAnimales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Queue<AnimalesMarinos> getAnimalesAlmacenados() {
        return animalesAlmacenados;
    }

    public void setAnimalesAlmacenados(Queue<AnimalesMarinos> animalesAlmacenados) {
        this.animalesAlmacenados = animalesAlmacenados;
    }

    public ArrayList<AnimalesMarinos> getAnimalesEnJuego() {
        return animalesEnJuego;
    }

    public void setAnimalesEnJuego(ArrayList<AnimalesMarinos> animalesEnJuego) {
        this.animalesEnJuego = animalesEnJuego;
    }

    public Buceador getBuzo() {
        return buzo;
    }

    public void setBuzo(Buceador buzo) {
        this.buzo = buzo;
    }

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public AnimalesMarinos getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalesMarinos animal) {
        this.animal = animal;
    }

    public ArrayList<String> getListaPalabras() {
        return listaPalabras;
    }

    public void setListaPalabras(ArrayList<String> listaPalabras) {
        this.listaPalabras = listaPalabras;
    }

    public String[] getAbecedario() {
        return abecedario;
    }

    public void setAbecedario(String[] abecedario) {
        this.abecedario = abecedario;
    }
}
