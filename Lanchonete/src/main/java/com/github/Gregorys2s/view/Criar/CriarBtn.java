package com.github.Gregorys2s.view.Criar;

import com.github.Gregorys2s.view.inicializacao.PanelRedondo;

import javax.swing.*;
import java.awt.*;

public class CriarBtn {

    public PanelRedondo criarBotaoProdutos(String texto) {

        PanelRedondo btn = new PanelRedondo();
        btn.setLayout(new BorderLayout());
        
        Dimension d = new Dimension(39, 40);
        btn.setPreferredSize(d);
        btn.setMinimumSize(d);
        btn.setMaximumSize(d);


        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 36));

        btn.add(label);

        return btn;
    }
}
