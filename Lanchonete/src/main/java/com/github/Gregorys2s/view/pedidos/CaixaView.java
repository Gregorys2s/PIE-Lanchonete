package com.github.Gregorys2s.view.pedidos;

import com.github.Gregorys2s.controller.CaixaController;
import com.github.Gregorys2s.entity.Despesas;
import com.github.Gregorys2s.repositories.DespesasRepository;
import com.github.Gregorys2s.util.LeitoresSwing;
import com.github.Gregorys2s.exceptions.CaixaControllerException;
import com.github.Gregorys2s.exceptions.PersistenciaDespesasRepositoryException;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CaixaView extends javax.swing.JInternalFrame {

    private final CaixaController caixaController;
    private final DespesasRepository despesasRepository;

    private JLabel lblSaldo;
    private JButton btnValorInicial;
    private JButton btnAdicionarDespesa;
    private JButton btnFechar;

    public CaixaView(CaixaController caixaController, DespesasRepository despesasRepository) {
        this.caixaController = caixaController;
        this.despesasRepository = despesasRepository;
        initComponents();
        atualizarSaldoTela();
    }

    private void initComponents() {
        setTitle("Controle de Caixa e Despesas");
        setClosable(true);
        setIconifiable(true);
        setSize(420, 320);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        lblSaldo = new JLabel("Saldo Atual em Caixa: R$ 0.00");
        lblSaldo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblSaldo.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnValorInicial = new JButton("Definir Valor Inicial (Abertura)");
        btnValorInicial.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        btnValorInicial.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnValorInicial.addActionListener(this::btnValorInicialActionPerformed);

        btnAdicionarDespesa = new JButton("Registrar e Abater Despesa");
        btnAdicionarDespesa.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        btnAdicionarDespesa.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAdicionarDespesa.addActionListener(this::btnAdicionarDespesaActionPerformed);

        btnFechar = new JButton("Fechar");
        btnFechar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        btnFechar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnFechar.addActionListener(e -> this.dispose());

        painelPrincipal.add(Box.createVerticalGlue());
        painelPrincipal.add(lblSaldo);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
        painelPrincipal.add(btnValorInicial);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        painelPrincipal.add(btnAdicionarDespesa);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));
        painelPrincipal.add(btnFechar);
        painelPrincipal.add(Box.createVerticalGlue());

        getContentPane().add(painelPrincipal);
    }

    private void atualizarSaldoTela() {
        try {
            BigDecimal saldo = caixaController.getsaldo();
            lblSaldo.setText("Saldo Atual em Caixa: R$ " + saldo.toString());

            if (saldo.compareTo(BigDecimal.ZERO) >= 0) {
                lblSaldo.setForeground(new Color(0, 128, 0));
            } else {
                lblSaldo.setForeground(Color.RED);
            }
        } catch (Exception e) {
            lblSaldo.setText("Erro ao carregar saldo");
            lblSaldo.setForeground(Color.BLACK);
        }
    }

    private void btnValorInicialActionPerformed(java.awt.event.ActionEvent evt) {
        BigDecimal valorInicial = LeitoresSwing.lerBigDecimal("Digite o valor inicial para abertura do caixa:");
        if (valorInicial == null) return;

        try {
            caixaController.adicionarValor(valorInicial);
            JOptionPane.showMessageDialog(this, "Caixa iniciado com R$ " + valorInicial + " com sucesso!");
            atualizarSaldoTela();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao definir valor inicial: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnAdicionarDespesaActionPerformed(java.awt.event.ActionEvent evt) {
        BigDecimal valorDespesa = LeitoresSwing.lerBigDecimal("Digite o valor da despesa:");
        if (valorDespesa == null) return;

        try {
            caixaController.removerValor(valorDespesa);

            Despesas novaDespesa = new Despesas();
            novaDespesa.setValorDespesa(valorDespesa);
            novaDespesa.setDataHora(LocalDateTime.now());

            despesasRepository.save(novaDespesa);

            JOptionPane.showMessageDialog(this, "Despesa de R$ " + valorDespesa + " lançada e abatida com sucesso!");
            atualizarSaldoTela();

        } catch (CaixaControllerException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Saldo Insuficiente", JOptionPane.WARNING_MESSAGE);
        } catch (PersistenciaDespesasRepositoryException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
    }
}