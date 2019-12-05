
public class Actividad {

    private String descripción;
    private Proyecto proyecto;
    private Empleado empleado;
    private int horas;

    public Actividad (Empleado empleado, Proyecto proyecto, String descripción, int horas) {
        this.empleado=empleado;
        this.proyecto=proyecto;
        this.descripción=descripción;
        this.horas=horas;
        setProductividadEmpleado();
        GestorEmpleados.insertarActividad(this);
    }

    public String getDescripción() {
        return descripción;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public int getHoras() {
        return horas;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setProductividadEmpleado() {
        empleado.getNomina().setProductividad(proyecto.getFprod(), horas);
    }

    @Override
    public String toString() {
        return "Descripción: " + descripción +
                "\nProyecto: " + proyecto.getNombre() +
                "\nEmpleado: " + empleado.getNombreApellidos() +
                "\nHoras: " + horas +
                "\n==================================";
    }
}
