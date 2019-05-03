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
import java.io.Serializable;

public abstract class MapaPlan extends Scene implements Serializable{
    private GridPane m1= new GridPane();
    private BorderPane m2= new BorderPane();
    private Button c,vacio;
    private Button perso= new Button();
    private Button [][] casilla= new Button[10][10];
    private Main main;
    private int i,j,b1,b2,a1,a2,d1,d2,primeraVez,primeraVez2,sE,sHp;
    private Taco taquito;
    private String nom, inventario;
    private Button seguir;
    private HBox abajo;
    private int morral;
    private boolean encontroArma,encontroDefensa,entroPelea,agarroVida,agarroEnergia;
    private Personaje secuaz; 
    private Boss boss;
    private Label mensaje= new Label("Bienvenido al mapa");

   
    public MapaPlan(Taco taquito, Main main,int b1, int b2, int a1, int a2, int d1, int d2, int i, int j, Personaje secuaz, Boss boss,int morral,int sHp,int sE,boolean encontroArma,boolean encontroDefensa,boolean entroPelea,boolean agarroVida,boolean agarroEnergia){

       super(new GridPane(),800,900);
       this.main=main;
       this.taquito=taquito;
       this.b1=b1;
       this.b2=b2;
       this.a1=a1;
       this.a2=a2;
       this.d1=d1;
       this.d2=d2;
       this.i=i;
       this.j=j;
       this.morral=morral;
       this.secuaz=secuaz;
       this.boss=boss;     
       this.sE=sE;
       this.sHp=sHp; 
       nom=taquito.getTipo();
       mensaje.setPrefSize(600,50);
       primeraVez=i;
       primeraVez2=j;
       mensaje.setStyle("-fx-background-color:white;");
        switch (nom){
            case "Suadero":
                perso.setStyle("-fx-background-image:url('assets/tacos.jpg'); -fx-background-size: stretch;");break;
            case "Pastor":
                perso.setStyle("-fx-background-image:url('assets/tacop.jpg'); -fx-background-size: stretch;");break;
            default:
                perso.setStyle("-fx-background-image:url('assets/tacoch.jpg'); -fx-background-size: stretch;");break;
        }
       perso.setPrefSize(90,90);
       pintar(); 
       Button pushInventario= new Button("Morral");
       pushInventario.setPrefSize(150,50);
       pushInventario.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){               
                inventario=taquito.dameInventario();
                mensaje.setText(inventario);
                m2.setBottom(abajo);
            }
        });
       Button datos= new Button("Tus datos");
       datos.setPrefSize(150,50);
       datos.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){               
                mensaje.setText(taquito.toString());
                m2.setBottom(abajo);
            }
        });
        m2.setCenter(m1);
        abajo= new HBox();
        abajo.setStyle("fx-background-color:white");
        abajo.getChildren().addAll(mensaje,pushInventario,datos);
        m2.setBottom(abajo);
        m2.setStyle("-fx-background-image:url('assets/taqueria2.jpg'); -fx-background-size: stretch;");
        super.setRoot(m2);
    }
    public void pintar(){
    Button signo = new Button();
    signo.setStyle("-fx-background-image:url('assets/int.png');");
        for(int a=0;a<10;a++){
            for(int b=0;b<10;b++){
                c =new Button(" ");
                c.setPrefSize(80, 80);
                if(a==i&&b==j){
                        casilla[a][b]=perso;
                }else if(((a==a1)&&(b==a2))&&(encontroArma==false)){    
                        c.setStyle("-fx-background-image:url('assets/int.jpg'); -fx-background-size: stretch;");
                        casilla[a][b]=c;
                }else if(((a==d1)&&(b==d2))&&(encontroDefensa==false)){    
                        c.setStyle("-fx-background-image:url('assets/int.jpg'); -fx-background-size: stretch;");
                        casilla[a][b]=c;
                }else if(((a==b1)&&(b==b2))&&(entroPelea==false)){    
                        c.setStyle("-fx-background-image:url('assets/int.jpg'); -fx-background-size: stretch;");
                        casilla[a][b]=c;
                }else if(((a==sHp)&&(b==sHp))&&(agarroVida==false)){             
                        c.setStyle("-fx-background-image:url('assets/cor.jpg'); -fx-background-color: transparent; -fx-background-size: stretch;");
                        casilla[a][b]=c;
                }else if(((a==sE)&&(b==sE))&&(agarroEnergia==false)){             
                        c.setStyle("-fx-background-image:url('assets/ray.jpg');-fx-background-color: transparent; -fx-background-size: stretch;");
                        casilla[a][b]=c;
                }else{
                    c.setStyle("-fx-background-color: transparent;");
                    casilla[a][b]=c; 
                }
                m1.add(casilla[a][b],a,b);
                moverse(casilla[a][b],b1,b2,a1,a2,d1,d2);
                
            }
        }
    }
    public void moverse(Button m, int b1, int b2, int a1, int a2, int d1, int d2){       
        m.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                try{
                    switch (ke.getCode()) { 
                        case UP: j--;  
                            casilla[i][j+1].setStyle("-fx-background-image:none;-fx-background-color: transparent;");
                            casilla[i][j+1].setText(" ");break;
                        case RIGHT: i++;
                            casilla[i-1][j].setStyle("-fx-background-image:none;-fx-background-color: transparent;");
                            casilla[i-1][j].setText(" ");break; 
                        case DOWN:  j++;
                            casilla[i][j-1].setStyle("-fx-background-image:none;-fx-background-color: transparent;");
                            casilla[i][j-1].setText(" ");break;  
                        case LEFT:  i--;
                            casilla[i+1][j].setStyle("-fx-background-image:none;-fx-background-color: transparent;");
                            casilla[i+1][j].setText(" ");break;
                            }
                    switch (nom){
                        case "Suadero":
                            casilla[i][j].setStyle("-fx-background-image:url('assets/tacos.jpg');-fx-background-size: stretch;");break;
                        case "Pastor":
                            casilla[i][j].setStyle("-fx-background-image:url('assets/tacop.jpg');-fx-background-size: stretch;");break;
                        default:
                            casilla[i][j].setStyle("-fx-background-image:url('assets/tacoch.jpg');-fx-background-size: stretch;");break;
                    }
                    casilla[i][j].setText(nom);
                    if((i==9)&&(j==9)){
                        main.pelear(boss,9,9);
                    }
                    if((primeraVez==0)&&(primeraVez2==0)){
                        if(((i==sHp)&&(j==sHp))&&(agarroVida==false)){             
                            SumarHP(sHp);
                            mensaje.setText(taquito.toString());
                            m2.setBottom(abajo);
                            agarroVida=true;
                        }
                        if(((i==sE)&&(j==sE))&&(agarroEnergia==false)){             
                            SumarEner(sE);
                            mensaje.setText(taquito.toString());
                            m2.setBottom(abajo);
                            agarroEnergia=true;
                        }
                        if(((i==b1)&&(j==b2))&&(entroPelea==false)){             
                            main.pelear(secuaz,i,j);
                            entroPelea=true;
                        }
                        if(((i==a1)&&(j==a2))&&(encontroArma==false)){
                            Arma(morral);
                            inventario=taquito.dameInventario();
                            mensaje.setText("Encontraste un arma: "+inventario);
                            m2.setBottom(abajo);
                            encontroArma=true;
                        }
                        if(((i==d1)&&(j==d2))&&(encontroDefensa==false)){
                            Defensa(morral);
                            inventario=taquito.dameInventario();
                            mensaje.setText("Encontraste un arma: "+inventario);
                            m2.setBottom(abajo);
                            encontroDefensa=true;
                        }
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("Choco con pared");
                    if(i>=10){i=9;}
                    if(i<=-1){i=0;}
                    if(j>=10){j=9;}
                    if(j<=-1){j=0;}
                    switch (nom){
            case "Suadero":
                casilla[i][j].setStyle("-fx-background-image:url('assets/tacos.jpg'); -fx-background-size: stretch;");break;
            case "Pastor":
                casilla[i][j].setStyle("-fx-background-image:url('assets/tacop.jpg'); -fx-background-size: stretch;");break;
            default:
                casilla[i][j].setStyle("-fx-background-image:url('assets/tacoch.jpg'); -fx-background-size: stretch;");break;
        }
                }
            }
        }); 
    }  
    public void setM(int morral){
        this.morral=morral;
    }
    public int getM(){
        return morral;
    }
    public void SumarHP(int sumHp){taquito.setHp(taquito.getHp()+sumHp);}
    public void SumarEner(int sumE){taquito.setEnergia(taquito.getEnergia()+sumE);}
    public abstract void Arma(int x);
    public abstract void Defensa(int y);
}