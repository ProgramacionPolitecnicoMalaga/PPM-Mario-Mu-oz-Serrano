package com.politecnicomalaga.modelo;

public class Mensaje {
    private int id;
    private String titulo;
    private String cuerpo;
    private int idReceptor;
    private String nombreRemitente;

    public Mensaje(int id, String titulo, String cuerpo, int idReceptor, String nombreRemitente) {
        this.id = id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.idReceptor = idReceptor;
        this.nombreRemitente = nombreRemitente;
    }

    public Mensaje(String titulo, String cuerpo, int idReceptor, String nombreRemitente) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.idReceptor = idReceptor;
        this.nombreRemitente = nombreRemitente;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public int getIdReceptor() {
        return idReceptor;
    }

    public String getRemitente() {
        return nombreRemitente;
    }
}
