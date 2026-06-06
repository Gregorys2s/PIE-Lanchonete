package com.github.Gregorys2s.controller.ingredientes.DTO;

import com.github.Gregorys2s.model.entity.Ingredientes;

import java.util.List;

public class IngredientesDTO {
    private Integer id;
    private String nome;
    private Integer estoque;
    private List<Ingredientes> ingredientes;

    public IngredientesDTO(List<Ingredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }


    public IngredientesDTO(Integer id, String nome, Integer estoque) {
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

}
