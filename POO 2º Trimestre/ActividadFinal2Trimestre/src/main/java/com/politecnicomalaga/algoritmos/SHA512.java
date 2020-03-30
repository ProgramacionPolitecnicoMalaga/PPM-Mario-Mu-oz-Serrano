package com.politecnicomalaga.algoritmos;
import com.politecnicomalaga.controlador.ControladorCredenciales;
import com.politecnicomalaga.modelo.Credencial;
import org.apache.commons.codec.binary.Hex;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SHA512 implements Encriptador{
    private MessageDigest messageDigest;

    public SHA512() {
        try {
            messageDigest = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String getSalt(){
        SecureRandom secureRandom = null;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
            byte[] salt = new byte[16];
            secureRandom.nextBytes(salt);
            return Hex.encodeHexString(salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "Salt!";
        }
    }

    public String getSaltedPasswordHash(String password, String salt) {
        if (messageDigest == null)
            try {
                throw new NoSuchAlgorithmException("No existe el algoritmo de hash");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        messageDigest.update(salt.getBytes());
        byte[] bytes = messageDigest.digest(password.getBytes());
        return new String(Hex.encodeHex(bytes));
    }

    public boolean verificarSaltedPassword(String password, String salt, String passwordHash) {
        String nuevoHash = null;
        nuevoHash = getSaltedPasswordHash(password, salt);
        return nuevoHash.equals(passwordHash);
    }

    @Override
    public Credencial crearContraseñaEncriptada(String password) {
        String salt = getSalt();
        return new Credencial(getSaltedPasswordHash(password, salt), ControladorCredenciales.ALGORITMO_SHA512, salt);
    }

    @Override
    public boolean comprobarContraseñaEncriptada(String password, Credencial credencial) {
        return verificarSaltedPassword(password, credencial.getSalt(), credencial.getHash());
    }
}
