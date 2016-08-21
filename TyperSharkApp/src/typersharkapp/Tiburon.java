package typersharkapp;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Tiburon extends AnimalesMarinos
{
    private String palabra;
    private Image tiburon;
    private ImageView iv;

    public Tiburon(Pane pane, int velocidad, String palabra) 
    {
        super();
        
        try{
            tiburon = new Image("Shark.png");
            
        }
        catch(Exception e)
        {
            System.out.println("No lee imagen");
        }
        
        iv = new ImageView(tiburon);
        iv.setFitHeight(50);
        iv.setFitWidth(130);
        
        this.palabra = palabra;
        this.generarPosicion();
        this.setVelocidad(velocidad);
        
        iv.setLayoutX(this.getPosicionX());
        iv.setLayoutY(this.getPosicionY());
        
        pane.getChildren().add(iv);
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public Image getTiburon() {
        return tiburon;
    }

    public void setTiburon(Image tiburon) {
        this.tiburon = tiburon;
    }

    public ImageView getIv() {
        return iv;
    }

    public void setIv(ImageView iv) {
        this.iv = iv;
    }

      
    
    @Override
    public void moverse() 
    {
        this.setPosicionX(this.getPosicionX() - 1);
        this.iv.setLayoutX(this.getPosicionX());
    }

    @Override
    public void atacar() 
    {
        
    }
    
    
    
    
}
