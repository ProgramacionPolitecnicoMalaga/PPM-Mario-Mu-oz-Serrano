
public class PriorityQueue implements Algoritmo{

    private Tarea tarea;

    public PriorityQueue() {

    }

    @Override
    public Tarea siguienteTarea() {
        Tareas.getTareasEnEspera().sort(Tarea.COMPARATOR_PRIORIDAD);
        tarea = Tareas.getTareasEnEspera().get(0);
        return Tareas.getTareasEnEspera().get(0);
        //Se elige el de mayor prioridad.
    }

    @Override
    public int determinarTiempoDeEjecucion() {
        return tarea.getDuracion();
        //Se devuelve la duración total de la tarea.
    }

}
