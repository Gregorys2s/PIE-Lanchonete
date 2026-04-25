package com.github.Gregorys2s.controller;

import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.service.ProdutoService;

import java.util.List;

public class ProdutoController {
    ProdutoService service;
    Leitores leitor = new Leitores();

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    Cardapio AdicionarProduto(Integer id)
    {

        return service.buscarPorId(id);
    }

    List<Cardapio> ExibirProdutos ()
    {
        return service.Exibir();
    }


}
