import java.util.ArrayList;
import java.util.Iterator;

public class Cursos {

    private static ArrayList<Curso> listaCursos = new ArrayList<Curso>();

    public Cursos() {

    }

    public void introducirCurso(Curso curso) {
        listaCursos.add(curso);
    }

    public Curso getCurso(String id) {
        Iterator<Curso> it = listaCursos.iterator();
        while (it.hasNext()) {
            Curso curso = it.next();
            if (curso.getId().equals(id)) {
                return curso;
            }
        }
        return null;
    }

    public ArrayList<Curso> getListaAsignaturas() {
        return listaCursos;
    }


}
