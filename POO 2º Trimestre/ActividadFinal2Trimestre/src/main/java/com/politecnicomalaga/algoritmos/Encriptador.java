package com.politecnicomalaga.algoritmos;
import com.politecnicomalaga.modelo.Credencial;

public interface Encriptador {

    Credencial crearContraseñaEncriptada(String password);
    boolean comprobarContraseñaEncriptada(String password, Credencial credencial);
}
