import java.util.Scanner;
public class Batalla{

	public Batalla(Taco p1, Personaje p2){
	int vida=p2.getHp();
		while(p1.getHp()>0&&p2.getHp()>0){
			System.out.println("Como quieres atacar? 1) Normal 2) Ataque Especial 3) Condimentos");
			Scanner sc= new Scanner(System.in);
			switch(sc.nextInt()){
				case 1: 
					p1.atacar(p2);
					break;
				case 2:
					System.out.print("Con que habilidad quieres atacar? ");
					for(int i=0;i<p1.getespeciales().length;i++){
						System.out.print((i+1)+" "+p1.getespeciales()[i].getNombre()+" ["+p1.getespeciales()[i].getPuntosEspeciales()+"] ");
					}
					System.out.println("");
					p1.atacar(p2,p1.getespeciales()[sc.nextInt()-1]);
					break;
				case 3:
					System.out.print("Con que objeto quieres atacar? ");
					for(int i=0;i<p1.getMorral().length;i++){
						if(p1.getMorral()[i]!=null){
							System.out.print((i+1)+" "+p1.getMorral()[i].getNombre()+" ["+p1.getMorral()[i].getPuntos()+"] ");
						}else{
							System.out.print((i+1)+" Vacio " );

						}
					}
					int opcionElegida=sc.nextInt();
						p1.atacar(p2,p1.getMorral()[opcionElegida-1],(opcionElegida-1));
					break;	
				default:
					System.out.println("Pierdes tu turno");

			}
			if(p2.getHp()>0){
				p2.atacar(p1);
			}

			System.out.println(p1.toString());
			System.out.println(p2.toString());

		}
		System.out.println("**************");
		if(p2.getHp()<=0){
			System.out.println("GANASTE ");
		}else if(p1.getNumVidas()>0){
			System.out.println(p2.getTipo()+" ha logrado vencerte, regresas a la batalla");
			System.out.println("**************");
			p1.setHp(100);
			p2.setHp(vida);
			//Batalla b= new Batalla(Taco, Personaje);
		}else{
			System.out.println(p2.getTipo()+" ha logrado vencerte y perdiste tu última vida");
		}
	}


}