package Modelo;

import Logica.Fecha;

public class Tarea {

    private Categoria categoria;
    private Fecha fechaLimite;
    private String descripcion;

    public Tarea(Categoria categoria, String fechaLimite, String descripcion) {
        this.categoria = categoria;
        this.fechaLimite = new Fecha(fechaLimite);
        this.descripcion = descripcion;
    }

    public Fecha getFechaLimite() {
        return fechaLimite;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Categoria: " + categoria.getNombre() +
                "\nFecha límite: " + fechaLimite +
                "\nDescripción: " + descripcion;
    }
}

