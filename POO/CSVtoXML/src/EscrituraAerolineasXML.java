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

public class EscrituraAerolineasXML {

    String[][] aerolineas;
    String[][] aeropuertos;

    public EscrituraAerolineasXML(){
        generarArrays();
    }

    public void generarArrays() {
        ConversorCSV conversor = new ConversorCSV();
        aerolineas = conversor.convertirCSV("airlines.dat", 7, 6162);
        aeropuertos = conversor.convertirCSV("airports.dat", 13, 7184);
    }

    public void generarAerolineasCadena() {
            try {
                BufferedWriter bw = new BufferedWriter (new FileWriter("aerolineas_con_cadena.xml"));
                bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
                bw.write("<aerolineas>\n");
                for (int i=0; i<aerolineas.length;i++) {
                    bw.write("\t<Pais id=" + aerolineas[i][6] + ">\n");
                    bw.write("\t\t<aerolinea id=\"" + aerolineas[i][0] + "\">\n");
                    bw.write("\t\t\t<nombre>" + aerolineas[i][1].replaceAll("\"","") + "</nombre>\n");
                    bw.write("\t\t\t<iata>" + aerolineas[i][4].replaceAll("\"","") + "</iata>\n");
                    bw.write("\t\t\t<codigoLlamada>" + aerolineas[i][5].replaceAll("\"","") + "</codigoLlamada>\n");
                    bw.write("\t\t</aerolinea>\n");
                    bw.write("\t</Pais>");
                    bw.newLine();
                }
                bw.write("</aerolineas>\n");
                bw.close();
            } catch(Exception ex) {
                ex.printStackTrace();
            }
    }

    public void generarAerolineasNodos() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element elementoRaiz = doc.createElement("aerolineas");
            doc.appendChild(elementoRaiz);
            for (int i=0; i<aerolineas.length;i++) {
                Element Pais = doc.createElement("Pais");
                elementoRaiz.appendChild(Pais);

                Attr paisId = doc.createAttribute("id");
                paisId.setNodeValue(aerolineas[i][6].replaceAll("\"",""));
                Pais.setAttributeNode(paisId);

                Element aerolinea = doc.createElement("aerolinea");
                Pais.appendChild(aerolinea);

                Attr aerolineaId = doc.createAttribute("id");
                aerolineaId.setValue(aerolineas[i][0]);
                aerolinea.setAttributeNode(aerolineaId);

                Element nombre = doc.createElement("nombre");
                nombre.appendChild(doc.createTextNode(aerolineas[i][1].replaceAll("\"","")));
                aerolinea.appendChild(nombre);

                Element iata = doc.createElement("iata");
                iata.appendChild(doc.createTextNode(aerolineas[i][4].replaceAll("\"","")));
                aerolinea.appendChild(iata);

                Element codigoLlamada = doc.createElement("codigoLlamada");
                codigoLlamada.appendChild(doc.createTextNode(aerolineas[i][5].replaceAll("\"","")));
                aerolinea.appendChild(codigoLlamada);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("aerolineas_con_nodos.xml"));
            transformer.transform(source, result);

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}




