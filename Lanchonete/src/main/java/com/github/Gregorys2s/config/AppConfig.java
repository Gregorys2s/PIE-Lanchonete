package com.github.Gregorys2s.config;

import com.github.Gregorys2s.controller.caixa.CaixaController;
import com.github.Gregorys2s.controller.cardapio.CardapioController;
import com.github.Gregorys2s.controller.ingredientes.IngredientesController;
import com.github.Gregorys2s.controller.pedidos.PedidosController;
import com.github.Gregorys2s.controller.relatorios.RelatorioController;
import com.github.Gregorys2s.model.entity.Pagamento;
import com.github.Gregorys2s.model.repositories.*;
import com.github.Gregorys2s.model.service.caixa.CaixaService;
import com.github.Gregorys2s.model.service.cardapio.CardapioService;
import com.github.Gregorys2s.model.service.ingrediente.IngredientesService;
import com.github.Gregorys2s.model.service.pagamento.PagamentoService;
import com.github.Gregorys2s.model.service.pagamento.impl.PagamentoServiceImpl;
import com.github.Gregorys2s.model.service.pedidos.PedidosService;
import com.github.Gregorys2s.model.service.relatorioDiario.RelatorioDiarioService;
import com.github.Gregorys2s.view.cardapio.CardapioView;
import com.github.Gregorys2s.view.inicializacao.MenuPrincipal;
import com.github.Gregorys2s.view.pedidos.CaixaView;
import jakarta.persistence.EntityManager;

public class AppConfig {

    private final EntityManager em = JPAUtil.getEntityManager();

    // ===== CAIXA =====
    private Caixa caixa = new Caixa();
    private CaixaService caixaService = new CaixaService(caixa);
    private CaixaController caixaController = new CaixaController(caixaService);

    // ===== DESPESAS REPOSITORY =====
    private DespesasRepository despesasRepository = new DespesasRepository(em);

    // ===== PAGAMENTO =====
    private final Pagamento pagamento = new Pagamento();
    PagamentoRepository pagamentoRepository = new PagamentoRepository(em);

    // ===== CARDÁPIO =====
    CardapioRepository cardapioRepository = new CardapioRepository(em);
    CardapioService cardapioService = new CardapioService(cardapioRepository);
    CardapioController cardapioController = new CardapioController(cardapioService);
    CardapioView cardapioView = new CardapioView(cardapioController);

        // ===== PEDIDOS =====
        PedidosRepository pedidosRepo = new PedidosRepository(em);
        PagamentoService pagamentoService = new PagamentoServiceImpl(pagamentoRepository);
        PedidosService pedidosService = new PedidosService(pedidosRepo, pagamentoService, caixaController);
        PedidosController pedidosController = new PedidosController(pedidosService);
        /// ==== INGREDIENTES =====
        IngredienteRepository ingredienteRepository = new IngredienteRepository(em);
        IngredientesService ingredientesService = new IngredientesService(ingredienteRepository);
        IngredientesController ingredientesController = new IngredientesController(ingredientesService);
        //IngredientesView ingredientesView = new IngredientesView();

        RelatorioDiarioRepository relatorioDiarioRepository = new RelatorioDiarioRepository(em);
        RelatorioDiarioService relatorioDiarioService = new RelatorioDiarioService(relatorioDiarioRepository, pedidosRepo);
        RelatorioController relatorioController = new RelatorioController(relatorioDiarioService);


    public AppConfig() {

        // ===== CAIXA =====
        CaixaService caixaService = new CaixaService(caixa);
        this.caixaController = new CaixaController(caixaService);

        // ===== PAGAMENTO =====
        PagamentoRepository pagamentoRepository = new PagamentoRepository(em);
        PagamentoService pagamentoService = new PagamentoServiceImpl(pagamentoRepository);

        // ===== PEDIDOS =====
        PedidosRepository pedidosRepo = new PedidosRepository(em);
        PedidosService pedidosService = new PedidosService(
                pedidosRepo,
                pagamentoService,
                caixaController
        );
        this.pedidosController = new PedidosController(pedidosService);

        // ===== CARDÁPIO =====
        CardapioRepository cardapioRepository = new CardapioRepository(em);
        CardapioService cardapioService = new CardapioService(cardapioRepository);

            this.cardapioController = new CardapioController(cardapioService);
            this.cardapioView = new CardapioView(cardapioController);


            RelatorioDiarioRepository relatorioDiarioRepository = new RelatorioDiarioRepository(em);
            RelatorioDiarioService relatorioDiarioService = new RelatorioDiarioService(relatorioDiarioRepository, pedidosRepo);
            RelatorioController relatorioController = new RelatorioController(relatorioDiarioService);

        }

    // ===== MENU PRINCIPAL =====
    MenuPrincipal menuPrincipal = new MenuPrincipal(cardapioController, pedidosController,ingredientesController, relatorioController);

    // ===== FACTORY - PEDIDOS VIEW =====
//    public PedidosView criarPedidosView() {
//        return new PedidosView(
//                pedidosController,
//                cardapioView,
//                cardapioController,
//                pagamento,
//                caixaController
//        );
//    }

    // ===== FACTORY - CAIXA VIEW =====
    public CaixaView criarCaixaView(javax.swing.JDesktopPane desktop) {
        return new CaixaView(caixaController, despesasRepository);
    }

    // ===== GETTERS =====
    public CardapioController getCardapioController() {
        return cardapioController;
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

        public CardapioView getCardapioView() {
            return cardapioView;
        }

        public RelatorioController getRelatorioController()
        {return relatorioController;}
    }
