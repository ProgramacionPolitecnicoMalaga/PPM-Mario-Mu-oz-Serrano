public class Triangulo extends Figuras {
    public double base;
    public double altura;

    public Triangulo(String tipo, String color, double base, double altura){
        super(tipo, color);
        this.base=base;
        this.altura=altura;
    }

    public double area() {
        double area;
        area = base*altura /2;
        return area;
    }

    public String toString(){
        return super.toString() + "Area: " + area();
    }
}
