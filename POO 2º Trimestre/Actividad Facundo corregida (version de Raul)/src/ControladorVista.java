import java.time.LocalDate;

public class ControladorVista {

    private static Vista vista;

    public void inicializarVista() {
        GestorDeTareas gestorDeTareas = new GestorDeTareas();
        vista = new Vista();
        int opcion;
        opcion = vista.mostrarMenu();
        while (opcion != Vista.TERMINAR) {
            switch (opcion) {
                case Vista.CREAR_CATEGORIA:
                    String nombreCategoria = vista.obtenerCategoria();
                    gestorDeTareas.añadirCategoria(new Categoria(nombreCategoria));
                    break;
                case Vista.MOSTRAR_CATEGORIAS:
                    vista.mostrarCategorias(gestorDeTareas.listaCategorias());
                    break;
                case Vista.CREAR_TAREA:
                    String nombreTarea = vista.pedirNombreTarea();
                    LocalDate fecha = vista.pedirFechaTarea();
                    Categoria categoria = vista.pedirCategoria(gestorDeTareas);
                    gestorDeTareas.añadirTarea(new Tarea(nombreTarea, fecha, categoria));
                    break;
                case Vista.CONSULTAR_TAREAS:
                    vista.mostrarTareas(gestorDeTareas.tareasPendientes());
                    break;
                case Vista.ELIMINAR_TAREA:
                    int posTarea = vista.pedirPosicionTareaAEliminar(gestorDeTareas.listaTareas);
                    gestorDeTareas.completarTarea(posTarea);
                    break;
                case Vista.CONSULTAR_TAREAS_CATEGORIA:
                    categoria = vista.pedirCategoria(gestorDeTareas);
                    vista.mostrarTareas(gestorDeTareas.tareasDeUnaCategoria(categoria));
                    break;
                case Vista.CONSULTAR_TAREAS_FECHA:
                    fecha = vista.pedirFechaTarea();
                    vista.mostrarTareas(gestorDeTareas.tareasEnUnaFecha(fecha));
                    break;
                case Vista.CONSULTAR_TAREAS_EN_PLAZO:
                    vista.mostrarTareas(gestorDeTareas.tareasEnTiempo());
                    break;
                case Vista.CONSULTAR_TAREAS_RETRASADAS:
                    vista.mostrarTareas(gestorDeTareas.tareasRetrasadas());
                    break;
            }
            opcion = vista.mostrarMenu();
        }
    }
}
