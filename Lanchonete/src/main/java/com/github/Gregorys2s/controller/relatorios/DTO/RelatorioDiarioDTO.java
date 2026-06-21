package com.github.Gregorys2s.controller.relatorios.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RelatorioDiarioDTO {
    private Integer id;
    private LocalDate data;
    private Integer quantidadePedidos;
    private BigDecimal despesas;
    private BigDecimal lucroTotal;
    private BigDecimal estoqueFinal;

    public RelatorioDiarioDTO(Integer id, LocalDate data, Integer quantidadePedidos, BigDecimal despesas, BigDecimal lucroTotal, BigDecimal estoqueFinal) {
        this.id = id;
        this.data = data;
        this.quantidadePedidos = quantidadePedidos;
        this.despesas = despesas;
        this.lucroTotal = lucroTotal;
        this.estoqueFinal = estoqueFinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getQuantidadePedidos() {
        return quantidadePedidos;
    }

    public void setQuantidadePedidos(Integer quantidadePedidos) {
        this.quantidadePedidos = quantidadePedidos;
    }

    public BigDecimal getDespesas() {
        return despesas;
    }

    public void setDespesas(BigDecimal despesas) {
        this.despesas = despesas;
    }

    public BigDecimal getLucroTotal() {
        return lucroTotal;
    }



    public BigDecimal getEstoqueFinal() {
        return estoqueFinal;
    }

    public void setEstoqueFinal(BigDecimal estoqueFinal) {
        this.estoqueFinal = estoqueFinal;
    }
}
