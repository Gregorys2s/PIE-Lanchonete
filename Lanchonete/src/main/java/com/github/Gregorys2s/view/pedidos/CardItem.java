package com.github.Gregorys2s.view.pedidos;

import com.github.Gregorys2s.view.Criar.CriarBtn;
import com.github.Gregorys2s.view.inicializacao.PanelRedondo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.List;

public class CardItem extends PanelRedondo {

    private CardItemListener listener;
    private Integer id;
    private JLabel nomeLabel;
    private JLabel precoLabel;
    CriarBtn criar = new CriarBtn();

    private final Color normalColor = SystemColor.activeCaption;
    private final Color hoverColor = new Color(120, 120, 140);

    private PanelRedondo btnAdd;
    private PanelRedondo btnMinus;

    public CardItem(Integer id,String nome, BigDecimal preco,CardItemListener listener) {

        this.id = id;
        this.listener = listener;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(170, 122));

        setBackground(normalColor);

        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));


        JTextArea nomeLabel = new JTextArea(nome);

        nomeLabel.setLineWrap(true);
        nomeLabel.setWrapStyleWord(true);
        nomeLabel.setEditable(false);
        nomeLabel.setOpaque(false);
        nomeLabel.setFocusable(false);
        nomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));

        nomeLabel.setRows(2);
        nomeLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));


        precoLabel = new JLabel("R$ " + preco);
        precoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));


        btnAdd = criar.criarBotaoProdutos("+");

        btnMinus = criar.criarBotaoProdutos("-");


        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        bottom.setOpaque(false);
        bottom.add(btnMinus);
        bottom.add(btnAdd);


        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));


        content.add(nomeLabel);
        content.add(precoLabel);

        nomeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        precoLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        add(content, BorderLayout.CENTER);
        add(bottom,BorderLayout.SOUTH);

        //aqui quando for clicado no + ou - ele tem que acrescentar valor ou aumentar
        MouseAdapter click = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                Object origem = e.getSource();

                if (origem == btnAdd) {
                }
                listener.onAdicionar(id);

                if(origem == btnMinus){}

            {
                listener.onRemover(id);
            }
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

    public interface CardItemListener {
        void onAdicionar(Integer id);
        void onRemover(Integer id);
    }



}