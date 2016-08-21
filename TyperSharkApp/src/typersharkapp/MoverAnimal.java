package typersharkapp;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

public class MoverAnimal implements Runnable
{
    private AnimalesMarinos animal; 
    
    public MoverAnimal(AnimalesMarinos a)
    {
        this.animal = a;
    }
    
    @Override
    public void run() 
    {
        while(this.animal.getPosicionX() != 50)
        {
            this.animal.moverse();
            
            Platform.runLater(new Runnable() 
            {
                @Override
                public void run() 
                {
                    animal.setPosicionX(animal.getPosicionX());
                }
            });
            try 
            {
                Thread.sleep(animal.getVelocidad()*10);
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(MoverAnimal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
}
