/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

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
        
        //VENTANA PRINCIPAL
        Inicio= new Pane();
        Inicio.setStyle("-fx-background-color: blue;");
        TitulosLabel T= new TitulosLabel("T","-fx-font: 40 ravie",10,10,190,10, Color.WHITE);
        TitulosLabel Y= new TitulosLabel("Y","-fx-font: 40 ravie",10,10,225,20, Color.ANTIQUEWHITE);
        TitulosLabel P= new TitulosLabel("P","-fx-font: 40 ravie",10,10,260,10, Color.AQUA);
        TitulosLabel E= new TitulosLabel("E","-fx-font: 40 ravie",10,10,295,20, Color.AQUAMARINE);
        TitulosLabel R= new TitulosLabel("R","-fx-font: 40 ravie",10,10,330,10, Color.AZURE);
        TitulosLabel S= new TitulosLabel("S","-fx-font: 40 ravie",10,10,370,20, Color.ANTIQUEWHITE);
        TitulosLabel H= new TitulosLabel("H","-fx-font: 40 ravie",10,10,405,10, Color.CYAN);
        TitulosLabel A= new TitulosLabel("A","-fx-font: 40 ravie",10,10,435,20, Color.WHEAT);
        TitulosLabel R1= new TitulosLabel("R","-fx-font: 40 ravie",10,10,465,10, Color.LAVENDER);
        TitulosLabel K= new TitulosLabel("K","-fx-font: 40 ravie",10,10,505,20, Color.AQUAMARINE);
        
        Boton iniciar= new Boton("Iniciar Partida","-fx-font: 12 ravie; -fx-base: #9BDCE1; -fx-background-radius: 30;", 150, 60, 30, 400, 10, Color.FUCHSIA);
        Boton reglas= new Boton("Reglas","-fx-font: 15 ravie; -fx-base: #9BDCE1; -fx-background-radius: 30;", 100, 60,210, 400, 10, Color.BLUE);
        Boton puntajes= new Boton("Top de puntajes","-fx-font: 12 ravie; -fx-base: #9BDCE1;-fx-background-radius: 30;", 180, 60, 340, 400, 10, Color.BLUEVIOLET);
        Boton salir= new Boton("Salir","-fx-font: 15 ravie; -fx-base: #9BDCE1;-fx-background-radius: 30;", 100, 60, 550, 400, 10, Color.DEEPPINK);
        
        //AGREGANDO NODOS A LAS VENTANAS
        Inicio.getChildren().add(vi);
        Inicio.getChildren().addAll(T.getL(),Y.getL(),P.getL(),E.getL(),R.getL(),S.getL(),H.getL(),A.getL(),R1.getL(),K.getL());
        Inicio.getChildren().addAll(iniciar.getBtn(),reglas.getBtn(),puntajes.getBtn(),salir.getBtn());
       
        
        //ACCIONES DE LOS BOTONES
        reglas.getBtn().setOnAction(new ventana2());
        salir.getBtn().setOnAction(new Salida());
    }

    public Pane getInicio() {
        return Inicio;
    }

    public Reglas getWindow2() {
        return window2;
    }
    
    
    private class ventana2 implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e){
            Stage v2 = new Stage();
            PaneOrganize po2= new PaneOrganize();
            Scene scene2 = new Scene(po2.getWindow2().getWindowReglas(),700,500);
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
}