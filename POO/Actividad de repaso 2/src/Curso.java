import java.util.ArrayList;
import java.util.Iterator;

public class Curso {
    private String id;
    private String nombre;
    private ArrayList<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();

    public Curso(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void introducirAsignatura(Asignatura asignatura) {
        listaAsignaturas.add(asignatura);
    }

    public void añadirAsignatura(Asignatura asignatura) {
        listaAsignaturas.add(asignatura);
    }

    public Asignatura getAsignatura(String id) {
        Iterator<Asignatura> it = listaAsignaturas.iterator();
        while (it.hasNext()) {
            Asignatura asignatura = it.next();
            if (asignatura.getId().equals(id)) {
                return asignatura;
            }
        }
        return null;
    }

    public void listadoDeAsignaturas() {
        System.out.println("Curso: " + nombre);
        Iterator<Asignatura> iterator = listaAsignaturas.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre
                + ", ID: " + id;
    }
}
