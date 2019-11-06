package ejercicioNominas;

public abstract class Empleados {

    public abstract double sueldo();

    public String nombre;
    public String dni;

    public Empleados(String nombre, String dni){
        this.nombre = nombre;
        this.dni = dni;
    }

    public String toString(){
            return "\n=======================================\n"
                   + "Nombre: " + nombre + "  DNI: " + dni + "\n";
    }

}

