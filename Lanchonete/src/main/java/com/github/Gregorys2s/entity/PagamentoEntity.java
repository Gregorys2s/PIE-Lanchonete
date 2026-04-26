package com.github.Gregorys2s.entity;

import com.github.Gregorys2s.entity.MetodoPagamentoEnum;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_pagamentos")
public class PagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Long idPagamento;

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
    private PedidosEntity pedido;



    public PagamentoEntity() {
    }



    public PagamentoEntity(Long idPedido,
                           BigDecimal valor,
                           BigDecimal taxa,
                           BigDecimal valorFinal,
                           String metodo,
                           String aprovado) {
    }



    public Long getIdPagamento() {
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

    public PedidosEntity getPedido(){
        return pedido;
    }

    public void setPedido(PedidosEntity pedido){
        this.pedido = pedido;
    }


    //Parte copiada da entidade
    @Override
    public String toString(){
        return "Pagamento{" +
                "idPedido=" + pedido +
                ", valorOriiginal=" + valorOriginal +
                ", taxa=" + taxa +
                ", valorFinal=" + valorFinal +
                // No momento, deixei essa parte em comentário, pois acredito que o metodo ainda não oi criao
                //", metodoPagamento=" + metodoPagamento +
                ", status=" + status +
                ", dataPagamento=" + dataPagamento + '}';
    }

}