import javafx.scene.control.Label;
public class TacoChoriqueso extends Taco{
    private Label img= new Label("");
    public TacoChoriqueso(){
        super("Choriqueso", 100,30,10,1,13);
        AtaqueEspecial[] especial=new AtaqueEspecial[4];
        especial[0]=new AtaqueEspecial("Choricombo",40);
        especial[1]=new AtaqueEspecial("Látigo de Queso",20);
        especial[2]=new AtaqueEspecial("Lluvia de Chorizo",25);
        especial[3]=new AtaqueEspecial("Agrasador",20);
        
        super.setAtaqueEspecial(especial);
        img.setPrefSize(500,300);
        img.setStyle("-fx-background-image:url('assets/tacoch.jpg'); -fx-background-size: stretch;");
        super.setImg(img);
    }
    

   public void atack(Personaje enemigo){
   	System.out.println("Ataque de Tlaxcalli Pastor");
   	enemigo.setHp(enemigo.getHp()-(getAtaque()-enemigo.getDefensa()));
   }

}