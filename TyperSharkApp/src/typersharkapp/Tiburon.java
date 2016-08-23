package typersharkapp;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.ALPHANUMERIC;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


public class Tiburon extends AnimalesMarinos //implements Runnable
{
    private String palabra;
    private Image tiburon;
    private ImageView iv;
    private Text texto;
    private TextFlow t;
    private KeyEvent event;

    public Tiburon(String palabra, KeyEvent ke) 
    {
        super();
        
        try{
            tiburon = new Image("Shark.png");
            
        }
        catch(Exception e)
        {
            System.out.println("No lee imagen");
        }
        
        this.palabra = palabra;
        this.event = ke;
        
        this.iv = new ImageView(tiburon);
        this.iv.setFitHeight(50);
        this.iv.setFitWidth(130);
        
        this.texto = new Text(130, 50, palabra);
        this.texto.setFill(Color.GREENYELLOW);
        this.texto.setStyle("-fx-font: 18 century;");
        
        this.t = new TextFlow(this.texto);
        this.t.setLayoutX(70);
        this.t.setLayoutY(10);
        
        
    }

    
    @Override
    public void run() 
    {
         try 
        {
            int i = 0;
            while(this.getPosicionX() > 50 && i < this.palabra.length())
            {
                
                if(Tiburon.this.palabra.charAt(i)== Tiburon.this.event.getCode().toString().charAt(0))
                {
                    i++;
                }
                
                this.setPosicionX(this.getPosicionX() - 1);
                
                Platform.runLater(new Runnable() 
                {
                    @Override
                    public void run() 
                    { 
                        Tiburon.this.getFigura().setLayoutX(Tiburon.this.getPosicionX());
                        
                    }
                });

                Thread.sleep(this.getVelocidad()*10); 
            }
            Tiburon.this.getFigura().setVisible(false);
        }
        catch(Exception ex)
        {
                System.out.println("Error");
                ex.printStackTrace();
        }  
    }

    public void adjuntarTiburon(Pane panel, int velocidad)
    {
        getFigura().getChildren().addAll(getIv(), getT());
        
        getFigura().setLayoutX(this.getPosicionX());
        getFigura().setLayoutY(this.getPosicionY());
        panel.getChildren().add(this.getFigura());
        
        this.setVelocidad(velocidad);
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

    public Text getTexto() {
        return texto;
    }

    public void setTexto(Text texto) {
        this.texto = texto;
    }

    public TextFlow getT() {
        return t;
    }

    public void setT(TextFlow t) {
        this.t = t;
    }
}