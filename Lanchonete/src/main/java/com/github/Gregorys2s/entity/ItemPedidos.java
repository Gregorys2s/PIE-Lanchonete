package com.github.Gregorys2s.entity;

import com.github.Gregorys2s.service.PedidosService;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ItemPedido")

public class ItemPedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_pedido_id")
    private Pedidos pedido;

    @ManyToOne
    @JoinColumn(name = "fk_cardapio_id")
    private Cardapio produto;

    private int quantidade;

    public void setPedido(Pedidos pedido) { this.pedido = pedido; }
    public void setProduto(Cardapio produto) { this.produto = produto; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public ItemPedidos(){}
    public Pedidos getPedido() { return pedido; }
    public Cardapio getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
}