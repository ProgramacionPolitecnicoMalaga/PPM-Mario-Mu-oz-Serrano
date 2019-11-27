
public class Incidencia {

    private String descripcion;
    private boolean grave;

    public String getDescripcion() {
        return descripcion;
    }

    public String getGravedad() {
        if (grave) {
            return "Grave";
        }
        return "Leve";
    }

    public Incidencia(String descripcion, boolean grave) {
        this.descripcion=descripcion;
        this.grave=grave;
    }

    @Override
    public String toString() {
        return ", descripción incidencia: " + descripcion +
                ", gravedad: " + getGravedad() + "\n";
    }
}
