package com.github.Gregorys2s.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "relatorio_semanal")
public class RelatorioSemanal {

    @Id
    @Column(name = "semana_inicio", nullable = false)
    private LocalDate semanaInicio;

    @Column(name = "total_pedidos", nullable = false)
    private Integer totalPedidos = 0;

    @Column(name = "lucro_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal lucroTotal = BigDecimal.ZERO;

    @Column(name = "despesas_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal despesasTotal = BigDecimal.ZERO;

    public RelatorioSemanal() {}

    public RelatorioSemanal(LocalDate semanaInicio, Integer totalPedidos,
                            BigDecimal lucroTotal, BigDecimal despesasTotal) {
        this.semanaInicio = semanaInicio;
        this.totalPedidos = totalPedidos;
        this.lucroTotal = lucroTotal;
        this.despesasTotal = despesasTotal;
    }

    public LocalDate getSemanaInicio() {
        return semanaInicio;
    }

    public void setSemanaInicio(LocalDate semanaInicio) {
        this.semanaInicio = semanaInicio;
    }

    public Integer getTotalPedidos() {
        return totalPedidos;
    }

    public void setTotalPedidos(Integer totalPedidos) {
        this.totalPedidos = totalPedidos;
    }

    public BigDecimal getLucroTotal() {
        return lucroTotal;
    }

    public void setLucroTotal(BigDecimal lucroTotal) {
        this.lucroTotal = lucroTotal;
    }

    public BigDecimal getDespesasTotal() {
        return despesasTotal;
    }

    public void setDespesasTotal(BigDecimal despesasTotal) {
        this.despesasTotal = despesasTotal;
    }
}