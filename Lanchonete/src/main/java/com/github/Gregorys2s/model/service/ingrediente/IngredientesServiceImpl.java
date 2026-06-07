package com.github.Gregorys2s.model.service.ingrediente;

import com.github.Gregorys2s.controller.ingredientes.DTO.IngredientesDTO;
import com.github.Gregorys2s.model.entity.Ingredientes;
import com.github.Gregorys2s.model.repositories.IngredienteRepository;
import com.github.Gregorys2s.exceptions.*;
import java.util.List;

public class IngredientesServiceImpl implements IngredientesService {

    private final IngredienteRepository repository;


    public IngredientesServiceImpl(IngredienteRepository repository) {
        this.repository = repository;
    }

    public IngredientesServiceImpl() {
        this.repository = null;
    }

    @Override
    public void salvar(IngredientesDTO dto) {
        validarIngrediente(dto);

        repository.buscarPorNome(dto.getNome())
                .ifPresent(existente -> {
                    throw new IngredienteDuplicadoException(
                            "Já existe um ingrediente com o nome: " + dto.getNome()
                    );
                });

        Ingredientes ingrediente = new Ingredientes(dto.getNome(),dto.getEstoque());

        repository.salvar(ingrediente);
    }
    @Override
    public IngredientesDTO buscarPorId(int id) {
        validarId(id);

        Ingredientes ingredientes = repository.buscarPorId(id)
                .orElseThrow(() -> new IngredienteNaoEncontradoException(
                        "Ingrediente não encontrado com ID: " + id
                ));

        return new IngredientesDTO(ingredientes.getId(),ingredientes.getNome(),ingredientes.getEstoque());
    }
    @Override
    public List<IngredientesDTO> listarTodos() {
        List<Ingredientes> ingredientes = repository.buscarTodos();

        if (ingredientes.isEmpty()) {
            throw new EstoqueVazioException("Nenhum ingrediente cadastrado no sistema");
        }

        return ingredientes.stream()
                .map(i -> new IngredientesDTO(
                        i.getId(),
                        i.getNome(),
                        i.getEstoque()
                ))
                .toList();
    }
    @Override
    public void atualizar(int id, IngredientesDTO dto) {

        validarId(id);
        validarIngrediente(dto);

        IngredientesDTO ingredienteExistente = buscarPorId(id);

        if (!ingredienteExistente.getNome().equalsIgnoreCase(dto.getNome())) {
            repository.buscarPorNome(dto.getNome())
                    .ifPresent(existente -> {
                        throw new IngredienteDuplicadoException(
                                "Já existe outro ingrediente com o nome: " + dto.getNome()
                        );
                    });
        }

        ingredienteExistente.setNome(dto.getNome());
        ingredienteExistente.setEstoque(dto.getEstoque());

        Ingredientes atualizado = new Ingredientes();

        atualizado.setEstoque(dto.getEstoque());
        atualizado.setNome(dto.getNome());

        repository.atualizar(atualizado);
    }
    @Override
    public void excluir(int id) {
        validarId(id);

        buscarPorId(id);

        repository.deletar(id);
    }

    @Override
    public void adicionarEstoque(int id, int quantidade) {
        if (quantidade <= 0) {
            throw new EstoqueInvalidoException("Quantidade deve ser maior que zero");
        }

        IngredientesDTO dto = buscarPorId(id);
        dto.setEstoque(dto.getEstoque() + quantidade);
        Ingredientes ingredientes = new Ingredientes();
        ingredientes.setEstoque(dto.getEstoque());

        repository.atualizar(ingredientes);
    } //testar
    @Override
    public void removerEstoque(int id, int quantidade) {
        if (quantidade <= 0) {
            throw new EstoqueInvalidoException("Quantidade deve ser maior que zero");
        }

        IngredientesDTO dto = buscarPorId(id);

        int novoEstoque = dto.getEstoque() - quantidade;

        if (novoEstoque < 0) {
            throw new EstoqueInsuficienteException(
                    "Estoque insuficiente. Disponível: " + dto.getEstoque() +
                            ", Solicitado: " + quantidade
            );
        }

        dto.setEstoque(novoEstoque);

        Ingredientes ingrediente = new Ingredientes();
        ingrediente.setEstoque(dto.getEstoque());
        repository.atualizar(ingrediente);
    }
    @Override
    public List<IngredientesDTO> listarEstoqueBaixo(int limiteMinimo) {
        if (limiteMinimo < 0) {
            throw new IllegalArgumentException("Limite mínimo não pode ser negativo");
        }
        return repository.buscarPorEstoqueBaixo(limiteMinimo)
                .stream()
                .map(i -> new IngredientesDTO(
                        i.getId(),
                        i.getNome(),
                        i.getEstoque()
                ))
                .toList();

    }

    @Override
    public List<IngredientesDTO> listarDisponiveis() {

        return repository.buscarComEstoqueDisponivel()
                .stream()
                .map(i -> new IngredientesDTO(
                        i.getId(),
                        i.getNome(),
                        i.getEstoque()
                ))
                .toList();
    }

    @Override
    public boolean verificarDisponibilidade(int id, int quantidadeNecessaria) {
        IngredientesDTO ingrediente = buscarPorId(id);
        return ingrediente.getEstoque() >= quantidadeNecessaria;
    }


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