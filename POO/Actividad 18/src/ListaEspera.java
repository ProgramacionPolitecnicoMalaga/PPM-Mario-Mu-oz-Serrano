import java.util.Iterator;
import java.util.PriorityQueue;

public class ListaEspera {

    private PriorityQueue<Paciente> listaEspera = new PriorityQueue<Paciente>(Paciente.COMPARATOR_PRIORIDAD);

    public ListaEspera() {

    }

    public PriorityQueue getLista() {
        return listaEspera;
    }

    public Paciente getPrimeroLista() {
        return listaEspera.peek();
    }

    public void añadirPaciente(Paciente paciente) {
        listaEspera.add(paciente);
    }
}
