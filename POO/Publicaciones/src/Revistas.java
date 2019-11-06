public class Revistas extends Publicacion{

    public int numeroEjemplar;

    public Revistas(int codigo, String titulo, int anoPublicacion, int numeroEjemplar) {
        super(codigo, titulo, anoPublicacion);
        this.numeroEjemplar=numeroEjemplar;
    }

    public String toString(){
        return super.toString() + "Tipo de publicación: Revista\n"
                                + "Numero de ejemplar: " + numeroEjemplar + "\n";
    }

    @Override
    public int getAnoPublicacion() {
        return super.getAnoPublicacion();
    }

    @Override
    public int getCodigo() {
        return super.getCodigo();
    }

}
