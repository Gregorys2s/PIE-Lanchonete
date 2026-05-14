package com.github.Gregorys2s.util;

import com.github.Gregorys2s.exceptions.TableSelectionException;

import javax.swing.*;
import java.util.List;

public class AcharNaTabela {

    public static <T> T selecionarItem(JTable tabela, List<T> items) {
        Integer linha = tabela.getSelectedRow();

        if(linha  == -1)
        {
            throw new TableSelectionException("Selecione um item da tabela.");
        }
        Integer indiceModel = tabela.convertRowIndexToModel(linha);
        return items.get(indiceModel);
    }

    public static <T> SelecaoTabela<T> selecionarComQtd(JTable tabela, List<T> items, String qtdMsg)
    {
        T item = selecionarItem(tabela, items);
        if(item == null)
        {
            throw new TableSelectionException("Selecione um item da tabela.");
        }
        Integer qtd = LeitoresSwing.lerInteger(qtdMsg);
        if(qtd == null || qtd <= 0) throw new TableSelectionException("Quantidade nao pode ser 0");
        return new SelecaoTabela<>(item, qtd);
    }
}
