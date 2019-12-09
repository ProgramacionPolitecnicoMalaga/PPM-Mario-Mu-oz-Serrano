import java.util.Comparator;
import java.util.Objects;

public class Tarea {

    private int duracion;
    private int prioridad;
    private int id;
    private long tiempoEjecucion = 0;
    private long tiempoEspera = 0;
    private Periodo periodoEspera = new Periodo();

    public Tarea(int duracion, int prioridad, int id) {
        this.duracion = duracion;
        this.prioridad = prioridad;
        this.id = id;
    }

    public int getDuracion() {
        return duracion;
    }

    public Periodo getPeriodoEspera() {
        return periodoEspera;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public long getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public long getTiempoEspera() {
        return tiempoEspera;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setTiempoEjecucion(long tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public void setTiempoEspera(long tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public static final Comparator<Tarea> COMPARATOR_DURACION = new Comparator<Tarea>(){
        @Override
        public int compare(Tarea o1, Tarea o2) {
            return o1.getDuracion() - o2.getDuracion();
        }
    };

    public static final Comparator<Tarea> COMPARATOR_PRIORIDAD = new Comparator<Tarea>(){
        @Override
        public int compare(Tarea o1, Tarea o2) {
            return o1.getPrioridad() - o2.getPrioridad();
        }
    };

    @Override
    public boolean equals(Object o) {
        Tarea tarea = (Tarea) o;
        return id == tarea.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
