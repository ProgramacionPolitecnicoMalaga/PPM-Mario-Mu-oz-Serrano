import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

public class MiMain {

    public static void main(String[] args) {

        ArrayList<Invitados> evento = new ArrayList<>();

        evento.add(new Invitados("Manuel", "Rodriguez", 35));
        evento.add(new Invitados("Rosa", "Perez", 24));
        evento.add(new Invitados("Ana", "Jimenez", 18));
        evento.add(new Invitados("Borja", "Fernandez", 15));
        evento.add(new Invitados("Mario", "Muñoz", 29));
        evento.add(new Invitados("Alfonso", "Muniain", 11));
        evento.add(new Invitados("Jose", "Serrano", 47));


        Predicate<Invitados> condicion = invitado -> invitado.getEdad() < 18;
        evento.removeIf(condicion);

        Collections.sort(evento, new ComparadorAlfabetico());
        for (Invitados aux : evento) {
            System.out.println(aux);
        }
    }
}

