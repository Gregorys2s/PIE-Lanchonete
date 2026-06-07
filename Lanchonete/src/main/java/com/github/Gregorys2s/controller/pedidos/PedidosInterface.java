package com.github.Gregorys2s.controller.pedidos;

import com.github.Gregorys2s.controller.pedidos.DTO.PedidosDTO;

import java.math.BigDecimal;
import java.util.List;

public interface PedidosInterface {
    public void salvar(PedidosDTO item);
    public List<PedidosDTO> procurarPedidos();
    public PedidosDTO procurarPorId(Integer id);
    public void cancelarPedido (Integer id);
    public void apagarItem(Integer id);
    public void finalizarPedido(PedidosDTO pedido, String metodoPagamento, BigDecimal valorPago);
    public BigDecimal calcularTroco(BigDecimal valorPago,PedidosDTO pedido);
}
