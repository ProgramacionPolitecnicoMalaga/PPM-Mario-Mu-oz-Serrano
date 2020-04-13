package com.politecnicomalaga.viewer;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TextDataViewer implements DataViewer{

    @Override
    public void mostrarContenido() {
        try {
            NodeList poblaciones = GestorXML.getNodeList();
            System.out.println("Listado de empadronamientos:\n");
            if (poblaciones != null) {
                for (int i = 0; i < poblaciones.getLength(); i++) {
                    Node poblacion = poblaciones.item(i);
                    NamedNodeMap atributosPoblacion = poblacion.getAttributes();
                    String año = atributosPoblacion.getNamedItem("Año").getTextContent();
                    String nacionalidad = atributosPoblacion.getNamedItem("Nacionalidad").getTextContent();
                    String empadronados = atributosPoblacion.getNamedItem("Número_de_empadronados").getTextContent();
                    System.out.println("El total de empadronados en " + año + " procedentes de " + nacionalidad + " fue de " + empadronados + " persona/s.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
