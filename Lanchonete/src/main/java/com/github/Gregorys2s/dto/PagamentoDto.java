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

    private BigDecimal getValor(){
        return valor;
    }

    private String getMetodoPagamento(){
        return metodoPagamento;
    }
}
