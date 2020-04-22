package com.politecnicomalaga.PackBuilder;

import com.politecnicomalaga.Pack.Pack;

public class PackBuilder {

    private Pack pack;

    public PackBuilder(){
        pack = new Pack();
    }

    public PackBuilder setTipo(TipoPack tipo){
        pack.setTipo(tipo);
        return this;
    }

    public PackBuilder addDesayuno(){
        pack.setDesayuno();
        return this;
    }

    public PackBuilder addAlmuerzo(){
        pack.setAlmuerzo();
        return this;
    }

    public PackBuilder addCena(){
        pack.setCena();
        return this;
    }

    public PackBuilder addHabitaciónSimple(){
        pack.setHabitaciónSimple();
        return this;
    }

    public PackBuilder addHabitacionDoble() {
        pack.setHabitacionDoble();
        return this;
    }

    public PackBuilder addHabitacionSuite(){
        pack.setHabitacionSuite();
        return this;
    }

    public PackBuilder addACamaAdicional(){
        pack.setCamaAdicional();
        return this;
    }

    public PackBuilder addParqueAtracciones(){
        pack.setParqueAtracciones();
        return this;
    }

    public PackBuilder addCursoKiteSurf(){
        pack.setCursoKiteSurf();
        return this;
    }

    public PackBuilder addActividadesInfantiles() {
        pack.setActividadesInfantiles();
        return this;
    }

    public PackBuilder addCinePlaya() {
        pack.setCinePlaya();
        return this;
    }

    public Pack getResultado(){
        return pack;
    }
}
