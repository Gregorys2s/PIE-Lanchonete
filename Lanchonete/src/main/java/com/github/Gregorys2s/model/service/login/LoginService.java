package com.github.Gregorys2s.model.service.login;

import java.util.Optional;

public interface LoginService {

    boolean autenticar(String usuario, String senha);

    Optional<UsuarioLogado> autenticarUsuario(String usuario, String senha);
}