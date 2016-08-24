/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typersharkapp;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
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
 *
 * @author Andy
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
    FileWriter fichero = null;
    PrintWriter pw = null;
    
    public DatosUsuario(){
        
         juego = new InicioJuego();
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
    
    public Stage getS() {
        return s;
    }

    public void setS(Stage s) {
        this.s = s;
    }

    public Scene getSc() {
        return sc;
    }

    public void setSc(Scene sc) {
        this.sc = sc;
    }
    
    
    private class regresar implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e){
            s.setTitle("TyperShark!...");
            s.setScene(getSc());
            s.show();
            
        }
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
           
            
          b = new Buceador();
          file= new File("C:/Users/Andy/Documents/NetBeansProjects/TyperSharkProject/TyperSharkApp/src/Top10.txt");
            try
            {
                
                    fichero = new FileWriter(file, true);
                    pw = new PrintWriter(fichero); 
                    pw.println(nombre.getText()+","+b.getPuntaje()+"\n");
                
              
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
            
            
            juego.setStage(s);
            juego.setSc2(sc);
            if(scene2 == null || scene2 != escena2)
            {
                scene2 = escena2;
                s.setScene(scene2);
                s.setResizable(false);
                s.addEventHandler(KeyEvent.KEY_PRESSED, getJuego().getTeclado());   
                s.show();
            }
            else
            {  
                s.setScene(scene2);
                s.setResizable(false);
                s.addEventHandler(KeyEvent.KEY_PRESSED, getJuego().getTeclado());   
                s.show();
            }
            //stage.addEventHandler(KeyEvent.KEY_PRESSED, getJuego().getTeclado()); 
            event.consume();
            System.out.println(nombre.getText());
        }
    }
     
     
    public Pane getWindowDatos() {
        return windowDatos;
    }
    
     public void setJuego(InicioJuego juego) {
        this.juego = juego;
    }
    
    
    public InicioJuego getJuego() {
        return juego;
    }

   
    
    
}
