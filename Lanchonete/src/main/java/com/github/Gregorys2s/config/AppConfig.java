package com.github.Gregorys2s.config;

import com.github.Gregorys2s.controller.*;
import com.github.Gregorys2s.entity.Pagamento;
import com.github.Gregorys2s.repositories.*;
import com.github.Gregorys2s.service.*;

import com.github.Gregorys2s.view.*;
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
        Pagamento pagamento = new Pagamento();

        PedidosRepository pedidosRepo = new PedidosRepository(em);
        PagamentoService pagamentoService = new PagamentoServiceImpl(pagamentoRepository);//preciso colocar aqui para usar o repository do pedidos
        PedidosService pedidosService = new PedidosService(pedidosRepo, pagamentoService);
        PedidosController pedidosController = new PedidosController(pedidosService);



        CaixaController caixa = new CaixaController();
        //config Cardapio ∨∨
        CardapioRepository cardapioRepository = new CardapioRepository(em);
        CardapioService cardapioService = new CardapioService(cardapioRepository);

        CardapioController cardapioController = new CardapioController(cardapioService);
        CardapioView cardapioView = new CardapioView(cardapioController);//Nesse caso precisei por o view antes do control

        PedidosView pedidosView = new PedidosView(pedidosController,cardapioView,cardapioController,pagamento);

        IngredienteRepository ingredienteRepository = new IngredienteRepository(em);
        IngredientesService ingredientesService = new IngredientesService(ingredienteRepository);
        IngredientesController ingredientesController = new IngredientesController(ingredientesService);
        IngredientesView ingredientes = new IngredientesView(ingredientesController);

        DespesasRepository despesasRepository = new DespesasRepository(em);
        DespesasService despesasService = new DespesasService(despesasRepository);
        DespesaController despesaController = new DespesaController(despesasService, caixa);
        DespesasView  despesasView = new DespesasView(despesaController);


        return new Inicializar(caixa, cardapioView,pedidosView, despesasView,ingredientes);
    }
}



