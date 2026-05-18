package com.github.Gregorys2s.view.relatorios;

import com.github.Gregorys2s.controller.RelatorioController;
import com.github.Gregorys2s.entity.RelatorioDiario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;


public class RelatorioDiarioView extends JInternalFrame {

    // ── Formatadores ──────────────────────────────────────────────────────────
    private static final DateTimeFormatter FMT_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final NumberFormat FMT_BRL = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    // ── Cores (consistentes com o Nimbus/look do projeto) ─────────────────────
    private static final Color COR_FUNDO   = new Color(245, 245, 245);
    private static final Color COR_LABEL   = new Color(80, 80, 80);
    private static final Color COR_VERDE   = new Color(34, 139, 34);
    private static final Color COR_VERMELHO = new Color(180, 30, 30);
    private static final Color COR_AZUL    = new Color(30, 100, 180);
    private static final Font FONTE_LABEL  = new Font("Segoe UI", Font.PLAIN, 13);
    private static final Font FONTE_VALOR  = new Font("Segoe UI", Font.BOLD, 13);
    private static final Font FONTE_TITULO = new Font("Segoe UI", Font.BOLD, 14);

    // ── Dependência ───────────────────────────────────────────────────────────
    private final RelatorioController relatorioController;

    // ── Campos de exibição ────────────────────────────────────────────────────
    private JLabel lblData;
    private JLabel lblQuantidadePedidos;
    private JLabel lblDespesas;
    private JLabel lblLucroTotal;
    private JLabel lblEstoqueFinal;
    private JLabel lblLucroLiquido;

    // ── Construtor ────────────────────────────────────────────────────────────

    public RelatorioDiarioView(RelatorioController relatorioController) {
        super("Relatório Diário", true, true, false, true);
        this.relatorioController = relatorioController;
        inicializarUI();
        carregarRelatorioDoDia();
    }

    // ── Montagem da tela ──────────────────────────────────────────────────────

    private void inicializarUI() {
        setSize(420, 380);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel painelPrincipal = new JPanel(new BorderLayout(0, 10));
        painelPrincipal.setBackground(COR_FUNDO);
        painelPrincipal.setBorder(new EmptyBorder(14, 16, 14, 16));

        painelPrincipal.add(criarPainelDados(),   BorderLayout.CENTER);
        painelPrincipal.add(criarBotaoAtualizar(), BorderLayout.SOUTH);

        
        painelPrincipal.add(criarPainelBotoes(), BorderLayout.SOUTH);
        setContentPane(painelPrincipal);
    }

