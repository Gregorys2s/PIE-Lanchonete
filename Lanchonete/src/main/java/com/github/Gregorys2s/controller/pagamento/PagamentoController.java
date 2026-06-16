package com.github.Gregorys2s.controller.pagamento;

import com.github.Gregorys2s.controller.pagamento.dto.PagamentoDto;
import com.github.Gregorys2s.model.entity.Pagamento;
import com.github.Gregorys2s.model.service.pagamento.PagamentoService;

public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    public Pagamento realizarPagamento(PagamentoDto pagamentoDto) {
        try {
            return pagamentoService.processar(pagamentoDto);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Erro no processamento: " + e.getMessage());
        }
    }
}