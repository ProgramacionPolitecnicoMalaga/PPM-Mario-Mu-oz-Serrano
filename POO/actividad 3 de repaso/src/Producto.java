import java.util.ArrayList;

public class Producto {

    private String id;
    private ArrayList<Componente> especificaciones;

    public Producto(String id) {
        this.id = id;
        especificaciones = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEspecificaciones(Componente especificación) {
        especificaciones.add(especificación);
    }

    public ArrayList<Componente> getEspecificaciones() {
        return especificaciones;
    }

}