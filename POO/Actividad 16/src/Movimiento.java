public class Movimiento {

    private String tipo;
    private int casillaOriginal;
    private int casillaSiguiente;
    private int numero;
    private Jugador jugador;

    public Movimiento (String tipo, int numero, int casillaOriginal, Jugador jugador, int casillaSiguiente) {
        this.tipo=tipo;
        this.numero=numero;
        this.casillaOriginal=casillaOriginal;
        this.jugador=jugador;
        this.casillaSiguiente=casillaSiguiente;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNumero() {
        return numero;
    }

    public int getCasillaOriginal() {
        return casillaOriginal;
    }

    @Override
    public String toString() {
        if (tipo.equals("avance")) {
            return "Avance a la casilla: " + casillaSiguiente;
        }
        else {
            return "Retroceso a la casilla: " + casillaSiguiente;
        }
    }
}
