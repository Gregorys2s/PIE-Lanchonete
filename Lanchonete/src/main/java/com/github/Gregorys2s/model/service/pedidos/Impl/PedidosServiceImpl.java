package com.github.Gregorys2s.model.service.pedidos.Impl;

import com.github.Gregorys2s.controller.pagamento.dto.PagamentoDto;
import com.github.Gregorys2s.controller.pedidos.DTO.PedidosDTO;
import com.github.Gregorys2s.controller.pedidos.DTO.PedidosMasVendidosDTO;
import com.github.Gregorys2s.exceptions.AcharProdutoException;
import com.github.Gregorys2s.model.entity.ItemPedidos;
import com.github.Gregorys2s.model.entity.Pedidos;
import com.github.Gregorys2s.model.repositories.PedidosRepository;
import com.github.Gregorys2s.model.service.pagamento.PagamentoService;
import com.github.Gregorys2s.model.service.pedidos.PedidosService;
import com.github.Gregorys2s.model.entity.Pagamento;
import com.github.Gregorys2s.model.service.caixa.CaixaService;
import com.github.Gregorys2s.model.service.pagamento.metodo.StatusPagamentoEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PedidosServiceImpl implements PedidosService {
    private final PedidosRepository repository;
    private final PagamentoService pagamentoService;
    private final CaixaService caixaService;

    public PedidosServiceImpl(PedidosRepository repository, PagamentoService pagamentoService,CaixaService caixaService) {
        this.repository = repository;
        this.pagamentoService = pagamentoService;
        this.caixaService = caixaService;
    }

    @Override
    public void salvarPedido(PedidosDTO dto){
        dto.setValorTotal(calcularTotal(dto));

        if (dto.getValorTotal().compareTo(BigDecimal.ZERO) <= 0){
            System.out.println("Pedido vacio");
            return;
        }

        dto.setDataHora(LocalDateTime.now());
        dto.setStatus(Pedidos.statuspedidoenum.PENDENTE);

        Pedidos pedido = new Pedidos();

        pedido.setStatus(dto.getStatus());
        pedido.setDataHora(dto.getDataHora());
        pedido.setValorTotal(dto.getValorTotal());
        pedido.setItens(dto.getItens());
        pedido.setAdicionais(dto.getAdicionais());
        for (ItemPedidos item : pedido.getItens()) {
            item.setPedido(pedido);
        }
        pedido.setTipoDePedido(dto.getTipoDePedido());


        repository.salvarPedido(pedido);
    }

    @Override
    public List<Pedidos> procurarPedidos()
    {
        return repository.procurarPedidos();
    }

    @Override
    public List<PedidosDTO> procurarPedidosPorData(LocalDate data) {

        return repository.procurarPedidosPorData(data)
                .stream()
                .map(pedido -> new PedidosDTO(
                        pedido.getId(),
                        pedido.getValorTotal(),
                        pedido.getAdicionais(),
                        pedido.getStatus(),
                        pedido.getItens(),
                        pedido.getDataHora(),
                        pedido.getTipoDePedido()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<PedidosMasVendidosDTO> buscarTop3MaisVendidos() {
        return repository.buscarTop3MaisVendidos();
    }

    @Override
    public List<PedidosMasVendidosDTO> buscarTop3MaisVendidosSemanal(){
        return repository.buscarTop3MaisVendidosSemanal();
    }

    @Override
    public PedidosDTO procurarId(Integer id)
    {
        Pedidos produto = repository.buscarIdPedido(id);
        seExistir(produto);

        PedidosDTO dto = new PedidosDTO();


            dto.setValorTotal(produto.getValorTotal());
            dto.setStatus(produto.getStatus());
            dto.setAdicionais(produto.getAdicionais());
            dto.setItens(produto.getItens());

        return dto;
    }

    private void seExistir(Pedidos produto)
    {
        //tinha outro nome nao
        if (produto == null)
        {
            throw new AcharProdutoException("Produto nao encontrado");
        }
    }


    BigDecimal calcularTotal(PedidosDTO pedido)
    {
        BigDecimal valorTotal = BigDecimal.ZERO;

        for (int i = 0;i <  pedido.getItens().size();i++)
        {
            int quantidade = pedido.getItens().get(i).getQuantidade();
            BigDecimal preco = pedido.getItens().get(i).getProduto().getPreco();
            BigDecimal subtotal = preco.multiply(BigDecimal.valueOf(quantidade));
            valorTotal = valorTotal.add(subtotal);
        }
        if (pedido.getAdicionais() != null) {
            valorTotal = valorTotal.add(pedido.getAdicionais());
        }
        return valorTotal;
    }

    @Override
    public void finalizarPedido(PedidosDTO pedido, String metodoPagamento, BigDecimal valorPago){
        if (pedido == null){
            throw new IllegalArgumentException("pedido nao pode ser nulo");
        }
        if (pedido.getItens().isEmpty()){
            throw new IllegalArgumentException("pedido nao pode estar vazio");
        }
        if (metodoPagamento == null){
            throw new IllegalArgumentException("metodo invalido");
        }

        BigDecimal total = calcularTotal(pedido);

        if (valorPago.compareTo(total) < 0){
            throw new IllegalArgumentException("valor pago menor que o total do pedido");
        }

        pedido.setValorTotal(total);
        pedido.setDataHora(LocalDateTime.now());
        pedido.setStatus(Pedidos.statuspedidoenum.PAGO);

        PagamentoDto dto = new PagamentoDto(
                pedido.getId(),
                total,
                metodoPagamento
        );
        //aqui adiciona o valor na caixa

        pagamentoService.processar(dto);
    }

    @Override
    public void CancelarPedido(Integer id)
    {
        Pedidos pedido = repository.buscarIdPedido(id);
        seExistir(pedido);
        repository.AtualizarPedidos(id, Pedidos.statuspedidoenum.CANCELADO);
    }

    @Override
    public void apagarItem(Integer id)
    {
        ItemPedidos item = repository.buscarIdItem(id);
        if (item == null)
        {
            throw new AcharProdutoException("Item não encontrado no pedido");
        }
        repository.apagarItem(id);
    }

    @Override
    public BigDecimal calcularTroco(BigDecimal valorPago,PedidosDTO pedido)
    {
        BigDecimal troco;
        BigDecimal total = calcularTotal(pedido);
        troco = valorPago.subtract(total);
        return troco;

    }

    @Override
    public void atualizarStatusPedido(Integer id, Pedidos.statuspedidoenum status) {

        repository.AtualizarPedidos(id,status);
    }

    @Override
    public List<PedidosDTO> procurarPedidosPorStatus(
            LocalDate data,
            Pedidos.statuspedidoenum status) {

        return repository.procurarPedidosPorDataEStatus(data, status)
                .stream()
                .map(pedido -> new PedidosDTO(
                        pedido.getId(),
                        pedido.getValorTotal(),
                        pedido.getAdicionais(),
                        pedido.getStatus(),
                        pedido.getItens(),
                        pedido.getDataHora(),
                        pedido.getTipoDePedido()
                ))
                .collect(Collectors.toList());
    }
}
