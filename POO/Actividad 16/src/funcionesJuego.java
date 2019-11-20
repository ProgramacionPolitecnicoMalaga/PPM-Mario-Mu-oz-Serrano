import java.util.LinkedList;
import java.util.ListIterator;

public class funcionesJuego {

    private LinkedList<Movimiento> historial = new LinkedList<>();
    private LinkedList<Movimiento> deshechos = new LinkedList<>();
    private boolean rehacer = false;

    public funcionesJuego(){

    }

    public void guardarMovimiento(Movimiento movimiento) {
        historial.add(movimiento);
        rehacer = false;
    }

    public Movimiento undo(){
        if (historial.getFirst() != historial.getLast()) {
            Movimiento movimiento = historial.removeLast();
            deshechos.add(movimiento);
            rehacer = true;
            return movimiento;
        }
        else {
            return null;
        }
    }

    public Movimiento redo(){
        Movimiento movimiento;
        if (rehacer) {
            if (deshechos.getLast() == deshechos.getFirst()) {
            rehacer = false;
            }
            movimiento = deshechos.removeLast();
            historial.add(movimiento);
            return movimiento;
        }
        else {
            return null;
        }
    }

    public void historial() {
        ListIterator <Movimiento> lIt = historial.listIterator();
        while (lIt.hasNext()) {
            System.out.println((((lIt.next().toString()))));
        }
    }



}
