package com.github.Gregorys2s.controller;

import com.github.Gregorys2s.entity.Ingredientes;
import com.github.Gregorys2s.service.IngredientesService;
import java.util.List;
import java.util.Scanner;

public class IngredientesController {

    private final IngredientesService service;
    private final Scanner scanner;

    public IngredientesController(IngredientesService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }


    public Ingredientes criarIngrediente() {
        System.out.print("Nome do ingrediente: ");
        String nome = lerTexto();

        System.out.print("Quantidade em estoque: ");
        int estoque = lerInteiro();

        Ingredientes ingrediente = new Ingredientes(nome, estoque);

        return service.salvar(ingrediente);
    }


    public Ingredientes buscarIngrediente() {
        System.out.print("ID do ingrediente: ");
        Long id = lerLong();

        return service.buscarPorId(id);
    }


    public List<Ingredientes> listarIngredientes() {
        return service.listarTodos();
    }


    public Ingredientes atualizarIngrediente() {
        System.out.print("ID do ingrediente para atualizar: ");
        Long id = lerLong();

        System.out.print("Novo nome: ");
        String novoNome = lerTexto();

        System.out.print("Nova quantidade em estoque: ");
        int novoEstoque = lerInteiro();

        Ingredientes ingredienteAtualizado = new Ingredientes(novoNome, novoEstoque);

        return service.atualizar(id, ingredienteAtualizado);
    }


    public void excluirIngrediente() {
        System.out.print("ID do ingrediente para excluir: ");
        Long id = lerLong();

        service.excluir(id);
    }


    public Ingredientes adicionarEstoque() {
        System.out.print("ID do ingrediente: ");
        Long id = lerLong();

        System.out.print("Quantidade a adicionar: ");
        int quantidade = lerInteiro();

        return service.adicionarEstoque(id, quantidade);
    }


    public Ingredientes removerEstoque() {
        System.out.print("ID do ingrediente: ");
        Long id = lerLong();

        System.out.print("Quantidade a remover: ");
        int quantidade = lerInteiro();

        return service.removerEstoque(id, quantidade);
    }


    public List<Ingredientes> listarEstoqueBaixo() {
        System.out.print("Limite mínimo de estoque: ");
        int limite = lerInteiro();

        return service.listarEstoqueBaixo(limite);
    }


    private String lerTexto() {
        while (true) {
            String texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.print("Campo obrigatório! Digite novamente: ");
        }
    }

    private Long lerLong() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido! Digite um número: ");
            }
        }
    }

    private int lerInteiro() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                int valor = Integer.parseInt(input);
                if (valor < 0) {
                    System.out.print("Valor não pode ser negativo! Digite novamente: ");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido! Digite um número inteiro: ");
            }
        }
    }
}