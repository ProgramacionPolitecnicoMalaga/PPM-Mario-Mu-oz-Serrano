package com.politecnicomalaga;

public class AccionSensor {
    public final static int ACCION_REPOSICION = 1;
    public final static int ACCION_REVISION = 2;
    public final static int ACCION_INNECESARIA = 3;

    public final static int DEMANDA_BAJA = 4;
    public final static int DEMANDA_MEDIA = 5;
    public final static int DEMANDA_ALTA = 6;

    private int nivelDemanda;
    private MatrizSensores matrizSensores;

    public AccionSensor(MatrizSensores matrizSensores) {
        this.matrizSensores = matrizSensores;
    }

    public void setNivelDemanda(int nivelDemanda) {
        this.nivelDemanda = nivelDemanda;
    }

    public int evaluar(int numeroSensor) {
        try {
            int estadoSensor = matrizSensores.getEstadoSensor(numeroSensor);

            if (nivelDemanda == DEMANDA_BAJA) {
                switch (estadoSensor) {
                    case Sensor.ESTADO_VACIO:
                    case Sensor.ESTADO_CASI_VACIO:
                        return ACCION_REPOSICION;
                    default:
                        return ACCION_INNECESARIA;
                }
            } else if (nivelDemanda == DEMANDA_MEDIA) {
                switch (estadoSensor) {
                    case Sensor.ESTADO_VACIO:
                    case Sensor.ESTADO_CASI_VACIO:
                    case Sensor.ESTADO_MITAD:
                        return ACCION_REPOSICION;
                    default:
                        return ACCION_INNECESARIA;
                }
            } else if (nivelDemanda == DEMANDA_ALTA) {
                switch (estadoSensor) {
                    case Sensor.ESTADO_VACIO:
                    case Sensor.ESTADO_CASI_VACIO:
                    case Sensor.ESTADO_MITAD:
                    case Sensor.ESTADO_CASI_LLENO:
                        return ACCION_REPOSICION;
                    default:
                        return ACCION_INNECESARIA;
                }
            }

        } catch (IllegalStateException e) {
            // El sensor no se ha iniciado (y se generó una excepción)
            return ACCION_REVISION;
        }
        // Cualquier otro caso no especificado
        return ACCION_REVISION;
    }
}