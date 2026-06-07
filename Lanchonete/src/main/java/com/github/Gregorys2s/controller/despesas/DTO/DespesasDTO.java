package com.github.Gregorys2s.controller.despesas.DTO;



import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DespesasDTO {
    private Integer id;
    private LocalDateTime dataHora;
    private BigDecimal valorDespesa;

    public DespesasDTO(Integer id, LocalDateTime dataHora, BigDecimal valorDespesa) {
        this.id = id;
        this.dataHora = dataHora;
        this.valorDespesa = valorDespesa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public BigDecimal getValorDespesa() {
        return valorDespesa;
    }

    public void setValorDespesa(BigDecimal valorDespesa) {
        this.valorDespesa = valorDespesa;
    }
}
