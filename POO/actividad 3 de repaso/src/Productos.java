import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Productos {

    public Productos() {

    }

    private ArrayList<Producto> listaProductos = new ArrayList<Producto>();

    public Producto getProducto(String id) {
        Iterator<Producto> it = listaProductos.iterator();
        while (it.hasNext()) {
            Producto producto = it.next();
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
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
            String xpathExpr = "/productos/producto";
            NodeList nodeList = (NodeList) xPath.compile(xpathExpr).evaluate(doc, XPathConstants.NODESET);

            for (int i=0; i<nodeList.getLength();i++) {
                Node nNode = nodeList.item(i);
                Element elementoComponente = (Element) nNode;
                Producto producto = new Producto(elementoComponente.getAttribute("id"));
                listaProductos.add(producto);
                NodeList especificaciones = nNode.getChildNodes();
                for (int j = 0; j < especificaciones.getLength(); j++) {
                    Node nNode2 = especificaciones.item(j);
                    if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement2 = (Element) nNode2;
                        producto.setEspecificaciones(new Componente(eElement2.getAttribute("id"),Integer.parseInt(eElement2.getAttribute("cantidad"))));
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
