import java.util.Objects;

public class Empleado {
    private String nombreApellidos;
    private String DNI;
    private String categoria;
    private Nomina nomina;

    public Empleado(String nombreApellidos, String DNI, int categoria) {
        this.nombreApellidos = nombreApellidos;
        this.DNI = DNI;
        this.categoria = GestorEmpleados.getCategoria(categoria);
        nomina = new Nomina();
        nomina.setSueldoBase(GestorEmpleados.getSueldoBase(categoria));
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public String getCategoria() {
        return categoria;
    }

    public Nomina getNomina() {
        return nomina;
    }

    public String getDNI() {
        return DNI;
    }

    @Override
    public int hashCode() {
        return Objects.hash(DNI);
    }

    @Override
    public boolean equals(Object o) {
        Empleado empleado = (Empleado) o;
        return Objects.equals(DNI, empleado.DNI);
    }

    @Override
    public String toString() {
        return  "-----------------------\n" +
                "Empleado " + nombreApellidos +
                "\nDNI: " + DNI + nomina;
    }
}
