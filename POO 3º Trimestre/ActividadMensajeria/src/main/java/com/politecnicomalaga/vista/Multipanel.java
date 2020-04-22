package com.politecnicomalaga.vista;

public interface Multipanel {

    int VISTA_LOGIN = 1;
    int VISTA_LECTURA = 2;
    int VISTA_ENVIO = 3;

    void notificarCambio(int vista);
}
