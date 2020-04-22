package com.politecnicomalaga;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private ArrayList<String> listaParticipantes = new ArrayList<>();;

    public boolean addParticipante(String nombreParticipante) {
        if (!listaParticipantes.contains(nombreParticipante)) {
            return listaParticipantes.add(nombreParticipante);
        }
        return false;
    }

    public List<String> getListadoParticipantes() {
        if (!listaParticipantes.isEmpty()) {
            return listaParticipantes;
        }
        return null;
    }

    public int getTotalParticipantes() {
        return listaParticipantes.size();
    }

    public List<String> cloneCarrera() {
        return (List<String>) listaParticipantes.clone();
    }

    public boolean setPosicion(String nombreParticipante, int posicionDestino) {
        if (listaParticipantes.contains(nombreParticipante)) {
            listaParticipantes.remove(nombreParticipante);
            listaParticipantes.add(posicionDestino-1, nombreParticipante);
            return true;
        }
        return false;
    }

    public String getParticipantePorPosicion (int posicion) {
        return listaParticipantes.get(posicion-1);
    }

    public void cerrarListaParticipantes() {
        listaParticipantes.clear();
    }
}
