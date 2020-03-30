package com.politecnicomalaga.algoritmos;
import com.politecnicomalaga.controlador.ControladorCredenciales;

public class EncriptadorFactory {

    public static Encriptador obtenerEncriptador(String tipo) {
        Encriptador encriptador = null;
        switch (tipo) {
            case ControladorCredenciales.ALGORITMO_SHA512:
                encriptador = new SHA512();
                break;
            case ControladorCredenciales.ALGORITMO_BCRYPT:
                encriptador = new Bcrypt();
                break;
        }
        return encriptador;
    }
}
