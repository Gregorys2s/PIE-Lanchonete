package com.github.Gregorys2s.controller.pedidos.DTO;

import com.github.Gregorys2s.model.entity.ItemPedidos;
import com.github.Gregorys2s.model.entity.Pedidos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PedidosDTO {
    private Integer id;
    private BigDecimal valorTotal;
    private BigDecimal adicionais;
    private Pedidos.statuspedidoenum status;
    private List<ItemPedidos> itens;
    private LocalDateTime dataHora;

    public PedidosDTO() {}
    public PedidosDTO(Integer id, BigDecimal valorTotal, BigDecimal adicionais, Pedidos.statuspedidoenum status, List<ItemPedidos> itens, LocalDateTime dataHora) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.adicionais = adicionais;
        this.status = status;
        this.itens = itens;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(BigDecimal adicionais) {
        this.adicionais = adicionais;
    }

    public Pedidos.statuspedidoenum getStatus() {
        return status;
    }

    public void setStatus(Pedidos.statuspedidoenum status) {
        this.status = status;
    }

    public List<ItemPedidos> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidos> itens) {
        this.itens = itens;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
