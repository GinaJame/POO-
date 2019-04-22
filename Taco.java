import java.util.Scanner;
import javafx.scene.control.Label;
public abstract class Taco extends Personaje{
	
	private AtaqueEspecial[] especiales;
	private Condimento[] morral;
	private int golpeF;
	private int numVidas=3;


	public Taco(String tipo, int hp, int energia, int ataque, int defensa, int golpeF){
		super(tipo, hp, energia, ataque, defensa);
		morral= new Condimento[10];
		this.golpeF=golpeF;
	}
	

	public AtaqueEspecial[] getespeciales(){
		return especiales;
	}

	public void setAtaqueEspecial(AtaqueEspecial[] especiales){
		this.especiales=especiales;
	}

	public Condimento[] getMorral(){
		return morral;
	}

	public void addCondimentotoMorral(Condimento c, int index){
		morral[index]=c;
	}
	public void removeCondimentoToMorral(int index){
		morral[index]=null;
	}

	public String dameInventario(){
		String resultado="Morral: [";
		for(int i=0; i<morral.length; i++){
			if(morral[i]!=null){
				resultado=resultado+" Condimento: "+morral[i].getNombre()+" puntos: "+morral[i].getPuntos()+",";
			}
			else{
				resultado=resultado+"Vacío, ";
			}
		}

		resultado=resultado+"]";
		return resultado;
	}


	public String verMiAtaqueEspecial(){
		String resultado="Ataques Especiales: [";
		for(int i=0;i<especiales.length;i++){

			resultado= resultado+" Ataque Especial: "
				+especiales[i].getNombre()
				+" puntos: "+ especiales[i].getPuntosEspeciales()+",";				

		}
		resultado= resultado+"]";
		return resultado;
	}
	public void atacar(Personaje enemigo, int i){
		System.out.println("1)GOLPE NOMAL 2)GOLPE FUERTE");
		Scanner sc= new Scanner(System.in);
		int golpe=sc.nextInt();
		switch(i){
			case 1:
			super.atacar(enemigo);
			break;
			default:
			enemigo.setHp(enemigo.getHp()-(golpeF-enemigo.getDefensa())); 
			setEnergia(getEnergia()-5);

		}
		
	}
	public void atacar(Personaje enemigo, Condimento condimento,int index){
		if(getEnergia()>=condimento.getGastoE()){
			if(condimento.getClass()==Arma.class){
			enemigo.setHp(enemigo.getHp()-(condimento.getPuntos()+getAtaque()-enemigo.getDefensa()));
			setEnergia(getEnergia()-condimento.getGastoE());
			removeCondimentoToMorral(index);
			}else{
				setHp(getHp()+enemigo.getAtaque()-getDefensa());
				enemigo.setHp(enemigo.getHp()-(enemigo.getAtaque()));
				setEnergia(getEnergia()-condimento.getGastoE());
				removeCondimentoToMorral(index);
			}
			}else{
			System.out.println("UPS, no tienes suficiente energía, pierdes tú turno");
			
		}
	}
	public void atacar(Personaje enemigo, AtaqueEspecial AE){
		enemigo.setHp(enemigo.getHp()-(AE.getPuntosEspeciales()-enemigo.getDefensa()));
	}
	public int getNumVidas(){
		return numVidas;
	}
	public void setNumVidas(int numVidas){
		this.numVidas=numVidas;
	}
	
	
}

