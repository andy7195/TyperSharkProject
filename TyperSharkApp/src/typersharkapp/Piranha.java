package typersharkapp;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


public class Piranha extends AnimalesMarinos //implements Runnable
{
    private char caracter;
    private Image piranha;
    private ImageView iv;
    private Text texto;
    private TextFlow t;

    public Piranha(char letra) 
    {
        super();
        try{
            piranha = new Image("Piranha.png");
            
        }
        catch(Exception e)
        {
            System.out.println("No lee imagen");
        }
        
        this.iv = new ImageView(piranha);
        this.iv.setFitHeight(25);
        this.iv.setFitWidth(50);
        
        this.texto = new Text(130, 50, "S");
        this.texto.setFill(Color.LIGHTCYAN);
        this.texto.setStyle("-fx-font: 18 century;");
        
        this.t = new TextFlow(this.texto);
        this.t.setLayoutX(15);
        this.t.setLayoutY(0);
        
        this.caracter = letra;
    }

    
    @Override
    public void run() 
    {
         try 
        {
            while(this.getPosicionX() != 50)
            {
            
                this.setPosicionX(this.getPosicionX() - 1);
                
                Platform.runLater(new Runnable() 
                {
                    @Override
                    public void run() 
                    { 
                        Piranha.this.getFigura().setLayoutX(Piranha.this.getPosicionX());
                    }
                });

                Thread.sleep(this.getVelocidad()*10); 
            }
            Piranha.this.getFigura().setVisible(false);
        }
        catch(Exception ex)
        {
                System.out.println("Error");
                ex.printStackTrace();
        }
    }

    public void adjuntarPiranha(Pane panel, int velocidad)
    {
        getFigura().getChildren().addAll(getIv(), getT());
        
        getFigura().setLayoutX(this.getPosicionX());
        getFigura().setLayoutY(this.getPosicionY());
        panel.getChildren().add(this.getFigura());
        
        this.setVelocidad(velocidad);
    }
    
    
    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public Image getPiranha() {
        return piranha;
    }

    public void setPiranha(Image piranha) {
        this.piranha = piranha;
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