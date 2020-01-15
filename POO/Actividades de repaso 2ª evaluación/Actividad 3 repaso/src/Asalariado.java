public class Asalariado extends Empleado {

    private static final double SUELDO_FIJO= 1400;

    public Asalariado(String nombre, String apellidos, String dni) {
        super(nombre, apellidos, dni);
    }

    @Override
    public void calcularSueldo() {
        super.setSueldo(SUELDO_FIJO);
    }

    public String toString(){
        return super.toString() + "Tipo de empleado: Asalariado\n" +
                "Total a percibir: " + super.getSueldo() + "€" +
                "\n=======================================\n";
    }
}