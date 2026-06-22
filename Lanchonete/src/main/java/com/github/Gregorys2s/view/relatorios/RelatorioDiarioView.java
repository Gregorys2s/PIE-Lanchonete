package com.github.Gregorys2s.view.relatorios;

import com.github.Gregorys2s.controller.relatorios.Implementacoes.RelatorioController;
import com.github.Gregorys2s.model.entity.RelatorioDiario;
import com.github.Gregorys2s.view.tema.TemaSistema;

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
        setSize(450, 450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel painelPrincipal = new JPanel(new BorderLayout(0, 15));
        painelPrincipal.setBackground(TemaSistema.fundo());
        painelPrincipal.setBorder(new EmptyBorder(20, 20, 20, 20));

        painelPrincipal.add(criarPainelDados(),   BorderLayout.CENTER);
        painelPrincipal.add(criarPainelBotoes(), BorderLayout.SOUTH);
        
        setContentPane(painelPrincipal);
        TemaSistema.aplicar(this);
    }

    private JPanel criarPainelDados() {
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(TemaSistema.card());
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(TemaSistema.borda()),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        GridBagConstraints cLabel = new GridBagConstraints();
        cLabel.anchor = GridBagConstraints.WEST;
        cLabel.insets = new Insets(10, 10, 10, 10);
        cLabel.gridx = 0;

        GridBagConstraints cValor = new GridBagConstraints();
        cValor.anchor = GridBagConstraints.EAST;
        cValor.insets = new Insets(10, 10, 10, 10);
        cValor.gridx = 1;
        cValor.fill = GridBagConstraints.HORIZONTAL;
        cValor.weightx = 1.0;

        lblData               = criarLabelValor("—");
        lblQuantidadePedidos  = criarLabelValor("—");
        lblDespesas           = criarLabelValor("—", TemaSistema.perigo());
        lblLucroTotal         = criarLabelValor("—", TemaSistema.sucesso());
        lblEstoqueFinal       = criarLabelValor("—");
        lblLucroLiquido       = criarLabelValor("—", TemaSistema.sucesso());

        int linha = 0;

        adicionarLinha(painel, "Data:",              lblData,              cLabel, cValor, linha++);
        adicionarLinha(painel, "Qtd. de Pedidos:",   lblQuantidadePedidos, cLabel, cValor, linha++);
        adicionarLinha(painel, "Despesas:",           lblDespesas,          cLabel, cValor, linha++);
        adicionarLinha(painel, "Lucro Bruto:",        lblLucroTotal,        cLabel, cValor, linha++);
        adicionarLinha(painel, "Estoque Final:",      lblEstoqueFinal,      cLabel, cValor, linha++);
        adicionarLinha(painel, "LUCRO LÍQUIDO:",      lblLucroLiquido,      cLabel, cValor, linha++);

        return painel;
    }

    private void adicionarLinha(JPanel p, String textoLabel, JLabel lblValor,
                                GridBagConstraints cL, GridBagConstraints cV, int linha) {
        JLabel label = new JLabel(textoLabel);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setForeground(TemaSistema.textoSecundario());

        cL.gridy = linha;
        cV.gridy = linha;
        p.add(label,   cL);
        p.add(lblValor, cV);
        
        // Separador
        GridBagConstraints cSep = new GridBagConstraints();
        cSep.gridy = linha + 1;
        cSep.gridx = 0;
        cSep.gridwidth = 2;
        cSep.fill = GridBagConstraints.HORIZONTAL;
        JSeparator sep = new JSeparator();
        sep.setForeground(TemaSistema.borda());
        p.add(sep, cSep);
    }

    private JLabel criarLabelValor(String texto) {
        return criarLabelValor(texto, TemaSistema.texto());
    }

    private JLabel criarLabelValor(String texto, Color cor) {
        JLabel lbl = new JLabel(texto, SwingConstants.RIGHT);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lbl.setForeground(cor);
        return lbl;
    }

    private JPanel criarPainelBotoes() {
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        painelBotoes.setOpaque(false);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(e -> carregarRelatorioDoDia());

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose()); 

        painelBotoes.add(btnAtualizar);
        painelBotoes.add(btnFechar);

        return painelBotoes;
    }

    private void carregarRelatorioDoDia() {
        try {
            List<RelatorioDiario> todos = relatorioController.listarTodos();

            if (todos.isEmpty()) {
                mostrarVazio();
                return;
            }

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
                lucroLiquido.compareTo(BigDecimal.ZERO) >= 0 ? TemaSistema.sucesso() : TemaSistema.perigo());
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
