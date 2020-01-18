import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Interfaz {

    private Comerciales comerciales;
    private Scanner lectorTeclado = new Scanner(System.in);
    private int numeroVentasABuscar;

    public Interfaz(Comerciales comerciales) {
        this.comerciales=comerciales;
    }

    public void pedirNumeroVentas() {
        System.out.println("Introduce un número de ventas a buscar:");
        numeroVentasABuscar = lectorTeclado.nextInt();
        generarMensajeVendedores();
    }

    public void generarMensajeVendedores() {
        ArrayList<Comercial> comercialesConEsasVentas = comerciales.listaDeComercialesConEsasVentas(numeroVentasABuscar);
        if (comercialesConEsasVentas.size()==1) {
            String mensajeSegunSexo = determinarMensajeSegunSexo(comercialesConEsasVentas.get(0));
            System.out.println( mensajeSegunSexo + " que vendió " + numeroVentasABuscar + " items fué: ");
            System.out.println(comercialesConEsasVentas.get(0));
            }
        else if (comercialesConEsasVentas.size()>1){
            System.out.println("Los empleados que vendieron " + numeroVentasABuscar + " items fueron:");
            Iterator<Comercial> it = comercialesConEsasVentas.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }
        if (comercialesConEsasVentas.size()==0) System.out.println("Ningún empleado vendió esa cantidad.");
    }

    public String determinarMensajeSegunSexo(Comercial comercial) {
        switch (comercial.getSexo()) {
            case "h": return "El empleado";
            case "m": return "La empleada";
            default : return "El empleado";
        }
    }

    public void generarMensajeMayorNumeroVentasDia() {
        Comercial comercial = comerciales.comercialConMayorNumeroVentasDia();
        String mensajeSegunSexo = determinarMensajeSegunSexo(comercial);
        System.out.println(comercial.getNombre() + " es " + mensajeSegunSexo.toLowerCase() + " de la semana con " + comercial.mayorNumeroVentasDia() + " items en un día.");
    }

    public void generarMensajePromedioVentas() {
        System.out.println("Promedio de ventas:");
        Iterator<Comercial> it = comerciales.getComerciales().iterator();
        while (it.hasNext()) {
            Comercial comercial = it.next();
            System.out.println(comercial.getNombre() + "         " + comercial.promedioDeVentas());
        }
    }
}