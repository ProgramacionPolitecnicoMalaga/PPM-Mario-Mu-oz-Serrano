import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Asignatura {

    private String id;
    private String nombre;
    private Curso curso;
    private ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();

    public Asignatura(String id, String nombre, Curso curso) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
        curso.introducirAsignatura(this);
    }

    public String getId() {
        return id;
    }

    public void matricularAlumno(Alumno alumno) {
        listaAlumnos.add(alumno);
    }

    public void nuevoIndicador(Indicador indicador) {
        Iterator<Alumno> it = listaAlumnos.iterator();
        while (it.hasNext()) {
            Alumno alumno = it.next();
            alumno.añadirIndicador(indicador);
        }
    }

    public void listadoDeAlumnos() {
        System.out.println("Asignatura: " + nombre);
        Iterator<Alumno> iterator = listaAlumnos.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        Asignatura that = (Asignatura) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Asignatura: " + nombre +
                ", ID: " + id;
    }
}
