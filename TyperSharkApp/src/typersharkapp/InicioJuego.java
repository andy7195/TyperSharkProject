package typersharkapp;

import java.io.FileReader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


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
        jugar.getBtn().setOnAction(event ->{
            new Thread(new Tiburon(this.juego, 2, palabra)).start();
            new Thread(new TiburonNegro(this.juego, 3, palabras)).start();
            new Thread(new Piranha(this.juego, 1, letra)).start();
        });
        
       
    }

 
    
  
    
    private class KeyHandler implements EventHandler<KeyEvent>
    {
        @Override
        public void handle(KeyEvent event)
        {
             switch(event.getCode())
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
                    break;
                }      
            }
        }
    }

    public KeyHandler getTeclado() {
        return teclado;
    }
    
    
    private class Salir implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e)
        {
            stage.setTitle("TyperShark!...");
            stage.setScene(getSc2());
            stage.show();  
        }
    }

    
    
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getSc2() {
        return sc2;
    }

    public void setSc2(Scene sc2) {
        this.sc2 = sc2;
    }
    
    public Pane getPaneJuego() {
        return juego;
    }

    public Image getFondo() {
        return fondo;
    }

    public ImageView getIv() {
        return iv;
    }
       
}
