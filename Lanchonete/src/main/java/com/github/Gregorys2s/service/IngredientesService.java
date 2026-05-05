package com.github.Gregorys2s.service;

import com.github.Gregorys2s.entity.Ingredientes;
import com.github.Gregorys2s.repositories.IngredienteRepository;
import com.github.Gregorys2s.exceptions.*;
import java.util.List;

public class IngredientesService {

    private final IngredienteRepository repository;

    public IngredientesService(IngredienteRepository repository) {
        this.repository = repository;
    }


    public void salvar(Ingredientes ingrediente) {
        validarIngrediente(ingrediente);

        repository.buscarPorNome(ingrediente.getNome())
                .ifPresent(existente -> {
                    throw new IngredienteDuplicadoException(
                            "Já existe um ingrediente com o nome: " + ingrediente.getNome()
                    );
                });

        repository.salvar(ingrediente);
    }

    public Ingredientes buscarPorId(int id) {
        validarId(id);

        return repository.buscarPorId(id)
                .orElseThrow(() -> new IngredienteNaoEncontradoException(
                        "Ingrediente não encontrado com ID: " + id
                ));
    }

    public List<Ingredientes> listarTodos() {
        List<Ingredientes> ingredientes = repository.buscarTodos();

        if (ingredientes.isEmpty()) {
            throw new EstoqueVazioException("Nenhum ingrediente cadastrado no sistema");
        }

        return ingredientes;
    }

    public void atualizar(int id, Ingredientes ingredienteAtualizado) {

        validarId(id);
        validarIngrediente(ingredienteAtualizado);

        Ingredientes ingredienteExistente = buscarPorId(id);

        if (!ingredienteExistente.getNome().equalsIgnoreCase(ingredienteAtualizado.getNome())) {
            repository.buscarPorNome(ingredienteAtualizado.getNome())
                    .ifPresent(existente -> {
                        throw new IngredienteDuplicadoException(
                                "Já existe outro ingrediente com o nome: " + ingredienteAtualizado.getNome()
                        );
                    });
        }

        ingredienteExistente.setNome(ingredienteAtualizado.getNome());
        ingredienteExistente.setEstoque(ingredienteAtualizado.getEstoque());

        repository.atualizar(ingredienteExistente);
    }

    public void excluir(int id) {
        validarId(id);

        buscarPorId(id);

        repository.deletar(id);
    }


    public void adicionarEstoque(int id, int quantidade) {
        if (quantidade <= 0) {
            throw new EstoqueInvalidoException("Quantidade deve ser maior que zero");
        }

        Ingredientes ingrediente = buscarPorId(id);
        ingrediente.setEstoque(ingrediente.getEstoque() + quantidade);

        repository.atualizar(ingrediente);
    } //testar

    public Ingredientes removerEstoque(int id, int quantidade) {
        if (quantidade <= 0) {
            throw new EstoqueInvalidoException("Quantidade deve ser maior que zero");
        }

        Ingredientes ingrediente = buscarPorId(id);

        int novoEstoque = ingrediente.getEstoque() - quantidade;

        if (novoEstoque < 0) {
            throw new EstoqueInsuficienteException(
                    "Estoque insuficiente. Disponível: " + ingrediente.getEstoque() +
                            ", Solicitado: " + quantidade
            );
        }

        ingrediente.setEstoque(novoEstoque);
        return repository.atualizar(ingrediente);
    }

    public List<Ingredientes> listarEstoqueBaixo(int limiteMinimo) {
        if (limiteMinimo < 0) {
            throw new IllegalArgumentException("Limite mínimo não pode ser negativo");
        }

        return repository.buscarPorEstoqueBaixo(limiteMinimo);
    }

    public List<Ingredientes> listarDisponiveis() {
        return repository.buscarComEstoqueDisponivel();
    }

    public boolean verificarDisponibilidade(int id, int quantidadeNecessaria) {
        Ingredientes ingrediente = buscarPorId(id);
        return ingrediente.getEstoque() >= quantidadeNecessaria;
    }


    private void validarIngrediente(Ingredientes ingrediente) {
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