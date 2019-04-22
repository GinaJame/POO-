public class Condimento{
    String nombre;
    int puntos;
    int gastoE;
    public Condimento(String nombre, int puntos,int gastoE){
        this.nombre=nombre;
        this.puntos=puntos;
        this.gastoE=gastoE;
    }
    public String getNombre(){
        return nombre;
    }
    public int getPuntos(){
        return puntos;
    }
    public int getGastoE(){
        return gastoE;
    }
}