    /**
     * Painel com os campos do relatório — espelha exatamente o que
     * exibirRelatorio() imprimia no CLI:
     *   Data / Qtd. de Pedidos / Despesas / Lucro Total / Estoque Final
     * + Lucro Líquido (Lucro Total - Despesas) calculado aqui na view.
     */
    private JPanel criarPainelDados() {
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(Color.WHITE);
        painel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                "Resumo do Turno",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                FONTE_TITULO,
                COR_AZUL));

        GridBagConstraints cLabel = new GridBagConstraints();
        cLabel.anchor = GridBagConstraints.WEST;
        cLabel.insets = new Insets(8, 12, 0, 8);
        cLabel.gridx = 0;

        GridBagConstraints cValor = new GridBagConstraints();
        cValor.anchor = GridBagConstraints.EAST;
        cValor.insets = new Insets(8, 0, 0, 12);
        cValor.gridx = 1;
        cValor.fill = GridBagConstraints.HORIZONTAL;
        cValor.weightx = 1.0;

        lblData               = criarLabelValor("—");
        lblQuantidadePedidos  = criarLabelValor("—");
        lblDespesas           = criarLabelValor("—", COR_VERMELHO);
        lblLucroTotal         = criarLabelValor("—", COR_VERDE);
        lblEstoqueFinal       = criarLabelValor("—");
        lblLucroLiquido       = criarLabelValor("—", COR_VERDE);

        int linha = 0;

        adicionarLinha(painel, "Data:",              lblData,              cLabel, cValor, linha++);
        adicionarSeparador(painel, linha++);
        adicionarLinha(painel, "Qtd. de Pedidos:",   lblQuantidadePedidos, cLabel, cValor, linha++);
        adicionarSeparador(painel, linha++);
        adicionarLinha(painel, "Despesas:",           lblDespesas,          cLabel, cValor, linha++);
        adicionarSeparador(painel, linha++);
        adicionarLinha(painel, "Lucro Total:",        lblLucroTotal,        cLabel, cValor, linha++);
        adicionarSeparador(painel, linha++);
        adicionarLinha(painel, "Estoque Final:",      lblEstoqueFinal,      cLabel, cValor, linha++);
        adicionarSeparador(painel, linha++);
        adicionarLinha(painel, "Lucro Líquido:",      lblLucroLiquido,      cLabel, cValor, linha++);

        // Espaçador no final
        GridBagConstraints cFill = new GridBagConstraints();
        cFill.gridy = linha;
        cFill.weighty = 1.0;
        painel.add(new JLabel(), cFill);

        return painel;
    }

    private JButton criarBotaoAtualizar() {
        JButton btn = new JButton("↻  Atualizar");
        btn.setFont(FONTE_VALOR);
        btn.setFocusPainted(false);
        btn.addActionListener(e -> carregarRelatorioDoDia());
        return btn;
    }

    // ── Helpers de layout ─────────────────────────────────────────────────────

    private void adicionarLinha(JPanel p, String textoLabel, JLabel lblValor,
                                GridBagConstraints cL, GridBagConstraints cV, int linha) {
        JLabel label = new JLabel(textoLabel);
        label.setFont(FONTE_LABEL);
        label.setForeground(COR_LABEL);

        cL.gridy = linha;
        cV.gridy = linha;
        p.add(label,   cL);
        p.add(lblValor, cV);
    }

    private void adicionarSeparador(JPanel p, int linha) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = linha;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(2, 12, 0, 12);
        JSeparator sep = new JSeparator();
        sep.setForeground(new Color(220, 220, 220));
        p.add(sep, c);
    }

    private JLabel criarLabelValor(String texto) {
        return criarLabelValor(texto, Color.BLACK);
    }

    private JLabel criarLabelValor(String texto, Color cor) {
        JLabel lbl = new JLabel(texto, SwingConstants.RIGHT);
        lbl.setFont(FONTE_VALOR);
        lbl.setForeground(cor);
        return lbl;
    }
    private JPanel criarPainelBotoes() {
        JPanel painelBotoes = new JPanel(new GridLayout(1, 2, 10, 0));
        painelBotoes.setBackground(COR_FUNDO);

        
        JButton btnAtualizar = new JButton("↻  Atualizar");
        btnAtualizar.setFont(FONTE_VALOR);
        btnAtualizar.setFocusPainted(false);
        btnAtualizar.addActionListener(e -> carregarRelatorioDoDia());

        JButton btnFechar = new JButton("✕  Fechar");
        btnFechar.setFont(FONTE_VALOR);
        btnFechar.setFocusPainted(false);
        btnFechar.addActionListener(e -> dispose()); 

        painelBotoes.add(btnAtualizar);
        painelBotoes.add(btnFechar);

        return painelBotoes;
    }
    // ── Carregamento de dados ─────────────────────────────────────────────────

    /**
     * Busca o relatório do dia atual via controller e preenche os campos.
     * É a única interação desta view com o controller — uma responsabilidade só.
     */
    private void carregarRelatorioDoDia() {
        try {
            List<RelatorioDiario> todos = relatorioController.listarTodos();

            if (todos.isEmpty()) {
                mostrarVazio();
                return;
            }

            // listarTodos() retorna ordem DESC — o primeiro é o mais recente (turno atual)
            RelatorioDiario relatorio = todos.get(0);
            preencherCampos(relatorio);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao carregar relatório:\n" + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Preenche os labels com os dados do relatório —
     * equivalente ao exibirRelatorio() que antes usava System.out.
     */
    private void preencherCampos(RelatorioDiario r) {
        lblData.setText(r.getData().format(FMT_DATA));
        lblQuantidadePedidos.setText(String.valueOf(r.getQuantidadePedidos()));
        lblDespesas.setText(FMT_BRL.format(r.getDespesas()));
        lblLucroTotal.setText(FMT_BRL.format(r.getLucroTotal()));

        if (r.getEstoqueFinal() != null) {
            lblEstoqueFinal.setText(FMT_BRL.format(r.getEstoqueFinal()));
        } else {
            lblEstoqueFinal.setText("—");
        }

        BigDecimal lucroLiquido = r.getLucroTotal().subtract(r.getDespesas());
        lblLucroLiquido.setText(FMT_BRL.format(lucroLiquido));
        lblLucroLiquido.setForeground(
                lucroLiquido.compareTo(BigDecimal.ZERO) >= 0 ? COR_VERDE : COR_VERMELHO);
    }

    private void mostrarVazio() {
        lblData.setText("Sem registro");
        lblQuantidadePedidos.setText("—");
        lblDespesas.setText("—");
        lblLucroTotal.setText("—");
        lblEstoqueFinal.setText("—");
        lblLucroLiquido.setText("—");
    }
}
