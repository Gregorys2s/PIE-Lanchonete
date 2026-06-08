package com.github.Gregorys2s.view.Pagamentos;

import com.github.Gregorys2s.controller.pagamento.PagamentoController;
import com.github.Gregorys2s.controller.pagamento.dto.PagamentoDto;
import com.github.Gregorys2s.model.entity.Pagamento;
import com.github.Gregorys2s.model.service.pagamento.impl.PagamentoRecusadoException;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class PagamentoView extends JInternalFrame {

    private final PagamentoController pagamentoController;
    private final Integer idPedido;
    private final BigDecimal valor;

    private String metodoPagamento;
    private Pagamento pagamentoRealizado;

    private JButton btnPix;
    private JButton btnDebito;
    private JButton btnCredito;
    private JButton btnDinheiro;

    public PagamentoView(PagamentoController pagamentoController,
                         Integer idPedido,
                         BigDecimal valor) {
        this.pagamentoController = pagamentoController;
        this.idPedido = idPedido;
        this.valor = valor;
        initComponents();
    }

    private void initComponents() {
        setTitle("Pagamento");
        setClosable(true);
        setResizable(false);
        setSize(560, 320);

        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblTitulo = new JLabel("Escolha o método de pagamento", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));

        JLabel lblValor = new JLabel("Valor: R$ " + valor.toString(), SwingConstants.CENTER);
        lblValor.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        JPanel painelTopo = new JPanel(new GridLayout(2, 1, 0, 4));
        painelTopo.add(lblTitulo);
        painelTopo.add(lblValor);

        btnPix      = criarBotao("Pix",      new Color(0x4CAF50));
        btnDebito   = criarBotao("Débito",   new Color(0x1976D2));
        btnCredito  = criarBotao("Crédito",  new Color(0x7B1FA2));
        btnDinheiro = criarBotao("Dinheiro", new Color(0x795548));

        btnPix.addActionListener(e      -> processarNaMaquininha("PIX"));
        btnDebito.addActionListener(e   -> processarNaMaquininha("DEBITO"));
        btnCredito.addActionListener(e  -> processarNaMaquininha("CREDITO"));
        btnDinheiro.addActionListener(e -> processarDinheiro());

        JPanel painelBotoes = new JPanel(new GridLayout(1, 4, 10, 0));
        painelBotoes.add(btnPix);
        painelBotoes.add(btnDebito);
        painelBotoes.add(btnCredito);
        painelBotoes.add(btnDinheiro);

        painel.add(painelTopo, BorderLayout.NORTH);
        painel.add(painelBotoes, BorderLayout.CENTER);
        getContentPane().add(painel);
    }

    private JButton criarBotao(String texto, Color cor) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setBackground(cor);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(120, 72));
        return btn;
    }

    private void processarDinheiro() {
        try {
            PagamentoDto dto = new PagamentoDto(idPedido, valor, "DINHEIRO");
            pagamentoRealizado = pagamentoController.realizarPagamento(dto);
            metodoPagamento = "DINHEIRO";
            JOptionPane.showMessageDialog(this,
                    "Pagamento em dinheiro registrado com sucesso!",
                    "Pagamento", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void processarNaMaquininha(String metodo) {
        setBotoesHabilitados(false);

        JDialog dialogo = new JDialog();
        dialogo.setTitle("Aguardando maquininha...");
        dialogo.setModal(false);
        dialogo.add(new JLabel(
                "  Aguarde — apresente o cartão na maquininha...  ",
                SwingConstants.CENTER));
        dialogo.setSize(340, 80);
        dialogo.setLocationRelativeTo(this);
        dialogo.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialogo.setVisible(true);

        SwingWorker<Pagamento, Void> worker = new SwingWorker<>() {

            @Override
            protected Pagamento doInBackground() {
                PagamentoDto dto = new PagamentoDto(idPedido, valor, metodo);
                return pagamentoController.realizarPagamento(dto);
            }

            @Override
            protected void done() {
                dialogo.dispose();
                setBotoesHabilitados(true);
                try {
                    pagamentoRealizado = get();
                    metodoPagamento = metodo;

                    String comprovante = String.format(
                            "<html><b>Pagamento aprovado!</b><br>" +
                                    "Método: %s<br>Valor: R$ %s<br>NSU: %s<br>Aut: %s</html>",
                            metodo, valor,
                            pagamentoRealizado.getNsu(),
                            pagamentoRealizado.getCodigoAutorizacao());

                    JOptionPane.showMessageDialog(PagamentoView.this,
                            comprovante, "Aprovado", JOptionPane.INFORMATION_MESSAGE);
                    dispose();

                } catch (java.util.concurrent.ExecutionException ex) {
                    Throwable causa = ex.getCause();
                    if (causa instanceof PagamentoRecusadoException) {
                        JOptionPane.showMessageDialog(PagamentoView.this,
                                "Pagamento recusado:\n" + causa.getMessage(),
                                "Recusado", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(PagamentoView.this,
                                "Erro ao processar pagamento:\n" + causa.getMessage(),
                                "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        worker.execute();
    }

    private void setBotoesHabilitados(boolean habilitado) {
        btnPix.setEnabled(habilitado);
        btnDebito.setEnabled(habilitado);
        btnCredito.setEnabled(habilitado);
        btnDinheiro.setEnabled(habilitado);
    }

    public String getMetodoPagamento() { return metodoPagamento; }
    public Pagamento getPagamentoRealizado() { return pagamentoRealizado; }
}