package com.github.Gregorys2s.model.service.login;

public record UsuarioSistema(
        String usuario,
        String senhaHash,
        PerfilUsuario perfil
) {
}