package typersharkapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Andy
 */
public class PaneOrganize 
{
    private Pane Inicio;
    private Image imagen;
    private ImageView vi;
    private Stage stagePrincipal;
    private Reglas reglas;
    private InicioJuego inicioJuego;
    private Puntajes puntajes;
    private File file;
    private FileReader fr;
    private BufferedReader br;
    private String datos[];
    
    public PaneOrganize(Stage stageP)
    {
        try{
            imagen= new Image("Menu.png");
        
        }
        catch(Exception e){System.out.println("No lee imagen");}
        
        this.stagePrincipal = stageP;
        
       
        vi=new ImageView(imagen);
        vi.setFitHeight(510);
        vi.setFitWidth(900);
        vi.setImage (imagen);
        
        
        //VENTANA PRINCIPAL
        Inicio= new Pane();
        Inicio.setStyle("-fx-background-color: blue;");
        TitulosLabel Ttot= new TitulosLabel("TYPERSHARK","-fx-font: 40 elephant",450,10,270,30, Color.DARKGRAY);
        
        Boton iniciar= new Boton("Iniciar Partida","-fx-font: 20 century; -fx-background-color: transparent; -fx-background-radius: 30;", 200, 60, 80, 410, 10, Color.AQUA);
        Boton cargar= new Boton("Cargar","-fx-font: 20 century; -fx-background-color: transparent; -fx-background-radius: 30;", 100, 60, 280, 410, 10, Color.AQUA);
        Boton regla= new Boton("Reglas","-fx-font: 20 century; -fx-background-color: transparent; -fx-background-radius: 30;", 100, 60, 400, 410, 10, Color.AQUA);
        Boton puntaje= new Boton("Top de puntajes","-fx-font: 20 century; -fx-background-color: transparent;-fx-background-radius: 30;", 180, 60, 520, 410, 10, Color.AQUA);
        Boton salir= new Boton("Salir","-fx-font: 20 century; -fx-background-color: transparent;-fx-background-radius: 30;", 100, 60, 700, 410, 10, Color.AQUA);
        
        //AGREGANDO NODOS A LAS VENTANAS
        Inicio.getChildren().add(vi);
        Inicio.getChildren().addAll(Ttot.getL(),iniciar.getBtn(),cargar.getBtn(),regla.getBtn(),puntaje.getBtn(),salir.getBtn());
        
        
        reglas = null;
        puntajes = null;
        inicioJuego = null;
        
        //ACCIONES DE LOS BOTONES
        regla.getBtn().setOnAction(new ventanaReglas());
        cargar.getBtn().setOnAction(new cargarPartida());
        salir.getBtn().setOnAction(new Salida());
        iniciar.getBtn().setOnAction(new Iniciar());
        puntaje.getBtn().setOnAction(new ventanaPuntajes());
        
    }
    
    private class ventanaPuntajes implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            setPuntajes(new Puntajes(getStagePrincipal()));
            //getPuntajes().getStagePuntajes().show();
            //stagePrincipal.hide();
            event.consume(); 
        }
    }
    
    private class ventanaReglas implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            if(reglas == null)
            {
                setReglas(new Reglas(getStagePrincipal()));
                getReglas().getStageReglas().show();
                stagePrincipal.hide();
            }
            else
            {
                getReglas().getStageReglas().show();
                stagePrincipal.hide();
            }
            
            event.consume();
        }
    }
    
    private class Iniciar implements EventHandler<ActionEvent>
    {
        
        @Override
        public void handle(ActionEvent event)     
        {
            if(inicioJuego == null)
            {
                setInicioJuego(new InicioJuego(getStagePrincipal(),datos,0));
                getInicioJuego().getStageIngresoDatos().show();
                stagePrincipal.hide();
            }
            else
            {
                getInicioJuego().getStageInicioJuego().show();
                stagePrincipal.hide();
            }
            
            event.consume();
        }
    }
    private class cargarPartida implements EventHandler<ActionEvent>
    {
        
        @Override
        public void handle(ActionEvent event)     
        {
            
            file= new File("Partidas Guardadas.txt");
                try {
                    System.out.println("sadgsadf");   
                    fr = new FileReader(file);
                    br = new BufferedReader(fr);
                    try{
                        String st = br.readLine();
                        //while(st!= null){
                            datos= st.split(",");
                            System.out.println("Nombre "+datos[0]);
                            System.out.println("Nivel "+datos[1]);
                            System.out.println("Puntaje "+datos[2]);
                            System.out.println("Vidas "+datos[3]);
                            st = br.readLine();
                        //}
                    }catch(Exception e1){
                        System.out.println("error");
                    }
                }catch (Exception e2) {
                    System.out.println("no lee");
                }


                setInicioJuego(new InicioJuego(getStagePrincipal(),datos,1));
                getInicioJuego().getStageInicioJuego().show();
                stagePrincipal.hide();
                  
            event.consume();
        }
         
    }
    

    private class Salida implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent e){
            System.out.println("Saliendo...");
            System.exit(0);   
        }
    }

    public Pane getInicio() {
        return Inicio;
    }

    public void setInicio(Pane Inicio) {
        this.Inicio = Inicio;
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

    public Stage getStagePrincipal() {
        return stagePrincipal;
    }

    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    }

    public Reglas getReglas() {
        return reglas;
    }

    public void setReglas(Reglas reglas) {
        this.reglas = reglas;
    }

    public InicioJuego getInicioJuego() {
        return inicioJuego;
    }

    public void setInicioJuego(InicioJuego inicioJuego) {
        this.inicioJuego = inicioJuego;
    }

    public Puntajes getPuntajes() {
        return puntajes;
    }

    public void setPuntajes(Puntajes puntajes) {
        this.puntajes = puntajes;
    }  
}