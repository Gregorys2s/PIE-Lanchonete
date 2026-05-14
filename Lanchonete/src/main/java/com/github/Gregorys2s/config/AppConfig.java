package com.github.Gregorys2s.config;

import com.github.Gregorys2s.controller.*;
import com.github.Gregorys2s.entity.Pagamento;
import com.github.Gregorys2s.model.Caixa;
import com.github.Gregorys2s.repositories.*;
import com.github.Gregorys2s.service.*;
import com.github.Gregorys2s.controller.RelatorioController;
import com.github.Gregorys2s.repositories.RelatorioDiarioRepository;
import com.github.Gregorys2s.service.RelatorioDiarioService;

import com.github.Gregorys2s.view.*;
import com.github.Gregorys2s.view.cardapio.CardapioView;
import jakarta.persistence.EntityManager;

public class AppConfig {
    public static Inicializar configSistema() {
        FlyWay.migrate();
        EntityManager em = JPAUtil.getEntityManager();

        Caixa caixa = new Caixa();
        CaixaService caixaService = new CaixaService(caixa);
        CaixaController caixaController = new CaixaController(caixaService);

        PagamentoRepository pagamentoRepository = new PagamentoRepository(em);
        Pagamento pagamento = new Pagamento();

        PedidosRepository pedidosRepo = new PedidosRepository(em);
        PagamentoService pagamentoService = new PagamentoServiceImpl(pagamentoRepository);
        PedidosService pedidosService = new PedidosService(pedidosRepo, pagamentoService, caixaController);
        PedidosController pedidosController = new PedidosController(pedidosService);

        CardapioRepository cardapioRepository = new CardapioRepository(em);
        CardapioService cardapioService = new CardapioService(cardapioRepository);
        CardapioController cardapioController = new CardapioController(cardapioService);
        CardapioView cardapioView = new CardapioView(cardapioController);

        IngredienteRepository ingredienteRepository = new IngredienteRepository(em);
        IngredientesService ingredientesService = new IngredientesService(ingredienteRepository);
        IngredientesController ingredientesController = new IngredientesController(ingredientesService);
        IngredientesView ingredientes = new IngredientesView(ingredientesController);

        DespesasRepository despesasRepository = new DespesasRepository(em);
        DespesasService despesasService = new DespesasService(despesasRepository);
        DespesaController despesaController = new DespesaController(despesasService, caixaController);
        DespesasView despesasView = new DespesasView(despesaController);

        // ── Relatório (adicionado aqui, depois que pedidosRepo já existe) ──
        RelatorioDiarioRepository relatorioRepository = new RelatorioDiarioRepository(em);
        RelatorioDiarioService relatorioService = new RelatorioDiarioService(relatorioRepository, pedidosRepo);
        RelatorioController relatorioController = new RelatorioController(relatorioService);

        return new Inicializar(caixaController, cardapioView, despesasView, ingredientes, relatorioController);
    }
}



