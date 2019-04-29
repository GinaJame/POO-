import java.util.Scanner;
import javafx.scene.control.TextField;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Button;

public class SceneBatalla extends Scene{
    private Main main;
    private BorderPane bp=new BorderPane();
    private Label l3= new Label("");
    private Label l4;
    private VBox vb= new VBox();
    private Taco t;
    private Personaje p;
    private HBox hb= new HBox();
    private Label fin= new Label("GANASTE");
    private TextField tf;
    private int op,x,y;
    private ComboBox atacar;
    public SceneBatalla(Taco t, Personaje p, int x, int y, Main main){
        super (new BorderPane(),900,900);
        this.main=main;
        this.t=t;
        this.p=p;
        this.x=x;
        this.y=y;
        VBox vb = new VBox();
        Label titulo= new Label("COMIENZA LA BATALLA");
        titulo.setStyle("-fx-background-color:black;");
        titulo.setPrefSize(900,50);
        inicio();
        Label l2=t.getImg();
        Label l5=p.getImg();
        Label l6= new Label("VS");     
		vb.getChildren().addAll(l2,l6,l5);
        bp.setCenter(hb);
        bp.setLeft(vb);
        bp.setTop(titulo);
        super.setRoot(bp);
    }
    public void golpear(String o){
        switch(o){
			case "Normal": 
                l3.setText("¿Como quieres golpear?");
                Button button1 = new Button("Normal");
                button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                    public void handle(MouseEvent e){ 
                        t.atacar(p,1); 
                        p.atacar(t);
                        vb.getChildren().clear();
                        imprimirVida();
                    }
                });
                Button button2 = new Button("Fuerte");
                button2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                    public void handle(MouseEvent e){ 
                        t.atacar(p,2); 
                        p.atacar(t);
                        vb.getChildren().clear();
                        imprimirVida();
                    }
                });
                vb.getChildren().addAll(l3,button1, button2);
                bp.setCenter(vb);
                 
			break;
			case "Ataque Especial":
				l3.setText("Con que habilidad quieres atacar? ");
                vb.getChildren().add(l3);
                ComboBox habilidad= new ComboBox<>();
				for(int i=0;i<t.getespeciales().length;i++){
					habilidad.getItems().add((i+1)+" "+t.getespeciales()[i].getNombre()+" ["+t.getespeciales()[i].getPuntosEspeciales()+"] ");
				}
                vb.getChildren().add(habilidad);
                bp.setCenter(vb);
                setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if(ke.getCode() == KeyCode.ENTER) { 
                    String hab= (String) habilidad.getValue();                                                                  
                    op= Character.getNumericValue(hab.charAt(0));
			            t.atacar(p,t.getespeciales()[op-1]);
                        p.atacar(t);
                        vb.getChildren().clear();
                        imprimirVida();
                }   
            }
        });
				break;
			case "Condimentos":
				l3.setText("Con que objeto quieres atacar? ");
                vb.getChildren().add(l3);
				for(int i=0;i<t.getMorral().length;i++){
					if(t.getMorral()[i]!=null){
						l4= new Label((i+1)+" "+t.getMorral()[i].getNombre()+" ["+t.getMorral()[i].getPuntos()+"] ");
                        vb.getChildren().add(l4);
					}else{
						l4= new Label((i+1)+" Vacio " );
                        vb.getChildren().add(l4);
					}
				}
                tf=new TextField();
                vb.getChildren().add(tf);
                bp.setCenter(vb);
                setOnKeyPressed(new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent ke) {
                        if(ke.getCode() == KeyCode.ENTER) {                                               
                            op= Integer.parseInt(tf.getText());
			                t.atacar(p,t.getMorral()[op-1],(op-1));
                            p.atacar(t);
                            vb.getChildren().clear();
                            imprimirVida();  
                        }   
                    }
                });
				break;	
			default:
				l3.setText("Pierdes tu turno");
                p.atacar(t);
                imprimirVida();  
		}    
    }
    public void inicio(){
        Label l1= new Label("Como quieres atacar?");
        atacar= new ComboBox<>();
        atacar.getItems().add("Normal");
        atacar.getItems().add("Ataque Especial");
        atacar.getItems().add("Condimentos");
		hb.getChildren().addAll(l1,atacar);
        hb.getChildren().remove(l3);
        vb.getChildren().add(hb);
        bp.setCenter(vb);
        setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if(ke.getCode() == KeyCode.ENTER) {                
                    String opcion= (String) atacar.getValue();
                    hb.getChildren().clear();
                    golpear(opcion);
                }
            }
        });
    }
    public void imprimirVida(){
        Label vida = new Label(t.toString());
        Label vidae = new Label(p.toString());
        vb.getChildren().addAll(vida, vidae);
        bp.setCenter(vb);
        
        if(p.getHp()>0&&t.getHp()>0){
            inicio();}else if(p.getHp()<=0){
            vb.getChildren().add(fin);
            bp.setCenter(vb);
            setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                    if(ke.getCode() == KeyCode.ENTER) {                                               
                        String malo=p.getTipo();
                        switch(malo){
                            case "Ensalada":
                                main.setScene4(x,y);
                            break;
                            case "HotDog":
                                main.setScene5(x,y);
                            break;
                            default: System.out.println("no aplica");
                            break;
                        }
                    }   
                }
            });
            }else if(t.getHp()<=0){fin.setText("PERDISTE");
            vb.getChildren().add(fin);
            bp.setCenter(vb);
            t.setHp(100);
			//p.setHp(vida);
            //SceneBatalla(t,p,main);}
            }
    }   
}