package Logica;

import java.util.Calendar;
import java.util.Date;

public class Fecha {

    private Calendar fecha = Calendar.getInstance();
    private static Calendar fechaActual = Calendar.getInstance();

    public Fecha(String fecha) {
        String[] split = fecha.split("/");
        int year = Integer.parseInt(split[2]);
        int month = Integer.parseInt(split[1]);
        int date = Integer.parseInt(split[0]);
        this.fecha.set(year,month,date);
    }

    public Calendar getFecha() {
        return fecha;
    }

    public static String getFechaActual() {
        return fechaFormateada(fechaActual);
    }

    public String getFechaFormateada() {
        return fechaFormateada(fecha);
    }

    public static String fechaFormateada(Calendar fecha) {
        String dia = Integer.toString(fecha.get(Calendar.DATE));
        String mes = Integer.toString(fecha.get(Calendar.MONTH));
        String año = Integer.toString(fecha.get(Calendar.YEAR));
        String fechaFormateada = dia + "/" + mes + "/" + año;
        return fechaFormateada;
    }

    public int numeroDiasEntreDosFechas(Calendar fechaAComparar){
        Date tiempoFinal = fecha.getTime();
        Date tiempoInicio = fechaAComparar.getTime();
        long diferencia = tiempoFinal.getTime() - tiempoInicio.getTime();
        long diferenciaDias = diferencia / (1000 * 60 * 60 * 24);
        return (int)diferenciaDias;
    }

    @Override
    public String toString() {
        return getFechaFormateada();
    }
}