import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventario {

    ArrayList<Componente> existencias;

    public Inventario() {
        existencias = new ArrayList<Componente>();
    }

    public void fabricarProducto(Producto producto) {
        Iterator<Componente> it = producto.getEspecificaciones().iterator();
        boolean mensaje = false;
        while (it.hasNext()){
            Componente componente = it.next();
            Iterator<Componente> it2 = existencias.iterator();
            while (it2.hasNext()) {
                Componente componente2 = it2.next();
                if (componente.getId().equals(componente2.getId())) {
                    componente2.setCantidad(componente2.getCantidad() - componente.getCantidad());
                    if (componente.getCantidad()*10>componente2.getCantidad()) {
                        mensaje = true;
                    }
                }
            }
        }
        if (mensaje) System.out.println("AVISO: Quedan menos unidades de las necesarias para fabricar 10 productos " + producto.getId());
    }

    public void mostrarInventario() {
        Iterator<Componente> it = existencias.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    public void componerXMLExistencias() {
        String xmlSerializado = "<inventario>";
        Iterator<Componente> it = existencias.iterator();
        while (it.hasNext()) {
            Componente componente = it.next();
            xmlSerializado += "<componente id=\"" + componente.getId() + "\" existencias=\"" + componente.getCantidad() + "\"/>";
        }
        xmlSerializado += "</inventario>";
        escribirXML(xmlSerializado,"inventario_escritura.xml");
    }

    public static void escribirXML(String xmlSerializado, String nombre){
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

    public void leerXMLExistencias(String nombreArchivo) {
        String dir = System.getProperty("user.dir");
        try {
            File inputFile = new File(dir + File.separator + nombreArchivo);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();
            String xpathExpr = "/inventario/componente";
            NodeList nodeList = (NodeList) xPath.compile(xpathExpr).evaluate(doc, XPathConstants.NODESET);

            for (int i=0; i<nodeList.getLength();i++) {
                Element elementoComponente = (Element) nodeList.item(i);
                String id = elementoComponente.getAttribute("id");
                int cantidad = Integer.parseInt(elementoComponente.getAttribute("existencias"));
                existencias.add(new Componente(id,cantidad));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
