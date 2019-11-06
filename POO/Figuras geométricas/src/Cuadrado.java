public class Cuadrado extends Figuras {
    public double lado;

    public Cuadrado(String tipo, String color, double lado){
        super(tipo, color);
        this.lado=lado;
    }

    public double area() {
        double area;
        area = Math.pow(lado,2);
        return area;
    }

    public String toString(){
        return super.toString() + "Area: " + area();
    }

}
