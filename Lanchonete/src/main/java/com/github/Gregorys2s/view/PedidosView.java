//package com.github.Gregorys2s.view;
//
//import com.github.Gregorys2s.controller.CardapioController;
//import com.github.Gregorys2s.controller.Leitores;
//import com.github.Gregorys2s.controller.PedidosController;
//import com.github.Gregorys2s.entity.Cardapio;
//import com.github.Gregorys2s.entity.ItemPedidos;
//import com.github.Gregorys2s.entity.Pagamento;
//import com.github.Gregorys2s.entity.Pedidos;
//import com.github.Gregorys2s.exceptions.AcharProdutoException;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class PedidosView {
//    PedidosController pedidosController;
//    CardapioView cardapioView;
//    CardapioController cardapioController;
//    Pagamento pagamento;
//
//    public PedidosView(PedidosController pedidosController, CardapioView cardapioView, CardapioController cardapioController, Pagamento pagamento) {
//        this.pedidosController = pedidosController;
//        this.cardapioView = cardapioView;
//        this.cardapioController = cardapioController;
//        this.pagamento = pagamento;
//    }
//
//    void menuPedido(Scanner sc) {
//        int escolha = 0;
//
//        do {
//            menuPrincipal();
//            escolha = Leitores.leitorInteger(sc);
//            switch (escolha) {
//                case 1 -> {
//                    iniciarPedido(sc);
//                }
//                case 2 -> {
//                    todosOsPedidos();
//                }
//
//                case 3 -> {
//                    finalizarPedido(sc);
//                }
//                case 4 -> {
//                    cancelarPedido(sc);
//                }
//                case 5 -> {
//                    removerItem(sc);
//                }
//                case 6 -> {System.out.println("Voltando pro menu");}
//                default -> {
//                    System.out.println("Digite uma das opcoes");
//                }
//            }
//        }while (escolha != 6);
//    }
//
//    void menuPrincipal()
//    {
//        System.out.println("1. Adicionar item ao pedido" +
//                "\n2. Ver todos os pedidos" +
//                "\n3. Concluir pedidos" +
//                "\n4. Cancelar pedido" +
//                "\n5. Remover Item" +
//                "\n6. Voltar ao menu");
//    }
//
//    private void todosOsPedidos()
//    {
//        List<Pedidos> pedidos = pedidosController.procurarPedidos();
//
//        for (Pedidos pedido : pedidos) {
//            System.out.println("Pedido #" + pedido.getId());
//
//            for (ItemPedidos item : pedido.getItens()) {
//                System.out.println(
//                        item.getProduto().getNome() +
//                                " | Qtd: " + item.getQuantidade() +
//                                " | Valor: " + item.getProduto().getPreco()
//                );
//            }
//
//            System.out.println("Adicionais: " + pedido.getAdicionais());
//            System.out.println("Valor Total: " + pedido.getValorTotal());
//            System.out.println("---------------------------");
//
//        }
//
//    }
//    void iniciarPedido(Scanner sc) {
//        //trocar nome de produto ou discutir um novo
//        Pedidos pedido = new Pedidos();
//        pedido.setItens(new ArrayList<>());
//
//        while (true) {
//
//            System.out.println("1.Agregar lanche\n2.colocar adicionais\n3.Finalizar pedido");
//
//            int escolha = Leitores.leitorInteger(sc);
//
//            switch (escolha) {
//
//                case 1 -> {
//                    ItemPedidos item = new ItemPedidos();
//                    System.out.println("Cardapio");
//                    cardapioView.mostrarCardapio();
//
//                    System.out.println("Digite o id");
//                    Integer id = Leitores.leitorInteger(sc);
//
//                    Cardapio produto = cardapioController.produtoSelecionadoId(id);
//                    if (produto == null)
//                    {
//                        System.out.println("Voltando ao menu");
//                        return;
//                    }
//
//                    System.out.println("Digite a quantidade");
//                    int quantidade = Leitores.leitorInteger(sc);
//                    item.setProduto(produto);
//
//                    item.setQuantidade(quantidade);
//                    item.setPedido(pedido);
//
//                    pedido.getItens().add(item);
//                }
//                case 2 -> {
//                    while (true) {
//                        System.out.println("Quanto e o valor do adicional");
//                        BigDecimal valorAdicinal = Leitores.leitorDecimais(sc);
//                        if (valorAdicinal.compareTo(BigDecimal.ZERO) < 0) {
//                            System.out.println("Digite um valor igual o maior que 0");
//                            continue;
//                        }
//
//                        pedido.setAdicionais(valorAdicinal);
//                        break;
//                    }
//                }
//                case 3 -> {
//                    pedidosController.guardarPedido(pedido);
//                    return;
//                }
//            }
//
//        }
//    }
//
//    void finalizarPedido(Scanner sc)
//    {
//        todosOsPedidos();
//        System.out.println("Digite o id do pedido");
//        int id = Leitores.leitorInteger(sc);
//        Pedidos pedido = pedidosController.procurarPorId(id);
//        if (pedido == null){
//            System.out.println("pedido nao encontrado");
//            return;
//        }
//
//        System.out.println("Digite o metodo de pagamento");
//        System.out.println("Pix || Credito || Debito || Dinheiro || Voltar ao menu");
//        int escolha;
//        do {
//            escolha = Leitores.leitorInteger(sc);
//
//            try {
//                BigDecimal valorPago;
//
//                switch (escolha)
//                {
//                    case 1 -> {
//                        valorPago = pedido.getValorTotal();
//                        pedidosController.finalizarPedido(pedido,"pix", valorPago);
//                    }
//                    case 2 -> {
//                        valorPago = pedido.getValorTotal();
//                        pedidosController.finalizarPedido(pedido,"credito",valorPago);
//                    }
//                    case 3 -> {
//                        valorPago = pedido.getValorTotal();
//                        pedidosController.finalizarPedido(pedido,"debito", valorPago);
//                    }
//                    case 4 -> {
//                        System.out.println("Digite o valor pago");
//                        valorPago = Leitores.leitorDecimais(sc);
//                        pedidosController.finalizarPedido(pedido,"dinheiro", valorPago);
//                        BigDecimal troco = pedidosController.calcularTroco(valorPago,pedido);
//                        if (troco.compareTo(BigDecimal.ZERO) > 0){
//                            System.out.println("troco: " + troco);
//                        }
//                    }
//                    case 5 -> {
//                        System.out.println("Voltando ao menu");
//                        return;
//                    }
//                    default -> {
//                        System.out.println("opcao invalida");
//                        continue;
//                    }
//                }
//
//                System.out.println("---pagamento efetuado com sucesso");
//                System.out.println("id do pedido: " + pedido.getId());
//                System.out.println("metodo de pagamento: " + pagamento.getPagamentoEnum());
//                System.out.println("valor: " + pagamento.getValorOriginal());
//
//                return;
//
//            }catch (IllegalArgumentException e){
//                System.out.println("erro: " + e.getMessage());
//            }
//
//        }while (escolha != 5);
//    }
//
//    void cancelarPedido (Scanner sc)
//    {
//        todosOsPedidos();
//        System.out.println("Digite o id do pedido que deseja cancelar");
//        int id = Leitores.leitorInteger(sc);
//        Pedidos pedido = pedidosController.procurarPorId(id);
//        pedidosController.apagarPedido(id);
//    }
//
//    void removerItem(Scanner sc)
//    {
//        todosOsPedidos();
//        System.out.println("De qual pedido vc quer remover os itens");
//        int id = Leitores.leitorInteger(sc);
//        Pedidos pedido = pedidosController.procurarPorId(id);
//        mostrarPedido(pedido);
//        System.out.println("Qual item deseja remover");
//        int item = Leitores.leitorInteger(sc);
//        try {
//            pedidosController.apagarItem(item);
//        }catch (AcharProdutoException e) {
//            System.out.println(e.getMessage());
//        }
//
//    }
//
//    void mostrarPedido(Pedidos pedido)
//    {
//        int i = 1;
//        for (ItemPedidos item : pedido.getItens()) {
//            System.out.println(
//                    "Item ID: " + item.getId() +
//                            " | Produto ID: " + item.getProduto().getId() +
//                            " | Nome: " + item.getProduto().getNome() +
//                            " | Qtd: " + item.getQuantidade() +
//                            " | Valor: " + item.getProduto().getPreco()
//            );
//        }
//    }
//}
