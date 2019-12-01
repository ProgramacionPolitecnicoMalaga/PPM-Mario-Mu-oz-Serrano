import java.util.LinkedList;
import java.util.ListIterator;

public class Proyecto {

    private String nombre;
    private String departamento;
    private Double fprod;
    private String descripcion;
    private LinkedList<Empleado> listaEmpleados = new LinkedList<>();

    public Proyecto(String nombre, String departamento, double fprod, String descripcion) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.fprod = fprod;
        this.descripcion = descripcion;
    }

    public LinkedList getListaEmpleados() {
        return listaEmpleados;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getFprod() {
        return fprod;
    }

    public void listarTareas() {
        GestorXML gestorXML = new GestorXML();
        int totalHoras = 0;
        System.out.println("Nombre del proyecto: " + nombre);
        System.out.println("Empleados que han trabajado en el proyecto:");
        ListIterator<Empleado> it = listaEmpleados.listIterator();
        while (it.hasNext()) {
            Empleado empleado = it.next();
            totalHoras += empleado.getHorasProyecto(this);
            System.out.println("Nombre: " + empleado.getNombreApellidos() + ", horas: " + empleado.getHorasProyecto(this) + ".");
        }
        System.out.println("Total de horas: " + totalHoras);
        System.out.println("-----------------------");
        gestorXML.listadoTareasProyecto(this);
    }

    public void introducirEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
    }

    @Override
    public String toString() {
        return  "----------------------" +
                "\nProyecto: " + nombre +
                "\nDepartamento: " + departamento +
                "\nDescripción: " + descripcion;
    }
}
