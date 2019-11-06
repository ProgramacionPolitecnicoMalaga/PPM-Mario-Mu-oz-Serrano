
public class Programa {

    public static void main(String[] args) {
        Figuras[] figuras = new Figuras[9];

        figuras[0] = new Triangulo("Triángulo","Verde", 5, 8);
        figuras[1] = new Triangulo("Triángulo","Rojo", 7, 4);
        figuras[2] = new Triangulo("Triángulo","Azul", 1, 5);
        figuras[3] = new Cuadrado("Cuadrado","Amarillo", 5);
        figuras[4] = new Cuadrado("Cuadrado","Rosa", 3);
        figuras[5] = new Cuadrado("Cuadrado","Marrón", 7);
        figuras[6] = new Circulo("Círculo","Rojo", 1);
        figuras[7] = new Circulo("Círculo","Verde", 2);
        figuras[8] = new Circulo("Círculo","Blanco", 5);

        for (int i=0; i<figuras.length;i++) {
            System.out.println(figuras[i]);
        }
    }
}
