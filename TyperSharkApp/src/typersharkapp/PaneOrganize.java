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
public class PaneOrganize 
{
    private Pane Inicio;
    private Image imagen;
    private ImageView vi;
    private Stage stagePrincipal;
    private Reglas reglas;
    private InicioJuego inicioJuego;
    private Puntajes puntajes;
    
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
        
        Boton iniciar= new Boton("Iniciar Partida","-fx-font: 20 century; -fx-background-color: transparent; -fx-background-radius: 30;", 200, 60, 130, 410, 10, Color.AQUA);
        Boton regla= new Boton("Reglas","-fx-font: 20 century; -fx-background-color: transparent; -fx-background-radius: 30;", 100, 60, 330, 410, 10, Color.AQUA);
        Boton puntaje= new Boton("Top de puntajes","-fx-font: 20 century; -fx-background-color: transparent;-fx-background-radius: 30;", 180, 60, 450, 410, 10, Color.AQUA);
        Boton salir= new Boton("Salir","-fx-font: 20 century; -fx-background-color: transparent;-fx-background-radius: 30;", 100, 60, 660, 410, 10, Color.AQUA);
        
        //AGREGANDO NODOS A LAS VENTANAS
        Inicio.getChildren().add(vi);
        Inicio.getChildren().addAll(Ttot.getL(),iniciar.getBtn(),regla.getBtn(),puntaje.getBtn(),salir.getBtn());
        
        
        reglas = null;
        puntajes = null;
        inicioJuego = null;
        
        //ACCIONES DE LOS BOTONES
        regla.getBtn().setOnAction(new ventanaReglas());
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
            getPuntajes().getStagePuntajes().show();
            stagePrincipal.hide();
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
                setInicioJuego(new InicioJuego(getStagePrincipal()));
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