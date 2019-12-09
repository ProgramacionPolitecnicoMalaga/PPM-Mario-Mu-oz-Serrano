import java.util.ArrayList;

public class Tareas {

    private ArrayList<Tarea> tareasCompletadas = new ArrayList<Tarea>();
    private static ArrayList<Tarea> tareasEnEspera = new ArrayList<Tarea>();

    public Tareas() {
        añadirTareas();
    }

    public static ArrayList<Tarea> getTareasEnEspera() {
        return tareasEnEspera;
    }

    public ArrayList<Tarea> getTareasCompletadas() {
        return tareasCompletadas;
    }

    public void añadirTareas() {
        tareasEnEspera.add(new Tarea(1200, 1, 1));
        tareasEnEspera.get(0).getPeriodoEspera().setTiempoInicio(System.nanoTime());

        tareasEnEspera.add(new Tarea(600, 2, 2));
        tareasEnEspera.get(1).getPeriodoEspera().setTiempoInicio(System.nanoTime());

        tareasEnEspera.add(new Tarea(1800, 3, 3));
        tareasEnEspera.get(2).getPeriodoEspera().setTiempoInicio(System.nanoTime());
        //Se añaden todas las tareas y se empieza a contar el tiempo en espera de cada una.
    }

    public void añadirTareaCompletada(Tarea tarea) {
        tareasCompletadas.add(tarea);
    }

    public void añadirTareaEnEspera(Tarea tarea) {
        tareasEnEspera.add(tarea);
        tarea.getPeriodoEspera().setTiempoInicio(System.nanoTime());
        //Al añadir una nueva tarea se vuelve a cronometrar el tiempo.
    }

    public void eliminarTareaEspera(Tarea tarea) {
        tareasEnEspera.remove(tarea);
        tarea.getPeriodoEspera().setTiempoFin(System.nanoTime());
        long periodoTotal = tarea.getTiempoEspera()+tarea.getPeriodoEspera().getPeriodo();
        tarea.setTiempoEspera(periodoTotal);
        //Al eliminar una tarea de la lista de espera se obtiene el tiempo y se le suma al que ya tenía.
    }
}
