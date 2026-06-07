package com.github.Gregorys2s.controller.cardapio.DTO;

import java.math.BigDecimal;

public class CardapioDTO {
    private Integer id;
    private String nome;
    private BigDecimal preco;
    private String tipo;

    public CardapioDTO(Integer id, String nome, BigDecimal preco, String tipo) {
        this.id = id;
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
