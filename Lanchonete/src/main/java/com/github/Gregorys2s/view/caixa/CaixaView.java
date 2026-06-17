package com.github.Gregorys2s.view.caixa;

import com.github.Gregorys2s.controller.caixa.CaixaController;
import com.github.Gregorys2s.controller.caixa.DTO.AbrirCaixaRequest;
import com.github.Gregorys2s.controller.caixa.DTO.MovimentoCaixaRequest;
import com.github.Gregorys2s.controller.caixa.DTO.CaixaResponse;
import com.github.Gregorys2s.util.LeitoresSwing;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class CaixaView extends JInternalFrame {

    private final CaixaController caixaController;

    private JLabel lblSaldo;
    private JButton btnValorInicial;
    private JButton btnAdicionarDespesa;
    private JButton btnFechar;

    public CaixaView(
            CaixaController caixaController
    ) {

        this.caixaController = caixaController;

        initComponents();

        atualizarSaldoTela();
    }

    private void initComponents() {

        setTitle("Controle de Caixa");
        setClosable(true);
        setIconifiable(true);
        setSize(420, 320);

        JPanel painelPrincipal = new JPanel();

        painelPrincipal.setLayout(
                new BoxLayout(
                        painelPrincipal,
                        BoxLayout.Y_AXIS
                )
        );

        painelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        20,
                        20,
                        20
                )
        );

        lblSaldo = new JLabel(
                "Saldo Atual: R$ 0,00"
        );

        lblSaldo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        lblSaldo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        btnValorInicial =
                new JButton(
                        "Abrir Caixa"
                );

        btnValorInicial.addActionListener(
                this::btnValorInicialActionPerformed
        );

        btnAdicionarDespesa =
                new JButton(
                        "Registrar Despesa"
                );

        btnAdicionarDespesa.addActionListener(
                this::btnAdicionarDespesaActionPerformed
        );

        btnFechar =
                new JButton(
                        "Fechar"
                );

        btnFechar.addActionListener(
                e -> dispose()
        );

        painelPrincipal.add(lblSaldo);
        painelPrincipal.add(Box.createVerticalStrut(20));
        painelPrincipal.add(btnValorInicial);
        painelPrincipal.add(Box.createVerticalStrut(10));
        painelPrincipal.add(btnAdicionarDespesa);
        painelPrincipal.add(Box.createVerticalStrut(10));
        painelPrincipal.add(btnFechar);

        add(painelPrincipal);
    }

    private void atualizarSaldoTela() {

        try {

            CaixaResponse response =
                    caixaController.obterCaixa();

            lblSaldo.setText(
                    "Saldo Atual: R$ "
                            + response.saldo()
            );

        } catch (Exception e) {

            lblSaldo.setText(
                    "Erro ao carregar saldo"
            );
        }
    }

    private void btnValorInicialActionPerformed(
            java.awt.event.ActionEvent evt
    ) {

        BigDecimal valorInicial =
                LeitoresSwing.lerBigDecimal(
                        "Digite o valor inicial:"
                );

        if (valorInicial == null) {
            return;
        }

        try {

            caixaController.abrirCaixa(

                    new AbrirCaixaRequest(
                            valorInicial
                    )

            );

            atualizarSaldoTela();

            JOptionPane.showMessageDialog(
                    this,
                    "Caixa aberto com sucesso!"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void btnAdicionarDespesaActionPerformed(
            java.awt.event.ActionEvent evt
    ) {

        BigDecimal valorDespesa =
                LeitoresSwing.lerBigDecimal(
                        "Digite o valor da despesa:"
                );

        if (valorDespesa == null) {
            return;
        }

        try {

            caixaController.registrarDespesa(

                    new MovimentoCaixaRequest(
                            valorDespesa
                    )

            );

            atualizarSaldoTela();

            JOptionPane.showMessageDialog(
                    this,
                    "Despesa registrada!"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}