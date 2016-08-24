package typersharkapp;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
/**
 * Una clase para representar al tiburon del juego.
 * @version 1.0
 * @author Dennise Guizado
 * @author Edward Pino
 * @author Xavier Pesantes
 */

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

  /**
     * Método que añade la imagen al panel del tiburon.
     * @param panel de tipo Pane que representa el panel del tiburon.
     * @param velocidad de tipo int que representa la velocidad del tiburon.
     */
    public void adjuntarTiburon(Pane panel, int velocidad)
    {
        getFigura().getChildren().addAll(getIv(), getT());
        
        getFigura().setLayoutX(this.getPosicionX());
        getFigura().setLayoutY(this.getPosicionY());
        panel.getChildren().add(this.getFigura());
        
        this.setVelocidad(velocidad);
    }
    
    /**
     * Método que devuelve la palabra del tiburon.
     * @return String
     */
    public String getPalabra() {
        return palabra;
    }

    /**
     * Método que modifica la palabra del tiburon.
     * @param palabra de tipo String que representa la palabra del tiburon.
     */
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    /**
     * Método que devuelve la imagen del tiburon.
     * @return Image
     */
    public Image getTiburon() {
        return tiburon;
    }

    /**
     * Método que modifica la imagen del tiburon.
     * @param tiburon de tipo Image que representa la imagen del tiburon.
     */
    public void setTiburon(Image tiburon) {
        this.tiburon = tiburon;
    }

    /**
     * Método que devuelve la vista de la imagen del tiburon.
     * @return ImageView
     */
    public ImageView getIv() {
        return iv;
    }

    /**
     * Método que modifica la vista de la imagen del tiburon.
     * @param iv de tipo ImageView que representa la vista de la imagen del tiburon.
     */
    public void setIv(ImageView iv) {
        this.iv = iv;
    }

    /**
     * Método que devuelve el texto del tiburon.
     * @return Text
     */
    public Text getTexto() {
        return texto;
    }

    /**
     * Método que modifica el texto del tiburon.
     * @param texto de tipo Text que representa el texto del tiburon.
     */
    public void setTexto(Text texto) {
        this.texto = texto;
    }

    /**
     * Método que devuelve el TextFlow del tiburon.
     * @return TextFlow
     */
    public TextFlow getT() {
        return t;
    }

    /**
     * Método que devuelve el TextFlow del tiburon.
     * @param t de tipo TextFlow que representa el TextFlow del tiburon.
     */
    public void setT(TextFlow t) {
        this.t = t;
    }


}