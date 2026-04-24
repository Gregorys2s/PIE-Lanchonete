package com.github.Gregorys2s.repositories;

import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.exceptions.AcharProdutoException;
import com.github.Gregorys2s.exceptions.PersistenciaProdutoRepositoryException;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CardapioRepository {
    private EntityManager em;

    public CardapioRepository(EntityManager em) {
        this.em = em;
    }

    public Cardapio findById(long id) {
        return em.find(Cardapio.class, id);
    }

    public void salvar(Cardapio produtos) {
        try {
            em.getTransaction().begin();
            em.persist(produtos);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            //noinspection GrazieInspectionRunner
            throw new PersistenciaProdutoRepositoryException("Erro ao tentar salvar o item " + produtos.getNome(), e);
        }
    }


    public void atualizar(Cardapio produtos) {
        try {
            em.getTransaction().begin();
            em.merge(produtos);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            //noinspection GrazieInspectionRunner
            throw new PersistenciaProdutoRepositoryException("Erro inesperado operação cancelada");
        }
    }

    public void delete(Cardapio produtos) {
        try{
            em.getTransaction().begin();
            em.remove(em.contains(produtos) ? produtos : em.merge(produtos));
            em.getTransaction().commit();
        }catch(Exception e){
            if(em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            //noinspection GrazieInspectionRunner
            throw new PersistenciaProdutoRepositoryException("Erro inesperado operação cancelada");
        }
    }
    public List<Cardapio> buscarTodos() {
        return em.createQuery("select c from Cardapio c", Cardapio.class).getResultList();
    }

    public List<Cardapio> acharPeloNome(String name) {
        try{
            return em.createQuery("select c from Cardapio c where c.nome like lower(:name)",
                            Cardapio.class)
                    .setParameter("name", "%" + name + "%")
                    .getResultList();
        } catch (Exception e) {
            throw new AcharProdutoException("Erro inesperado operação cancelada");
        }
    }
}