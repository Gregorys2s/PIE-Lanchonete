package com.github.Gregorys2s.controller;

import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.entity.ItemPedidos;
import com.github.Gregorys2s.entity.Pagamento;
import com.github.Gregorys2s.entity.Pedidos;
import com.github.Gregorys2s.service.PedidosService;

import java.math.BigDecimal;
import java.util.List;

public class PedidosController {

    PedidosService service;

    public PedidosController(PedidosService service) {
        this.service = service;
    }

    public void guardarPedido(Pedidos item)
    {
        service.salvarPedido(item);
    }

    public List<Pedidos> procurarPedidos()
    {
        return service.procurarPedidos();
    }

    public Pedidos procurarPorId(Integer id)
    {
        return service.procurarId(id);
    }

    public void apagarPedido (Integer id)
    {
        service.CancelarPedido(id);
    }

    public void apagarItem(Integer id)
    {
        service.apagarItem(id);
    }
    public void finalizarPedido(Pedidos pedido, String metodoPagamento, BigDecimal valorPago){
        try {
            service.finalizarPedido(pedido,metodoPagamento,valorPago);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("erro ao finalizar: " + e.getMessage());
        }
    }

    public BigDecimal calcularTroco(BigDecimal valorPago,Pedidos pedido)
    {
        return service.calcularTroco(valorPago,pedido);
    }
}
