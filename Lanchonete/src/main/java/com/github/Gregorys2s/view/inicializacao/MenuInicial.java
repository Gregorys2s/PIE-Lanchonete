package com.github.Gregorys2s.view.inicializacao;

import com.github.Gregorys2s.controller.caixa.CaixaController;
import com.github.Gregorys2s.controller.caixa.DTO.AbrirCaixaRequest;
import com.github.Gregorys2s.controller.caixa.DTO.CaixaResponse;
import com.github.Gregorys2s.controller.caixa.DTO.MovimentoCaixaRequest;
import com.github.Gregorys2s.controller.caixa.DTO.MovimentoCaixaResponse;
import com.github.Gregorys2s.controller.cardapio.Implementacoes.CardapioController;
import com.github.Gregorys2s.controller.ingredientes.DTO.IngredientesDTO;
import com.github.Gregorys2s.controller.ingredientes.Implementacoes.IngredientesController;
import com.github.Gregorys2s.controller.pagamento.PagamentoController;
import com.github.Gregorys2s.controller.pagamento.dto.PagamentoDto;
import com.github.Gregorys2s.controller.pedidos.DTO.PedidosDTO;
import com.github.Gregorys2s.controller.pedidos.DTO.PedidosMasVendidosDTO;
import com.github.Gregorys2s.controller.pedidos.Implementacoes.PedidosController;
import com.github.Gregorys2s.controller.relatorios.Implementacoes.RelatorioController;
import com.github.Gregorys2s.controller.relatoriosSemanal.DTO.RelatoriosSemanalesDTO;
import com.github.Gregorys2s.controller.relatoriosSemanal.Implementacoes.RelatoriosSemanalesController;
import com.github.Gregorys2s.model.entity.Cardapio;
import com.github.Gregorys2s.model.entity.ItemPedidos;
import com.github.Gregorys2s.model.entity.Pedidos;
import com.github.Gregorys2s.model.entity.RelatorioDiario;
import com.github.Gregorys2s.util.ImagemUtil;
import com.github.Gregorys2s.view.Criar.WrapLayout;
import com.github.Gregorys2s.view.pedidos.CardItem;
import com.github.Gregorys2s.view.pedidos.CardPedido;
import com.github.Gregorys2s.view.tema.TemaSistema;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

/**
 *
 * @author Gregory
 */
