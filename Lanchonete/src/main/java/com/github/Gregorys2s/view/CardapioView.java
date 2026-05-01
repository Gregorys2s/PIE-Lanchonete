package com.github.Gregorys2s.view;

import com.github.Gregorys2s.controller.CardapioController;
import com.github.Gregorys2s.controller.Leitores;
import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.exceptions.CardapioControllerException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

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



    void menu()
    {
        System.out.println("1. Mostrar cardapio completo" +
                "\n2. Pesquisas/filtros" +
                "\n3. Menu de alteracoes");
        int escolha = Leitores.leitorInteger(sc);
        switch (escolha)
        {
            case 1: mostrarCardapio();
                break;
            case 2:
                break; //colcar as outras opcoes
            case 3:
                break;

        }
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
            case 1: procuras(escolha);
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
    }
    public void menuAlteracoes(Scanner sc)
    {
        System.out.println("1. Adicionar item ao cardapio" +
                "\n2. Remover item do cardapio" +
                "\n3. Atualizar item do cardapio" /*+
                "\n4. Atualizar ingredientes de item do cardapio"*/);
        int escolha = Leitores.leitorInteger(sc);
        switch (escolha)
        {
            case 1: cardapio.menuAlteracoes(escolha,cadastroCardapio(sc));
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
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

    private void procuras(int escolha)
    {
        //aqui falta adicionas os outros tipos de procuras id nome e tipo
        if (escolha == 1)
        {
            System.out.println("Nome do item");
            String nome = Leitores.leitorTextos(sc);
            Cardapio item = cardapio.produtoSelecionadoNome(nome);
            mostrarItem(item);
        }
    }

    public void mostrarCardapio()
    {
        List<Cardapio> c = cardapio.obterLista();
        if(c.isEmpty()) {
            System.out.println("Lista de produtos vazia");
            return;
        }        System.out.printf("%-5s | %-20s | %-10s%n | %-10s%n", "ID", "NOME", "PRECO", "TIPO");
        for(Cardapio cardapio : c) {
            System.out.printf("%-5d | %-20s | %-10.2f%n | %-20s%n", cardapio.getId(), cardapio.getNome(), cardapio.getPreco(), cardapio.getTipo());
        }
    }
    public void mostrarCardapioIds()
    {
        List<Cardapio> c = cardapio.obterLista();
        if(c.isEmpty()) {
            System.out.println("Lista de produtos vazia");
            return;
        }
        System.out.printf("%-5s | %-20s ", "ID", "NOME");
        for(Cardapio cardapio : c) {
            System.out.printf("%-5d | %-20s", cardapio.getId(), cardapio.getNome());
        }
    }

    private void mostrarItem(Cardapio c)
    {
        if(c == null) {
            System.out.println("Lista de produtos vazia");
            return;
        }
        System.out.printf("%-5s | %-20s | %-10s%n | %-10s%n", "ID", "NOME", "PRECO", "TIPO");
    }
}
