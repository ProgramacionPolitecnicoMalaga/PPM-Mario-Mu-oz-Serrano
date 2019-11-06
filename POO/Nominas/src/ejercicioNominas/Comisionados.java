package ejercicioNominas;

public class Comisionados extends Empleados {

    public double sueldo(){
        return sueldoBase + ventasRealizadas * EXTRA_POR_VENTA;
    }

    public final static int EXTRA_POR_VENTA = 50;
    public double sueldoBase;
    public int ventasRealizadas;


    public Comisionados(String nombre, String dni, double sueldoBase, int ventasRealizadasEmpleado){
        super(nombre, dni);
        this.sueldoBase = sueldoBase;
        this.ventasRealizadas = ventasRealizadasEmpleado;
    }

    public String toString(){
        return super.toString() + "Tipo de empleado: Comisionado\n"
                                + "Sueldo base: " + sueldoBase + "€" + "\n"
                                + "Ventas realizadas: " + ventasRealizadas + "\n"
                                + "Total a percibir: " + sueldo() + "€";
    }
}
