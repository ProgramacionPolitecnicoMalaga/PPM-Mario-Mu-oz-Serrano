package ejercicioNominas;

public class Asalariados extends  Empleados {

    public double sueldo(){
        return sueldoFijoPorMes;
    }

    public double sueldoFijoPorMes;

    public Asalariados(String nombre, String dni, double sueldoFijoPorMes){
        super(nombre, dni);
        this.sueldoFijoPorMes = sueldoFijoPorMes;
    }

    public String toString(){
        return super.toString() + "Tipo de empleado: Asalariados\n"
                                + "Total a percibir: " + sueldo() + "€";
    }
}
