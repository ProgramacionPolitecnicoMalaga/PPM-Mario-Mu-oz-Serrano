public class CompradorPersonaJuridica extends Comprador {

    private String CIF;
    private String razonSocial;

    public CompradorPersonaJuridica(String nombre, String CIF, String razonSocial){
        super(nombre);
        this.CIF=CIF;
        this.razonSocial=razonSocial;
    }

    @Override
    public String toString() {
        return "CompradorPersonaJuridica{" +
                "CIF='" + CIF + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                '}';
    }
}
