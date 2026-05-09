package com.github.Gregorys2s.repositories;

import com.github.Gregorys2s.entity.Despesas;
import com.github.Gregorys2s.exceptions.PersistenciaDespesasRepositoryException;
import jakarta.persistence.EntityManager;


import java.time.*;
import java.util.List;

public class DespesasRepository {
    private final EntityManager em;

    public DespesasRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Despesas despesas) {
        try {
            em.getTransaction().begin();
            em.persist(despesas);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            //noinspection GrazieInspectionRunner
            throw new PersistenciaDespesasRepositoryException("Erro ao tentar salvar a despesa no sistema ");
        }
    }


    public void update(Despesas despesas) {
        try {
            em.getTransaction().begin();
            em.merge(despesas);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            //noinspection GrazieInspectionRunner
            throw new PersistenciaDespesasRepositoryException("Erro ao tentar atualizar a despesa no sistema ");
        }
    }

    public void delete(Despesas despesas) {
        try{
            em.getTransaction().begin();
            em.remove(em.contains(despesas) ? despesas : em.merge(despesas));
            em.getTransaction().commit();
        }catch(Exception e){
            if(em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            //noinspection GrazieInspectionRunner
            throw new PersistenciaDespesasRepositoryException("Erro ao tentar apagar a despesa no sistema ");
        }
    }

    public Despesas findById(Integer id) {
            return em.find(Despesas.class, id);
    }

    public List<Despesas> findByDay(LocalDate data) {
        try {
            //mesma logica do trigger que pega e subtrai 7 horas do horario atual
            LocalDateTime inicio = data.atTime(19, 0);
            LocalDateTime fim = data.plusDays(1).atTime(5, 0);

            return em.createQuery("SELECT d FROM Despesas d WHERE d.dataHora BETWEEN :inicio AND :fim",
                            Despesas.class)
                    .setParameter("inicio", inicio)
                    .setParameter("fim", fim)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaDespesasRepositoryException("Erro inesperado no sistema");
        }
    }
}
