package com.github.Gregorys2s.view.tema;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
                ? new Color(17, 24, 39)
                : new Color(244, 247, 251);
    }

    public static Color painel() {
        return isEscuro()
                ? new Color(24, 31, 45)
                : new Color(255, 255, 255);
    }

    public static Color card() {
        return isEscuro()
                ? new Color(31, 41, 55)
                : Color.WHITE;
    }

    public static Color cardElevado() {
        return isEscuro()
                ? new Color(39, 52, 70)
                : new Color(255, 255, 255);
    }

    public static Color campo() {
        return isEscuro()
                ? new Color(15, 23, 42)
                : new Color(248, 250, 252);
    }

    public static Color menu() {
        return isEscuro()
                ? new Color(11, 18, 32)
                : new Color(255, 255, 255);
    }

    public static Color menuItem() {
        return isEscuro()
                ? new Color(17, 24, 39)
                : new Color(248, 250, 252);
    }

    public static Color menuItemHover() {
        return isEscuro()
                ? new Color(31, 41, 55)
                : new Color(239, 246, 255);
    }

    public static Color texto() {
        return isEscuro()
                ? new Color(248, 250, 252)
                : new Color(17, 24, 39);
    }

    public static Color textoSecundario() {
        return isEscuro()
                ? new Color(203, 213, 225)
                : new Color(100, 116, 139);
    }

    public static Color textoInvertido() {
        return Color.WHITE;
    }

    public static Color borda() {
        return isEscuro()
                ? new Color(51, 65, 85)
                : new Color(226, 232, 240);
    }

    public static Color primaria() {
        return new Color(249, 115, 22);
    }

    public static Color primariaHover() {
        return new Color(234, 88, 12);
    }

    public static Color primariaSuave() {
        return isEscuro()
                ? new Color(67, 44, 27)
                : new Color(255, 237, 213);
    }

    public static Color sucesso() {
        return new Color(34, 197, 94);
    }

    public static Color sucessoEscuro() {
        return new Color(22, 163, 74);
    }

    public static Color perigo() {
        return new Color(239, 68, 68);
    }

    public static Color perigoEscuro() {
        return new Color(220, 38, 38);
    }

    public static Color alerta() {
        return new Color(245, 158, 11);
    }

    public static Color info() {
        return new Color(59, 130, 246);
    }

    public static Color secundaria() {
        return isEscuro()
                ? new Color(71, 85, 105)
                : new Color(100, 116, 139);
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
            label.setFont(new Font("Segoe UI", label.getFont().getStyle(), Math.max(label.getFont().getSize(), 12)));
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

        if (componente instanceof JTextArea area) {
            area.setBackground(card());
            area.setForeground(texto());
            area.setCaretColor(texto());
            area.setFont(new Font("Segoe UI", area.getFont().getStyle(), Math.max(area.getFont().getSize(), 13)));
        }

        if (componente instanceof JTable tabela) {
            estilizarTabela(tabela);
        }

        if (componente instanceof JScrollPane scroll) {
            scroll.setBorder(BorderFactory.createLineBorder(borda()));
            scroll.getViewport().setBackground(fundo());
        }

        if (componente instanceof JComboBox<?> combo) {
            combo.setBackground(cardElevado());
            combo.setForeground(texto());
            combo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            combo.setBorder(BorderFactory.createLineBorder(borda()));
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
            configurarBotao(botao, perigo(), perigoEscuro(), Color.WHITE);
        } else if (
                textoBotao.contains("voltar") ||
                        textoBotao.contains("tema") ||
                        textoBotao.contains("modo")
        ) {
            configurarBotao(botao, secundaria(), menuItemHover(), Color.WHITE);
        } else if (
                textoBotao.contains("entrada") ||
                        textoBotao.contains("abrir") ||
                        textoBotao.contains("salvar") ||
                        textoBotao.contains("confirmar") ||
                        textoBotao.contains("finalizar") ||
                        textoBotao.contains("pagar")
        ) {
            configurarBotao(botao, sucesso(), sucessoEscuro(), Color.WHITE);
        } else {
            configurarBotao(botao, primaria(), primariaHover(), Color.WHITE);
        }
    }

    public static void configurarBotao(JButton botao, Color normal, Color hover, Color texto) {
        botao.setBackground(normal);
        botao.setForeground(texto);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 14));
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setOpaque(true);
        botao.setContentAreaFilled(true);
        botao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botao.setBorder(new EmptyBorder(10, 16, 10, 16));

        if (!Boolean.TRUE.equals(botao.getClientProperty("tema.hover.instalado"))) {
            botao.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    botao.setBackground(hover);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    botao.setBackground(normal);
                }
            });
            botao.putClientProperty("tema.hover.instalado", true);
        }
    }

    public static void estilizarBotaoMenu(JButton botao) {
        botao.setBackground(menuItem());
        botao.setForeground(isEscuro()
                ? new Color(226, 232, 240)
                : new Color(30, 41, 59));

        botao.setFont(new Font("Segoe UI", Font.BOLD, 15));
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setOpaque(true);
        botao.setContentAreaFilled(true);
        botao.setHorizontalAlignment(SwingConstants.CENTER);
        botao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botao.setBorder(new EmptyBorder(12, 16, 12, 16));
        botao.setMaximumSize(new Dimension(185, 50));
        botao.setPreferredSize(new Dimension(180, 50));

        if (!Boolean.TRUE.equals(botao.getClientProperty("tema.menu.hover.instalado"))) {
            botao.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    botao.setBackground(menuItemHover());
                    botao.setForeground(primaria());
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    botao.setBackground(menuItem());
                    botao.setForeground(isEscuro()
                            ? new Color(226, 232, 240)
                            : new Color(30, 41, 59));
                }
            });
            botao.putClientProperty("tema.menu.hover.instalado", true);
        }
    }

    public static void estilizarCampo(JTextField campo) {
        campo.setBackground(campo());
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
        tabela.setFillsViewportHeight(true);
        tabela.setBorder(BorderFactory.createLineBorder(borda()));

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