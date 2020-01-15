public abstract class Empleado {

    private String nombre;
    private String apellidos;
    private String dni;
    private double sueldo;

    public Empleado(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        calcularSueldo();
    }

    public abstract void calcularSueldo();

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString(){
        return "\n=======================================\n" +
                "Nombre: " + nombre + "  DNI: " + dni + "\n";
    }
}