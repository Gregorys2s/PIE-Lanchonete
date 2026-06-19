package com.github.Gregorys2s.view.caixa;

import com.github.Gregorys2s.controller.caixa.CaixaController;
import com.github.Gregorys2s.controller.caixa.DTO.AbrirCaixaRequest;
import com.github.Gregorys2s.controller.caixa.DTO.CaixaResponse;
import com.github.Gregorys2s.controller.caixa.DTO.MovimentoCaixaRequest;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

/**
 * @author Gregory
 * @coauthor Felipe (Felps)
 */
public class CaixaView extends javax.swing.JInternalFrame {

    // Instância global do controlador do Caixa
    private final CaixaController caixaController;

    /**
     * Construtor da View que recebe o controlador injetado
     */
    public CaixaView(CaixaController caixaController) {
        this.caixaController = caixaController;

        initComponents();

        // Remove as bordas padrão do JInternalFrame para encaixar perfeitamente no painel do menu
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(null);

        // Atualiza o saldo na tela assim que o Caixa abre
        atualizarSaldoNaTela();
    }

    /**
     * Busca o saldo atual no banco de dados e joga no JLabel da tela
     */
    public void atualizarSaldoNaTela() {
        try {
            if (caixaController != null) {
                CaixaResponse response = caixaController.obterCaixa();
                lblSaldo.setText("R$ " + response.saldo().toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar o saldo do caixa: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Ação do botão para ABRIR/ADICIONAR valor inicial ao caixa
     */
    private void btnAbrirCaixaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String textoValor = txtValorInicial.getText().trim();
            if (textoValor.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, digite um valor para abrir o caixa.");
                return;
            }

            BigDecimal valorInicial = new BigDecimal(textoValor);
            AbrirCaixaRequest request = new AbrirCaixaRequest(valorInicial);

            // Chama o controlador
            CaixaResponse response = caixaController.abrirCaixa(request);

            // Atualiza o visor de saldo e limpa o campo preenchido
            lblSaldo.setText("R$ " + response.saldo().toString());
            txtValorInicial.setText("");

            JOptionPane.showMessageDialog(this, "Caixa atualizado/aberto com sucesso!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Insira um valor numérico válido (Use ponto em vez de vírgula se necessário).", "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao abrir o caixa: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Ação do botão para REGISTRAR DESPESA (Saídas/Sangrias do caixa)
     */
    private void btnRegistrarDespesaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String textoDespesa = txtValorDespesa.getText().trim();
            if (textoDespesa.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, digite o valor da despesa.");
                return;
            }

            BigDecimal valorDespesa = new BigDecimal(textoDespesa);
            MovimentoCaixaRequest request = new MovimentoCaixaRequest(valorDespesa);

            // Chama o controlador
            CaixaResponse response = caixaController.registrarDespesa(request);

            // Atualiza o visor de saldo e limpa o campo
            lblSaldo.setText("R$ " + response.saldo().toString());
            txtValorDespesa.setText("");

            JOptionPane.showMessageDialog(this, "Despesa registrada com sucesso!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Insira um valor de despesa válido.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao registrar despesa: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Código gerado pelo NetBeans para montar os componentes visuais.
     * Ajustado com os nomes exatos de labels e botões de controle de fluxo de caixa.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipalCaixa = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panelSaldo = new javax.swing.JPanel();
        lblTextoSaldo = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        lblSubTituloEntradas = new javax.swing.JLabel();
        txtValorInicial = new javax.swing.JTextField();
        btnAbrirCaixa = new javax.swing.JButton();
        lblSubTituloSaidas = new javax.swing.JLabel();
        txtValorDespesa = new javax.swing.JTextField();
        btnRegistrarDespesa = new javax.swing.JButton();

        setBackground(new java.awt.Color(43, 43, 43));

        panelPrincipalCaixa.setBackground(new java.awt.Color(43, 43, 43));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 153, 0));
        lblTitulo.setText("Fluxo de Caixa");

        panelSaldo.setBackground(new java.awt.Color(51, 51, 51));
        panelSaldo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));

        lblTextoSaldo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTextoSaldo.setForeground(new java.awt.Color(153, 153, 153));
        lblTextoSaldo.setText("SALDO ATUAL EM CAIXA");

        lblSaldo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblSaldo.setForeground(new java.awt.Color(102, 255, 102));
        lblSaldo.setText("R$ 0.00");

        javax.swing.GroupLayout panelSaldoLayout = new javax.swing.GroupLayout(panelSaldo);
        panelSaldo.setLayout(panelSaldoLayout);
        panelSaldoLayout.setHorizontalGroup(
                panelSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelSaldoLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(panelSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblTextoSaldo))
                                .addContainerGap(232, Short.MAX_VALUE))
        );
        panelSaldoLayout.setVerticalGroup(
                panelSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelSaldoLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(lblTextoSaldo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        lblSubTituloEntradas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSubTituloEntradas.setForeground(new java.awt.Color(255, 255, 255));
        lblSubTituloEntradas.setText("Abertura / Adicionar Fundo de Caixa (Entrada)");

        txtValorInicial.setBackground(new java.awt.Color(51, 51, 51));
        txtValorInicial.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtValorInicial.setForeground(new java.awt.Color(255, 255, 255));
        txtValorInicial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        btnAbrirCaixa.setBackground(new java.awt.Color(0, 153, 51));
        btnAbrirCaixa.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAbrirCaixa.setForeground(new java.awt.Color(255, 255, 255));
        btnAbrirCaixa.setText("Confirmar Entrada");
        btnAbrirCaixa.setBorderPainted(false);
        btnAbrirCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirCaixaActionPerformed(evt);
            }
        });

        lblSubTituloSaidas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSubTituloSaidas.setForeground(new java.awt.Color(255, 255, 255));
        lblSubTituloSaidas.setText("Registrar Retirada / Pagamento / Despesa (Saída)");

        txtValorDespesa.setBackground(new java.awt.Color(51, 51, 51));
        txtValorDespesa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtValorDespesa.setForeground(new java.awt.Color(255, 255, 255));
        txtValorDespesa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        btnRegistrarDespesa.setBackground(new java.awt.Color(204, 0, 0));
        btnRegistrarDespesa.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnRegistrarDespesa.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarDespesa.setText("Confirmar Saída");
        btnRegistrarDespesa.setBorderPainted(false);
        btnRegistrarDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarDespesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalCaixaLayout = new javax.swing.GroupLayout(panelPrincipalCaixa);
        panelPrincipalCaixa.setLayout(panelPrincipalCaixaLayout);
        panelPrincipalCaixaLayout.setHorizontalGroup(
                panelPrincipalCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPrincipalCaixaLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(panelPrincipalCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblSubTituloSaidas)
                                        .addComponent(lblSubTituloEntradas)
                                        .addComponent(lblTitulo)
                                        .addComponent(panelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panelPrincipalCaixaLayout.createSequentialGroup()
                                                .addComponent(txtValorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnAbrirCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelPrincipalCaixaLayout.createSequentialGroup()
                                                .addComponent(txtValorDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnRegistrarDespesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        panelPrincipalCaixaLayout.setVerticalGroup(
                panelPrincipalCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPrincipalCaixaLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(lblTitulo)
                                .addGap(27, 27, 27)
                                .addComponent(panelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(lblSubTituloEntradas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelPrincipalCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnAbrirCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                        .addComponent(txtValorInicial))
                                .addGap(45, 45, 45)
                                .addComponent(lblSubTituloSaidas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelPrincipalCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtValorDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRegistrarDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelPrincipalCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelPrincipalCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Declaração de variáveis visuais controladas pelo Java/NetBeans
    private javax.swing.JButton btnAbrirCaixa;
    private javax.swing.JButton btnRegistrarDespesa;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblSubTituloEntradas;
    private javax.swing.JLabel lblSubTituloSaidas;
    private javax.swing.JLabel lblTextoSaldo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelPrincipalCaixa;
    private javax.swing.JPanel panelSaldo;
    private javax.swing.JTextField txtValorDespesa;
    private javax.swing.JTextField txtValorInicial;
}