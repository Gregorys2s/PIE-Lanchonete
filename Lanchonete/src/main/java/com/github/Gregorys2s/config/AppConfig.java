package com.github.Gregorys2s.config;

//import com.github.Gregorys2s.controller.caixa.CaixaController;
import com.github.Gregorys2s.controller.cardapio.Implementacoes.CardapioController;
import com.github.Gregorys2s.controller.ingredientes.Implementacoes.IngredientesController;
import com.github.Gregorys2s.controller.pedidos.Implementacoes.PedidosController;
import com.github.Gregorys2s.controller.relatorios.Implementacoes.RelatorioController;
import com.github.Gregorys2s.model.entity.Caixa;
import com.github.Gregorys2s.model.entity.Pagamento;
import com.github.Gregorys2s.model.repositories.*;
import com.github.Gregorys2s.model.service.caixa.CaixaService;
import com.github.Gregorys2s.model.service.cardapio.CardapioServiceImpl;
import com.github.Gregorys2s.model.service.ingrediente.IngredientesServiceImpl;
import com.github.Gregorys2s.model.service.pagamento.PagamentoService;
import com.github.Gregorys2s.model.service.pagamento.impl.PagamentoServiceImpl;
import com.github.Gregorys2s.model.service.pedidos.PedidosService;
import com.github.Gregorys2s.model.service.pedidos.PedidosServiceImpl;
import com.github.Gregorys2s.model.service.relatorioDiario.RelatorioDiarioServiceLmpl;
import com.github.Gregorys2s.view.cardapio.CardapioView;
import com.github.Gregorys2s.view.inicializacao.MenuPrincipal;
//import com.github.Gregorys2s.view.pedidos.CaixaView;
import jakarta.persistence.EntityManager;

public class AppConfig {

    private final EntityManager em = JPAUtil.getEntityManager();

    // ===== CAIXA =====
    private Caixa caixa = new Caixa();
    private CaixaService caixaService = new CaixaService(caixa);
//    private CaixaController caixaController = new CaixaController(caixaService);

    // ===== DESPESAS REPOSITORY =====
    private DespesasRepository despesasRepository = new DespesasRepository(em);

    // ===== PAGAMENTO =====
    private final Pagamento pagamento = new Pagamento();
    PagamentoRepository pagamentoRepository = new PagamentoRepository(em);

    // ===== CARDÁPIO =====
    CardapioRepository cardapioRepository = new CardapioRepository(em);
    CardapioServiceImpl cardapioService = new CardapioServiceImpl(cardapioRepository);
    CardapioController cardapioController = new CardapioController(cardapioService);
    CardapioView cardapioView = new CardapioView(cardapioController);

        // ===== PEDIDOS =====
        PedidosRepository pedidosRepo = new PedidosRepository(em);
        PagamentoService pagamentoService = new PagamentoServiceImpl(pagamentoRepository);
    PedidosServiceImpl pedidosService = new PedidosServiceImpl(pedidosRepo, pagamentoService);
        PedidosController pedidosController = new PedidosController(pedidosService);
        /// ==== INGREDIENTES =====
        IngredienteRepository ingredienteRepository = new IngredienteRepository(em);
        IngredientesServiceImpl ingredientesService = new IngredientesServiceImpl(ingredienteRepository);
        IngredientesController ingredientesController = new IngredientesController(ingredientesService);
        //IngredientesView ingredientesView = new IngredientesView();

        RelatorioDiarioRepository relatorioDiarioRepository = new RelatorioDiarioRepository(em);
        RelatorioDiarioServiceLmpl relatorioDiarioService = new RelatorioDiarioServiceLmpl(relatorioDiarioRepository, pedidosRepo);
        RelatorioController relatorioController = new RelatorioController(relatorioDiarioService);


    public AppConfig() {

        // ===== CAIXA =====
        CaixaService caixaService = new CaixaService(caixa);
//        this.caixaController = new CaixaController(caixaService);

        // ===== PAGAMENTO =====
        PagamentoRepository pagamentoRepository = new PagamentoRepository(em);
        PagamentoService pagamentoService = new PagamentoServiceImpl(pagamentoRepository);

        // ===== PEDIDOS =====
        PedidosRepository pedidosRepo = new PedidosRepository(em);
        PedidosService pedidosService = new PedidosServiceImpl(
                pedidosRepo,
                pagamentoService
        );
        this.pedidosController = new PedidosController(pedidosService);

        // ===== CARDÁPIO =====
        CardapioRepository cardapioRepository = new CardapioRepository(em);
        CardapioServiceImpl cardapioService = new CardapioServiceImpl(cardapioRepository);

            this.cardapioController = new CardapioController(cardapioService);
            this.cardapioView = new CardapioView(cardapioController);


            RelatorioDiarioRepository relatorioDiarioRepository = new RelatorioDiarioRepository(em);
            RelatorioDiarioServiceLmpl relatorioDiarioService = new RelatorioDiarioServiceLmpl(relatorioDiarioRepository, pedidosRepo);
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
//    public CaixaView criarCaixaView(javax.swing.JDesktopPane desktop) {
//        return new CaixaView(caixaController, despesasRepository);
//    }

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

//    public CaixaController getCaixaController() {
//        return caixaController;
//    }

        public CardapioView getCardapioView() {
            return cardapioView;
        }

        public RelatorioController getRelatorioController()
        {return relatorioController;}
    }
