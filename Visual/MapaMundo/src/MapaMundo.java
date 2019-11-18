import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
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

public class MapaMundo {


    private JComboBox comboBoxPaises;
    private JButton buscarButton;
    private JPanel panelMain;
    private JButton iniciarButton;
    private JMapViewer mapa;
    private String dir = System.getProperty("user.dir");

    public MapaMundo() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapa.removeAllMapMarkers();
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
                            mapa.addMapMarker(new MapMarkerDot(Double.parseDouble(eElement.getAttribute("lat")), Double.parseDouble(eElement.getAttribute("lon"))));
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
                mapa.removeAllMapMarkers();
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
        frame.setContentPane(new MapaMundo().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}