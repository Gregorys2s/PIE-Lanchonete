package com.github.Gregorys2s;

import com.github.Gregorys2s.config.AppConfig;
import com.github.Gregorys2s.controller.IngredientesController; // import adicinado (Yuji)
import com.github.Gregorys2s.service.IngredientesService; // import adicinado (Yuji)
import com.github.Gregorys2s.view.IngredientePanel; // import adicinado (Yuji)
import com.github.Gregorys2s.view.Inicializar;
import javax.swing.SwingUtilities;

public class    Main {
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {

        Inicializar init = AppConfig.configSistema();
        init.inicializarSistema();

        IngredientesService service = new IngredientesService();
        IngredientesController controller = new IngredientesController(service);

        SwingUtilities.invokeLater(() -> {
            IngredientePanel tela = new IngredientePanel(controller);

            // Garante que a tela só fique visível APÓS tudo ser construído internamente
            tela.setVisible(true);
        });
    }
}