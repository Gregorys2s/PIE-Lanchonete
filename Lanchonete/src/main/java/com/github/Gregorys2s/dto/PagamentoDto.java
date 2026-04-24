package com.github.Gregorys2s.dto;

public class PagamentoDto {
    private Long idPedido;
    private String metodoPagamento;

    public PagamentoDto(){
    }

    public PagamentoDto(long idPedido, String metodoPagamento){
        this.idPedido = idPedido;
        this.metodoPagamento = metodoPagamento;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
}
