public class Boss extends Personaje{
	private int ataqueE=0;
    public Boss(String nombre, int hp, int energia, int ataque, int defensa,int ataqueE){
		super(nombre,hp,energia,ataque,defensa);
        this.ataqueE=ataqueE;
	}
    public void atacar(Taco taco){
        int x=(int) Math.floor(Math.random()*5);
        if((x==3)&&(getEnergia()>4)){
            System.out.println("Ataque especial de Hamburguesa");
            taco.setHp(taco.getHp()-(ataqueE-taco.getDefensa()));
            setEnergia(getEnergia()-5);
        }else{
            System.out.println("Ataque normal de Hamburguesaa");
            super.atacar(taco);
        }
    }
}