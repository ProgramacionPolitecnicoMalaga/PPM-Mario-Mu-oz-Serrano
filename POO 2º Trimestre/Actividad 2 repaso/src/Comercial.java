import java.util.ArrayList;
import java.util.Iterator;

public class Comercial {

    private String nombre;
    private String apellidos;
    private String sexo;
    private ArrayList<Integer> ventas = new ArrayList<>();

    public Comercial(String nombre, String apellidos, String sexo, ArrayList<Integer> ventas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo=sexo;
        this.ventas = ventas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public boolean buscarNumeroVentas(int numeroVentas) {
        Iterator<Integer> it = ventas.iterator();
        while (it.hasNext()) {
            if (it.next() == numeroVentas) {
                return true;
            }
        }
        return false;
    }

    public double promedioDeVentas() {
        double sumaVentas = 0;
        Iterator<Integer> it = ventas.iterator();
        while (it.hasNext()) {
            sumaVentas += it.next();
            }
            return sumaVentas/ventas.size();
    }

    public int mayorNumeroVentasDia() {
        Iterator<Integer> it = ventas.iterator();
        int mayorNumero = Integer.MIN_VALUE;
        while (it.hasNext()) {
            int venta = it.next();
            if (venta > mayorNumero) {
                mayorNumero = venta;
            }
        }
        return mayorNumero;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos;
    }
}