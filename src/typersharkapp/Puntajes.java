package typersharkapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Una clase para representar la ventana de los 10 mejores jugadores.
 * @version 1.0
 * @author Dennise Guizado
 * @author Edward Pino
 * @author Xavier Pesantes
 */
public class Puntajes {
    private Pane windowPuntajes;
    private Stage stagePrincipal;
    private Stage stagePuntaje;
    private Image imagen;
    private ImageView vi; 
    private Stage s;
    private Scene sc;
    private Label textArea;
    private File file;
    private ComboBox niveles;
    private final TitulosLabel name1;
    private final TitulosLabel name2;
    private final TitulosLabel name3;
    private final TitulosLabel name4;
    private final TitulosLabel name5;
    private final TitulosLabel name6;
    private final TitulosLabel name7;
    private final TitulosLabel name8;
    private final TitulosLabel name9;
    private final TitulosLabel name10;
    
    private final TitulosLabel puntaje1;
    private final TitulosLabel puntaje2;
    private final TitulosLabel puntaje3;
    private final TitulosLabel puntaje4;
    private final TitulosLabel puntaje5;
    private final TitulosLabel puntaje6;
    private final TitulosLabel puntaje7;
    private final TitulosLabel puntaje8;
    private final TitulosLabel puntaje9;
    private final TitulosLabel puntaje10;
    
    FileReader fr = null;
    BufferedReader br = null;
    String texto = "";
    
