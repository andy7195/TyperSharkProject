package typersharkapp;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
/**
 * Una clase para representar al tiburon negro del juego.
 * @version 1.0
 * @author Dennise Guizado
 * @author Edward Pino
 * @author Xavier Pesantes
 */

public class TiburonNegro extends AnimalesMarinos //implements Runnable
{
    private String palabras[];
    private int numroAlt;
    private Image tiburon_negro;
    private ImageView iv;
    private Text texto;
    private TextFlow t;

    public TiburonNegro() {
        
    }

    
    public TiburonNegro(String palabra[]) 
    {
        super();
        
        try{
            tiburon_negro = new Image("BlackShark.png");
            
        }
        catch(Exception e)
        {
            System.out.println("No lee imagen");
        }
        
        iv = new ImageView(tiburon_negro);
        iv.setFitHeight(75);
        iv.setFitWidth(150);
        
        this.texto = new Text(130, 50, "mundo");
        this.texto.setFill(Color.CYAN);
        this.texto.setStyle("-fx-font: 18 century;");
        
        //this.texto.addEventHandler(KeyEvent.KEY_TYPED, new EventTecla());
        
        this.t = new TextFlow(this.texto);
        this.t.setLayoutX(35);
        this.t.setLayoutY(30);
        
        this.palabras = palabra;
    }
   /*public Text Customize(String word, String color){
        return TextBuilder.create().text(word).fill(Paint.valueOf(color)).build();
    }
    
    private class EventTecla implements EventHandler<KeyEvent> {

         @Override
        public void handle(KeyEvent event) {
            Customize(event.getCode().getName(),"black");
        }
    }*/
    
    
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
                        TiburonNegro.this.getFigura().setLayoutX(TiburonNegro.this.getPosicionX());
                    }
                });

                Thread.sleep(this.getVelocidad()*10); 
            }
            TiburonNegro.this.getFigura().setVisible(false);
        }
        catch(Exception ex)
        {
                System.out.println("Error");
                ex.printStackTrace();
        }
    }

    /**
     * Método que añade la imagen al panel del tiburon negro.
     * @param panel de tipo Pane que representa el panel del tiburon negro.
     * @param velocidad de tipo int que representa la velocidad del tiburon negro.
     */
    public void adjuntarTiburonNegro(Pane panel, int velocidad)
    {
        getFigura().getChildren().addAll(getIv(), getT());
        
        getFigura().setLayoutX(this.getPosicionX());
        getFigura().setLayoutY(this.getPosicionY());
        panel.getChildren().add(this.getFigura());
        
        this.setVelocidad(velocidad);
    }
    
    /**
     * Método que saca aletoriamente una palabra de un archivo.
     */
    public void generarPalabras(){
    
    }
    
    /**
     * Método que devuelve el TextFlow del tiburon negro.
     * @return TextFlow
     */
    public TextFlow getT() {
        return t;
    }

    /**
     * Método que modifica el TextFlow del tiburon negro.
     * @param t de tipo TextFlow que representa el TextFlow de la piraña.
     */
    public void setT(TextFlow t) {
        this.t = t;
    }
    
    /**
     * Método que devuelve el texto del tiburon negro.
     * @return Text
     */
    public Text getTexto() {
        return texto;
    }

    /**
     * Método que modifica el texto del tiburon negro.
     * @param texto de tipo Text que representa el texto de la piraña.
     */
    public void setTexto(Text texto) {
        this.texto = texto;
    }

    /**
     * Método que devuelve una arreglo de palabras del tiburon negro.
     * @return String[]
     */
    public String[] getPalabras() {
        return palabras;
    }

    /**
     * Método que modifica una arreglo de palabras del tiburon negro.
     * @param palabras de tipo String[] que representa una arreglo de palabras.
     */
    public void setPalabras(String[] palabras) {
        this.palabras = palabras;
    }

    /**
     * Método que devuelve el numero aleatorio de la cantidad de palabras que tendra le tiburon negro;
     * @return int
     */
    public int getNumroAlt() {
        return numroAlt;
    }

    /**
     * Método que modifica el numero aleatorio de la cantidad de palabras que tendra le tiburon negro;
     * @param numroAlt de tipo int que representa el numero aleatorio de la cantidad de palabras que tendra le tiburon negro;
     */
    public void setNumroAlt(int numroAlt) {
        this.numroAlt = numroAlt;
    }

    /**
     * Método que devuelve la imagen del tiburon negro.
     * @return Image
     */
    public Image getTiburon_negro() {
        return tiburon_negro;
    }

    /**
     * Método que modifica la imagen del tiburon negro.
     * @param tiburon_negro de tipo Image que representa la imagen del tiburon negro.
     */
    public void setTiburon_negro(Image tiburon_negro) {
        this.tiburon_negro = tiburon_negro;
    }

    /**
     * Método que devuelve la vista de la imagen del tiburon negro.
     * @return ImageView
     */
    public ImageView getIv() {
        return iv;
    }

    /**
     * Método que modifica la vista de la imagen del tiburon negro.
     * @param iv de tipo ImageView que representa la vista de la imagen del tiburon negro.
     */
    public void setIv(ImageView iv) {
        this.iv = iv;
    }
    
}
