public class TelefonoNokia extends Telefono {

    String modelo;

    public TelefonoNokia(int numero, String modelo) {
        super(numero);
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "TelefonoNokia{" +
                "modelo='" + modelo + '\'' +
                ", numero=" + numero +
                "} " + super.toString();
    }
}
