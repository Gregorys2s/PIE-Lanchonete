package com.github.Gregorys2s.config;

import com.github.Gregorys2s.controller.*;
import com.github.Gregorys2s.repositories.*;
import com.github.Gregorys2s.service.*;

import com.github.Gregorys2s.view.CardapioView;
import com.github.Gregorys2s.view.Inicializar;
import com.github.Gregorys2s.view.PedidosView;
import jakarta.persistence.EntityManager;

public class AppConfig {
    public static Inicializar configSistema()
    {
        FlyWay.migrate();
        EntityManager em = JPAUtil.getEntityManager();


        //ordem pra chamar
        //repository
        //service
        //controller
        PagamentoRepository pagamentoRepository = new PagamentoRepository(em);
        PagamentoService pagamentoService = new PagamentoServiceImpl(pagamentoRepository);

        PedidosRepository pedidosRepo = new PedidosRepository(em);
        PedidosService pedidosService = new PedidosService(pedidosRepo, pagamentoService);
        PedidosController pedidosController = new PedidosController(pedidosService);

        CaixaController caixa = new CaixaController();
        //config Cardapio ∨∨
        CardapioRepository cardapioRepository = new CardapioRepository(em);
        CardapioService cardapioService = new CardapioService(cardapioRepository);

        CardapioController cardapioController = new CardapioController(cardapioService);
        CardapioView cardapioView = new CardapioView(cardapioController);//Nesse caso precisei por o view antes do control

        PedidosView pedidosView = new PedidosView(pedidosController,cardapioView,cardapioController);

        return new Inicializar(caixa, cardapioView,pedidosView);
    }
}



