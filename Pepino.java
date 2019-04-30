import javafx.scene.control.Label;
public class Pepino extends Personaje{
    private Label img= new Label("");
    public Pepino(){
        super("Pepino",100,0,3,0);img.setPrefSize(500,300);
    img.setStyle("-fx-background-image:url('assets/pepino.jpg'); -fx-background-size: stretch;");
    super.setImg(img);
    }
}