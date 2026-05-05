package com.github.Gregorys2s.repositories;

import com.github.Gregorys2s.entity.Ingredientes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class IngredienteRepository {

    private final EntityManager em;

    public IngredienteRepository(EntityManager em) {
        this.em = em;
    }


    public void salvar(Ingredientes ingredientes) {
        em.getTransaction().begin();
        try {
            em.persist(ingredientes);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    public Optional<Ingredientes> buscarPorId(int id) {
        return Optional.ofNullable(em.find(Ingredientes.class, id));
    }

    public List<Ingredientes> buscarTodos() {
        TypedQuery<Ingredientes> query = em.createQuery(
                "SELECT i FROM Ingredientes i ORDER BY i.nome",
                Ingredientes.class
        );
        return query.getResultList();
    }

    public Ingredientes atualizar(Ingredientes ingredientes) {
        em.getTransaction().begin();
        try {
            Ingredientes atualizado = em.merge(ingredientes);
            em.getTransaction().commit();
            return atualizado;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    public void deletar(int id) {
        em.getTransaction().begin();
        try {
            Ingredientes ingrediente = em.find(Ingredientes.class, id);
            if (ingrediente != null) {
                em.remove(ingrediente);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }


    public Optional<Ingredientes> buscarPorNome(String nome) {
        TypedQuery<Ingredientes> query = em.createQuery(
                "SELECT i FROM Ingredientes i WHERE LOWER(i.nome) = LOWER(:nome)",
                Ingredientes.class
        );
        query.setParameter("nome", nome);
        List<Ingredientes> resultado = query.getResultList();
        return resultado.isEmpty() ? Optional.empty() : Optional.of(resultado.get(0));
    }

    public List<Ingredientes> buscarPorEstoqueBaixo(int limiteMinimo) {
        TypedQuery<Ingredientes> query = em.createQuery(
                "SELECT i FROM Ingredientes i WHERE i.estoque <= :limite ORDER BY i.estoque",
                Ingredientes.class
        );
        query.setParameter("limite", limiteMinimo);
        return query.getResultList();
    }

    public List<Ingredientes> buscarComEstoqueDisponivel() {
        TypedQuery<Ingredientes> query = em.createQuery(
                "SELECT i FROM Ingredientes i WHERE i.estoque > 0 ORDER BY i.nome",
                Ingredientes.class
        );
        return query.getResultList();
    }

    public long contarTotal() {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(i) FROM Ingredientes i",
                Long.class
        );
        return query.getSingleResult();
    }
}