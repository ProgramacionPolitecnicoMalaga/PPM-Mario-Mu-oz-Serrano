package com.politecnicomalaga.modelo;

import java.util.Random;
import java.util.TimerTask;

public abstract class SensorTimerTask extends TimerTask {

    private Random aleatorio;

    public SensorTimerTask(){
        aleatorio = new Random();
    }

    public abstract void nuevaLectura();

    @Override
    public void run() {
            nuevaLectura();
    }
}