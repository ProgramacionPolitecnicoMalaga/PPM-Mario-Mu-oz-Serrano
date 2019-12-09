
public class RoundRobin implements Algoritmo {

    private Tarea tarea;
    private int quantum = 0;

    public RoundRobin(int quantum) {
        this.quantum=quantum;
    }

    @Override
    public Tarea siguienteTarea() {
        tarea = Tareas.getTareasEnEspera().get(0);
        return Tareas.getTareasEnEspera().get(0);
        //Se elige el primero de la cola de tareas.
    }

    @Override
    public int determinarTiempoDeEjecucion() {
        return quantum;
        //Se devuelve el quantum.
    }
}
