package com.github.Gregorys2s.repositories;

import com.github.Gregorys2s.entity.Cardapio;
import jakarta.persistence.EntityManager;

public class PedidosRepository {

    private EntityManager em;

    public PedidosRepository(EntityManager em) {
        this.em = em;
    }

    public Cardapio getProduto(long id)
    {
        Cardapio produto = em.find(Cardapio.class,id);
        return produto;
    }
}
