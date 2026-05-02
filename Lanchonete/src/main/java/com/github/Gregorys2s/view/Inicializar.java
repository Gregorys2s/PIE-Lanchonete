package com.github.Gregorys2s.view;

import com.github.Gregorys2s.controller.CaixaController;
import com.github.Gregorys2s.controller.CardapioController;
import com.github.Gregorys2s.controller.Leitores;
import com.github.Gregorys2s.controller.PedidosController;
import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.entity.ItemPedidos;
import com.github.Gregorys2s.entity.Pedidos;
import org.postgresql.jdbc.SslMode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inicializar {

    private PedidosController pedidosController;
    private CardapioView cardapioView;
    private CardapioController cardapioController;
    private CaixaController caixa;

    //tranformei em static os leitores
    //Leitores leitor = new Leitores();


    public Inicializar(PedidosController pedidos, CaixaController caixa, CardapioView cardapioView, CardapioController cardapioController) {
        this.pedidosController = pedidos;
        this.caixa = caixa;
        this.cardapioView = cardapioView;
        this.cardapioController = cardapioController;
    }

    public void inicializarSistema() {
        Scanner sc = new Scanner(System.in);
        List<ItemPedidos> pedidosPendentes = new ArrayList<>();
        int escolha = 0;

        iniciarCaixa(sc);
        do {
            menuPrincipal();
            escolha = Leitores.leitorInteger(sc);


            switch (escolha) {
                case 1 -> {
                    System.out.println("\nPedido");
                    menuPedido(sc, pedidosPendentes);
                }
                case 2 -> {
                    System.out.println("\nEstoque");
                }
                case 3 -> {

                }
                case 4 -> {
                    System.out.println("Saindo do sistema");
                    caixa.encerrarCaixa();
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }

        } while (escolha != 4);

        fechamentoCaixa();

    }

    void menuPrincipal() {
        System.out.println("Seja bem-vido" +
                "\n1. Pedidos" +
                "\n2. Cardapio" +
                "\n3. Estoque" +
                "\n3. Sair");
    }

    void menuPedido(Scanner sc, List<ItemPedidos> pedidosPendentes) {
        System.out.println("1. Adicionar item ao pedido" +
                "\n2. Ver todos os pedidos" +
                "\n3. Concluir pedidos" +
                "\n4. Voltar");
        int escolha = Leitores.leitorInteger(sc);
        switch (escolha) {
            case 1 -> {
                iniciarPedido(sc);
            }
            case 2 -> {
                todosOsPedidos();
            }

            case 3 -> {
            }

            default -> {
            }
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

    public void fechamentoCaixa() {
        caixa.encerrarCaixa();
    }

    public void opcoesDeEstoque(Scanner sc) {
        System.out.println("Menu");
        cardapioView.menu();
        int escolha = Leitores.leitorInteger(sc);
        cardapioView.menuCardapio(escolha);

    }

    void iniciarPedido(Scanner sc) {
        //trocar nome de produto ou discutir um novo
        Pedidos pedido = new Pedidos();
        pedido.setItens(new ArrayList<>());

        while (true) {

            System.out.println("1.Agregar lanche\n2.colocar adicionais\n3.Finalizar pedido");

            int escolha = Leitores.leitorInteger(sc);

            switch (escolha) {

                case 1 -> {
                    ItemPedidos item = new ItemPedidos();
                    System.out.println("Cardapio");
                    cardapioView.mostrarCardapio();

                    System.out.println("Digite o id");
                    Integer id = Leitores.leitorInteger(sc);

                    Cardapio produto = cardapioController.produtoSelecionadoId(id);

                    System.out.println("Digite a quantidade");
                    int quantidade = Leitores.leitorInteger(sc);
                    item.setProduto(produto);

                    item.setQuantidade(quantidade);
                    item.setPedido(pedido);

                    pedido.getItens().add(item);
                }
                case 2 -> {
                    while (true) {
                        System.out.println("Quanto e o valor do adicional");
                        BigDecimal valorAdicinal = Leitores.leitorDecimais(sc);
                        if (valorAdicinal.compareTo(BigDecimal.ZERO) < 0) {
                            System.out.println("Digite um valor igual o maior que 0");
                            continue;
                        }

                        pedido.setAdicionais(valorAdicinal);
                        break;
                    }
                }
                case 3 -> {
                    pedido.setValorTotal(calcularTotal(pedido));
                    pedidosController.guardarPedido(pedido);
                    return;
                }
            }

        }
    }

    BigDecimal calcularTotal(Pedidos pedido)
    {
        BigDecimal valorTotal = BigDecimal.ZERO;

        for (int i = 0;i <  pedido.getItens().size();i++)
        {
            int quantidade = pedido.getItens().get(i).getQuantidade();
            BigDecimal preco = pedido.getItens().get(i).getProduto().getPreco();
            BigDecimal subtotal = preco.multiply(BigDecimal.valueOf(quantidade));
            valorTotal = valorTotal.add(subtotal);
        }
        valorTotal = valorTotal.add(pedido.getAdicionais());
        return valorTotal;
    }

    private void todosOsPedidos()
    {
        List<Pedidos> pedidos = pedidosController.procurarPedidos();
        int contador = 1;

        for (Pedidos pedido : pedidos) {
            System.out.println("Pedido #" + contador);

            for (ItemPedidos item : pedido.getItens()) {
                System.out.println(
                        item.getProduto().getNome() +
                                " | Qtd: " + item.getQuantidade() +
                                " | Valor: " + item.getProduto().getPreco()
                );
            }

            System.out.println("Adicionais: " + pedido.getAdicionais());
            System.out.println("Valor Total: " + pedido.getValorTotal());
            System.out.println("---------------------------");

            contador++;
        }

    }

}
