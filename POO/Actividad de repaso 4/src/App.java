import java.util.ArrayList;
import java.util.Collections;

public class App {

    public static void main(String[] args) {

        System.out.println("============================================================");
        System.out.println("                        ALGORITMO FIFO                      ");
        System.out.println("============================================================");
        Algoritmo algoritmoFifo = new Fifo();
        Planificador planificador = new Planificador(algoritmoFifo);
        planificador.gestionarTareas();

        System.out.println("============================================================");
        System.out.println("                     ALGORITMO Round Robin                  ");
        System.out.println("============================================================");
        planificador = new Planificador(new RoundRobin(2));
        planificador.gestionarTareas();

        System.out.println("============================================================");
        System.out.println("                         ALGORITMO SJF                      ");
        System.out.println("============================================================");
        planificador = new Planificador(new SJF());
        planificador.gestionarTareas();

        System.out.println("============================================================");
        System.out.println("                  ALGORITMO PriorityQueue                   ");
        System.out.println("============================================================");
        planificador = new Planificador(new PriorityQueue());
        planificador.gestionarTareas();

    }

}