    public Puntajes(Stage stageP) {
         try{
            imagen= new Image("Menu.png");
        
        }
        catch(Exception e){System.out.println("No lee imagen");}
        vi=new ImageView(imagen);
        vi.setFitHeight(510);
        vi.setFitWidth(900);
        vi.setImage (imagen);
        
        
        windowPuntajes= new Pane();
        this.stagePrincipal = stageP;

        niveles= new ComboBox();
        niveles.setValue("Nivel 1");
        niveles.getItems().addAll("Nivel 1", "Nivel 2", "Nivel 3", "Nivel 4", "Nivel 5", "Nivel 6", "Nivel 7", "Nivel 8", "Nivel 9", "Nivel 10");
        niveles.setLayoutX(360);
        niveles.setLayoutY(80);
        
        TitulosLabel titulo1= new TitulosLabel("TOP 10 MEJORES","-fx-font: 20 elephant",250,10,360,20, Color.DARKGRAY);
        TitulosLabel titulo2= new TitulosLabel("PUNTAJES","-fx-font: 20 elephant;",150,10,400,50, Color.DARKGRAY);
        TitulosLabel jugador= new TitulosLabel("JUGADOR","-fx-font: 20 elephant",150,10,300,120, Color.DARKGRAY);
        TitulosLabel puntaje= new TitulosLabel("PUNTAJE","-fx-font: 20 elephant",150,10,500,120, Color.DARKGRAY);
         
        name1= new TitulosLabel(" ","-fx-font: 20 elephant",150,10,300,140,Color.DARKGRAY);
        name2= new TitulosLabel(" ","-fx-font: 20 elephant",150,10,300,170, Color.DARKGRAY);
        name3= new TitulosLabel(" ","-fx-font: 20 elephant",150,10,300,200, Color.DARKGRAY);
        name4= new TitulosLabel(" ","-fx-font: 20 elephant",150,10,300,230, Color.DARKGRAY);
        name5= new TitulosLabel(" ","-fx-font: 20 elephant",150,10,300,260, Color.DARKGRAY);
        name6= new TitulosLabel(" ","-fx-font: 20 elephant",150,10,300,300, Color.DARKGRAY);
        name7= new TitulosLabel(" ","-fx-font: 20 elephant",150,10,300,330, Color.DARKGRAY);
        name8= new TitulosLabel(" ","-fx-font: 20 elephant",150,10,300,360, Color.DARKGRAY);
        name9= new TitulosLabel(" ","-fx-font: 20 elephant",150,10,300,390, Color.DARKGRAY);
        name10= new TitulosLabel(" ","-fx-font: 20 elephant",150,10,300,420, Color.DARKGRAY);
        
        puntaje1= new TitulosLabel(" ","-fx-font: 20 elephant",150,10,500,140, Color.DARKGRAY);
        puntaje2= new TitulosLabel(" ","-fx-font: 20 elephant",150,10,500,170, Color.DARKGRAY);
        puntaje3= new TitulosLabel(" ","-fx-font: 20 elephant",150,10,500,200, Color.DARKGRAY);
        puntaje4= new TitulosLabel(" ","-fx-font: 20 elephant",150,10,500,230, Color.DARKGRAY);
        puntaje5= new TitulosLabel(" ","-fx-font: 20 elephant",150,10,500,260, Color.DARKGRAY);
        puntaje6= new TitulosLabel(" ","-fx-font: 20 elephant",150,10,500,300, Color.DARKGRAY);
        puntaje7= new TitulosLabel(" ","-fx-font: 20 elephant",150,10,500,330, Color.DARKGRAY);
        puntaje8= new TitulosLabel(" ","-fx-font: 20 elephant",150,10,500,360, Color.DARKGRAY);
        puntaje9= new TitulosLabel(" ","-fx-font: 20 elephant",150,10,500,390, Color.DARKGRAY);
        puntaje10= new TitulosLabel(" ","-fx-font: 20 elephant",150,10,500,420, Color.DARKGRAY);
        
        
        Boton regreso= new Boton("Regresar","-fx-font: 20 century; -fx-background-color: transparent;-fx-background-radius: 30;", 150, 60, 580, 438, 10, Color.AQUA);
        Boton ver= new Boton("Ver","-fx-font: 20 century;-fx-background-color: transparent;-fx-background-radius: 30;", 150, 60, 460, 60, 10, Color.AQUA);
        windowPuntajes.getChildren().addAll(vi);
        windowPuntajes.getChildren().addAll(titulo1.getL(),titulo2.getL(),regreso.getBtn(),niveles,ver.getBtn());
        windowPuntajes.getChildren().addAll(jugador.getL(),puntaje.getL(),name1.getL(),name2.getL(),name3.getL(),name4.getL(),name5.getL(),name6.getL(),name7.getL(),name8.getL(),name9.getL(), name10.getL());
        windowPuntajes.getChildren().addAll(puntaje1.getL(),puntaje2.getL(),puntaje3.getL(),puntaje4.getL(),puntaje5.getL(), puntaje6.getL(),puntaje7.getL(),puntaje8.getL(),puntaje9.getL(), puntaje10.getL());
        regreso.getBtn().setOnAction(new regresar());
        ver.getBtn().setOnAction(new verPuntaje());
        Scene scenePuntajes = new Scene(this.windowPuntajes, 890, 500);
        this.sc=this.stagePrincipal.getScene();
        this.stagePrincipal.setScene(scenePuntajes);
    
    }

    /**
     * Método que devuelve el stage del juego.
     * @return Stage
     */
    public Stage getS() {
        return s;
    }

    /**
     * Método que modifica el stage del juego.
     * @param s de tipo Stage que representa el stage del juego.
     */
    public void setS(Stage s) {
        this.s = s;
    }

    /**
     * Método que devuelve la escena de la ventana Puntajes.
     * @return Scene
     */
    public Scene getSc() {
        return sc;
    }

    /**
     * Método que modifica la escena de la ventana Puntajes.
     * @param sc de tipo Scene que representa la escena de la ventana Reglas.
     */
    public void setSc(Scene sc) {
        this.sc = sc;
    }
    
