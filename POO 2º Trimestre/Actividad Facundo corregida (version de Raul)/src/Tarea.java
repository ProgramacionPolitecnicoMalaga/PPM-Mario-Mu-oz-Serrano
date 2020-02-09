import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Tarea {
    private Categoria categoria;
    private String descripcion;
    private LocalDate fechaLimite;

    public Tarea(String descripcion, LocalDate fechaLimite, Categoria categoria) {
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.categoria=categoria;
    }

    @Override
    public String toString() {
        return "Fecha: " + new SimpleDateFormat("dd-MM-yyyy").format(fechaLimite) + " | " + "Descripcion: "+ descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
