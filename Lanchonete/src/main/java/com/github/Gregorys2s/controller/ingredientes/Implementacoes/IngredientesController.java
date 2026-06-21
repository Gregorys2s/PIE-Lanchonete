package com.github.Gregorys2s.controller.ingredientes.Implementacoes;

import com.github.Gregorys2s.controller.ingredientes.DTO.IngredientesDTO;
import com.github.Gregorys2s.controller.ingredientes.IngredientesInterface;
import com.github.Gregorys2s.model.entity.Ingredientes;
import com.github.Gregorys2s.model.service.ingrediente.IngredientesServiceImpl;

import java.util.List;

public class IngredientesController implements IngredientesInterface {

    private final IngredientesServiceImpl service;

    public IngredientesController(IngredientesServiceImpl service) {
        this.service = service;
    }


    public void cadastrarIngrediente(IngredientesDTO ingrediente) {
        service.salvar(ingrediente);
    }


    public IngredientesDTO buscarId(int id) {
        System.out.print("ID do ingrediente: ");

        return service.buscarPorId(id);
    }


    public List<IngredientesDTO> listarIngredientes() {
        return service.listarTodos();
    }


    public void atualizarIngrediente(int id,IngredientesDTO ingredienteAtualizado) {

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


    public List<IngredientesDTO> listarEstoqueBaixo(int limite) {

        return service.listarEstoqueBaixo(limite);
    }

}