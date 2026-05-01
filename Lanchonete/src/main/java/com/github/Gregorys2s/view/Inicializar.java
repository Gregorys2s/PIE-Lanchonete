/*package com.github.Gregorys2s.view;

import com.github.Gregorys2s.controller.CaixaController;
import com.github.Gregorys2s.controller.CardapioController;
import com.github.Gregorys2s.controller.Leitores;
import com.github.Gregorys2s.controller.PedidosController;
import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.entity.ItemPedidos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inicializar {

    private PedidosController pedidos;
    private CardapioView cardapioView;
    private CardapioController cardapioController;
    private CaixaController caixa;

    //tranformei em static os leitores
    //Leitores leitor = new Leitores();


    public Inicializar(PedidosController pedidos, CaixaController caixa, CardapioView cardapioView, CardapioController cardapioController) {
        this.pedidos = pedidos;
        this.caixa = caixa;
        this.cardapioView = cardapioView;
        this.cardapioController = cardapioController;
    }

    public void inicializarSistema()
    {
        Scanner sc = new Scanner(System.in);
        List<Cardapio> pedidosPendentes;
        int escolha = 0;

        iniciarCaixa(sc);
        do{
            menuPrincipal();
            escolha = Leitores.leitorInteger(sc);


                switch (escolha) {
                    case 1 -> {
                        System.out.println("\nPedido");
                        menuPedido(sc);
                    }
                    case 2 -> {
                        System.out.println("\nEstoque");
                    }
                    case 3 -> {

                    }
                    case 4 -> { System.out.println("Saindo do sistema");
                        caixa.encerrarCaixa();
                    }
                    default -> System.out.println("Opção inválida! Tente novamente.");
                }

        }while (escolha != 4);

        fechamentoCaixa();

    }

    void menuPrincipal()
    {
        System.out.println("Seja bem-vido" +
                "\n1. Pedidos" +
                "\n2. Cardapio" +
                "\n3. Estoque" +
                "\n3. Sair");
    }

    List<ItemPedidos> menuPedido(Scanner sc, List<ItemPedidos> pedidosPendentes)
    {
        System.out.println("1. Adicionar item ao pedido" +
                "\n2. inicar pedido" +
                "\n3. Concluir pedido" +
                "\n4. Voltar");
        int escolha = Leitores.leitorInteger(sc);
        switch (escolha)
        {
            case 1 -> {
                pedidosPendentes.add(iniciarPedido(sc));
                return pedidosPendentes;
            }
            case 2 -> {}

            case 3 -> {}

            default -> {}
        }
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

    public void fechamentoCaixa ()
    {
        caixa.encerrarCaixa();
    }

    public void opcoesDeEstoque(Scanner sc)
    {
        System.out.println("Menu");
        cardapioView.menu();
        int escolha = Leitores.leitorInteger(sc);
        cardapioView.menuCardapio(escolha);

    }

    ItemPedidos  iniciarPedido(Scanner sc)
    {
        //trocar nome de produto ou discutir um novo
        List<Cardapio> produto = new ArrayList<>();
        //aqui cria o adicinal e trabalha nesta base
        while(true)
        {
            System.out.println("Cardapio");
            cardapioView.mostrarCardapio();
            System.out.println("Digite o id");
            Integer id = Leitores.leitorInteger(sc);
            produto.add(cardapioController.produtoSelecionadoId(id));
            item.add(produto);
            System.out.println("1.adicionar outro lanche\n2.colocar adicionais\n3.Finalizar pedido");
            Integer opcion = Leitores.leitorInteger(sc);
            if(opcion == 1) {
                System.out.println("okay :)");
                //aqui deixa colocar mais lanches
            } else if (opcion == 2) {
                //aqui coloca adicionais
                //aqui uma funcao para adicionar os produtos no
            } else if(opcion == 3)
            {
                //retorna a lista do pedido
                return produto;
            }

        }


        //aqui uma funcao que vai receber os valores que o usuario vai passar
    }

}
*/