import java.util.HashMap;

public class Empleado {
    private String nombreApellidos;
    private String DNI;
    private String categoria;
    private Nomina nomina;
    private GestorEmpleados gestorEmpleados = new GestorEmpleados();

    public Empleado(String nombreApellidos, String DNI, String categoria) {
        this.nombreApellidos = nombreApellidos;
        this.DNI = DNI;
        this.categoria = categoria;
        nomina = new Nomina();
        nomina.setSueldoBase(categoria);
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public int getHorasProyecto(Proyecto proyecto) {
        return nomina.getHorasProyecto(proyecto);
    }

    public double getSueldoBase() {
        return nomina.getSueldoBase();
    }

    public double getProductividad() {
        return nomina.getProductividad();
    }

    public double getSueldoTotal() {
        return nomina.getSueldoTotal();
    }

    public void setProductividad(String nombreProyecto, int horas) {
        nomina.setProductividad(nombreProyecto, horas);
        gestorEmpleados.getProyecto(nombreProyecto).introducirEmpleado(this);
    }

    public void listarTareas() {
        System.out.println("Tareas realizadas por el empleado " + nombreApellidos + ": ");
        nomina.listaTareasEmpleado(this);
    }

    public HashMap getProyectoHoras() {
        return nomina.getProyectoHoras();
    }

    @Override
    public String toString() {
        return  "-----------------------\n" +
                "Empleado " + nombreApellidos +
                "\nDNI: " + DNI + nomina;
    }
}
