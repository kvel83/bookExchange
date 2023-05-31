package com.example.bookExchange.util;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class KeyGenerator {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Genera una clave segura de 512 bits
        SecureRandom secureRandom = new SecureRandom();
        byte[] keyBytes = new byte[64];
        secureRandom.nextBytes(keyBytes);

        // Codifica la clave en Base64
        String base64Key = Base64.getEncoder().encodeToString(keyBytes);
        System.out.println("Nueva clave en Base64: " + base64Key);
    }
}
