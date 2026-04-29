package com.github.Gregorys2s.view;

import com.github.Gregorys2s.controller.CaixaController;
import com.github.Gregorys2s.controller.CardapioController;
import com.github.Gregorys2s.controller.Leitores;
import com.github.Gregorys2s.controller.PedidosController;
import com.github.Gregorys2s.entity.Cardapio;

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

        int escolha = 0;
        Scanner sc = new Scanner(System.in);
        iniciarCaixa(sc);
        do{
            menuPrincipal();
            escolha = Leitores.leitorInteger(sc);


                switch (escolha) {
                    case 1 -> {
                        System.out.println("\nINICIANDO PEDIDO");
                        menuPedido();
                        iniciarPedido(sc);
                    }
                    case 2 -> {
                        System.out.println("\nEstoque");
                    }
                    case 3 -> { System.out.println("Saindo do sistema");
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
                "\n1. Iniciar Pedidos" +
                "\n2. Cardapio" +
                "\n3. Sair");
    }

    void menuPedido()
    {
        System.out.println("1. Adicionar item ao pedido" +
                "\n2. Adicionais" +
                "\n3. Visualizar pedido" +
                "\n4. Finalizar pedido");
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

    void iniciarPedido(Scanner sc)
    {
        //trocar nome de produto ou discutir um novo
        List<Cardapio> porduto = new ArrayList<>();
        while(true)
        {
            System.out.println("Produtos");
            cardapioView.mostrarCardapio(cardapioController.obterLista());
            System.out.println("Digite o id do produto a escolher");
            Integer id = Leitores.leitorInteger(sc);
            porduto.add(cardapioController.produtoSelecionado(id));
            System.out.println("Deseja escolher outro produto??");
            System.out.println("1.Sim\n2.Nao");
            Integer opcion = Leitores.leitorInteger(sc);
            if(opcion == 1)
            {
                System.out.println("okay :)");
            }
            else if(opcion == 2)
            {
                break;
            }

        }


        //aqui uma funcao que vai receber os valores que o usuario vai passar
    }

}
