package Datos;

public class PersonaFisica extends Comprador {
    private String apellidos;
    private String DNI;
    private String NIE;
    private String direccion;

    public PersonaFisica(String nombre, String apellidos, String identificacion, String direccion, String tipoIdentificacion){
        super(nombre);
        this.apellidos=apellidos;
        this.direccion=direccion;
        if (tipoIdentificacion.equals("DNI")) this.DNI=identificacion;
        else this.NIE=identificacion;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nApellidos: " + apellidos +
                "\nDNI: " + DNI +
                "\nNIE: " + NIE +
                "\nDirección: " + direccion;
    }
}