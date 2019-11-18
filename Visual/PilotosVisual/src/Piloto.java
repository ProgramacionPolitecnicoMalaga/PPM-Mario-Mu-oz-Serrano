public class Piloto extends PilotosVisual {

    private String nombre;
    private String escuderia;
    private int posicionDeSalida;
    private int posicionActual;

    public Piloto(String nombre, String escuderia, int posicionDeSalida, int posicionActual){
        this.nombre=nombre;
        this.escuderia=escuderia;
        this.posicionDeSalida=posicionDeSalida;
        this.posicionActual=posicionActual;
    }

    public String getNombre(){
        return nombre;
    }

    public String getEscuderia(){
        return escuderia;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual){
        this.posicionActual=posicionActual;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "Nombre: " + nombre +
                ", Escuderia: " + escuderia +
                ", Posición de salida: " + posicionDeSalida +
                ", Posición actual: " + posicionActual +
                "}\n";
    }
}