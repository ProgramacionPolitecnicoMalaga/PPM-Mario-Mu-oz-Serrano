package com.politecnicomalaga.modelo;
import java.util.ArrayList;

public class Credenciales {

    private ArrayList<Credencial> listaCredenciales;

    public Credenciales(ArrayList<Credencial> listaCredenciales) {
        this.listaCredenciales = listaCredenciales;
    }

    public void addCredencial(Credencial credencial) {
        listaCredenciales.add(credencial);
    }

    public void borrarCredencial(Credencial credencial) {
        listaCredenciales.remove(credencial);
    }

    public ArrayList<Credencial> getListaCredenciales() {
        return listaCredenciales;
    }

    public Credencial getCredencialPorNombre(String nombre) {
        for (Credencial credencial: listaCredenciales) {
            if (credencial.getNombre().equals(nombre)) {
                return credencial;
            }
        }
        return null;
    }
}
