package com.politecnicomalaga;

public class App {

    public static void main(String[] args) {
        Tareas tareas = Tareas.getInstance();
        AvanceTarea avanceTarea = new AvanceTarea();
        RetrocesoTarea retrocesoTarea = new RetrocesoTarea();

        // Insertar un conjunto de tareas en la clase Tareas.
        tareas.addTarea("Tarea 1");
        tareas.addTarea("Tarea 2");
        tareas.addTarea("Tarea 3");
        tareas.addTarea("Tarea 4");

        // Realizar varios avances y retrocesos en las tareas y comprobar que es coherente.
        avanceTarea.avanzar(2);
        System.out.println(tareas.getÚltimaTareaRealizada());

        retrocesoTarea.retroceder(1);
        System.out.println(tareas.getÚltimaTareaRealizada());

        avanceTarea.avanzar(3);
        System.out.println(tareas.getÚltimaTareaRealizada());

        retrocesoTarea.retroceder(3);
        System.out.println(tareas.getÚltimaTareaRealizada());

        avanceTarea.avanzar(1);
        System.out.println(tareas.getÚltimaTareaRealizada());
    }
}
