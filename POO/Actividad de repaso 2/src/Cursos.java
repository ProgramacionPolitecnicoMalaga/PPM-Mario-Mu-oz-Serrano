import java.util.ArrayList;
import java.util.Iterator;

public class Cursos {

    private static ArrayList<Curso> listaCursos = new ArrayList<Curso>();

    public Cursos() {

    }

    public static void introducirCurso(Curso curso) {
        listaCursos.add(curso);
    }

    public static Curso getCurso(String id) {
        Iterator<Curso> it = listaCursos.iterator();
        while (it.hasNext()) {
            Curso curso = it.next();
            if (curso.getId().equals(id)) {
                return curso;
            }
        }
        return null;
    }

    public void listadoDeCursos() {
        Iterator<Curso> iterator = listaCursos.iterator();
        while (iterator.hasNext()) {
            Curso curso = iterator.next();
            System.out.println(curso);
            curso.listadoDeAsignaturas();
            System.out.println("==========================================");
        }
    }

    public void componerXMLCursosYAsignaturas() {
        String xmlSerializado = "<cursos>";
        Iterator<Curso> it = listaCursos.iterator();
        while (it.hasNext()) {
            Curso curso = it.next();
            xmlSerializado += "<curso id=\"" + curso.getId() + "\" nombre=\"" + curso.getNombre() + "\">";
                    Iterator<Asignatura> it2 = curso.getListaAsignaturas().iterator();
                    while (it2.hasNext()) {
                        Asignatura asignatura = it2.next();
                        xmlSerializado += "<asignatura id=\"" + asignatura.getId() + "\" nombre=\"" + asignatura.getNombre() + "\">" + "</asignatura>";
                    }
                    xmlSerializado += "</curso>";
        }
        xmlSerializado += "</cursos>";
        GestorXML.escribirXML(xmlSerializado,"cursos_escritura.xml");
    }

}
