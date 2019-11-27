import java.util.Comparator;

public class Paciente implements Comparable<Paciente> {

    private String nombre;
    private int edad;
    private Incidencia incidencia;
    private int prioridad;

    public Paciente(String nombre, int edad, Incidencia incidencia, int prioridad){
        this.nombre=nombre;
        this.edad=edad;
        this.incidencia=incidencia;
        this.prioridad=prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public static final Comparator<Paciente> COMPARATOR_PRIORIDAD = new Comparator<Paciente>(){
        @Override
        public int compare(Paciente o1, Paciente o2) {
            return o1.getPrioridad() - o2.getPrioridad();
        }
    };

    @Override
    public String toString() {
        return "Prioridad: " + getPrioridad() +
                ", nombre: " + nombre +
                ", edad: " + edad +
                incidencia;
    }

    @Override
    public int compareTo(Paciente o) {
        if (prioridad < o.prioridad) {
            return -1;
        }
        if (prioridad > o.prioridad) {
            return 1;
        }
        return 0;
    }
}
