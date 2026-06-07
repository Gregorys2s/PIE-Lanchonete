package com.github.Gregorys2s.model.service.ingrediente;

import com.github.Gregorys2s.controller.ingredientes.DTO.IngredientesDTO;
import com.github.Gregorys2s.exceptions.EstoqueInvalidoException;
import com.github.Gregorys2s.exceptions.IngredienteInvalidoException;
import com.github.Gregorys2s.model.entity.Ingredientes;

import java.util.List;

public interface IngredientesService {

    public void salvar(IngredientesDTO ingrediente);

    public IngredientesDTO buscarPorId(int id);

    public List<IngredientesDTO> listarTodos();

    public void atualizar(int id, IngredientesDTO ingredienteAtualizado);

    public void excluir(int id);


    public void adicionarEstoque(int id, int quantidade);

    public void removerEstoque(int id, int quantidade);

    public List<IngredientesDTO> listarEstoqueBaixo(int limiteMinimo);

    public List<IngredientesDTO> listarDisponiveis();

    public boolean verificarDisponibilidade(int id, int quantidadeNecessaria);

    private void validarIngrediente(IngredientesDTO ingrediente) {
        if (ingrediente == null) {
            throw new IllegalArgumentException("Ingrediente não pode ser nulo");
        }

        if (ingrediente.getNome() == null || ingrediente.getNome().isBlank()) {
            throw new IngredienteInvalidoException("O ingrediente precisa de um nome!");
        }

        if (ingrediente.getEstoque() < 0) {
            throw new EstoqueInvalidoException("O estoque não pode ser negativo!");
        }
    }

    private void validarId(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido: " + id);
        }
    }
}
