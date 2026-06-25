package com.github.Gregorys2s.model.service.pedidos;

import com.github.Gregorys2s.controller.pedidos.DTO.PedidosDTO;
import com.github.Gregorys2s.controller.pedidos.DTO.PedidosMasVendidosDTO;
import com.github.Gregorys2s.model.entity.Pedidos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface PedidosService {
    void salvarPedido(PedidosDTO item);
    List<Pedidos> procurarPedidos();
    List<PedidosDTO> procurarPedidosPorData(LocalDate data);
    List<PedidosMasVendidosDTO> buscarTop3MaisVendidos();
    public List<PedidosMasVendidosDTO> buscarTop3MaisVendidosSemanal();
    PedidosDTO procurarId(Integer id);
    void finalizarPedido(PedidosDTO pedido, String metodoPagamento, BigDecimal valorPago);
    void CancelarPedido(Integer id);
    void apagarItem(Integer id);
    BigDecimal calcularTroco(BigDecimal valorPago, PedidosDTO pedido);
    void atualizarStatusPedido(Integer id,  Pedidos.statuspedidoenum status);
    List<PedidosDTO> procurarPedidosPorStatus(
            LocalDate data,
            Pedidos.statuspedidoenum status);
}