public class MenuInicial extends JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuInicial.class.getName());
    private CardapioController cardapioController;
    private PedidosController pedidosController;
    private IngredientesController ingredientesController;
    private RelatoriosSemanalesController relatorioSemanalcontroller;
    private CaixaController caixaController;
    private Map<Integer, CardPedido> pedidosCard = new HashMap<>();
    private RelatorioController relatorioController;
    private PagamentoController pagamentoController;
    private static Integer idPedidoText = 0;
    private BigDecimal adicionais = BigDecimal.ZERO;
    private int opciontbEstoque = 0;
    private JPanel containerPedidos = new JPanel();
    private JButton bottonCaixa;
    private JButton botaoTema;
    private JPanel telaCaixa;
    private JLabel caixaStatusLabel;
    private JLabel caixaSaldoLabel;
    private JLabel caixaEntradasLabel;
    private JLabel caixaDespesasLabel;
    private JTextField caixaEntradaField;
    private JTextField caixaReceitaField;
    private JTextField caixaSaidaField;
    private DefaultTableModel caixaMovimentosModel;
    private JTable caixaMovimentosTable;
    private boolean modoSemanal = false;

    private String tipoEntrega = "LOCAL";

    private PedidosDTO pedidoSelecionado = null;
    private JPanel painelPedidoSelecionado = null;

    private static final Color corPadraoPedido = UIManager.getColor("Panel.background");
    private static final Color corHouverPedido = new Color(230, 230, 230);
    private static final Color corSelecionadoPedido = new Color(255, 204, 102); // destaque

    /**
     * Creates new form MenuInicial
     */
    public MenuInicial(CardapioController cardapioController,PedidosController pedidosController,IngredientesController ingredientesController,RelatorioController relatorioController,CaixaController caixaController,RelatoriosSemanalesController relatorioSemanalcontroller,PagamentoController pagamentoController) {
        this.cardapioController = cardapioController;
        this.pedidosController = pedidosController;
        this.ingredientesController = ingredientesController;
        this.relatorioController = relatorioController;
        this.caixaController = caixaController;
        this.relatorioSemanalcontroller = relatorioSemanalcontroller;
        this.pagamentoController = pagamentoController;

        initComponents();

        containerPedidos.setLayout(new BoxLayout(containerPedidos, BoxLayout.Y_AXIS));
        jScrollPane3.setViewportView(containerPedidos);

        carregarTbPedidosEmProcesso();
        textprocurar.setText("Procurar...");
        telaProdutos.setLayout(new WrapLayout(FlowLayout.LEFT, 2, 2));
        scrollPanelProdutos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        telaPedidoAtual.setLayout(new BoxLayout(telaPedidoAtual, BoxLayout.Y_AXIS));
        PedidoText.setText("Pedido " + idPedidoText);
        configurarFiltro();

        organizarTelaPedidos();
        organizarTelaPedidosEmProcesso();
        ajustarDimensoesGerais();

        criarTelaCaixa();
        configurarMenuComTema();
        aplicarTemaNaTela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new JPanel();
        BottonPedidos = new JButton();
        jLabel1 = new JLabel();
        bottonEstoque = new JButton();
        bottonRelatorio = new JButton();
        pedidosEmProcesso = new JButton();
        panelConteudo = new JPanel();
        telaPedidosEmProcesso = new JPanel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        panelRedondo1 = new PanelRedondo();
        todostext = new JLabel();
        quantidadePedidosText = new JLabel();
        PedidosText = new JLabel();
        panelRedondo3 = new PanelRedondo();
        pendenteText = new JLabel();
        quantidadePedidosPendentesText = new JLabel();
        jLabel8 = new JLabel();
        panelRedondo4 = new PanelRedondo();
        jLabel9 = new JLabel();
        quantidadePedidosPagosText = new JLabel();
        jLabel11 = new JLabel();
        panelRedondo8 = new PanelRedondo();
        jLabel12 = new JLabel();
        quantidadePedidosCanceladosText = new JLabel();
        jLabel14 = new JLabel();
        panelPedidosEmProcessoLista = new PanelRedondo();
        jScrollPane3 = new JScrollPane();
        tbPedidosEmProcesso = new JTable();
        JcomboBoxProdutos = new JComboBox<>();
        panelRedondo5 = new PanelRedondo();
        cancelarPedidoPanel = new PanelRedondo();
        cancelarText = new JLabel();
        pagarPanel = new PanelRedondo();
        pagarText = new JLabel();
        PedidoEmProcessoText = new JLabel();
        jLabel13 = new JLabel();
        totalPedidos = new JLabel();
        jLabel16 = new JLabel();
        subtotalPedido = new JLabel();
        jLabel18 = new JLabel();
        adicionaisPedido = new JLabel();
        telaEstoque = new JPanel();
        bottonadicinarEstoque = new JButton();
        bottonRemoverEstoque = new JButton();
        jScrollPane1 = new JScrollPane();
        tbEstoque = new JTable();
        bottonIngredientes = new JButton();
        bottonCardapio = new JButton();
        telaPedidos = new JPanel();
        panelBebidas = new PanelRedondo();
        imgSha = new JLabel();
        bebidasText = new JLabel();
        quantidadeDeItenBebi = new JLabel();
        panelHamburguer = new PanelRedondo();
        quantidadeDeItenHam = new JLabel();
        hamburguerText = new JLabel();
        imgHambur = new JLabel();
        panelCombos = new PanelRedondo();
        quantidadeDeItenCom = new JLabel();
        combosText = new JLabel();
        imgCombos = new JLabel();
        panelPorcoes = new PanelRedondo();
        quantidadeDeItenporcao = new JLabel();
        PorcoesText = new JLabel();
        imgPorcoes = new JLabel();
        panelAlcoolicas = new PanelRedondo();
        quantidadeDeItenAlcool = new JLabel();
        alcoolicasText = new JLabel();
        imgAlcoolicas = new JLabel();
        MenuBusqueda = new PanelRedondo();
        textprocurar = new JTextField();
        PedidoText = new JLabel();
        scrollPanelProdutos = new JScrollPane();
        telaProdutos = new JPanel();
        SomaDeValores = new PanelRedondo();
        adicionaisTextPago = new JLabel();
        subTotalText = new JLabel();
        jSeparator2 = new JSeparator();
        praViagemPanel = new PanelRedondo();
        btnParaViagem = new JLabel();
        noLocalPanel = new PanelRedondo();
        btnNoLocal = new JLabel();
        RealizarPedidoPanel = new PanelRedondo();
        realizarPedidotext = new JLabel();
        valorTotalText = new JLabel();
        valorTotal = new JLabel();
        valorAdicionais = new JLabel();
        valorSubTotal = new JLabel();
        panelAdicionais = new PanelRedondo();
        adicionaisText = new JLabel();
        jScrollPane2 = new JScrollPane();
        telaPedidoAtual = new JPanel();
        jSeparator1 = new JSeparator();
        TelaRelatorios = new JPanel();
        graficopizza1 = new com.github.Gregorys2s.util.GraficoPizza();
        graficoPizza2 = new com.github.Gregorys2s.util.GraficoPizza();
        panelQuantidadePedidos = new PanelRedondo();
        jLabel2 = new JLabel();
        pedidosLabel = new JLabel();
        buttonDiario = new JButton();
        bottonSemanal = new JButton();
        panelFaturamento1 = new PanelRedondo();
        lucroLabel = new JLabel();
        jLabel6 = new JLabel();
        panelDespesas = new PanelRedondo();
        despesasLabel = new JLabel();
        jLabel3 = new JLabel();
        jLabel20 = new JLabel();
        jLabel21 = new JLabel();
        jComboBoxDias = new JComboBox<>();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(43, 43, 43));

        panelMenu.setBackground(new Color(33, 33, 33));

        BottonPedidos.setBackground(new Color(33, 33, 33));
        BottonPedidos.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        BottonPedidos.setForeground(new Color(153, 153, 153));
        BottonPedidos.setText("Pedidos");
        BottonPedidos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BottonPedidos.setBorderPainted(false);
        BottonPedidos.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        BottonPedidos.setHorizontalAlignment(SwingConstants.LEFT);
        BottonPedidos.setVerifyInputWhenFocusTarget(false);
        BottonPedidos.addActionListener(this::BottonPedidosActionPerformed);

        jLabel1.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new Color(255, 153, 0));
        jLabel1.setText("Lanchonete");

        bottonEstoque.setBackground(new Color(33, 33, 33));
        bottonEstoque.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        bottonEstoque.setForeground(new Color(153, 153, 153));
        bottonEstoque.setText("Estoque");
        bottonEstoque.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bottonEstoque.setBorderPainted(false);
        bottonEstoque.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        bottonEstoque.setHorizontalAlignment(SwingConstants.LEFT);
        bottonEstoque.setVerifyInputWhenFocusTarget(false);
        bottonEstoque.addActionListener(this::bottonEstoqueActionPerformed);

        bottonRelatorio.setBackground(new Color(33, 33, 33));
        bottonRelatorio.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        bottonRelatorio.setForeground(new Color(153, 153, 153));
        bottonRelatorio.setText("Relatorio");
        bottonRelatorio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bottonRelatorio.setBorderPainted(false);
        bottonRelatorio.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        bottonRelatorio.setHorizontalAlignment(SwingConstants.LEFT);
        bottonRelatorio.setVerifyInputWhenFocusTarget(false);
        bottonRelatorio.addActionListener(this::bottonRelatorioActionPerformed);

        pedidosEmProcesso.setBackground(new Color(33, 33, 33));
        pedidosEmProcesso.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        pedidosEmProcesso.setForeground(new Color(153, 153, 153));
        pedidosEmProcesso.setText("Concluir");
        pedidosEmProcesso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pedidosEmProcesso.setBorderPainted(false);
        pedidosEmProcesso.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        pedidosEmProcesso.setHorizontalAlignment(SwingConstants.LEFT);
        pedidosEmProcesso.setVerifyInputWhenFocusTarget(false);
        pedidosEmProcesso.addActionListener(this::pedidosEmProcessoActionPerformed);

        GroupLayout panelMenuLayout = new GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(BottonPedidos, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(bottonEstoque, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottonRelatorio, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pedidosEmProcesso, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BottonPedidos, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottonEstoque, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottonRelatorio, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pedidosEmProcesso, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelConteudo.setLayout(new CardLayout());

        jLabel4.setFont(new Font("Segoe UI", 2, 24)); // NOI18N
        jLabel4.setText("Pedidos");

        jLabel5.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Gerencie e acompanhe todos os pedidos");

        panelRedondo1.setBackground(new Color(0, 204, 204));
        panelRedondo1.setPreferredSize(new Dimension(140, 100));

        todostext.setFont(new Font("Segoe UI", 2, 14)); // NOI18N
        todostext.setText("Todos");

        quantidadePedidosText.setFont(new Font("Segoe UI", 2, 18)); // NOI18N
        quantidadePedidosText.setHorizontalAlignment(SwingConstants.CENTER);
        quantidadePedidosText.setText("N");

        PedidosText.setText("Pedidos");

        GroupLayout panelRedondo1Layout = new GroupLayout(panelRedondo1);
        panelRedondo1.setLayout(panelRedondo1Layout);
        panelRedondo1Layout.setHorizontalGroup(
            panelRedondo1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelRedondo1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(panelRedondo1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(PedidosText)
                    .addComponent(todostext)
                    .addComponent(quantidadePedidosText, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
        panelRedondo1Layout.setVerticalGroup(
            panelRedondo1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(todostext)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantidadePedidosText, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PedidosText)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        panelRedondo3.setBackground(new Color(0, 204, 204));
        panelRedondo3.setPreferredSize(new Dimension(140, 100));

        pendenteText.setFont(new Font("Segoe UI", 2, 14)); // NOI18N
        pendenteText.setText("Pendentes");

        quantidadePedidosPendentesText.setFont(new Font("Segoe UI", 2, 18)); // NOI18N
        quantidadePedidosPendentesText.setHorizontalAlignment(SwingConstants.CENTER);
        quantidadePedidosPendentesText.setText("N");

        jLabel8.setFont(new Font("Segoe UI", 0, 11)); // NOI18N
        jLabel8.setText("aguardando Pagamentos");

        GroupLayout panelRedondo3Layout = new GroupLayout(panelRedondo3);
        panelRedondo3.setLayout(panelRedondo3Layout);
        panelRedondo3Layout.setHorizontalGroup(
            panelRedondo3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelRedondo3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(pendenteText, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRedondo3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(quantidadePedidosPendentesText, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelRedondo3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRedondo3Layout.setVerticalGroup(
            panelRedondo3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pendenteText)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantidadePedidosPendentesText)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        panelRedondo4.setBackground(new Color(0, 204, 204));
        panelRedondo4.setPreferredSize(new Dimension(140, 100));

        jLabel9.setFont(new Font("Segoe UI", 2, 14)); // NOI18N
        jLabel9.setText("Pagos");

        quantidadePedidosPagosText.setFont(new Font("Segoe UI", 2, 18)); // NOI18N
        quantidadePedidosPagosText.setHorizontalAlignment(SwingConstants.CENTER);
        quantidadePedidosPagosText.setText("N");

        jLabel11.setText("Pedidos concluidos");

        GroupLayout panelRedondo4Layout = new GroupLayout(panelRedondo4);
        panelRedondo4.setLayout(panelRedondo4Layout);
        panelRedondo4Layout.setHorizontalGroup(
            panelRedondo4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo4Layout.createSequentialGroup()
                .addGroup(panelRedondo4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelRedondo4Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel9))
                    .addGroup(panelRedondo4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(quantidadePedidosPagosText, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRedondo4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel11)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelRedondo4Layout.setVerticalGroup(
            panelRedondo4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantidadePedidosPagosText)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelRedondo8.setBackground(new Color(0, 204, 204));
        panelRedondo8.setPreferredSize(new Dimension(140, 100));

        jLabel12.setFont(new Font("Segoe UI", 2, 14)); // NOI18N
        jLabel12.setText("Cancelados");

        quantidadePedidosCanceladosText.setFont(new Font("Segoe UI", 2, 18)); // NOI18N
        quantidadePedidosCanceladosText.setHorizontalAlignment(SwingConstants.CENTER);
        quantidadePedidosCanceladosText.setText("N");

        jLabel14.setText("Pedidos cancelados");

        GroupLayout panelRedondo8Layout = new GroupLayout(panelRedondo8);
        panelRedondo8.setLayout(panelRedondo8Layout);
        panelRedondo8Layout.setHorizontalGroup(
            panelRedondo8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo8Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelRedondo8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelRedondo8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(quantidadePedidosCanceladosText, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, panelRedondo8Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(17, 17, 17))
        );
        panelRedondo8Layout.setVerticalGroup(
            panelRedondo8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantidadePedidosCanceladosText)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tbPedidosEmProcesso.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Produto", "Quantidade", "Preço", "Valor"
            }
        ));
        jScrollPane3.setViewportView(tbPedidosEmProcesso);

        JcomboBoxProdutos.setModel(new DefaultComboBoxModel<>(new String[] { "Todos", "Pendentes", "Cancelados", "Pagos" }));
        JcomboBoxProdutos.addActionListener(this::JcomboBoxProdutosActionPerformed);

        GroupLayout panelPedidosEmProcessoListaLayout = new GroupLayout(panelPedidosEmProcessoLista);
        panelPedidosEmProcessoLista.setLayout(panelPedidosEmProcessoListaLayout);
        panelPedidosEmProcessoListaLayout.setHorizontalGroup(
            panelPedidosEmProcessoListaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
            .addGroup(panelPedidosEmProcessoListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JcomboBoxProdutos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPedidosEmProcessoListaLayout.setVerticalGroup(
            panelPedidosEmProcessoListaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelPedidosEmProcessoListaLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(JcomboBoxProdutos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 545, GroupLayout.PREFERRED_SIZE))
        );

        panelRedondo5.setBackground(new Color(51, 204, 255));

        cancelarPedidoPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarTextMouseClicked(evt);
            }
        });

        cancelarText.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        cancelarText.setHorizontalAlignment(SwingConstants.CENTER);
        cancelarText.setText("Cancelar Pedido");
        cancelarText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarTextMouseClicked(evt);
            }
        });

        GroupLayout cancelarPedidoPanelLayout = new GroupLayout(cancelarPedidoPanel);
        cancelarPedidoPanel.setLayout(cancelarPedidoPanelLayout);
        cancelarPedidoPanelLayout.setHorizontalGroup(
            cancelarPedidoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, cancelarPedidoPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelarText)
                .addGap(51, 51, 51))
        );
        cancelarPedidoPanelLayout.setVerticalGroup(
            cancelarPedidoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(cancelarPedidoPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(cancelarText, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        pagarPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pagarTextMouseClicked(evt);
            }
        });

        pagarText.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        pagarText.setHorizontalAlignment(SwingConstants.CENTER);
        pagarText.setText("Pagar");
        pagarText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pagarTextMouseClicked(evt);
            }
        });

        GroupLayout pagarPanelLayout = new GroupLayout(pagarPanel);
        pagarPanel.setLayout(pagarPanelLayout);
        pagarPanelLayout.setHorizontalGroup(
            pagarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, pagarPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pagarText, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        pagarPanelLayout.setVerticalGroup(
            pagarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pagarPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(pagarText, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        PedidoEmProcessoText.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        PedidoEmProcessoText.setText("Pedido #??");

        jLabel13.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        jLabel13.setText("Total");

        totalPedidos.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        totalPedidos.setText("R$-");

        jLabel16.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        jLabel16.setText("Subtotal");

        subtotalPedido.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        subtotalPedido.setText("R$-");

        jLabel18.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        jLabel18.setText("Adicionais");

        adicionaisPedido.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        adicionaisPedido.setText("R$-");

        GroupLayout panelRedondo5Layout = new GroupLayout(panelRedondo5);
        panelRedondo5.setLayout(panelRedondo5Layout);
        panelRedondo5Layout.setHorizontalGroup(
            panelRedondo5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRedondo5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(cancelarPedidoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pagarPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(panelRedondo5Layout.createSequentialGroup()
                .addGroup(panelRedondo5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelRedondo5Layout.createSequentialGroup()
                        .addGroup(panelRedondo5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panelRedondo5Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(PedidoEmProcessoText, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRedondo5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel16))
                            .addGroup(panelRedondo5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(panelRedondo5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(totalPedidos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subtotalPedido, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)))
                    .addGroup(panelRedondo5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18)
                        .addGap(24, 24, 24)
                        .addComponent(adicionaisPedido, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelRedondo5Layout.setVerticalGroup(
            panelRedondo5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelRedondo5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(PedidoEmProcessoText, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRedondo5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(subtotalPedido, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRedondo5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(adicionaisPedido, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(panelRedondo5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalPedidos, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(pagarPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelarPedidoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout telaPedidosEmProcessoLayout = new GroupLayout(telaPedidosEmProcesso);
        telaPedidosEmProcesso.setLayout(telaPedidosEmProcessoLayout);
        telaPedidosEmProcessoLayout.setHorizontalGroup(
            telaPedidosEmProcessoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(telaPedidosEmProcessoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(telaPedidosEmProcessoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(telaPedidosEmProcessoLayout.createSequentialGroup()
                        .addComponent(panelPedidosEmProcessoLista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelRedondo5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(telaPedidosEmProcessoLayout.createSequentialGroup()
                        .addGroup(telaPedidosEmProcessoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addGroup(telaPedidosEmProcessoLayout.createSequentialGroup()
                                .addComponent(panelRedondo1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(panelRedondo3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(panelRedondo4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(panelRedondo8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        telaPedidosEmProcessoLayout.setVerticalGroup(
            telaPedidosEmProcessoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(telaPedidosEmProcessoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(telaPedidosEmProcessoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(telaPedidosEmProcessoLayout.createSequentialGroup()
                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(telaPedidosEmProcessoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(panelRedondo1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRedondo3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelRedondo8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRedondo4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(telaPedidosEmProcessoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(panelPedidosEmProcessoLista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRedondo5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelConteudo.add(telaPedidosEmProcesso, "card4");

        bottonadicinarEstoque.setText("adicionar Item");
        bottonadicinarEstoque.addActionListener(this::bottonadicinarEstoqueActionPerformed);

        bottonRemoverEstoque.setText("remover item");
        bottonRemoverEstoque.addActionListener(this::bottonRemoverEstoqueActionPerformed);

        tbEstoque.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Estoque"
            }
        ));
        jScrollPane1.setViewportView(tbEstoque);

        bottonIngredientes.setText("Ingredientes");
        bottonIngredientes.addActionListener(this::bottonIngredientesActionPerformed);

        bottonCardapio.setText("Cardapio");
        bottonCardapio.addActionListener(this::bottonCardapioActionPerformed);

        GroupLayout telaEstoqueLayout = new GroupLayout(telaEstoque);
        telaEstoque.setLayout(telaEstoqueLayout);
        telaEstoqueLayout.setHorizontalGroup(
            telaEstoqueLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(telaEstoqueLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(bottonCardapio, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bottonIngredientes, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, telaEstoqueLayout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(telaEstoqueLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(telaEstoqueLayout.createSequentialGroup()
                        .addComponent(bottonadicinarEstoque, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(bottonRemoverEstoque, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 774, GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        telaEstoqueLayout.setVerticalGroup(
            telaEstoqueLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(telaEstoqueLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(telaEstoqueLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(bottonIngredientes, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottonCardapio, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(telaEstoqueLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(bottonadicinarEstoque, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottonRemoverEstoque, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        panelConteudo.add(telaEstoque, "card3");

        telaPedidos.setBackground(new Color(43, 43, 43));

        panelBebidas.setBackground(SystemColor.activeCaption);
        panelBebidas.setMaximumSize(new Dimension(166, 122));
        panelBebidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBebidasMouseClicked(evt);
            }
        });

        imgSha.setIcon(ImagemUtil.carregar("/Imagens/Pedidos/Refrigerante.png", 44, 58));

        bebidasText.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        bebidasText.setText("Bebidas");

        quantidadeDeItenBebi.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        quantidadeDeItenBebi.setText("?  itens");

        GroupLayout panelBebidasLayout = new GroupLayout(panelBebidas);
        panelBebidas.setLayout(panelBebidasLayout);
        panelBebidasLayout.setHorizontalGroup(
            panelBebidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelBebidasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBebidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(imgSha)
                    .addComponent(bebidasText)
                    .addComponent(quantidadeDeItenBebi, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBebidasLayout.setVerticalGroup(
            panelBebidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelBebidasLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgSha, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bebidasText, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(quantidadeDeItenBebi)
                .addContainerGap())
        );

        panelHamburguer.setBackground(SystemColor.activeCaption);
        panelHamburguer.setMaximumSize(new Dimension(166, 122));
        panelHamburguer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelHamburguerMouseClicked(evt);
            }
        });

        quantidadeDeItenHam.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        quantidadeDeItenHam.setText("?  itens");

        hamburguerText.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        hamburguerText.setText("Hamburguer");

        imgHambur.setIcon(new ImageIcon(getClass().getResource("/Imagens/Pedidos/hambur.png"))); // NOI18N
        imgHambur.setPreferredSize(new Dimension(47, 47));
        imgHambur.setMaximumSize(new Dimension(47, 47));
        imgHambur.setMinimumSize(new Dimension(47, 47));

        GroupLayout panelHamburguerLayout = new GroupLayout(panelHamburguer);
        panelHamburguer.setLayout(panelHamburguerLayout);
        panelHamburguerLayout.setHorizontalGroup(
            panelHamburguerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelHamburguerLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelHamburguerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, panelHamburguerLayout.createSequentialGroup()
                        .addGroup(panelHamburguerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(imgHambur)
                            .addComponent(quantidadeDeItenHam, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75))
                    .addGroup(GroupLayout.Alignment.TRAILING, panelHamburguerLayout.createSequentialGroup()
                        .addComponent(hamburguerText, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panelHamburguerLayout.setVerticalGroup(
            panelHamburguerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelHamburguerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgHambur, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(hamburguerText, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(quantidadeDeItenHam, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelCombos.setBackground(SystemColor.activeCaption);
        panelCombos.setMaximumSize(new Dimension(166, 122));
        panelCombos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCombosMouseClicked(evt);
            }
        });

        quantidadeDeItenCom.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        quantidadeDeItenCom.setText("?  itens");

        combosText.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        combosText.setText("Combos");

        imgCombos.setIcon(ImagemUtil.carregar("/Imagens/Pedidos/hamburguesaIcone.png", 58, 48));        GroupLayout panelCombosLayout = new GroupLayout(panelCombos);
        panelCombos.setLayout(panelCombosLayout);
        panelCombosLayout.setHorizontalGroup(
            panelCombosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelCombosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCombosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(combosText)
                    .addComponent(imgCombos)
                    .addComponent(quantidadeDeItenCom, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        panelCombosLayout.setVerticalGroup(
            panelCombosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelCombosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgCombos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(combosText, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantidadeDeItenCom)
                .addContainerGap())
        );

        panelPorcoes.setBackground(SystemColor.activeCaption);
        panelPorcoes.setMaximumSize(new Dimension(166, 122));
        panelPorcoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelPorcoesMouseClicked(evt);
            }
        });

        quantidadeDeItenporcao.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        quantidadeDeItenporcao.setText("?  itens");

        PorcoesText.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        PorcoesText.setText("Porções");

        imgPorcoes.setIcon(ImagemUtil.carregar("/Imagens/Pedidos/hambur.png", 56, 52));
        GroupLayout panelPorcoesLayout = new GroupLayout(panelPorcoes);
        panelPorcoes.setLayout(panelPorcoesLayout);
        panelPorcoesLayout.setHorizontalGroup(
            panelPorcoesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelPorcoesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelPorcoesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(imgPorcoes)
                    .addComponent(PorcoesText)
                    .addComponent(quantidadeDeItenporcao, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        panelPorcoesLayout.setVerticalGroup(
            panelPorcoesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelPorcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgPorcoes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PorcoesText, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantidadeDeItenporcao))
        );

        panelAlcoolicas.setBackground(SystemColor.activeCaption);
        panelAlcoolicas.setMaximumSize(new Dimension(166, 122));
        panelAlcoolicas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAlcoolicasMouseClicked(evt);
            }
        });

        quantidadeDeItenAlcool.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        quantidadeDeItenAlcool.setText("?  itens");

        alcoolicasText.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        alcoolicasText.setText("Alcoolicas ");

        imgAlcoolicas.setIcon(ImagemUtil.carregar("/Imagens/Pedidos/Refrigerante.png", 44, 58));
        imgAlcoolicas.setPreferredSize(new Dimension(47, 47));
        imgAlcoolicas.setMaximumSize(new Dimension(47, 47));
        imgAlcoolicas.setMinimumSize(new Dimension(47, 47));

        GroupLayout panelAlcoolicasLayout = new GroupLayout(panelAlcoolicas);
        panelAlcoolicas.setLayout(panelAlcoolicasLayout);
        panelAlcoolicasLayout.setHorizontalGroup(
            panelAlcoolicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelAlcoolicasLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelAlcoolicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(imgAlcoolicas)
                    .addComponent(quantidadeDeItenAlcool, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                    .addComponent(alcoolicasText))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelAlcoolicasLayout.setVerticalGroup(
            panelAlcoolicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelAlcoolicasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgAlcoolicas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alcoolicasText, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantidadeDeItenAlcool))
        );

        MenuBusqueda.setBackground(new Color(51, 51, 51));

        textprocurar.setBackground(new Color(51, 51, 51));
        textprocurar.setFont(new Font("Segoe UI", 2, 18)); // NOI18N
        textprocurar.setForeground(new Color(242, 242, 242));
        textprocurar.setActionCommand("null");
        textprocurar.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textprocurar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textprocurarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textprocurarFocusLost(evt);
            }
        });

        GroupLayout MenuBusquedaLayout = new GroupLayout(MenuBusqueda);
        MenuBusqueda.setLayout(MenuBusquedaLayout);
        MenuBusquedaLayout.setHorizontalGroup(
            MenuBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(MenuBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textprocurar, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        MenuBusquedaLayout.setVerticalGroup(
            MenuBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(MenuBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textprocurar, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PedidoText.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        PedidoText.setForeground(new Color(255, 51, 51));
        PedidoText.setText("Pedido #?");

        scrollPanelProdutos.setBackground(new Color(43, 43, 43));
        scrollPanelProdutos.setBorder(null);

        telaProdutos.setBackground(new Color(43, 43, 43));
        telaProdutos.setLayout(new GridBagLayout());
        scrollPanelProdutos.setViewportView(telaProdutos);

        SomaDeValores.setBackground(new Color(255, 153, 153));

        adicionaisTextPago.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        adicionaisTextPago.setText("Adicionais");

        subTotalText.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        subTotalText.setText("Subtotal");

        jSeparator2.setBackground(new Color(0, 0, 0));
        jSeparator2.setForeground(new Color(0, 0, 0));

        praViagemPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnParaViagemMouseClicked(evt);
            }
        });

        btnParaViagem.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        btnParaViagem.setHorizontalAlignment(SwingConstants.CENTER);
        btnParaViagem.setText("Para Viagem");
        btnParaViagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnParaViagemMouseClicked(evt);
            }
        });

        GroupLayout praViagemPanelLayout = new GroupLayout(praViagemPanel);
        praViagemPanel.setLayout(praViagemPanelLayout);
        praViagemPanelLayout.setHorizontalGroup(
            praViagemPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(praViagemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnParaViagem, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );
        praViagemPanelLayout.setVerticalGroup(
            praViagemPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, praViagemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnParaViagem, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        noLocalPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noLocalPanelMouseClicked(evt);
            }
        });

        btnNoLocal.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        btnNoLocal.setHorizontalAlignment(SwingConstants.CENTER);
        btnNoLocal.setText("No Local");
        btnNoLocal.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnNoLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noLocalPanelMouseClicked(evt);
            }
        });

        GroupLayout noLocalPanelLayout = new GroupLayout(noLocalPanel);
        noLocalPanel.setLayout(noLocalPanelLayout);
        noLocalPanelLayout.setHorizontalGroup(
            noLocalPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(noLocalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNoLocal, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );
        noLocalPanelLayout.setVerticalGroup(
            noLocalPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, noLocalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNoLocal, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNoLocal.getAccessibleContext().setAccessibleDescription("");

        RealizarPedidoPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RealizarPedidoPanelMouseClicked(evt);
            }
        });

        realizarPedidotext.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        realizarPedidotext.setHorizontalAlignment(SwingConstants.CENTER);
        realizarPedidotext.setText("Realizar Pedido");
        realizarPedidotext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RealizarPedidoPanelMouseClicked(evt);
            }
        });

        GroupLayout RealizarPedidoPanelLayout = new GroupLayout(RealizarPedidoPanel);
        RealizarPedidoPanel.setLayout(RealizarPedidoPanelLayout);
        RealizarPedidoPanelLayout.setHorizontalGroup(
            RealizarPedidoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(RealizarPedidoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(realizarPedidotext, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        RealizarPedidoPanelLayout.setVerticalGroup(
            RealizarPedidoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, RealizarPedidoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(realizarPedidotext, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );

        valorTotalText.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        valorTotalText.setText("Total");

        valorTotal.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        valorTotal.setText("R$    0");

        valorAdicionais.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        valorAdicionais.setText("R$    0");

        valorSubTotal.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        valorSubTotal.setText("R$    0");

        GroupLayout SomaDeValoresLayout = new GroupLayout(SomaDeValores);
        SomaDeValores.setLayout(SomaDeValoresLayout);
        SomaDeValoresLayout.setHorizontalGroup(
            SomaDeValoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, GroupLayout.Alignment.TRAILING)
            .addGroup(SomaDeValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SomaDeValoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(RealizarPedidoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.TRAILING, SomaDeValoresLayout.createSequentialGroup()
                        .addGroup(SomaDeValoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(adicionaisTextPago)
                            .addComponent(subTotalText))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(SomaDeValoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(valorSubTotal, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addComponent(valorAdicionais, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addGroup(GroupLayout.Alignment.TRAILING, SomaDeValoresLayout.createSequentialGroup()
                        .addGroup(SomaDeValoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(praViagemPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(valorTotalText))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(SomaDeValoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(valorTotal, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addComponent(noLocalPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        SomaDeValoresLayout.setVerticalGroup(
            SomaDeValoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(SomaDeValoresLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(SomaDeValoresLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(subTotalText)
                    .addComponent(valorSubTotal))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SomaDeValoresLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionaisTextPago)
                    .addComponent(valorAdicionais))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SomaDeValoresLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(valorTotalText)
                    .addComponent(valorTotal))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                .addGroup(SomaDeValoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(praViagemPanel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(noLocalPanel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(RealizarPedidoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        panelAdicionais.setBackground(SystemColor.activeCaption);
        panelAdicionais.setMaximumSize(new Dimension(166, 122));
        panelAdicionais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAdicionaisMouseClicked(evt);
            }
        });

        adicionaisText.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        adicionaisText.setText("  Adicionais");
        adicionaisText.setToolTipText("");
        adicionaisText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAdicionaisMouseClicked(evt);
            }
        });

        GroupLayout panelAdicionaisLayout = new GroupLayout(panelAdicionais);
        panelAdicionais.setLayout(panelAdicionaisLayout);
        panelAdicionaisLayout.setHorizontalGroup(
            panelAdicionaisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(adicionaisText, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        panelAdicionaisLayout.setVerticalGroup(
            panelAdicionaisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelAdicionaisLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(adicionaisText)
                .addGap(23, 23, 23))
        );

        jScrollPane2.setBorder(null);

        telaPedidoAtual.setBackground(new Color(0, 102, 102));

        GroupLayout telaPedidoAtualLayout = new GroupLayout(telaPedidoAtual);
        telaPedidoAtual.setLayout(telaPedidoAtualLayout);
        telaPedidoAtualLayout.setHorizontalGroup(
            telaPedidoAtualLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
        );
        telaPedidoAtualLayout.setVerticalGroup(
            telaPedidoAtualLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(telaPedidoAtual);

        GroupLayout telaPedidosLayout = new GroupLayout(telaPedidos);
        telaPedidos.setLayout(telaPedidosLayout);
        telaPedidosLayout.setHorizontalGroup(
            telaPedidosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(telaPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(telaPedidosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(MenuBusqueda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(telaPedidosLayout.createSequentialGroup()
                        .addGroup(telaPedidosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelAlcoolicas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelHamburguer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(telaPedidosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelPorcoes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBebidas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(telaPedidosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelCombos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelAdicionais, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 514, GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPanelProdutos, GroupLayout.PREFERRED_SIZE, 534, GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(telaPedidosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(telaPedidosLayout.createSequentialGroup()
                        .addComponent(PedidoText, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(SomaDeValores, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        telaPedidosLayout.setVerticalGroup(
            telaPedidosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(telaPedidosLayout.createSequentialGroup()
                .addGroup(telaPedidosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(telaPedidosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(MenuBusqueda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(GroupLayout.Alignment.TRAILING, telaPedidosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PedidoText)
                        .addGap(18, 18, 18)))
                .addGroup(telaPedidosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(telaPedidosLayout.createSequentialGroup()
                        .addGroup(telaPedidosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelBebidas, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelHamburguer, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelCombos, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(telaPedidosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelPorcoes, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelAlcoolicas, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelAdicionais, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(scrollPanelProdutos, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE))
                    .addGroup(telaPedidosLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)
                        .addComponent(SomaDeValores, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        panelConteudo.add(telaPedidos, "card2");

        GroupLayout graficopizza1Layout = new GroupLayout(graficopizza1);
        graficopizza1.setLayout(graficopizza1Layout);
        graficopizza1Layout.setHorizontalGroup(
            graficopizza1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        graficopizza1Layout.setVerticalGroup(
            graficopizza1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        GroupLayout graficoPizza2Layout = new GroupLayout(graficoPizza2);
        graficoPizza2.setLayout(graficoPizza2Layout);
        graficoPizza2Layout.setHorizontalGroup(
            graficoPizza2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        graficoPizza2Layout.setVerticalGroup(
            graficoPizza2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        panelQuantidadePedidos.setBackground(new Color(204, 51, 0));

        jLabel2.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Pedidos");

        pedidosLabel.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        pedidosLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pedidosLabel.setText("N");

        GroupLayout panelQuantidadePedidosLayout = new GroupLayout(panelQuantidadePedidos);
        panelQuantidadePedidos.setLayout(panelQuantidadePedidosLayout);
        panelQuantidadePedidosLayout.setHorizontalGroup(
            panelQuantidadePedidosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelQuantidadePedidosLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelQuantidadePedidosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelQuantidadePedidosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(pedidosLabel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        panelQuantidadePedidosLayout.setVerticalGroup(
            panelQuantidadePedidosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelQuantidadePedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pedidosLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        buttonDiario.setText("Diario");
        buttonDiario.addActionListener(this::buttonDiarioActionPerformed);

        bottonSemanal.setText("Semanal");
        bottonSemanal.addActionListener(this::bottonSemanalActionPerformed);

        panelFaturamento1.setBackground(new Color(0, 153, 255));

        lucroLabel.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        lucroLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lucroLabel.setText("N");

        jLabel6.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel6.setText("Lucro");

        GroupLayout panelFaturamento1Layout = new GroupLayout(panelFaturamento1);
        panelFaturamento1.setLayout(panelFaturamento1Layout);
        panelFaturamento1Layout.setHorizontalGroup(
            panelFaturamento1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelFaturamento1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelFaturamento1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lucroLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFaturamento1Layout.setVerticalGroup(
            panelFaturamento1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelFaturamento1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lucroLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panelDespesas.setBackground(new Color(204, 51, 0));

        despesasLabel.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        despesasLabel.setHorizontalAlignment(SwingConstants.CENTER);
        despesasLabel.setText("N");

        jLabel3.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Despesas");

        GroupLayout panelDespesasLayout = new GroupLayout(panelDespesas);
        panelDespesas.setLayout(panelDespesasLayout);
        panelDespesasLayout.setHorizontalGroup(
            panelDespesasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelDespesasLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(panelDespesasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(despesasLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelDespesasLayout.setVerticalGroup(
            panelDespesasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelDespesasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(despesasLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel20.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setText("Produtos mais Vendidos");

        jLabel21.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setText("Relatorios Financeiros");

        jComboBoxDias.setModel(new DefaultComboBoxModel<>(new String[] { "Item 2", "Item 3", "Item 4" }));
        jComboBoxDias.addActionListener(this::jComboBoxDiasActionPerformed);

        GroupLayout TelaRelatoriosLayout = new GroupLayout(TelaRelatorios);
        TelaRelatorios.setLayout(TelaRelatoriosLayout);
        TelaRelatoriosLayout.setHorizontalGroup(
            TelaRelatoriosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(TelaRelatoriosLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(TelaRelatoriosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(TelaRelatoriosLayout.createSequentialGroup()
                        .addComponent(panelFaturamento1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(panelQuantidadePedidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(panelDespesas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(TelaRelatoriosLayout.createSequentialGroup()
                        .addComponent(buttonDiario, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(bottonSemanal, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(jComboBoxDias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(TelaRelatoriosLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(TelaRelatoriosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(graficopizza1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(53, 53, 53)
                .addGroup(TelaRelatoriosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(graficoPizza2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 67, Short.MAX_VALUE))
        );
        TelaRelatoriosLayout.setVerticalGroup(
            TelaRelatoriosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(TelaRelatoriosLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(TelaRelatoriosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDiario, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottonSemanal, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(TelaRelatoriosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(panelFaturamento1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelQuantidadePedidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDespesas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TelaRelatoriosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TelaRelatoriosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(graficoPizza2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(graficopizza1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(146, 146, 146))
        );

        panelConteudo.add(TelaRelatorios, "card5");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelConteudo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(panelConteudo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BottonPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottonPedidosActionPerformed
        carregarProdutos();
        carregarQuantidadeItens();
        CardLayout cl = (CardLayout) panelConteudo.getLayout();
        cl.show(panelConteudo, "card2");
    }//GEN-LAST:event_BottonPedidosActionPerformed

    private void panelHamburguerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHamburguerMouseClicked
        carregarProdutosCategoria("Lanche");
    }//GEN-LAST:event_panelHamburguerMouseClicked

    private void textprocurarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textprocurarFocusGained
        System.out.println("GANHOU FOCO");
        if ("Procurar...".equals(textprocurar.getText())) {
            textprocurar.setText("");
            textprocurar.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_textprocurarFocusGained

    private void textprocurarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textprocurarFocusLost
        System.out.println("PERDEU FOCO");
        if (textprocurar.getText().trim().isEmpty()) {
            textprocurar.setText("Procurar...");
            textprocurar.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_textprocurarFocusLost

    private void panelCombosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCombosMouseClicked
        carregarProdutosCategoria("Combo");
    }//GEN-LAST:event_panelCombosMouseClicked

    private void panelAlcoolicasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAlcoolicasMouseClicked
        carregarProdutosCategoria("Alcoolicas");
    }//GEN-LAST:event_panelAlcoolicasMouseClicked

    private void panelPorcoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPorcoesMouseClicked
        carregarProdutosCategoria("Porcao");
    }//GEN-LAST:event_panelPorcoesMouseClicked

    private void panelAdicionaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAdicionaisMouseClicked
        String[] opcoes = {"Adicionar", "Remover", "Cancelar"};

        int opcao = JOptionPane.showOptionDialog(
                this,
                "O que deseja fazer com os adicionais?",
                "Adicionais",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );

        if (opcao == 2 || opcao == JOptionPane.CLOSED_OPTION) {
            return;
        }

        if (opcao == 1 && adicionais.compareTo(BigDecimal.ZERO) == 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Não há adicionais para remover.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        String valor = JOptionPane.showInputDialog(
                this,
                "Informe o valor:"
        );

        if (valor == null || valor.isBlank()) {
            return;
        }

        try {

            BigDecimal valorDigitado = new BigDecimal(valor.replace(",", "."));

            if (valorDigitado.compareTo(BigDecimal.ZERO) <= 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "O valor deve ser maior que zero.",
                        "Valor inválido",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if (opcao == 0) { // Adicionar
                adicionais = adicionais.add(valorDigitado);

            } else if (opcao == 1) { // Remover

                adicionais = adicionais.subtract(valorDigitado);

                // Não permite valor negativo
                if (adicionais.compareTo(BigDecimal.ZERO) < 0) {
                    adicionais = BigDecimal.ZERO;
                }
            }

            atualizarValoresPedido();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Valor inválido!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_panelAdicionaisMouseClicked

    private void panelBebidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBebidasMouseClicked
        carregarProdutosCategoria("Bebida");
    }//GEN-LAST:event_panelBebidasMouseClicked

    private void noLocalPanelMouseClicked(java.awt.event.MouseEvent evt) {
        selecionarTipoEntrega("LOCAL");
    }//GEN-LAST:event_noLocalPanelMouseClicked

    private void selecionarTipoEntrega(String tipo) {
        tipoEntrega = tipo;
        atualizarEstiloTipoEntrega();
    }

    private void organizarTelaPedidosEmProcesso() {
        telaPedidosEmProcesso.removeAll();
        telaPedidosEmProcesso.setLayout(new BorderLayout(0, 16));
        telaPedidosEmProcesso.setBorder(new EmptyBorder(18, 18, 18, 18));
        telaPedidosEmProcesso.setBackground(TemaSistema.fundo());

        reconstruirPainelResumoConclusao();

        JPanel topo = new JPanel(new BorderLayout(0, 14));
        topo.setOpaque(false);

        JPanel textosTopo = new JPanel();
        textosTopo.setOpaque(false);
        textosTopo.setLayout(new BoxLayout(textosTopo, BoxLayout.Y_AXIS));

        jLabel4.setText("Pedidos");
        jLabel4.setFont(new Font("Segoe UI", Font.ITALIC, 24));
        jLabel4.setForeground(TemaSistema.texto());

        jLabel5.setText("Gerencie e acompanhe todos os pedidos");
        jLabel5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel5.setForeground(TemaSistema.textoSecundario());

        textosTopo.add(jLabel4);
        textosTopo.add(Box.createVerticalStrut(6));
        textosTopo.add(jLabel5);

        JPanel cards = new JPanel(new GridLayout(1, 4, 14, 0));
        cards.setOpaque(false);
        cards.setPreferredSize(new Dimension(700, 95));

        configurarCardResumo(
                panelRedondo1,
                todostext,
                quantidadePedidosText,
                PedidosText,
                "Todos",
                TemaSistema.info()
        );

        configurarCardResumo(
                panelRedondo3,
                pendenteText,
                quantidadePedidosPendentesText,
                jLabel8,
                "Pendentes",
                TemaSistema.alerta()
        );

        configurarCardResumo(
                panelRedondo4,
                jLabel9,
                quantidadePedidosPagosText,
                jLabel11,
                "Pagos",
                TemaSistema.sucesso()
        );

        configurarCardResumo(
                panelRedondo8,
                jLabel12,
                quantidadePedidosCanceladosText,
                jLabel14,
                "Cancelados",
                TemaSistema.perigo()
        );

        cards.add(panelRedondo1);
        cards.add(panelRedondo3);
        cards.add(panelRedondo4);
        cards.add(panelRedondo8);

        topo.add(textosTopo, BorderLayout.NORTH);
        topo.add(cards, BorderLayout.CENTER);

        panelPedidosEmProcessoLista.removeAll();
        panelPedidosEmProcessoLista.setLayout(new BorderLayout(0, 12));
        panelPedidosEmProcessoLista.setBackground(TemaSistema.card());
        panelPedidosEmProcessoLista.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(TemaSistema.borda()),
                new EmptyBorder(12, 12, 12, 12)
        ));

        JcomboBoxProdutos.setPreferredSize(new Dimension(150, 42));
        JcomboBoxProdutos.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JPanel filtro = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        filtro.setOpaque(false);
        filtro.add(JcomboBoxProdutos);

        jScrollPane3.setBorder(BorderFactory.createLineBorder(TemaSistema.borda()));
        jScrollPane3.getViewport().setBackground(TemaSistema.fundo());

        panelPedidosEmProcessoLista.add(filtro, BorderLayout.NORTH);
        panelPedidosEmProcessoLista.add(jScrollPane3, BorderLayout.CENTER);

        JPanel centro = new JPanel(new BorderLayout(18, 0));
        centro.setOpaque(false);
        centro.add(panelPedidosEmProcessoLista, BorderLayout.CENTER);
        centro.add(panelRedondo5, BorderLayout.EAST);

        telaPedidosEmProcesso.add(topo, BorderLayout.NORTH);
        telaPedidosEmProcesso.add(centro, BorderLayout.CENTER);

        telaPedidosEmProcesso.revalidate();
        telaPedidosEmProcesso.repaint();
    }

    private void configurarCardResumo(
            PanelRedondo panel,
            JLabel titulo,
            JLabel valor,
            JLabel subtitulo,
            String textoTitulo,
            Color corValor
    ) {
        panel.removeAll();
        panel.setLayout(new BorderLayout());
        panel.setBackground(TemaSistema.cardElevado());
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(TemaSistema.borda()),
                new EmptyBorder(10, 10, 10, 10)
        ));

        titulo.setText(textoTitulo);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(TemaSistema.texto());
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 14));

        valor.setHorizontalAlignment(SwingConstants.CENTER);
        valor.setForeground(corValor);
        valor.setFont(new Font("Segoe UI", Font.BOLD, 26));

        subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        subtitulo.setForeground(TemaSistema.textoSecundario());
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        panel.add(titulo, BorderLayout.NORTH);
        panel.add(valor, BorderLayout.CENTER);
        panel.add(subtitulo, BorderLayout.SOUTH);
    }

    private void reconstruirPainelResumoConclusao() {
        panelRedondo5.removeAll();
        panelRedondo5.setLayout(new BorderLayout(0, 16));
        panelRedondo5.setBackground(TemaSistema.card());
        panelRedondo5.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(TemaSistema.borda()),
                new EmptyBorder(18, 18, 18, 18)
        ));

        panelRedondo5.setPreferredSize(new Dimension(330, 420));
        panelRedondo5.setMinimumSize(new Dimension(310, 380));

        PedidoEmProcessoText.setForeground(TemaSistema.texto());
        PedidoEmProcessoText.setFont(new Font("Segoe UI", Font.BOLD, 18));

        JPanel valores = new JPanel();
        valores.setOpaque(false);
        valores.setLayout(new BoxLayout(valores, BoxLayout.Y_AXIS));

        valores.add(criarLinhaResumoConclusao(jLabel16, subtotalPedido, false));
        valores.add(Box.createVerticalStrut(12));
        valores.add(criarLinhaResumoConclusao(jLabel18, adicionaisPedido, false));
        valores.add(Box.createVerticalStrut(22));
        valores.add(criarLinhaResumoConclusao(jLabel13, totalPedidos, true));

        configurarBotaoPainel(pagarPanel, pagarText, TemaSistema.primaria(), "Pagar");
        configurarBotaoPainel(cancelarPedidoPanel, cancelarText, TemaSistema.perigo(), "Cancelar Pedido");

        JPanel botoes = new JPanel();
        botoes.setOpaque(false);
        botoes.setLayout(new BoxLayout(botoes, BoxLayout.Y_AXIS));
        botoes.add(pagarPanel);
        botoes.add(Box.createVerticalStrut(12));
        botoes.add(cancelarPedidoPanel);

        panelRedondo5.add(PedidoEmProcessoText, BorderLayout.NORTH);
        panelRedondo5.add(valores, BorderLayout.CENTER);
        panelRedondo5.add(botoes, BorderLayout.SOUTH);
    }

    private JPanel criarLinhaResumoConclusao(JLabel label, JLabel valor, boolean destaque) {
        JPanel linha = new JPanel(new BorderLayout());
        linha.setOpaque(false);

        label.setFont(new Font("Segoe UI", Font.BOLD, destaque ? 18 : 16));
        label.setForeground(destaque ? TemaSistema.texto() : TemaSistema.textoSecundario());

        valor.setFont(new Font("Segoe UI", Font.BOLD, destaque ? 18 : 16));
        valor.setForeground(destaque ? TemaSistema.primaria() : TemaSistema.texto());

        linha.add(label, BorderLayout.WEST);
        linha.add(valor, BorderLayout.EAST);

        return linha;
    }

    private void configurarBotaoPainel(
            PanelRedondo panel,
            JLabel label,
            Color cor,
            String texto
    ) {
        panel.removeAll();
        panel.setLayout(new BorderLayout());
        panel.setBackground(cor);
        panel.setPreferredSize(new Dimension(1, 54));
        panel.setMinimumSize(new Dimension(1, 50));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 54));
        panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        label.setText(texto);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 15));
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        panel.add(label, BorderLayout.CENTER);
    }

    private void RealizarPedidoPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RealizarPedidoPanelMouseClicked
        realizarPedido();
    }//GEN-LAST:event_RealizarPedidoPanelMouseClicked

    private void bottonEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottonEstoqueActionPerformed
        CardLayout cl = (CardLayout) panelConteudo.getLayout();
        cl.show(panelConteudo, "card3");
        carregarTbIngredientes();

    }//GEN-LAST:event_bottonEstoqueActionPerformed

    private void bottonCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottonCardapioActionPerformed
        carregarTbCardapio();
        opciontbEstoque = 0;
    }//GEN-LAST:event_bottonCardapioActionPerformed

    private void bottonIngredientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottonIngredientesActionPerformed
        carregarTbIngredientes();
        opciontbEstoque = 1;
    }//GEN-LAST:event_bottonIngredientesActionPerformed

    private void bottonRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottonRelatorioActionPerformed

        CardLayout cl = (CardLayout) panelConteudo.getLayout();
        cl.show(panelConteudo, "card5");

        carregarDiasRelatorio();

        atualizarValoresRelatorioDiario();

        graficoPizza2.revalidate();
        graficoPizza2.repaint();

    }//GEN-LAST:event_bottonRelatorioActionPerformed


    private void carregarDiasRelatorio() {
        jComboBoxDias.removeAllItems();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate hoje = LocalDate.now();

        for (int i = 0; i < 5; i++) {
            LocalDate data = hoje.minusDays(i);
            jComboBoxDias.addItem(data.format(formatter));

        }
    }

    private void carregarSemanasRelatorio() {

        jComboBoxDias.removeAllItems();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        List<RelatoriosSemanalesDTO> relatorios =
                relatorioSemanalcontroller.listarTodos();

        for (RelatoriosSemanalesDTO relatorio : relatorios) {

            jComboBoxDias.addItem(
                    relatorio.getSemanaInicio().format(formatter)
            );

        }
    }

    private void bottonSemanalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottonSemanalActionPerformed
        modoSemanal = true;

        // Carrega as semanas no ComboBox
        carregarSemanasRelatorio();

        // Se não houver nenhuma semana cadastrada, encerra
        if (jComboBoxDias.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Não existe nenhum relatório semanal cadastrado.",
                    "Relatório não encontrado",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        // Atualiza os dados da tela
        atualizarValoresRelatorioSemanal();

        // Atualiza o gráfico dos produtos mais vendidos
        graficoPizza2.limpar();

        List<PedidosMasVendidosDTO> top3 = pedidosController.buscarTop3MaisVendidosSemanal();

        for (PedidosMasVendidosDTO item : top3) {
            graficoPizza2.adicionarItem(item.getNome(), item.getQuantidade());
        }

    }//GEN-LAST:event_bottonSemanalActionPerformed

    private void buttonDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDiarioActionPerformed

        modoSemanal = false;
        carregarDiasRelatorio();

        atualizarValoresRelatorioDiario();

    }//GEN-LAST:event_buttonDiarioActionPerformed

    private void atualizarValoresRelatorioDiario() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (jComboBoxDias.getSelectedItem() == null) {
            return;
        }

        LocalDate data = LocalDate.parse(
                jComboBoxDias.getSelectedItem().toString(),
                formatter
        );

        Optional<RelatorioDiario> optional = relatorioController.buscarPorData(data);

        graficopizza1.limpar();
        graficoPizza2.limpar();

        if (optional.isPresent()) {

            RelatorioDiario relatorioDiario = optional.get();

            BigDecimal lucro = relatorioDiario.getLucroTotal() != null
                    ? relatorioDiario.getLucroTotal() : BigDecimal.ZERO;

            BigDecimal despesas = relatorioDiario.getDespesas() != null
                    ? relatorioDiario.getDespesas() : BigDecimal.ZERO;

            Integer quantidadePedidos = relatorioDiario.getQuantidadePedidos() != null
                    ? relatorioDiario.getQuantidadePedidos() : 0;

            logger.info("Relatorio diario [" + data + "] -> lucro=" + lucro
                    + " despesas=" + despesas + " pedidos=" + quantidadePedidos);

            lucroLabel.setText("R$ " + lucro);
            pedidosLabel.setText(String.valueOf(quantidadePedidos));
            despesasLabel.setText("R$ " + despesas);

            graficopizza1.adicionarItem("Despesas", despesas.intValue());
            graficopizza1.adicionarItem("Lucro", lucro.intValue());

            // só busca/exibe top3 quando existe relatório para a data
            List<PedidosMasVendidosDTO> top3 = pedidosController.buscarTop3MaisVendidos();

            for (PedidosMasVendidosDTO item : top3) {
                graficoPizza2.adicionarItem(item.getNome(), item.getQuantidade());
            }

        } else {

            lucroLabel.setText("R$ 0");
            pedidosLabel.setText("0");
            despesasLabel.setText("R$ 0");

            JOptionPane.showMessageDialog(
                    this,
                    "Não existe relatório para esta data.",
                    "Relatório não encontrado",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

        graficopizza1.revalidate();
        graficopizza1.repaint();
        graficoPizza2.revalidate();
        graficoPizza2.repaint();
    }

    private void atualizarValoresRelatorioSemanal() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (jComboBoxDias.getSelectedItem() == null) {
            return;
        }

        LocalDate semanaInicio = LocalDate.parse(
                jComboBoxDias.getSelectedItem().toString(),
                formatter
        );

        RelatoriosSemanalesDTO relatorio = relatorioSemanalcontroller.buscarPorSemana(semanaInicio);

        graficopizza1.limpar();
        graficoPizza2.limpar();

        if (relatorio != null) {

            BigDecimal lucro = relatorio.getLucroTotal() != null
                    ? relatorio.getLucroTotal() : BigDecimal.ZERO;

            BigDecimal despesas = relatorio.getDespesasTotal() != null
                    ? relatorio.getDespesasTotal() : BigDecimal.ZERO;

            Integer totalPedidos = relatorio.getTotalPedidos() != null
                    ? relatorio.getTotalPedidos() : 0;

            logger.info("Relatorio semanal [" + semanaInicio + "] -> lucro=" + lucro
                    + " despesas=" + despesas + " pedidos=" + totalPedidos);

            lucroLabel.setText("R$ " + lucro);
            pedidosLabel.setText(String.valueOf(totalPedidos));
            despesasLabel.setText("R$ " + despesas);

            graficopizza1.adicionarItem("Despesas", despesas.intValue());
            graficopizza1.adicionarItem("Lucro", lucro.intValue());

            // só busca/exibe top3 quando existe relatório para a semana
            List<PedidosMasVendidosDTO> top3 = pedidosController.buscarTop3MaisVendidosSemanal();

            for (PedidosMasVendidosDTO item : top3) {
                graficoPizza2.adicionarItem(item.getNome(), item.getQuantidade());
            }

        } else {

            lucroLabel.setText("R$ 0");
            pedidosLabel.setText("0");
            despesasLabel.setText("R$ 0");

            JOptionPane.showMessageDialog(
                    this,
                    "Não existe relatório para esta semana.",
                    "Relatório não encontrado",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

        graficopizza1.revalidate();
        graficopizza1.repaint();
        graficoPizza2.revalidate();
        graficoPizza2.repaint();
    }

    private void bottonadicinarEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottonadicinarEstoqueActionPerformed
    if (opciontbEstoque == 0) {
        abrirDialogNovoProdutoCardapio();
    } else {
        abrirDialogNovoIngrediente();
    }
}//GEN-LAST:event_bottonadicinarEstoqueActionPerformed

    private void abrirDialogNovoProdutoCardapio() {
        JTextField nomeField = criarCampoDialogEstoque();
        JTextField precoField = criarCampoDialogEstoque();

        JComboBox<String> tipoBox = new JComboBox<>(new String[]{
                "Lanche",
                "Bebida",
                "Combo",
                "Porcao",
                "Alcoolica"
        });

        tipoBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tipoBox.setBackground(TemaSistema.campo());
        tipoBox.setForeground(TemaSistema.texto());

        JPanel painel = criarPainelDialogEstoque();

        painel.add(criarLabelDialogEstoque("Nome do produto"));
        painel.add(nomeField);

        painel.add(criarLabelDialogEstoque("Tipo"));
        painel.add(tipoBox);

        painel.add(criarLabelDialogEstoque("Preço"));
        painel.add(precoField);

        int opcao = JOptionPane.showConfirmDialog(
                this,
                painel,
                "Novo produto",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (opcao != JOptionPane.OK_OPTION) {
            return;
        }

        try {
            String nome = nomeField.getText().trim();
            String tipo = String.valueOf(tipoBox.getSelectedItem());
            BigDecimal preco = converterTextoParaBigDecimal(precoField.getText());

            if (nome.isBlank()) {
                throw new IllegalArgumentException("Informe o nome do produto.");
            }

            if (preco.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("O preço precisa ser maior que zero.");
            }

            cardapioController.adicionarItem(nome, tipo, preco);

            carregarTbCardapio();
            carregarQuantidadeItens();
            carregarProdutos();

            JOptionPane.showMessageDialog(
                    this,
                    "Produto cadastrado com sucesso.",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Não foi possível cadastrar o produto: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void abrirDialogNovoIngrediente() {
        JTextField nomeField = criarCampoDialogEstoque();
        JTextField estoqueField = criarCampoDialogEstoque();

        JPanel painel = criarPainelDialogEstoque();

        painel.add(criarLabelDialogEstoque("Nome do ingrediente"));
        painel.add(nomeField);

        painel.add(criarLabelDialogEstoque("Quantidade em estoque"));
        painel.add(estoqueField);

        int opcao = JOptionPane.showConfirmDialog(
                this,
                painel,
                "Novo ingrediente",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (opcao != JOptionPane.OK_OPTION) {
            return;
        }

        try {
            String nome = nomeField.getText().trim();
            int estoque = converterTextoParaInteiro(estoqueField.getText());

            if (nome.isBlank()) {
                throw new IllegalArgumentException("Informe o nome do ingrediente.");
            }

            if (estoque < 0) {
                throw new IllegalArgumentException("O estoque não pode ser negativo.");
            }

            ingredientesController.cadastrarIngrediente(
                    new IngredientesDTO(null, nome, estoque)
            );

            carregarTbIngredientes();

            JOptionPane.showMessageDialog(
                    this,
                    "Ingrediente cadastrado com sucesso.",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Não foi possível cadastrar o ingrediente: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private JPanel criarPainelDialogEstoque() {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBackground(TemaSistema.card());
        painel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        painel.setPreferredSize(new Dimension(320, 230));
        return painel;
    }

    private JLabel criarLabelDialogEstoque(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setForeground(TemaSistema.texto());
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setBorder(BorderFactory.createEmptyBorder(8, 0, 4, 0));
        return label;
    }

    private JTextField criarCampoDialogEstoque() {
        JTextField campo = new JTextField();
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campo.setForeground(TemaSistema.texto());
        campo.setBackground(TemaSistema.campo());
        campo.setCaretColor(TemaSistema.texto());
        campo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        campo.setPreferredSize(new Dimension(280, 40));
        campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(TemaSistema.borda()),
                BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        campo.setAlignmentX(Component.LEFT_ALIGNMENT);
        return campo;
    }

    private BigDecimal converterTextoParaBigDecimal(String texto) {
        if (texto == null || texto.trim().isBlank()) {
            throw new IllegalArgumentException("Informe o preço.");
        }

        String valorNormalizado = texto
                .trim()
                .replace("R$", "")
                .replace(" ", "");

        if (valorNormalizado.contains(",")) {
            valorNormalizado = valorNormalizado
                    .replace(".", "")
                    .replace(",", ".");
        }

        try {
            return new BigDecimal(valorNormalizado);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Preço inválido. Exemplo correto: 12,50");
        }
    }

    private int converterTextoParaInteiro(String texto) {
        if (texto == null || texto.trim().isBlank()) {
            throw new IllegalArgumentException("Informe a quantidade em estoque.");
        }

        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Quantidade inválida. Use apenas números inteiros.");
        }
    }

    private void bottonRemoverEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottonRemoverEstoqueActionPerformed
        int linha = tbEstoque.getSelectedRow();
        
        if (linha == -1) {
        JOptionPane.showMessageDialog(
                this,
                "Não foi selecionada nenhuma linha",
                "Escolha",
                JOptionPane.INFORMATION_MESSAGE
        );
    }else{
            if (opciontbEstoque == 1){
                int id = Integer.parseInt(tbEstoque.getValueAt(linha, 0).toString());
                ingredientesController.excluirIngrediente(id);
                carregarTbIngredientes();
            }else if (opciontbEstoque == 0) {
                int id = Integer.parseInt(tbEstoque.getValueAt(linha, 0).toString());
                Cardapio item = cardapioController.produtoSelecionadoId(id);
                cardapioController.removerItem(item);
                carregarTbCardapio();
            }

    }
        
    }//GEN-LAST:event_bottonRemoverEstoqueActionPerformed

    private void pedidosEmProcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosEmProcessoActionPerformed
        CardLayout cl = (CardLayout) panelConteudo.getLayout();
        cl.show(panelConteudo, "card4");
        carregarTbPedidosEmProcesso();
        
    }//GEN-LAST:event_pedidosEmProcessoActionPerformed

    private void JcomboBoxProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcomboBoxProdutosActionPerformed
        String filtro = JcomboBoxProdutos.getSelectedItem().toString();

    switch (filtro) {
        case "Todos":
            carregarTbPedidosEmProcesso();
            break;

        case "Pendentes":
            carregarPedidosPorStatus(Pedidos.statuspedidoenum.PENDENTE);
            break;

        case "Pagos":
            carregarPedidosPorStatus(Pedidos.statuspedidoenum.PAGO);
            break;

        case "Cancelados":
            carregarPedidosPorStatus(Pedidos.statuspedidoenum.CANCELADO);
            break;
    }
    }//GEN-LAST:event_JcomboBoxProdutosActionPerformed

    private void carregarPedidosPorStatus(Pedidos.statuspedidoenum status) {

        carregarDadosPedidosEmProcesso();

        containerPedidos.removeAll();
        pedidoSelecionado = null;
        painelPedidoSelecionado = null;

        List<PedidosDTO> lista = pedidosController.procurarPedidosPorStatus(
                LocalDate.now(),
                status
        );

        for (PedidosDTO p : lista) {

            DefaultTableModel model = new DefaultTableModel(
                    new Object[]{"Produto", "Qtd", "Preço", "Total"}, 0
            );

            for (ItemPedidos item : p.getItens()) {
                model.addRow(new Object[]{
                        item.getProduto().getNome(),
                        item.getQuantidade(),
                        item.getProduto().getPreco(),
                        item.getProduto().getPreco().multiply(BigDecimal.valueOf(item.getQuantidade()))
                });
            }

            JTable tabela = new JTable(model);
            int altura = (model.getRowCount() + 1) * tabela.getRowHeight() + 40;

            JLabel labelAdicionais = new JLabel("Adicionais: R$ " + p.getAdicionais());
            JLabel labelTotal = new JLabel("Total: R$ " + p.getValorTotal());
            JLabel labelStatus = new JLabel("Status: " + p.getStatus());

            labelTotal.setFont(labelTotal.getFont().deriveFont(Font.BOLD));

            JPanel painelResumo = new JPanel(new GridLayout(3, 1));
            painelResumo.add(labelAdicionais);
            painelResumo.add(labelTotal);
            painelResumo.add(labelStatus);

            JPanel painelPedido = new JPanel(new BorderLayout());
            painelPedido.setBorder(BorderFactory.createTitledBorder("Pedido " + p.getId()));
            painelPedido.setMaximumSize(new Dimension(Integer.MAX_VALUE, altura + 80));
            painelPedido.add(new JScrollPane(tabela), BorderLayout.CENTER);
            painelPedido.add(painelResumo, BorderLayout.SOUTH);
            painelPedido.setBackground(corPadraoPedido);
            painelPedido.setOpaque(true);

            painelPedido.setCursor(new Cursor(Cursor.HAND_CURSOR));

            painelPedido.addMouseListener(new java.awt.event.MouseAdapter() {

                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    selecionarPedido(p, painelPedido);
                }

                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    if (painelPedido != painelPedidoSelecionado) {
                        painelPedido.setBackground(corHouverPedido);
                    }
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    if (painelPedido != painelPedidoSelecionado) {
                        painelPedido.setBackground(corPadraoPedido);
                    }
                }
            });

            containerPedidos.add(painelPedido);
            containerPedidos.add(Box.createVerticalStrut(10));
        }

        containerPedidos.revalidate();
        containerPedidos.repaint();
    }



    private void cancelarTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarTextMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarTextMouseClicked

    private void pagarTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagarTextMouseClicked
        pagarPedido();
    }//GEN-LAST:event_pagarTextMouseClicked

    private void btnParaViagemMouseClicked(java.awt.event.MouseEvent evt) {
        selecionarTipoEntrega("VIAGEM");
    }//GEN-LAST:event_btnParaViagemMouseClicked

    private void jComboBoxDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDiasActionPerformed
        if (modoSemanal) {
            atualizarValoresRelatorioSemanal();
        } else {
            atualizarValoresRelatorioDiario();
        }
    }//GEN-LAST:event_jComboBoxDiasActionPerformed

        private void pagarPedido() {

        if (!garantirCaixaAberto()) {
            return;
        }

        if (pedidoSelecionado == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Selecione um pedido antes de marcar como pago.",
                    "Nenhum pedido selecionado",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (pedidoSelecionado.getStatus() == Pedidos.statuspedidoenum.PAGO) {
            JOptionPane.showMessageDialog(
                    this,
                    "Pedido selecionado já foi pago.",
                    "Pedido Pago",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        String[] opcoes = {"PIX", "Cartão Débito", "Cartão Crédito", "Dinheiro"};

        int escolha = JOptionPane.showOptionDialog(
                this,
                "Selecione a forma de pagamento:",
                "Forma de Pagamento",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );

        if (escolha == JOptionPane.CLOSED_OPTION) {
            return;
        }

        String formaPagamento;

        switch (escolha) {
            case 0 -> formaPagamento = "PIX";
            case 1 -> formaPagamento = "DEBITO";
            case 2 -> formaPagamento = "CREDITO";
            case 3 -> formaPagamento = "DINHEIRO";
            default -> {
                return;
            }
        }

        try {
            PagamentoDto dto = new PagamentoDto(
                    pedidoSelecionado.getId(),
                    pedidoSelecionado.getValorTotal(),
                    formaPagamento
            );

            pagamentoController.realizarPagamento(dto);

            pedidosController.atualizarStatusPedido(
                    pedidoSelecionado.getId(),
                    Pedidos.statuspedidoenum.PAGO
            );

            caixaController.registrarReceita(
                    new MovimentoCaixaRequest(pedidoSelecionado.getValorTotal())
            );

            atualizarSaldoCaixaTela();

            JOptionPane.showMessageDialog(
                    this,
                    "Pedido #" + pedidoSelecionado.getId() + " pago com sucesso! " +
                            "Valor lançado no caixa: " + formatarMoeda(pedidoSelecionado.getValorTotal()),
                    "Pedido Pago",
                    JOptionPane.INFORMATION_MESSAGE
            );

            JcomboBoxProdutos.setSelectedIndex(0);
            carregarTbPedidosEmProcesso();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao pagar pedido: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    void carregarTbPedidosEmProcesso() {

        carregarDadosPedidosEmProcesso();

        containerPedidos.removeAll();
        containerPedidos.setBackground(TemaSistema.fundo());
        containerPedidos.setBorder(new EmptyBorder(12, 12, 12, 12));

        pedidoSelecionado = null;
        painelPedidoSelecionado = null;

        List<PedidosDTO> lista = pedidosController.procurarPedidosPorData(LocalDate.now());

        if (lista.isEmpty()) {
            JLabel vazio = new JLabel("Nenhum pedido encontrado para hoje.", SwingConstants.CENTER);
            vazio.setForeground(TemaSistema.textoSecundario());
            vazio.setFont(new Font("Segoe UI", Font.BOLD, 15));
            vazio.setBorder(new EmptyBorder(24, 12, 24, 12));

            containerPedidos.add(vazio);
            containerPedidos.revalidate();
            containerPedidos.repaint();
            return;
        }

        for (PedidosDTO p : lista) {
            DefaultTableModel model = new DefaultTableModel(
                    new Object[]{"Produto", "Qtd", "Preço", "Total"}, 0
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            for (ItemPedidos item : p.getItens()) {
                model.addRow(new Object[]{
                        item.getProduto().getNome(),
                        item.getQuantidade(),
                        item.getProduto().getPreco(),
                        item.getProduto().getPreco().multiply(new BigDecimal(item.getQuantidade()))
                });
            }

            JTable tabela = new JTable(model);
            estilizarTabelaPedidoInterna(tabela);

            int alturaTabela = Math.min(220, Math.max(95, (model.getRowCount() + 1) * 34 + 8));

            JScrollPane scrollPedido = new JScrollPane(tabela);
            scrollPedido.setBorder(BorderFactory.createEmptyBorder());
            scrollPedido.getViewport().setBackground(corPedidoNormal());
            scrollPedido.setPreferredSize(new Dimension(1, alturaTabela));

            JLabel labelAdicionais = criarLabelResumoPedido("Adicionais: R$ " + p.getAdicionais(), false);
            JLabel labelTotal = criarLabelResumoPedido("Total: R$ " + p.getValorTotal(), true);
            JLabel labelStatus = criarLabelResumoPedido("Status: " + p.getStatus(), false);

            JPanel painelResumo = new JPanel(new GridLayout(3, 1, 0, 4));
            painelResumo.setOpaque(false);
            painelResumo.setBorder(new EmptyBorder(8, 2, 2, 2));
            painelResumo.add(labelAdicionais);
            painelResumo.add(labelTotal);
            painelResumo.add(labelStatus);

            JPanel painelPedido = new JPanel(new BorderLayout(0, 8));
            painelPedido.setOpaque(true);
            pintarCardPedido(painelPedido, corPedidoNormal());
            painelPedido.setCursor(new Cursor(Cursor.HAND_CURSOR));

            TitledBorder titulo = BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(TemaSistema.borda()),
                    "Pedido #" + p.getId(),
                    TitledBorder.LEFT,
                    TitledBorder.TOP,
                    new Font("Segoe UI", Font.BOLD, 15),
                    TemaSistema.texto()
            );

            painelPedido.setBorder(BorderFactory.createCompoundBorder(
                    titulo,
                    new EmptyBorder(10, 10, 10, 10)
            ));

            painelPedido.add(scrollPedido, BorderLayout.CENTER);
            painelPedido.add(painelResumo, BorderLayout.SOUTH);
            painelPedido.setMaximumSize(new Dimension(Integer.MAX_VALUE, alturaTabela + 145));
            painelPedido.setPreferredSize(new Dimension(1, alturaTabela + 145));

            painelPedido.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    selecionarPedido(p, painelPedido);
                }

                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    if (painelPedido != painelPedidoSelecionado) {
                        pintarCardPedido(painelPedido, corPedidoHover());
                    }
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    if (painelPedido != painelPedidoSelecionado) {
                        pintarCardPedido(painelPedido, corPedidoNormal());
                    }
                }
            });

            containerPedidos.add(painelPedido);
            containerPedidos.add(Box.createVerticalStrut(12));
        }

        containerPedidos.revalidate();
        containerPedidos.repaint();
    }

    private JLabel criarLabelResumoPedido(String texto, boolean destaque) {
        JLabel label = new JLabel(texto);
        label.setForeground(destaque ? TemaSistema.primaria() : TemaSistema.textoSecundario());
        label.setFont(new Font("Segoe UI", destaque ? Font.BOLD : Font.PLAIN, destaque ? 15 : 13));
        return label;
    }

    private void estilizarTabelaPedidoInterna(JTable tabela) {
        tabela.setRowHeight(34);
        tabela.setShowGrid(false);
        tabela.setIntercellSpacing(new Dimension(0, 0));
        tabela.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tabela.setForeground(TemaSistema.texto());
        tabela.setBackground(corLinhaTabelaPar());
        tabela.setSelectionBackground(TemaSistema.primaria());
        tabela.setSelectionForeground(Color.WHITE);
        tabela.setFocusable(false);

        JTableHeader header = tabela.getTableHeader();

        if (header != null) {
            header.setBackground(TemaSistema.isEscuro() ? new Color(15, 23, 42) : new Color(241, 245, 249));
            header.setForeground(TemaSistema.texto());
            header.setFont(new Font("Segoe UI", Font.BOLD, 13));
            header.setPreferredSize(new Dimension(1, 34));
            header.setReorderingAllowed(false);
        }

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column
            ) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (isSelected) {
                    c.setBackground(TemaSistema.primaria());
                    c.setForeground(Color.WHITE);
                } else {
                    c.setBackground(row % 2 == 0 ? corLinhaTabelaPar() : corLinhaTabelaImpar());
                    c.setForeground(TemaSistema.texto());
                }

                if (c instanceof JLabel label) {
                    label.setHorizontalAlignment(column == 0 ? SwingConstants.LEFT : SwingConstants.CENTER);
                    label.setBorder(new EmptyBorder(0, 10, 0, 10));
                }

                return c;
            }
        };

        for (int i = 0; i < tabela.getColumnCount(); i++) {
            tabela.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }

    private void pintarCardPedido(JPanel painel, Color cor) {
        painel.setBackground(cor);

        for (Component component : painel.getComponents()) {
            if (component instanceof JPanel panelFilho) {
                panelFilho.setBackground(cor);
            }
        }

        painel.repaint();
    }

    private Color corPedidoNormal() {
        return TemaSistema.isEscuro() ? new Color(31, 41, 55) : Color.WHITE;
    }

    private Color corPedidoHover() {
        return TemaSistema.isEscuro() ? new Color(45, 55, 72) : new Color(255, 247, 237);
    }

    private Color corPedidoSelecionado() {
        return TemaSistema.isEscuro() ? new Color(67, 44, 27) : new Color(255, 237, 213);
    }

    private Color corLinhaTabelaPar() {
        return TemaSistema.isEscuro() ? new Color(17, 24, 39) : Color.WHITE;
    }

    private Color corLinhaTabelaImpar() {
        return TemaSistema.isEscuro() ? new Color(24, 31, 45) : new Color(248, 250, 252);
    }

    private void selecionarPedido(PedidosDTO pedido, JPanel painel) {

        if (painelPedidoSelecionado != null) {
            pintarCardPedido(painelPedidoSelecionado, corPedidoNormal());
        }

        if (pedido.equals(pedidoSelecionado)) {
            pedidoSelecionado = null;
            painelPedidoSelecionado = null;
            return;
        }

        pedidoSelecionado = pedido;
        painelPedidoSelecionado = painel;
        pintarCardPedido(painel, corPedidoSelecionado());

        PedidoEmProcessoText.setText("Pedido #" + pedido.getId());
        subtotalPedido.setText("R$ " + (pedido.getValorTotal().subtract(pedido.getAdicionais())));
        adicionaisPedido.setText("R$ " + pedido.getAdicionais());
        totalPedidos.setText("R$ " + pedido.getValorTotal());
    }

    private void carregarDadosPedidosEmProcesso(){

        List<PedidosDTO> lista = pedidosController.procurarPedidosPorData(LocalDate.now());

        int total = lista.size();
        int pendentes = 0;
        int pagos = 0;
        int cancelados = 0;

        for (PedidosDTO p : lista) {
            switch (p.getStatus()) {
                case PENDENTE -> pendentes++;
                case PAGO -> pagos++;
                case CANCELADO -> cancelados++;
            }
        }

        quantidadePedidosText.setText(String.valueOf(total));
        quantidadePedidosPendentesText.setText(String.valueOf(pendentes));
        quantidadePedidosCanceladosText.setText(String.valueOf(cancelados));
        quantidadePedidosPagosText.setText(String.valueOf(pagos));
    }



        void realizarPedido() {

        if (!garantirCaixaAberto()) {
            return;
        }

        if (pedidosCard.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "O pedido está vazio!",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        List<ItemPedidos> itens = new ArrayList<>();

        for (Map.Entry<Integer, CardPedido> entry : pedidosCard.entrySet()) {

            Integer produtoId = entry.getKey();
            CardPedido card = entry.getValue();

            ItemPedidos item = new ItemPedidos();

            item.setProduto(
                    cardapioController.produtoSelecionadoId(produtoId)
            );

            item.setQuantidade(card.getQuantidade());

            itens.add(item);
        }

        PedidosDTO dto = new PedidosDTO();
        dto.setAdicionais(adicionais);
        dto.setItens(itens);
        dto.setTipoDePedido(tipoEntrega);

        pedidosController.salvar(dto);

        // Limpa os cards da tela
        telaPedidoAtual.removeAll();
        telaPedidoAtual.revalidate();
        telaPedidoAtual.repaint();

        // Limpa o mapa
        pedidosCard.clear();

        // Zera adicionais
        adicionais = BigDecimal.ZERO;
        //Limpa os valores mostrados
        atualizarValoresPedido();

        JOptionPane.showMessageDialog(
                this,
                "Pedido realizado com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


    private JPanel criarCard(Integer id,String nome, BigDecimal preco) {

        return new CardItem(id, nome, preco, new CardItem.CardItemListener() {
            @Override
            public void onAdicionar(Integer id) {
                CardPedido card = pedidosCard.get(id);

                if (card == null) {

                    // produto ainda não está no pedido
                    Cardapio produto = cardapioController.produtoSelecionadoId(id);
                    int quantidade = 1;


                    card = new CardPedido(
                            produto.getNome(),
                            produto.getPreco(),
                            quantidade
                    );

                    card.getQuantidadeLabel().setText("X " + card.getQuantidade());
                    card.setQuantidade(1);
                    pedidosCard.put(id, card);

                    atualizarValoresPedido();

                    telaPedidoAtual.add(card);

                } else {

                    // já existe
                    card.setQuantidade(card.getQuantidade() + 1);
                    card.getQuantidadeLabel().setText("X " + card.getQuantidade());
                    atualizarValoresPedido();
                }

                telaPedidoAtual.revalidate();
                telaPedidoAtual.repaint();
            }

            @Override
            public void onRemover(Integer id) {
                CardPedido card = pedidosCard.get(id);

                if (card == null) return;

                if (card.getQuantidade() > 1) {
                    card.setQuantidade(card.getQuantidade() - 1);
                    card.getQuantidadeLabel().setText("X " + card.getQuantidade());
                    atualizarValoresPedido();
                } else {
                    // quantidade chegou a 0: remove do painel e do map
                    pedidosCard.remove(id);
                    atualizarValoresPedido();
                    telaPedidoAtual.remove(card);
                }

                telaPedidoAtual.revalidate();
                telaPedidoAtual.repaint();

            }
        });
    }

    private void atualizarValoresPedido() {

        BigDecimal subTotal = BigDecimal.ZERO;

        for (Map.Entry<Integer, CardPedido> entry : pedidosCard.entrySet()) {

            Integer produtoId = entry.getKey();
            CardPedido card = entry.getValue();

            Cardapio produto = cardapioController.produtoSelecionadoId(produtoId);

            BigDecimal valorItem = produto.getPreco()
                    .multiply(BigDecimal.valueOf(card.getQuantidade()));

            subTotal = subTotal.add(valorItem);
        }

        BigDecimal total = subTotal.add(adicionais);

        valorSubTotal.setText("R$ " + subTotal);
        valorAdicionais.setText("R$ " + adicionais);
        valorTotal.setText("R$ " + total);
    }

    private void carregarProdutos() {

        telaProdutos.removeAll();
        List<Cardapio> produtos = cardapioController.obterLista();

        for(Cardapio item : produtos){
            telaProdutos.add(criarCard(item.getId(),item.getNome(),item.getPreco()));
        }

        telaProdutos.revalidate();
        telaProdutos.repaint();
        TemaSistema.aplicar(telaProdutos);
    }

    private void carregarProdutosCategoria(String categoria){

        telaProdutos.removeAll();

        List<Cardapio> produtos = cardapioController.obterLista();

        for (Cardapio item:produtos) {

            if (item.getTipo().equals(categoria)){
                telaProdutos.add(
                        criarCard(
                                item.getId(),
                                item.getNome(),
                                item.getPreco()
                                )
                );
            }
        }
        telaProdutos.revalidate();;
        telaProdutos.repaint();
        TemaSistema.aplicar(telaProdutos);
    }

    private void carregarQuantidadeItens()
    {
        List<Cardapio> produto = cardapioController.obterLista();
        int hambur = 0,bebida = 0,combo = 0,porcao = 0,alcoolica = 0;
        for (Cardapio item : produto){
            if (item.getTipo().equals("Lanche")){hambur ++;}
            if (item.getTipo().equals("Bebida")){bebida++;}
            if (item.getTipo().equals("Combo")){combo++;}
            if (item.getTipo().equals("Porcao")){porcao++;}
            if (item.getTipo().equals("Alcoolica")){alcoolica++;}
        }

        quantidadeDeItenHam.setText(hambur + "  itens");
        quantidadeDeItenBebi.setText(bebida + "  itens");
        quantidadeDeItenCom.setText(combo + "  itens");
        quantidadeDeItenporcao.setText(porcao + "  itens");
        quantidadeDeItenAlcool.setText(alcoolica + "  itens");

    }

    private void carregarTbIngredientes(){
        DefaultTableModel model = (DefaultTableModel) tbEstoque.getModel();
        model.setColumnIdentifiers(new String[]{
                "id", "nome", "Estoque"
        });
        model.setRowCount(0);
        List<IngredientesDTO> lista = ingredientesController.listarIngredientes();
        for(IngredientesDTO i : lista){
            model.addRow(new Object[]{
                            i.getId(),
                            i.getNome(),
                            i.getEstoque()
                    }
            );
        }
    }

    private void carregarTbCardapio(){
        DefaultTableModel model = (DefaultTableModel) tbEstoque.getModel();
        model.setColumnIdentifiers(new String[]{
                "id", "nome", "Preço"
        });
        model.setRowCount(0);
        List<Cardapio> lista = cardapioController.obterLista();
        for(Cardapio c : lista){
            model.addRow(new Object[]{
                    c.getId(),
                    c.getNome(),
                    c.getPreco()
                    }
            );
        }
    }

    private void filtrarProdutos() {

        String texto = textprocurar.getText().trim().toLowerCase();

        telaProdutos.removeAll();

        List<Cardapio> produtos = cardapioController.obterLista();

        for (Cardapio item : produtos) {

            if (texto.isEmpty()
                    || item.getNome().toLowerCase().contains(texto)
                    || item.getTipo().toLowerCase().contains(texto)) {

                telaProdutos.add(
                        criarCard(
                                item.getId(),
                                item.getNome(),
                                item.getPreco()
                        )
                );
            }
        }

        telaProdutos.revalidate();
        telaProdutos.repaint();
    }

    private void configurarFiltro() {

        textprocurar.getDocument().addDocumentListener(
                new javax.swing.event.DocumentListener() {

                    @Override
                    public void insertUpdate(javax.swing.event.DocumentEvent e) {
                        filtrarProdutos();
                    }

                    @Override
                    public void removeUpdate(javax.swing.event.DocumentEvent e) {
                        filtrarProdutos();
                    }

                    @Override
                    public void changedUpdate(javax.swing.event.DocumentEvent e) {
                        filtrarProdutos();
                    }
                }
        );
    }

    private void configurarMenuComTema() {

        bottonCaixa = new JButton("Caixa");
        botaoTema = new JButton(TemaSistema.textoBotaoTema());

        panelMenu.removeAll();
        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));
        panelMenu.setBorder(BorderFactory.createEmptyBorder(20, 12, 20, 12));

        BottonPedidos.setText("Pedidos");
        bottonEstoque.setText("Estoque");
        bottonRelatorio.setText("Relatórios");
        pedidosEmProcesso.setText("Concluir");
        bottonCaixa.setText("Caixa");
        botaoTema.setText(TemaSistema.textoBotaoTema());

        TemaSistema.estilizarBotaoMenu(BottonPedidos);
        TemaSistema.estilizarBotaoMenu(bottonEstoque);
        TemaSistema.estilizarBotaoMenu(bottonRelatorio);
        TemaSistema.estilizarBotaoMenu(pedidosEmProcesso);
        TemaSistema.estilizarBotaoMenu(bottonCaixa);
        TemaSistema.estilizarBotaoMenu(botaoTema);

        bottonCaixa.addActionListener(e -> {
            atualizarSaldoCaixaTela();

            CardLayout cl = (CardLayout) panelConteudo.getLayout();
            cl.show(panelConteudo, "cardCaixa");
        });

        botaoTema.addActionListener(e -> {
            TemaSistema.alternarTema();

            botaoTema.setText(TemaSistema.textoBotaoTema());

            aplicarTemaNaTela();
        });

        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        jLabel1.setForeground(TemaSistema.primaria());

        panelMenu.add(jLabel1);
        panelMenu.add(Box.createVerticalStrut(24));

        panelMenu.add(BottonPedidos);
        panelMenu.add(Box.createVerticalStrut(10));

        panelMenu.add(bottonEstoque);
        panelMenu.add(Box.createVerticalStrut(10));

        panelMenu.add(bottonRelatorio);
        panelMenu.add(Box.createVerticalStrut(10));

        panelMenu.add(pedidosEmProcesso);
        panelMenu.add(Box.createVerticalStrut(10));

        panelMenu.add(bottonCaixa);

        panelMenu.add(Box.createVerticalGlue());

        panelMenu.add(botaoTema);

        panelMenu.revalidate();
        panelMenu.repaint();
    }

    private void reconstruirPainelResumoPedido() {
        SomaDeValores.removeAll();
        SomaDeValores.setLayout(new BorderLayout(0, 14));
        SomaDeValores.setBackground(TemaSistema.cardElevado());
        SomaDeValores.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(TemaSistema.borda()),
                new EmptyBorder(14, 14, 14, 14)
        ));

        JPanel valores = new JPanel();
        valores.setOpaque(false);
        valores.setLayout(new BoxLayout(valores, BoxLayout.Y_AXIS));

        valores.add(criarLinhaResumoPedido(subTotalText, valorSubTotal, false));
        valores.add(Box.createVerticalStrut(8));
        valores.add(criarLinhaResumoPedido(adicionaisTextPago, valorAdicionais, false));
        valores.add(Box.createVerticalStrut(10));

        JSeparator separador = new JSeparator();
        separador.setForeground(TemaSistema.borda());
        valores.add(separador);

        valores.add(Box.createVerticalStrut(10));
        valores.add(criarLinhaResumoPedido(valorTotalText, valorTotal, true));

        JPanel entrega = new JPanel(new GridLayout(1, 2, 10, 0));
        entrega.setOpaque(false);

        configurarOpcaoEntrega(praViagemPanel, btnParaViagem, "VIAGEM".equals(tipoEntrega));
        configurarOpcaoEntrega(noLocalPanel, btnNoLocal, "LOCAL".equals(tipoEntrega));

        entrega.add(praViagemPanel);
        entrega.add(noLocalPanel);

        configurarBotaoPainel(
                RealizarPedidoPanel,
                realizarPedidotext,
                TemaSistema.sucesso(),
                "Realizar Pedido"
        );

        JPanel inferior = new JPanel();
        inferior.setOpaque(false);
        inferior.setLayout(new BoxLayout(inferior, BoxLayout.Y_AXIS));
        inferior.add(entrega);
        inferior.add(Box.createVerticalStrut(12));
        inferior.add(RealizarPedidoPanel);

        SomaDeValores.add(valores, BorderLayout.NORTH);
        SomaDeValores.add(inferior, BorderLayout.SOUTH);

        SomaDeValores.revalidate();
        SomaDeValores.repaint();
    }

    private JPanel criarLinhaResumoPedido(JLabel label, JLabel valor, boolean destaque) {
        JPanel linha = new JPanel(new BorderLayout());
        linha.setOpaque(false);

        label.setFont(new Font("Segoe UI", Font.BOLD, destaque ? 17 : 15));
        label.setForeground(destaque ? TemaSistema.texto() : TemaSistema.textoSecundario());

        valor.setFont(new Font("Segoe UI", Font.BOLD, destaque ? 18 : 15));
        valor.setForeground(destaque ? TemaSistema.primaria() : TemaSistema.texto());

        linha.add(label, BorderLayout.WEST);
        linha.add(valor, BorderLayout.EAST);

        return linha;
    }

    private void configurarOpcaoEntrega(
            PanelRedondo panel,
            JLabel label,
            boolean selecionado
    ) {
        panel.removeAll();
        panel.setLayout(new BorderLayout());
        panel.setBackground(selecionado ? TemaSistema.primaria() : TemaSistema.card());
        panel.setBorder(BorderFactory.createLineBorder(
                selecionado ? TemaSistema.primariaHover() : TemaSistema.borda()
        ));
        panel.setPreferredSize(new Dimension(1, 54));
        panel.setMinimumSize(new Dimension(1, 50));
        panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(selecionado ? Color.WHITE : TemaSistema.texto());
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));

        panel.add(label, BorderLayout.CENTER);
    }

    private void organizarTelaPedidos() {
        telaPedidos.removeAll();
        telaPedidos.setLayout(new BorderLayout(18, 0));
        telaPedidos.setBorder(new EmptyBorder(18, 18, 18, 18));
        telaPedidos.setBackground(TemaSistema.fundo());

        reconstruirBusca();
        reconstruirCategoriasPedidos();
        reconstruirPainelResumoPedido();

        JPanel painelEsquerda = new JPanel(new BorderLayout(0, 14));
        painelEsquerda.setOpaque(false);

        JPanel painelCategorias = new JPanel(new GridLayout(2, 3, 12, 12));
        painelCategorias.setOpaque(false);

        painelCategorias.add(panelHamburguer);
        painelCategorias.add(panelBebidas);
        painelCategorias.add(panelCombos);
        painelCategorias.add(panelAlcoolicas);
        painelCategorias.add(panelPorcoes);
        painelCategorias.add(panelAdicionais);

        JPanel topoProdutos = new JPanel(new BorderLayout(0, 14));
        topoProdutos.setOpaque(false);
        topoProdutos.add(MenuBusqueda, BorderLayout.NORTH);
        topoProdutos.add(painelCategorias, BorderLayout.CENTER);

        telaProdutos.setLayout(new WrapLayout(FlowLayout.LEFT, 14, 14));
        telaProdutos.setBorder(new EmptyBorder(14, 14, 14, 14));
        telaProdutos.setBackground(TemaSistema.fundo());

        scrollPanelProdutos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanelProdutos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPanelProdutos.setBorder(BorderFactory.createLineBorder(TemaSistema.borda()));
        scrollPanelProdutos.getViewport().setBackground(TemaSistema.fundo());

        painelEsquerda.add(topoProdutos, BorderLayout.NORTH);
        painelEsquerda.add(scrollPanelProdutos, BorderLayout.CENTER);

        JPanel painelDireita = new JPanel(new BorderLayout(0, 12));
        painelDireita.setOpaque(false);
        painelDireita.setPreferredSize(new Dimension(330, 10));
        painelDireita.setMinimumSize(new Dimension(310, 10));

        PedidoText.setHorizontalAlignment(SwingConstants.LEFT);
        PedidoText.setForeground(TemaSistema.primaria());
        PedidoText.setFont(new Font("Segoe UI", Font.BOLD, 20));

        jScrollPane2.setBorder(BorderFactory.createLineBorder(TemaSistema.borda()));
        jScrollPane2.getViewport().setBackground(TemaSistema.card());

        painelDireita.add(PedidoText, BorderLayout.NORTH);
        painelDireita.add(jScrollPane2, BorderLayout.CENTER);
        painelDireita.add(SomaDeValores, BorderLayout.SOUTH);

        telaPedidos.add(painelEsquerda, BorderLayout.CENTER);
        telaPedidos.add(painelDireita, BorderLayout.EAST);

        telaPedidos.revalidate();
        telaPedidos.repaint();
    }

    private void reconstruirBusca() {
        MenuBusqueda.removeAll();
        MenuBusqueda.setLayout(new BorderLayout());
        MenuBusqueda.setBackground(TemaSistema.cardElevado());
        MenuBusqueda.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(TemaSistema.borda()),
                new EmptyBorder(0, 14, 0, 14)
        ));

        textprocurar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textprocurar.setForeground(TemaSistema.texto());
        textprocurar.setBackground(TemaSistema.cardElevado());
        textprocurar.setCaretColor(TemaSistema.texto());
        textprocurar.setBorder(BorderFactory.createEmptyBorder());
        textprocurar.setPreferredSize(new Dimension(1, 46));

        MenuBusqueda.add(textprocurar, BorderLayout.CENTER);
    }

    private void reconstruirCategoriasPedidos() {
        prepararCardCategoria(panelHamburguer, hamburguerText, quantidadeDeItenHam, imgHambur);
        prepararCardCategoria(panelBebidas, bebidasText, quantidadeDeItenBebi, imgSha);
        prepararCardCategoria(panelCombos, combosText, quantidadeDeItenCom, imgCombos);
        prepararCardCategoria(panelAlcoolicas, alcoolicasText, quantidadeDeItenAlcool, imgAlcoolicas);
        prepararCardCategoria(panelPorcoes, PorcoesText, quantidadeDeItenporcao, imgPorcoes);
        prepararCardCategoria(panelAdicionais, adicionaisText, null, null);
    }

    private void prepararCardCategoria(
            PanelRedondo panel,
            JLabel titulo,
            JLabel quantidade,
            JLabel imagem
    ) {
        if (panel == null) return;

        panel.removeAll();
        panel.setLayout(new BorderLayout(12, 0));
        panel.setBackground(TemaSistema.cardElevado());
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(TemaSistema.borda()),
                new EmptyBorder(12, 14, 12, 14)
        ));
        panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        if (imagem != null) {
            imagem.setHorizontalAlignment(SwingConstants.CENTER);
            imagem.setVerticalAlignment(SwingConstants.CENTER);
            imagem.setPreferredSize(new Dimension(68, 68));
            imagem.setMinimumSize(new Dimension(68, 68));
            imagem.setOpaque(false);
            panel.add(imagem, BorderLayout.WEST);
        }

        JPanel textos = new JPanel();
        textos.setOpaque(false);
        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));

        titulo.setText(titulo.getText().replace("...", "").trim());
        titulo.setForeground(TemaSistema.texto());
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        textos.add(Box.createVerticalGlue());
        textos.add(titulo);

        if (quantidade != null) {
            quantidade.setForeground(TemaSistema.textoSecundario());
            quantidade.setFont(new Font("Segoe UI", Font.BOLD, 12));
            quantidade.setAlignmentX(Component.LEFT_ALIGNMENT);
            textos.add(Box.createVerticalStrut(4));
            textos.add(quantidade);
        }

        textos.add(Box.createVerticalGlue());

        panel.add(textos, BorderLayout.CENTER);

        Dimension tamanho = new Dimension(220, 105);
        panel.setPreferredSize(tamanho);
        panel.setMinimumSize(tamanho);
    }

    private void ajustarDimensoesGerais() {
        setMinimumSize(new Dimension(1180, 720));
        setPreferredSize(new Dimension(1366, 768));

        panelMenu.setPreferredSize(new Dimension(205, 10));
        panelMenu.setMinimumSize(new Dimension(195, 10));

        MenuBusqueda.setPreferredSize(new Dimension(1, 56));
        MenuBusqueda.setMinimumSize(new Dimension(1, 50));

        Dimension categoria = new Dimension(220, 105);

        panelHamburguer.setPreferredSize(categoria);
        panelBebidas.setPreferredSize(categoria);
        panelCombos.setPreferredSize(categoria);
        panelAlcoolicas.setPreferredSize(categoria);
        panelPorcoes.setPreferredSize(categoria);
        panelAdicionais.setPreferredSize(categoria);

        scrollPanelProdutos.setPreferredSize(new Dimension(650, 390));
        scrollPanelProdutos.setMinimumSize(new Dimension(500, 280));

        jScrollPane2.setPreferredSize(new Dimension(330, 360));
        jScrollPane2.setMinimumSize(new Dimension(310, 260));

        SomaDeValores.setPreferredSize(new Dimension(330, 245));
        SomaDeValores.setMinimumSize(new Dimension(310, 230));

        panelRedondo5.setPreferredSize(new Dimension(330, 420));
        panelRedondo5.setMinimumSize(new Dimension(310, 380));

        configurarBotoesSoltos();

        pack();
        setLocationRelativeTo(null);
    }

    private void configurarBotoesSoltos() {
        configurarBotaoPequeno(bottonCardapio, "Cardápio", 135);
        configurarBotaoPequeno(bottonIngredientes, "Ingredientes", 145);
        configurarBotaoPequeno(buttonDiario, "Diário", 120);
        configurarBotaoPequeno(bottonSemanal, "Semanal", 120);

        configurarBotaoGrande(bottonadicinarEstoque, "+ Novo Produto", 220);
        configurarBotaoGrande(bottonRemoverEstoque, "Remover", 220);
    }

    private void configurarBotaoPequeno(JButton botao, String texto, int largura) {
        if (botao == null) return;

        botao.setText(texto);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 14));
        botao.setMargin(new Insets(0, 8, 0, 8));
        botao.setPreferredSize(new Dimension(largura, 44));
        botao.setMinimumSize(new Dimension(largura, 44));
    }

    private void configurarBotaoGrande(JButton botao, String texto, int largura) {
        if (botao == null) return;

        botao.setText(texto);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 15));
        botao.setMargin(new Insets(0, 12, 0, 12));
        botao.setPreferredSize(new Dimension(largura, 58));
        botao.setMinimumSize(new Dimension(largura, 52));
    }

    private void fixarTamanho(JComponent component, int largura, int altura) {
        Dimension dimension = new Dimension(largura, altura);
        component.setPreferredSize(dimension);
        component.setMinimumSize(dimension);
        component.setMaximumSize(dimension);
    }

    private void aplicarTemaNaTela() {
        getContentPane().setBackground(TemaSistema.fundo());
        panelConteudo.setBackground(TemaSistema.fundo());

        panelMenu.setBackground(TemaSistema.isEscuro()
                ? new Color(11, 18, 32)
                : Color.WHITE);

        TemaSistema.aplicar(this);

        TemaSistema.estilizarBotaoMenu(BottonPedidos);
        TemaSistema.estilizarBotaoMenu(bottonEstoque);
        TemaSistema.estilizarBotaoMenu(bottonRelatorio);
        TemaSistema.estilizarBotaoMenu(pedidosEmProcesso);

        if (bottonCaixa != null) {
            TemaSistema.estilizarBotaoMenu(bottonCaixa);
        }

        if (botaoTema != null) {
            botaoTema.setText(TemaSistema.textoBotaoTema());
            TemaSistema.estilizarBotaoMenu(botaoTema);
        }

        jLabel1.setForeground(TemaSistema.primaria());
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 19));

        reconstruirBusca();
        reconstruirCategoriasPedidos();
        reconstruirPainelResumoPedido();
        reconstruirPainelResumoConclusao();
        configurarBotoesSoltos();

        telaPedidos.setBackground(TemaSistema.fundo());
        telaPedidosEmProcesso.setBackground(TemaSistema.fundo());
        telaEstoque.setBackground(TemaSistema.fundo());
        TelaRelatorios.setBackground(TemaSistema.fundo());
        telaProdutos.setBackground(TemaSistema.fundo());
        telaPedidoAtual.setBackground(TemaSistema.card());
        containerPedidos.setBackground(TemaSistema.fundo());

        scrollPanelProdutos.setBorder(BorderFactory.createLineBorder(TemaSistema.borda()));
        scrollPanelProdutos.getViewport().setBackground(TemaSistema.fundo());

        jScrollPane2.setBorder(BorderFactory.createLineBorder(TemaSistema.borda()));
        jScrollPane2.getViewport().setBackground(TemaSistema.card());

        jScrollPane3.setBorder(BorderFactory.createLineBorder(TemaSistema.borda()));
        jScrollPane3.getViewport().setBackground(TemaSistema.fundo());

        TemaSistema.estilizarTabela(tbEstoque);
        TemaSistema.estilizarTabela(tbPedidosEmProcesso);

        revalidate();
        repaint();
    }

    private void estilizarTelasPrincipais() {
        setBackground(TemaSistema.fundo());
        telaPedidos.setBackground(TemaSistema.fundo());
        telaEstoque.setBackground(TemaSistema.fundo());
        telaPedidosEmProcesso.setBackground(TemaSistema.fundo());
        TelaRelatorios.setBackground(TemaSistema.fundo());
        telaProdutos.setBackground(TemaSistema.fundo());
        containerPedidos.setBackground(TemaSistema.fundo());

        scrollPanelProdutos.setBorder(BorderFactory.createEmptyBorder());
        scrollPanelProdutos.getViewport().setBackground(TemaSistema.fundo());
        jScrollPane1.setBorder(BorderFactory.createLineBorder(TemaSistema.borda()));
        jScrollPane2.setBorder(BorderFactory.createLineBorder(TemaSistema.borda()));
        jScrollPane3.setBorder(BorderFactory.createLineBorder(TemaSistema.borda()));
    }

    private void estilizarCardsResumo() {
        estilizarCardInformativo(panelRedondo1, TemaSistema.info(), todostext, quantidadePedidosText, PedidosText);
        estilizarCardInformativo(panelRedondo3, TemaSistema.alerta(), pendenteText, quantidadePedidosPendentesText, jLabel8);
        estilizarCardInformativo(panelRedondo4, TemaSistema.sucesso(), jLabel9, quantidadePedidosPagosText, jLabel11);
        estilizarCardInformativo(panelRedondo8, TemaSistema.perigo(), jLabel12, quantidadePedidosCanceladosText, jLabel14);

        estilizarCardInformativo(panelQuantidadePedidos, TemaSistema.primaria(), jLabel2, pedidosLabel);
        estilizarCardInformativo(panelFaturamento1, TemaSistema.sucesso(), lucroLabel, jLabel6);
        estilizarCardInformativo(panelDespesas, TemaSistema.perigo(), despesasLabel, jLabel3);

        panelPedidosEmProcessoLista.setBackground(TemaSistema.card());
        PedidoEmProcessoText.setForeground(TemaSistema.texto());
        jLabel13.setForeground(TemaSistema.textoSecundario());
        totalPedidos.setForeground(TemaSistema.primaria());
        jLabel16.setForeground(TemaSistema.textoSecundario());
        subtotalPedido.setForeground(TemaSistema.texto());
        jLabel18.setForeground(TemaSistema.textoSecundario());
        adicionaisPedido.setForeground(TemaSistema.texto());
    }

    private void estilizarCategorias() {
        estilizarCategoria(panelBebidas, bebidasText, quantidadeDeItenBebi, imgSha);
        estilizarCategoria(panelHamburguer, hamburguerText, quantidadeDeItenHam, imgHambur);
        estilizarCategoria(panelCombos, combosText, quantidadeDeItenCom, imgCombos);
        estilizarCategoria(panelPorcoes, PorcoesText, quantidadeDeItenporcao, imgPorcoes);
        estilizarCategoria(panelAlcoolicas, alcoolicasText, quantidadeDeItenAlcool, imgAlcoolicas);
        estilizarCategoria(panelAdicionais, adicionaisText, null, null);
    }

    private void estilizarPedidoAtual() {
        PedidoText.setForeground(TemaSistema.primaria());
        PedidoText.setFont(new Font("Segoe UI", Font.BOLD, 20));

        telaPedidoAtual.setBackground(TemaSistema.card());
        telaPedidoAtual.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        SomaDeValores.setBackground(TemaSistema.cardElevado());
        setLabelsForeground(SomaDeValores, TemaSistema.texto());
        adicionaisTextPago.setForeground(TemaSistema.textoSecundario());
        subTotalText.setForeground(TemaSistema.textoSecundario());
        valorTotalText.setForeground(TemaSistema.textoSecundario());
        valorSubTotal.setForeground(TemaSistema.texto());
        valorAdicionais.setForeground(TemaSistema.texto());
        valorTotal.setForeground(TemaSistema.primaria());
        jSeparator1.setForeground(TemaSistema.borda());
        jSeparator2.setForeground(TemaSistema.borda());
    }

    private void estilizarAcoesPedido() {
        estilizarAcaoPainel(RealizarPedidoPanel, realizarPedidotext, TemaSistema.sucesso(), TemaSistema.sucessoEscuro());
        estilizarAcaoPainel(pagarPanel, pagarText, TemaSistema.primaria(), TemaSistema.primariaHover());
        estilizarAcaoPainel(cancelarPedidoPanel, cancelarText, TemaSistema.perigo(), TemaSistema.perigoEscuro());

        atualizarEstiloTipoEntrega();
    }

    private void estilizarEstoqueRelatorios() {
        TemaSistema.estilizarTabela(tbEstoque);
        TemaSistema.estilizarTabela(tbPedidosEmProcesso);

        bottonadicinarEstoque.setText("+ Novo Produto");
        bottonRemoverEstoque.setText("Remover");
        bottonIngredientes.setText("Ingredientes");
        bottonCardapio.setText("Cardápio");

        TemaSistema.estilizarBotao(bottonadicinarEstoque);
        TemaSistema.estilizarBotao(bottonRemoverEstoque);
        TemaSistema.estilizarBotao(bottonIngredientes);
        TemaSistema.estilizarBotao(bottonCardapio);
        TemaSistema.estilizarBotao(buttonDiario);
        TemaSistema.estilizarBotao(bottonSemanal);

        jLabel4.setForeground(TemaSistema.texto());
        jLabel5.setForeground(TemaSistema.textoSecundario());
        jLabel20.setForeground(TemaSistema.texto());
        jLabel21.setForeground(TemaSistema.texto());
    }

    private void estilizarBusca() {
        MenuBusqueda.setBackground(TemaSistema.cardElevado());
        MenuBusqueda.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(TemaSistema.borda()),
                BorderFactory.createEmptyBorder(4, 8, 4, 8)
        ));
        textprocurar.setBackground(TemaSistema.cardElevado());
        textprocurar.setForeground(TemaSistema.texto());
        textprocurar.setCaretColor(TemaSistema.texto());
        textprocurar.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
    }

    private void estilizarCaixa() {
        if (telaCaixa != null) {
            telaCaixa.setBackground(TemaSistema.fundo());
        }
        if (caixaSaldoLabel != null) {
            caixaSaldoLabel.setForeground(TemaSistema.primaria());
        }
        if (caixaEntradaField != null) {
            TemaSistema.estilizarCampo(caixaEntradaField);
        }
        if (caixaSaidaField != null) {
            TemaSistema.estilizarCampo(caixaSaidaField);
        }
    }

    private void estilizarCategoria(PanelRedondo panel, JLabel titulo, JLabel quantidade, JLabel imagem) {
        if (panel == null) return;

        panel.setBackground(TemaSistema.cardElevado());
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(TemaSistema.borda()),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)
        ));
        panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        if (titulo != null) {
            titulo.setForeground(TemaSistema.texto());
            titulo.setFont(new Font("Segoe UI", Font.BOLD, 21));
        }

        if (quantidade != null) {
            quantidade.setForeground(TemaSistema.textoSecundario());
            quantidade.setFont(new Font("Segoe UI", Font.BOLD, 14));
        }

        if (imagem != null) {
            imagem.setOpaque(false);
        }
    }

    private void estilizarCardInformativo(PanelRedondo panel, Color destaque, JLabel... labels) {
        if (panel == null) return;

        panel.setBackground(TemaSistema.cardElevado());
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(TemaSistema.borda()),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        for (int i = 0; i < labels.length; i++) {
            JLabel label = labels[i];
            if (label == null) continue;

            label.setForeground(i == 1 ? destaque : TemaSistema.textoSecundario());

            if (i == 1) {
                label.setFont(new Font("Segoe UI", Font.BOLD, 28));
            } else {
                label.setFont(new Font("Segoe UI", Font.BOLD, Math.max(13, label.getFont().getSize())));
            }
        }
    }

    private void estilizarAcaoPainel(PanelRedondo panel, JLabel label, Color normal, Color hover) {
        if (panel == null) return;

        panel.setBackground(normal);
        panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        if (label != null) {
            label.setForeground(Color.WHITE);
            label.setFont(new Font("Segoe UI", Font.BOLD, 16));
            label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        if (!Boolean.TRUE.equals(panel.getClientProperty("tema.acao.hover.instalado"))) {
            panel.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    panel.setBackground(hover);
                    panel.repaint();
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    panel.setBackground(normal);
                    panel.repaint();
                }
            });
            panel.putClientProperty("tema.acao.hover.instalado", true);
        }
    }

    private void atualizarEstiloTipoEntrega() {
        boolean viagemSelecionado = "VIAGEM".equals(tipoEntrega);

        estilizarTipoEntrega(praViagemPanel, btnParaViagem, viagemSelecionado);
        estilizarTipoEntrega(noLocalPanel, btnNoLocal, !viagemSelecionado);
    }

    private void estilizarTipoEntrega(PanelRedondo panel, JLabel label, boolean selecionado) {
        if (panel == null) return;

        panel.setBackground(selecionado ? TemaSistema.primaria() : TemaSistema.cardElevado());
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(selecionado ? TemaSistema.primariaHover() : TemaSistema.borda()),
                BorderFactory.createEmptyBorder(4, 4, 4, 4)
        ));
        panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        if (label != null) {
            label.setForeground(selecionado ? Color.WHITE : TemaSistema.texto());
            label.setFont(new Font("Segoe UI", Font.BOLD, 16));
            label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    private void setLabelsForeground(Container container, Color color) {
        if (container == null) return;

        for (Component component : container.getComponents()) {
            if (component instanceof JLabel label) {
                label.setForeground(color);
            }
            if (component instanceof Container child) {
                setLabelsForeground(child, color);
            }
        }
    }
//    private void criarPedido() {Pedidos pedido = new Pedidos();}

    /*
      @param args the command line arguments
     **/

    private void criarTelaCaixa() {
        telaCaixa = new JPanel(new BorderLayout(18, 18));
        telaCaixa.setBackground(TemaSistema.fundo());
        telaCaixa.setBorder(BorderFactory.createEmptyBorder(24, 28, 24, 28));

        JPanel topo = new JPanel(new BorderLayout());
        topo.setOpaque(false);

        JPanel textosTopo = new JPanel();
        textosTopo.setOpaque(false);
        textosTopo.setLayout(new BoxLayout(textosTopo, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Fluxo de Caixa");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titulo.setForeground(TemaSistema.primaria());

        JLabel subtitulo = new JLabel("Controle temporário do caixa durante a execução do sistema");
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        subtitulo.setForeground(TemaSistema.textoSecundario());

        textosTopo.add(titulo);
        textosTopo.add(Box.createVerticalStrut(4));
        textosTopo.add(subtitulo);

        caixaStatusLabel = new JLabel("Caixa fechado");
        caixaStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        caixaStatusLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        caixaStatusLabel.setOpaque(true);
        caixaStatusLabel.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));

        topo.add(textosTopo, BorderLayout.WEST);
        topo.add(caixaStatusLabel, BorderLayout.EAST);

        JPanel centro = new JPanel(new BorderLayout(18, 0));
        centro.setOpaque(false);

        JPanel cardResumo = criarCardCaixaResumo();
        JPanel cardOperacoes = criarCardCaixaOperacoes();

        centro.add(cardResumo, BorderLayout.WEST);
        centro.add(cardOperacoes, BorderLayout.CENTER);

        JPanel cardMovimentos = criarCardCaixaMovimentos();

        telaCaixa.add(topo, BorderLayout.NORTH);
        telaCaixa.add(centro, BorderLayout.CENTER);
        telaCaixa.add(cardMovimentos, BorderLayout.SOUTH);

        panelConteudo.add(telaCaixa, "cardCaixa");

        atualizarSaldoCaixaTela();
    }

    private JPanel criarCardCaixaResumo() {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(TemaSistema.card());
        card.setPreferredSize(new Dimension(360, 300));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(TemaSistema.borda()),
                BorderFactory.createEmptyBorder(22, 22, 22, 22)
        ));

        JLabel saldoTitulo = new JLabel("Saldo atual");
        saldoTitulo.setFont(new Font("Segoe UI", Font.BOLD, 15));
        saldoTitulo.setForeground(TemaSistema.textoSecundario());
        saldoTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        caixaSaldoLabel = new JLabel("R$ 0,00");
        caixaSaldoLabel.setFont(new Font("Segoe UI", Font.BOLD, 38));
        caixaSaldoLabel.setForeground(TemaSistema.primaria());
        caixaSaldoLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        caixaEntradasLabel = new JLabel("Entradas: R$ 0,00");
        caixaEntradasLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        caixaEntradasLabel.setForeground(TemaSistema.sucesso());
        caixaEntradasLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        caixaDespesasLabel = new JLabel("Despesas: R$ 0,00");
        caixaDespesasLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        caixaDespesasLabel.setForeground(TemaSistema.perigo());
        caixaDespesasLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(saldoTitulo);
        card.add(Box.createVerticalStrut(8));
        card.add(caixaSaldoLabel);
        card.add(Box.createVerticalStrut(24));
        card.add(caixaEntradasLabel);
        card.add(Box.createVerticalStrut(10));
        card.add(caixaDespesasLabel);

        return card;
    }

    private JPanel criarCardCaixaOperacoes() {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(TemaSistema.card());
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(TemaSistema.borda()),
                BorderFactory.createEmptyBorder(22, 22, 22, 22)
        ));

        JLabel aberturaLabel = criarLabelCaixa("Abrir caixa");
        caixaEntradaField = criarCampoCaixa();

        JButton btnAbrirCaixa = criarBotaoCaixa("Abrir Caixa", TemaSistema.sucesso());
        btnAbrirCaixa.addActionListener(e -> confirmarAberturaCaixa());

        JLabel receitaLabel = criarLabelCaixa("Registrar entrada manual");
        caixaReceitaField = criarCampoCaixa();

        JButton btnReceita = criarBotaoCaixa("Registrar Entrada", TemaSistema.primaria());
        btnReceita.addActionListener(e -> confirmarReceitaCaixa());

        JLabel despesaLabel = criarLabelCaixa("Registrar despesa");
        caixaSaidaField = criarCampoCaixa();

        JButton btnDespesa = criarBotaoCaixa("Registrar Despesa", TemaSistema.perigo());
        btnDespesa.addActionListener(e -> confirmarSaidaCaixa());

        card.add(aberturaLabel);
        card.add(Box.createVerticalStrut(6));
        card.add(caixaEntradaField);
        card.add(Box.createVerticalStrut(8));
        card.add(btnAbrirCaixa);
        card.add(Box.createVerticalStrut(20));

        card.add(receitaLabel);
        card.add(Box.createVerticalStrut(6));
        card.add(caixaReceitaField);
        card.add(Box.createVerticalStrut(8));
        card.add(btnReceita);
        card.add(Box.createVerticalStrut(20));

        card.add(despesaLabel);
        card.add(Box.createVerticalStrut(6));
        card.add(caixaSaidaField);
        card.add(Box.createVerticalStrut(8));
        card.add(btnDespesa);

        return card;
    }

    private JPanel criarCardCaixaMovimentos() {
        JPanel card = new JPanel(new BorderLayout(0, 12));
        card.setBackground(TemaSistema.card());
        card.setPreferredSize(new Dimension(1, 230));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(TemaSistema.borda()),
                BorderFactory.createEmptyBorder(14, 14, 14, 14)
        ));

        JLabel titulo = new JLabel("Movimentações do caixa");
        titulo.setForeground(TemaSistema.texto());
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));

        caixaMovimentosModel = new DefaultTableModel(
                new Object[]{"Data/Hora", "Tipo", "Valor", "Saldo após"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        caixaMovimentosTable = new JTable(caixaMovimentosModel);
        TemaSistema.estilizarTabela(caixaMovimentosTable);

        JScrollPane scroll = new JScrollPane(caixaMovimentosTable);
        scroll.setBorder(BorderFactory.createLineBorder(TemaSistema.borda()));
        scroll.getViewport().setBackground(TemaSistema.card());

        card.add(titulo, BorderLayout.NORTH);
        card.add(scroll, BorderLayout.CENTER);

        return card;
    }

    private JLabel criarLabelCaixa(String texto) {
        JLabel label = new JLabel(texto);
        label.setForeground(TemaSistema.texto());
        label.setFont(new Font("Segoe UI", Font.BOLD, 15));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    private JTextField criarCampoCaixa() {
        JTextField campo = new JTextField();
        campo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
        campo.setPreferredSize(new Dimension(420, 42));
        campo.setBackground(TemaSistema.campo());
        campo.setForeground(TemaSistema.texto());
        campo.setCaretColor(TemaSistema.texto());
        campo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(TemaSistema.borda()),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        campo.setAlignmentX(Component.LEFT_ALIGNMENT);
        return campo;
    }

    private JButton criarBotaoCaixa(String texto, Color cor) {
        JButton botao = new JButton(texto);
        botao.setBackground(cor);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 15));
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setOpaque(true);
        botao.setContentAreaFilled(true);
        botao.setMaximumSize(new Dimension(Integer.MAX_VALUE, 44));
        botao.setPreferredSize(new Dimension(420, 44));
        botao.setAlignmentX(Component.LEFT_ALIGNMENT);
        botao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return botao;
    }

    private void atualizarSaldoCaixaTela() {
        try {
            if (caixaController == null || caixaSaldoLabel == null) {
                return;
            }

            CaixaResponse response = caixaController.obterCaixa();

            caixaSaldoLabel.setText(formatarMoeda(response.saldo()));
            caixaEntradasLabel.setText("Entradas: " + formatarMoeda(response.totalEntradas()));
            caixaDespesasLabel.setText("Despesas: " + formatarMoeda(response.totalDespesas()));

            if (response.aberto()) {
                caixaStatusLabel.setText("Caixa aberto");
                caixaStatusLabel.setBackground(TemaSistema.sucesso());
                caixaStatusLabel.setForeground(Color.WHITE);
            } else {
                caixaStatusLabel.setText("Caixa fechado");
                caixaStatusLabel.setBackground(TemaSistema.perigo());
                caixaStatusLabel.setForeground(Color.WHITE);
            }

            carregarMovimentosCaixa(response);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao carregar caixa: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void carregarMovimentosCaixa(CaixaResponse response) {
        if (caixaMovimentosModel == null) {
            return;
        }

        caixaMovimentosModel.setRowCount(0);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        for (MovimentoCaixaResponse movimento : response.movimentos()) {
            caixaMovimentosModel.addRow(new Object[]{
                    movimento.dataHora().format(formatter),
                    movimento.tipo(),
                    formatarMoeda(movimento.valor()),
                    formatarMoeda(movimento.saldoAposMovimento())
            });
        }
    }

    private void confirmarAberturaCaixa() {
        try {
            BigDecimal valor = lerValorMonetario(caixaEntradaField);

            CaixaResponse response = caixaController.abrirCaixa(
                    new AbrirCaixaRequest(valor)
            );

            caixaEntradaField.setText("");
            atualizarSaldoCaixaTela();

            JOptionPane.showMessageDialog(
                    this,
                    "Caixa aberto com sucesso.\nSaldo inicial: " + formatarMoeda(response.valorAbertura()),
                    "Caixa aberto",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao abrir caixa: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void confirmarReceitaCaixa() {
        try {
            BigDecimal valor = lerValorMonetario(caixaReceitaField);

            caixaController.registrarReceita(
                    new MovimentoCaixaRequest(valor)
            );

            caixaReceitaField.setText("");
            atualizarSaldoCaixaTela();

            JOptionPane.showMessageDialog(
                    this,
                    "Entrada registrada com sucesso.",
                    "Entrada registrada",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao registrar entrada: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void confirmarSaidaCaixa() {
        try {
            BigDecimal valor = lerValorMonetario(caixaSaidaField);

            caixaController.registrarDespesa(
                    new MovimentoCaixaRequest(valor)
            );

            caixaSaidaField.setText("");
            atualizarSaldoCaixaTela();

            JOptionPane.showMessageDialog(
                    this,
                    "Despesa registrada com sucesso.",
                    "Despesa registrada",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao registrar despesa: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private boolean caixaEstaAberto() {
        return caixaController != null && caixaController.isAberto();
    }

    private boolean garantirCaixaAberto() {
        if (caixaEstaAberto()) {
            return true;
        }

        JOptionPane.showMessageDialog(
                this,
                "Abra o caixa antes de realizar essa operação.",
                "Caixa fechado",
                JOptionPane.WARNING_MESSAGE
        );

        CardLayout cl = (CardLayout) panelConteudo.getLayout();
        cl.show(panelConteudo, "cardCaixa");

        return false;
    }

    private BigDecimal lerValorMonetario(JTextField campo) {
        String texto = campo.getText()
                .trim()
                .replace("R$", "")
                .replace(" ", "");

        if (texto.isBlank()) {
            throw new IllegalArgumentException("Digite um valor.");
        }

        if (texto.contains(",")) {
            texto = texto.replace(".", "").replace(",", ".");
        }

        try {
            BigDecimal valor = new BigDecimal(texto);

            if (valor.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("O valor precisa ser maior que zero.");
            }

            return valor;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Valor inválido. Exemplo correto: 12,50");
        }
    }

    private String formatarMoeda(BigDecimal valor) {
        if (valor == null) {
            valor = BigDecimal.ZERO;
        }

        return "R$ " + valor.setScale(2, java.math.RoundingMode.HALF_UP)
                .toString()
                .replace(".", ",");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton BottonPedidos;
    private JComboBox<String> JcomboBoxProdutos;
    private PanelRedondo MenuBusqueda;
    private JLabel PedidoEmProcessoText;
    private JLabel PedidoText;
    private JLabel PedidosText;
    private JLabel PorcoesText;
    private PanelRedondo RealizarPedidoPanel;
    private PanelRedondo SomaDeValores;
    private JPanel TelaRelatorios;
    private JLabel adicionaisPedido;
    private JLabel adicionaisText;
    private JLabel adicionaisTextPago;
    private JLabel alcoolicasText;
    private JLabel bebidasText;
    private JButton bottonCardapio;
    private JButton bottonEstoque;
    private JButton bottonIngredientes;
    private JButton bottonRelatorio;
    private JButton bottonRemoverEstoque;
    private JButton bottonSemanal;
    private JButton bottonadicinarEstoque;
    private JLabel btnNoLocal;
    private JLabel btnParaViagem;
    private JButton buttonDiario;
    private PanelRedondo cancelarPedidoPanel;
    private JLabel cancelarText;
    private JLabel combosText;
    private JLabel despesasLabel;
    private com.github.Gregorys2s.util.GraficoPizza graficoPizza2;
    private com.github.Gregorys2s.util.GraficoPizza graficopizza1;
    private JLabel hamburguerText;
    private JLabel imgAlcoolicas;
    private JLabel imgCombos;
    private JLabel imgHambur;
    private JLabel imgPorcoes;
    private JLabel imgSha;
    private JComboBox<String> jComboBoxDias;
    private JLabel jLabel1;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel16;
    private JLabel jLabel18;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JLabel lucroLabel;
    private PanelRedondo noLocalPanel;
    private PanelRedondo pagarPanel;
    private JLabel pagarText;
    private PanelRedondo panelAdicionais;
    private PanelRedondo panelAlcoolicas;
    private PanelRedondo panelBebidas;
    private PanelRedondo panelCombos;
    private JPanel panelConteudo;
    private PanelRedondo panelDespesas;
    private PanelRedondo panelFaturamento1;
    private PanelRedondo panelHamburguer;
    private JPanel panelMenu;
    private PanelRedondo panelPedidosEmProcessoLista;
    private PanelRedondo panelPorcoes;
    private PanelRedondo panelQuantidadePedidos;
    private PanelRedondo panelRedondo1;
    private PanelRedondo panelRedondo3;
    private PanelRedondo panelRedondo4;
    private PanelRedondo panelRedondo5;
    private PanelRedondo panelRedondo8;
    private JButton pedidosEmProcesso;
    private JLabel pedidosLabel;
    private JLabel pendenteText;
    private PanelRedondo praViagemPanel;
    private JLabel quantidadeDeItenAlcool;
    private JLabel quantidadeDeItenBebi;
    private JLabel quantidadeDeItenCom;
    private JLabel quantidadeDeItenHam;
    private JLabel quantidadeDeItenporcao;
    private JLabel quantidadePedidosCanceladosText;
    private JLabel quantidadePedidosPagosText;
    private JLabel quantidadePedidosPendentesText;
    private JLabel quantidadePedidosText;
    private JLabel realizarPedidotext;
    private JScrollPane scrollPanelProdutos;
    private JLabel subTotalText;
    private JLabel subtotalPedido;
    private JTable tbEstoque;
    private JTable tbPedidosEmProcesso;
    private JPanel telaEstoque;
    private JPanel telaPedidoAtual;
    private JPanel telaPedidos;
    private JPanel telaPedidosEmProcesso;
    private JPanel telaProdutos;
    private JTextField textprocurar;
    private JLabel todostext;
    private JLabel totalPedidos;
    private JLabel valorAdicionais;
    private JLabel valorSubTotal;
    private JLabel valorTotal;
    private JLabel valorTotalText;
    // End of variables declaration//GEN-END:variables
}
