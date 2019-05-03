import java.util.Optional;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.layout.VBox;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.event.EventHandler;
public class Final extends Scene{
    private BorderPane bp= new BorderPane();

    public Final(Main main){
        super(new BorderPane(),1024,700);
        Label titulo= new Label("LOGRASTE VENCER A TODOS TUS ENEMIGOS");
        Label despedida= new Label("Felicidades! Gracias a tu ayuda Tlaxcalli logró vencer a sus enemigos y ser la comida más sexy.");
        Button continuar = new Button("CERRAR");
        
        VBox ultimo=new VBox();
        ultimo.getChildren().addAll(titulo,despedida);
        bp.setCenter(ultimo);
        bp.setStyle("-fx-background-image:url('assets/fin.jpg'); -fx-background-size: stretch;");
        ultimo.setStyle("-fx-alignment: center; -fx-padding: 30px;");
        titulo.setStyle("-fx-alignment: top-center;");
        super.setRoot(bp);
    }
}