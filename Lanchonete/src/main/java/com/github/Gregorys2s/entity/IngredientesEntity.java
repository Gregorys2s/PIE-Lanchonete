package com.github.Gregorys2s.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredientes")
public class IngredientesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private int estoque;

    public IngredientesEntity() {
    }

    public IngredientesEntity(String nome, int estoque) {
        this.nome = nome;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

}
