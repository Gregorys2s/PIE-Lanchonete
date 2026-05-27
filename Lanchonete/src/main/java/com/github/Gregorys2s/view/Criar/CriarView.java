package com.github.Gregorys2s.view.Criar;

import com.github.Gregorys2s.view.inicializacao.PanelRedondo;

import javax.swing.*;
import java.awt.*;

public class CriarView {

    public PanelRedondo criarBotao(String texto) {

        PanelRedondo btn = new PanelRedondo();
        btn.setLayout(new BorderLayout());
        btn.setPreferredSize(new Dimension(39, 40));
        btn.setMinimumSize(new Dimension(28, 28));
        btn.setMaximumSize(new Dimension(28, 28));


        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 36));

        btn.add(label);

        return btn;
    }
}
