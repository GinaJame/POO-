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
        super(new BorderPane(),1024,700);
        Label titulo= new Label("CALL OF TACO");
        Label historia= new Label("Esta es la historia de Tlaxcalli una tortilla que desea superarse y ser el taco m\u00e1s rico y sexy de la taquer\u00eda para lograrlo deber\u00e1 superar los enemigos mortales de los tacos, los temibles HotDog, la malvada ensalada junto con sus secuazes para finalmente enfretar a su enemiga mortal La Se\u00f1ora Gringa. Unete a est\u00e1 aventura junto a Tlaxcalli para lograr su cometido y terminar de una vez por todas con sus enemigos.");
        Button continuar = new Button("Continuar");
        continuar.setPrefSize(100,50);
        continuar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){               
                main.setScene2();
            }
        });
        VBox his=new VBox();
        his.getChildren().addAll(titulo,historia);
        bp.setCenter(his);
        bp.setBottom(continuar);
        bp.setAlignment(continuar,Pos.BOTTOM_CENTER);
        bp.setStyle("-fx-background-image:url('assets/inicio.png'); -fx-background-size: stretch;");
        his.setStyle("-fx-alignment: center; -fx-padding: 30px;");
        titulo.setStyle("-fx-alignment: top-center;");
        super.setRoot(bp);
    }
}