
public class Fifo implements Algoritmo {

    private Tarea tarea;

    public Fifo() {

    }

    @Override
    public Tarea siguienteTarea() {
        tarea = Tareas.getListaTareas().get(0);
        return Tareas.getListaTareas().get(0);
        //Se elige el primero de la cola de tareas.
    }

    @Override
    public int determinarTiempoDeEjecucion() {
        return tarea.getDuracion();
        //Se devuelve la duración total de la tarea.
    }
}
