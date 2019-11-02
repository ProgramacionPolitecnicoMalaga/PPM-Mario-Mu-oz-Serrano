public class MejoresProductos implements SelectorDeMejoresProductos {

    public MejoresProductos(){

    }

    @Override
    public LoteDeProductos elegirMejoresProductos(LoteDeProductos lote) {
        MejoresProductos mejoresProductos = new MejoresProductos();
        LoteDeProductos mejoresValorados= new LoteDeProductos(3);
        mejoresValorados.getListaProductos()[0]=mejoresProductos.MejorValorado(lote);
        mejoresValorados.getListaProductos()[1]=mejoresProductos.MejorPrecio(lote);
        mejoresValorados.getListaProductos()[2]=mejoresProductos.mejorRelacionCalidadPrecio(lote);
        return mejoresValorados;
    }

    public Producto mejorRelacionCalidadPrecio(LoteDeProductos lote) {
        int posicion=0;
        double mejorRelacion = -1;
        for (int i=0;i<lote.getListaProductos().length;i++){
            if (mejorRelacion <= lote.getListaProductos()[i].getValoracion()/lote.getListaProductos()[i].getPrecio()){
                mejorRelacion = lote.getListaProductos()[i].getValoracion()/lote.getListaProductos()[i].getPrecio();
                posicion = i;
            }
        }
        return lote.getListaProductos()[posicion];
    }

    public Producto MejorValorado(LoteDeProductos lote){
        int mejorPuntuacion=0;
        int posicion=0;
        for (int i=0;i<lote.getListaProductos().length;i++){
            if (lote.getListaProductos()[i].getValoracion()>mejorPuntuacion){
                mejorPuntuacion=lote.getListaProductos()[i].getValoracion();
                posicion=i;
            }
        }
        return lote.getListaProductos()[posicion];
    }

    public Producto MejorPrecio(LoteDeProductos lote){
        double mejorPrecio=Double.MAX_VALUE;
        int posicion=0;
        for (int i=0;i<lote.getListaProductos().length;i++){
            if (lote.getListaProductos()[i].getPrecio()<mejorPrecio){
                mejorPrecio=lote.getListaProductos()[i].getPrecio();
                posicion=i;
            }
        }
        return lote.getListaProductos()[posicion];
    }

}
