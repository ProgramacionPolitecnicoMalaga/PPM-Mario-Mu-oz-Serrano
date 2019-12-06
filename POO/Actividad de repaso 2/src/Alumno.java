import java.util.*;

public class Alumno {

    private String nombreYApellidos;
    private String dni;
    private Curso curso;
    private HashMap<Indicador, Nota> indicadoresNotas = new HashMap<Indicador, Nota>();

    public Alumno(String nombreYApellidos, String dni, Curso curso) {
        this.nombreYApellidos = nombreYApellidos;
        this.dni = dni;
        this.curso = curso;
    }

    public String getNombreYApellidos() {
        return nombreYApellidos;
    }

    public void añadirIndicador(Indicador indicador) {
        indicadoresNotas.put(indicador,null);
    }

    public void asignarNota(Indicador indicador, Nota nota){
        indicadoresNotas.replace(indicador,nota);
    }

    public void listadoDeNotas() {
        System.out.println("Alumno: " + nombreYApellidos);
        Iterator it = indicadoresNotas.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Indicador key = (Indicador) entry.getKey();
            Nota value = (Nota) entry.getValue();
            if (value != null) {
                System.out.println(key + "\n" + value);
            }
        }
    }

    public void setNombreYApellidos(String nombreYApellidos) {
        this.nombreYApellidos = nombreYApellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Alumno: " + nombreYApellidos +
                ", DNI: " + dni +
                ", Curso: " + curso.getNombre();
    }
}
