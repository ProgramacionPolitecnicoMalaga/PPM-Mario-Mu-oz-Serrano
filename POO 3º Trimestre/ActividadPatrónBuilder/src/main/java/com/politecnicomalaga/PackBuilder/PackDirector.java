package com.politecnicomalaga.PackBuilder;

import com.politecnicomalaga.Pack.Pack;

public class PackDirector {
    private PackBuilder builder;

    public PackDirector(PackBuilder builder){
        this.builder = builder;
    }

    public Pack entregarPackBasico(){
        return builder.addHabitaciónSimple()
                .addDesayuno()
                .setTipo(TipoPack.PACK_BÁSICO)
                .getResultado();
    }

    public Pack entregarPackRomance(){
        return builder.addHabitacionDoble()
                .addCena()
                .setTipo(TipoPack.PACK_ROMANCE)
                .getResultado();
    }

    public Pack entregarPackFamiliar(){
        return builder.addHabitacionDoble()
                .addACamaAdicional()
                .addDesayuno()
                .addAlmuerzo()
                .addCena()
                .addParqueAtracciones()
                .addActividadesInfantiles()
                .addCinePlaya()
                .setTipo(TipoPack.PACK_FAMILIAR)
                .getResultado();
    }

    public Pack entregarPackPadresRelajados(){
        return builder.addHabitacionDoble()
                .addACamaAdicional()
                .addDesayuno()
                .addAlmuerzo()
                .addCena()
                .addActividadesInfantiles()
                .addCursoKiteSurf()
                .addCinePlaya()
                .setTipo(TipoPack.PACK_PADRES_RELAJADOS)
                .getResultado();
    }

    public Pack entregarPackDeluxe(){
        return builder.addHabitacionSuite()
                .addDesayuno()
                .addAlmuerzo()
                .addCena()
                .addCursoKiteSurf()
                .addCinePlaya()
                .setTipo(TipoPack.PACK_DELUXE)
                .getResultado();
    }
    public Pack entregarPackDeluxeFamiliar(){
        return builder.addHabitacionSuite()
                .addACamaAdicional()
                .addDesayuno()
                .addAlmuerzo()
                .addCena()
                .addParqueAtracciones()
                .addCursoKiteSurf()
                .addActividadesInfantiles()
                .addCinePlaya()
                .setTipo(TipoPack.PACK_DELUXE_FAMILIAR)
                .getResultado();
    }
}
