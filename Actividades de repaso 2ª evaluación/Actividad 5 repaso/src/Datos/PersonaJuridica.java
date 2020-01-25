package Datos;

public class PersonaJuridica extends Comprador {

    private String CIF;
    private String razonSocial;

    public PersonaJuridica(String nombre, String CIF, String razonSocial){
        super(nombre);
        this.CIF=CIF;
        this.razonSocial=razonSocial;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCIF: " + CIF +
                "\nRazón social: " + razonSocial;
    }
}