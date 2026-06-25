/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.github.Gregorys2s.view.relatorios;

import com.github.Gregorys2s.controller.relatorios.Implementacoes.RelatorioController;
import com.github.Gregorys2s.model.entity.RelatorioDiario;
import java.awt.*;
import java.math.BigDecimal;
import java.text.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import com.github.Gregorys2s.view.tema.TemaSistema;

/**
 *
 * @author pedro
 */
public class RelatoriosFrame extends javax.swing.JInternalFrame {
    
    private static final DateTimeFormatter FMT_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final NumberFormat FMT_BRL = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    private JLabel lblData;
    private JLabel lblQuantidadePedidos;
    private JLabel lblDespesas;
    private JLabel lblLucroTotal;
    private JLabel lblEstoqueFinal;
    private JLabel lblLucroLiquido;
    
    private final RelatorioController relatorioController;

    public RelatoriosFrame(RelatorioController relatorioController) {
        this.relatorioController = relatorioController;
        initComponents();
        configurarVisual();
        carregarRelatorioDoDia();
    }

    private void configurarVisual() {
        TemaSistema.aplicar(this);
        
        diarioAtualPane.setLayout(new BorderLayout(0, 15));
        diarioAtualPane.setBackground(TemaSistema.fundo());
        diarioAtualPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        diarioAtualPane.removeAll(); 
        diarioAtualPane.add(criarPainelDados(), BorderLayout.CENTER);
        diarioAtualPane.add(criarPainelBotoes(), BorderLayout.SOUTH);
        
        diarioAtualPane.revalidate();
        diarioAtualPane.repaint();
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
        adicionarLinha(painel, "Data do Relatório:", lblData, cLabel, cValor, linha++);
        adicionarLinha(painel, "Quantidade de Pedidos:", lblQuantidadePedidos, cLabel, cValor, linha++);
        adicionarLinha(painel, "Total de Despesas:", lblDespesas, cLabel, cValor, linha++);
        adicionarLinha(painel, "Lucro Bruto:", lblLucroTotal, cLabel, cValor, linha++);
        adicionarLinha(painel, "Estoque Final:", lblEstoqueFinal, cLabel, cValor, linha++);
        adicionarLinha(painel, "LUCRO LÍQUIDO:", lblLucroLiquido, cLabel, cValor, linha++);

        return painel;
    }

    private JPanel criarPainelBotoes() {
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        painelBotoes.setOpaque(false);

        JButton btnAtualizar = new JButton("Atualizar Dados");
        btnAtualizar.addActionListener(e -> carregarRelatorioDoDia());

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose()); 

        painelBotoes.add(btnAtualizar);
        painelBotoes.add(btnFechar);

        return painelBotoes;
    }

    private void adicionarLinha(JPanel p, String textoLabel, JLabel lblValor,
                                GridBagConstraints cL, GridBagConstraints cV, int linha) {
        JLabel label = new JLabel(textoLabel);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setForeground(TemaSistema.textoSecundario());

        cL.gridy = linha;
        cV.gridy = linha;
        p.add(label, cL);
        p.add(lblValor, cV);
        
        // Separador
        GridBagConstraints cSep = new GridBagConstraints();
        cSep.gridy = linha + 1;
        cSep.gridx = 0;
        cSep.gridwidth = 2;
        cSep.fill = GridBagConstraints.HORIZONTAL;
        cSep.insets = new Insets(0, 10, 0, 10);
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

    private void carregarRelatorioDoDia() {
        try {
            var todos = relatorioController.listarTodos();
            if (todos.isEmpty()) {
                mostrarVazio();
                return;
            }
            RelatorioDiario relatorio = todos.get(0);
            preencherCampos(relatorio);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar relatório:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
        lblLucroLiquido.setForeground(lucroLiquido.compareTo(BigDecimal.ZERO) >= 0 ? TemaSistema.sucesso() : TemaSistema.perigo());
    }

    private void mostrarVazio() {
        lblData.setText("Sem registro");
        lblQuantidadePedidos.setText("—");
        lblDespesas.setText("—");
        lblLucroTotal.setText("—");
        lblEstoqueFinal.setText("—");
        lblLucroLiquido.setText("—");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        diarioAtualPane = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Relatórios");
        getContentPane().setLayout(new java.awt.GridLayout(1, 1));

        javax.swing.GroupLayout diarioAtualPaneLayout = new javax.swing.GroupLayout(diarioAtualPane);
        diarioAtualPane.setLayout(diarioAtualPaneLayout);
        diarioAtualPaneLayout.setHorizontalGroup(
            diarioAtualPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );
        diarioAtualPaneLayout.setVerticalGroup(
            diarioAtualPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Diário", diarioAtualPane);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Semanal", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Pesquisar Dia", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Pesquisar Semana", jPanel5);

        getContentPane().add(jTabbedPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel diarioAtualPane;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
