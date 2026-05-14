package com.github.Gregorys2s.config;

import com.github.Gregorys2s.controller.*;
import com.github.Gregorys2s.entity.Pagamento;
import com.github.Gregorys2s.model.Caixa;
import com.github.Gregorys2s.repositories.*;
import com.github.Gregorys2s.service.*;

import com.github.Gregorys2s.view.*;
import jakarta.persistence.EntityManager;
import java.util.Scanner;                              // NOVO

public class AppConfig {
    public static Inicializar configSistema()
    {
        FlyWay.migrate();
        EntityManager em = JPAUtil.getEntityManager();

        Caixa caixa = new Caixa();
        CaixaService caixaService = new CaixaService(caixa);
        CaixaController caixaController = new CaixaController(caixaService);

        //ordem pra chamar
        //repository
        //service
        //controller

        // repository → service → controller
        PagamentoRepository pagamentoRepository = new PagamentoRepository(em);
        Pagamento pagamento = new Pagamento();

        PedidosRepository pedidosRepo = new PedidosRepository(em);
        PagamentoService pagamentoService = new PagamentoServiceImpl(pagamentoRepository, pedidosRepo);
        PedidosService pedidosService = new PedidosService(pedidosRepo, pagamentoService);
        PagamentoService pagamentoService = new PagamentoServiceImpl(pagamentoRepository);//preciso colocar aqui para usar o repository do pedidos
        PedidosService pedidosService = new PedidosService(pedidosRepo, pagamentoService,caixaController);
        PedidosController pedidosController = new PedidosController(pedidosService);

        CaixaController caixa = new CaixaController();

        // config Cardapio




        //config Cardapio ∨∨
        CardapioRepository cardapioRepository = new CardapioRepository(em);
        CardapioService cardapioService = new CardapioService(cardapioRepository);
        CardapioController cardapioController = new CardapioController(cardapioService);
        CardapioView cardapioView = new CardapioView(cardapioController);

        PedidosView pedidosView = new PedidosView(pedidosController, cardapioView, cardapioController);
        PedidosView pedidosView = new PedidosView(pedidosController,cardapioView,cardapioController,pagamento,caixaController);

        IngredienteRepository ingredienteRepository = new IngredienteRepository(em);
        IngredientesService ingredientesService = new IngredientesService(ingredienteRepository);
        IngredientesController ingredientesController = new IngredientesController(ingredientesService);
        IngredientesView ingredientes = new IngredientesView(ingredientesController);

        // config Despesas
        DespesasRepository despesasRepository = new DespesasRepository(em);
        DespesasService despesasService = new DespesasService(despesasRepository);
        DespesaController despesaController = new DespesaController(despesasService, caixa);
        DespesasView despesasView = new DespesasView(despesaController);
        DespesaController despesaController = new DespesaController(despesasService, caixaController);
        DespesasView  despesasView = new DespesasView(despesaController);


        return new Inicializar(caixaController, cardapioView,pedidosView, despesasView,ingredientes);
    }
}


        // config Ingredientes — NOVO
        IngredienteRepository ingredienteRepository = new IngredienteRepository(em);
        IngredientesService ingredientesService = new IngredientesService(ingredienteRepository);
        Scanner scannerIngredientes = new Scanner(System.in);
        IngredientesController ingredientesController = new IngredientesController(ingredientesService, scannerIngredientes);
        IngredientesView ingredientesView = new IngredientesView(ingredientesController);  // NOVO

        return new Inicializar(caixa, cardapioView, pedidosView, despesasView, ingredientesView); // NOVO parâmetro
    }
}