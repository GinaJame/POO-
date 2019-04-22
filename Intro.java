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
public class Intro extends Scene{
    private BorderPane bp= new BorderPane();

    public Intro(Main main){
        super(new BorderPane(),1000,1000);
        Label historia= new Label("Esta es la historia de Tlaxcalli una tortilla  que desea superarse y ser el taco más rico y sexy de la taquería para lograrlo deberá súper a los enemigos mortales de los tacos, los temibles hotDog, la malvada ensalada junto con sus secuazes para finalmente enfretar a su enemiga mortal La Señora Gringa. Unete a está aventura junto a Tlaxcalli para lograr su cometido y terminar de una ve por todas con sus enemigos");
        Button continuar = new Button("Continuar");
        continuar.setPrefSize(100,50);
        continuar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){               
                main.setScene2();
            }
        });
        bp.setCenter(historia);
        bp.setBottom(continuar);
        bp.setAlignment(continuar,Pos.BOTTOM_CENTER);
        bp.setStyle("-fx-background-image:url('assets/intro.jpg');");
        super.setRoot(bp);
    }
}