public class PorHoras extends Empleado {

    private int horasTrabajadas;
    private static final int SUELDO_POR_HORA = 12;

    public PorHoras(String nombre, String apellidos, String dni, int horasTrabajadas) {
        super(nombre, apellidos, dni);
        this.horasTrabajadas = horasTrabajadas;
    }

    public void calcularSueldo() {
        double sueldo = horasTrabajadas * SUELDO_POR_HORA;
        super.setSueldo(sueldo);
    }

    public String toString() {
        return super.toString() + "Tipo de empleado: Por Horas\n" +
                "Sueldo por horas: " + SUELDO_POR_HORA + "€" + "\n" + "Horas trabajadas:  " + horasTrabajadas + "\n" +
                "Total a percibir: " + super.getSueldo() + "€" +
                "\n=======================================\n";
    }
}