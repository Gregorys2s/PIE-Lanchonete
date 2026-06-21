package com.github.Gregorys2s.util;

import javax.swing.*;
import java.math.BigDecimal;

public class LeitoresSwing {

    public static Integer lerInteger(String mensagem) {
        while (true) {
            String input = JOptionPane.showInputDialog(mensagem);

            if (input == null) {
                return null; // usuário cancelou
            }

            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite um número válido!");
            }
        }
    }

    public static BigDecimal lerBigDecimal(String mensagem) {
        while (true) {
            String input = JOptionPane.showInputDialog(mensagem);

            if (input == null) {
                return null;
            }

            try {
                input = input.replace(",", ".");
                BigDecimal valor = new BigDecimal(input);

                if (valor.compareTo(BigDecimal.ZERO) < 0) {
                    JOptionPane.showMessageDialog(null, "Valor não pode ser negativo!");
                    continue;
                }

                return valor;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Digite um número válido!");
            }
        }
    }

    public static String lerTexto(String mensagem) {
        while (true) {
            String input = JOptionPane.showInputDialog(mensagem);

            if (input == null) {
                return null;
            }

            if (input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite algo!");
            } else {
                return input.trim();
            }
        }
    }
}