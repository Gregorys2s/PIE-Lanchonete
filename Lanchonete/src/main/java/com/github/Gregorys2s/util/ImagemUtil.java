package com.github.Gregorys2s.util;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public final class ImagemUtil {

    private ImagemUtil() {}

    public static ImageIcon carregar(String caminho, int largura, int altura) {
        ImageIcon icon = carregarOriginal(caminho);

        if (icon == null || icon.getIconWidth() <= 0) {
            return placeholder(largura, altura);
        }

        if (largura <= 0 || altura <= 0) {
            return icon;
        }

        Image imagem = icon.getImage().getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
        return new ImageIcon(imagem);
    }

    private static ImageIcon carregarOriginal(String caminho) {
        String normalizado = caminho.startsWith("/") ? caminho : "/" + caminho;

        URL url = ImagemUtil.class.getResource(normalizado);
        if (url != null) {
            return new ImageIcon(url);
        }

        String semBarra = normalizado.substring(1);
        String[] tentativas = {
                semBarra,
                "src/main/resources/" + semBarra,
                "target/classes/" + semBarra,
                "Lanchonete/src/main/resources/" + semBarra,
                "Lanchonete/target/classes/" + semBarra
        };

        for (String tentativa : tentativas) {
            File arquivo = new File(tentativa);
            if (arquivo.exists() && arquivo.isFile()) {
                return new ImageIcon(arquivo.getAbsolutePath());
            }
        }

        return null;
    }

    private static ImageIcon placeholder(int largura, int altura) {
        int w = largura > 0 ? largura : 48;
        int h = altura > 0 ? altura : 48;

        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(249, 115, 22));
        g.fillRoundRect(0, 0, w - 1, h - 1, 14, 14);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Segoe UI", Font.BOLD, Math.max(12, Math.min(w, h) / 3)));

        FontMetrics fm = g.getFontMetrics();
        String texto = "?";
        g.drawString(texto, (w - fm.stringWidth(texto)) / 2, (h + fm.getAscent()) / 2 - 3);

        g.dispose();

        return new ImageIcon(img);
    }
}