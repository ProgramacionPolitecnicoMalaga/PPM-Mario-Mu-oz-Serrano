package com.politecnicomalaga.factory;

import com.politecnicomalaga.modelo.jugador.Jugador;
import com.politecnicomalaga.modelo.villano.Villano;
import com.politecnicomalaga.modelo.obstáculo.Obstáculo;

public interface PersonajeFactory {
    Jugador crearJugador();
    Villano crearVillano();
    Obstáculo crearObstáculo();
}
