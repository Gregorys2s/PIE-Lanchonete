package com.github.Gregorys2s.config;

import com.github.Gregorys2s.controller.*;
import com.github.Gregorys2s.entity.Pagamento;
import com.github.Gregorys2s.model.Caixa;
import com.github.Gregorys2s.repositories.*;
import com.github.Gregorys2s.service.*;
import com.github.Gregorys2s.controller.RelatorioController;
import com.github.Gregorys2s.repositories.RelatorioDiarioRepository;
import com.github.Gregorys2s.service.RelatorioDiarioService;
import com.github.Gregorys2s.view.despesas.DespesasView;
import com.github.Gregorys2s.view.inicializacao.Inicializar;
import com.github.Gregorys2s.view.pedidos.PedidosView;
import com.github.Gregorys2s.view.cardapio.CardapioView;
import com.github.Gregorys2s.view.ingredientes.IngredientesView;
import jakarta.persistence.EntityManager;

public class AppConfigtet {
    public AppConfigtet() {
        FlyWay.migrate();
        EntityManager em = JPAUtil.getEntityManager();

        Caixa caixa = new Caixa();
        CaixaService caixaService = new CaixaService(caixa);
        CaixaController caixaController = new CaixaController(caixaService);

        PagamentoRepository pagamentoRepository = new PagamentoRepository(em);
        Pagamento pagamento = new Pagamento();

        CardapioRepository cardapioRepository = new CardapioRepository(em);
        CardapioService cardapioService = new CardapioService(cardapioRepository);
        CardapioController cardapioController = new CardapioController(cardapioService);
        CardapioView cardapioView = new CardapioView(cardapioController);

        IngredienteRepository ingredienteRepository = new IngredienteRepository(em);
        IngredientesService ingredientesService = new IngredientesService(ingredienteRepository);
        IngredientesController ingredientesController = new IngredientesController(ingredientesService);
        //IngredientesView ingredientesView = new IngredientesView();

        DespesasRepository despesasRepository = new DespesasRepository(em);
        DespesasService despesasService = new DespesasService(despesasRepository);
        DespesaController despesaController = new DespesaController(despesasService, caixaController);
        DespesasView despesasView = new DespesasView(despesaController);

        // ── Relatório (adicionado aqui, depois que pedidosRepo já existe) ──

        PedidosRepository pedidosRepo = new PedidosRepository(em);
        PagamentoService pagamentoService = new PagamentoServiceImpl(pagamentoRepository);
        PedidosService pedidosService = new PedidosService(pedidosRepo, pagamentoService, caixaController);
        PedidosController pedidosController = new PedidosController(pedidosService);
        PedidosView pedidosView = new PedidosView(pedidosController, cardapioView, cardapioController, pagamento, caixaController);

        RelatorioDiarioRepository relatorioRepository = new RelatorioDiarioRepository(em);
        RelatorioDiarioService relatorioService = new RelatorioDiarioService(relatorioRepository, pedidosRepo);
        RelatorioController relatorioController = new RelatorioController(relatorioService);

        //return new Inicializar(caixaController, cardapioView, pedidosView,  despesasView, ingredientesView);
    }
}



