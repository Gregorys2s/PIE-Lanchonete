package com.github.Gregorys2s.repositories;

import com.github.Gregorys2s.entity.RelatorioDiario;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class RelatorioDiarioRepository {

    private final EntityManager em;

    public RelatorioDiarioRepository(EntityManager em) {
        this.em = em;
    }

    public void salvar(RelatorioDiario relatorio) {
        try {
            em.getTransaction().begin();
            em.persist(relatorio);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro ao salvar relatório diário: " + e.getMessage());
        }
    }

    public Optional<RelatorioDiario> buscarPorData(LocalDate data) {
        List<RelatorioDiario> resultado = em.createQuery(
                        "SELECT r FROM RelatorioDiario r WHERE r.data = :data",
                        RelatorioDiario.class)
                .setParameter("data", data)
                .getResultList();
        return resultado.isEmpty() ? Optional.empty() : Optional.of(resultado.get(0));
    }

    public List<RelatorioDiario> listarTodos() {
        return em.createQuery("SELECT r FROM RelatorioDiario r ORDER BY r.data DESC",
                        RelatorioDiario.class)
                .getResultList();
    }
}
