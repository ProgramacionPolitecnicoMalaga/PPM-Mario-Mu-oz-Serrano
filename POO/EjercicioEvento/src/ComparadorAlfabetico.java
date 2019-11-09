import java.util.Comparator;

public class ComparadorAlfabetico implements Comparator<Invitados> {

    public int compare(Invitados o1, Invitados o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
}