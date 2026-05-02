package com.github.Gregorys2s.repositories;

import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.exceptions.AcharProdutoException;
import com.github.Gregorys2s.exceptions.AcharTipoProdutoException;
import com.github.Gregorys2s.exceptions.PersistenciaProdutoRepositoryException;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CardapioRepository {
    private final EntityManager em;

    public CardapioRepository(EntityManager em) {
        this.em = em;
    }

    public Cardapio findById(long id) {
        return em.find(Cardapio.class, id);
    }

    public void save(Cardapio cardapio) {
        try {
            em.getTransaction().begin();
            em.persist(cardapio);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            //noinspection GrazieInspectionRunner
            throw new PersistenciaProdutoRepositoryException("Erro ao tentar salvar o item " + cardapio.getNome(), e);
        }
    }


    public void update(Cardapio cardapio) {
        try {
            em.getTransaction().begin();
            em.merge(cardapio);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            //noinspection GrazieInspectionRunner
            throw new PersistenciaProdutoRepositoryException("Erro inesperado operação cancelada");
        }
    }

    public void delete(Cardapio cardapio) {
        try{
            em.getTransaction().begin();
            em.remove(em.contains(cardapio) ? cardapio : em.merge(cardapio));
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
    public List<Cardapio> findAll() {
        return em.createQuery("select c from Cardapio c", Cardapio.class).getResultList();
    }
    public Cardapio findByNameUnique(String name) {
        try{
            return em.createQuery("select c from Cardapio c where c.nome = :nome",
                            Cardapio.class)
                    .setParameter("name",name)
                    .getSingleResult();
        } catch (Exception e) {
            throw new AcharProdutoException("Erro inesperado operação cancelada");
        }
    }
    public List<Cardapio> findByNameList(String name) {
        try{
            return em.createQuery("select c from Cardapio c where lower(c.nome) like lower(:name)",
                            Cardapio.class)
                    .setParameter("name", "%" + name + "%")
                    .getResultList();
        } catch (Exception e) {
            throw new AcharProdutoException("Erro inesperado operação cancelada");
        }
    }

    public List<Cardapio> findByType(String type) {
        try{
            return em.createQuery("select c from Cardapio c where lower(c.tipo) like lower(:type)",
                    Cardapio.class)
                    .setParameter("type", "%" + type + "%")
                    .getResultList();
        } catch (Exception e) {
            throw new AcharTipoProdutoException("Erro inesperado operação cancelada");
        }
    }
}