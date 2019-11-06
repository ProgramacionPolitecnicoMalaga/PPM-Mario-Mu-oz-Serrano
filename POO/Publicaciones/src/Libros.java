public class Libros extends Publicacion {

    public Libros(int codigo, String titulo, int anoPublicacion) {
        super(codigo, titulo, anoPublicacion);
    }

    public String toString(){
        return super.toString() + "Tipo de publicación: Libro\n";
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
