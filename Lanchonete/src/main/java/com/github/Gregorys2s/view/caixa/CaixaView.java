package com.github.Gregorys2s.view.caixa;

import com.github.Gregorys2s.controller.caixa.CaixaController;
import com.github.Gregorys2s.controller.caixa.DTO.AbrirCaixaRequest;
import com.github.Gregorys2s.controller.caixa.DTO.CaixaResponse;
import com.github.Gregorys2s.controller.caixa.DTO.MovimentoCaixaRequest;
import com.github.Gregorys2s.view.tema.TemaSistema;
import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

/**
 * @author Gregory
 * @coauthor Felipe (Felps)
 */
public class CaixaView extends javax.swing.JInternalFrame {

    private final CaixaController caixaController;

    public CaixaView(CaixaController caixaController) {
        this.caixaController = caixaController;
        initComponents();
        configurarVisual();
        atualizarSaldoNaTela();
    }

    private void configurarVisual() {
        TemaSistema.aplicar(this);
        
        // Ajustes finos
        lblSaldo.setForeground(TemaSistema.sucesso());
        lblTitulo.setForeground(TemaSistema.primaria());
        panelSaldo.setBackground(TemaSistema.card());
        panelSaldo.setBorder(BorderFactory.createLineBorder(TemaSistema.primaria(), 2));
        
        btnAbrirCaixa.setBackground(TemaSistema.sucesso());
        btnRegistrarDespesa.setBackground(TemaSistema.perigo());
        
        // Remove as bordas padrão do JInternalFrame
        if (this.getUI() instanceof javax.swing.plaf.basic.BasicInternalFrameUI ui) {
            ui.setNorthPane(null);
        }
        this.setBorder(null);
    }

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

    private void btnAbrirCaixaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String textoValor = txtValorInicial.getText().trim();
            if (textoValor.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, digite um valor para abrir o caixa.");
                return;
            }

            BigDecimal valorInicial = new BigDecimal(textoValor.replace(",", "."));
            AbrirCaixaRequest request = new AbrirCaixaRequest(valorInicial);

            CaixaResponse response = caixaController.abrirCaixa(request);
            lblSaldo.setText("R$ " + response.saldo().toString());
            txtValorInicial.setText("");

            JOptionPane.showMessageDialog(this, "Caixa atualizado/aberto com sucesso!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Insira um valor numérico válido.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao abrir o caixa: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnRegistrarDespesaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String textoDespesa = txtValorDespesa.getText().trim();
            if (textoDespesa.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, digite o valor da despesa.");
                return;
            }

            BigDecimal valorDespesa = new BigDecimal(textoDespesa.replace(",", "."));
            MovimentoCaixaRequest request = new MovimentoCaixaRequest(valorDespesa);

            CaixaResponse response = caixaController.registrarDespesa(request);
            lblSaldo.setText("R$ " + response.saldo().toString());
            txtValorDespesa.setText("");

            JOptionPane.showMessageDialog(this, "Despesa registrada com sucesso!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Insira um valor de despesa válido.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao registrar despesa: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

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

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setText("Fluxo de Caixa");

        lblTextoSaldo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTextoSaldo.setText("SALDO ATUAL EM CAIXA");

        lblSaldo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblSaldo.setText("R$ 0.00");

        javax.swing.GroupLayout panelSaldoLayout = new javax.swing.GroupLayout(panelSaldo);
        panelSaldo.setLayout(panelSaldoLayout);
        panelSaldoLayout.setHorizontalGroup(
            panelSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSaldoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTextoSaldo))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        panelSaldoLayout.setVerticalGroup(
            panelSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSaldoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTextoSaldo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        lblSubTituloEntradas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSubTituloEntradas.setText("Abertura / Adicionar Fundo de Caixa (Entrada)");

        txtValorInicial.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnAbrirCaixa.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAbrirCaixa.setForeground(new java.awt.Color(255, 255, 255));
        btnAbrirCaixa.setText("Confirmar Entrada");
        btnAbrirCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirCaixaActionPerformed(evt);
            }
        });

        lblSubTituloSaidas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSubTituloSaidas.setText("Registrar Retirada / Pagamento / Despesa (Saída)");

        txtValorDespesa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnRegistrarDespesa.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnRegistrarDespesa.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarDespesa.setText("Confirmar Saída");
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
                .addGap(40, 40, 40)
                .addGroup(panelPrincipalCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSubTituloSaidas)
                    .addComponent(lblSubTituloEntradas)
                    .addComponent(lblTitulo)
                    .addComponent(panelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPrincipalCaixaLayout.createSequentialGroup()
                        .addComponent(txtValorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnAbrirCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalCaixaLayout.createSequentialGroup()
                        .addComponent(txtValorDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnRegistrarDespesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        panelPrincipalCaixaLayout.setVerticalGroup(
            panelPrincipalCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalCaixaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitulo)
                .addGap(30, 30, 30)
                .addComponent(panelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lblSubTituloEntradas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAbrirCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(txtValorInicial))
                .addGap(40, 40, 40)
                .addComponent(lblSubTituloSaidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
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
