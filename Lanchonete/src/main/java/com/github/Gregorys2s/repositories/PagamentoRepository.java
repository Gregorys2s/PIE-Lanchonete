package com.github.Gregorys2s.repositories;

import com.github.Gregorys2s.entity.Pagamento;
import  jakarta.persistence.EntityManager;

import java.util.List;

public class PagamentoRepository {
    private EntityManager em;

    public PagamentoRepository(EntityManager em){
        this.em = em;
    }

    public void salvar(Pagamento pagamento){
        try {
            em.getTransaction().begin();
            em.persist(pagamento);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("erro ao salvar pagamento:" + e.getMessage());
        }
    }
    public List<Pagamento> listarPagamento(){
        return em.createQuery("SELECT p FROM Pagamento p", Pagamento.class).getResultList();
    }
}
