package com.github.Gregorys2s.model.service.login;

public record UsuarioLogado(
        String usuario,
        PerfilUsuario perfil
) {

    public String getNomeExibicao() {
        return perfil == PerfilUsuario.GERENTE
                ? "Gerente"
                : "Atendente";
    }
}