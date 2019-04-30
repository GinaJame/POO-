import javafx.scene.control.Label;
public class Hamburguesa extends Boss{
    private Label img= new Label("");
    public Hamburguesa(){
        super("Hamburguesa",100,10,14,2,16);
    img.setPrefSize(500,300);
    img.setStyle("-fx-background-image:url('assets/hamb.jpg'); -fx-background-size: stretch;");
    super.setImg(img);
    }
    


}