package com.github.Gregorys2s.controller;

import com.github.Gregorys2s.entity.Ingredientes;
import com.github.Gregorys2s.service.IngredientesService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class IngredientesController {

    private final IngredientesService service;

    public IngredientesController(IngredientesService service) {
        this.service = service;
    }


    public void cadastrarIngrediente(Ingredientes ingrediente) {
        service.salvar(ingrediente);
    }


    public Ingredientes buscarId(int id) {
        System.out.print("ID do ingrediente: ");

        return service.buscarPorId(id);
    }


    public List<Ingredientes> listarIngredientes() {
        return service.listarTodos();
    }


    public void atualizarIngrediente(int id,Ingredientes ingredienteAtualizado) {

        service.atualizar(id, ingredienteAtualizado);
    }


    public void excluirIngrediente(int id) {
        service.excluir(id);
    }


    public void adicionarEstoque(int id,int quantidade) {

        service.adicionarEstoque(id, quantidade);
    }


    public Ingredientes removerEstoque() {
        System.out.print("ID do ingrediente: ");
        int id = lerDecimal(sc);

        System.out.print("Quantidade a remover: ");
        Integer quantidade = lerInteiro(sc);

        return service.removerEstoque(id, quantidade);
    }


    public List<Ingredientes> listarEstoqueBaixo() {
        System.out.print("Limite mínimo de estoque: ");
        int limite = lerInteiro(sc);

        return service.listarEstoqueBaixo(limite);
    }


    private String lerTexto(Scanner sc) {
        while (true) {
            String texto = Leitores.leitorTextos(sc);
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.print("Campo obrigatório! Digite novamente: ");
        }
    }

    private BigDecimal lerDecimal(Scanner sc) {
        while (true) {
            try {
                BigDecimal input;
                return input = Leitores.leitorDecimais(sc);
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido! Digite um número: ");
            }
        }
    }

    private Integer lerInteiro(Scanner sc) {
        while (true) {
            try {
                int valor = Leitores.leitorInteger(sc);

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