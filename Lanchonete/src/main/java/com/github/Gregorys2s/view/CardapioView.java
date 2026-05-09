package com.github.Gregorys2s.view;

import com.github.Gregorys2s.controller.CardapioController;
import com.github.Gregorys2s.controller.Leitores;
import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.exceptions.CardapioControllerException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class CardapioView {

    private CardapioController cardapio ;

    public CardapioView(CardapioController cardapio) {
        this.cardapio = cardapio;
    }

    Scanner sc = new Scanner(System.in);

    public void menuCardapio(int escolha)
    {
        switch (escolha) {
            case 1: mostrarCardapio(); break;
            case 2: menuPesquisas(); break;
            case 3: menuAlteracoes(sc);
                break;
            default: throw new CardapioControllerException("Opcao invalida");
        }
    }



    void menu(Scanner sc)
    {
        System.out.println("1. Mostrar cardapio completo" +
                "\n2. Pesquisas/filtros" +
                "\n3. Menu de alteracoes");
        int escolha = Leitores.leitorInteger(sc);
        menuCardapio(escolha);
    }
    public void menuPesquisas()
    {
        System.out.println(
                "1. Procurar por nome" +
                        "\n2. Procurar por id" +
                        "\n3. Filtrar por tipo"
        );
        int escolha = Leitores.leitorInteger(sc);
        switch (escolha)
        {
            //oloco a IDE eh foda
            case 1, 2, 3: procuras(escolha);
                break;
            default: throw new CardapioControllerException("Opcao invalida");
        }
    }
    public void menuAlteracoes(Scanner sc)
    {
        System.out.println("1. Adicionar item ao cardapio" +
                "\n2. Remover item do cardapio" +
                "\n3. Atualizar item do cardapio" );
        int escolha = Leitores.leitorInteger(sc);
        switch (escolha)
        {
            case 1: cardapio.menuAlteracoes(escolha,cadastroCardapio(sc));//gregory sua logica ta muito estranha para ler, deu para entender mas ta ruim de ler
                break;
            case 2:cardapio.menuAlteracoes(escolha, removerItem(sc));
                break;
            case 3:cardapio.menuAlteracoes(escolha, atualizarItem(sc));
                break;
            default:
                break;
        }
    }


    private void procuras(int escolha)
    {
        //aqui falta adicionas os outros tipos de procuras id nome e tipo
        switch (escolha) {
            case 1:
                System.out.println("Nome do item");
                String nome = Leitores.leitorTextos(sc);
                List<Cardapio> item = cardapio.produtoSelecionadoNomeLista(nome);
                mostrarItem(item);
            break;
            case 2:
                System.out.println("Id do item");
                Integer id = Leitores.leitorInteger(sc);
                Cardapio itemId = cardapio.produtoSelecionadoId(id);
                mostrarItemUnico(itemId);
            break;
            case 3:
                System.out.println("Tipo do item do cardapio");
                String tipo = Leitores.leitorTextos(sc);
                List<Cardapio> tipos = cardapio.produtoSelecionadoTipoLista(tipo);
                mostrarItem(tipos);
            break;

        }

    }

    public void mostrarCardapio()
    {
        List<Cardapio> c = cardapio.obterLista();
        if(c.isEmpty()) {
            System.out.println("Lista de produtos vazia");
            return;
        }        System.out.printf("%-5s | %-20s | %-10s | %-10s%n", "ID", "NOME", "PRECO", "TIPO");
        for(Cardapio cardapio : c) {
            System.out.printf("%-5d | %-20s | %-10.2f | %-20s%n", cardapio.getId(), cardapio.getNome(), cardapio.getPreco(), cardapio.getTipo());
        }
    }
    public void mostrarCardapioIds()
    {
        List<Cardapio> c = cardapio.obterLista();
        if(c.isEmpty()) {
            System.out.println("Lista de produtos vazia");
            return;
        }
        System.out.printf("%-5s | %-20s \n", "ID", "NOME");
        for(Cardapio cardapio : c) {
            System.out.printf("%-5d | %-20s\n", cardapio.getId(), cardapio.getNome());
        }
    }

    private void mostrarItem(List<Cardapio> c)
    {
        if(c == null) {
            System.out.println("Lista de produtos vazia");
            return;
        }
        System.out.printf("%-5s | %-20s | %-10s%n | %-10s%n", "ID", "NOME", "PRECO", "TIPO");
        for(Cardapio cardapio : c) {
            System.out.printf("%-5d | %-20s | R$ %-8.2f | %-10s%n", cardapio.getId(), cardapio.getNome(), cardapio.getPreco(), cardapio.getTipo());
        }
    }
    private void mostrarItemUnico(Cardapio cardapio)
    {
        if(cardapio == null) {
            System.out.println("Produto nao encontrado");
            return;
        }
        System.out.printf("%-5d | %-20s | R$ %-8.2f | %-10s%n", cardapio.getId(), cardapio.getNome(), cardapio.getPreco(), cardapio.getTipo());
    }
    private Cardapio cadastroCardapio(Scanner sc)
    {
        Cardapio itemNovo = new Cardapio();
        System.out.println("Digite o nome do produto: ");
        String nome = Leitores.leitorTextos(sc);
        if(nome.isEmpty()){
            throw new CardapioControllerException("Operacao cancelada");
        }
        System.out.println("Digite o valor do produto: ");
        BigDecimal preco = Leitores.leitorDecimais(sc);
        if(preco.compareTo(BigDecimal.ZERO)<=0){
            throw new CardapioControllerException("Operacao cancelada");
        }
        System.out.println("Digite o tipo do produto: ");
        String tipo = Leitores.leitorTextos(sc);
        if(tipo.isEmpty()){
            throw new CardapioControllerException("Operacao cancelada");
        }
        itemNovo.setNome(nome);
        itemNovo.setPreco(preco);
        itemNovo.setTipo(tipo);
        return itemNovo;
    }

    private Cardapio removerItem(Scanner sc)
    {
        mostrarCardapioIds();
        System.out.println("Digite o id do produto: ");
        Integer achar = Leitores.leitorInteger(sc);

        return cardapio.produtoSelecionadoId(achar);
    }




    private Cardapio atualizarItem(Scanner sc)
    {
        mostrarCardapioIds();
        System.out.println("Digite o id do produto: ");
        Integer id = Leitores.leitorInteger(sc);
        Cardapio atualizar = cardapio.produtoSelecionadoId(id);
        if(atualizar != null){
            System.out.println("Digite o nome do produto ou " +
                    "digite continuar para \"atualizar\" o preco: ");
            cardapio.verificarInput("nome", atualizar::setNome, Leitores.leitorTextos(sc));
            System.out.println("Digite o valor do produto: ");
            cardapio.verificarInput("preco", precoConsumer(atualizar, sc),  Leitores.leitorTextos(sc));
            System.out.println("Digite o tipo do produto: ");
            cardapio.verificarInput("tipo", atualizar::setTipo, Leitores.leitorTextos(sc));
            return atualizar;
        } else {
            throw new CardapioControllerException("Produto nao encontrado");
        }
    }

    private Consumer<String> precoConsumer(Cardapio item, Scanner sc) {
        return valor -> {
                BigDecimal novoPreco = Leitores.leitorDecimais(sc);
                if(novoPreco.compareTo(BigDecimal.ZERO)<=0){throw new CardapioControllerException("Operacao cancelada");}
                item.setPreco(novoPreco);
        };
    }
}
