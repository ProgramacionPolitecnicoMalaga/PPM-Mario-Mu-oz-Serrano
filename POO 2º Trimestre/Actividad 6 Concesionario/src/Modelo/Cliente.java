package Modelo;

import java.util.Objects;

public class Cliente {
    private String nombre, apellidos, NIF, cuentaBancaria;

    public Cliente(String nombre, String apellidos, String NIF, String cuentaBancaria) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.NIF = NIF;
        this.cuentaBancaria = cuentaBancaria;
    }

    @Override
    public boolean equals(Object o) {
        Cliente cliente = (Cliente) o;
        return Objects.equals(NIF, cliente.NIF);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NIF);
    }

    public String getNIF() {
        return NIF;
    }
}
