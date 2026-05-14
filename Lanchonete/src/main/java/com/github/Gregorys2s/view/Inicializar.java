import com.github.Gregorys2s.config.AppConfig;
import com.github.Gregorys2s.controller.IngredientesController;
import com.github.Gregorys2s.service.IngredientesService;
import com.github.Gregorys2s.view.IngredientePanel;

import javax.swing.*;

public static <Inicializar> void main(String[] args) {
    Inicializar Inicializar = AppConfig.configSistema();

    IngredientesService service = new IngredientesService();
    IngredientesController controller = new IngredientesController(service);

    SwingUtilities.invokeLater(() -> {
        IngredientePanel tela = new IngredientePanel(controller);
        tela.setVisible(true);
    });
}
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
