package com.github.Gregorys2s.controller.relatoriosSemanal.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RelatoriosSemanalesDTO {

    private LocalDate semanaInicio;
    private Integer totalPedidos;
    private BigDecimal lucroTotal;
    private BigDecimal despesasTotal;


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