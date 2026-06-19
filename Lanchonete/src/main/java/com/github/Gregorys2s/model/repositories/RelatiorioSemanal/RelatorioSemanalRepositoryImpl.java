package com.github.Gregorys2s.model.repositories.RelatiorioSemanal;

import com.github.Gregorys2s.model.entity.RelatorioSemanal;
import com.github.Gregorys2s.model.repositories.PedidosRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class RelatorioSemanalRepositoryImpl implements RelatorioSemanalRepository {

    private final EntityManager em;

    public RelatorioSemanalRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void salvar(RelatorioSemanal relatorio) {
        em.getTransaction().begin();
        em.persist(relatorio);
        em.getTransaction().commit();
    }

    @Override
    public void atualizar(RelatorioSemanal relatorio) {
        em.getTransaction().begin();
        em.merge(relatorio);
        em.getTransaction().commit();
    }

    @Override
    public void excluir(LocalDate semanaInicio) {
        RelatorioSemanal relatorio = em.find(RelatorioSemanal.class, semanaInicio);

        if (relatorio != null) {
            em.getTransaction().begin();
            em.remove(relatorio);
            em.getTransaction().commit();
        }
    }

    @Override
    public RelatorioSemanal buscarPorSemana(LocalDate semanaInicio) {
        return em.find(RelatorioSemanal.class, semanaInicio);
    }

    @Override
    public List<RelatorioSemanal> listarTodos() {
        TypedQuery<RelatorioSemanal> query =
                em.createQuery("from RelatorioSemanal", RelatorioSemanal.class);

        return query.getResultList();
    }
}