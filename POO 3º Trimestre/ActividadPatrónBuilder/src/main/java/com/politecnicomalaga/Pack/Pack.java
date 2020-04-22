package com.politecnicomalaga.Pack;

import com.politecnicomalaga.PackBuilder.TipoPack;

public class Pack {
    private TipoPack tipo = null;
    private boolean desayuno = false;
    private boolean almuerzo = false;
    private boolean cena = false;
    private boolean habitaciónSimple = false;
    private boolean habitacionDoble = false;
    private boolean habitacionSuite = false;
    private boolean camaAdicional = false;
    private boolean parqueAtracciones = false;
    private boolean cursoKiteSurf = false;
    private boolean actividadesInfantiles = false;
    private boolean cinePlaya = false;

    public void setTipo(TipoPack tipo) {
        this.tipo = tipo;
    }

    public void setDesayuno() {
        desayuno = true;
    }

    public void setAlmuerzo() {
        almuerzo = true;
    }

    public void setCena() {
        cena = true;
    }

    public void setHabitaciónSimple() {
        habitaciónSimple = true;
    }

    public void setHabitacionDoble() {
        habitacionDoble = true;
    }

    public void setHabitacionSuite() {
        habitacionSuite = true;
    }

    public void setCamaAdicional() {
        camaAdicional = true;
    }

    public void setParqueAtracciones() {
        parqueAtracciones = true;
    }

    public void setCursoKiteSurf() {
        cursoKiteSurf = true;
    }

    public void setActividadesInfantiles() {
        actividadesInfantiles = true;
    }

    public void setCinePlaya() {
        cinePlaya = true;
    }

    @Override
    public String toString() {
        String descripción = tipo + "\n";
        descripción += (desayuno) ? "- incluye desayuno\n" : "";
        descripción += (almuerzo) ? "- incluye almuerzo\n" : "";
        descripción += (cena) ? "- incluye cena\n" : "";
        descripción += (habitaciónSimple) ? "- incluye habitación simple\n" : "";
        descripción += (habitacionDoble) ? "- incluye habitación doble\n" : "";
        descripción += (habitacionSuite) ? "- incluye habitación suite\n" : "";
        descripción += (camaAdicional) ? "- incluye cama adicional\n" : "";
        descripción += (parqueAtracciones) ? "- incluye parque de atracciones\n" : "";
        descripción += (cursoKiteSurf) ? "- incluye curso kite surf\n" : "";
        descripción += (actividadesInfantiles) ? "- incluye actividades infantiles\n" : "";
        descripción += (cinePlaya) ? "- incluye cine playa" : "";
        return descripción;
    }
}