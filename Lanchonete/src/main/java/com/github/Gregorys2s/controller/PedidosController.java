package com.github.Gregorys2s.controller;

import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.service.PedidosService;

public class PedidosController {

    PedidosService service;

    public PedidosController(PedidosService service) {
        this.service = service;
    }

    public Cardapio adicionarProduto(Integer id)
    {
        return service.procurarId(id);
    }
}
