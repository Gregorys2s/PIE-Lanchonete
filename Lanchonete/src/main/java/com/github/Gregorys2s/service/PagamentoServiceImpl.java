package com.github.Gregorys2s.service;

import java.math.BigDecimal;

public class PagamentoServiceImpl implements PagamentoService{
    @Override
    public Pagamento processar(BigDecimal valor, String metodoPagemento) {
        try{
            processar(valor,metodoPagemento);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
