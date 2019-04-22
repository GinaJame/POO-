import javafx.scene.control.Label;
public class HotDog extends Boss{
    private Label img= new Label("");
    public HotDog(){
        super("Hot Dog",50,10,10,0,13);
        img.setPrefSize(500,300);
        img.setStyle("-fx-background-image:url('assets/hotdog.jpg');");
        super.setImg(img);
    }
    
}