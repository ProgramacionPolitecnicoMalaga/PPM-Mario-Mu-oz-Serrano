import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;

    public class GestorXML {

        private Cursos cursos = new Cursos();

        public GestorXML() {

        }

        public ArrayList<Curso> IntroducirCursosYAsignaturas() {
            String dir = System.getProperty("user.dir");
            ArrayList<Curso> listaCursos = new ArrayList<Curso>();
            ArrayList<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();
            File inputFile = new File(dir + File.separator + "cursos.xml");
            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();
                NodeList nodeList = doc.getElementsByTagName("curso");
                for(int temp = 0; temp < nodeList.getLength(); temp++) {
                    Node nNode = nodeList.item(temp);
                    Element eElement = (Element) nNode;
                    NodeList nodeList3 = nNode.getChildNodes();
                    System.out.println(nNode.getFirstChild());
                    Curso curso = new Curso(eElement.getAttribute("id"), eElement.getAttribute("nombre"));
                    cursos.introducirCurso(curso);
                    NodeList nodeList2 = doc.getElementsByTagName("asignatura");
                    for (int i = 0; i < nodeList2.getLength(); i++) {
                        Node nNode2 = nodeList2.item(i);
                        Element eLement2 = (Element) nNode2;
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return listaCursos;
        }

        public ArrayList<Curso> MatricularAlumnosyAñadirIndicadores() {
            String dir = System.getProperty("user.dir");
            ArrayList<Curso> listaCursos = new ArrayList<Curso>();
            File inputFile = new File(dir + File.separator + "prog_S11AW.xml");
            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();
                NodeList nodeList = doc.getElementsByTagName("asignatura");
                for(int temp = 0; temp < nodeList.getLength(); temp++) {
                    Node nNode = nodeList.item(temp);
                    Element eElement = (Element) nNode;
                    Curso curso = cursos.getCurso(eElement.getAttribute("curso"));
                    Asignatura asignatura = curso.getAsignatura(eElement.getAttribute("id"));
                    NodeList nodeList2 = doc.getElementsByTagName("alumno");
                    for (int i = 0; i < nodeList2.getLength(); i++) {
                        Node nNode2 = nodeList2.item(i);
                        Element eLement2 = (Element) nNode2;
                        Alumno alumno1 = new Alumno(eLement2.getAttribute("nombre"),
                                 eLement2.getAttribute("dni"), curso);
                        asignatura.matricularAlumno(alumno1);
                        NodeList nodeList3 = doc.getElementsByTagName("indicador");
                        for (int x = 0; x < nodeList3.getLength(); x++) {
                            Node nNode3 = nodeList3.item(x);
                            Element eLement3 = (Element) nNode3;
                        }
                    }

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return listaCursos;
        }

}
