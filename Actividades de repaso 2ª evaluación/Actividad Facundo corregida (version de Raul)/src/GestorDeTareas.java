import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GestorDeTareas {
    public ArrayList<Tarea> listaTareas;
    public ArrayList<Tarea> listaTareasCompletadas;
    public ArrayList<Categoria> listaCategorias;

    public GestorDeTareas(){
        listaTareas = new ArrayList<Tarea>();
        listaCategorias = new ArrayList<Categoria>();
    }

    public void añadirTarea(Tarea tarea){
        listaTareas.add(tarea);
    }

    public void completarTarea(int posicion){
        listaTareasCompletadas.add(listaTareas.get(posicion));
        listaTareas.remove(posicion);
    }

    public ArrayList<Tarea> tareasPendientes(){
            return listaTareas;
    }

    public ArrayList<Tarea> tareasDeUnaCategoria(Categoria categoria){
        ArrayList<Tarea> tareasDeCategoria = new ArrayList<>();
        for(Tarea tarea: listaTareas)
            if(tarea.getCategoria().equals(categoria))
                tareasDeCategoria.add(tarea);
            return tareasDeCategoria;
    }

    public ArrayList<Tarea> tareasEnUnaFecha(LocalDate fecha){
        ArrayList<Tarea> fechaBuscada = new ArrayList<>();
        for(Tarea tarea: listaTareas)
            if(tarea.getFechaLimite().equals(fecha))
                fechaBuscada.add(tarea);
            return fechaBuscada;
    }

    public ArrayList<Tarea> tareasEnTiempo(){
        LocalDate fechaActual = LocalDate.now();
        ArrayList<Tarea> fechaTiempo = new ArrayList<>();
        for(Tarea tarea: listaTareas)
            if(tarea.getFechaLimite().compareTo(fechaActual) > -1)
                fechaTiempo.add(tarea);
            return fechaTiempo;
    }

    public ArrayList<Tarea> tareasRetrasadas(){
        LocalDate fechaActual = LocalDate.now();
        ArrayList<Tarea> fechaRetrasada = new ArrayList<>();
        for(Tarea tarea: listaTareas)
            if(tarea.getFechaLimite().compareTo(fechaActual) < 0)
                fechaRetrasada.add(tarea);
            return fechaRetrasada;
    }

    public ArrayList<Categoria> listaCategorias(){
        for(Tarea tarea: listaTareas)
            listaCategorias.add(tarea.getCategoria());
        Set<Categoria> hs = new HashSet<>(listaCategorias);
        listaCategorias.clear();
        listaCategorias.addAll(hs);
        return listaCategorias;
    }

    public ArrayList<Categoria> añadirCategoria(Categoria categoria){
        listaCategorias.add(categoria);
        return listaCategorias;
    }
}
