package com.github.Gregorys2s.view.pedidos;

import com.github.Gregorys2s.view.inicializacao.PanelRedondo;
import com.github.Gregorys2s.view.tema.TemaSistema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;

public class CardItem extends PanelRedondo {

    private final CardItemListener listener;
    private final Integer id;

    private final Color normalColor = TemaSistema.isEscuro()
            ? new Color(31, 41, 55)
            : Color.WHITE;

    private final Color hoverColor = TemaSistema.isEscuro()
            ? new Color(45, 55, 72)
            : new Color(255, 247, 237);

    private final JButton btnAdd;
    private final JButton btnMinus;

    public CardItem(Integer id, String nome, BigDecimal preco, CardItemListener listener) {
        this.id = id;
        this.listener = listener;

        setLayout(new BorderLayout(0, 10));
        setPreferredSize(new Dimension(190, 145));
        setMinimumSize(new Dimension(190, 145));
        setMaximumSize(new Dimension(190, 145));
        setBackground(normalColor);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(TemaSistema.borda()),
                BorderFactory.createEmptyBorder(14, 14, 12, 14)
        ));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel nomeLabel = new JLabel("<html><body style='width:145px'>" + nome + "</body></html>");
        nomeLabel.setForeground(TemaSistema.texto());
        nomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        JLabel precoLabel = new JLabel("R$ " + preco);
        precoLabel.setForeground(TemaSistema.primaria());
        precoLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        JPanel textos = new JPanel();
        textos.setOpaque(false);
        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));
        textos.add(nomeLabel);
        textos.add(Box.createVerticalStrut(12));
        textos.add(precoLabel);

        btnMinus = criarBotaoProduto("-", TemaSistema.perigo());
        btnAdd = criarBotaoProduto("+", TemaSistema.sucesso());

        btnMinus.addActionListener(e -> listener.onRemover(id));
        btnAdd.addActionListener(e -> listener.onAdicionar(id));

        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        botoes.setOpaque(false);
        botoes.add(btnMinus);
        botoes.add(btnAdd);

        add(textos, BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(normalColor);
                repaint();
            }
        });
    }

    private JButton criarBotaoProduto(String texto, Color cor) {
        JButton botao = new JButton(texto);
        botao.setPreferredSize(new Dimension(36, 32));
        botao.setMinimumSize(new Dimension(36, 32));
        botao.setMaximumSize(new Dimension(36, 32));
        botao.setBackground(cor);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 18));
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setContentAreaFilled(true);
        botao.setOpaque(true);
        botao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return botao;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnMinus() {
        return btnMinus;
    }

    public interface CardItemListener {
        void onAdicionar(Integer id);
        void onRemover(Integer id);
    }
}