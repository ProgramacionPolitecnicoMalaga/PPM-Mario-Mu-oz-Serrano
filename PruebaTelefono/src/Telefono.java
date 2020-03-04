import java.util.Objects;

public class Telefono {

    int numero;

    public Telefono(int numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        Telefono telefono = (Telefono) o;
        return this.toString().equals(telefono.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "numero=" + numero +
                '}';
    }
}
