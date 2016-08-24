package typersharkapp;

import java.io.FileReader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import javafx.scene.layout.Pane;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @version 1.0
 * @author Dennise Guizado
 * @author Edward Pino
 * @author Xavier Pesantes
 */

public class InicioJuego 
{
    private Pane juego;
    private Image fondo;
    private ImageView iv;
    private KeyHandler teclado;
    private Boton salir;
    private Boton jugar;
    private FileReader archivo;
    private char letra;
    private String palabra;
    private String palabras[];
    private Buceador jugador;
    private Stage stage;
    private Scene sc2;
    
   
    public InicioJuego()
    {
        // HACER LA LECTURA DEL ARCHIVO DE PALABRAS
        //archivo = new FileReader("Palabras_Tiburon.txt");
        this.palabra = null;
        this.palabras = null;
        this.letra = 'S';
        
        
        teclado = new KeyHandler();
        juego = new Pane();
        try{
            fondo = new Image("FondoJuego.jpg");
            
        }
        catch(Exception e)
        {
            System.out.println("No lee imagen");
        }
        iv = new ImageView(fondo);
        iv.setFitHeight(510);
        iv.setFitWidth(900);
        iv.setImage (fondo);
        
        salir = new Boton("Regresar","-fx-font: 20 century; -fx-background-color: transparent;-fx-background-radius: 30;", 150, 60, 730, 438, 10, Color.AQUA);
        jugar = new Boton("Start","-fx-font: 20 century; -fx-background-color: transparent;-fx-background-radius: 30;", 150, 60, 5, 438, 10, Color.AQUA);
        
        juego.getChildren().addAll(iv, salir.getBtn(), jugar.getBtn());
        
        
        salir.getBtn().setOnAction(new Salir());
        new Thread(new Buceador(juego)).start();
        jugar.getBtn().setOnAction((ActionEvent event) -> {
            
            //Tiburon t = new Tiburon(palabra);
            //t.adjuntarTiburon(juego, 2);
            
            TiburonNegro tn = new TiburonNegro(palabras);
            tn.adjuntarTiburonNegro(juego, 3);
            
            Piranha p = new Piranha(letra);
            p.adjuntarPiranha(juego, 1);
            
            //t.start();
            tn.start();
            p.start();
            
        });
        
       
    }

     private class KeyHandler implements EventHandler<KeyEvent>
    {
        @Override
        public void handle(KeyEvent event)
        {
            Tiburon t = new Tiburon("hola", event);
            t.adjuntarTiburon(juego, 2);
            if(event.getCode().equals(KeyCode.ENTER))
            {
                t.start();
            }
         
            
            
            /*switch(event.getCode())
            {
                case ENTER:
                {
                    if(jugador.getPuntaje()<=50){
                        System.out.println("No puedo usar poder especial");
                        break;
                    }
                    else{
                        jugador.setPuntaje(jugador.getPuntaje()/2);
                        break;
                    }
                  
                }        
                default:  {
                    if(event.getCode().isLetterKey()){
                        
                        break;
                    }
                    else{
                        System.out.println("La tecla presionada no es válida");
                        break;
                    }
                }      
            }*/
        }
    }

    /**
     * Método que devuelve un Key Hanlder la ventana de inicio del juego.
     * @return
     */
    public KeyHandler getTeclado() {
        return teclado;
    }
    
     
    private class Salir implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e)
        {
            stage.setTitle("TyperShark!...");
            stage.setScene(getSc2());
            stage.show();  
        }
    }

    /**
     * Método que devuelve el stage del juego.
     * @return Stage
     */
    public Stage getStage() {
        return stage;
    }

    /** 
     * Método que modifica el stage del juego.
     * @param stage de tipo Stage que representa el stage del juego.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Método que devuelve la escena de la ventana de inicio del juego.
     * @return Scene
     */
    public Scene getSc2() {
        return sc2;
    }

    /**
     * Método que modifica la escena de la ventana de inicio del juego.
     * @param sc2 de tipo Scene que representa la escena de la venta de inicio del juego.
     */
    public void setSc2(Scene sc2) {
        this.sc2 = sc2;
    }
    
    /**
     * Método que devuelve el panel de la ventana de inicio del juego.
     * @return
     */
    public Pane getPaneJuego() {
        return juego;
    }

    /**
     * Método que modifica el panel de la ventana de inicio del juego.
     * @param juego de tipo Pane que representa el panel de la venta de inicio del juego.
     */
    public void setJuego(Pane juego) {
        this.juego = juego;
    }

    /**
     * Método que devuelve la imagen de fondo de la ventana de inicio del juego.
     * @return Image
     */
    public Image getFondo() {
        return fondo;
    }

    /**
     * Método que modifica la imagen de fondo de la ventana de inicio del juego.
     * @param fondo de tipo Image que representa la imagen de fondo de la venta de inicio del juego.
     */
    public void setFondo(Image fondo) {
        this.fondo = fondo;
    }

    /**
     * Método que devuelve la vista de la imagen de fondo de la ventana de inicio del juego.
     * @return ImageView
     */
    public ImageView getIv() {
        return iv;
    }

    /**
     * Método que modifica la vista de la imagen de fondo de la ventana de inicio del juego.
     * @param iv de tipo ImageView que representa la vista de la imagen de fondo de la venta de inicio del juego.
     */
    public void setIv(ImageView iv) {
        this.iv = iv;
    }
       
}
