import java.util.ArrayList;
import java.util.Iterator;

public class Comerciales {

    private ArrayList<Comercial> comerciales = new ArrayList<>();

    public Comerciales() {

    }

    public void añadirComercial(Comercial comercial) {
        comerciales.add(comercial);
    }

    public ArrayList<Comercial> getComerciales() {
        return comerciales;
    }

    public ArrayList<Comercial> listaDeComercialesConEsasVentas(int numeroVentas) {
        ArrayList<Comercial> coincidencias = new ArrayList<>();
        Iterator<Comercial> it = comerciales.iterator();
        while (it.hasNext()) {
            Comercial comercial = it.next();
            if (comercial.buscarNumeroVentas(numeroVentas)) {
                coincidencias.add(comercial);
            }
        }
        return coincidencias;
    }

    public Comercial comercialConMayorNumeroVentasDia() {
        Iterator<Comercial> it = comerciales.iterator();
        int mayorNumero = Integer.MIN_VALUE;
        Comercial comercialConMasVentasDia = null;
        while (it.hasNext()) {
            Comercial comercial = it.next();
            if (comercial.mayorNumeroVentasDia()>mayorNumero) {
                mayorNumero = comercial.mayorNumeroVentasDia();
                comercialConMasVentasDia = comercial;
            }
        }
        return comercialConMasVentasDia;
    }
}
