package com.github.Gregorys2s.view.Criar;

import com.github.Gregorys2s.view.inicializacao.PanelRedondo;

import javax.swing.*;
import java.awt.*;

public class CriarBtn {

    public PanelRedondo criarBotaoProdutos(String texto) {

        PanelRedondo btn = new PanelRedondo();
        btn.setLayout(new BorderLayout());

        Dimension d = new Dimension(36, 36);
        btn.setPreferredSize(d);
        btn.setMinimumSize(d);
        btn.setMaximumSize(d);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label.setForeground(Color.WHITE);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btn.add(label, BorderLayout.CENTER);

        return btn;
    }
}