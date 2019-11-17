public class CompradorPersonaFisica extends Comprador {
    private String apellidos;
    private String DNI;
    private String NIE;
    private String direccion;

    public CompradorPersonaFisica(String nombre, String apellidos, String identificacion, String direccion, String tipoIdentificacion){
        super(nombre);
        this.apellidos=apellidos;
        this.direccion=direccion;

        if (tipoIdentificacion.equals("DNI")){
            this.DNI=identificacion;
        }

        if (tipoIdentificacion.equals("NIE")){
            this.NIE=identificacion;
        }
    }

    @Override
    public String toString() {
        return "CompradorPersonaFisica{" +
                "apellidos='" + apellidos + '\'' +
                ", DNI='" + DNI + '\'' +
                ", NIE='" + NIE + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
