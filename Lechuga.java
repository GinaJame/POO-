import javafx.scene.control.Label;
public class Lechuga extends Personaje{
    private Label img= new Label("");
    public Lechuga(){
        super("Lechuga",50,0,2,0);
        img.setPrefSize(500,300);
        img.setStyle("-fx-background-image:url('assets/lechuga.jpg');");
        super.setImg(img);
    }
}