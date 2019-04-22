import javafx.scene.control.Label;
public class Trumpito extends Personaje{
    private Label img= new Label("");
    public Trumpito(){
        super("Trumpito",10,0,5,0);
        img.setPrefSize(500,300);
        img.setStyle("-fx-background-image:url('assets/trumpito.jpg');");
        super.setImg(img);
    }
}