    private class regresar implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            stagePrincipal.setScene(sc);
            
        }
    }
    
    
    private class verPuntaje implements EventHandler<ActionEvent>{
        @Override
        public void handle (ActionEvent e){
            System.out.println(niveles.getValue().toString());
            String a=niveles.getValue().toString();
            a=a.concat(".txt");
            System.out.println(a);
            leerAndOrdenarDatos(a);
            
            
        }
    }
    
    /**
     * Método para ordenar y mostrar el top de puntajes de los jugadores.
     * @param s de tipo String que representa el nombre del archivo.
     */
    public void leerAndOrdenarDatos(String s)
    {
        ArrayList<Jugador>jugadores= new ArrayList<>();
            
                file= new File(s);
                try {
                    System.out.println("sadgsadf");   
                 fr = new FileReader(file);
                 br = new BufferedReader(fr);
                 try{
                 String st = br.readLine();
                 while(st!= null){
                     String array[]= st.split(",");
                     jugadores.add(new Jugador (array[0],Integer.parseInt(array[1])));
                     System.out.println(array[0]);
                     st = br.readLine();
                 }
                 }catch(Exception e1){
                     System.out.println("error");
                 }
                 Collections.sort(jugadores);
                 System.out.println("333sdafsdaf");
                 if(jugadores.size()>10)
                 name1.getL().setText(jugadores.get(0).getNombre());
                 puntaje1.getL().setText(Integer.toString(jugadores.get(0).getPuntaje()));
                 
                 name2.getL().setText(jugadores.get(1).getNombre());
                 puntaje2.getL().setText(Integer.toString(jugadores.get(1).getPuntaje()));
                 
                 name3.getL().setText(jugadores.get(2).getNombre());
                 puntaje3.getL().setText(Integer.toString(jugadores.get(2).getPuntaje()));
                 
                 name4.getL().setText(jugadores.get(3).getNombre());
                 puntaje4.getL().setText(Integer.toString(jugadores.get(3).getPuntaje()));
                 
                 name5.getL().setText(jugadores.get(4).getNombre());
                 puntaje5.getL().setText(Integer.toString(jugadores.get(4).getPuntaje()));
                 
                 name6.getL().setText(jugadores.get(5).getNombre());
                 puntaje6.getL().setText(Integer.toString(jugadores.get(5).getPuntaje()));
                 
                 name7.getL().setText(jugadores.get(6).getNombre());
                 puntaje7.getL().setText(Integer.toString(jugadores.get(6).getPuntaje()));
                 
                 name8.getL().setText(jugadores.get(7).getNombre());
                 puntaje8.getL().setText(Integer.toString(jugadores.get(7).getPuntaje()));
                 
                 name9.getL().setText(jugadores.get(8).getNombre());
                 puntaje9.getL().setText(Integer.toString(jugadores.get(8).getPuntaje()));
                 
                 name10.getL().setText(jugadores.get(9).getNombre());
                 puntaje10.getL().setText(Integer.toString(jugadores.get(9).getPuntaje()));
                 
                 br.close();
                 fr.close();
                 
                 
               }catch (Exception e2) {
                    System.out.println("no lee");
               }

    }
    
    /**
     * Método que devuelve el panel de la ventana Puntajes.
     * @return windowPuntajes
     */
    public Pane getWindowPuntajes() {
        return windowPuntajes;
    }

    /**
     * Método que modifica el panel de la ventana Puntajes.
     * @param windowPuntajes de tipo Pane que representa el panel de la ventana Puntajes.
     */
    public void setWindowPuntajes(Pane windowPuntajes) {
        this.windowPuntajes = windowPuntajes;
    }

    /**
     * Método que devuelve la ventana principal del juego.
     * @return stagePrincipal
     */
    public Stage getStagePrincipal() {
        return stagePrincipal;
    }

    /**
     * Método que modifica la ventana principal del juego.
     * @param stagePrincipal de tipo Stage que representa la ventana principal del juego.
     */
    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    }

    /**
     * Método que devuelve la ventana de puntajes del juego.
     * @return stagePuntajes
     */
    public Stage getStagePuntaje() {
        return stagePuntaje;
    }

    /**
     * Método que modifica el stage de puntajes del juego.
     * @param stagePuntaje de tipo Stage que representa el stage de puntajes del juego.
     */
    public void setStagePuntaje(Stage stagePuntaje) {
        this.stagePuntaje = stagePuntaje;
    }
    
    
}