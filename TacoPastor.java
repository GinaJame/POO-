import javafx.scene.control.Label;
public class TacoPastor extends Taco{
    private Label img= new Label("");
    public TacoPastor(){
        super("Pastor", 100,20,10,5,17);
        AtaqueEspecial[] especial=new AtaqueEspecial[4];
        especial[0]=new AtaqueEspecial("Carnazo",35);
        especial[1]=new AtaqueEspecial("Lanzar guajillo en los ojos",30);
        especial[2]=new AtaqueEspecial("Cachetada de Tortilla",25);
        especial[3]=new AtaqueEspecial("Aceite hirviendo",20);
        
        super.setAtaqueEspecial(especial);
        img.setPrefSize(500,300);
        img.setStyle("-fx-background-image:url('assets/tacop.jpg');");
        super.setImg(img);
    }
    

   public void atack(Personaje enemigo){
   	System.out.println("Ataque de Tlaxcalli Pastor");
   	enemigo.setHp(enemigo.getHp()-(getAtaque()-enemigo.getDefensa()));
   }

}