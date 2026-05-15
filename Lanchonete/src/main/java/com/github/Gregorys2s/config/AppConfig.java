package com.github.Gregorys2s.config;

import com.github.Gregorys2s.controller.*;
import com.github.Gregorys2s.entity.Pagamento;
import com.github.Gregorys2s.model.Caixa;
import com.github.Gregorys2s.repositories.*;
import com.github.Gregorys2s.service.*;
import com.github.Gregorys2s.view.cardapio.CardapioView;
import com.github.Gregorys2s.view.inicializacao.MenuPrincipal;
import com.github.Gregorys2s.view.pedidos.PedidosEmProcesso;
import com.github.Gregorys2s.view.pedidos.PedidosView;
import jakarta.persistence.EntityManager;


    public class AppConfig {

        private final EntityManager em = JPAUtil.getEntityManager();

        // ===== CAIXA =====
        private Caixa caixa = new Caixa();
        private CaixaService caixaService = new CaixaService(caixa);
        private CaixaController caixaController = new CaixaController(caixaService);

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
        }

        //menu principal

        MenuPrincipal menuPrincipal = new MenuPrincipal(cardapioController,pedidosController);
        // =====================================================
        // FACTORY - PEDIDOS VIEW
        // =====================================================
        public PedidosView criarPedidosView() {
            return new PedidosView(
                    pedidosController,
                    cardapioView,
                    cardapioController,
                    pagamento,
                    caixaController
            );
        }

        // =====================================================
        // GETTERS (se precisar usar em outras telas)
        // =====================================================
        public CardapioController getCardapioController() {
            return cardapioController;
        }

        public PedidosController getPedidosController() {
            return pedidosController;
        }

        public CaixaController getCaixaController() {
            return caixaController;
        }

        public CardapioView getCardapioView() {
            return cardapioView;
        }
    }
