package com.github.Gregorys2s.view;

import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.service.CardapioService;

import java.util.List;

public class CardapioView {
    private CardapioService cardapioService;
    void menuCardapio()
    {
        System.out.println("1. Mostrar cardapio completo" +
                "\n2. Pesquisas/filtros" +
                "\n3. Menu de alteracoes");
    }
    public void menuPesquisas()
    {
        System.out.println(
                "1. Procurar por nome" +
                        "\n2. Procurar por id" +
                        "\n3. Filtrar por tipo"
        );
    }
    public void menuAlteracoes()
    {
        System.out.println("1. Adicionar item ao cardapio" +
                "\n2. Remover item do cardapio" +
                "\n3. Atualizar item do cardapio" /*+
                "\n4. Atualizar ingredientes de item do cardapio"*/);
    }
    public void mostrarCardapio()
    {
        List<Cardapio> todos = cardapioService.obterListaInteira();
        System.out.printf("%-5s | %-20s | %-10s%n | %-10s%n", "ID", "NOME", "PRECO", "TIPO");
        for(Cardapio cardapio : todos) {
            System.out.printf("%-5d | %-20s | %-10.2f%n | %-20s%n", cardapio.getId(), cardapio.getNome(), cardapio.getPreco(), cardapio.getTipo());
        }
    }
    public void mostrarCardapioIds()
    {
        List<Cardapio> todos = cardapioService.obterListaInteira();
        System.out.printf("%-5s | %-20s ", "ID", "NOME");
        for(Cardapio cardapio : todos) {
            System.out.printf("%-5d | %-20s", cardapio.getId(), cardapio.getNome());
        }
    }
}
