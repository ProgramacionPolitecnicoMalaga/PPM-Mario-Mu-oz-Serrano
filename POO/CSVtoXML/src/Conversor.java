import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class Conversor {

    public Conversor() {

    }

   public void convertirConCadena() {
        String[] linea;
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("airlines.dat"));
            BufferedWriter bw = new BufferedWriter (new FileWriter("airlines_con_cadena.xml"));
            String line = br.readLine();
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            bw.write("<aerolineas>\n");
            while (null != line) {
                linea = line.split(",");
                bw.write("\t<Pais id=" + linea[6] + ">\n");
                bw.write("\t\t<aerolinea id=\"" + linea[0] + "\">\n");
                bw.write("\t\t\t<nombre>" + linea[1].replaceAll("\"","") + "</nombre>\n");
                bw.write("\t\t\t<iata>" + linea[4].replaceAll("\"","") + "</iata>\n");
                bw.write("\t\t\t<codigoLlamada>" + linea[5].replaceAll("\"","") + "</codigoLlamada>\n");
                bw.write("\t\t</aerolinea>\n");
                bw.write("\t</Pais>");
                bw.newLine();
                line = br.readLine();
            }
            bw.write("</aerolineas>\n");
            bw.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void convertirConNodos() {
        String[] linea;
        BufferedReader br = null;

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            br = new BufferedReader(new FileReader("airlines.dat"));
            String line = br.readLine();
            Document doc = docBuilder.newDocument();

            Element elementoRaiz = doc.createElement("aerolineas");
            doc.appendChild(elementoRaiz);
            while (null != line) {
                linea = line.split(",");
                Element Pais = doc.createElement("Pais");
                elementoRaiz.appendChild(Pais);

                Attr paisId = doc.createAttribute("id");
                paisId.setNodeValue(linea[6].replaceAll("\"",""));
                Pais.setAttributeNode(paisId);

                Element aerolinea = doc.createElement("aerolinea");
                Pais.appendChild(aerolinea);

                Attr aerolineaId = doc.createAttribute("id");
                aerolineaId.setValue(linea[0]);
                aerolinea.setAttributeNode(aerolineaId);

                Element nombre = doc.createElement("nombre");
                nombre.appendChild(doc.createTextNode(linea[1].replaceAll("\"","")));
                aerolinea.appendChild(nombre);

                Element iata = doc.createElement("iata");
                iata.appendChild(doc.createTextNode(linea[4].replaceAll("\"","")));
                aerolinea.appendChild(iata);

                Element codigoLlamada = doc.createElement("codigoLlamada");
                codigoLlamada.appendChild(doc.createTextNode(linea[5].replaceAll("\"","")));
                aerolinea.appendChild(codigoLlamada);

                line = br.readLine();
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("airlines_con_nodos.xml"));
            transformer.transform(source, result);

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}
