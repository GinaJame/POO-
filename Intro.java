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
        Label historia= new Label("Esta es la historia de Tlaxcalli una tortilla ");
        Label historia2= new Label("que desea superarse y ser el taco más rico y ");
        Label historia3= new Label("sexy de la taquería para lograrlo deberá súper a ");
        Label historia4= new Label("los enemigos mortales de los tacos, los temibles hotDog, ");
        Label historia5=new Label("la malvada ensalada junto con sus secuazes para finalmente ");
        Label historia6=new Label("enfretar a su enemiga mortal La Señora Gringa. Unete a está ");
        Label historia7=new Label("aventura junto a Tlaxcalli para lograr su cometido y terminar ");
        Label historia8=new Label("de una ve por todas con sus enemigos");
        Button continuar = new Button("Continuar");
        continuar.setPrefSize(100,50);
        continuar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){               
                main.setScene2();
            }
        });
        VBox his=new VBox();
        his.getChildren().addAll(historia,historia2,historia3,historia4,historia5,historia6,historia7,historia8);
        bp.setCenter(his);
        bp.setBottom(continuar);
        bp.setAlignment(continuar,Pos.BOTTOM_CENTER);
        bp.setStyle("-fx-background-image:url('assets/intro.jpg');");
        super.setRoot(bp);
    }
}