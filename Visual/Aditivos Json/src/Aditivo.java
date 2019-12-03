public class Aditivo {

    private String peligrosidad;
    private String name;
    private String comentario;

    public Aditivo(String peligrosidad, String nombre, String comentario) {
        this.peligrosidad = peligrosidad;
        this.name = nombre;
        this.comentario = comentario;
    }

    public String getPeligrosidad() {
        return peligrosidad;
    }

    public void setPeligrosidad(String peligrosidad) {
        this.peligrosidad = peligrosidad;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Aditivo{" +
                "peligrosidad='" + peligrosidad + '\'' +
                ", nombre='" + name + '\'' +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
