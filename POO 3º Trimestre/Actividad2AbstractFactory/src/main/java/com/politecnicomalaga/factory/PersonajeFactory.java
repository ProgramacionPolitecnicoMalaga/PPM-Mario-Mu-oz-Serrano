package com.politecnicomalaga.factory;

import com.politecnicomalaga.modelo.jugador.Jugador;
import com.politecnicomalaga.modelo.villano.Villano;
import com.politecnicomalaga.modelo.obstáculo.Obstáculo;

public interface PersonajeFactory {
    public Jugador crearJugador();
    public Villano crearVillano();
    public Obstáculo crearObstáculo();
}
