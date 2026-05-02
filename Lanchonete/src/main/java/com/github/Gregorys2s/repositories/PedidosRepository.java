package com.github.Gregorys2s.repositories;

import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.entity.ItemPedidos;
import com.github.Gregorys2s.entity.Pedidos;
import com.github.Gregorys2s.exceptions.PersistenciaProdutoRepositoryException;
import jakarta.persistence.EntityManager;

import java.time.LocalDateTime;
import java.util.List;

public class PedidosRepository {

    private EntityManager em;

    public PedidosRepository(EntityManager em) {
        this.em = em;
    }

    public void salvarPedido(Pedidos item) {
        try {
            em.getTransaction().begin();
            em.persist(item);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro ao salvar pedido: " + e.getMessage());
        }
    }

    public List<Pedidos> procurarPedidos() {
        return em.createQuery("SELECT p FROM Pedidos p WHERE p.status = false", Pedidos.class)
                .getResultList();
    }

    public Pedidos buscarIdPedido(Integer id) {
        return em.find(Pedidos.class, id);
    }

    public ItemPedidos buscarIdItem(Integer id)
    {
        return em.find(ItemPedidos.class, id);
    }


    public List<Pedidos> buscarPedidosFinalizadosPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return em.createQuery(
                        "SELECT p FROM Pedidos p WHERE p.status = true " +
                                "AND p.dataHora >= :inicio AND p.dataHora < :fim",
                        Pedidos.class)
                .setParameter("inicio", inicio)
                .setParameter("fim", fim)
                .getResultList();
    }

    public void apagarPedido(Integer id) {
        try {
            em.getTransaction().begin();
            Pedidos p = em.find(Pedidos.class, id);
            if (p != null)
            {
                em.remove(p);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public void apagarItem(int id) {
        try {
            em.getTransaction().begin();

            ItemPedidos item = em.find(ItemPedidos.class, id);

            if (item == null) {
                em.getTransaction().rollback();
                return;
            }

            item.getPedido().getItens().remove(item);

            em.remove(em.contains(item) ? item : em.merge(item));

            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException(e);
        }
    }
}
