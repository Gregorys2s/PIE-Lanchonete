package com.github.Gregorys2s.view;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    private JButton botaoCaixa = new JButton("Caixa");
    private JButton botaoCardapio = new JButton("Cardapio");
    private JButton botaoPedidos =  new JButton("Pedidos");
    private JButton botaoDespesas = new JButton("Despesas");
    private JButton botaoIngredientes = new JButton("Ingredientes");
    private JButton botaoSair = new JButton("Sair");

    public MenuPrincipal(){
        setTitle("MENU PRINCIPAL");
        setSize(400, 300);
        setLayout(new BorderLayout(10,10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titulo = new JLabel("Menu principal", SwingUtilities.CENTER);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(5, 1, 10, 10));

        painelBotoes.add(botaoCaixa);
        painelBotoes.add(botaoIngredientes);
        painelBotoes.add(botaoPedidos);
        painelBotoes.add(botaoDespesas);
        painelBotoes.add(botaoCardapio);
        painelBotoes.add(botaoSair);

        add(painelBotoes, BorderLayout.CENTER);
    }
    public JButton getBotaoCaixa(){return botaoCaixa;}
    public JButton getBotaoPedidos(){return botaoPedidos;}
    public JButton getBotaoIngredientes(){return botaoIngredientes;}
    public JButton getBotaoDespesas(){return botaoDespesas;}
    public JButton getBotaoSair(){return botaoSair;}
    public JButton getBotaoCardapio(){return botaoCardapio;}
}