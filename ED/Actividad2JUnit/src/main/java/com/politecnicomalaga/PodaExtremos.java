package com.politecnicomalaga;

import java.util.List;

public class PodaExtremos {

    public int podarMasProximo (int numero, List<Integer> listaNumeros) {
        int posicionMenorDiferencia = -1;
        int menorDiferencia = Integer.MAX_VALUE;
        for (int i = 0; i < listaNumeros.size(); i++) {
            int diferenciaActual = numero - listaNumeros.get(i);
            diferenciaActual = Math.abs(diferenciaActual);
            if (menorDiferencia > diferenciaActual ||
                    menorDiferencia == diferenciaActual &&
                            listaNumeros.get(posicionMenorDiferencia) > listaNumeros.get(i)) {
                menorDiferencia = diferenciaActual;
                posicionMenorDiferencia = i;
            }
        }
        return listaNumeros.remove(posicionMenorDiferencia);
    }

        public int podarMasLejano(int numero, List<Integer> listaNumeros) {
            int posicionMayorDiferencia = -1;
            int mayorDiferencia = Integer.MIN_VALUE;
            for (int i = 0; i < listaNumeros.size(); i++) {
                int diferenciaActual = numero - listaNumeros.get(i);
                diferenciaActual = Math.abs(diferenciaActual);
                if (mayorDiferencia < diferenciaActual ||
                        (mayorDiferencia == diferenciaActual &&
                                listaNumeros.get(posicionMayorDiferencia) > listaNumeros.get(i))) {
                    mayorDiferencia = diferenciaActual;
                    posicionMayorDiferencia = i;
                }
            }
            return listaNumeros.remove(posicionMayorDiferencia);
        }
    }


