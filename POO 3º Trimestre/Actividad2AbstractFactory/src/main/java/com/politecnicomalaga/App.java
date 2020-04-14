package com.politecnicomalaga;

import com.politecnicomalaga.factory.PersonajeFactory;
import com.politecnicomalaga.modelo.jugador.Jugador;
import com.politecnicomalaga.modelo.obstáculo.Obstáculo;
import com.politecnicomalaga.modelo.villano.Villano;
import com.politecnicomalaga.vista.SelectorJuego;

public class App {
    public static void main(String[] args) {
        SelectorJuego selectorJuego = new SelectorJuego();
        PersonajeFactory personajeFactory = selectorJuego.inicializarEscenario();

        Jugador jugador = personajeFactory.crearJugador();
        Villano villano = personajeFactory.crearVillano();
        Obstáculo obstáculo = personajeFactory.crearObstáculo();

        System.out.println("Jugador: " + jugador.getNombre());
        System.out.println("Villano: " + villano.getNombre());
        System.out.println("Obstáculo: " + obstáculo.getNombre());
    }
}
