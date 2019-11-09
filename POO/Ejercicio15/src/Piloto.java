public class Piloto extends ComparadorAlfabetico implements Comparable<Piloto> {

    String nombre;
    String escuderia;
    int posicionDeSalida;
    boolean descalificado = false;

    public Piloto(String nombre, String escuderia, int posicionDeSalida){
        this.nombre=nombre;
        this.escuderia=escuderia;
        this.posicionDeSalida=posicionDeSalida;
    }

    public String getNombre(){
        return nombre;
    }

    public int getPosicionDeSalida(){
        return posicionDeSalida;
    }

    public boolean getDescalificado(){
        return descalificado;
    }

    public void setDescalificado(){
        descalificado=true;
    }

    @Override
    public int compareTo(Piloto o) {
        if(o.getPosicionDeSalida()>posicionDeSalida){
            return -1;
        }else if(getPosicionDeSalida()>posicionDeSalida){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "nombre='" + nombre + '\'' +
                ", escuderia='" + escuderia + '\'' +
                ", posicionDeSalida=" + posicionDeSalida +
                ", descalificado=" + descalificado +
                '}';
    }
}
