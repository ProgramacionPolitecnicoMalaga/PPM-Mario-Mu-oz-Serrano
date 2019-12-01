import java.util.*;

public class GestorEmpleados {

    private HashMap<String, Double> sueldoCategoria = new HashMap<String, Double>();
    private static Empleado[] listaEmpleados = new Empleado[5];
    private static Proyecto[] listaProyectos;
    private static GestorXML gestorXML = new GestorXML();

    public GestorEmpleados() {
        sueldoCategoria.put("Técnico", (double) 900);
        sueldoCategoria.put("Administrador", (double) 1400);
        sueldoCategoria.put("Programador", (double) 1800);
        sueldoCategoria.put("Jefe de proyecto", (double) 2500);
        sueldoCategoria.put("Jefe de operaciones", (double) 3500);
    }

    public static void listarProyectos() {
        listaProyectos = gestorXML.leerXMLProyectos();
    }

    public static void añadirEmpleados() {
        listaEmpleados[0] = new Empleado("Javier Gonzalez", "26479512L", "Técnico");
        listaEmpleados[1] = new Empleado("Federico Gutierrez", "24624135M", "Administrador");
        listaEmpleados[2] = new Empleado("Alonso Gallardo", "63424671N", "Programador");
        listaEmpleados[3] = new Empleado("Manuel Dominguez", "57234134B", "Jefe de proyecto");
        listaEmpleados[4] = new Empleado("Antonio Perez", "48395713A", "Jefe de operaciones");
    }

    public Proyecto[] getListaProyectos() {
        return listaProyectos;
    }

    public Empleado[] getListaEmpleados() {
        return listaEmpleados;
    }

    public Proyecto getProyecto(String nombreProyecto) {
        for (int i=0;i<listaProyectos.length;i++) {
            if (listaProyectos[i].getNombre().equals(nombreProyecto))
                return listaProyectos[i];
        }
        return null;
    }

    public Empleado getEmpleado(String nombreEmpleado) {
        for (int i=0;i<listaEmpleados.length;i++) {
            if (listaEmpleados[i].getNombreApellidos().equals(nombreEmpleado))
                return listaEmpleados[i];
        }
        return null;
    }

    public double getSueldoCategoria(String categoria) {
        return sueldoCategoria.get(categoria);
    }

    public void listadoDeNominas() {
        for (int i=0;i<listaEmpleados.length;i++) {
            System.out.println(listaEmpleados[i]);
        }
        gestorXML.listadoNominas();
    }
}
