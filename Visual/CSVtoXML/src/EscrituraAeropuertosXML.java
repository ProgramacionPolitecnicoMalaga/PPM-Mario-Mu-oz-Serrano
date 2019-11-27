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

public class EscrituraAeropuertosXML {

    String[][] aerolineas;
    String[][] aeropuertos;

    public EscrituraAeropuertosXML(){
        generarArrays();
    }

    public void generarArrays() {
        ConversorCSV conversor = new ConversorCSV();
        aerolineas = conversor.convertirCSV("airlines.dat", 7, 6162);
        aeropuertos = conversor.convertirCSV("airports.dat", 13, 7184);
    }

    public void generarAeropuertosCadena() {
        try {
            BufferedWriter bw = new BufferedWriter (new FileWriter("aeropuertos_con_cadena.xml"));
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            bw.write("<aeropuertos>\n");
            for (int i=0; i<aeropuertos.length;i++) {
                bw.write("\t<Pais name=" + aeropuertos[i][3] + ">\n");
                bw.write("\t\t<aeropuerto>\n");
                bw.write("\t\t\t<nombre>" + aeropuertos[i][1].replaceAll("\"","") + "</nombre>\n");
                bw.write("\t\t\t<iata>" + aeropuertos[i][4].replaceAll("\"","") + "</iata>\n");
                bw.write("\t\t\t<localización>\n");
                bw.write("\t\t\t\t<ciudad>" + aeropuertos[i][2].replaceAll("\"","") + "</ciudad>\n");
                bw.write("\t\t\t\t<latitud>" + aeropuertos[i][6] + "</latitud>\n");
                bw.write("\t\t\t\t<longitud>" + aeropuertos[i][7] + "</longitud>\n");
                bw.write("\t\t\t</localización>\n");
                bw.write("\t\t</aeropuerto>\n");
                bw.write("\t</Pais>");
                bw.newLine();
            }
            bw.write("</aeropuertos>\n");
            bw.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void generarAeropuertosNodos() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element elementoRaiz = doc.createElement("aerolineas");
            doc.appendChild(elementoRaiz);
            for (int i=0; i<aeropuertos.length;i++) {
                Element Pais = doc.createElement("Pais");
                elementoRaiz.appendChild(Pais);

                Attr paisName = doc.createAttribute("name");
                paisName.setNodeValue(aeropuertos[i][3].replaceAll("\"",""));
                Pais.setAttributeNode(paisName);

                Element aeropuerto = doc.createElement("aeropuerto");
                Pais.appendChild(aeropuerto);

                Element nombre = doc.createElement("nombre");
                nombre.appendChild(doc.createTextNode(aeropuertos[i][1].replaceAll("\"","")));
                aeropuerto.appendChild(nombre);

                Element iata = doc.createElement("iata");
                iata.appendChild(doc.createTextNode(aeropuertos[i][4].replaceAll("\"","")));
                aeropuerto.appendChild(iata);

                Element localizacion = doc.createElement("localización");
                aeropuerto.appendChild(localizacion);

                Element ciudad = doc.createElement("ciudad");
                ciudad.appendChild(doc.createTextNode(aeropuertos[i][2].replaceAll("\"","")));
                localizacion.appendChild(ciudad);

                Element latitud = doc.createElement("latitud");
                latitud.appendChild(doc.createTextNode(aeropuertos[i][6]));
                localizacion.appendChild(latitud);

                Element longitud = doc.createElement("longitud");
                longitud.appendChild(doc.createTextNode(aeropuertos[i][7]));
                localizacion.appendChild(longitud);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("aeropuertos_con_nodos.xml"));
            transformer.transform(source, result);

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
