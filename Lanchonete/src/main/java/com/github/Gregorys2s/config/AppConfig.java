package com.github.Gregorys2s.config;

import com.github.Gregorys2s.controller.*;
import com.github.Gregorys2s.repositories.*;
import com.github.Gregorys2s.service.*;

import com.github.Gregorys2s.view.CardapioView;
import com.github.Gregorys2s.view.DespesasView;
import com.github.Gregorys2s.view.IngredientesView;   // NOVO
import com.github.Gregorys2s.view.Inicializar;
import com.github.Gregorys2s.view.PedidosView;
import jakarta.persistence.EntityManager;
import java.util.Scanner;                              // NOVO

public class AppConfig {
    public static Inicializar configSistema() {
        FlyWay.migrate();
        EntityManager em = JPAUtil.getEntityManager();

        // repository → service → controller
        PagamentoRepository pagamentoRepository = new PagamentoRepository(em);
        PedidosRepository pedidosRepo = new PedidosRepository(em);
        PagamentoService pagamentoService = new PagamentoServiceImpl(pagamentoRepository, pedidosRepo);
        PedidosService pedidosService = new PedidosService(pedidosRepo, pagamentoService);
        PedidosController pedidosController = new PedidosController(pedidosService);

        CaixaController caixa = new CaixaController();

        // config Cardapio
        CardapioRepository cardapioRepository = new CardapioRepository(em);
        CardapioService cardapioService = new CardapioService(cardapioRepository);
        CardapioController cardapioController = new CardapioController(cardapioService);
        CardapioView cardapioView = new CardapioView(cardapioController);

        PedidosView pedidosView = new PedidosView(pedidosController, cardapioView, cardapioController);

        // config Despesas
        DespesasRepository despesasRepository = new DespesasRepository(em);
        DespesasService despesasService = new DespesasService(despesasRepository);
        DespesaController despesaController = new DespesaController(despesasService, caixa);
        DespesasView despesasView = new DespesasView(despesaController);

        // config Ingredientes — NOVO
        IngredienteRepository ingredienteRepository = new IngredienteRepository(em);
        IngredientesService ingredientesService = new IngredientesService(ingredienteRepository);
        Scanner scannerIngredientes = new Scanner(System.in);
        IngredientesController ingredientesController = new IngredientesController(ingredientesService, scannerIngredientes);
        IngredientesView ingredientesView = new IngredientesView(ingredientesController);  // NOVO

        return new Inicializar(caixa, cardapioView, pedidosView, despesasView, ingredientesView); // NOVO parâmetro
    }
}