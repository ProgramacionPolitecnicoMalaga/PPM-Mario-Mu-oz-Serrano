import java.util.Objects;

public class Issue {

    private int idIncidencia;
    private String descripcion;
    private String sistemaAfectado;


    public Issue(int idIncidencia, String descripcion, String sistemaAfectado) {
        this.idIncidencia = idIncidencia;
        this.descripcion = descripcion;
        this.sistemaAfectado = sistemaAfectado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIncidencia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return idIncidencia == issue.idIncidencia &&
                Objects.equals(descripcion, issue.descripcion) &&
                Objects.equals(sistemaAfectado, issue.sistemaAfectado);
    }

    @Override
    public String toString() {
        return "Issue{" +
                "idIncidencia=" + idIncidencia +
                ", descripcion='" + descripcion + '\'' +
                ", sistemaAfectado='" + sistemaAfectado + '\'' +
                '}';
    }
}

