public class AtaqueEspecial {
	private String nombre; 
	private int poder; 

	public AtaqueEspecial(String nombre, int poder){

		this.nombre=nombre; 
		this.poder=poder; 
	}

	public String getNombre(){
		return nombre;
	}

	public int getPuntosEspeciales(){
		return poder;
	}
}