public class Nota{

    Double nota;
    String observaciones;

    public Nota(Double nota, String observaciones) {
        this.nota = nota;
        this.observaciones = observaciones;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Nota: " + nota +
                "\nObservaciones: " + observaciones
                + "\n===============================";
    }
}
