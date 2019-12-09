public class Periodo {

    private long tiempoInicio;
    private long tiempoFin;

    public Periodo() {

    }

    public long getPeriodo() {
        return tiempoFin-tiempoInicio;
    }

    public void setTiempoFin(long tiempoFin) {
        this.tiempoFin = tiempoFin;
    }

    public void setTiempoInicio(long tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }
}
