package com.github.Gregorys2s.view.tema;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

public final class TemaSistema {

    public enum Modo {
        CLARO,
        ESCURO
    }

    private static Modo modoAtual = Modo.ESCURO;

    private TemaSistema() {}

    public static void alternarTema() {
        modoAtual = modoAtual == Modo.ESCURO
                ? Modo.CLARO
                : Modo.ESCURO;
    }

    public static boolean isEscuro() {
        return modoAtual == Modo.ESCURO;
    }

    public static String textoBotaoTema() {
        return isEscuro()
                ? "☀ Modo claro"
                : "🌙 Modo escuro";
    }

    public static Color fundo() {
        return isEscuro()
                ? new Color(24, 24, 27)
                : new Color(245, 245, 245);
    }

    public static Color painel() {
        return isEscuro()
                ? new Color(32, 32, 36)
                : Color.WHITE;
    }

    public static Color card() {
        return isEscuro()
                ? new Color(42, 42, 48)
                : Color.WHITE;
    }

    public static Color texto() {
        return isEscuro()
                ? new Color(245, 245, 245)
                : new Color(32, 32, 32);
    }

    public static Color textoSecundario() {
        return isEscuro()
                ? new Color(180, 180, 180)
                : new Color(90, 90, 90);
    }

    public static Color borda() {
        return isEscuro()
                ? new Color(70, 70, 75)
                : new Color(220, 220, 220);
    }

    public static Color primaria() {
        return new Color(255, 153, 0);
    }

    public static Color sucesso() {
        return new Color(34, 180, 95);
    }

    public static Color perigo() {
        return new Color(220, 53, 69);
    }

    public static Color secundaria() {
        return isEscuro()
                ? new Color(75, 75, 82)
                : new Color(108, 117, 125);
    }

    public static void aplicar(JFrame frame) {
        aplicar(frame.getContentPane());
        frame.repaint();
    }

    public static void aplicar(JInternalFrame frame) {
        aplicar(frame.getContentPane());
        frame.repaint();
    }

    public static void aplicar(Component componente) {
        if (componente == null) return;

        if (componente instanceof JPanel panel) {
            panel.setBackground(painel());
        }

        if (componente instanceof JLabel label) {
            label.setForeground(texto());
            label.setFont(new Font("Segoe UI", label.getFont().getStyle(), label.getFont().getSize()));
        }

        if (componente instanceof JButton botao) {
            estilizarBotao(botao);
        }

        if (componente instanceof JTextField campo) {
            estilizarCampo(campo);
        }

        if (componente instanceof JPasswordField campoSenha) {
            estilizarCampo(campoSenha);
        }

        if (componente instanceof JTable tabela) {
            estilizarTabela(tabela);
        }

        if (componente instanceof JScrollPane scroll) {
            scroll.setBorder(BorderFactory.createLineBorder(borda()));
            scroll.getViewport().setBackground(painel());
        }

        if (componente instanceof JComboBox<?> combo) {
            combo.setBackground(card());
            combo.setForeground(texto());
            combo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        }

        if (componente instanceof Container container) {
            for (Component filho : container.getComponents()) {
                aplicar(filho);
            }
        }
    }

    public static void estilizarBotao(JButton botao) {
        String textoBotao = botao.getText() == null
                ? ""
                : botao.getText().toLowerCase();

        if (
                textoBotao.contains("remover") ||
                        textoBotao.contains("deletar") ||
                        textoBotao.contains("cancelar") ||
                        textoBotao.contains("saída") ||
                        textoBotao.contains("despesa")
        ) {
            botao.setBackground(perigo());
        } else if (
                textoBotao.contains("voltar") ||
                        textoBotao.contains("tema") ||
                        textoBotao.contains("modo")
        ) {
            botao.setBackground(secundaria());
        } else if (
                textoBotao.contains("entrada") ||
                        textoBotao.contains("abrir") ||
                        textoBotao.contains("salvar")
        ) {
            botao.setBackground(sucesso());
        } else {
            botao.setBackground(primaria());
        }

        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 14));
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setOpaque(true);
        botao.setContentAreaFilled(true);
        botao.setBorder(new EmptyBorder(10, 16, 10, 16));
    }

    public static void estilizarBotaoMenu(JButton botao) {
        botao.setBackground(isEscuro()
                ? new Color(24, 24, 27)
                : Color.WHITE);

        botao.setForeground(isEscuro()
                ? new Color(210, 210, 210)
                : new Color(45, 45, 45));

        botao.setFont(new Font("Segoe UI", Font.BOLD, 20));
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setOpaque(true);
        botao.setContentAreaFilled(true);
        botao.setHorizontalAlignment(SwingConstants.LEFT);
        botao.setBorder(new EmptyBorder(10, 14, 10, 14));
        botao.setMaximumSize(new Dimension(180, 48));
    }

    public static void estilizarCampo(JTextField campo) {
        campo.setBackground(card());
        campo.setForeground(texto());
        campo.setCaretColor(texto());
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(borda()),
                new EmptyBorder(10, 12, 10, 12)
        ));
    }

    public static void estilizarTabela(JTable tabela) {
        tabela.setBackground(card());
        tabela.setForeground(texto());
        tabela.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabela.setRowHeight(38);
        tabela.setShowGrid(false);
        tabela.setIntercellSpacing(new Dimension(0, 0));
        tabela.setSelectionBackground(primaria());
        tabela.setSelectionForeground(Color.WHITE);

        JTableHeader header = tabela.getTableHeader();

        if (header != null) {
            header.setBackground(primaria());
            header.setForeground(Color.WHITE);
            header.setFont(new Font("Segoe UI", Font.BOLD, 14));
            header.setReorderingAllowed(false);
        }

        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        center.setBackground(card());
        center.setForeground(texto());

        for (int i = 0; i < tabela.getColumnCount(); i++) {
            tabela.getColumnModel().getColumn(i).setCellRenderer(center);
        }
    }
}