package com.github.Gregorys2s.entity;


import jakarta.persistence.*;
import java.math.BigDecimal;


@SuppressWarnings("GrazieInspectionRunner")
@Entity
@Table(name = "produtos") //ver nome na tabela depois
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private String tipo;

    public Cardapio() {
    }
    public Cardapio(String nome, BigDecimal preco, String tipo) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
    }
    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}