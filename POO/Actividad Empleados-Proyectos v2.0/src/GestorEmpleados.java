import java.util.*;

public class GestorEmpleados {

    private ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
    private ArrayList<Proyecto> listaProyectos = new ArrayList<Proyecto>();
    private static ArrayList<Actividad> listaActividades = new ArrayList<Actividad>();
    private GestorXML gestorXML = new GestorXML();
    private final static int TECNICO = 1;
    private final static int ADMINISTRADOR = 2;
    private final static int PROGRAMADOR = 3;
    private final static int JEFE_DE_PROYECTO = 4;
    private final static int JEFE_DE_OPERACIONES = 5;

    public GestorEmpleados() {

    }

    public void listarProyectos() {
        listaProyectos = GestorXML.leerXMLProyectos();
    }

    public void añadirEmpleados() {
        listaEmpleados.add(new Empleado("Javier Gonzalez", "26479512L", TECNICO));
        listaEmpleados.add(new Empleado("Federico Gutierrez", "24624135M", ADMINISTRADOR));
        listaEmpleados.add(new Empleado("Alonso Gallardo", "63424671N", PROGRAMADOR));
        listaEmpleados.add(new Empleado("Manuel Dominguez", "57234134B", JEFE_DE_PROYECTO));
        listaEmpleados.add(new Empleado("Antonio Perez", "48395713A", JEFE_DE_OPERACIONES));
    }

    public static double getSueldoBase(int categoria) {
        switch (categoria){
            case TECNICO:
                return 900;
            case ADMINISTRADOR:
                return 1400;
            case PROGRAMADOR:
                return 1800;
            case JEFE_DE_PROYECTO:
                return 2500;
            case JEFE_DE_OPERACIONES:
                return 3500;
            default:
                return 0;
        }
    }

    public static String getCategoria(int categoria) {
        switch (categoria){
            case TECNICO:
                return "Técnico";
            case ADMINISTRADOR:
                return "Administrador";
            case PROGRAMADOR:
                return "Programador";
            case JEFE_DE_PROYECTO:
                return "Jefe de proyecto";
            case JEFE_DE_OPERACIONES:
                return "Jefe de operaciones";
            default:
                return "";
        }
    }

    public Proyecto getProyecto(String nombreProyecto) {
        Iterator<Proyecto> iterator = listaProyectos.iterator();
        while (iterator.hasNext()) {
            Proyecto proyecto = iterator.next();
            if (proyecto.getNombre().equals(nombreProyecto)) {
                return proyecto;
            }
        }
        return null;
    }

    public Empleado getEmpleado(String dni) {
        Iterator<Empleado> iterator = listaEmpleados.iterator();
        while (iterator.hasNext()) {
            Empleado empleado = iterator.next();
            if (empleado.getDNI().equals(dni)) {
                return empleado;
            }
        }
        return null;
    }

    public static void insertarActividad(Actividad actividad) {
        listaActividades.add(actividad);
    }

    public void listadoDeActividadesEmpleado(String dni) {
        Empleado empleado = getEmpleado(dni);
        ArrayList<Actividad> actividadesPorEmpleado = new ArrayList<Actividad>();
        Iterator<Actividad> iterator = listaActividades.iterator();
        System.out.println("Listado de actividades del empleado " + empleado.getNombreApellidos() + ":");
        while (iterator.hasNext()) {
            Actividad actividad = iterator.next();
            if (actividad.getEmpleado().equals(empleado)) {
                System.out.println(actividad);
                actividadesPorEmpleado.add(actividad);
            }
        }
        componerXMLActividadesPorEmpleado(actividadesPorEmpleado);
    }

    public void listadoDeActividadesProyecto(String nombreProyecto) {
        Proyecto proyecto = getProyecto(nombreProyecto);
        ArrayList<Actividad> actividadesPorProyecto = new ArrayList<Actividad>();
        Iterator<Actividad> iterator = listaActividades.iterator();
        System.out.println("Listado de actividades relacionadas con el proyecto " + proyecto.getNombre() + ":");
        while (iterator.hasNext()) {
            Actividad actividad = iterator.next();
            if (actividad.getProyecto().equals(proyecto)) {
                System.out.println(actividad);
                actividadesPorProyecto.add(actividad);
            }
        }
        componerXMLActividadesPorProyecto(actividadesPorProyecto);
    }

    public void listadoDeNominas() {
        Iterator<Empleado> iterator = listaEmpleados.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        componerXMLNominas();
    }

    public void componerXMLActividadesPorEmpleado(ArrayList<Actividad> actividades) {
            Empleado empleado = actividades.get(0).getEmpleado();
            String xmlSerializado = "<empleado nombre=\"" + empleado.getNombreApellidos() + "\" dni=\"" + empleado.getDNI() + "\" categoría=\"" + empleado.getCategoria() + "\">";
            Iterator<Actividad> it = actividades.iterator();
            while (it.hasNext()) {
                Actividad actividad = it.next();
                Proyecto proyecto = actividad.getProyecto();
                xmlSerializado += "<actividad proyecto=\"" + proyecto.getNombre() + "\" horas=\"" + actividad.getHoras() + "\">" +
                        actividad.getDescripción() +
                        "</actividad>";
            }
            xmlSerializado += "</empleado>";
            gestorXML.escribirXML(xmlSerializado,empleado.getDNI() + ".xml");
        }

    public void componerXMLActividadesPorProyecto(ArrayList<Actividad> actividades) {
        Proyecto proyecto = actividades.get(0).getProyecto();
        String xmlSerializado = "<proyecto nombre=\"" + proyecto.getNombre() + "\" departamento=\"" + proyecto.getDepartamento() + "\" fprod=\"" + proyecto.getFprod() + "\">";
        xmlSerializado += "<descripcion>" + proyecto.getDescripcion() + "</descripcion>";
        Iterator<Actividad> it = actividades.iterator();
        while (it.hasNext()) {
            Actividad actividad = it.next();
            Empleado empleado = actividad.getEmpleado();
            xmlSerializado += "<actividad horas=\"" + actividad.getHoras() + "\">";
            xmlSerializado += "<descripcion>" + actividad.getDescripción() + "</descripcion>";
            xmlSerializado += "<empleado nombre=\"" + empleado.getNombreApellidos() + "\" dni=\"" + empleado.getDNI()+ "\" categoría=\"" + empleado.getCategoria() + "\"/>";
            xmlSerializado += "</actividad>";
        }
        xmlSerializado += "</proyecto>";
        gestorXML.escribirXML(xmlSerializado, proyecto.getNombre() + ".xml");
    }

    public void componerXMLNominas() {
        String xmlSerializado = "<nominas>";
        Iterator<Empleado> it = listaEmpleados.iterator();
        while (it.hasNext()) {
            Empleado empleado = it.next();
            Nomina nomina = empleado.getNomina();
            xmlSerializado += "<nomina dni=\"" + empleado.getDNI() + "\" nombre=\"" + empleado.getNombreApellidos() + "\">";
            xmlSerializado += 	"<sueldo apartado=\"base\" valor=\"" + nomina.getSueldoBase() + "\"/>";
            xmlSerializado += 	"<sueldo apartado=\"productividad\" valor=\"" + nomina.getProductividad() + "\"/>";
            xmlSerializado += 	"<sueldo apartado=\"total\" valor=\"" + nomina.getSueldoTotal() + "\"/>";
            xmlSerializado += "</nomina>";
        }
        xmlSerializado += "</nominas>";
        gestorXML.escribirXML(xmlSerializado, "nominas.xml");
    }
}
