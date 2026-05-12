package com.github.Gregorys2s.config;

import com.github.Gregorys2s.controller.*;
import com.github.Gregorys2s.entity.Pagamento;
import com.github.Gregorys2s.model.Caixa;
import com.github.Gregorys2s.repositories.*;
import com.github.Gregorys2s.service.*;
import com.github.Gregorys2s.view.CardapioView;
import com.github.Gregorys2s.view.Panel.pedidosView;
import jakarta.persistence.EntityManager;

public class Appteste {

    public static class AppConfig {

        private final EntityManager em = JPAUtil.getEntityManager();

        // ===== CAIXA =====
        private final Caixa caixa = new Caixa();
        private final CaixaController caixaController;

        // ===== CARDÁPIO =====
        private final CardapioController cardapioController;
        private final CardapioView cardapioView;

        // ===== PEDIDOS =====
        private final PedidosController pedidosController;

        // ===== PAGAMENTO =====
        private final Pagamento pagamento = new Pagamento();

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

        // =====================================================
        // FACTORY - PEDIDOS VIEW
        // =====================================================
        public pedidosView criarPedidosView() {
            return new pedidosView(
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
}
