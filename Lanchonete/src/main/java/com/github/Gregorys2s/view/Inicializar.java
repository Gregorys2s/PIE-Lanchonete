import com.github.Gregorys2s.config.AppConfig;
import com.github.Gregorys2s.controller.CaixaController;
import com.github.Gregorys2s.controller.IngredientesController;
import com.github.Gregorys2s.service.IngredientesService;
import com.github.Gregorys2s.view.DespesasView;
import com.github.Gregorys2s.view.IngredientePanel;
import com.github.Gregorys2s.view.IngredientesView;
import com.github.Gregorys2s.view.MenuPrincipal;
import com.github.Gregorys2s.view.Panel.pedidosView;
import com.github.Gregorys2s.view.cardapio.CardapioView;

import javax.swing.*;

import java.util.Scanner;

public class Inicializar extends JFrame {
    private final CardapioView cardapioView;
    private final PedidosView pedidosView;
    private final CaixaController caixa;
    private final DespesasView despesasView;
    private final IngredientesView ingredientes;

    public Inicializar(CaixaController caixa, CardapioView cardapioView,PedidosView pedidosView, DespesasView despesasView,IngredientesView ingredientes) {
        this.caixa = caixa;
        this.cardapioView = cardapioView;
        this.pedidosView = pedidosView;
        this.despesasView = despesasView;
        this.ingredientes = ingredientes;
    }

    public void inicializarSistema() {
        SwingUtilities.invokeLater(() -> {

            MenuPrincipal menu = new MenuPrincipal();

            menu.getBotaoCaixa().addActionListener(e -> caixa.setVisible(true));
            menu.getBotaoCardapio().addActionListener(e -> cardapioView.setVisible(true));
            menu.getBotaoPedidos().addActionListener(e -> pedidosView.setVisible(true));
            menu.getBotaoDespesas().addActionListener(e -> despesasView.setVisible(true));
            menu.getBotaoIngredientes().addActionListener(e -> ingredientes.setVisible(true));

            menu.getBotaoSair().addActionListener(e -> System.exit(0));
            menu.setVisible(true);
        });
    }
}
