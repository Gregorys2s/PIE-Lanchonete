package com.github.Gregorys2s.view.pedidos;

import com.github.Gregorys2s.view.Criar.CriarBtn;
import com.github.Gregorys2s.view.inicializacao.PanelRedondo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import com.github.Gregorys2s.view.tema.TemaSistema;

public class CardItem extends PanelRedondo {

    private CardItemListener listener;
    private Integer id;
    private JLabel precoLabel;
    private CriarBtn criar = new CriarBtn();

    private final Color normalColor = TemaSistema.secundaria();
    private final Color hoverColor = TemaSistema.primaria();

    private PanelRedondo btnAdd;
    private PanelRedondo btnMinus;

    public CardItem(Integer id, String nome, BigDecimal preco, CardItemListener listener) {
        this.id = id;
        this.listener = listener;
        
        setLayout(new BorderLayout(10, 10));
        setPreferredSize(new Dimension(180, 140));
        setMinimumSize(new Dimension(180, 140));
        setMaximumSize(new Dimension(180, 140));

        setBackground(TemaSistema.card());
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(TemaSistema.borda(), 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JTextArea nomeArea = new JTextArea(nome);
        nomeArea.setLineWrap(true);
        nomeArea.setWrapStyleWord(true);
        nomeArea.setEditable(false);
        nomeArea.setOpaque(false);
        nomeArea.setFocusable(false);
        nomeArea.setFont(new Font("Segoe UI", Font.BOLD, 14));
        nomeArea.setForeground(TemaSistema.texto());
        nomeArea.setRows(2);

        precoLabel = new JLabel("R$ " + preco);
        precoLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        precoLabel.setForeground(TemaSistema.primaria());

        btnAdd = criar.criarBotaoProdutos("+");
        btnMinus = criar.criarBotaoProdutos("-");

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        bottom.setOpaque(false);
        bottom.add(btnMinus);
        bottom.add(btnAdd);

        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add(nomeArea);
        content.add(Box.createVerticalStrut(5));
        content.add(precoLabel);

        add(content, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        MouseAdapter click = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Object origem = e.getSource();
                if (origem == btnAdd || origem == CardItem.this) {
                    listener.onAdicionar(id);
                } else if (origem == btnMinus) {
                    listener.onRemover(id);
                }
            }
        };

        this.addMouseListener(click);
        btnAdd.addMouseListener(click);
        btnMinus.addMouseListener(click);
        
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));

        addHover(btnAdd, hoverColor, normalColor);
        addHover(btnMinus, hoverColor, normalColor);
    }

    private void addHover(JPanel panel, Color hover, Color normal) {
        panel.setBackground(normal);
        panel.setOpaque(true);
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                panel.setBackground(hover);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                panel.setBackground(normal);
            }
        });
    }

    public interface CardItemListener {
        void onAdicionar(Integer id);
        void onRemover(Integer id);
    }
}
