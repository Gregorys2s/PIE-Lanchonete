package com.github.Gregorys2s.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "relatorio_diario")
public class RelatorioDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "quantidade_pedidos", nullable = false)
    private Integer quantidadePedidos = 0;

    @Column(name = "despesas", nullable = false, precision = 10, scale = 2)
    private BigDecimal despesas = BigDecimal.ZERO;

    @Column(name = "lucro_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal lucroTotal = BigDecimal.ZERO;

    // Baixa prioridade — campo opcional por enquanto
    @Column(name = "estoque_final", precision = 10, scale = 2)
    private BigDecimal estoqueFinal;

    public RelatorioDiario() {}

    public RelatorioDiario(LocalDate data, Integer quantidadePedidos,
                           BigDecimal despesas, BigDecimal lucroTotal) {
        this.data = data;
        this.quantidadePedidos = quantidadePedidos;
        this.despesas = despesas;
        this.lucroTotal = lucroTotal;
    }

    public Integer getId() { return id; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public Integer getQuantidadePedidos() { return quantidadePedidos; }
    public void setQuantidadePedidos(Integer quantidadePedidos) { this.quantidadePedidos = quantidadePedidos; }

    public BigDecimal getDespesas() { return despesas; }
    public void setDespesas(BigDecimal despesas) { this.despesas = despesas; }

    public BigDecimal getLucroTotal() { return lucroTotal; }
    public void setLucroTotal(BigDecimal lucroTotal) { this.lucroTotal = lucroTotal; }

    public BigDecimal getEstoqueFinal() { return estoqueFinal; }
    public void setEstoqueFinal(BigDecimal estoqueFinal) { this.estoqueFinal = estoqueFinal; }
}
