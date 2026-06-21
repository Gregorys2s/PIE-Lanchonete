package com.github.Gregorys2s.controller.pedidos;

import com.github.Gregorys2s.controller.pedidos.DTO.PedidosDTO;
import com.github.Gregorys2s.model.entity.Pedidos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface PedidosInterface {
    public void salvar(PedidosDTO item);
    public List<PedidosDTO> procurarPedidos();
    public List<PedidosDTO> procurarPedidosPorData(LocalDate data);
    public PedidosDTO procurarPorId(Integer id);
    public void cancelarPedido (Integer id);
    public void apagarItem(Integer id);
    public void finalizarPedido(PedidosDTO pedido, String metodoPagamento, BigDecimal valorPago);
    public BigDecimal calcularTroco(BigDecimal valorPago,PedidosDTO pedido);
    void atualizarStatusPedido(Integer id, Pedidos.statuspedidoenum status);

}
