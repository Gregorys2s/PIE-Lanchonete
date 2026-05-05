package com.github.Gregorys2s.service;

import com.github.Gregorys2s.dto.PagamentoDto;
import com.github.Gregorys2s.entity.ItemPedidos;
import com.github.Gregorys2s.entity.Pedidos;
import com.github.Gregorys2s.exceptions.AcharProdutoException;
import com.github.Gregorys2s.repositories.PedidosRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PedidosService {
    private final PedidosRepository repository;
    private final PagamentoService pagamentoService;


    public PedidosService(PedidosRepository repository, PagamentoService pagamentoService)
    {
        this.repository = repository;
        this.pagamentoService = pagamentoService;
    }

    public void salvarPedido(Pedidos item){
        item.setValorTotal(calcularTotal(item));
        item.setDataHora(LocalDateTime.now());
        item.setStatus(Pedidos.statuspedidoenum.PENDENTE);
        repository.salvarPedido(item);
    }

    public List<Pedidos> procurarPedidos()
    {
        return repository.procurarPedidos();
    }

    public Pedidos procurarId(Integer id)
    {
        Pedidos produto = repository.buscarIdPedido(id);
        seExistir(produto);
        return produto;
    }

    private void seExistir(Pedidos produto)
    {
        //tinha outro nome nao
        if (produto == null)
        {
            throw new AcharProdutoException("Produto nao encontrado");
        }
    }

    BigDecimal calcularTotal(Pedidos pedido)
    {
        BigDecimal valorTotal = BigDecimal.ZERO;

        for (int i = 0;i <  pedido.getItens().size();i++)
        {
            int quantidade = pedido.getItens().get(i).getQuantidade();
            BigDecimal preco = pedido.getItens().get(i).getProduto().getPreco();
            BigDecimal subtotal = preco.multiply(BigDecimal.valueOf(quantidade));
            valorTotal = valorTotal.add(subtotal);
        }
        valorTotal = valorTotal.add(pedido.getAdicionais());
        return valorTotal;
    }

    public void finalizarPedido(Pedidos pedido, String metodoPagamento){
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
        pedido.setValorTotal(total);
        pedido.setDataHora(LocalDateTime.now());
        pedido.setStatus(Pedidos.statuspedidoenum.PAGO);

        PagamentoDto dto = new PagamentoDto(
                pedido.getId(),
                total,
                metodoPagamento
        );

        pagamentoService.processar(dto);
    }

    public void apagarPedido(Integer id)
    {
        Pedidos pedido = repository.buscarIdPedido(id);
        seExistir(pedido);
        repository.apagarPedido(id);
    }

    public void apagarItem(Integer id)
    {
        ItemPedidos item = repository.buscarIdItem(id);
        if (item == null)
        {
            throw new AcharProdutoException("Item não encontrado no pedido");
        }
        repository.apagarItem(id);
    }
}
