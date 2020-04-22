package com.politecnicomalaga.controlador;

import java.io.*;
import java.util.Properties;

public class Propiedades {

    private final static String NOMBRE_ARCHIVO_PROPIEDADES = "config.properties";
    private Properties properties;

    public Propiedades() throws IOException {
        File archivoPropiedades = new File(NOMBRE_ARCHIVO_PROPIEDADES);
        properties = new Properties();
        if (archivoPropiedades.exists()) {
            properties.load(new FileInputStream(archivoPropiedades));
        }
    }

    public String getPropiedad(String nombrePropiedad) {
        return properties.getProperty(nombrePropiedad);
    }

    public void setPropiedad(String nombrePropiedad, String valorPropiedad) throws IOException {
        properties.setProperty(nombrePropiedad, valorPropiedad);
        guardar();
    }

    public void guardar() throws IOException {
        FileOutputStream output = new FileOutputStream(new File(NOMBRE_ARCHIVO_PROPIEDADES));
        properties.store(output, "Configuración login");
    }

    public void borrar() throws IOException {
        properties.clear();
        guardar();
    }
}
