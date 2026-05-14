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


    public void removerEstoque(int id, int quantidade) {
        service.removerEstoque(id,quantidade);
    }


    public List<Ingredientes> listarEstoqueBaixo(int limite) {

        return service.listarEstoqueBaixo(limite);
    }

}