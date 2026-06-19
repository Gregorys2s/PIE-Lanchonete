package com.github.Gregorys2s.controller.pedidos.Implementacoes;

import com.github.Gregorys2s.controller.pedidos.DTO.PedidosMasVendidosDTO;
import com.github.Gregorys2s.controller.pedidos.PedidosInterface;
import com.github.Gregorys2s.controller.pedidos.DTO.PedidosDTO;
import com.github.Gregorys2s.model.entity.Pedidos;
import com.github.Gregorys2s.model.service.pedidos.PedidosService;
import com.github.Gregorys2s.view.pedidos.CardPedido;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidosController implements PedidosInterface {

    PedidosService service;

    public PedidosController(PedidosService service) {
        this.service = service;
    }

    @Override
    public void salvar(PedidosDTO item)
    {
        service.salvarPedido(item);
    }

    @Override
    public List<PedidosDTO> procurarPedidos() {
        List<Pedidos> pedidos = service.procurarPedidos();
        List<PedidosDTO> lista = new ArrayList<>();

        for(Pedidos pedido: pedidos){
            lista.add(new PedidosDTO(
                    pedido.getId(),
                    pedido.getValorTotal(),
                    pedido.getAdicionais(),
                    pedido.getStatus(),
                    pedido.getItens(),
                    pedido.getDataHora()
            ));
        }
        return lista;

    }

    @Override
    public List<PedidosDTO> procurarPedidosPorData(LocalDate data) {
        return service.procurarPedidosPorData(data);
    }

    @Override
    public PedidosDTO procurarPorId(Integer id)
    {
        PedidosDTO pedidos = service.procurarId(id);
        return new PedidosDTO(
                pedidos.getId(),
                pedidos.getValorTotal(),
                pedidos.getAdicionais(),
                pedidos.getStatus(),
                pedidos.getItens(),
                pedidos.getDataHora()

        );
    }

    public List<PedidosMasVendidosDTO> buscarTop3MaisVendidos() {
        return service.buscarTop3MaisVendidos();
    }

    @Override
    public void cancelarPedido (Integer id)
    {
        service.CancelarPedido(id);
    }

    @Override
    public void apagarItem(Integer id)
    {
        service.apagarItem(id);
    }

    @Override
    public void finalizarPedido(PedidosDTO pedido, String metodoPagamento, BigDecimal valorPago){
        try {
            service.finalizarPedido(pedido,metodoPagamento,valorPago);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("erro ao finalizar: " + e.getMessage());
        }
    }

    @Override
    public BigDecimal calcularTroco(BigDecimal valorPago,PedidosDTO pedido)
    {
        return service.calcularTroco(valorPago,pedido);
    }
}
