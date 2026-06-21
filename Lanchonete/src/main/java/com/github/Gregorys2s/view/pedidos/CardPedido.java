package com.github.Gregorys2s.view.pedidos;

import com.github.Gregorys2s.view.inicializacao.PanelRedondo;
import com.github.Gregorys2s.view.tema.TemaSistema;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class CardPedido extends PanelRedondo {
    private JLabel nomeLabel;
    private JLabel precoLabel;
    private JLabel quantidadeLabel;
    private Integer quantidade;

    private final Color normalColor = SystemColor.activeCaption;

    public CardPedido(String nome, BigDecimal preco,Integer quantidade) {
        this.quantidade = quantidade;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(297, 60));
        setMinimumSize(new Dimension(297, 60));
        setMaximumSize(new Dimension(297, 60));

        setBackground(TemaSistema.card());

        setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 0));

        JTextArea nomeLabel = new JTextArea(nome);

        nomeLabel.setLineWrap(true);
        nomeLabel.setWrapStyleWord(true);
        nomeLabel.setEditable(false);
        nomeLabel.setOpaque(false);
        nomeLabel.setFocusable(false);
        nomeLabel.setForeground(TemaSistema.texto());

        nomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));

        precoLabel = new JLabel("   R$" + preco);
        precoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        precoLabel.setForeground(TemaSistema.textoSecundario());precoLabel.setForeground(TemaSistema.textoSecundario());

        quantidadeLabel = new JLabel("X Num");
        quantidadeLabel.setForeground(TemaSistema.primaria());

        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));


        content.add(nomeLabel);
        content.add(quantidadeLabel);
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
    }
}
