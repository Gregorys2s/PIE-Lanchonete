package com.github.Gregorys2s.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pagamento {

    private Long idPedido;
    private BigDecimal valorOriginal;
    private BigDecimal taxa;
    private BigDecimal valorFinal;
    private String metodoPagamento;
    private String status;
    private LocalDateTime dataPagamento;

    public Pagamento(Long idPedido, BigDecimal valorOriginal, BigDecimal taxa, BigDecimal valorFinal, String metodoPagamento,String status){
        this.idPedido = idPedido;
        this.valorOriginal = valorOriginal;
        this.taxa = taxa;
        this.valorFinal = valorFinal;
        this.metodoPagamento = metodoPagamento;
        this.status = status;
        this.dataPagamento = LocalDateTime.now();
    }

    public BigDecimal getValorFinal(){
        return valorFinal;
    }

    @Override
    public String toString(){
        return "Pagamento{" +
                "idPedido=" + idPedido +
                ", valorOriiginal=" + valorOriginal +
                ", taxa=" + taxa +
                ", valorFinal=" + valorFinal +
                ", metodoPagamento=" + metodoPagamento +
                ", status=" + status +
                ", dataPagamento=" + dataPagamento + '}';
    }

}
