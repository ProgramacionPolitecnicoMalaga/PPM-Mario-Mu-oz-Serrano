import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

public class GestorXML {

    private String dir = System.getProperty("user.dir");

    public GestorXML() {

    }

    public Proyecto[] leerXMLProyectos() {
        Proyecto[] listaProyectos = new Proyecto[5];

        File inputFile = new File(dir + File.separator + "proyectos.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("proyecto");
            for(int temp = 0; temp < nodeList.getLength(); temp++) {
                Node nNode = nodeList.item(temp);
                Element eElement = (Element) nNode;
                    listaProyectos[temp] = (new Proyecto
                                        (eElement.getAttribute("nombre"), eElement.getAttribute("departamento"),
                                         Double.parseDouble(eElement.getAttribute("fprod")), eElement.getTextContent()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listaProyectos;
    }

    public void listadoTareasEmpleado(Empleado empleado) {
        try {
            BufferedWriter bw = new BufferedWriter (new FileWriter(empleado.getDNI() + ".xml"));
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            bw.write("<tareas>\n");
            Iterator it = empleado.getProyectoHoras().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Proyecto key = (Proyecto)entry.getKey();
                Integer value = (Integer)entry.getValue();
                bw.write("\t<proyecto nombre=\"" + key.getNombre() +
                             "\" departamento=\"" + key.getDepartamento() +
                             "\" descripción=\"" + key.getDescripcion() +
                             "\" horas=\"" + value + "\"/>");
                bw.newLine();
            }
            bw.write("</tareas>\n");
            bw.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void listadoTareasProyecto(Proyecto proyecto) {
        try {
            BufferedWriter bw = new BufferedWriter (new FileWriter(proyecto.getNombre() + ".xml"));
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            bw.write("<" + proyecto.getNombre() + ">\n");
            bw.write("\t<departamento>" + proyecto.getNombre() + "</departamento>\n");
            bw.write("\t<descripcion>" + proyecto.getDescripcion() + "</descripcion>\n");
            ListIterator<Empleado> it = proyecto.getListaEmpleados().listIterator();
            while (it.hasNext()) {
                Empleado empleado = it.next();
                bw.write("\t<empleado nombre=\"" + empleado.getNombreApellidos() +
                        "\">\n");
                bw.write("\t\t<horas>" + empleado.getHorasProyecto(proyecto) +
                        "</horas>");
                bw.newLine();
            }
            bw.write("</" + proyecto.getNombre() + ">\n");
            bw.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void listadoNominas() {
        GestorEmpleados gestorEmpleados = new GestorEmpleados();
        try {
            BufferedWriter bw = new BufferedWriter (new FileWriter("nominas.xml"));
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            bw.write("<nominas>\n");
            for (int i=0;i<gestorEmpleados.getListaEmpleados().length;i++) {
                Empleado empleado = gestorEmpleados.getListaEmpleados()[i];
                bw.write("\t<empleado dni=\"" + empleado.getDNI() +
                              "\">");
                bw.write("\n\t\t<nombre>" + empleado.getNombreApellidos() + "</nombre>");
                bw.write("\n\t\t<sueldo base>" + empleado.getSueldoBase() + "</sueldo base>");
                bw.write("\n\t\t<productividad>" + empleado.getProductividad() + "</productividad>");
                bw.write("\n\t\t<sueldo total>" + empleado.getSueldoTotal() + "</sueldo total>");
                bw.write("\n\t</empleado>");
                bw.newLine();
            }
            bw.write("</nominas>\n");
            bw.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}
