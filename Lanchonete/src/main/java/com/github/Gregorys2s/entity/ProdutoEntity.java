package com.github.Gregorys2s.entity;

import jakarta.persistence.*;
import jakarta.persistence.Column;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, precision = 10, scale = 2)
    private java.math.BigDecimal preco;

    public ProdutoEntity() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = Math.toIntExact(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
