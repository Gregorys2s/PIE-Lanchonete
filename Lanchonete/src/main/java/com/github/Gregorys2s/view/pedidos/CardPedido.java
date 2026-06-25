package com.github.Gregorys2s.view.pedidos;

import com.github.Gregorys2s.view.inicializacao.PanelRedondo;
import com.github.Gregorys2s.view.tema.TemaSistema;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class CardPedido extends PanelRedondo {

    private final JLabel precoLabel;
    private final JLabel quantidadeLabel;
    private Integer quantidade;

    public CardPedido(String nome, BigDecimal preco, Integer quantidade) {
        this.quantidade = quantidade;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(320, 68));
        setMinimumSize(new Dimension(260, 68));
        setMaximumSize(new Dimension(Integer.MAX_VALUE,68));
        setBackground(TemaSistema.isEscuro() ? new Color(31, 41, 55) : Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JTextArea nomeArea = new JTextArea(nome);
        nomeArea.setLineWrap(true);
        nomeArea.setWrapStyleWord(true);
        nomeArea.setEditable(false);
        nomeArea.setOpaque(false);
        nomeArea.setFocusable(false);
        nomeArea.setForeground(TemaSistema.texto());
        nomeArea.setFont(new Font("Segoe UI", Font.BOLD, 14));

        quantidadeLabel = new JLabel("x" + quantidade);
        quantidadeLabel.setForeground(TemaSistema.primaria());
        quantidadeLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));

        precoLabel = new JLabel("R$ " + preco);
        precoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        precoLabel.setForeground(TemaSistema.textoSecundario());

        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));
        content.add(nomeArea);
        content.add(Box.createHorizontalStrut(8));
        content.add(quantidadeLabel);
        content.add(Box.createHorizontalStrut(8));
        content.add(precoLabel);

        add(content, BorderLayout.CENTER);
    }

    public JLabel getQuantidadeLabel() {
        return quantidadeLabel;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        this.quantidadeLabel.setText("x" + quantidade);
    }
}
