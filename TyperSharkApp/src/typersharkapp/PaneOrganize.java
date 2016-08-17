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
            imagen= new Image("Shark.jpeg");
        
        }
        catch(Exception e){System.out.println("No lee imagen");}
        vi=new ImageView(imagen);
        vi.setFitHeight(500);
        vi.setFitWidth(700);
        vi.setImage (imagen);
        
        window2=new Reglas();
        
        juego = new InicioJuego();
        
        
        
        
        //VENTANA PRINCIPAL
        Inicio= new Pane();
        Inicio.setStyle("-fx-background-color: blue;");
        TitulosLabel Ttot= new TitulosLabel("TYPERSHARK","-fx-font: 40 elephant",450,10,170,30, Color.DARKGRAY);
        
        Boton iniciar= new Boton("Iniciar Partida","-fx-font: 20 century; -fx-background-color: transparent; -fx-background-radius: 30;", 200, 60, 30, 400, 10, Color.AQUA);
        Boton reglas= new Boton("Reglas","-fx-font: 18 century; -fx-background-color: transparent; -fx-background-radius: 30;", 100, 60,220, 400, 10, Color.AQUA);
        Boton puntajes= new Boton("Top de puntajes","-fx-font: 20 century; -fx-background-color: transparent;-fx-background-radius: 30;", 180, 60, 340, 400, 10, Color.AQUA);
        Boton salir= new Boton("Salir","-fx-font: 18 century; -fx-background-color: transparent;-fx-background-radius: 30;", 100, 60, 550, 400, 10, Color.AQUA);
        
        //AGREGANDO NODOS A LAS VENTANAS
        Inicio.getChildren().add(vi);
       
        Inicio.getChildren().addAll(Ttot.getL(),iniciar.getBtn(),reglas.getBtn(),puntajes.getBtn(),salir.getBtn());
       
        
        //ACCIONES DE LOS BOTONES
        reglas.getBtn().setOnAction(new ventana2());
        salir.getBtn().setOnAction(new Salida());
        iniciar.getBtn().setOnAction(new Iniciar());
    }

    public Pane getInicio() {
        return Inicio;
    }

    public Reglas getWindow2() {
        return window2;
    }

    public InicioJuego getJuego() {
        return juego;
    }
    
    
    
    private class ventana2 implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e){
            Stage v2 = new Stage();
            Scene scene2 = new Scene(getWindow2().getWindowReglas(),700,500);
            v2.setScene(scene2);
            v2.show();
           
            
        }
    }

    private class Salida implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e){
            System.out.println("Saliendo");
            System.exit(0);   
        }
    }
    
    private class Iniciar implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
            Stage StageJuego = new Stage();
            Scene scene = new Scene(getJuego().getJuego(), 700, 500);
            StageJuego.setScene(scene);
            StageJuego.show();
            
        }
    }
}
