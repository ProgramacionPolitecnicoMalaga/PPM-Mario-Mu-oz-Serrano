import java.util.Objects;

public class Proyecto {

    private String nombre;
    private String departamento;
    private double fprod;
    private String descripcion;

    public Proyecto(String nombre, String departamento, double fprod, String descripcion) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.fprod = fprod;
        this.descripcion = descripcion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getFprod() {
        return fprod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object o) {
        Proyecto proyecto = (Proyecto) o;
        return Objects.equals(nombre, proyecto.nombre);
    }

    @Override
    public String toString() {
        return  "----------------------" +
                "\nProyecto: " + nombre +
                "\nDepartamento: " + departamento +
                "\nDescripción: " + descripcion;
    }
}