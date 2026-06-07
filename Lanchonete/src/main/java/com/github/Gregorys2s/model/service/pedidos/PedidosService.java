package com.github.Gregorys2s.model.service.pedidos;

import com.github.Gregorys2s.controller.pedidos.DTO.PedidosDTO;
import com.github.Gregorys2s.model.entity.Pedidos;

import java.math.BigDecimal;
import java.util.List;

public interface PedidosService {
    void salvarPedido(PedidosDTO item);
    List<Pedidos> procurarPedidos();
    PedidosDTO procurarId(Integer id);
    void finalizarPedido(PedidosDTO pedido, String metodoPagamento, BigDecimal valorPago);
    void CancelarPedido(Integer id);
    void apagarItem(Integer id);
    BigDecimal calcularTroco(BigDecimal valorPago, PedidosDTO pedido);
}
