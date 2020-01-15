public class Comisionado extends Empleado {

    private int ventasRealizadas;
    private static final double SUELDO_BASE = 600;
    private static final int SUELDO_POR_VENTA_REALIZADA = 50;

    public Comisionado(String nombre, String apellidos, String dni, int ventasRealizadas) {
        super(nombre, apellidos, dni);
        this.ventasRealizadas = ventasRealizadas;
    }

    public void calcularSueldo() {
        double extraPorVenta = ventasRealizadas * SUELDO_POR_VENTA_REALIZADA;
        double sueldo = SUELDO_BASE + extraPorVenta;
        super.setSueldo(sueldo);
    }

    public String toString(){
        return super.toString() + "Tipo de empleado: Comisionado\n" +
                "Sueldo base: " + SUELDO_BASE + "€" + "\n" +
                "Ventas realizadas: " + ventasRealizadas + "\n" +
                "Total a percibir: " + super.getSueldo() + "€" +
                "\n=======================================\n";
    }
}