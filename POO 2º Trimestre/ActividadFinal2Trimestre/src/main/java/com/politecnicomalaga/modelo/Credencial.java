package com.politecnicomalaga.modelo;

public class Credencial {

    private String nombre;
    private String hash;
    private String algoritmo;
    private String salt;

    public Credencial(String nombre, String hash, String algoritmo, String salt) {
        this.nombre = nombre;
        this.hash = hash;
        this.algoritmo = algoritmo;
        this.salt = salt;
    }

    public Credencial(String hash, String algoritmo, String salt) {
        this.hash = hash;
        this.algoritmo = algoritmo;
        this.salt = salt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHash() {
        return hash;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public String getSalt() {
        return salt;
    }

    @Override
    public boolean equals(Object o) {
        Credencial that = (Credencial) o;
        return nombre.equals(that.nombre);
    }
}
