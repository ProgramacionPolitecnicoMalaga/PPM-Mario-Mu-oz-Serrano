import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
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
        alumno.setAsignatura(this);
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

    public void componerXMLAlumnosEIndicadores() {
        String xmlSerializado = "<asignatura id=\"" + id + "\" nombre=\"" + nombre + "\" curso=\"" + curso.getId() + "\">";
        Iterator<Alumno> it = listaAlumnos.iterator();
        while (it.hasNext()) {
            Alumno alumno = it.next();
            xmlSerializado += "<alumno nombre=\"" + alumno.getNombreYApellidos() + "\" dni=\"" + alumno.getDNI() + "\">";
            Iterator it2 = alumno.getIndicadoresNotas().entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                Indicador indicador = (Indicador) entry.getKey();
                Nota nota = (Nota) entry.getValue();
                if (nota != null) {
                    xmlSerializado += "<indicador tipo=\"" + indicador.getTipo() + "\" nombre=\"" + indicador.getNombre() + "\" nota=\"" + nota.getNota() + "\">";
                    xmlSerializado += nota.getObservaciones();
                    xmlSerializado += "</indicador>";
                }
            }
            xmlSerializado += "</alumno>";
        }
        xmlSerializado += "</asignatura>";
        GestorXML.escribirXML(xmlSerializado, id + "_" + curso.getId() + "_escritura" + ".xml");
    }

    public String getNombre() {
        return nombre;
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
