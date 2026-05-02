package com.github.Gregorys2s.service;

import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.entity.ItemPedidos;
import com.github.Gregorys2s.entity.Pedidos;
import com.github.Gregorys2s.exceptions.AcharProdutoException;
import com.github.Gregorys2s.repositories.PedidosRepository;

import java.util.List;

public class PedidosService {
    PedidosRepository repository;

    public PedidosService(PedidosRepository repository)
    {
        this.repository = repository;
    }

    public void salvarPedido(Pedidos item){
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
}
