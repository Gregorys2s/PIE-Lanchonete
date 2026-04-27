package com.github.Gregorys2s.service;

import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.exceptions.AcharProdutoException;
import com.github.Gregorys2s.repositories.PedidosRepository;

public class PedidosService {
    PedidosRepository repository;

    public PedidosService(PedidosRepository repository)
    {
        this.repository = repository;
    }

    public Cardapio procurarId(long id)
    {
        Cardapio produto = repository.getProduto(id);
        seExistir(produto);
        return produto;
    }

    private void seExistir(Cardapio produto)
    {
        if (produto == null)
        {
            throw new AcharProdutoException("Produto nao encontrado");
        }
    }
}
