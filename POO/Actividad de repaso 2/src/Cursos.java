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

}
