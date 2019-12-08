public class Nota{

    Double nota;
    String observaciones;

    public Nota(Double nota, String observaciones) {
        this.nota = nota;
        this.observaciones = observaciones;
    }

    public Double getNota() {
        return nota;
    }

    public String getObservaciones() {
        return observaciones;
    }

    @Override
    public String toString() {
        return "Nota: " + nota +
                "\nObservaciones: " + observaciones
                + "\n===============================";
    }
}
