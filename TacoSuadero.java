import javafx.scene.control.Label;
public class TacoSuadero extends Taco{
    private Label img= new Label("");
    public TacoSuadero(){
        super("Suadero", 100,20,15,3,20);
        AtaqueEspecial[] especial=new AtaqueEspecial[4];
        especial[0]=new AtaqueEspecial("Carne de dudosa procedencia",40);
        especial[1]=new AtaqueEspecial("tomatazo",30);
        especial[2]=new AtaqueEspecial("",25);
        especial[3]=new AtaqueEspecial("Aceite hirviendo",20);
        
        super.setAtaqueEspecial(especial);
        img.setPrefSize(500,300);
        img.setStyle("-fx-background-image:url('assets/tacos.jpg');-fx-background-size: stretch;");
        super.setImg(img);
    }
    

   public void atack(Personaje enemigo){
   	System.out.println("Ataque de Tlaxcalli Pastor");
   	enemigo.setHp(enemigo.getHp()-(getAtaque()-enemigo.getDefensa()));
   }
 }
   
