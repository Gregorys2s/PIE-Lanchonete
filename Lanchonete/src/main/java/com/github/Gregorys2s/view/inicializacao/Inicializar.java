package com.github.Gregorys2s.view.inicializacao;

import com.github.Gregorys2s.controller.CaixaController;
import com.github.Gregorys2s.view.despesas.DespesasView;
// com.github.Gregorys2s.view.pedidos.PedidosView;
import com.github.Gregorys2s.view.cardapio.*;
//import com.github.Gregorys2s.view.ingredientes.IngredientesView;

import javax.swing.*;

public class Inicializar extends JFrame {
    private final CardapioView cardapioView;
    //private final PedidosView pedidosView;
    private final CaixaController caixa;
    private final DespesasView despesasView;
    //private final IngredientesView ingredientes;

    public Inicializar(CaixaController caixa, CardapioView cardapioView/*PedidosView pedidosView*/, DespesasView despesasView) {
        this.caixa = caixa;
        this.cardapioView = cardapioView;
        //this.pedidosView = pedidosView;
        this.despesasView = despesasView;
//        this.ingredientes = ingredientes;
    }

    public void inicializarSistema() {
//        SwingUtilities.invokeLater(() -> {

//            menuFelipe menu = new menuFelipe();
//
//            menu.getBotaoCaixa().addActionListener(e -> caixa.setVisible(true));
////            menu.getBotaoCardapio().addActionListener(e -> cardapioView.setVisible(true));
//            menu.getBotaoPedidos().addActionListener(e -> pedidosView.setVisible(true));
//            menu.getBotaoDespesas().addActionListener(e -> despesasView.setVisible(true));
////            menu.getBotaoIngredientes().addActionListener(e -> ingredientes.setVisible(true));
//
//            menu.getBotaoSair().addActionListener(e -> System.exit(0));
//            menu.setVisible(true);
//        });
    }
}
