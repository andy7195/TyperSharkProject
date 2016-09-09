package typersharkapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Andy
 */
public class Puntajes {
    private Pane windowPuntajes;
    private Image imagen;
    private ImageView vi; 
    private Stage stagePrincipal;
    private Stage stagePuntajes;
    private TextArea textArea;
    private File file;
    FileReader fr = null;
    BufferedReader br = null;
    String texto = "";
    public Puntajes(Stage stageP) 
    {
        try
        {
            imagen= new Image("Menu.png");
        
        }
        catch(Exception e){System.out.println("No lee imagen");}
        
        windowPuntajes= new Pane();
        this.stagePrincipal = stageP;
        this.stagePuntajes = new Stage();
        Scene scenePuntajes = new Scene(this.windowPuntajes, 890, 500);
        this.stagePuntajes.setTitle("Puntajes");
        this.stagePuntajes.setScene(scenePuntajes);
        this.stagePuntajes.setResizable(false);
        
        
        vi=new ImageView(imagen);
        vi.setFitHeight(510);
        vi.setFitWidth(900);
        vi.setImage (imagen);
        
        
        textArea= new TextArea();
        textArea.setLayoutX(400);
        textArea.setLayoutY(150);
        textArea.setStyle("-fx-font: 18 century;-fx-background-color: transparent;-fx-background-radius: 30;");
        textArea.setPrefSize(180, 270);
        
        
        file= new File("Top10.txt");
        
        try 
        {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String st = br.readLine();
            while (st != null) 
            {
                texto = texto + st + "\n";
                st = br.readLine();
            }
        }
        catch (Exception e) 
        {
            System.out.println("no sale");
            textArea.appendText(e.toString());
        }
        finally 
        {
            try 
            {
                fr.close();
            }
            catch (Exception e2) 
            {
                textArea.appendText(e2.toString());
            }
        }
        textArea.appendText(texto);

        
        TitulosLabel titulo1= new TitulosLabel("TOP 10 MEJORES","-fx-font: 20 elephant",250,10,360,20, Color.DARKGRAY);
        TitulosLabel titulo2= new TitulosLabel("PUNTAJES","-fx-font: 20 elephant;",150,10,400,50, Color.DARKGRAY);
        Boton regreso= new Boton("Regresar","-fx-font: 20 century; -fx-background-color: transparent;-fx-background-radius: 30;", 150, 60, 580, 438, 10, Color.AQUA);
        windowPuntajes.getChildren().addAll(vi);
        windowPuntajes.getChildren().addAll(titulo1.getL(),titulo2.getL(),regreso.getBtn(), textArea);
        regreso.getBtn().setOnAction(new regresar());
    
    
    }

    private class regresar implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e)
        {
            stagePuntajes.hide();
            stagePrincipal.show();
        }
    }

    
    
    public Pane getWindowPuntajes() {
        return windowPuntajes;
    }

    public void setWindowPuntajes(Pane windowPuntajes) {
        this.windowPuntajes = windowPuntajes;
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

    public Stage getStagePuntajes() {
        return stagePuntajes;
    }

    public void setStagePuntajes(Stage stagePuntajes) {
        this.stagePuntajes = stagePuntajes;
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FileReader getFr() {
        return fr;
    }

    public void setFr(FileReader fr) {
        this.fr = fr;
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
}