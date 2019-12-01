import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Nomina {
    private double sueldoBase;
    private double sueldoTotal;
    private double productividad = 0;
    private GestorEmpleados gestorEmpleados = new GestorEmpleados();
    private GestorXML gestorXML = new GestorXML();
    private HashMap<Proyecto, Integer> proyectoHoras = new HashMap<Proyecto, Integer>();

    public Nomina() {
        incluirProyectos();
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public double getSueldoTotal() {
        return sueldoTotal;
    }

    public double getProductividad() {
        return productividad;
    }

    public HashMap getProyectoHoras() {
        return proyectoHoras;
    }

    public int getHorasProyecto(Proyecto proyecto) {
        return proyectoHoras.get(proyecto);
    }

    public void setHorasProyecto(String proyecto, int horas) {
        Proyecto proyectoAModificar = gestorEmpleados.getProyecto(proyecto);
        Integer suma = proyectoHoras.get(proyectoAModificar) + horas;
        proyectoHoras.put(proyectoAModificar, suma);
    }

    public void incluirProyectos() {
        for (int i=0; i<gestorEmpleados.getListaProyectos().length;i++) {
            proyectoHoras.put(gestorEmpleados.getListaProyectos()[i], 0);
        }
    }

    public void setSueldoBase(String categoria) {
       sueldoBase = gestorEmpleados.getSueldoCategoria(categoria);
    }

    public void setProductividad(String nombreProyecto, int horas) {
        productividad += gestorEmpleados.getProyecto(nombreProyecto).getFprod() * horas;
        setHorasProyecto(nombreProyecto,horas);
        sueldoTotal = sueldoBase + productividad;
    }

    public void listaTareasEmpleado(Empleado empleado) {
        Iterator it = empleado.getProyectoHoras().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Proyecto key = (Proyecto)entry.getKey();
            Integer value = (Integer)entry.getValue();
            if (value != 0) {
                System.out.println(key + "\nHoras: " + value);
            }
        }
        gestorXML.listadoTareasEmpleado(empleado);
    }

    @Override
    public String toString() {
        return "\nSueldo base: " + sueldoBase +
                "\nProductividad: " + productividad +
                "\nSueldoTotal: " + sueldoTotal;
    }
}
