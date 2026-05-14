package com.github.Gregorys2s;

import com.github.Gregorys2s.config.AppConfig;
import com.github.Gregorys2s.view.Inicializar;
import com.github.Gregorys2s.view.Panel.MenuPrincipal;

import javax.swing.*;

public class    Main {
    public static void main(String[] args) {

        Inicializar init = AppConfig.configSistema();
        //init.inicializarSistema();
        SwingUtilities.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });

    }

}