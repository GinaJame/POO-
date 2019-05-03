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
import java.io.Serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
public class Intro extends Scene implements Serializable{
    private BorderPane bp= new BorderPane();
    private MapaPlan m;

    public Intro(Main main){
        super(new BorderPane(),1024,700);
        Label titulo= new Label("CALL OF TACO");
        Label historia= new Label("Esta es la historia de Tlaxcalli un taco que desea superarse y ser la comida mas rica y sexy del Mundo, para lograrlo deber\u00e1 superar los enemigos mortales de los tacos, los temibles HotDog, la malvada ensalada junto con sus secuazes para finalmente enfretar a su enemiga mortal La Se\u00f1ora Gringa. Unete a est\u00e1 aventura junto a Tlaxcalli para lograr su cometido y terminar de una vez por todas con sus enemigos.");
        
        Button iniciar= new Button("NUEVA PARTIDA");
        Button continuar= new Button("CONTINUAR PARTIDA");
        iniciar.setPrefSize(200,50);
        continuar.setPrefSize(200,50);
        HBox boton= new HBox();
        boton.getChildren().addAll(continuar,iniciar);
        bp.setBottom(boton);
        bp.setAlignment(boton,Pos.BOTTOM_CENTER);
        iniciar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){               
                main.setScene2();
            }
        });
        continuar.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
				public void handle(MouseEvent e){
					try{
						File selectedFile = new File("mapa.atm");
						FileInputStream fin = new FileInputStream(selectedFile);
						ObjectInputStream ois = new ObjectInputStream(fin);
						m=(MapaPlan) ois.readObject();
					}catch(IOException ex){
						ex.printStackTrace();
					}catch(ClassNotFoundException ex){
						ex.printStackTrace();
					}
				}
			}
		);
        VBox his=new VBox();
        his.getChildren().addAll(titulo,historia);
        bp.setCenter(his);
        bp.setStyle("-fx-background-image:url('assets/inicio.png'); -fx-background-size: stretch;");
        his.setStyle("-fx-alignment: center; -fx-padding: 30px;");
        titulo.setStyle("-fx-alignment: top-center;");
        super.setRoot(bp);
    }
}