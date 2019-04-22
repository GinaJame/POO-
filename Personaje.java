import javafx.scene.control.Label;
public class Personaje{

	private int hp;
	private String tipo;
	private int ataque;
	private int defensa;
	private int energia;
	private Label img;
	

	public Personaje(String tipo, int hp, int energia,int ataque,int defensa){
		this.tipo=tipo;
		this.hp=hp;
		this.ataque=ataque;
		this.defensa=defensa;
		this.energia=energia;
	}
	
	public void setTipo(String nombre){
		this.tipo=tipo;
	}

	public String getTipo(){
		return tipo;
	}

	public void setHp(int hp){
		this.hp=hp;
	}

	public int getHp(){
		return hp;
	}

	public void setAtaque(int ataque){
		this.ataque=ataque;
	}

	public int getAtaque(){
		return ataque;
	}

	public void setDefensa(int defensa){
		this.defensa=defensa;
	}
	public int getDefensa(){
		return defensa;
	}
	public int getEnergia(){
		return energia;
	}
	public void setEnergia(int energia){
		this.energia=energia;
	}

	public String toString(){
		return "Personaje: "+tipo+" HP: "+hp+" ataque: "+ataque+" defensa: "+defensa+" energía"+energia;
	}
	public void atacar(Personaje enemigo){
            enemigo.setHp(enemigo.getHp()-(getAtaque()-enemigo.getDefensa()));
    }
	public Label getImg(){
		return img;
	}
	public void setImg(Label img){
		this.img=img;
	}

}