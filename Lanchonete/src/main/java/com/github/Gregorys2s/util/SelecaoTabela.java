/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.Gregorys2s.util;

import com.github.Gregorys2s.exceptions.AcharTabelaException;
import javax.swing.JTable;

/**
 *
 * @author pedro
 */
public class SelecaoTabela {
    public static Integer selecionarId(JTable tabela)
    {
        int linhaSelecionada = tabela.getSelectedRow();
    
        if (linhaSelecionada != -1) {
            // Converte o índice da linha caso a tabela esteja filtrada ou ordenada
            int modelIndex = tabela.convertRowIndexToModel(linhaSelecionada);

            // Pega o valor da primeira coluna (coluna 0)
            Object valor = tabela.getModel().getValueAt(modelIndex, 0);

            if (valor instanceof Integer) {
                return (Integer) valor;
            } else { 
                return Integer.parseInt(valor.toString());
            }
        } else {
            throw new AcharTabelaException("Id nao encontrado");
        }
    }
}
