package Datos;
import java.util.ArrayList;

public class Categoria {

    private String nombre;
    private ArrayList<Tarea> tareasPendientes = new ArrayList<>();
    private ArrayList<Tarea> tareasCompletadas = new ArrayList<>();

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Tarea> getTareasPendientes() {
        return tareasPendientes;
    }

    public ArrayList<Tarea> getTareasCompletadas() {
        return tareasCompletadas;
    }

    @Override
    public String toString() {
        return "Nombre categoría: " + nombre;
    }
}