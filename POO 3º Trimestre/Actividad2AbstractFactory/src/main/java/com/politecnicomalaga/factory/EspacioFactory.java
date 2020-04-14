package com.politecnicomalaga.factory;

import com.politecnicomalaga.modelo.jugador.Jugador;
import com.politecnicomalaga.modelo.jugador.USSEnterprise;
import com.politecnicomalaga.modelo.obstáculo.NaveKlingon;
import com.politecnicomalaga.modelo.villano.Khan;
import com.politecnicomalaga.modelo.villano.Villano;
import com.politecnicomalaga.modelo.obstáculo.Obstáculo;

public class EspacioFactory implements PersonajeFactory{
    public Jugador crearJugador() {
        return new USSEnterprise();
    }

    public Villano crearVillano() {
        return new Khan();
    }

    public Obstáculo crearObstáculo() {
        return new NaveKlingon();
    }
}
