import javafx.scene.control.Label;
public class Gringa extends Boss{
    private Label img= new Label("");
    public Gringa(){
        super("Gringa",200,0,18,0,0);
        img.setPrefSize(500,300);
        img.setStyle("-fx-background-image:url('assets/gringa.jpg');");
        super.setImg(img);
    }

}