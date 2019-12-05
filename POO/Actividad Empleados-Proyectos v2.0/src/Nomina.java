
public class Nomina {
    private double sueldoBase;
    private double sueldoTotal;
    private double productividad = 0;

    public Nomina() {

    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public double getSueldoTotal() {
        return sueldoTotal;
    }

    public double getProductividad() {
        return productividad;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public void setProductividad(double fprod, int horas) {
        productividad += fprod * horas;
        sueldoTotal = sueldoBase + productividad;
    }

    @Override
    public String toString() {
        return "\nSueldo base: " + sueldoBase +
                "\nProductividad: " + productividad +
                "\nSueldoTotal: " + sueldoTotal;
    }
}
