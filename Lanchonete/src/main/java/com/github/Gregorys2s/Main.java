package com.github.Gregorys2s; // Verifique se o pacote está correto conforme seu projeto

import com.github.Gregorys2s.config.AppConfig;
import com.github.Gregorys2s.controller.IngredientesController;
import com.github.Gregorys2s.service.IngredientesService;
import com.github.Gregorys2s.view.IngredientePanel;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Inicializar init = AppConfig.configSistema();

        IngredientesService service = new IngredientesService();
        IngredientesController controller = new IngredientesController(service);

        SwingUtilities.invokeLater(() -> {
            IngredientePanel tela = new IngredientePanel(controller);
            tela.setVisible(true);
        });
    }
}