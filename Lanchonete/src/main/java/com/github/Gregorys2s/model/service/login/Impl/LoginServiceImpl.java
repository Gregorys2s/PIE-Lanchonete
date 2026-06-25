package com.github.Gregorys2s.model.service.login.Impl;

import com.github.Gregorys2s.model.service.login.LoginService;
import com.github.Gregorys2s.model.service.login.PerfilUsuario;
import com.github.Gregorys2s.model.service.login.UsuarioLogado;
import com.github.Gregorys2s.model.service.login.UsuarioSistema;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Optional;

public record LoginServiceImpl() implements LoginService {

    private static final Map<String, UsuarioSistema> USUARIOS = Map.of(
            "atendente",
            criarUsuario("atendente", "atendente123", PerfilUsuario.ATENDENTE),

            "gerente",
            criarUsuario("gerente", "gerente123", PerfilUsuario.GERENTE)
    );

    @Override
    public boolean autenticar(String usuario, String senha) {
        return autenticarUsuario(usuario, senha).isPresent();
    }

    @Override
    public Optional<UsuarioLogado> autenticarUsuario(String usuario, String senha) {
        if (usuario == null || senha == null) {
            return Optional.empty();
        }

        String usuarioNormalizado = usuario.trim().toLowerCase();

        UsuarioSistema usuarioSistema = USUARIOS.get(usuarioNormalizado);

        if (usuarioSistema == null) {
            return Optional.empty();
        }

        String senhaInformadaHash = gerarHash(senha);

        if (!senhaInformadaHash.equals(usuarioSistema.senhaHash())) {
            return Optional.empty();
        }

        return Optional.of(
                new UsuarioLogado(
                        usuarioSistema.usuario(),
                        usuarioSistema.perfil()
                )
        );
    }

    private static UsuarioSistema criarUsuario(
            String usuario,
            String senha,
            PerfilUsuario perfil
    ) {
        return new UsuarioSistema(
                usuario,
                gerarHash(senha),
                perfil
        );
    }

    private static String gerarHash(String texto) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(texto.getBytes(StandardCharsets.UTF_8));

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