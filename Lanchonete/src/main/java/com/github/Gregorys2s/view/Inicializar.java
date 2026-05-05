package com.github.Gregorys2s.view;

import com.github.Gregorys2s.controller.CaixaController;
import com.github.Gregorys2s.controller.Leitores;


import java.math.BigDecimal;

import java.util.Scanner;

public class Inicializar {
    private final CardapioView cardapioView;
    private final PedidosView pedidosview;
    private final CaixaController caixa;
    private final DespesasView despesasView;
    private final IngredientesView ingredientes;

    public Inicializar(CaixaController caixa, CardapioView cardapioView,PedidosView pedidosView, DespesasView despesasView,IngredientesView ingredientes) {
        this.caixa = caixa;
        this.cardapioView = cardapioView;
        this.pedidosview = pedidosView;
        this.despesasView = despesasView;
        this.ingredientes = ingredientes;
    }

    public void inicializarSistema() {
        Scanner sc = new Scanner(System.in);
        int escolha = 0;

        iniciarCaixa(sc);
        do {
            menuPrincipal();
            escolha = Leitores.leitorInteger(sc);


            switch (escolha) {
                case 1 -> {
                    System.out.println("\nPedido");
                    pedidosview.menuPedido(sc);
                }
                case 2 -> {
                    cardapioView.menu(sc);
                }
                case 3 -> {
                    ingredientes.menuPrincipal(sc);
                }
                case 4 -> {
                    despesasView.menuDespesas(sc);
                }
                case 5 -> {
                    System.out.println("Saindo do sistema");
                    caixa.encerrarCaixa();
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }

        } while (escolha != 5);

        fechamentoCaixa();
        sc.close();
    }

    void menuPrincipal() {
        System.out.println("Seja bem-vido" +
                "\n1. Pedidos" +
                "\n2. Cardapio" +
                "\n3. Estoque" +
                "\n4. Despesas" +
                "\n5. Sair");
    }

    public void iniciarCaixa(Scanner sc) {
        while (true) {
            try {
                System.out.println("Digite o valor inicial da caixa:");
                BigDecimal valor = Leitores.leitorDecimais(sc);
                caixa.iniciarCaixa(valor);
                System.out.println("Caixa aberta com: " + caixa.getsaldo());
                break;
            } catch (Exception e) {
                System.out.println("Error\n");
                System.out.println("Digite um valor em numeros");
            }
        }
    }

    public void fechamentoCaixa() {
        caixa.encerrarCaixa();
    }

}
