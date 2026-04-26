package com.github.Gregorys2s.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ItemPedido_ProdutoEntityEntity")

public class ItemPedidosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_pedido_id")
    private PedidosEntity pedido;

    @ManyToOne
    @JoinColumn(name = "fk_produto_id")
    private ProdutoEntity produto;

    private int quantidade;

    public void setPedido(PedidosEntity pedido) { this.pedido = pedido; }
    public void setProduto(ProdutoEntity produto) { this.produto = produto; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public ItemPedidosEntity(){}
    public PedidosEntity getPedido() { return pedido; }
    public ProdutoEntity getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
}