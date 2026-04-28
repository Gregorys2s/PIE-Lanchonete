package com.github.Gregorys2s.entity;

import java.util.List;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Table (name = "pedidos")

public class Pedidos {

    @Id
    @GeneratedValue(strategy =   GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_hora", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dataHora;

    @Column(name = "valor_total", precision = 10, scale = 2, nullable = false)
    private BigDecimal valorTotal;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)

    private List<ItemPedidos> itens = new ArrayList<>();

    public Pedidos(){}

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

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemPedidos> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidos> itens) {
        this.itens = itens;
    }
}