package com.politecnicomalaga.factory;

import com.politecnicomalaga.modelo.jugador.Indiana;
import com.politecnicomalaga.modelo.jugador.Jugador;
import com.politecnicomalaga.modelo.obstáculo.CarceleroTurco;
import com.politecnicomalaga.modelo.villano.Molaram;
import com.politecnicomalaga.modelo.villano.Villano;
import com.politecnicomalaga.modelo.obstáculo.Obstáculo;

public class SelvaFactory implements PersonajeFactory{
    public Jugador crearJugador() {
        return new Indiana();
    }

    public Villano crearVillano() {
        return new Molaram();
    }

    public Obstáculo crearObstáculo() {
        return new CarceleroTurco();
    }
}
