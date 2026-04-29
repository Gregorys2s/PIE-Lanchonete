package com.github.Gregorys2s.dto;

import java.math.BigDecimal;

public class PagamentoDto {
    private Long idPedido;
    private BigDecimal valor;
    private String metodoPagamento;

    public PagamentoDto(){
    }

    public PagamentoDto(long idPedido,BigDecimal valor, String metodoPagamento){
        this.idPedido = idPedido;
        this.metodoPagamento = metodoPagamento;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public BigDecimal getValor(){
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getMetodoPagamento(){
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
}
