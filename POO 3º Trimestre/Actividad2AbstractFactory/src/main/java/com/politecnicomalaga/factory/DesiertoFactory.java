package com.politecnicomalaga.factory;

import com.politecnicomalaga.modelo.jugador.Jugador;
import com.politecnicomalaga.modelo.jugador.Patton;
import com.politecnicomalaga.modelo.villano.Rommel;
import com.politecnicomalaga.modelo.villano.Villano;
import com.politecnicomalaga.modelo.obstáculo.Tanque;
import com.politecnicomalaga.modelo.obstáculo.Obstáculo;

public class DesiertoFactory implements PersonajeFactory{
    public Jugador crearJugador() {
        return new Patton();
    }

    public Villano crearVillano() {
        return new Rommel();
    }

    public Obstáculo crearObstáculo() {
        return new Tanque();
    }
}
