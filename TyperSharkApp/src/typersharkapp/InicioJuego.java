package typersharkapp;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.ENTER;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class InicioJuego
{
    private Pane juego;
    private Image fondo,fondoU;
    private ImageView iv,ivU;
    private KeyHandler eventoTeclado;
    private Boton salir;
    private Boton jugar;
    private FileReader archivo;
    private Buceador jugador;
    private Stage stagePrincipal;
    private Stage stageInicioJuego;
    private Stage stageIngresoDatos;
    private Queue<AnimalesMarinos> animales = new LinkedList<>();
    
    private Pane ingresoDatos;
    private TextField campoNombre;
    
    private BorderPane panelJuego;
    
    private GridPane menu;
    private Label lbNombre, lbNivel, lbPuntaje, lbVidas;
    
    private JuegoAnimales conjuntoHilosAnimales;
    
    public InicioJuego(Stage stageP)
    {
        try{
            fondo = new Image("FondoJuego.jpg");
            
        }
        catch(Exception e)
        {
            System.out.println("No lee imagen");
        }
        
        this.stagePrincipal = stageP;
        
        this.panelJuego = new BorderPane();
        
        
        
        iv = new ImageView(fondo);
        iv.setFitHeight(510);
        iv.setFitWidth(900);
        iv.setImage(fondo);
        
        
        this.menu = new GridPane();
        
        //Stage del Ingreso del nombre del jugador.
        this.stageIngresoDatos = new Stage();
        
        try{
            fondoU= new Image("Menu.png");
        
        }
        catch(Exception e){System.out.println("No lee imagen");}
        
        ivU = new ImageView(fondo);
        ivU.setFitHeight(510);
        ivU.setFitWidth(900);
        ivU.setImage(fondo);
        
        TitulosLabel label = new TitulosLabel("Ingrese su nombre:", "-fx-font: 25 elephant",450,10,200,250, Color.DARKGRAY);
        this.campoNombre = new TextField();
        this.campoNombre.setLayoutX(450);
        this.campoNombre.setLayoutY(255);
        this.ingresoDatos = new Pane();
        this.jugar = new Boton("Start","-fx-font: 20 century; -fx-background-color: transparent;-fx-background-radius: 30;", 150, 60, 5, 438, 10, Color.AQUA);        
        Scene sceneIngresoDatos = new Scene(this.ingresoDatos, 890, 500);
        this.stageIngresoDatos.setTitle("Ingreso de Datos");
        this.stageIngresoDatos.setScene(sceneIngresoDatos);
        this.stageIngresoDatos.setResizable(false);
        this.ingresoDatos.getChildren().add(ivU);
        this.ingresoDatos.getChildren().addAll(iv, campoNombre, label.getL(), jugar.getBtn());
        this.jugar.getBtn().setOnAction(new Jugar());
        
        
        
        //Stage del panel en donde sale el buceador y las criaturas marinas.
        salir = new Boton("Regresar","-fx-font: 20 century; -fx-background-color: transparent;-fx-background-radius: 30;", 150, 60, 730, 438, 10, Color.AQUA);
        stageInicioJuego = new Stage();
        juego = new Pane();
        Scene sceneInicioJuego = new Scene(this.panelJuego, 890, 525);
        stageInicioJuego.setTitle("TyperShark");
        stageInicioJuego.setScene(sceneInicioJuego);
        stageInicioJuego.setResizable(false);
        
        juego.getChildren().addAll(iv, salir.getBtn());
        
        this.panelJuego.setCenter(juego);
        this.panelJuego.setTop(menu);
        
        salir.getBtn().setOnAction(new Salir());
        
    }

     private class KeyHandler implements EventHandler<KeyEvent>
    {
         private ArrayList<AnimalesMarinos> animal;
         private Buceador buzo;
         
         public KeyHandler(ArrayList<AnimalesMarinos> a, Buceador jugador)
         {
             this.animal = a;
             this.buzo = jugador;
         }
        
        @Override
        public void handle(KeyEvent keyEvent)
        {
            try
            {
                System.out.println("TECLA PRESIONADA "+ keyEvent.getText().charAt(0));
                if (keyEvent.getCode().isLetterKey())
                {
                    String A=this.animal.get(0).getPalabra();
                    String B=this.animal.get(1).getPalabra();
                    String C=this.animal.get(2).getPalabra();
                    String D=this.animal.get(3).getPalabra();
                   //System.out.println(A+""+B+""+C+""+D);
                    if(!A.isEmpty())
                        if((A.charAt(0) ==keyEvent.getText().charAt(0)))
                        {
                            System.out.println("ENTRA0");
                            this.animal.get(0).setPalabra(A.substring(1));
                            
                        }
                    if(!B.isEmpty())
                        if((B.charAt(0) ==keyEvent.getText().charAt(0)))
                        {
                            System.out.println("ENTRA1");
                            this.animal.get(1).setPalabra(B.substring(1));

                        }
                    if(!C.isEmpty())
                        if((C.charAt(0) ==keyEvent.getText().charAt(0)))
                        {
                            System.out.println("ENTRA2");
                            this.animal.get(2).setPalabra(C.substring(1));

                        }
                    if(!D.isEmpty())
                        if((D.charAt(0) ==keyEvent.getText().charAt(0)))
                        {
                            System.out.println("ENTRA3");
                            this.animal.get(3).setPalabra(D.substring(1));

                        }
                }
                else if(keyEvent.getCode() == KeyCode.ENTER)
                {
                    System.out.println("ENTER");
                    if(this.buzo.getPoder() >= 500)
                    {
                        System.out.println("Se uso el poder.");
                        //this.animal.clear();
                        
                        this.buzo.setPuntaje(this.buzo.getPuntaje() - 500);
                        this.buzo.setPoder(0);

                        this.animal.get(0).setBandera(1);
                        this.animal.get(1).setBandera(1);
                        this.animal.get(2).setBandera(1);
                        this.animal.get(3).setBandera(1);

                    }
                }
                else if(keyEvent.getCode() == KeyCode.CONTROL){
                    this.buzo.setVidas(this.buzo.getVidas()+1);
                
                }
                
            }
            catch(Exception ex)
            {
                ex.getStackTrace();
            }
        }
    }
     
    public KeyHandler getEventoTeclado() {
        return eventoTeclado;
    }
    
    private class Jugar implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            try
            {
                stageIngresoDatos.hide();
            
                stageInicioJuego.show();
                jugador = new Buceador(juego, campoNombre.getText());
                jugador.adjuntarBuceador(juego);

                menu.setStyle("-fx-background-color: #778899;");
                lbNombre = new Label("Nombre Jugador:");
                lbNombre.setStyle("-fx-font: 14 elephant");
                lbNombre.setTextFill(Color.AQUA);
                lbNivel = new Label("Nivel:");
                lbNivel.setStyle("-fx-font: 14 elephant");
                lbNivel.setTextFill(Color.AQUA);
                lbPuntaje = new Label("Puntaje:");
                lbPuntaje.setStyle("-fx-font: 14 elephant");
                lbPuntaje.setTextFill(Color.AQUA);
                lbVidas = new Label("Vidas:");
                lbVidas.setStyle("-fx-font: 14 elephant");
                lbVidas.setTextFill(Color.AQUA);
                menu.add(lbNombre, 0, 0);
                menu.add(jugador.getLb_nombre(), 1, 0);
                menu.add(lbVidas, 0, 1);
                menu.add(jugador.getLb_vidas(), 1, 1);
                menu.add(lbPuntaje, 2, 0);
                menu.add(jugador.getLb_puntaje(), 3, 0);
                menu.add(lbNivel, 2, 1);
                menu.add(jugador.getLb_nivel(), 3, 1);

                conjuntoHilosAnimales = new JuegoAnimales(animales, jugador, juego, "Palabras.txt");

                eventoTeclado = new KeyHandler(conjuntoHilosAnimales.getAnimalesEnJuego(), jugador);
                stageInicioJuego.addEventHandler(KeyEvent.KEY_PRESSED, eventoTeclado);

                conjuntoHilosAnimales.start();
                jugador.start();
            }
            catch(Exception ex)
            {
                System.err.println("Error");
            }
        }
    }
    
    private class Salir implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e)
        {
            stageInicioJuego.close();
            stagePrincipal.show();
        }
    }

    
    

    
    public Stage getStageIngresoDatos() {
        return stageIngresoDatos;
    }

    public void setStageIngresoDatos(Stage stageIngresoDatos) {
        this.stageIngresoDatos = stageIngresoDatos;
    }
    
    public Stage getStagePrincipal() {
        return stagePrincipal;
    }

    public void setStagePrincipal(Stage stage) {
        this.stagePrincipal = stage;
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

    public Stage getStageInicioJuego() {
        return stageInicioJuego;
    }
    
}