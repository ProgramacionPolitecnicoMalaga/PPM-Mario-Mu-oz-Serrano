public class App {

    public static void main(String[] args) {
        Telefono telefono1 = new TelefonoNokia(625263461, "3310");
        Telefono telefono2 = new TelefonoNokia(625263461, "3310");

        if (telefono1.equals(telefono2)) System.out.println("Son iguales");
        else System.out.println("No son iguales");
    }
}
