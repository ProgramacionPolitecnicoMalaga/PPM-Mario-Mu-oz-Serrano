public class Circulo extends Figuras {
    public double radio;

    public Circulo(String tipo, String color, double radio){
        super(tipo, color);
        this.radio=radio;
    }

    public double area() {
        double area;
        area = Math.PI * Math.pow(radio,2);
        return area;
    }

    public String toString(){
        return super.toString() + "Area: " + area();
    }
}
