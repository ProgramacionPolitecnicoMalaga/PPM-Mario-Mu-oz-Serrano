
public class SJF implements Algoritmo {

    private Tarea tarea;

    public SJF() {

    }

    @Override
    public Tarea siguienteTarea() {
        Tareas.getTareasEnEspera().sort(Tarea.COMPARATOR_DURACION);
        tarea = Tareas.getTareasEnEspera().get(0);
        return Tareas.getTareasEnEspera().get(0);
        //Se elige el de menor duración.
    }

    @Override
    public int determinarTiempoDeEjecucion() {
        return tarea.getDuracion();
        //Se devuelve la duración total de la tarea.
    }
}
