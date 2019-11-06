package ejercicioNominas;

public class PorHoras extends Empleados {

    public double sueldo(){
        return sueldoPorHora * horasTrabajadas;
    }

    public double sueldoPorHora;
    public int horasTrabajadas;

    public PorHoras(String nombre, String dni, double sueldoPorHora, int horasTrabajadas){
        super(nombre, dni);
        this.sueldoPorHora = sueldoPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    public String toString(){
        return super.toString() + "Tipo de empleado: Por Horas\n"
                                + "Sueldo por horas: " + sueldoPorHora + "€" + "\n" + "Horas trabajadas:  " + horasTrabajadas + "\n"
                                + "Total a percibir: " + sueldo() + "€";
    }
}
