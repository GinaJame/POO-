import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import java.util.Optional;
import javafx.stage.*;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.event.EventHandler;
public class Persona extends Scene{

    private HBox hb;

    public Persona(Main main){
        super(new HBox(),1000,1000);
        Button pastor= new Button("Taco Pastor");
        pastor.setPrefSize(330,1000);
        pastor.setStyle("-fx-background-image:url('assets/tacop.jpg');");
        pastor.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){   
              Taco taquito= new TacoPastor();
              main.setTaco(taquito);                 
              main.setScene3(0,0);         
            }
        });
        Button chori= new Button("Taco Choriqueso");
        chori.setPrefSize(330,1000);
        chori.setStyle("-fx-background-image:url('assets/tacoch.jpg');");
        chori.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){ 
                Taco taquito = new TacoChoriqueso(); 
                main.setTaco(taquito);             
                main.setScene3(0,0);
            }
        });
        Button suadero= new Button("Taco Suadero");
        suadero.setPrefSize(330,1000);
        suadero.setStyle("-fx-background-image:url('assets/tacos.jpg');");
        suadero.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){  
                Taco taquito = new TacoSuadero();  
                main.setTaco(taquito);           
                main.setScene3(0,0);
            }
        });
        hb = new HBox(pastor,chori,suadero);
        super.setRoot(hb);
    }
}