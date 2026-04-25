package com.github.Gregorys2s.service;


import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.exceptions.ServiceCardapioException;
import com.github.Gregorys2s.repositories.CardapioRepository;

import java.util.List;

public class ProdutoService {
    private CardapioRepository produto;

    public ProdutoService(CardapioRepository produto) {
        this.produto = produto;
    }

    public Cardapio buscarPorId(Integer id)
    {
        Cardapio c = produto.findById(id);
        if (c == null)
        {

        }
        return c;
    }

    public List<Cardapio> Exibir ()
    {
        List<Cardapio> c = produto.findAll();
        if (c == null)
        {
            throw new ServiceCardapioException("Produto nao encontrado");
        }
        return c;
    }
}
