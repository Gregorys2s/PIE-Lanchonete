/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.github.Gregorys2s.view.inicializacao;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
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
import com.github.Gregorys2s.model.entity.*;
import com.github.Gregorys2s.view.Criar.WrapLayout;
import com.github.Gregorys2s.view.pedidos.CardItem;
import com.github.Gregorys2s.view.pedidos.CardPedido;
import com.github.Gregorys2s.controller.caixa.CaixaController;
import com.github.Gregorys2s.view.tema.TemaSistema;
import com.github.Gregorys2s.util.ImagemUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

/**
 *
 * @author Gregory
 */
public class MenuInicial extends javax.swing.JFrame {

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
    private JLabel caixaSaldoLabel;
    private JTextField caixaEntradaField;
    private JTextField caixaSaidaField;

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

        panelMenu = new javax.swing.JPanel();
        BottonPedidos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bottonEstoque = new javax.swing.JButton();
        bottonRelatorio = new javax.swing.JButton();
        pedidosEmProcesso = new javax.swing.JButton();
        panelConteudo = new javax.swing.JPanel();
        telaPedidosEmProcesso = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelRedondo1 = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        todostext = new javax.swing.JLabel();
        quantidadePedidosText = new javax.swing.JLabel();
        PedidosText = new javax.swing.JLabel();
        panelRedondo3 = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        pendenteText = new javax.swing.JLabel();
        quantidadePedidosPendentesText = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelRedondo4 = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        jLabel9 = new javax.swing.JLabel();
        quantidadePedidosPagosText = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        panelRedondo8 = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        jLabel12 = new javax.swing.JLabel();
        quantidadePedidosCanceladosText = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        panelPedidosEmProcessoLista = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbPedidosEmProcesso = new javax.swing.JTable();
        JcomboBoxProdutos = new javax.swing.JComboBox<>();
        panelRedondo5 = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        cancelarPedidoPanel = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        cancelarText = new javax.swing.JLabel();
        pagarPanel = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        pagarText = new javax.swing.JLabel();
        PedidoEmProcessoText = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        totalPedidos = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        subtotalPedido = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        adicionaisPedido = new javax.swing.JLabel();
        telaEstoque = new javax.swing.JPanel();
        bottonadicinarEstoque = new javax.swing.JButton();
        bottonRemoverEstoque = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEstoque = new javax.swing.JTable();
        bottonIngredientes = new javax.swing.JButton();
        bottonCardapio = new javax.swing.JButton();
        telaPedidos = new javax.swing.JPanel();
        panelBebidas = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        imgSha = new javax.swing.JLabel();
        bebidasText = new javax.swing.JLabel();
        quantidadeDeItenBebi = new javax.swing.JLabel();
        panelHamburguer = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        quantidadeDeItenHam = new javax.swing.JLabel();
        hamburguerText = new javax.swing.JLabel();
        imgHambur = new javax.swing.JLabel();
        panelCombos = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        quantidadeDeItenCom = new javax.swing.JLabel();
        combosText = new javax.swing.JLabel();
        imgCombos = new javax.swing.JLabel();
        panelPorcoes = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        quantidadeDeItenporcao = new javax.swing.JLabel();
        PorcoesText = new javax.swing.JLabel();
        imgPorcoes = new javax.swing.JLabel();
        panelAlcoolicas = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        quantidadeDeItenAlcool = new javax.swing.JLabel();
        alcoolicasText = new javax.swing.JLabel();
        imgAlcoolicas = new javax.swing.JLabel();
        MenuBusqueda = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        textprocurar = new javax.swing.JTextField();
        PedidoText = new javax.swing.JLabel();
        scrollPanelProdutos = new javax.swing.JScrollPane();
        telaProdutos = new javax.swing.JPanel();
        SomaDeValores = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        adicionaisTextPago = new javax.swing.JLabel();
        subTotalText = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        praViagemPanel = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        btnParaViagem = new javax.swing.JLabel();
        noLocalPanel = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        btnNoLocal = new javax.swing.JLabel();
        RealizarPedidoPanel = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        realizarPedidotext = new javax.swing.JLabel();
        valorTotalText = new javax.swing.JLabel();
        valorTotal = new javax.swing.JLabel();
        valorAdicionais = new javax.swing.JLabel();
        valorSubTotal = new javax.swing.JLabel();
        panelAdicionais = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        adicionaisText = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        telaPedidoAtual = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        TelaRelatorios = new javax.swing.JPanel();
        graficopizza1 = new com.github.Gregorys2s.util.GraficoPizza();
        graficoPizza2 = new com.github.Gregorys2s.util.GraficoPizza();
        panelQuantidadePedidos = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        jLabel2 = new javax.swing.JLabel();
        pedidosLabel = new javax.swing.JLabel();
        buttonDiario = new javax.swing.JButton();
        bottonSemanal = new javax.swing.JButton();
        panelFaturamento1 = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        lucroLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelDespesas = new com.github.Gregorys2s.view.inicializacao.PanelRedondo();
        despesasLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(43, 43, 43));

        panelMenu.setBackground(new java.awt.Color(33, 33, 33));

        BottonPedidos.setBackground(new java.awt.Color(33, 33, 33));
        BottonPedidos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        BottonPedidos.setForeground(new java.awt.Color(153, 153, 153));
        BottonPedidos.setText("Pedidos");
        BottonPedidos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BottonPedidos.setBorderPainted(false);
        BottonPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BottonPedidos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BottonPedidos.setVerifyInputWhenFocusTarget(false);
        BottonPedidos.addActionListener(this::BottonPedidosActionPerformed);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Lanchonete");

        bottonEstoque.setBackground(new java.awt.Color(33, 33, 33));
        bottonEstoque.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bottonEstoque.setForeground(new java.awt.Color(153, 153, 153));
        bottonEstoque.setText("Estoque");
        bottonEstoque.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bottonEstoque.setBorderPainted(false);
        bottonEstoque.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bottonEstoque.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bottonEstoque.setVerifyInputWhenFocusTarget(false);
        bottonEstoque.addActionListener(this::bottonEstoqueActionPerformed);

        bottonRelatorio.setBackground(new java.awt.Color(33, 33, 33));
        bottonRelatorio.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bottonRelatorio.setForeground(new java.awt.Color(153, 153, 153));
        bottonRelatorio.setText("Relatorio");
        bottonRelatorio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bottonRelatorio.setBorderPainted(false);
        bottonRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bottonRelatorio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bottonRelatorio.setVerifyInputWhenFocusTarget(false);
        bottonRelatorio.addActionListener(this::bottonRelatorioActionPerformed);

        pedidosEmProcesso.setBackground(new java.awt.Color(33, 33, 33));
        pedidosEmProcesso.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        pedidosEmProcesso.setForeground(new java.awt.Color(153, 153, 153));
        pedidosEmProcesso.setText("Concluir");
        pedidosEmProcesso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pedidosEmProcesso.setBorderPainted(false);
        pedidosEmProcesso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pedidosEmProcesso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pedidosEmProcesso.setVerifyInputWhenFocusTarget(false);
        pedidosEmProcesso.addActionListener(this::pedidosEmProcessoActionPerformed);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BottonPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(bottonEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottonRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pedidosEmProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BottonPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottonEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottonRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pedidosEmProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelConteudo.setLayout(new java.awt.CardLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel4.setText("Pedidos");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Gerencie e acompanhe todos os pedidos");

        panelRedondo1.setBackground(new java.awt.Color(0, 204, 204));
        panelRedondo1.setPreferredSize(new java.awt.Dimension(140, 100));

        todostext.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        todostext.setText("Todos");

        quantidadePedidosText.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        quantidadePedidosText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quantidadePedidosText.setText("N");

        PedidosText.setText("Pedidos");

        javax.swing.GroupLayout panelRedondo1Layout = new javax.swing.GroupLayout(panelRedondo1);
        panelRedondo1.setLayout(panelRedondo1Layout);
        panelRedondo1Layout.setHorizontalGroup(
            panelRedondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedondo1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(panelRedondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PedidosText)
                    .addComponent(todostext)
                    .addComponent(quantidadePedidosText, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
        panelRedondo1Layout.setVerticalGroup(
            panelRedondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(todostext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantidadePedidosText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PedidosText)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        panelRedondo3.setBackground(new java.awt.Color(0, 204, 204));
        panelRedondo3.setPreferredSize(new java.awt.Dimension(140, 100));

        pendenteText.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        pendenteText.setText("Pendentes");

        quantidadePedidosPendentesText.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        quantidadePedidosPendentesText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quantidadePedidosPendentesText.setText("N");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel8.setText("aguardando Pagamentos");

        javax.swing.GroupLayout panelRedondo3Layout = new javax.swing.GroupLayout(panelRedondo3);
        panelRedondo3.setLayout(panelRedondo3Layout);
        panelRedondo3Layout.setHorizontalGroup(
            panelRedondo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelRedondo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pendenteText, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRedondo3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(quantidadePedidosPendentesText, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelRedondo3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRedondo3Layout.setVerticalGroup(
            panelRedondo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pendenteText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantidadePedidosPendentesText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        panelRedondo4.setBackground(new java.awt.Color(0, 204, 204));
        panelRedondo4.setPreferredSize(new java.awt.Dimension(140, 100));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel9.setText("Pagos");

        quantidadePedidosPagosText.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        quantidadePedidosPagosText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quantidadePedidosPagosText.setText("N");

        jLabel11.setText("Pedidos concluidos");

        javax.swing.GroupLayout panelRedondo4Layout = new javax.swing.GroupLayout(panelRedondo4);
        panelRedondo4.setLayout(panelRedondo4Layout);
        panelRedondo4Layout.setHorizontalGroup(
            panelRedondo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo4Layout.createSequentialGroup()
                .addGroup(panelRedondo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRedondo4Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel9))
                    .addGroup(panelRedondo4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(quantidadePedidosPagosText, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRedondo4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel11)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelRedondo4Layout.setVerticalGroup(
            panelRedondo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantidadePedidosPagosText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelRedondo8.setBackground(new java.awt.Color(0, 204, 204));
        panelRedondo8.setPreferredSize(new java.awt.Dimension(140, 100));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel12.setText("Cancelados");

        quantidadePedidosCanceladosText.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        quantidadePedidosCanceladosText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quantidadePedidosCanceladosText.setText("N");

        jLabel14.setText("Pedidos cancelados");

        javax.swing.GroupLayout panelRedondo8Layout = new javax.swing.GroupLayout(panelRedondo8);
        panelRedondo8.setLayout(panelRedondo8Layout);
        panelRedondo8Layout.setHorizontalGroup(
            panelRedondo8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo8Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelRedondo8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRedondo8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(quantidadePedidosCanceladosText, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedondo8Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(17, 17, 17))
        );
        panelRedondo8Layout.setVerticalGroup(
            panelRedondo8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantidadePedidosCanceladosText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tbPedidosEmProcesso.setModel(new javax.swing.table.DefaultTableModel(
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

        JcomboBoxProdutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Pendentes", "Cancelados", "Pagos" }));
        JcomboBoxProdutos.addActionListener(this::JcomboBoxProdutosActionPerformed);

        javax.swing.GroupLayout panelPedidosEmProcessoListaLayout = new javax.swing.GroupLayout(panelPedidosEmProcessoLista);
        panelPedidosEmProcessoLista.setLayout(panelPedidosEmProcessoListaLayout);
        panelPedidosEmProcessoListaLayout.setHorizontalGroup(
            panelPedidosEmProcessoListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
            .addGroup(panelPedidosEmProcessoListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JcomboBoxProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPedidosEmProcessoListaLayout.setVerticalGroup(
            panelPedidosEmProcessoListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPedidosEmProcessoListaLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(JcomboBoxProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelRedondo5.setBackground(new java.awt.Color(51, 204, 255));

        cancelarPedidoPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarTextMouseClicked(evt);
            }
        });

        cancelarText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cancelarText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelarText.setText("Cancelar Pedido");
        cancelarText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarTextMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout cancelarPedidoPanelLayout = new javax.swing.GroupLayout(cancelarPedidoPanel);
        cancelarPedidoPanel.setLayout(cancelarPedidoPanelLayout);
        cancelarPedidoPanelLayout.setHorizontalGroup(
            cancelarPedidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cancelarPedidoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelarText)
                .addGap(51, 51, 51))
        );
        cancelarPedidoPanelLayout.setVerticalGroup(
            cancelarPedidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cancelarPedidoPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(cancelarText, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        pagarPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pagarTextMouseClicked(evt);
            }
        });

        pagarText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pagarText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pagarText.setText("Pagar");
        pagarText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pagarTextMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pagarPanelLayout = new javax.swing.GroupLayout(pagarPanel);
        pagarPanel.setLayout(pagarPanelLayout);
        pagarPanelLayout.setHorizontalGroup(
            pagarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pagarPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pagarText, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        pagarPanelLayout.setVerticalGroup(
            pagarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagarPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(pagarText, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        PedidoEmProcessoText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PedidoEmProcessoText.setText("Pedido #??");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel13.setText("Total");

        totalPedidos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        totalPedidos.setText("R$-");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel16.setText("Subtotal");

        subtotalPedido.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        subtotalPedido.setText("R$-");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel18.setText("Adicionais");

        adicionaisPedido.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        adicionaisPedido.setText("R$-");

        javax.swing.GroupLayout panelRedondo5Layout = new javax.swing.GroupLayout(panelRedondo5);
        panelRedondo5.setLayout(panelRedondo5Layout);
        panelRedondo5Layout.setHorizontalGroup(
            panelRedondo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRedondo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelarPedidoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pagarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(panelRedondo5Layout.createSequentialGroup()
                .addGroup(panelRedondo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRedondo5Layout.createSequentialGroup()
                        .addGroup(panelRedondo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRedondo5Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(PedidoEmProcessoText, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRedondo5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel16))
                            .addGroup(panelRedondo5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(panelRedondo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(totalPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subtotalPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)))
                    .addGroup(panelRedondo5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18)
                        .addGap(24, 24, 24)
                        .addComponent(adicionaisPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelRedondo5Layout.setVerticalGroup(
            panelRedondo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedondo5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(PedidoEmProcessoText, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRedondo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subtotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRedondo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(adicionaisPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(panelRedondo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(pagarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelarPedidoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout telaPedidosEmProcessoLayout = new javax.swing.GroupLayout(telaPedidosEmProcesso);
        telaPedidosEmProcesso.setLayout(telaPedidosEmProcessoLayout);
        telaPedidosEmProcessoLayout.setHorizontalGroup(
            telaPedidosEmProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaPedidosEmProcessoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(telaPedidosEmProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaPedidosEmProcessoLayout.createSequentialGroup()
                        .addComponent(panelPedidosEmProcessoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelRedondo5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(telaPedidosEmProcessoLayout.createSequentialGroup()
                        .addGroup(telaPedidosEmProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addGroup(telaPedidosEmProcessoLayout.createSequentialGroup()
                                .addComponent(panelRedondo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(panelRedondo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(panelRedondo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(panelRedondo8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        telaPedidosEmProcessoLayout.setVerticalGroup(
            telaPedidosEmProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaPedidosEmProcessoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(telaPedidosEmProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(telaPedidosEmProcessoLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(telaPedidosEmProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelRedondo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRedondo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelRedondo8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRedondo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(telaPedidosEmProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelPedidosEmProcessoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRedondo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelConteudo.add(telaPedidosEmProcesso, "card4");

        bottonadicinarEstoque.setText("adicionar Item");
        bottonadicinarEstoque.addActionListener(this::bottonadicinarEstoqueActionPerformed);

        bottonRemoverEstoque.setText("remover item");
        bottonRemoverEstoque.addActionListener(this::bottonRemoverEstoqueActionPerformed);

        tbEstoque.setModel(new javax.swing.table.DefaultTableModel(
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

        javax.swing.GroupLayout telaEstoqueLayout = new javax.swing.GroupLayout(telaEstoque);
        telaEstoque.setLayout(telaEstoqueLayout);
        telaEstoqueLayout.setHorizontalGroup(
            telaEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaEstoqueLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(bottonCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bottonIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaEstoqueLayout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(telaEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaEstoqueLayout.createSequentialGroup()
                        .addComponent(bottonadicinarEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(bottonRemoverEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        telaEstoqueLayout.setVerticalGroup(
            telaEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaEstoqueLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(telaEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bottonIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottonCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(telaEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bottonadicinarEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottonRemoverEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        panelConteudo.add(telaEstoque, "card3");

        telaPedidos.setBackground(new java.awt.Color(43, 43, 43));

        panelBebidas.setBackground(java.awt.SystemColor.activeCaption);
        panelBebidas.setMaximumSize(new java.awt.Dimension(166, 122));
        panelBebidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBebidasMouseClicked(evt);
            }
        });

        imgSha.setIcon(ImagemUtil.carregar("/Imagens/Pedidos/Refrigerante.png", 44, 58));

        bebidasText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bebidasText.setText("Bebidas");

        quantidadeDeItenBebi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        quantidadeDeItenBebi.setText("?  itens");

        javax.swing.GroupLayout panelBebidasLayout = new javax.swing.GroupLayout(panelBebidas);
        panelBebidas.setLayout(panelBebidasLayout);
        panelBebidasLayout.setHorizontalGroup(
            panelBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBebidasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgSha)
                    .addComponent(bebidasText)
                    .addComponent(quantidadeDeItenBebi, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBebidasLayout.setVerticalGroup(
            panelBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBebidasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgSha, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bebidasText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(quantidadeDeItenBebi)
                .addContainerGap())
        );

        panelHamburguer.setBackground(java.awt.SystemColor.activeCaption);
        panelHamburguer.setMaximumSize(new java.awt.Dimension(166, 122));
        panelHamburguer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelHamburguerMouseClicked(evt);
            }
        });

        quantidadeDeItenHam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        quantidadeDeItenHam.setText("?  itens");

        hamburguerText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        hamburguerText.setText("Hamburguer");

        imgHambur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Pedidos/hambur.png"))); // NOI18N
        imgHambur.setPreferredSize(new java.awt.Dimension(47, 47));
        imgHambur.setMaximumSize(new java.awt.Dimension(47, 47));
        imgHambur.setMinimumSize(new java.awt.Dimension(47, 47));

        javax.swing.GroupLayout panelHamburguerLayout = new javax.swing.GroupLayout(panelHamburguer);
        panelHamburguer.setLayout(panelHamburguerLayout);
        panelHamburguerLayout.setHorizontalGroup(
            panelHamburguerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHamburguerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelHamburguerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHamburguerLayout.createSequentialGroup()
                        .addGroup(panelHamburguerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imgHambur)
                            .addComponent(quantidadeDeItenHam, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHamburguerLayout.createSequentialGroup()
                        .addComponent(hamburguerText, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panelHamburguerLayout.setVerticalGroup(
            panelHamburguerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHamburguerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgHambur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(hamburguerText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(quantidadeDeItenHam, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelCombos.setBackground(java.awt.SystemColor.activeCaption);
        panelCombos.setMaximumSize(new java.awt.Dimension(166, 122));
        panelCombos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCombosMouseClicked(evt);
            }
        });

        quantidadeDeItenCom.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        quantidadeDeItenCom.setText("?  itens");

        combosText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        combosText.setText("Combos");

        imgCombos.setIcon(ImagemUtil.carregar("/Imagens/Pedidos/hamburguesaIcone.png", 58, 48));        javax.swing.GroupLayout panelCombosLayout = new javax.swing.GroupLayout(panelCombos);
        panelCombos.setLayout(panelCombosLayout);
        panelCombosLayout.setHorizontalGroup(
            panelCombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCombosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combosText)
                    .addComponent(imgCombos)
                    .addComponent(quantidadeDeItenCom, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        panelCombosLayout.setVerticalGroup(
            panelCombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCombosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgCombos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(combosText, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantidadeDeItenCom)
                .addContainerGap())
        );

        panelPorcoes.setBackground(java.awt.SystemColor.activeCaption);
        panelPorcoes.setMaximumSize(new java.awt.Dimension(166, 122));
        panelPorcoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelPorcoesMouseClicked(evt);
            }
        });

        quantidadeDeItenporcao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        quantidadeDeItenporcao.setText("?  itens");

        PorcoesText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PorcoesText.setText("Porções");

        imgPorcoes.setIcon(ImagemUtil.carregar("/Imagens/Pedidos/hambur.png", 56, 52));
        javax.swing.GroupLayout panelPorcoesLayout = new javax.swing.GroupLayout(panelPorcoes);
        panelPorcoes.setLayout(panelPorcoesLayout);
        panelPorcoesLayout.setHorizontalGroup(
            panelPorcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPorcoesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelPorcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgPorcoes)
                    .addComponent(PorcoesText)
                    .addComponent(quantidadeDeItenporcao, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        panelPorcoesLayout.setVerticalGroup(
            panelPorcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPorcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgPorcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PorcoesText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantidadeDeItenporcao))
        );

        panelAlcoolicas.setBackground(java.awt.SystemColor.activeCaption);
        panelAlcoolicas.setMaximumSize(new java.awt.Dimension(166, 122));
        panelAlcoolicas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAlcoolicasMouseClicked(evt);
            }
        });

        quantidadeDeItenAlcool.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        quantidadeDeItenAlcool.setText("?  itens");

        alcoolicasText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        alcoolicasText.setText("Alcoolicas ");

        imgAlcoolicas.setIcon(ImagemUtil.carregar("/Imagens/Pedidos/Refrigerante.png", 44, 58));
        imgAlcoolicas.setPreferredSize(new java.awt.Dimension(47, 47));
        imgAlcoolicas.setMaximumSize(new java.awt.Dimension(47, 47));
        imgAlcoolicas.setMinimumSize(new java.awt.Dimension(47, 47));

        javax.swing.GroupLayout panelAlcoolicasLayout = new javax.swing.GroupLayout(panelAlcoolicas);
        panelAlcoolicas.setLayout(panelAlcoolicasLayout);
        panelAlcoolicasLayout.setHorizontalGroup(
            panelAlcoolicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlcoolicasLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelAlcoolicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgAlcoolicas)
                    .addComponent(quantidadeDeItenAlcool, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alcoolicasText))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelAlcoolicasLayout.setVerticalGroup(
            panelAlcoolicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlcoolicasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgAlcoolicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alcoolicasText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantidadeDeItenAlcool))
        );

        MenuBusqueda.setBackground(new java.awt.Color(51, 51, 51));

        textprocurar.setBackground(new java.awt.Color(51, 51, 51));
        textprocurar.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        textprocurar.setForeground(new java.awt.Color(242, 242, 242));
        textprocurar.setActionCommand("null");
        textprocurar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textprocurar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textprocurarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textprocurarFocusLost(evt);
            }
        });

        javax.swing.GroupLayout MenuBusquedaLayout = new javax.swing.GroupLayout(MenuBusqueda);
        MenuBusqueda.setLayout(MenuBusquedaLayout);
        MenuBusquedaLayout.setHorizontalGroup(
            MenuBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textprocurar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        MenuBusquedaLayout.setVerticalGroup(
            MenuBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textprocurar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PedidoText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PedidoText.setForeground(new java.awt.Color(255, 51, 51));
        PedidoText.setText("Pedido #?");

        scrollPanelProdutos.setBackground(new java.awt.Color(43, 43, 43));
        scrollPanelProdutos.setBorder(null);

        telaProdutos.setBackground(new java.awt.Color(43, 43, 43));
        telaProdutos.setLayout(new java.awt.GridBagLayout());
        scrollPanelProdutos.setViewportView(telaProdutos);

        SomaDeValores.setBackground(new java.awt.Color(255, 153, 153));

        adicionaisTextPago.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        adicionaisTextPago.setText("Adicionais");

        subTotalText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        subTotalText.setText("Subtotal");

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        praViagemPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnParaViagemMouseClicked(evt);
            }
        });

        btnParaViagem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnParaViagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnParaViagem.setText("Para Viagem");
        btnParaViagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnParaViagemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout praViagemPanelLayout = new javax.swing.GroupLayout(praViagemPanel);
        praViagemPanel.setLayout(praViagemPanelLayout);
        praViagemPanelLayout.setHorizontalGroup(
            praViagemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(praViagemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnParaViagem, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );
        praViagemPanelLayout.setVerticalGroup(
            praViagemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, praViagemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnParaViagem, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        noLocalPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noLocalPanelMouseClicked(evt);
            }
        });

        btnNoLocal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNoLocal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNoLocal.setText("No Local");
        btnNoLocal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNoLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noLocalPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout noLocalPanelLayout = new javax.swing.GroupLayout(noLocalPanel);
        noLocalPanel.setLayout(noLocalPanelLayout);
        noLocalPanelLayout.setHorizontalGroup(
            noLocalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noLocalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNoLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );
        noLocalPanelLayout.setVerticalGroup(
            noLocalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, noLocalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNoLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNoLocal.getAccessibleContext().setAccessibleDescription("");

        RealizarPedidoPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RealizarPedidoPanelMouseClicked(evt);
            }
        });

        realizarPedidotext.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        realizarPedidotext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        realizarPedidotext.setText("Realizar Pedido");
        realizarPedidotext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RealizarPedidoPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout RealizarPedidoPanelLayout = new javax.swing.GroupLayout(RealizarPedidoPanel);
        RealizarPedidoPanel.setLayout(RealizarPedidoPanelLayout);
        RealizarPedidoPanelLayout.setHorizontalGroup(
            RealizarPedidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RealizarPedidoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(realizarPedidotext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        RealizarPedidoPanelLayout.setVerticalGroup(
            RealizarPedidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RealizarPedidoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(realizarPedidotext, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );

        valorTotalText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        valorTotalText.setText("Total");

        valorTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        valorTotal.setText("R$    0");

        valorAdicionais.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        valorAdicionais.setText("R$    0");

        valorSubTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        valorSubTotal.setText("R$    0");

        javax.swing.GroupLayout SomaDeValoresLayout = new javax.swing.GroupLayout(SomaDeValores);
        SomaDeValores.setLayout(SomaDeValoresLayout);
        SomaDeValoresLayout.setHorizontalGroup(
            SomaDeValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(SomaDeValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SomaDeValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RealizarPedidoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SomaDeValoresLayout.createSequentialGroup()
                        .addGroup(SomaDeValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adicionaisTextPago)
                            .addComponent(subTotalText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(SomaDeValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valorAdicionais, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SomaDeValoresLayout.createSequentialGroup()
                        .addGroup(SomaDeValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(praViagemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valorTotalText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(SomaDeValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(noLocalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        SomaDeValoresLayout.setVerticalGroup(
            SomaDeValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SomaDeValoresLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(SomaDeValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subTotalText)
                    .addComponent(valorSubTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SomaDeValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionaisTextPago)
                    .addComponent(valorAdicionais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SomaDeValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorTotalText)
                    .addComponent(valorTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                .addGroup(SomaDeValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(praViagemPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noLocalPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(RealizarPedidoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        panelAdicionais.setBackground(java.awt.SystemColor.activeCaption);
        panelAdicionais.setMaximumSize(new java.awt.Dimension(166, 122));
        panelAdicionais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAdicionaisMouseClicked(evt);
            }
        });

        adicionaisText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        adicionaisText.setText("  Adicionais");
        adicionaisText.setToolTipText("");
        adicionaisText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAdicionaisMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelAdicionaisLayout = new javax.swing.GroupLayout(panelAdicionais);
        panelAdicionais.setLayout(panelAdicionaisLayout);
        panelAdicionaisLayout.setHorizontalGroup(
            panelAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adicionaisText, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        panelAdicionaisLayout.setVerticalGroup(
            panelAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdicionaisLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(adicionaisText)
                .addGap(23, 23, 23))
        );

        jScrollPane2.setBorder(null);

        telaPedidoAtual.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout telaPedidoAtualLayout = new javax.swing.GroupLayout(telaPedidoAtual);
        telaPedidoAtual.setLayout(telaPedidoAtualLayout);
        telaPedidoAtualLayout.setHorizontalGroup(
            telaPedidoAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
        );
        telaPedidoAtualLayout.setVerticalGroup(
            telaPedidoAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(telaPedidoAtual);

        javax.swing.GroupLayout telaPedidosLayout = new javax.swing.GroupLayout(telaPedidos);
        telaPedidos.setLayout(telaPedidosLayout);
        telaPedidosLayout.setHorizontalGroup(
            telaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(telaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(telaPedidosLayout.createSequentialGroup()
                        .addGroup(telaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelAlcoolicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelHamburguer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(telaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelPorcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBebidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(telaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelCombos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelAdicionais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPanelProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(telaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaPedidosLayout.createSequentialGroup()
                        .addComponent(PedidoText, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(SomaDeValores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        telaPedidosLayout.setVerticalGroup(
            telaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaPedidosLayout.createSequentialGroup()
                .addGroup(telaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaPedidosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(MenuBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaPedidosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PedidoText)
                        .addGap(18, 18, 18)))
                .addGroup(telaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(telaPedidosLayout.createSequentialGroup()
                        .addGroup(telaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelBebidas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelHamburguer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelCombos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(telaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelPorcoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelAlcoolicas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelAdicionais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(scrollPanelProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(telaPedidosLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)
                        .addComponent(SomaDeValores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        panelConteudo.add(telaPedidos, "card2");

        javax.swing.GroupLayout graficopizza1Layout = new javax.swing.GroupLayout(graficopizza1);
        graficopizza1.setLayout(graficopizza1Layout);
        graficopizza1Layout.setHorizontalGroup(
            graficopizza1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        graficopizza1Layout.setVerticalGroup(
            graficopizza1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout graficoPizza2Layout = new javax.swing.GroupLayout(graficoPizza2);
        graficoPizza2.setLayout(graficoPizza2Layout);
        graficoPizza2Layout.setHorizontalGroup(
            graficoPizza2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        graficoPizza2Layout.setVerticalGroup(
            graficoPizza2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        panelQuantidadePedidos.setBackground(new java.awt.Color(204, 51, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Pedidos");

        pedidosLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pedidosLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pedidosLabel.setText("N");

        javax.swing.GroupLayout panelQuantidadePedidosLayout = new javax.swing.GroupLayout(panelQuantidadePedidos);
        panelQuantidadePedidos.setLayout(panelQuantidadePedidosLayout);
        panelQuantidadePedidosLayout.setHorizontalGroup(
            panelQuantidadePedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuantidadePedidosLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelQuantidadePedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelQuantidadePedidosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(pedidosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        panelQuantidadePedidosLayout.setVerticalGroup(
            panelQuantidadePedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuantidadePedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pedidosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        buttonDiario.setText("Diario");
        buttonDiario.addActionListener(this::buttonDiarioActionPerformed);

        bottonSemanal.setText("Semanal");
        bottonSemanal.addActionListener(this::bottonSemanalActionPerformed);

        panelFaturamento1.setBackground(new java.awt.Color(0, 153, 255));

        lucroLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lucroLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lucroLabel.setText("N");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Lucro");

        javax.swing.GroupLayout panelFaturamento1Layout = new javax.swing.GroupLayout(panelFaturamento1);
        panelFaturamento1.setLayout(panelFaturamento1Layout);
        panelFaturamento1Layout.setHorizontalGroup(
            panelFaturamento1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFaturamento1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelFaturamento1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lucroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFaturamento1Layout.setVerticalGroup(
            panelFaturamento1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFaturamento1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lucroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panelDespesas.setBackground(new java.awt.Color(204, 51, 0));

        despesasLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        despesasLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        despesasLabel.setText("N");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Despesas");

        javax.swing.GroupLayout panelDespesasLayout = new javax.swing.GroupLayout(panelDespesas);
        panelDespesas.setLayout(panelDespesasLayout);
        panelDespesasLayout.setHorizontalGroup(
            panelDespesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDespesasLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(panelDespesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(despesasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelDespesasLayout.setVerticalGroup(
            panelDespesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDespesasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(despesasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setText("Produtos mais Vendidos");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setText("Relatorios Financeiros");

        javax.swing.GroupLayout TelaRelatoriosLayout = new javax.swing.GroupLayout(TelaRelatorios);
        TelaRelatorios.setLayout(TelaRelatoriosLayout);
        TelaRelatoriosLayout.setHorizontalGroup(
            TelaRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaRelatoriosLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(TelaRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TelaRelatoriosLayout.createSequentialGroup()
                        .addComponent(panelFaturamento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(panelQuantidadePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(panelDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TelaRelatoriosLayout.createSequentialGroup()
                        .addComponent(buttonDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(bottonSemanal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(TelaRelatoriosLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(TelaRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(graficopizza1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(53, 53, 53)
                .addGroup(TelaRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(graficoPizza2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        TelaRelatoriosLayout.setVerticalGroup(
            TelaRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaRelatoriosLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(TelaRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottonSemanal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(TelaRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelFaturamento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelQuantidadePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TelaRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TelaRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(graficoPizza2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(graficopizza1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(146, 146, 146))
        );

        panelConteudo.add(TelaRelatorios, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelConteudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelConteudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        AtualizarValoresRelatorioDiario();

        graficoPizza2.revalidate();
        graficoPizza2.repaint();

    }//GEN-LAST:event_bottonRelatorioActionPerformed

    private void bottonSemanalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottonSemanalActionPerformed

        LocalDate semanaInicio = LocalDate.now().with(java.time.DayOfWeek.MONDAY);


        RelatoriosSemanalesDTO relatorio =
                relatorioSemanalcontroller.buscarPorSemana(semanaInicio);

        if (relatorio != null) {

            lucroLabel.setText("R$ " + relatorio.getLucroTotal());
            pedidosLabel.setText(relatorio.getTotalPedidos().toString());
            despesasLabel.setText("R$ " + relatorio.getDespesasTotal());

            graficopizza1.adicionarItem("Despesas",relatorio.getDespesasTotal().intValue());
            graficopizza1.adicionarItem("Lucro",relatorio.getLucroTotal().intValue());

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Não existe relatório semanal para a data de hoje.",
                    "Relatório não encontrado",
                    JOptionPane.INFORMATION_MESSAGE
            );

        }
        graficoPizza2.limpar();
        List<PedidosMasVendidosDTO> top3 = pedidosController.buscarTop3MaisVendidosSemanal();

        for (PedidosMasVendidosDTO item :top3){
            graficoPizza2.adicionarItem(item.getNome(),item.getQuantidade());
        }

    }//GEN-LAST:event_bottonSemanalActionPerformed

    private void buttonDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDiarioActionPerformed

        AtualizarValoresRelatorioDiario();

    }//GEN-LAST:event_buttonDiarioActionPerformed

    private void AtualizarValoresRelatorioDiario(){
        Optional<RelatorioDiario> optional = relatorioController.buscarPorData(LocalDate.now());
        if (optional.isPresent()) {
            RelatorioDiario relatorioDiario = optional.get();
            
            lucroLabel.setText("R$" + relatorioDiario.getLucroTotal().toString());
            pedidosLabel.setText(relatorioDiario.getQuantidadePedidos().toString());
            despesasLabel.setText(relatorioDiario.getDespesas().toString());

            graficopizza1.adicionarItem("Despesas",relatorioDiario.getDespesas().intValue());
            graficopizza1.adicionarItem("Lucro",relatorioDiario.getLucroTotal().intValue());

        }else {
            JOptionPane.showMessageDialog(
                    this,
                    "Não existe relatório diário para a data de hoje.",
                    "Relatório não encontrado",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

        List<PedidosMasVendidosDTO> top3 = pedidosController.buscarTop3MaisVendidos();

        graficoPizza2.limpar();

        for (PedidosMasVendidosDTO item :top3){
            graficoPizza2.adicionarItem(item.getNome(),item.getQuantidade());
        }
    }

    private void bottonadicinarEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottonadicinarEstoqueActionPerformed
        
    }//GEN-LAST:event_bottonadicinarEstoqueActionPerformed

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

    private void pagarPedido() {

        if (pedidoSelecionado == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Selecione um pedido antes de marcar como pago.",
                    "Nenhum pedido selecionado",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (pedidoSelecionado.getStatus() == Pedidos.statuspedidoenum.PAGO){
            JOptionPane.showMessageDialog(
                    this,
                    "Pedido Selecionado ja foi pago",
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
            return; // usuário fechou sem escolher
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

        PagamentoDto dto = new PagamentoDto(
                pedidoSelecionado.getId(),
                pedidoSelecionado.getValorTotal(),
                formaPagamento
        );

        pedidosController.atualizarStatusPedido(pedidoSelecionado.getId(),Pedidos.statuspedidoenum.PAGO);
        pagamentoController.realizarPagamento(dto);

        JOptionPane.showMessageDialog(
                this,
                "Pedido #" + pedidoSelecionado.getId() + " pago com sucesso!",
                "Pedido Pago",
                JOptionPane.INFORMATION_MESSAGE
        );

        JcomboBoxProdutos.setSelectedIndex(0);
        carregarTbPedidosEmProcesso(); // recarrega e limpa seleção
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
        telaCaixa = new JPanel(new GridBagLayout());
        telaCaixa.setBackground(new Color(24, 24, 24));
        telaCaixa.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JPanel card = new JPanel();
        card.setBackground(new Color(33, 33, 33));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(255, 153, 0), 1),
                BorderFactory.createEmptyBorder(28, 32, 28, 32)
        ));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Fluxo de Caixa");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 34));
        titulo.setForeground(new Color(255, 153, 0));
        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel subtitulo = new JLabel("Controle de entradas e saídas do caixa");
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        subtitulo.setForeground(new Color(190, 190, 190));
        subtitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        caixaSaldoLabel = new JLabel("R$ 0.00");
        caixaSaldoLabel.setFont(new Font("Segoe UI", Font.BOLD, 42));
        caixaSaldoLabel.setForeground(Color.WHITE);
        caixaSaldoLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel entradaLabel = new JLabel("Entrada / abertura de caixa");
        entradaLabel.setForeground(Color.WHITE);
        entradaLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        entradaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        caixaEntradaField = criarCampoCaixa();

        JButton btnEntrada = criarBotaoCaixa(
                "Confirmar Entrada",
                new Color(0, 153, 76)
        );

        btnEntrada.addActionListener(e -> confirmarEntradaCaixa());

        JLabel saidaLabel = new JLabel("Saída / despesa / retirada");
        saidaLabel.setForeground(Color.WHITE);
        saidaLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        saidaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        caixaSaidaField = criarCampoCaixa();

        JButton btnSaida = criarBotaoCaixa(
                "Confirmar Saída",
                new Color(204, 51, 51)
        );

        btnSaida.addActionListener(e -> confirmarSaidaCaixa());

        card.add(titulo);
        card.add(Box.createVerticalStrut(6));
        card.add(subtitulo);
        card.add(Box.createVerticalStrut(30));
        card.add(caixaSaldoLabel);
        card.add(Box.createVerticalStrut(35));
        card.add(entradaLabel);
        card.add(Box.createVerticalStrut(8));
        card.add(caixaEntradaField);
        card.add(Box.createVerticalStrut(10));
        card.add(btnEntrada);
        card.add(Box.createVerticalStrut(30));
        card.add(saidaLabel);
        card.add(Box.createVerticalStrut(8));
        card.add(caixaSaidaField);
        card.add(Box.createVerticalStrut(10));
        card.add(btnSaida);

        telaCaixa.add(card);

        panelConteudo.add(telaCaixa, "cardCaixa");

        atualizarSaldoCaixaTela();
    }

    private JTextField criarCampoCaixa() {
        JTextField campo = new JTextField();
        campo.setMaximumSize(new Dimension(420, 42));
        campo.setPreferredSize(new Dimension(420, 42));
        campo.setBackground(new Color(45, 45, 45));
        campo.setForeground(Color.WHITE);
        campo.setCaretColor(Color.WHITE);
        campo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(90, 90, 90)),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        campo.setAlignmentX(Component.LEFT_ALIGNMENT);
        return campo;
    }

    private JButton criarBotaoCaixa(String texto, Color cor) {
        JButton botao = new JButton(texto);
        botao.setBackground(cor);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 16));
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setMaximumSize(new Dimension(420, 44));
        botao.setPreferredSize(new Dimension(420, 44));
        botao.setAlignmentX(Component.LEFT_ALIGNMENT);
        return botao;
    }

    private void atualizarSaldoCaixaTela() {
        try {
            if (caixaController == null) {
                caixaSaldoLabel.setText("Caixa não configurado");
                return;
            }

            var response = caixaController.obterCaixa();

            caixaSaldoLabel.setText("R$ " + response.saldo());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao carregar saldo do caixa: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void confirmarEntradaCaixa() {
        try {
            BigDecimal valor = lerValorMonetario(caixaEntradaField);

            var request =
                    new com.github.Gregorys2s.controller.caixa.DTO.AbrirCaixaRequest(valor);

            var response = caixaController.abrirCaixa(request);

            caixaSaldoLabel.setText("R$ " + response.saldo());
            caixaEntradaField.setText("");

            JOptionPane.showMessageDialog(
                    this,
                    "Entrada registrada com sucesso!"
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

            var request =
                    new com.github.Gregorys2s.controller.caixa.DTO.MovimentoCaixaRequest(valor);

            var response = caixaController.registrarDespesa(request);

            caixaSaldoLabel.setText("R$ " + response.saldo());
            caixaSaidaField.setText("");

            JOptionPane.showMessageDialog(
                    this,
                    "Saída registrada com sucesso!"
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao registrar saída: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
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

        BigDecimal valor = new BigDecimal(texto);

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor precisa ser maior que zero.");
        }

        return valor;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BottonPedidos;
    private javax.swing.JComboBox<String> JcomboBoxProdutos;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo MenuBusqueda;
    private javax.swing.JLabel PedidoEmProcessoText;
    private javax.swing.JLabel PedidoText;
    private javax.swing.JLabel PedidosText;
    private javax.swing.JLabel PorcoesText;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo RealizarPedidoPanel;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo SomaDeValores;
    private javax.swing.JPanel TelaRelatorios;
    private javax.swing.JLabel adicionaisPedido;
    private javax.swing.JLabel adicionaisText;
    private javax.swing.JLabel adicionaisTextPago;
    private javax.swing.JLabel alcoolicasText;
    private javax.swing.JLabel bebidasText;
    private javax.swing.JButton bottonCardapio;
    private javax.swing.JButton bottonEstoque;
    private javax.swing.JButton bottonIngredientes;
    private javax.swing.JButton bottonRelatorio;
    private javax.swing.JButton bottonRemoverEstoque;
    private javax.swing.JButton bottonSemanal;
    private javax.swing.JButton bottonadicinarEstoque;
    private javax.swing.JLabel btnNoLocal;
    private javax.swing.JLabel btnParaViagem;
    private javax.swing.JButton buttonDiario;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo cancelarPedidoPanel;
    private javax.swing.JLabel cancelarText;
    private javax.swing.JLabel combosText;
    private javax.swing.JLabel despesasLabel;
    private com.github.Gregorys2s.util.GraficoPizza graficoPizza2;
    private com.github.Gregorys2s.util.GraficoPizza graficopizza1;
    private javax.swing.JLabel hamburguerText;
    private javax.swing.JLabel imgAlcoolicas;
    private javax.swing.JLabel imgCombos;
    private javax.swing.JLabel imgHambur;
    private javax.swing.JLabel imgPorcoes;
    private javax.swing.JLabel imgSha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lucroLabel;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo noLocalPanel;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo pagarPanel;
    private javax.swing.JLabel pagarText;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo panelAdicionais;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo panelAlcoolicas;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo panelBebidas;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo panelCombos;
    private javax.swing.JPanel panelConteudo;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo panelDespesas;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo panelFaturamento1;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo panelHamburguer;
    private javax.swing.JPanel panelMenu;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo panelPedidosEmProcessoLista;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo panelPorcoes;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo panelQuantidadePedidos;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo panelRedondo1;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo panelRedondo3;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo panelRedondo4;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo panelRedondo5;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo panelRedondo8;
    private javax.swing.JButton pedidosEmProcesso;
    private javax.swing.JLabel pedidosLabel;
    private javax.swing.JLabel pendenteText;
    private com.github.Gregorys2s.view.inicializacao.PanelRedondo praViagemPanel;
    private javax.swing.JLabel quantidadeDeItenAlcool;
    private javax.swing.JLabel quantidadeDeItenBebi;
    private javax.swing.JLabel quantidadeDeItenCom;
    private javax.swing.JLabel quantidadeDeItenHam;
    private javax.swing.JLabel quantidadeDeItenporcao;
    private javax.swing.JLabel quantidadePedidosCanceladosText;
    private javax.swing.JLabel quantidadePedidosPagosText;
    private javax.swing.JLabel quantidadePedidosPendentesText;
    private javax.swing.JLabel quantidadePedidosText;
    private javax.swing.JLabel realizarPedidotext;
    private javax.swing.JScrollPane scrollPanelProdutos;
    private javax.swing.JLabel subTotalText;
    private javax.swing.JLabel subtotalPedido;
    private javax.swing.JTable tbEstoque;
    private javax.swing.JTable tbPedidosEmProcesso;
    private javax.swing.JPanel telaEstoque;
    private javax.swing.JPanel telaPedidoAtual;
    private javax.swing.JPanel telaPedidos;
    private javax.swing.JPanel telaPedidosEmProcesso;
    private javax.swing.JPanel telaProdutos;
    private javax.swing.JTextField textprocurar;
    private javax.swing.JLabel todostext;
    private javax.swing.JLabel totalPedidos;
    private javax.swing.JLabel valorAdicionais;
    private javax.swing.JLabel valorSubTotal;
    private javax.swing.JLabel valorTotal;
    private javax.swing.JLabel valorTotalText;
    // End of variables declaration//GEN-END:variables
}
