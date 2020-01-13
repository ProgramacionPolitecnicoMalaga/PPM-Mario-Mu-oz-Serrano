import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        Comerciales comerciales = new Comerciales();
        Interfaz interfaz = new Interfaz(comerciales);
        ArrayList<Integer> ventasDeIsabel = new ArrayList<>();
        ArrayList<Integer> ventasDeVicente = new ArrayList<>();
        ventasDeIsabel.add(7);
        ventasDeIsabel.add(7);
        ventasDeIsabel.add(10);
        ventasDeIsabel.add(6);
        ventasDeIsabel.add(4);
        ventasDeVicente.add(4);
        ventasDeVicente.add(7);
        ventasDeVicente.add(5);
        ventasDeVicente.add(4);
        ventasDeVicente.add(5);

        Comercial comercial1 = new Comercial("Isabel", "Castillo", "m", ventasDeIsabel);
        Comercial comercial2 = new Comercial("Vicente", "Calzado", "h", ventasDeVicente);

        comerciales.añadirComercial(comercial1);
        comerciales.añadirComercial(comercial2);

        System.out.println("==========================================");
        System.out.println("Empleados que vendieron un número de items");
        System.out.println("==========================================");
        interfaz.pedirNumeroVentas();

        System.out.println("==========================================");
        System.out.println("Obtener el promedio de ventas de cada uno");
        System.out.println("==========================================");
        interfaz.generarMensajePromedioVentas();

        System.out.println("==========================================");
        System.out.println("Averiguar quién han conseguido el mayor número de ventas en un día");
        System.out.println("==========================================");
        interfaz.generarMensajeMayorNumeroVentasDia();

        System.out.println("==========================================");
        System.out.println("Insertar un nuevo empleado y sus ventas");
        System.out.println("==========================================");
        ArrayList<Integer> ventasDeAlonso = new ArrayList<>();
        ventasDeAlonso.add(3);
        ventasDeAlonso.add(8);
        ventasDeAlonso.add(9);
        ventasDeAlonso.add(1);
        ventasDeAlonso.add(6);
        Comercial comercial3 = new Comercial("Alonso", "Rodriguez", "h", ventasDeAlonso);
    }
}
