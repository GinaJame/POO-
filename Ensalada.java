import javafx.scene.control.Label;
public class Ensalada extends Boss{
    private Label img= new Label("");
    public Ensalada(){
        super("Ensalda",150,20,8,5,30);
        img.setPrefSize(500,300);
        img.setStyle("-fx-background-image:url('assets/ensalada.jpg');");
        super.setImg(img);
    }
    

}