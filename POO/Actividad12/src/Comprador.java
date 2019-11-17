public class Comprador {

    private String nombre;
    private double precioCompra;
    private String fechaCompra;

    public Comprador(String nombre){
        this.nombre=nombre;
    }

    public void setPrecioCompra(double precioCompra){
        this.precioCompra=precioCompra;
    }

    public void setFechaCompra(String fechaCompra){
        this.fechaCompra=fechaCompra;
    }

    public double getPrecioCompra(){
        return precioCompra;
    }

    public String getFechaCompra(){
        return fechaCompra;
    }

    @Override
    public String toString() {
        return "Comprador{" +
                "nombre='" + nombre + '\'' +
                ", precioCompra=" + precioCompra +
                ", fechaCompra='" + fechaCompra + '\'' +
                '}';
    }
}
