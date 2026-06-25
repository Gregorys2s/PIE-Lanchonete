package com.github.Gregorys2s.config;

import com.github.Gregorys2s.controller.caixa.CaixaController;
import com.github.Gregorys2s.controller.caixa.Implementacao.CaixaControllerImpl;
import com.github.Gregorys2s.controller.cardapio.Implementacoes.CardapioController;
import com.github.Gregorys2s.controller.ingredientes.Implementacoes.IngredientesController;
import com.github.Gregorys2s.controller.pagamento.PagamentoController;
import com.github.Gregorys2s.controller.pedidos.Implementacoes.PedidosController;
import com.github.Gregorys2s.controller.relatorios.Implementacoes.RelatorioController;
import com.github.Gregorys2s.controller.relatoriosSemanal.Implementacoes.RelatoriosSemanalesController;
import com.github.Gregorys2s.model.repositories.*;
import com.github.Gregorys2s.model.repositories.RelatiorioSemanal.RelatorioSemanalRepositoryImpl;
import com.github.Gregorys2s.model.service.caixa.CaixaService;
import com.github.Gregorys2s.model.service.caixa.Impl.CaixaServiceImpl;
import com.github.Gregorys2s.model.service.cardapio.CardapioServiceImpl;
import com.github.Gregorys2s.model.service.ingrediente.IngredientesServiceImpl;
import com.github.Gregorys2s.model.service.pagamento.impl.PagamentoServiceImpl;
import com.github.Gregorys2s.model.service.pedidos.Impl.PedidosServiceImpl;
import com.github.Gregorys2s.model.service.relatorioDiario.RelatorioDiarioServiceLmpl;
import com.github.Gregorys2s.model.service.relatorioSemanal.RelatorioSemanalService;
import com.github.Gregorys2s.model.service.relatorioSemanal.RelatorioSemanalServiceImpl;
import com.github.Gregorys2s.view.cardapio.CardapioView;
import jakarta.persistence.EntityManager;

public class AppConfig {

    private final EntityManager em;

    private final CaixaService caixaService;
    private final CaixaController caixaController;

    private final CardapioController cardapioController;
    private final CardapioView cardapioView;

    private final PedidosController pedidosController;
    private final IngredientesController ingredientesController;

    private final RelatorioController relatorioController;
    private final RelatoriosSemanalesController relatoriosSemanalesController;

    private final PagamentoController pagamentoController;

    public AppConfig() {
        this.em = JPAUtil.getEntityManager();

        FlyWay.migrate();
        // CAIXA
        this.caixaService = new CaixaServiceImpl();
        this.caixaController = new CaixaControllerImpl(caixaService);

        // PAGAMENTO
        PagamentoRepository pagamentoRepository = new PagamentoRepository(em);
        PagamentoServiceImpl pagamentoService = new PagamentoServiceImpl(pagamentoRepository);
         this.pagamentoController = new PagamentoController(pagamentoService);

        // CARDÁPIO
        CardapioRepository cardapioRepository = new CardapioRepository(em);
        CardapioServiceImpl cardapioService = new CardapioServiceImpl(cardapioRepository);

        this.cardapioController = new CardapioController(cardapioService);
        this.cardapioView = new CardapioView(cardapioController);

        // PEDIDOS
        PedidosRepository pedidosRepo = new PedidosRepository(em);

        PedidosServiceImpl pedidosService = new PedidosServiceImpl(
                pedidosRepo,
                pagamentoService,
                caixaService
        );

        this.pedidosController = new PedidosController(pedidosService);

        // INGREDIENTES
        IngredienteRepository ingredienteRepository = new IngredienteRepository(em);
        IngredientesServiceImpl ingredientesService = new IngredientesServiceImpl(ingredienteRepository);

        this.ingredientesController = new IngredientesController(ingredientesService);

        // RELATÓRIO DIÁRIO
        RelatorioDiarioRepository relatorioDiarioRepository = new RelatorioDiarioRepository(em);

        RelatorioDiarioServiceLmpl relatorioDiarioService =
                new RelatorioDiarioServiceLmpl(relatorioDiarioRepository, pedidosRepo);

        this.relatorioController = new RelatorioController(relatorioDiarioService);

        // RELATÓRIO SEMANAL
        RelatorioSemanalRepositoryImpl relatorioSemanalRepository =
                new RelatorioSemanalRepositoryImpl(em);

        RelatorioSemanalService relatorioSemanalService =
                new RelatorioSemanalServiceImpl(relatorioSemanalRepository);

        this.relatoriosSemanalesController =
                new RelatoriosSemanalesController(relatorioSemanalService);
    }

    public CardapioController getCardapioController() {
        return cardapioController;
    }

    public CardapioView getCardapioView() {
        return cardapioView;
    }

    public PedidosController getPedidosController() {
        return pedidosController;
    }

    public IngredientesController getIngredientesController() {
        return ingredientesController;
    }

    public CaixaController getCaixaController() {
        return caixaController;
    }

    public RelatorioController getRelatorioController() {
        return relatorioController;
    }

    public RelatoriosSemanalesController getRelatoriosSemanalesController() {
        return relatoriosSemanalesController;
    }

    public PagamentoController getPagamentoController() {
        return pagamentoController;
    }
}