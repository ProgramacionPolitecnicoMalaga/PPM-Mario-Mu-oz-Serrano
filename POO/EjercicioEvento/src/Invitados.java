public class Invitados {
private String nombre;
private String apellidos;
private int edad;

public Invitados(String nombre, String apellidos, int edad){
    this.nombre=nombre;
    this.apellidos=apellidos;
    this.edad=edad;
}

    public String getNombre() {
        return nombre;
    }

    public int getEdad(){
    return edad;
}

    @Override
    public String toString() {
        return "Invitados{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                '}';
    }
}
