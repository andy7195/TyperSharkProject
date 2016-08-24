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
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Una clase para representar la ventana principal del juego.
 * @version 1.0
 * @author Dennise Guizado
 * @author Edward Pino
 * @author Xavier Pesantes
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
    private DatosUsuario du;
  
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
        du = new DatosUsuario();
        
        //ACCIONES DE LOS BOTONES
        regla.getBtn().setOnAction(new ventana2());
        salir.getBtn().setOnAction(new Salida());
        iniciar.getBtn().setOnAction(new VentanaDatos());
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

    private class VentanaDatos implements EventHandler<ActionEvent>
    {
        Scene escena2 = new Scene(getDu().getWindowDatos(),890,500);
        @Override
        public void handle(ActionEvent event){
            du.setS(stage);
            du.getS();
            if(scene2 == null || scene2 != escena2)
            {
                scene2 = escena2;
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
        
            
                /*try{
         musicFile = new Media("file:///C:/Users/Andy/Videos/music.mp3");
                  
         }
        catch(Exception e1){System.out.println("No oye");}
        mp = new MediaPlayer(musicFile);
                mp.setVolume(0.5);
                mp.play();*/
           
            
            
            
           
               
        }
    }
    private class Salida implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            System.out.println("Saliendo");
            System.exit(0);   
        }
    }
    
    /**
     * Método que devuelve la escena de la ventana principal.
     * @return Scene
     */
    public Scene getSc() {
        return sc;
    }

    /**
     * Método que modifica la escena de la ventana principal.
     * @param sc
     */
    public void setSc(Scene sc) {
        this.sc = sc;
    }
        
    /**
     * Método que devuelve la imagen de fondo de la ventana principal.
     * @return Image
     */
    public Image getImagen() {
        return imagen;
    }

    /**
     * Método que modifica la imagen de fondo de la ventana principal.
     * @param imagen
     */
    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    /**
     * Método que devuelve la vista de la imagen de fondo de la ventana principal.
     * @return ImageView
     */
    public ImageView getVi() {
        return vi;
    }

    /**
     * Método que dmodifica la vista de la imagen de fondo de la ventana principal.
     * @param vi de tipo ImageView que representa la vista de la imagen de fondo de la ventana principal.
     */
    public void setVi(ImageView vi) {
        this.vi = vi;
    }

    /**
     * Método que devuelve el panel de la ventana principal.
     * @return Pane
     */
    public Pane getInicio() {
        return Inicio;
    }

    /**
     * Método que modifica el panel de la ventana principal.
     * @param Inicio de tipo Pane que representa el panel de la ventana principal.
     */
    public void setInicio(Pane Inicio) {
        this.Inicio = Inicio;
    }
    
    /**
     * Método que devuelve la ventana Reglas.
     * @return Reglas
     */
    public Reglas getReglas() {
        return reglas;
    }
    
    /**
     * Método que modifica la ventana Reglas.
     * @param window2 de tipo Reglas que representa la ventana Reglas
     */
    public void setReglas(Reglas window2) {
        this.reglas = window2;
    }
    
    /**
     * Método que devuelve la clase InicioJuego.
     * @return InicioJuego
     */
    public InicioJuego getJuego() {
        return juego;
    }
    /**
     * Método que modifica la clase InicioJuego.
     * @param juego de tipo InicioJuego que representa a la ventana de Inicio del Juego.
     */
    public void setJuego(InicioJuego juego) {
        this.juego = juego;
    }
    
    /**
     * Método que devuelve el Stage del juego.
     * @return Stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * Método que modifica el Stage del juego.
     * @param stage de tipo Stage que representa el Stage del juego.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Método que devuelve la ventana Puntajes.
     * @return Puntajes
     */
    public Puntajes getPuntaje() {
        return puntaje;
    }

    /**
     * Método que modifica la ventana Puntajes.
     * @param puntaje de tipo Puntajes que representa la ventana Puntajes.
     */
    public void setPuntaje(Puntajes puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * Método que devuelve la ventana de ingreso de datos de usuario.
     * @return DatosUsario
     */
    public DatosUsuario getDu() {
        return du;
    }

    /**
     * Método que modifica la ventana la ventana de ingreso de datos de usuario.
     * @param du de tipo DatosUsuario que representa la ventana de ingreso de datos de usuario.
     */
    public void setDu(DatosUsuario du) {
        this.du = du;
    }
    
    
}
