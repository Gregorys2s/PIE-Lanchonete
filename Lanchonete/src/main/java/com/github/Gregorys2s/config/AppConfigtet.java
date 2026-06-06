package com.github.Gregorys2s.config;

import com.github.Gregorys2s.controller.caixa.CaixaController;
import com.github.Gregorys2s.controller.cardapio.CardapioController;
import com.github.Gregorys2s.controller.despesas.DespesaController;
import com.github.Gregorys2s.controller.ingredientes.IngredientesController;
import com.github.Gregorys2s.controller.pedidos.PedidosController;
import com.github.Gregorys2s.model.entity.Pagamento;
import com.github.Gregorys2s.controller.caixa.Caixa;
import com.github.Gregorys2s.model.repositories.*;
import com.github.Gregorys2s.controller.relatorios.RelatorioController;
import com.github.Gregorys2s.model.service.caixa.CaixaService;
import com.github.Gregorys2s.model.service.cardapio.CardapioService;
import com.github.Gregorys2s.model.service.despesas.DespesasService;
import com.github.Gregorys2s.model.service.ingrediente.IngredientesService;
import com.github.Gregorys2s.model.service.pagamento.PagamentoService;
import com.github.Gregorys2s.model.service.pagamento.impl.PagamentoServiceImpl;
import com.github.Gregorys2s.model.service.pedidos.PedidosService;
import com.github.Gregorys2s.model.service.relatorioDiario.RelatorioDiarioService;
import com.github.Gregorys2s.view.despesas.DespesasView;
import com.github.Gregorys2s.view.cardapio.CardapioView;
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

        RelatorioDiarioRepository relatorioRepository = new RelatorioDiarioRepository(em);
        RelatorioDiarioService relatorioService = new RelatorioDiarioService(relatorioRepository, pedidosRepo);
        RelatorioController relatorioController = new RelatorioController(relatorioService);

        //return new Inicializar(caixaController, cardapioView, pedidosView,  despesasView, ingredientesView);
    }
}



