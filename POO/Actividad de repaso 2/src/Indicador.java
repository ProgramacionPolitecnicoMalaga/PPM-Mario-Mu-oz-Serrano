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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    @Override
    public String toString() {
        return "Tipo de indicador: " + tipo +
                "\nNombre: " + nombre +
                "\nAsignatura: " + asignatura.getNombre();
    }
}
