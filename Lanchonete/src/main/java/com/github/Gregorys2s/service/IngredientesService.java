package com.github.Gregorys2s.service;

import com.github.Gregorys2s.config.DatabaseConfig;
import com.github.Gregorys2s.entity.Ingredientes;
import com.github.Gregorys2s.repositories.IngredienteRepository;
import com.github.Gregorys2s.exceptions.EstoqueRepositoryException;
import jakarta.persistence.EntityManager;

public class IngredientesService {


    public void salvar(Ingredientes ingredientes) {




        if (ingredientes.getNome() == null || ingredientes.getNome().isBlank()) {
            throw new EstoqueRepositoryException("O ingrediente precisa de um nome!!");
        }

        if (ingredientes.getEstoque() < 0) {
            throw new EstoqueRepositoryException("O estoque não pode ser negativo, tropa!");
        }

        EntityManager em = DatabaseConfig.getEntityManager();

        try {
            IngredienteRepository repository = new IngredienteRepository(em);

            repository.salvar(ingredientes);
        } finally  {
            em.close();
        }



    }
    public java.util.List<Ingredientes> buscarTodos(){
        EntityManager em = DatabaseConfig.getEntityManager();
        try {
            IngredienteRepository repository = new IngredienteRepository(em);
            return repository.buscarTodos();
        } finally  {
            em.close();
        }

    }
    public Ingredientes buscarPorId(Long id){
        EntityManager em = DatabaseConfig.getEntityManager();
        try{
            IngredienteRepository repository = new IngredienteRepository(em);

            if (id == null || id <= 0) {
            throw new EstoqueRepositoryException("ID invalido para buscar!");
            }
            return repository.buscarPorId(id);
        } finally  {
            em.close();
        }
    }

    public void atualizar(Ingredientes ingredientes) {
       if (ingredientes.getNome() == null || ingredientes.getId() <= 0) {
           throw new EstoqueRepositoryException("Para atualizar o ingrediente precisa ter um ID valido!");
       }
       if (ingredientes.getEstoque() < 0) {
           throw new EstoqueRepositoryException("O estoque nao pode ser negativo, tropa!");
       }

        EntityManager em = DatabaseConfig.getEntityManager();
        try {

            em.getTransaction().begin();

            IngredienteRepository repository = new IngredienteRepository(em);
            repository.atualizar(ingredientes);
            em.getTransaction().commit();

        } catch (Exception e) {
            boolean active = em.getTransaction().isActive();
            {
                em.getTransaction().rollback();
            }
            throw new EstoqueRepositoryException("Erro ao atualizar o ingrediente!");

        } finally  {
            em.close();
        }

    }

    public void excluir(Long id) {

        if (id == null || id <= 0) {
            throw new EstoqueRepositoryException("ID invalido! Nao sei quem excluir");
        }

        EntityManager em = DatabaseConfig.getEntityManager();
        try {
            em.getTransaction().begin();
            IngredienteRepository repository = new IngredienteRepository(em);
            repository.excluir(id);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new EstoqueRepositoryException("Erro ao excluir o ingrediente!");
        } finally  {
            em.close();
        }

    }












}
