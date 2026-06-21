package com.github.Gregorys2s.model.repositories;

import com.github.Gregorys2s.controller.pedidos.DTO.PedidosMasVendidosDTO;
import com.github.Gregorys2s.model.entity.ItemPedidos;
import com.github.Gregorys2s.model.entity.Pedidos;
import jakarta.persistence.EntityManager;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidosRepository {

    private EntityManager em;

    public PedidosRepository(EntityManager em) {
        this.em = em;
    }

    public Pedidos salvarPedido(Pedidos item) {
        try {
            em.getTransaction().begin();
            em.persist(item);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro ao salvar pedido: " + e.getMessage());
        }
        return item;
    }

    public List<Pedidos> procurarPedidos() {
        return em.createQuery("SELECT p FROM Pedidos p WHERE p.status = :status", Pedidos.class)
                .setParameter("status", Pedidos.statuspedidoenum.PENDENTE)
                .getResultList();
    }

    public List<Pedidos> procurarPedidosPorData(LocalDate data) {

        LocalDateTime inicio = data.atStartOfDay();
        LocalDateTime fim = data.plusDays(1).atStartOfDay();

        return em.createQuery(
                        "SELECT p FROM Pedidos p " +
                                "WHERE p.dataHora >= :inicio " +
                                "AND p.dataHora < :fim",
                        Pedidos.class)
                .setParameter("inicio", inicio)
                .setParameter("fim", fim)
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

    public List<PedidosMasVendidosDTO> buscarTop3MaisVendidos() {

        LocalDate hoje = LocalDate.now();
        LocalDateTime inicio = hoje.atStartOfDay();
        LocalDateTime fim = hoje.plusDays(1).atStartOfDay();

        String jpql = """
        SELECT ip.produto.nome, SUM(ip.quantidade)
        FROM ItemPedidos ip
        WHERE ip.pedido.dataHora >= :inicio
          AND ip.pedido.dataHora < :fim
          AND ip.pedido.status = :status
        GROUP BY ip.produto.id, ip.produto.nome
        ORDER BY SUM(ip.quantidade) DESC
        """;

        List<Object[]> resultado = em.createQuery(jpql, Object[].class)
                .setParameter("inicio", inicio)
                .setParameter("fim", fim)
                .setParameter("status", Pedidos.statuspedidoenum.PAGO)
                .setMaxResults(3)
                .getResultList();

        List<PedidosMasVendidosDTO> lista = new ArrayList<>();

        for (Object[] obj : resultado) {

            String nome = (String) obj[0];
            Integer quantidade = ((Long) obj[1]).intValue();

            lista.add(new PedidosMasVendidosDTO(nome, quantidade));
        }

        return lista;
    }

    public List<PedidosMasVendidosDTO> buscarTop3MaisVendidosSemanal() {

        LocalDate hoje = LocalDate.now();

        // Segunda-feira da semana atual
        LocalDate inicioSemana = hoje.with(DayOfWeek.MONDAY);

        // Próxima segunda-feira (fim exclusivo)
        LocalDate fimSemana = inicioSemana.plusWeeks(1);

        LocalDateTime inicio = inicioSemana.atStartOfDay();
        LocalDateTime fim = fimSemana.atStartOfDay();

        String jpql = """
        SELECT ip.produto.nome, SUM(ip.quantidade)
        FROM ItemPedidos ip
        WHERE ip.pedido.dataHora >= :inicio
          AND ip.pedido.dataHora < :fim
          AND ip.pedido.status = :status
        GROUP BY ip.produto.id, ip.produto.nome
        ORDER BY SUM(ip.quantidade) DESC
        """;

        List<Object[]> resultado = em.createQuery(jpql, Object[].class)
                .setParameter("inicio", inicio)
                .setParameter("fim", fim)
                .setParameter("status", Pedidos.statuspedidoenum.PAGO)
                .setMaxResults(3)
                .getResultList();

        List<PedidosMasVendidosDTO> lista = new ArrayList<>();

        for (Object[] obj : resultado) {
            String nome = (String) obj[0];
            Integer quantidade = ((Long) obj[1]).intValue();

            lista.add(new PedidosMasVendidosDTO(nome, quantidade));
        }

        return lista;
    }

    public void AtualizarPedidos(Integer id,Pedidos.statuspedidoenum status) {
        try {
            em.getTransaction().begin();
            Pedidos p = em.find(Pedidos.class, id);
            if (p != null) {
                p.setStatus(status);
                em.persist(p);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao atualizar status do pedido: " + e.getMessage());
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

    public List<Pedidos> procurarPedidosPorDataEStatus(
            LocalDate data,
            Pedidos.statuspedidoenum status) {

        LocalDateTime inicio = data.atStartOfDay();
        LocalDateTime fim = data.plusDays(1).atStartOfDay();

        return em.createQuery(
                        "SELECT p FROM Pedidos p " +
                                "WHERE p.dataHora >= :inicio " +
                                "AND p.dataHora < :fim " +
                                "AND p.status = :status",
                        Pedidos.class)
                .setParameter("inicio", inicio)
                .setParameter("fim", fim)
                .setParameter("status", status)
                .getResultList();
    }
}