package com.github.Gregorys2s.entity;

import com.github.Gregorys2s.entity.pagamentosEnum.MetodoPagamentoEnum;
import com.github.Gregorys2s.entity.pagamentosEnum.StatusPagamentoEnum;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Integer idPagamento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MetodoPagamentoEnum metodo; // Corrigido para usar o Enum

    @Column(name = "valor_original", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorOriginal;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal taxa;

    @Column(name = "valor_final", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorFinal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPagamentoEnum status; // Mantida apenas esta declaração

    @Column(name = "data_pagamento", nullable = false)
    private LocalDateTime dataPagamento;

    @OneToOne
    @JoinColumn(name = "fk_pedido_id", nullable = false, unique = true)
    private Pedidos pedido;



    public Pagamento() {
    }



    public Pagamento(Long idPedido,
                     BigDecimal valor,
                     BigDecimal taxa,
                     BigDecimal valorFinal,
                     String metodo,
                     String aprovado) {
    }



    public Integer getIdPagamento() {
        return idPagamento;
    }

    public MetodoPagamentoEnum getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoPagamentoEnum metodo) {
        this.metodo = metodo;
    }

    public BigDecimal getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(BigDecimal valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    public StatusPagamentoEnum getStatus() {
        return status;
    }

    public void setStatus(StatusPagamentoEnum status) {
        this.status = status;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Pedidos getPedido(){
        return pedido;
    }

    public void setPedido(Pedidos pedido){
        this.pedido = pedido;
    }

}