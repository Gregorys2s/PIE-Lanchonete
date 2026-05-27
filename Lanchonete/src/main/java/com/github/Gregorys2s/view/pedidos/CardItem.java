package com.github.Gregorys2s.view.pedidos;

import com.github.Gregorys2s.view.Criar.CriarView;
import com.github.Gregorys2s.view.inicializacao.PanelRedondo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;

public class CardItem extends PanelRedondo {

    private JLabel nomeLabel;
    private JLabel precoLabel;
    CriarView criar = new CriarView();

    private final Color normalColor = SystemColor.activeCaption;
    private final Color hoverColor = new Color(120, 120, 140);

    private PanelRedondo btnAdd;
    private PanelRedondo btnMinus;

    public CardItem(String nome, BigDecimal preco) {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(140, 100));
        setBackground(SystemColor.activeCaption);

        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));


        nomeLabel = new JLabel(nome);
        nomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));


        precoLabel = new JLabel("R$ " + preco);
        precoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));


        btnAdd = criar.criarBotao("+");

        btnMinus = criar.criarBotao("-");


        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        bottom.setOpaque(false);
        bottom.add(btnMinus);
        bottom.add(btnAdd);


        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        content.add(nomeLabel);
        content.add(precoLabel);
        content.add(bottom);

        add(content, BorderLayout.CENTER);
        add(bottom,BorderLayout.SOUTH);

        //aqui quando for clicado no + ou - ele tem que acrescentar valor ou aumentar
        MouseAdapter click = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("clicado: " + nomeLabel.getText());
            }
        };

        addClickListener(click);

        addHover(btnAdd, hoverColor, normalColor);
        addHover(btnMinus, hoverColor, normalColor);
    }

    // opcional: eventos depois
    public PanelRedondo getBtnAdd() {
        return btnAdd;
    }

    public PanelRedondo getBtnMinus() {
        return btnMinus;
    }

    private void addClickListener(MouseAdapter adapter) {
        addMouseListener(adapter);
        btnAdd.addMouseListener(adapter);
        btnMinus.addMouseListener(adapter);
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


}