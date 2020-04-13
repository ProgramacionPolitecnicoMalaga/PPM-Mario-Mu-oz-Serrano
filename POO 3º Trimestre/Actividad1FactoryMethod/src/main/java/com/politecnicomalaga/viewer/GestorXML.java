package com.politecnicomalaga.viewer;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;

public class GestorXML {

    private static String dir = System.getProperty("user.dir");

    public static NodeList getNodeList() {
        NodeList nodeList = null;
        try {
        File inputFile = new File(dir + File.separator + "src/main/resources/poblacion.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        XPath xPath = XPathFactory.newInstance().newXPath();
        nodeList = (NodeList) xPath.compile("/root/row").evaluate(doc, XPathConstants.NODESET);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nodeList;
    }
}
