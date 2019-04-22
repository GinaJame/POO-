import java.util.Optional;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Mapa2 extends MapaPlan{
    private GridPane m1= new GridPane();
    private Button c;
    private Button perso= new Button();
    private Button vacio;
    private Button [][] casilla= new Button[10][10];
    private Main main;
    private int i;
    private int j;
    private Taco taquito;
    private String nom;
    private Button seguir;
    private int m=0;


    public Mapa2(Taco taquito, Main main, int i, int j, Personaje secuaz, Boss boss){

       super(taquito, main,3,3,6,4,7,7,i,j,secuaz,boss);
       this.taquito=taquito;
       
    }
    public Button Arma(){
        Condimento c2= new Arma("Salsa Roja",50,4);
        taquito.addCondimentotoMorral(c2,m);
        m++;
        System.out.println("Encontraste una salsa Roja");
        for(int i=0;i<taquito.getMorral().length;i++){
			if(taquito.getMorral()[i]!=null){
				System.out.print((i+1)+" "+taquito.getMorral()[i].getNombre()+" ["+taquito.getMorral()[i].getPuntos()+"] ");
			}else{
				System.out.print((i+1)+" Vacio " );
                }
		}
        Button  salsa= new Button("");
        salsa.setStyle("-fx-background-image:url('assets/piña.jpg');");
        return salsa;
    }
    public void Defensa(){
        Condimento d2= new Defensa("Limón",15,6);
        taquito.addCondimentotoMorral(d2,m);
        m++;
        System.out.println("Encontraste un Limón");
        for(int i=0;i<taquito.getMorral().length;i++){
			if(taquito.getMorral()[i]!=null){
				System.out.print((i+1)+" "+taquito.getMorral()[i].getNombre()+" ["+taquito.getMorral()[i].getPuntos()+"] ");
			}else{
				System.out.print((i+1)+" Vacio " );
                }
		}
    }
}