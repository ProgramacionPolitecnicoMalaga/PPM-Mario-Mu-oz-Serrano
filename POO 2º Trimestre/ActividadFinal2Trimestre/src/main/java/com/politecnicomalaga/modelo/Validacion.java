package com.politecnicomalaga.modelo;

public class Validacion {

    private Credencial credencial;
    private String contraseña;
    private boolean validado;

    public Validacion(Credencial credencial, String contraseña, boolean validado) {
        this.credencial = credencial;
        this.contraseña = contraseña;
        this.validado = validado;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public String getContraseña() {
        return contraseña;
    }

    public boolean isValidado() {
        return validado;
    }
}
