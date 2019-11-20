public class Jugador {

    private String color;
    private String nombreJugador;
    private int casillaActual;
    private funcionesJuego funcionesJuego;

    public Jugador (String color, String nombreJugador) {
        this.color=color;
        this.nombreJugador=nombreJugador;
        funcionesJuego = new funcionesJuego();
        casillaActual = 0;
    }

    public void tirarDado(){
        int resultado = (int) (Math.random() * 6 + 1);
        avanzarCasillas(resultado);
    }

    public void avanzarCasillas (int numero) {
        int anterior = casillaActual;
        casillaActual = casillaActual + numero;
        Movimiento movimiento = new Movimiento("avance", numero, anterior,this, casillaActual);
        funcionesJuego.guardarMovimiento(movimiento);
        System.out.println("El jugador " + nombreJugador + " tira el dado y avanza desde la casilla " + anterior + " hasta la casilla " + casillaActual);
    }

    public void retrocederACasilla (int numero) {
        int anterior = casillaActual;
        casillaActual = numero;
        Movimiento movimiento = new Movimiento("retroceso", numero, anterior, this, casillaActual);
        funcionesJuego.guardarMovimiento(movimiento);
        System.out.println("El jugador " + nombreJugador + " retrocede desde la casilla " + anterior + " hasta la casilla " + casillaActual);
    }

    public void deshacer() {
        Movimiento movimiento = funcionesJuego.undo();
        if (movimiento != null) {
            casillaActual = movimiento.getCasillaOriginal();
            System.out.println("El jugador " + nombreJugador + " deshace un movimiento, casilla actual: " + casillaActual);
        } else {
            System.out.println("No se puede deshacer ningún movimiento.");
        }
    }

    public void rehacer() {
        Movimiento movimiento = funcionesJuego.redo();
        if (movimiento != null) {
            casillaActual = movimiento.getCasillaSiguiente();
            System.out.println("El jugador " + nombreJugador + " rehace un movimiento, casilla actual: " + casillaActual);
        } else {
            System.out.println("No se puede rehacer ningún movimiento.");
            }
        }

    public void historial() {
        System.out.println("El jugador " + nombreJugador + " realizó los siguientes movimientos:");
        funcionesJuego.historial();
    }
}
