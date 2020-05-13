package com.politecnicomalaga.modelo;

import java.util.ArrayList;
import java.util.List;

public class ExpertoCerveza {
    public List getMarcas(String color){
        List<String> cervezas = new ArrayList<>();
        switch (color){
            case "clara":
                cervezas.add("San Miguel - Fresca");
                cervezas.add("Estrea Damm - Saaz");
                break;
            case "ambar":
                cervezas.add("Ambar - Especial");
                cervezas.add("Alhambra - Especial");
                cervezas.add("Estrella Damm - Original");
                break;
            case "marron":
                cervezas.add("Estrella Damm - Bock-Damm");
                cervezas.add("Mahou - Maestra");
                break;
            case "negra":
                cervezas.add("Estrella Galicia - 1906 Black Coupage");
                cervezas.add("Alhambra - Baltic Porter");
                break;
            default:
                cervezas.add("No hay sugerencias");
        }
        return cervezas;
    }
}