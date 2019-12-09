import java.util.Objects;

public class Componente {

    private String id;
    private int cantidad;

    public Componente(String id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        Componente otroComponente = (Componente) o;
        return Objects.equals(id, otroComponente.id);
    }

    @Override
    public String toString() {
        return "Componente{" +
                "id='" + id + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
