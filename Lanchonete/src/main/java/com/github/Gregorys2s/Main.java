package com.github.Gregorys2s;

import com.github.Gregorys2s.entity.Pagamento;

import com.github.Gregorys2s.config.AppConfig;
import com.github.Gregorys2s.view.Inicializar;

public class Main {
    public static void main(String[] args) {

        Inicializar init = AppConfig.configSistema();
        init.inicializarSistema();

    Pagamento pagamento = new Pagamento();


    }

}