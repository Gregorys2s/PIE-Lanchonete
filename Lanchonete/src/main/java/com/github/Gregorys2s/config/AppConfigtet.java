package com.github.Gregorys2s.config;

import com.github.Gregorys2s.controller.cardapio.Implementacoes.CardapioController;
import com.github.Gregorys2s.controller.despesas.Implementacoes.DespesaController;
import com.github.Gregorys2s.controller.ingredientes.Implementacoes.IngredientesController;
import com.github.Gregorys2s.controller.pedidos.Implementacoes.PedidosController;
import com.github.Gregorys2s.model.entity.Pagamento;
import com.github.Gregorys2s.model.repositories.*;
import com.github.Gregorys2s.controller.relatorios.Implementacoes.RelatorioController;
import com.github.Gregorys2s.model.service.cardapio.CardapioServiceImpl;
import com.github.Gregorys2s.model.service.despesas.DespesasServicelmpl;
import com.github.Gregorys2s.model.service.ingrediente.IngredientesServiceImpl;
import com.github.Gregorys2s.model.service.pagamento.PagamentoService;
import com.github.Gregorys2s.model.service.pagamento.impl.PagamentoServiceImpl;
import com.github.Gregorys2s.model.service.pedidos.PedidosService;
import com.github.Gregorys2s.model.service.pedidos.PedidosServiceImpl;
import com.github.Gregorys2s.model.service.relatorioDiario.RelatorioDiarioServiceLmpl;
import com.github.Gregorys2s.view.despesas.DespesasView;
import com.github.Gregorys2s.view.cardapio.CardapioView;
import jakarta.persistence.EntityManager;
import org.flywaydb.core.Flyway;

public class AppConfigtet {
    public AppConfigtet() {
        FlyWay.migrate();
        EntityManager em = JPAUtil.getEntityManager();



        PagamentoRepository pagamentoRepository = new PagamentoRepository(em);
        Pagamento pagamento = new Pagamento();

        CardapioRepository cardapioRepository = new CardapioRepository(em);
        CardapioServiceImpl cardapioService = new CardapioServiceImpl(cardapioRepository);
        CardapioController cardapioController = new CardapioController(cardapioService);
        CardapioView cardapioView = new CardapioView(cardapioController);

        IngredienteRepository ingredienteRepository = new IngredienteRepository(em);
        IngredientesServiceImpl ingredientesService = new IngredientesServiceImpl(ingredienteRepository);
        IngredientesController ingredientesController = new IngredientesController(ingredientesService);
        //IngredientesView ingredientesView = new IngredientesView();

        DespesasRepository despesasRepository = new DespesasRepository(em);
        DespesasServicelmpl despesasServicelmpl = new DespesasServicelmpl(despesasRepository);
        DespesaController despesaController = new DespesaController(despesasServicelmpl);
        DespesasView despesasView = new DespesasView(despesaController);

        // ── Relatório (adicionado aqui, depois que pedidosRepo já existe) ──

        PedidosRepository pedidosRepo = new PedidosRepository(em);
        PagamentoService pagamentoService = new PagamentoServiceImpl(pagamentoRepository);
        PedidosService pedidosService = new PedidosServiceImpl(pedidosRepo, pagamentoService);
        PedidosController pedidosController = new PedidosController(pedidosService);

        RelatorioDiarioRepository relatorioRepository = new RelatorioDiarioRepository(em);
        RelatorioDiarioServiceLmpl relatorioService = new RelatorioDiarioServiceLmpl(relatorioRepository, pedidosRepo);
        RelatorioController relatorioController = new RelatorioController(relatorioService);

        //return new Inicializar(caixaController, cardapioView, pedidosView,  despesasView, ingredientesView);
    }
}



