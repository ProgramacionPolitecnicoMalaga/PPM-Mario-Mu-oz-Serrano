public class Nota{

    Double nota;
    String observaciones;

    public Nota(Double nota, String observaciones) {
        this.nota = nota;
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Nota: " + nota +
                "\nObservaciones: " + observaciones
                + "\n===============================";
    }
}
