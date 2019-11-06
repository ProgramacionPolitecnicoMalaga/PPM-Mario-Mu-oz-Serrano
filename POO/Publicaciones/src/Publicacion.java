public class Publicacion implements Prestable{
    public int codigo;
    public String titulo;
    public int anoPublicacion;
    public boolean prestado=false;

    public Publicacion(int codigo, String titulo, int anoPublicacion){
        this.codigo=codigo;
        this.titulo=titulo;
        this.anoPublicacion=anoPublicacion;
    }

    public String toString(){
        return "\n=======================================\n"
                + "Codigo: " + codigo + "\nTítulo: " + titulo + "\nAño de publicación: " + anoPublicacion + "\nPrestado: " + estaPrestado() + "\n";
    }


    public int getAnoPublicacion(){
        return anoPublicacion;
    }

    public int getCodigo(){
        return codigo;
    }

    @Override
    public void prestar(boolean condicion) {
        prestado=condicion;
    }

    @Override
    public void devolver(boolean condicion) {
        prestado=!condicion;
    }

    @Override
    public String estaPrestado() {
        String estaPrestado = "";

        if (prestado){
            estaPrestado = " Sí";
        }

        else {
            estaPrestado = " No";
        }
        return estaPrestado;
    }
}
