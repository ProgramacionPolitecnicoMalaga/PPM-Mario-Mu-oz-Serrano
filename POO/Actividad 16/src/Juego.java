public class Juego{

        public static void main(String[]args) {

                Jugador jugador1 = new Jugador("Azul", "Mario");
                Jugador jugador2 = new Jugador("Verde", "Javier");

                System.out.println("-----------------------");
                System.out.println("Realizar movimientos:");
                System.out.println("-----------------------");
                for (int i = 0; i < 5; i++) {
                        jugador1.tirarDado();
                        jugador2.tirarDado();
                }

                System.out.println("-----------------------");
                System.out.println("Retroceder casillas:");
                System.out.println("-----------------------");
                jugador1.retrocederACasilla(10);
                jugador2.retrocederACasilla(5);

                System.out.println("-----------------------");
                System.out.println("Deshacer movimientos:");
                System.out.println("-----------------------");
                for (int i = 0; i < 4; i++) {
                        jugador1.deshacer();
                        jugador2.deshacer();
                }

                System.out.println("-----------------------");
                System.out.println("Rehacer movimientos:");
                System.out.println("-----------------------");
                for (int i = 0; i < 4; i++) {
                        jugador1.rehacer();
                        jugador2.rehacer();
                }

                System.out.println("-----------------------");
                System.out.println("Mostrar historial:");
                System.out.println("-----------------------");
                jugador1.historial();
                System.out.println("-----------------------");
                jugador2.historial();
                }
        }
