package Lógica;

import Datos.Categoria;
import Datos.Categorias;
import Datos.Tarea;

public class Main {

    public static void main(String[] args) {

        Categorias categorias = new Categorias();
        GestorDeTareas gestorDeTareas = new GestorDeTareas(categorias);

        System.out.println("\n1. Crear una nueva categoría:");
        Categoria clase = new Categoria("Clase");
        categorias.añadirCategoria(clase);

        System.out.println("\n2. Mostrar las categorías existentes:");
        categorias.listaCategorias(categorias.getCategorias());

        System.out.println("\n3. Crear una nueva tarea:");
        Tarea tarea1 = new Tarea(clase, "02/02/2020", "Estudiar para el examen de programación.");
        Tarea tarea2 = new Tarea(clase, "05/02/2020", "Realizar práctica de sistemas.");
        gestorDeTareas.añadirNuevaTarea(tarea1, clase);
        gestorDeTareas.añadirNuevaTarea(tarea2, clase);

        System.out.println("\n4. Consultar las tareas pendientes:");
        gestorDeTareas.listaTareasPendientes();

        System.out.println("\n5. Eliminar una tarea (completada):");
        gestorDeTareas.eliminarTareaPendiente(tarea1);

        System.out.println("\n6. Consultar las tareas de una categoría:");
        System.out.println("Tareas pendientes: ");
        gestorDeTareas.listaTareasPorCategoria(clase.getTareasPendientes());
        System.out.println("Tareas completadas: ");
        gestorDeTareas.listaTareasPorCategoria(clase.getTareasCompletadas());

        System.out.println("\n7. Consultar las tareas en una fecha.");
        gestorDeTareas.listaTareasPorFecha("05/02/2020", GestorDeTareas.TAREAS_EN_FECHA);

        System.out.println("\n8. Consultar las tareas en tiempo.");
        gestorDeTareas.listaTareasPorFecha(Fecha.getFechaActual(), GestorDeTareas.TAREAS_EN_TIEMPO);

        System.out.println("\n9. Consultar las tareas retrasadas.");
        gestorDeTareas.listaTareasPorFecha(Fecha.getFechaActual(), GestorDeTareas.TAREAS_RETRASADAS);
    }
}
