import java.util.Objects;

public class Categoria {
    private String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
