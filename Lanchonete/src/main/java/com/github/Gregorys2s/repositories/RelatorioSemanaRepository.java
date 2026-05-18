package com.github.Gregorys2s.repositories;

import com.github.Gregorys2s.entity.RelatorioDiario;
import com.github.Gregorys2s.entity.RelatorioSemanal;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class RelatorioSemanaRepository {
    private final EntityManager em;

    public RelatorioSemanaRepository(EntityManager em) {
        this.em = em;
    }

    public void salvar(RelatorioSemanal relatorio) {
        try {
            em.getTransaction().begin();
            // Utiliza-se merge em vez de persist porque a chave primária (semanaInicio)
            // não é gerada automaticamente. O merge insere ou atualiza o registo se já existir.
            em.merge(relatorio);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Erro ao salvar relatório semanal: " + e.getMessage());
        }
    }

    public Optional<RelatorioSemanal> buscarPorDataInicio(LocalDate semanaInicio) {
        RelatorioSemanal resultado = em.find(RelatorioSemanal.class, semanaInicio);
        return Optional.ofNullable(resultado);
    }

    public List<RelatorioSemanal> listarTodos() {
        return em.createQuery("SELECT r FROM RelatorioSemanal r ORDER BY r.semanaInicio DESC",
                        RelatorioSemanal.class)
                .getResultList();
    }

    public Optional<RelatorioDiario> buscarPorData(LocalDate data) {
        List<RelatorioDiario> resultado = em.createQuery(
                        "SELECT r FROM RelatorioDiario r WHERE r.data = :data",
                        RelatorioDiario.class)
                .setParameter("data", data)
                .getResultList();
        return resultado.isEmpty() ? Optional.empty() : Optional.of(resultado.get(0));
    }
}
