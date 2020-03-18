package com.politecnicomalaga.modelo;
import java.time.LocalDate;

public class Item {
    private int id;
    private String autor;
    private LocalDate fecha;
    private String texto;
    private String tema;

    public Item(int id, String autor, String tema, LocalDate fecha, String texto) {
        this.id = id;
        this.autor = autor;
        this.tema = tema;
        this.fecha = fecha;
        this.texto = texto;
    }

    public Item(String autor, String tema, LocalDate fecha, String texto) {
        this.autor = autor;
        this.tema = tema;
        this.fecha = fecha;
        this.texto = texto;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getTexto() {
        return texto;
    }

    public String getTema() {
        return tema;
    }

    public int getId() {
        return id;
    }
}
