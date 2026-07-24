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

    private final PanelRedondo btnAdd;
    private final PanelRedondo btnMinus;

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

        btnMinus = criarBotaoProduto("-", TemaSistema.perigo(), TemaSistema.perigoEscuro());
        btnAdd = criarBotaoProduto("+", TemaSistema.sucesso(), TemaSistema.sucessoEscuro());

        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        botoes.setOpaque(false);
        botoes.add(btnMinus);
        botoes.add(btnAdd);

        add(textos, BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        MouseAdapter click = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Component origem = (Component) e.getSource();

                if (isFilhoDe(origem, btnAdd)) {
                    listener.onAdicionar(id);
                }

                if (isFilhoDe(origem, btnMinus)) {
                    listener.onRemover(id);
                }
            }
        };

        adicionarCliqueRecursivo(btnAdd, click);
        adicionarCliqueRecursivo(btnMinus, click);

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

    private PanelRedondo criarBotaoProduto(String texto, Color corNormal, Color corHover) {
        PanelRedondo botao = new PanelRedondo();
        botao.setLayout(new BorderLayout());

        Dimension tamanho = new Dimension(42, 36);
        botao.setPreferredSize(tamanho);
        botao.setMinimumSize(tamanho);
        botao.setMaximumSize(tamanho);

        botao.setBackground(corNormal);
        botao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 22));
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        botao.add(label, BorderLayout.CENTER);

        botao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botao.setBackground(corHover);
                botao.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botao.setBackground(corNormal);
                botao.repaint();
            }
        });

        return botao;
    }

    private void adicionarCliqueRecursivo(Component componente, MouseAdapter adapter) {
        componente.addMouseListener(adapter);

        if (componente instanceof Container container) {
            for (Component filho : container.getComponents()) {
                adicionarCliqueRecursivo(filho, adapter);
            }
        }
    }

    private boolean isFilhoDe(Component origem, Component pai) {
        Component atual = origem;

        while (atual != null) {
            if (atual == pai) {
                return true;
            }

            atual = atual.getParent();
        }

        return false;
    }

    public PanelRedondo getBtnAdd() {
        return btnAdd;
    }

    public PanelRedondo getBtnMinus() {
        return btnMinus;
    }

    public interface CardItemListener {
        void onAdicionar(Integer id);
        void onRemover(Integer id);
    }
}