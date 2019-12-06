public class App {

    public static void main(String[] args) {
        GestorXML gestorXML = new GestorXML();
        Cursos cursos = new Cursos();
        System.out.println("============================================================");
        System.out.println("           INTRODUCIR NUEVOS CURSOS Y ASIGNATURAS           ");
        System.out.println("============================================================");

        Curso curso1 = new Curso ("1bach","1º de bachillerato");

        cursos.introducirCurso(curso1);

        Asignatura asignatura1 = new Asignatura("fil1","Filosofía", curso1);
        Asignatura asignatura2 = new Asignatura("lcl1","Lengua Castellana y literatura", curso1);

        System.out.println("============================================================");
        System.out.println("           INTRODUCIR ALUMNOS Y ASOCIARLOS A UN CURSO       ");
        System.out.println("============================================================");

        Alumno alumno1 = new Alumno("Antonio Sanchez","15495845L", curso1);
        Alumno alumno2 = new Alumno("Javier Rodriguez","45683245N", curso1);

        System.out.println("============================================================");
        System.out.println("              MATRICULAR ALUMNOS EN ASIGNATURAS             ");
        System.out.println("============================================================");

        asignatura1.matricularAlumno(alumno1);
        asignatura1.matricularAlumno(alumno2);
        asignatura2.matricularAlumno(alumno2);

        System.out.println("============================================================");
        System.out.println("       DEFINIR NUEVOS INDICADORES PARA LAS ASIGNATURAS      ");
        System.out.println("============================================================");

        Indicador indicador1 = new Indicador("Examen","Examen Tema 1", asignatura1);
        Indicador indicador2 = new Indicador("Lectura","Trabajo sobre la lectura de un libro", asignatura1);
        Indicador indicador3 = new Indicador("Actividad","Actividad 2", asignatura2);

        System.out.println("============================================================");
        System.out.println(" ASIGNAR UNA NOTA A UN INDICADOR PARA UN ALUMNO DETERMINADO ");
        System.out.println("============================================================");

        alumno1.asignarNota(indicador1,new Nota(8.5,"Muy bien"));
        alumno1.asignarNota(indicador2,new Nota(6.2,"Regular"));
        alumno2.asignarNota(indicador1,new Nota(5.1,"Varios ejercicios sin hacer"));
        alumno2.asignarNota(indicador2,new Nota(3.6,"Mal"));
        alumno2.asignarNota(indicador3,new Nota(9.5,"Muy bien"));

        System.out.println("============================================================");
        System.out.println("             LISTADO DE ASIGNATURAS DE UN CURSO             ");
        System.out.println("============================================================");
        curso1.listadoDeAsignaturas();

        System.out.println("============================================================");
        System.out.println("            LISTADO DE ALUMNOS DE UNA ASIGNATURA            ");
        System.out.println("============================================================");
        asignatura1.listadoDeAlumnos();
        System.out.println("=============================================================");
        asignatura2.listadoDeAlumnos();

        System.out.println("============================================================");
        System.out.println("               LISTADO DE NOTAS DE CADA ALUMNO              ");
        System.out.println("============================================================");
        alumno1.listadoDeNotas();
        alumno2.listadoDeNotas();
    }
}
