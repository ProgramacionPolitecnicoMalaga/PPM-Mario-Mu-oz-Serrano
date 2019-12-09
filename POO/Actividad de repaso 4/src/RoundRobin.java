
public class RoundRobin implements Algoritmo {

    private Tarea tarea;
    private int quantum = 3;

    public RoundRobin() {

    }

    @Override
    public Tarea siguienteTarea() {
        tarea = Tareas.getListaTareas().get(0);
        return Tareas.getListaTareas().get(0);
        //Se elige el primero de la cola de tareas.
    }

    @Override
    public int determinarTiempoDeEjecucion() {
        return quantum;
        //Se devuelve el quantum.
    }
}
