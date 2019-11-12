import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Aeropuertos {


    private JComboBox comboBoxPaises;
    private JButton buscarButton;
    private JTextArea textAreaResultados;
    private JPanel panelMain;
    private JButton iniciarButton;
    private String dir = System.getProperty("user.dir");

    public Aeropuertos() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaResultados.setText("");
                boolean indicadorPais = false;
                File inputFile = new File(dir + File.separator + "aeropuertos.xml");

                try {
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(inputFile);
                    doc.getDocumentElement().normalize();
                    NodeList nodeList = doc.getElementsByTagName("aeropuerto");

                    for(int temp = 0; temp < nodeList.getLength(); temp++) {
                        Node nNode = nodeList.item(temp);
                        Element eElement = (Element) nNode;

                        if (eElement.getAttribute("pais").equals(comboBoxPaises.getSelectedItem())) {

                            if (!indicadorPais){
                                textAreaResultados.append("Pais seleccionado: " + eElement.getAttribute("pais") + "\n\n");
                                indicadorPais=true;
                            }

                            textAreaResultados.append("Nombre: " + eElement.getAttribute("nombreLargo"));
                            textAreaResultados.append("  Matricula: " + eElement.getAttribute("matricula"));
                            textAreaResultados.append("  Latitud: " + eElement.getAttribute("lat") + "");
                            textAreaResultados.append("  Longitud: " + eElement.getAttribute("lon") + "\n");
                        }

                    }

                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
            });

        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buscarButton.setEnabled(true);
                comboBoxPaises.setEnabled(true);
                File inputFile = new File(dir + File.separator + "aeropuertos.xml");

                try {
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(inputFile);
                    doc.getDocumentElement().normalize();
                    NodeList nodeList = doc.getElementsByTagName("aeropuerto");

                    for(int temp = 0; temp < nodeList.getLength(); temp++) {
                        Node nNode = nodeList.item(temp);
                        Element eElement = (Element) nNode;
                        boolean esta = false;

                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                            String pais = eElement.getAttribute("pais");

                            for (int i=0; i<comboBoxPaises.getItemCount(); i++) {
                                if (comboBoxPaises.getItemAt(i).equals(pais)) {
                                    esta = true;
                                }
                            }
                            if (!esta){
                                comboBoxPaises.addItem(pais);
                            }
                        }
                    }
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        }

    public static void main(String[] args){
        JFrame frame = new JFrame("Aeropuertos del mundo");
        frame.setContentPane(new Aeropuertos().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
