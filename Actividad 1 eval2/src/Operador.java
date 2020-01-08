public class Operador {

    public double hipotenusa;

    public Operador() {

    }

    public double operacionOpcion1(double cateto, double cateto2) {
        hipotenusa = Math.sqrt(Math.pow(cateto,2)+Math.pow(cateto2,2));
        return hipotenusa;
    }

    public double operacionOpcion2(double cateto, double hipotenusa) {
        return Math.sqrt(Math.pow(hipotenusa,2) - Math.pow(cateto,2));
    }

    public double operacionOpcion3(double cateto, double hipotenusa) {
        return (cateto*hipotenusa)/2;
    }

    public double operacionOpcion4(double cateto, double cateto2) {
       hipotenusa = Math.sqrt(Math.pow(cateto,2)+Math.pow(cateto2,2));
       return (cateto*hipotenusa)/2;
    }
}
