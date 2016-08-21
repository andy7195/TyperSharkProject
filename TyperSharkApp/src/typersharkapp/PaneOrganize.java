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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Andy
 */
public class PaneOrganize {
    private Pane Inicio;
    private Reglas window2;
    private Image imagen;
    private ImageView vi; 
    private InicioJuego juego;
  
    public PaneOrganize(){
        try{
            imagen= new Image("Menu.png");
        
        }
        catch(Exception e){System.out.println("No lee imagen");}
        vi=new ImageView(imagen);
        vi.setFitHeight(510);
        vi.setFitWidth(900);
        vi.setImage (imagen);
        
        window2=new Reglas();
        
        juego = new InicioJuego();
        
        
        
        
        //VENTANA PRINCIPAL
        Inicio= new Pane();
        Inicio.setStyle("-fx-background-color: blue;");
        TitulosLabel Ttot= new TitulosLabel("TYPERSHARK","-fx-font: 40 elephant",450,10,270,30, Color.DARKGRAY);
        
        Boton iniciar= new Boton("Iniciar Partida","-fx-font: 20 century; -fx-background-color: transparent; -fx-background-radius: 30;", 200, 60, 130, 410, 10, Color.AQUA);
        Boton reglas= new Boton("Reglas","-fx-font: 20 century; -fx-background-color: transparent; -fx-background-radius: 30;", 100, 60, 330, 410, 10, Color.AQUA);
        Boton puntajes= new Boton("Top de puntajes","-fx-font: 20 century; -fx-background-color: transparent;-fx-background-radius: 30;", 180, 60, 450, 410, 10, Color.AQUA);
        Boton salir= new Boton("Salir","-fx-font: 20 century; -fx-background-color: transparent;-fx-background-radius: 30;", 100, 60, 660, 410, 10, Color.AQUA);
        //AGREGANDO NODOS A LAS VENTANAS
        Inicio.getChildren().add(vi);
       
        Inicio.getChildren().addAll(Ttot.getL(),iniciar.getBtn(),reglas.getBtn(),puntajes.getBtn(),salir.getBtn());
       
        
        //ACCIONES DE LOS BOTONES
        reglas.getBtn().setOnAction(new ventana2());
        salir.getBtn().setOnAction(new Salida());
        iniciar.getBtn().setOnAction(new Iniciar());
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
    
    
    public Reglas getWindow2() {
        return window2;
    }

    public void setJuego(InicioJuego juego) {
        this.juego = juego;
    }
    
    
    public InicioJuego getJuego() {
        return juego;
    }

    public void setWindow2(Reglas window2) {
        this.window2 = window2;
    }
    
    
    
    
    private class ventana2 implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            Stage v2 = new Stage();
            Scene scene2 = new Scene(getWindow2().getWindowReglas(),890,500);
            v2.setScene(scene2);
            v2.setResizable(false);
            v2.show();
           
            
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
        @Override
        public void handle(ActionEvent event)
        {
            Stage StageJuego = new Stage();
            Scene scene = new Scene(getJuego().getPaneJuego(), 890, 500);
            StageJuego.setScene(scene);
            StageJuego.setTitle("TyperShark");
            StageJuego.addEventHandler(KeyEvent.KEY_PRESSED, getJuego().getTeclado());
            StageJuego.setResizable(false);
            StageJuego.show();
            
        }
    }
}
