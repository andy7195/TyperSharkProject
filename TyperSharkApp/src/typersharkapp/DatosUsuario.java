/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typersharkapp;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Una clase para representar la ventana de ingreso de datos de usuario.
 * @version 1.0
 * @author Dennise Guizado
 * @author Edward Pino
 * @author Xavier Pesantes
 */
public class DatosUsuario {
    private Pane windowDatos;
    private Image imagen;
    private ImageView vi; 
    private Stage s;
    private Scene sc;
    private TextField nombre;
    private InicioJuego juego;
    private Scene scene2;
    private Buceador b;
    private File file;
    private SortedMap <String, Integer> datos;
    FileWriter fichero = null;
    PrintWriter pw = null;
    
    public DatosUsuario(){
         datos = new TreeMap(java.util.Collections.reverseOrder());

         
         //juego = new InicioJuego();
         Label titulo= new Label("INGRESE SU NOMBRE");
         nombre = new TextField();
         
         Button btn1= new Button("JUGAR");
         try{
            imagen= new Image("Menu.png");
        
        }
        catch(Exception e){System.out.println("No lee imagen");}
        vi=new ImageView(imagen);
        vi.setFitHeight(510);
        vi.setFitWidth(900);
        vi.setImage (imagen);
        
        titulo.setLayoutX(200);
        titulo.setLayoutY(300);
        titulo.setStyle("-fx-font: 20 century;");
        titulo.setTextFill(Color.AQUA);
        
        nombre.setLayoutX(450);
        nombre.setLayoutY(300);
        
        btn1.setLayoutX(250);
        btn1.setLayoutY(400);
        btn1.setStyle("-fx-font: 20 century; -fx-background-color: transparent;");
        btn1.setTextFill(Color.AQUA);
        
        windowDatos = new Pane();
        windowDatos.getChildren().addAll(vi);
        windowDatos.getChildren().addAll(titulo,nombre,btn1);
        
        btn1.setOnAction(new Iniciar());
        
           }
    
    /**
     * Método que devuelve el stage del juego.
     * @return Stage
     */
    public Stage getS() {
        return s;
    }

    /**
     * Método que modifica el Stage del juego.
     * @param stage de tipo Stage que representa el Stage del juego.
     */
    public void setS(Stage s) {
        this.s = s;
    }

    /**
     * Método que devuelve la escena de la ventana de ingreso de datos de usuario.
     * @return Scene
     */
    public Scene getSc() {
        return sc;
    }

    /**
     * Método que modifica la escena de la ventana de ingreso de datos de usuario.
     * @param sc de tipo Scene que representa la escena de la ventana de ingreso de datos de usuario.
     */
    public void setSc(Scene sc) {
        this.sc = sc;
    }
    
    
   
    
     private class Iniciar implements EventHandler<ActionEvent>
    {
        Scene escena2 = new Scene(getJuego().getPaneJuego(),890,500);
        @Override
        public void handle(ActionEvent event)
                
        {
            
                /*try{
         musicFile = new Media("file:///C:/Users/Andy/Videos/music.mp3");
                  
         }
        catch(Exception e1){System.out.println("No oye");}
        mp = new MediaPlayer(musicFile);
                mp.setVolume(0.5);
                mp.play();*/
           
           
         // b = new Buceador();
          file= new File("C:/Users/Andy/Documents/NetBeansProjects/TyperSharkProject/TyperSharkApp/src/Top10.txt");
            try
            {
                    
                    Set ref = datos.keySet();
                    Iterator it = ref.iterator();
                    while (it.hasNext()) {
                    datos.put(nombre.getText(),(b.getPuntaje()));
                    System.out.println((String)it.next());
                    fichero = new FileWriter(file, true);
                    pw = new PrintWriter(fichero); 
                    pw.println(datos);
                    
               }     
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
               try {
               // Nuevamente aprovechamos el finally para 
               // asegurarnos que se cierra el fichero.
               if (null != fichero)
                  fichero.close();
               } catch (Exception e2) {
                  e2.printStackTrace();
               }
            }
            
            
           // juego.setStage(s);
            juego.setSc2(sc);
            if(scene2 == null || scene2 != escena2)
            {
                scene2 = escena2;
                s.setScene(scene2);
                s.setResizable(false);
                s.addEventHandler(KeyEvent.KEY_PRESSED, getJuego().getEventoTeclado());   
                s.show();
            }
            else
            {  
                s.setScene(scene2);
                s.setResizable(false);
                s.addEventHandler(KeyEvent.KEY_PRESSED, getJuego().getEventoTeclado());   
                s.show();
            }
            //stage.addEventHandler(KeyEvent.KEY_PRESSED, getJuego().getTeclado()); 
            event.consume();
            System.out.println(nombre.getText());
        }
    }
     
    /**
     * Método que devuelve el panel de la ventana de ingreso de datos de usuario.
     * @return Pane
     */
    public Pane getWindowDatos() {
        return windowDatos;
    }
    
    /**
     * Método que devuelve la ventana de ingreso de inicio del juego.
     * @return InicioJuego
     */
    public InicioJuego getJuego() {
        return juego;
    }
    
    /**
     * Método que modifica la ventana de ingreso de inicio del juego.
     * @param juego de tipo InicioJuego que representa la ventana de ingreso de inicio del juego
     */
    public void setJuego(InicioJuego juego) {
        this.juego = juego;
    }

    /**
     * Método que devuelve la imagen de fondo de la ventana de ingreso de inicio del juego.
     * @return Image
     */
    public Image getImagen() {
        return imagen;
    }

    /**
     * Método que modifica la imagen de fondo de la ventana de ingreso de inicio del juego.
     * @param imagen de tipo Imagen que representa la imagen de fondo de la ventana de ingreso de inicio del juego.
     */
    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    /**
     * Método que devuelve la vista de imagen de fondo de la ventana de ingreso de inicio del juego.
     * @return ImageView
     */
    public ImageView getVi() {
        return vi;
    }

    /** 
     * Método que modifica la vista de imagen de fondo de la ventana de ingreso de inicio del juego.
     * @param vi de tipo ImageView que representa la vista de imagen de fondo de la ventana de ingreso de inicio del juego.
     */
    public void setVi(ImageView vi) {
        this.vi = vi;
    }

    /**
     * Método que devuelve al buceador del juego.
     * @return Buceador
     */
    public Buceador getB() {
        return b;
    }

    /**
     * Método que modifica al buceador del juego.
     * @param b de tipo Buceador que representa al buceador del juego.
     */
    public void setB(Buceador b) {
        this.b = b;
    }
    
    

   
    
    
}
