package com.github.Gregorys2s.view.cardapio;

import com.github.Gregorys2s.controller.CardapioController;
import com.github.Gregorys2s.entity.Cardapio;
import java.math.BigDecimal;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CardapioView extends AbstractTableModel {
       private final CardapioController cardapioController;
       private final String[] colunas = {"ID", "Nome", "Tipo", "Preco"};

    public CardapioView(CardapioController cardapioController) {
        this.cardapioController = cardapioController;
    }
    
    @Override
    public int getRowCount(){return cardapioController.obterLista().size();}
    
    @Override
    public int getColumnCount(){ return colunas.length;}
    
    @Override
    public String getColumnName(int column){return colunas[column];}
     
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return switch(columnIndex){
            case 0 -> Integer.class;
            case 3 -> BigDecimal.class;
            default -> String.class;
        };
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Cardapio item = cardapioController.obterLista().get(rowIndex);
        return switch(columnIndex)
        {
            case 0 -> item.getId();
            case 1 -> item.getNome();
            case 2 -> item.getTipo();
            case 3 -> item.getPreco();
            default -> null;
        };
    }
    
    public void atualizarDadosTabela()
    {
        fireTableDataChanged();
    }
//    public void setLista(List<Cardapio> novaLista)
//    {
//        this.cardapioLista = novaLista;
//        fireTableDataChanged();
//    }
}





