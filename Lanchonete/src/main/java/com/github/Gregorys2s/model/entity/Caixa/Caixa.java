package com.github.Gregorys2s.model.entity.Caixa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Caixa {

    private boolean aberto;
    private BigDecimal saldo;
    private BigDecimal valorAbertura;
    private BigDecimal totalEntradas;
    private BigDecimal totalDespesas;
    private final List<MovimentoCaixa> movimentos;

    public Caixa() {
        this.aberto = false;
        this.saldo = BigDecimal.ZERO;
        this.valorAbertura = BigDecimal.ZERO;
        this.totalEntradas = BigDecimal.ZERO;
        this.totalDespesas = BigDecimal.ZERO;
        this.movimentos = new ArrayList<>();
    }

    public Caixa(
            boolean aberto,
            BigDecimal saldo,
            BigDecimal valorAbertura,
            BigDecimal totalEntradas,
            BigDecimal totalDespesas,
            List<MovimentoCaixa> movimentos
    ) {
        this.aberto = aberto;
        this.saldo = saldo == null ? BigDecimal.ZERO : saldo;
        this.valorAbertura = valorAbertura == null ? BigDecimal.ZERO : valorAbertura;
        this.totalEntradas = totalEntradas == null ? BigDecimal.ZERO : totalEntradas;
        this.totalDespesas = totalDespesas == null ? BigDecimal.ZERO : totalDespesas;
        this.movimentos = movimentos == null ? new ArrayList<>() : new ArrayList<>(movimentos);
    }

    public boolean isAberto() {
        return aberto;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public BigDecimal getValorAbertura() {
        return valorAbertura;
    }

    public BigDecimal getTotalEntradas() {
        return totalEntradas;
    }

    public BigDecimal getTotalDespesas() {
        return totalDespesas;
    }

    public List<MovimentoCaixa> getMovimentos() {
        return Collections.unmodifiableList(movimentos);
    }
}