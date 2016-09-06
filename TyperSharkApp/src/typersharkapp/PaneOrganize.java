/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typersharkapp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Andy
 */
public class PaneOrganize {
    private Pane Inicio;
    private Reglas reglas;
    private Scene scene2;
    private Image imagen;
    private ImageView vi; 
    private InicioJuego juego;
    private Stage stage; 
    private Scene sc;
    private Puntajes puntaje;
    private MediaPlayer mp;
    private Media musicFile;
  
    public PaneOrganize(){
        try{
            imagen= new Image("Menu.png");
        
        }
        catch(Exception e){System.out.println("No lee imagen");}
        vi=new ImageView(imagen);
        vi.setFitHeight(510);
        vi.setFitWidth(900);
        vi.setImage (imagen);
        
        
        //VENTANA PRINCIPAL
        Inicio= new Pane();
        Inicio.setStyle("-fx-background-color: blue;");
        TitulosLabel Ttot= new TitulosLabel("TYPERSHARK","-fx-font: 40 elephant",450,10,270,30, Color.DARKGRAY);
        
        Boton iniciar= new Boton("Iniciar Partida","-fx-font: 20 century; -fx-background-color: transparent; -fx-background-radius: 30;", 200, 60, 130, 410, 10, Color.AQUA);
        Boton regla= new Boton("Reglas","-fx-font: 20 century; -fx-background-color: transparent; -fx-background-radius: 30;", 100, 60, 330, 410, 10, Color.AQUA);
        Boton puntajes= new Boton("Top de puntajes","-fx-font: 20 century; -fx-background-color: transparent;-fx-background-radius: 30;", 180, 60, 450, 410, 10, Color.AQUA);
        Boton salir= new Boton("Salir","-fx-font: 20 century; -fx-background-color: transparent;-fx-background-radius: 30;", 100, 60, 660, 410, 10, Color.AQUA);
        //AGREGANDO NODOS A LAS VENTANAS
        Inicio.getChildren().add(vi);
        Inicio.getChildren().addAll(Ttot.getL(),iniciar.getBtn(),regla.getBtn(),puntajes.getBtn(),salir.getBtn());
        
        
        reglas = new Reglas();
        puntaje = new Puntajes();
        juego = new InicioJuego();
        
        //ACCIONES DE LOS BOTONES
        regla.getBtn().setOnAction(new ventana2());
        salir.getBtn().setOnAction(new Salida());
        iniciar.getBtn().setOnAction(new Iniciar());
        puntajes.getBtn().setOnAction(new score());
    }
    
    private class score implements EventHandler<ActionEvent>{
         Scene escena1 = new Scene(getPuntaje().getWindowPuntajes(),890,500);
        @Override
        public void handle(ActionEvent event)
        {
            puntaje.setS(stage);
            puntaje.setSc(sc);
            if(scene2 == null || scene2 != escena1)
            {
                scene2 = escena1;
                stage.setScene(scene2);
                stage.setResizable(false);
                stage.show();
            }
            else
            {
                
                stage.setScene(scene2);
                stage.setResizable(false);
                stage.show();
            }
            event.consume(); 
        }
    }
    
    
    private class ventana2 implements EventHandler<ActionEvent>
    {
        Scene escena1 = new Scene(getReglas().getWindowReglas(),890,500);
        @Override
        public void handle(ActionEvent event)
        {
            reglas.setStage(stage);
            reglas.setSc1(sc);
            if(scene2 == null || scene2 != escena1)
            {
                scene2 = escena1;
                stage.setScene(scene2);
                stage.setResizable(false);
                stage.show();
            }
            else
            {
                
                stage.setScene(scene2);
                stage.setResizable(false);
                stage.show();
            }
            event.consume();
        }
    }

    private class Salida implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            System.out.println("Saliendo");
            System.exit(0);   
        }
    }
    
    private class Iniciar implements EventHandler<ActionEvent>
    {
        Scene escena2 = new Scene(getJuego().getPaneJuego(),890,500);
        
        @Override
        public void handle(ActionEvent event)
                
        {
            
            /*try
            {
                musicFile = new Media("file:///C:/Users/Andy/Videos/music.mp3");
            }
            catch(Exception e1){System.out.println("No oye");}
            mp = new MediaPlayer(musicFile);
            mp.setVolume(0.5);
            mp.play();*/

                           
            juego.setStage(stage);
            juego.setSc2(sc);
            if(scene2 == null || scene2 != escena2)
            {
                scene2 = escena2;
                stage.setScene(scene2);
                stage.setResizable(false);
                stage.addEventHandler(KeyEvent.KEY_PRESSED, getJuego().getTeclado());   
                stage.show();
                /*
                Stage stageJuego = new Stage();
                Scene sceneJuego = new Scene(juego.getPaneJuego(), 900, 510);
                stageJuego.setScene(sceneJuego);
                stageJuego.setResizable(false);
                stageJuego.addEventHandler(KeyEvent.KEY_PRESSED, getJuego().getTeclado());
                stageJuego.show();*/
            }
            else
            {  
                stage.setScene(scene2);
                stage.setResizable(false);
                stage.addEventHandler(KeyEvent.KEY_PRESSED, getJuego().getTeclado());   
                stage.show();
            }
            //stage.addEventHandler(KeyEvent.KEY_PRESSED, getJuego().getTeclado()); 
            event.consume();
        }
    }

    
    
    public Scene getSc() {
        return sc;
    }

    public void setSc(Scene sc) {
        this.sc = sc;
    }
        
    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public ImageView getVi() {
        return vi;
    }

    public void setVi(ImageView vi) {
        this.vi = vi;
    }

    public Pane getInicio() {
        return Inicio;
    }

    public void setInicio(Pane Inicio) {
        this.Inicio = Inicio;
    }
    
    
    public Reglas getReglas() {
        return reglas;
    }

    public void setJuego(InicioJuego juego) {
        this.juego = juego;
    }
    
    
    public InicioJuego getJuego() {
        return juego;
    }

    public void setReglas(Reglas window2) {
        this.reglas = window2;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Puntajes getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Puntajes puntaje) {
        this.puntaje = puntaje;
    }
    
    
}