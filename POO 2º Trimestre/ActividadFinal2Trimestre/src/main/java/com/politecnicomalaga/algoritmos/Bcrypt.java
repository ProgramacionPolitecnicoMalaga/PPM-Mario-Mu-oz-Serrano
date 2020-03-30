package com.politecnicomalaga.algoritmos;
import com.politecnicomalaga.controlador.ControladorCredenciales;
import com.politecnicomalaga.modelo.Credencial;
import org.mindrot.jbcrypt.BCrypt;

public class Bcrypt implements Encriptador{

    public String getSalt() {
        return BCrypt.gensalt(12);
    }
    public String getSaltedPasswordHash(String password, String salt){
        return BCrypt.hashpw(password, salt);
    }

    public boolean verificarSaltedPassword(String password, String passwordHash) {
        return BCrypt.checkpw(password, passwordHash);
    }

    @Override
    public Credencial crearContraseñaEncriptada(String password) {
        String salt = getSalt();
        return new Credencial(getSaltedPasswordHash(password, salt), ControladorCredenciales.ALGORITMO_BCRYPT, salt);
    }

    @Override
    public boolean comprobarContraseñaEncriptada(String password, Credencial credencial) {
        return verificarSaltedPassword(password, credencial.getHash());
    }
}
