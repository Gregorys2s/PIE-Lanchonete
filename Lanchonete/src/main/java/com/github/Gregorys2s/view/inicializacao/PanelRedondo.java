/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.Gregorys2s.view.inicializacao;
import java.awt.*;
import javax.swing.*;

public class PanelRedondo extends JPanel {

    private final int radius = 30;

    public PanelRedondo() {
        setOpaque(false);
    }

    @Override
protected void paintComponent(Graphics g) {

    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g.create();

    g2.setRenderingHint(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON
    );

    g2.setColor(getBackground());

    g2.fillRoundRect(
        0,
        0,
        getWidth(),
        getHeight(),
        radius,
        radius
    );
    
    g2.dispose();

    }
}