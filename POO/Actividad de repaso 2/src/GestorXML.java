import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;

    public class GestorXML {

        String dir = System.getProperty("user.dir");

        public GestorXML() {

        }

        public void IntroducirCursosYAsignaturas() {
            try {
                File inputFile = new File(dir + File.separator + "cursos.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();
                XPath xPath = XPathFactory.newInstance().newXPath();
                NodeList cursos = (NodeList) xPath.compile("/cursos/curso").evaluate(doc, XPathConstants.NODESET);
                if (cursos != null) {
                    for (int i = 0; i < cursos.getLength(); i++) {
                        Node curso = cursos.item(i);
                        NamedNodeMap atributosCurso = curso.getAttributes();
                        Curso nuevoCurso = new Curso(atributosCurso.getNamedItem("id").getTextContent(), atributosCurso.getNamedItem("nombre").getTextContent());
                        Cursos.introducirCurso(nuevoCurso);
                        NodeList asignaturas = curso.getChildNodes();
                        for (int j = 0; j < asignaturas.getLength(); j++) {
                            Node asignatura = asignaturas.item(j);
                            if (asignatura.getNodeType() == Node.ELEMENT_NODE) {
                                NamedNodeMap atributosAsignatura = asignatura.getAttributes();
                                Asignatura nuevaAsignatura = new Asignatura(atributosAsignatura.getNamedItem("id").getTextContent(), atributosAsignatura.getNamedItem("nombre").getTextContent(), nuevoCurso);
                            }
                        }
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public void MatricularAlumnosyAñadirIndicadores() {
            try {
                File inputFile = new File(dir + File.separator + "prog_S11AW.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();
                XPath xPath = XPathFactory.newInstance().newXPath();
                NodeList elementos = (NodeList) xPath.compile("/asignatura").evaluate(doc, XPathConstants.NODESET);
                if (elementos != null) {
                    for (int i = 0; i < elementos.getLength(); i++) {
                        Node elemento = elementos.item(i);
                        NamedNodeMap atributosCurso = elemento.getAttributes();
                        Curso curso = Cursos.getCurso(atributosCurso.getNamedItem("curso").getTextContent());
                        Asignatura asignatura = curso.getAsignatura(atributosCurso.getNamedItem("id").getTextContent());
                        NodeList alumnos = elemento.getChildNodes();
                        for (int j = 0; j < alumnos.getLength(); j++) {
                            Node alumno = alumnos.item(j);
                            if (alumno.getNodeType() == Node.ELEMENT_NODE) {
                                NamedNodeMap atributosAlumno = alumno.getAttributes();
                                Alumno nuevoAlumno = new Alumno(atributosAlumno.getNamedItem("nombre").getTextContent(), atributosAlumno.getNamedItem("dni").getTextContent(), curso);
                                asignatura.matricularAlumno(nuevoAlumno);
                                NodeList indicadores = alumno.getChildNodes();
                                for (int x = 0; x < indicadores.getLength(); x++) {
                                    Node indicador = indicadores.item(x);
                                    if (indicador.getNodeType() == Node.ELEMENT_NODE) {
                                        NamedNodeMap atributosIndicador = indicador.getAttributes();
                                        Indicador nuevoIndicador = new Indicador(atributosIndicador.getNamedItem("tipo").getTextContent(), atributosIndicador.getNamedItem("nombre").getTextContent(), asignatura);
                                        nuevoAlumno.asignarNota(nuevoIndicador, new Nota(Double.parseDouble(atributosIndicador.getNamedItem("nota").getTextContent()), indicador.getTextContent()));
                                        nuevoAlumno.listadoDeNotas();
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

