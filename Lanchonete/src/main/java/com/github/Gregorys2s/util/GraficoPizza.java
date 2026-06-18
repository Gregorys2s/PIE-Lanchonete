package com.github.Gregorys2s.util;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class GraficoPizza extends JPanel {

    private final Map<String, Integer> dados = new LinkedHashMap<>();

    private final Color[] cores = {
            Color.RED,
            Color.BLUE,
            Color.GREEN,
            Color.ORANGE,
            Color.MAGENTA,
            Color.CYAN,
            Color.PINK,
            Color.YELLOW
    };

    public GraficoPizza() {
        setBackground(Color.WHITE);
    }

    public void adicionarItem(String nome, int valor) {
        dados.put(nome, valor);
        repaint();
    }

    public void limpar() {
        dados.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (dados.isEmpty()) {
            g.drawString("Nenhum dado disponível", 20, 20);
            return;
        }

        Graphics2D g2 = (Graphics2D) g;

        int total = dados.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

        int inicio = 0;
        int indice = 0;

        int xGrafico = 20;
        int yGrafico = 20;
        int tamanho = 250;

        for (Map.Entry<String, Integer> item : dados.entrySet()) {

            int angulo = (int) Math.round(
                    item.getValue() * 360.0 / total
            );

            g2.setColor(cores[indice % cores.length]);

            g2.fillArc(
                    xGrafico,
                    yGrafico,
                    tamanho,
                    tamanho,
                    inicio,
                    angulo
            );

            inicio += angulo;
            indice++;
        }

        // legenda
        int xLegenda = 20;
        int yLegenda = yGrafico + tamanho + 30;

        indice = 0;

        for (Map.Entry<String, Integer> item : dados.entrySet()) {

            g2.setColor(cores[indice % cores.length]);
            g2.fillRect(xLegenda, yLegenda, 15, 15);

            double porcentagem = item.getValue() * 100.0 / total;

            g2.setColor(Color.BLACK);

            String texto = item.getKey() + " (" +
                    String.format("%.1f", porcentagem) + "%)";

            g2.drawString(texto, xLegenda + 20, yLegenda + 12);

            // Avança para o próximo item na mesma linha
            xLegenda += g2.getFontMetrics().stringWidth(texto) + 45;

            indice++;
        }
    }
}