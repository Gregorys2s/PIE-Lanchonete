package com.github.Gregorys2s;

import com.github.Gregorys2s.config.AppConfig;
import com.github.Gregorys2s.view.inicializacao.MenuInicial;
import com.github.Gregorys2s.view.login.LoginView;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    private static final AtomicReference<AppConfig> configRef =
            new AtomicReference<>();

    private static final AtomicReference<Throwable> erroConfig =
            new AtomicReference<>();

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Carrega o sistema em segundo plano ENQUANTO o login está aberto
        Thread preload = new Thread(() -> {
            try {
                AppConfig config = new AppConfig();
                configRef.set(config);
            } catch (Throwable e) {
                erroConfig.set(e);
                e.printStackTrace();
            }
        });

        preload.setName("preload-app-config");
        preload.start();

        SwingUtilities.invokeLater(() -> {

            LoginView loginView = new LoginView(() -> {

                if (erroConfig.get() != null) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Erro ao carregar o sistema:\n" +
                                    erroConfig.get().getMessage(),
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                AppConfig config = configRef.get();

                if (config == null) {
                    JDialog carregando = criarDialogCarregando();

                    SwingWorker<AppConfig, Void> worker =
                            new SwingWorker<>() {
                                @Override
                                protected AppConfig doInBackground()
                                        throws Exception {

                                    preload.join();

                                    if (erroConfig.get() != null) {
                                        throw new RuntimeException(
                                                erroConfig.get()
                                        );
                                    }

                                    return configRef.get();
                                }

                                @Override
                                protected void done() {
                                    carregando.dispose();

                                    try {
                                        abrirSistema(get());
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(
                                                null,
                                                "Erro ao abrir sistema:\n" +
                                                        e.getMessage(),
                                                "Erro",
                                                JOptionPane.ERROR_MESSAGE
                                        );
                                    }
                                }
                            };

                    worker.execute();
                    carregando.setVisible(true);

                } else {
                    abrirSistema(config);
                }
            });

            loginView.setVisible(true);
        });
    }

    private static void abrirSistema(AppConfig config) {

        MenuInicial menu = new MenuInicial(
                config.getCardapioController(),
                config.getPedidosController(),
                config.getIngredientesController(),
                config.getRelatorioController(),
                config.getCaixaController(),
                config.getRelatoriosSemanalesController()
        );

        menu.setVisible(true);
    }

    private static JDialog criarDialogCarregando() {

        JDialog dialog = new JDialog();

        dialog.setTitle("Carregando");
        dialog.setModal(true);
        dialog.setSize(300, 120);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);

        JLabel label =
                new JLabel("Carregando sistema, aguarde...");

        label.setHorizontalAlignment(SwingConstants.CENTER);

        dialog.add(label);

        return dialog;
    }
}