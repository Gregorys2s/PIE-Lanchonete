package com.github.Gregorys2s.model.service.login;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class LoginService {

    private static final String USUARIO_PADRAO = "admin";

    // senha: admin123
    private static final String SENHA_HASH_PADRAO =
            "240be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9";

    public boolean autenticar(String usuario, String senha) {

        if (usuario == null || senha == null) {
            return false;
        }

        return usuario.equals(USUARIO_PADRAO)
                && gerarHash(senha).equals(SENHA_HASH_PADRAO);
    }

    private String gerarHash(String texto) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash =
                    digest.digest(texto.getBytes(StandardCharsets.UTF_8));

            StringBuilder hex = new StringBuilder();

            for (byte b : hash) {
                hex.append(String.format("%02x", b));
            }

            return hex.toString();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar hash da senha.", e);
        }
    }
}