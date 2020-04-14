package com.politecnicomalaga.vista;

import com.politecnicomalaga.factory.DesiertoFactory;
import com.politecnicomalaga.factory.EspacioFactory;
import com.politecnicomalaga.factory.PersonajeFactory;
import com.politecnicomalaga.factory.SelvaFactory;

import java.util.Scanner;

public class SelectorJuego {

    private Scanner lectorTeclado;

    private final static int SELVA = 1;
    private final static int DESIERTO = 2;
    private final static int ESPACIO = 3;

    public SelectorJuego() {
        lectorTeclado = new Scanner(System.in).useDelimiter("\n");
    }

    public int mostrarOpciones() {
        System.out.println("\nPor favor, elige un escenario:\n" +
                "1. Selva.\n" +
                "2. Desierto.\n" +
                "3. Espacio.\n" +
                "Opción: ");
        return lectorTeclado.nextInt();
    }

    public PersonajeFactory inicializarEscenario() {
        PersonajeFactory personajeFactory = null;
        int opcion = mostrarOpciones();
            switch (opcion) {
                case SELVA:
                    personajeFactory = new SelvaFactory();
                    break;
                case DESIERTO:
                    personajeFactory = new DesiertoFactory();
                    break;
                case ESPACIO:
                    personajeFactory = new EspacioFactory();
                    break;
            }
        return personajeFactory;
    }
}
