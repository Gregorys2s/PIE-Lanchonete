package com.github.Gregorys2s.view;

public class CardapioView {
    void menuCardapio()
    {
        System.out.println("1. Mostrar cardapio completo" +
                "\n2. Pesquisas/filtros" +
                "\n3. Menu de alteracoes");
    }
    void menuPesquisas()
    {
        System.out.println(
                "1. Procurar por nome" +
                        "\n2. Procurar por id" +
                        "\n3. Filtrar por tipo"
        );
    }
    void menuAlteracoes()
    {
        System.out.println("1. Adicionar item ao cardapio" +
                "\n2. Remover item do cardapio" +
                "\n3. Atualizar item do cardapio" +
                "\n4. Atualizar ingredientes de item do cardapio");
    }
}
