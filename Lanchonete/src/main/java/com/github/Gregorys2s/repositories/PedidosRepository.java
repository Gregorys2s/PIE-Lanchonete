package com.github.Gregorys2s.repositories;

import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.entity.ItemPedidos;
import com.github.Gregorys2s.entity.Pedidos;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PedidosRepository {

    private EntityManager em;

    public PedidosRepository(EntityManager em) {
        this.em = em;
    }

    public void salvarPedido(Pedidos item)
    {
        try{
            em.getTransaction().begin();
            em.persist(item);
            em.getTransaction().commit();
        }
        catch (Exception e)
        {
            em.getTransaction().rollback();
            System.out.println("Erro ao salvar pedido: " + e.getMessage());
        }


    }

    public List<Pedidos> procurarPedidos()
    {
        return em.createQuery("SELECT p FROM Pedidos p WHERE p.status = false", Pedidos.class)
                .getResultList();
    }

    public Cardapio getProduto(long id)
    {
        Cardapio produto = em.find(Cardapio.class,id);
        return produto;
    }
}
