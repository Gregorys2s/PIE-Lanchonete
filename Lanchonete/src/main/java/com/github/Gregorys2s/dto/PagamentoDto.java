package com.github.Gregorys2s.dto;

import java.math.BigDecimal;

public class PagamentoDto {
    private Integer idPedido;
    private BigDecimal valor;
    private String metodoPagamento;

    public PagamentoDto(){
    }

    public PagamentoDto(Integer idPedido,BigDecimal valor, String metodoPagamento){
        this.idPedido = idPedido;
        this.metodoPagamento = metodoPagamento;
        this.valor = valor;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
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
