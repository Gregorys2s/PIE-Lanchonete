package com.github.Gregorys2s.controller;

import com.github.Gregorys2s.dto.PagamentoDto;
import com.github.Gregorys2s.entity.Pagamento;
import com.github.Gregorys2s.service.PagamentoService;

public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService){
        this.pagamentoService = pagamentoService;
    }

    public Pagamento realizarPagamento(PagamentoDto pagamentoDto){
        try{
            return pagamentoService.processar(pagamentoDto);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("erro no processamento: " + e.getMessage());
        }
    }
}


