package com.politecnicomalaga;

public class RetrocesoTarea {

    Tareas tareas = Tareas.getInstance();

    public void retroceder(int numero) {
        tareas.cambiarÚltimaTareaRealizada(-numero);
    }

    public String mostrarÚltimaTareaRealizada() {
        return tareas.getÚltimaTareaRealizada();
    }
}
