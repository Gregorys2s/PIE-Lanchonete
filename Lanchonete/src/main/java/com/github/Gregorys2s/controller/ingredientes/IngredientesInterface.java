package com.github.Gregorys2s.controller.ingredientes;

import com.github.Gregorys2s.controller.ingredientes.DTO.IngredientesDTO;
import com.github.Gregorys2s.model.entity.Ingredientes;

import java.util.List;

public interface IngredientesInterface {
    public void cadastrarIngrediente(IngredientesDTO ingrediente);


    public IngredientesDTO buscarId(int id);


    public List<IngredientesDTO> listarIngredientes();


    public void atualizarIngrediente(int id,IngredientesDTO ingredienteAtualizado);


    public void excluirIngrediente(int id);


    public void adicionarEstoque(int id,int quantidade);


    public void removerEstoque(int id, int quantidade);


    public List<IngredientesDTO> listarEstoqueBaixo(int limite);

}
