package com.politecnicomalaga;

import java.util.ArrayList;

public class Tareas {

    private static Tareas instancia = null;

    private ArrayList<String> tareas;
    private int ultimaRealizada;

    public Tareas(){
        tareas = new ArrayList<>();
    }

    public static Tareas getInstance(){
        if (instancia == null)
            instancia = new Tareas();
        return instancia;
    }

    public void addTarea(String tarea) {
        tareas.add(tarea);
        ultimaRealizada = tareas.size()-1;
    }

    public String getÚltimaTareaRealizada() {
        return tareas.get(ultimaRealizada);
    }

    public void cambiarÚltimaTareaRealizada(int numero) {
        ultimaRealizada += numero;
    }
}
