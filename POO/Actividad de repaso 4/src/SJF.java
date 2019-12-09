import java.util.*;

public class SJF implements Algoritmo {

    private Tarea tarea;

    public SJF() {

    }

    @Override
    public Tarea siguienteTarea() {
        ArrayList<Tarea> tareasAOrdenar = Tareas.getTareasEnEspera();
        tareasAOrdenar.sort(Tarea.COMPARATOR_DURACION);
        tarea = tareasAOrdenar.get(0);
        return tareasAOrdenar.get(0);
        //Se elige el de menor duración.
    }

    @Override
    public int determinarTiempoDeEjecucion() {
        return tarea.getDuracion();
        //Se devuelve la duración total de la tarea.
    }
}
