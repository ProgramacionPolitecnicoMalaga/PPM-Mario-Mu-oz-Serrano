public abstract class Figuras{
    public String tipo;
    public String color;
    public abstract double area();

    public Figuras(String tipo, String color){
        this.tipo=tipo;
        this.color=color;
    }

    public String getTipo(){
        return tipo;
    }

    public String getColor(){
        return color;
    }

    public double getArea(){
        return area();
    }

    public String toString(){
        return "=======================================\n"
                + "Figura: " + tipo + "\nColor: " + color + "\n";
    }
}
