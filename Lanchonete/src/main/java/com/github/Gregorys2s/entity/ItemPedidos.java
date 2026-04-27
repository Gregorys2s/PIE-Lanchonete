package com.github.Gregorys2s.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ItemPedidos")

public class ItemPedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_pedido_id")
    private ItemPedidos pedido;

    @ManyToOne
    @JoinColumn(name = "fk_produto_id")
    private Cardapio produto;

    private int quantidade;

    public void setPedido(ItemPedidos pedido) { this.pedido = pedido; }
    public void setProduto(Cardapio produto) { this.produto = produto; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public ItemPedidos(){}
    public ItemPedidos getPedido() { return pedido; }
    public Cardapio getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
}