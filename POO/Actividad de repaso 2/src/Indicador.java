public class Indicador {

    private String tipo;
    private String nombre;
    private Asignatura asignatura;

    public Indicador(String tipo, String nombre, Asignatura asignatura) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.asignatura = asignatura;
        asignatura.nuevoIndicador(this);
    }

    @Override
    public String toString() {
        return "Tipo de indicador: " + tipo +
                "\nNombre: " + nombre +
                "\nAsignatura: " + asignatura.getNombre();
    }
}
