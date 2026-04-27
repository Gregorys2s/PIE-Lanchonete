package com.github.Gregorys2s.config;

import com.github.Gregorys2s.controller.*;
import com.github.Gregorys2s.repositories.*;
import com.github.Gregorys2s.service.*;

import com.github.Gregorys2s.view.Inicializar;
import jakarta.persistence.EntityManager;

public class AppConfig {
    public static Inicializar configSistema()
    {
        EntityManager em = JPAUtil.getEntityManager();

        // camada de baixo pra cima
        PedidosRepository pedidosRepo = new PedidosRepository(em);
        PedidosService pedidosService = new PedidosService(pedidosRepo);
        PedidosController pedidosController = new PedidosController(pedidosService);

        CaixaController caixa = new CaixaController();

        CardapioRepository cardapioRepository = new CardapioRepository(em);
        CardapioService cardapioService = new CardapioService(cardapioRepository);
        CardapioController cardapioController = new CardapioController(cardapioService);
        return new Inicializar(pedidosController,caixa);
    }
}
