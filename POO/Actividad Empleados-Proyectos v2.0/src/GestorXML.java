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

    public GestorXML() {

    }

    public static ArrayList<Proyecto> leerXMLProyectos() {
        String dir = System.getProperty("user.dir");
        ArrayList<Proyecto> listaProyectos = new ArrayList<Proyecto>();

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
                listaProyectos.add(new Proyecto
                        (eElement.getAttribute("nombre"), eElement.getAttribute("departamento"),
                                Double.parseDouble(eElement.getAttribute("fprod")), eElement.getTextContent()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listaProyectos;
    }

    public void escribirXML(String xmlSerializado, String nombre){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlSerializado)));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            DOMSource source = new DOMSource(doc);

            StreamResult result =  new StreamResult(new File(nombre));
            transformer.transform(source, result);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}
