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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
public class Main extends Application{
    private Scene intro = new Intro(this);
    private Scene perso= new Persona(this);
    private Scene mapa,mapa_2,mapa_3,mapa_4,fiinal,m;
    private Stage mainStage;
    private Taco taquito;
    private SceneBatalla sb;
    private BorderPane ultimo;

    public static void main(String[]args){
        launch(args);
    }
    public void start(Stage primaryStage){
        mainStage=primaryStage;
        mainStage.setTitle("CALL OF TACO");
        mainStage.setScene(intro);
        mainStage.show();
        
    }
    public void setScene2(){
        mainStage.setScene(perso);    
    }
    public void setScene3(int x, int y){
        if(x==9&&y==9){setScene4(0,0);   
        }else{
            Personaje secuaz= new Jitomate(); 
            Boss boss= new Ensalada();
            mapa = new Mapa(/*taquito, this,x,y,secuaz,boss,0,7,3*/);
            mainStage.setScene(mapa);                     
            guardar(mapa);
        }
    }
    public void setScene4(int x1, int y1){
        Personaje secuaz= new Trumpito(); 
        Boss boss= new HotDog();
        mapa_2 = new Mapa2(/*taquito,this,x1,y1,secuaz,boss,2,5,4*/);
        guardar(mapa_2);
        mainStage.setScene(mapa_2);
    }
    public void setScene5(int x2, int y2){
        Personaje secuaz= new Pepino(); 
        Boss boss= new Hamburguesa();
        mapa_3 = new Mapa3(/*taquito,this,x2,y2,secuaz,boss,8,6,3*/);
        guardar(mapa_3);
        mainStage.setScene(mapa_3);        
    }
    public void setScene6(int x3, int y3){
        Personaje secuaz= new Muro(); 
        Boss boss= new Gringa();
        mapa_4 = new Mapa4(/*taquito,this,x3,y3,secuaz,boss,4,5,5*/);
        guardar(mapa_4);
        mainStage.setScene(mapa_4);        
    }
    public void setSceneFinal(){
        fiinal = new Final(this);
        mainStage.setScene(fiinal);
        guardar(fiinal);
    }
    public void setTaco(Taco taquito){
        this.taquito=taquito;
    }
    public Taco getTaquito(){
        return taquito;
    }
    public void pelear(Personaje p, int xx, int yy){
        sb= new SceneBatalla(taquito,p,xx,yy,this);
        mainStage.setScene(sb);
    }
    public void guardar(Scene sc){
        try{
			FileOutputStream fout = new FileOutputStream("mapa.atm");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(sc);
			oos.close();
		}catch(IOException ex){

			} 
    }
    public Scene mostrar(){
        try{
			File selectedFile = new File("mapa.atm");
			FileInputStream fin = new FileInputStream(selectedFile);
			ObjectInputStream ois = new ObjectInputStream(fin);
			m=(Scene) ois.readObject();
	    }catch(IOException ex){
			ex.printStackTrace();
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}
        return m;
    }
    

    
}