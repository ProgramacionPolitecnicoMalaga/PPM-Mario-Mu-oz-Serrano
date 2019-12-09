import java.util.ArrayList;

public class PriorityQueue implements Algoritmo{

    private Tarea tarea;

    public PriorityQueue() {

    }

    @Override
    public Tarea siguienteTarea() {
        ArrayList<Tarea> tareasAOrdenar = Tareas.getListaTareas();
        tareasAOrdenar.sort(Tarea.COMPARATOR_PRIORIDAD);
        tarea = tareasAOrdenar.get(0);
        return tareasAOrdenar.get(0);
        //Se elige el de mayor prioridad.
    }

    @Override
    public int determinarTiempoDeEjecucion() {
        return tarea.getDuracion();
        //Se devuelve la duración total de la tarea.
    }

}
