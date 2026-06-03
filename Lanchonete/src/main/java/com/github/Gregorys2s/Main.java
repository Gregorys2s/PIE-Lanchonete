package com.github.Gregorys2s;

import com.github.Gregorys2s.config.AppConfig;
import com.github.Gregorys2s.view.inicializacao.MenuInicial;
import com.github.Gregorys2s.view.inicializacao.MenuPrincipal;


public class Main {
    public static void main(String[] args) {

        AppConfig config = new AppConfig();
        // 2. Run the UI on the Event Dispatch Thread (Swing standard)
        java.awt.EventQueue.invokeLater(() -> {
            try {
                java.awt.EventQueue.invokeLater(() -> {
                    new MenuInicial(config.getCardapioController()).setVisible(true);
                });

            } catch (Exception e) {//fazer a coletanea de erros depois
                e.printStackTrace();
            }
        });



    }

    }