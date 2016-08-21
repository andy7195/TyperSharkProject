package typersharkapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;


public class InicioJuego 
{
    private Pane juego;
    private Image fondo;
    private ImageView iv;
    private KeyHandler teclado;
    private Boton salir;
    private Boton jugar;
    private FileReader archivo;
    private String palabra;
    private String palabras[];
    
    
    public InicioJuego()
    {
        // HACER LA LECTURA DEL ARCHIVO DE PALABRAS
        //archivo = new FileReader("Palabras_Tiburon.txt");
        this.palabra = null;
        this.palabras = null;
        
        
        
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
            new Thread(new MoverAnimal(new Tiburon(this.juego, 2, new String()))).start();
            new Thread(new MoverAnimal(new TiburonNegro(this.juego, 3, palabras))).start();
        });
        
       
    }

 
    
  
    
    private class KeyHandler implements EventHandler<KeyEvent>
    {
        @Override
        public void handle(KeyEvent event)
        {
            
        }
    }

    public KeyHandler getTeclado() {
        return teclado;
    }
    
    
    private class Salir implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e){
            System.out.println("Saliendo");
            System.exit(0);   
        }
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
