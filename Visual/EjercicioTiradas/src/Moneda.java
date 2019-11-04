public class Moneda {
    private int tiradaUnica;
    private int[] tiradaMultiple;
    private int cantidadCaraTiradaMultiple=0;
    private int cantidadCruzTiradaMultiple=0;
    private int cantidadTotalCara;
    private int cantidadTotalCruz;
    private int cantidadTotalTiradas;

    public Moneda(){
        cantidadTotalCara =0;
        cantidadTotalCruz=0;
        cantidadTotalTiradas=0;
    }

    public void tirarMoneda(){
        tiradaUnica = (int) (Math.random() * 2);

        if(tiradaUnica==0){
            cantidadTotalCara++;
        }

        if(tiradaUnica==1){
            cantidadTotalCruz++;
        }

        cantidadTotalTiradas++;
    }

    public void tiradaMultiple(int i){
        tiradaMultiple = new int[i];
        cantidadCaraTiradaMultiple = 0;
        cantidadCruzTiradaMultiple = 0;
        for (int x=0 ; x<tiradaMultiple.length;x++){
            tiradaMultiple[x] = (int) (Math.random() * 2);

            if(tiradaMultiple[x]==0){
                cantidadTotalCara++;
                cantidadCaraTiradaMultiple++;
            }
            if(tiradaMultiple[x]==1){
                cantidadTotalCruz++;
                cantidadCruzTiradaMultiple++;
            }
            cantidadTotalTiradas++;
        }
    }



    public void reiniciar() {
        cantidadTotalCara=0;
        cantidadTotalCruz=0;
        cantidadTotalTiradas=0;
    }

    public int getTiradaUnica(){
      return tiradaUnica;
    }

    public int getCaraTiradaMultiple(){
        return cantidadCaraTiradaMultiple;
    }

    public int getCruzTiradaMultiple(){
        return cantidadCruzTiradaMultiple;
    }

    public int getCantidadTotalCara(){
        return cantidadTotalCara;
    }

    public int getCantidadTotalCruz(){
        return cantidadTotalCruz;
    }

    public int getCantidadTotalTiradas(){
        return cantidadTotalTiradas;
    }
}
