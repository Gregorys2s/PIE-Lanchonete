package com.github.Gregorys2s.model.repositories.caixa.Impl;

import com.github.Gregorys2s.model.entity.Caixa.Caixa;
import com.github.Gregorys2s.model.entity.Caixa.MovimentoCaixa;
import com.github.Gregorys2s.model.repositories.caixa.CaixaRepository;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CaixaRepositoryImpl implements CaixaRepository {

    private final EntityManager em;

    public CaixaRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Caixa obterCaixaAtual() {
        BigDecimal saldo = buscarSaldoAtual();
        BigDecimal valorAbertura = buscarValorAbertura();
        BigDecimal totalEntradas = buscarTotalEntradas();
        BigDecimal totalDespesas = buscarTotalDespesas();
        boolean aberto = existeAbertura();
        List<MovimentoCaixa> movimentos = buscarMovimentos();

        return new Caixa(
                aberto,
                saldo,
                valorAbertura,
                totalEntradas,
                totalDespesas,
                movimentos
        );
    }

    @Override
    public Caixa abrirCaixa(BigDecimal valorInicial) {
        salvarMovimento(
                MovimentoCaixa.TipoMovimentoCaixa.ABERTURA.name(),
                valorInicial,
                valorInicial,
                false
        );

        return obterCaixaAtual();
    }

    @Override
    public Caixa registrarEntrada(BigDecimal valor) {
        BigDecimal saldoAtual = buscarSaldoAtual();
        BigDecimal saldoApos = saldoAtual.add(valor);

        salvarMovimento(
                MovimentoCaixa.TipoMovimentoCaixa.ENTRADA.name(),
                valor,
                saldoApos,
                false
        );

        return obterCaixaAtual();
    }

    @Override
    public Caixa registrarDespesa(BigDecimal valor) {
        BigDecimal saldoAtual = buscarSaldoAtual();
        BigDecimal saldoApos = saldoAtual.subtract(valor);

        try {
            em.getTransaction().begin();

            em.createNativeQuery("""
                    INSERT INTO caixa_movimentos (tipo, valor, saldo_apos)
                    VALUES (:tipo, :valor, :saldoApos)
                    """)
                    .setParameter("tipo", MovimentoCaixa.TipoMovimentoCaixa.DESPESA.name())
                    .setParameter("valor", valor)
                    .setParameter("saldoApos", saldoApos)
                    .executeUpdate();

            em.createNativeQuery("""
                    INSERT INTO despesas (valor_despesa)
                    VALUES (:valor)
                    """)
                    .setParameter("valor", valor)
                    .executeUpdate();

            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            throw new RuntimeException("Erro ao registrar despesa no banco: " + e.getMessage(), e);
        }

        return obterCaixaAtual();
    }

    private void salvarMovimento(
            String tipo,
            BigDecimal valor,
            BigDecimal saldoApos,
            boolean transacaoAberta
    ) {
        try {
            if (!transacaoAberta) {
                em.getTransaction().begin();
            }

            em.createNativeQuery("""
                    INSERT INTO caixa_movimentos (tipo, valor, saldo_apos)
                    VALUES (:tipo, :valor, :saldoApos)
                    """)
                    .setParameter("tipo", tipo)
                    .setParameter("valor", valor)
                    .setParameter("saldoApos", saldoApos)
                    .executeUpdate();

            if (!transacaoAberta) {
                em.getTransaction().commit();
            }

        } catch (Exception e) {
            if (!transacaoAberta && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            throw new RuntimeException("Erro ao salvar movimento do caixa: " + e.getMessage(), e);
        }
    }

    private BigDecimal buscarSaldoAtual() {
        Object result = em.createNativeQuery("""
                SELECT COALESCE(
                    (
                        SELECT saldo_apos
                        FROM caixa_movimentos
                        ORDER BY id DESC
                        LIMIT 1
                    ),
                    0
                )
                """)
                .getSingleResult();

        return toBigDecimal(result);
    }

    private BigDecimal buscarValorAbertura() {
        Object result = em.createNativeQuery("""
                SELECT COALESCE(
                    (
                        SELECT valor
                        FROM caixa_movimentos
                        WHERE tipo = 'ABERTURA'
                        ORDER BY id DESC
                        LIMIT 1
                    ),
                    0
                )
                """)
                .getSingleResult();

        return toBigDecimal(result);
    }

    private BigDecimal buscarTotalEntradas() {
        Object result = em.createNativeQuery("""
                SELECT COALESCE(SUM(valor), 0)
                FROM caixa_movimentos
                WHERE tipo IN ('ABERTURA', 'ENTRADA')
                """)
                .getSingleResult();

        return toBigDecimal(result);
    }

    private BigDecimal buscarTotalDespesas() {
        Object result = em.createNativeQuery("""
                SELECT COALESCE(SUM(valor), 0)
                FROM caixa_movimentos
                WHERE tipo = 'DESPESA'
                """)
                .getSingleResult();

        return toBigDecimal(result);
    }

    private boolean existeAbertura() {
        Object result = em.createNativeQuery("""
                SELECT COUNT(*)
                FROM caixa_movimentos
                WHERE tipo = 'ABERTURA'
                """)
                .getSingleResult();

        return ((Number) result).longValue() > 0;
    }

    private List<MovimentoCaixa> buscarMovimentos() {
        List<Object[]> rows = em.createNativeQuery("""
                SELECT id, data_hora, tipo, valor, saldo_apos
                FROM caixa_movimentos
                ORDER BY id ASC
                """)
                .getResultList();

        List<MovimentoCaixa> movimentos = new ArrayList<>();

        for (Object[] row : rows) {
            Long id = ((Number) row[0]).longValue();
            Timestamp timestamp = (Timestamp) row[1];
            String tipo = String.valueOf(row[2]);
            BigDecimal valor = toBigDecimal(row[3]);
            BigDecimal saldoApos = toBigDecimal(row[4]);

            movimentos.add(
                    new MovimentoCaixa(
                            id,
                            timestamp.toLocalDateTime(),
                            MovimentoCaixa.TipoMovimentoCaixa.valueOf(tipo),
                            valor,
                            saldoApos
                    )
            );
        }

        return movimentos;
    }

    private BigDecimal toBigDecimal(Object value) {
        if (value == null) {
            return BigDecimal.ZERO;
        }

        if (value instanceof BigDecimal bigDecimal) {
            return bigDecimal;
        }

        if (value instanceof Number number) {
            return BigDecimal.valueOf(number.doubleValue());
        }

        return new BigDecimal(value.toString());
    }
}