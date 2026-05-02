package com.github.Gregorys2s.service;

import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.entity.ItemPedidos;
import com.github.Gregorys2s.entity.Pedidos;
import com.github.Gregorys2s.exceptions.AcharProdutoException;
import com.github.Gregorys2s.repositories.PedidosRepository;

import java.math.BigDecimal;
import java.util.List;

public class PedidosService {
    PedidosRepository repository;

    public PedidosService(PedidosRepository repository)
    {
        this.repository = repository;
    }

    public void salvarPedido(Pedidos item){
        item.setValorTotal(calcularTotal(item));
        item.setStatus(false);
        repository.salvarPedido(item);
    }

    public List<Pedidos> procurarPedidos()
    {
        return repository.procurarPedidos();
    }

    public Cardapio procurarId(long id)
    {
        Cardapio produto = repository.getProduto(id);
        seExistir(produto);
        return produto;
    }

    private void seExistir(Cardapio produto)
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
}
