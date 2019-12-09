import java.util.ArrayList;

public class Planificador {

    private Algoritmo algoritmo;
    private Tareas tareasEnEsperaOCompletadas = new Tareas();

    public Planificador(Algoritmo algoritmo) {
        this.algoritmo=algoritmo;
    }

    public void ejecutarTarea() {
        int suma = 2+2;
    }

    public void setAlgoritmo(Algoritmo algoritmo) {
        this.algoritmo=algoritmo;
    }

    public void gestionarTareas() {
       do {
           Tarea tareaAEjecutar = algoritmo.siguienteTarea();
           int tiempoEjecucion = algoritmo.determinarTiempoDeEjecucion();
           //Se obtienen los datos de la siguiente tarea a realizar y el tiempo de ejecución segun el algoritmo utilizado.

           tareasEnEsperaOCompletadas.eliminarTareaEspera(tareaAEjecutar);
           Periodo periodoEjecucion = new Periodo();
           periodoEjecucion.setTiempoInicio(System.nanoTime());
           for (int i = 0; i < tiempoEjecucion; i++) {
               ejecutarTarea();
           }
           periodoEjecucion.setTiempoFin(System.nanoTime());
           //Se ejecuta el metodo el numero de veces que pida el algoritmo y se cronometra.

           long periodoTotal = tareaAEjecutar.getTiempoEjecucion()+periodoEjecucion.getPeriodo();
           tareaAEjecutar.setTiempoEjecucion(periodoTotal);
           tareaAEjecutar.setDuracion(tareaAEjecutar.getDuracion()-tiempoEjecucion);
           //Se actualizan los tiempos.

           if (tareaAEjecutar.getDuracion()!=0) {
               tareasEnEsperaOCompletadas.añadirTareaEnEspera(tareaAEjecutar);
           } else tareasEnEsperaOCompletadas.añadirTareaCompletada(tareaAEjecutar);
           //Se devuelve el proceso a la lista de espera o de procesos completados si ha terminado su ejecucion.

       } while (tareasEnEsperaOCompletadas.getTareasCompletadas().size() != 3);
       imprimirEstadisticas();
        //Si todos los procesos se han completado se imprimen las estadisticas
    }

    public void imprimirEstadisticas() {
        Tarea a = tareasEnEsperaOCompletadas.getTareasCompletadas().get(0);
        Tarea b = tareasEnEsperaOCompletadas.getTareasCompletadas().get(1);
        Tarea c = tareasEnEsperaOCompletadas.getTareasCompletadas().get(2);

        long tiempoTotalEjecucion = a.getTiempoEjecucion() + b.getTiempoEjecucion() + c.getTiempoEjecucion();
        long tiempoMediaEspera = (a.getTiempoEspera() + b.getTiempoEspera() + c.getTiempoEspera())/3;

        System.out.println("Tiempo de ejecución de cada tarea: ");
        System.out.println("Tarea A: " + a.getTiempoEjecucion() + " nanosegundos.");
        System.out.println("Tarea B: " + b.getTiempoEjecucion() + " nanosegundos.");
        System.out.println("Tarea C: " + c.getTiempoEjecucion() + " nanosegundos.");
        System.out.println("=========================================================");
        System.out.println("Tiempo total de ejecución: ");
        System.out.println(tiempoTotalEjecucion + " nanosegundos.");
        System.out.println("=========================================================");
        System.out.println("Tiempo de espera de cada tarea: ");
        System.out.println("Tarea A: " + a.getTiempoEspera() + " nanosegundos.");
        System.out.println("Tarea B: " + b.getTiempoEspera() + " nanosegundos.");
        System.out.println("Tarea C: " + c.getTiempoEspera() + " nanosegundos.");
        System.out.println("=========================================================");
        System.out.println("Tiempo de espera medio de las tareas: ");
        System.out.println(tiempoMediaEspera + " nanosegundos.");
    }

}
