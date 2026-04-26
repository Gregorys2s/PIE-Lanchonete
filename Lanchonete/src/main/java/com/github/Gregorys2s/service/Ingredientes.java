package com.github.Gregorys2s.service;


import com.github.Gregorys2s.entity.IngredientesEntity;
import com.github.Gregorys2s.repositories.IngredienteRepository;
import com.github.Gregorys2s.exceptions.EstoqueRepositoryException;

public class Ingredientes {

    private IngredienteRepository repository = new IngredienteRepository();

    public void salvar(IngredientesEntity ingredientes) {
        if (ingredientes.getNome() == null || ingredientes.getNome().isBlank()) {
            throw new EstoqueRepositoryException("O ingrediente precisa de um nome!!");
        }

        if (ingredientes.getEstoque() < 0) {
            throw new EstoqueRepositoryException("O estoque não pode ser negativo, tropa!");
        }

        repository.salvar(ingredientes);

    }

}
