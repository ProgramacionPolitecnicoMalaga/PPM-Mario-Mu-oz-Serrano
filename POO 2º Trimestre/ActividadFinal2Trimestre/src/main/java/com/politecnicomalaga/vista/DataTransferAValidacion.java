package com.politecnicomalaga.vista;
import com.politecnicomalaga.controlador.ControladorCredenciales;
import com.politecnicomalaga.modelo.Credencial;
import com.politecnicomalaga.modelo.Validacion;

public class DataTransferAValidacion {

    public static Validacion transformar(DataTransfer datos){
        ControladorCredenciales controlador = (ControladorCredenciales) datos.get("controlador");
        String nombre = (String) datos.get("nombre");
        String contraseña = (String) datos.get("contraseña");
        Credencial credencial = controlador.getCredencialPorNombre(nombre);
        return new Validacion(credencial, contraseña, controlador.comprobarCredenciales(nombre, contraseña));
    }
}