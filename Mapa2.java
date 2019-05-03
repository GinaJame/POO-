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
    private Taco taquito;
    private int morral,sE,sHp;

    public Mapa2(Taco taquito, Main main, int i, int j, Personaje secuaz, Boss boss, int morral,int sHp,int sE,boolean encontroArma,boolean encontroDefensa,boolean entroPelea,boolean agarroVida,boolean agarroEnergia){
       
       super(taquito, main,3,3,6,4,7,7,i,j,secuaz,boss,morral,sHp,sE,encontroArma,encontroDefensa,entroPelea,agarroVida,agarroEnergia);
       this.taquito=taquito;  
       this.morral=morral;    
       this.sE=sE;
       this.sHp=sHp; 
    }
    public void Arma(int morral){
        this.morral=morral;
        Condimento c2= new Arma("Salsa Roja",50,4);
        taquito.addCondimentotoMorral(c2,morral);
        morral++;
        super.setM(morral);
    }
    public void Defensa(int morral){
        this.morral=morral;
        Condimento d2= new Defensa("Limón",15,6);
        taquito.addCondimentotoMorral(d2,morral);
        morral++;
        super.setM(morral);
    }
}