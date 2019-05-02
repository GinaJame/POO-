import javafx.scene.control.Label;
public class Jitomate extends Personaje{
    private Label img= new Label("");
    public Jitomate(){
        super("Jitomate",20,0,4,0);
        img.setPrefSize(500,300);
        img.setStyle("-fx-background-image:url('assets/jitomate.jpg'); -fx-background-size: stretch;");
        super.setImg(img);
    }
}