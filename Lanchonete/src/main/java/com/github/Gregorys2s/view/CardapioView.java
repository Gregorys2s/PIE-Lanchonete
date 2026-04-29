package com.github.Gregorys2s.view;

import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.repositories.CardapioRepository;
import com.github.Gregorys2s.service.CardapioService;

import java.util.List;

public class CardapioView {
    public CardapioView(){}//fiz esse construtor vazio pq minha IDE tava marcando erro
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
    public void mostrarCardapio(List<Cardapio> c)
    {
        if(c.isEmpty()) {
            System.out.println("Lista de produtos vazia");
            return;
        }        System.out.printf("%-5s | %-20s | %-10s%n | %-10s%n", "ID", "NOME", "PRECO", "TIPO");
        for(Cardapio cardapio : c) {
            System.out.printf("%-5d | %-20s | %-10.2f%n | %-20s%n", cardapio.getId(), cardapio.getNome(), cardapio.getPreco(), cardapio.getTipo());
        }
    }
    public void mostrarCardapioIds(List<Cardapio> c)
    {
        if(c.isEmpty()) {
            System.out.println("Lista de produtos vazia");
            return;
        }
        System.out.printf("%-5s | %-20s ", "ID", "NOME");
        for(Cardapio cardapio : c) {
            System.out.printf("%-5d | %-20s", cardapio.getId(), cardapio.getNome());
        }
    }
}
