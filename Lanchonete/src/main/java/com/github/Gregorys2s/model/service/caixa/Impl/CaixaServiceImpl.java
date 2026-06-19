package com.github.Gregorys2s.model.service.caixa.Impl;

import com.github.Gregorys2s.model.entity.Caixa;
import com.github.Gregorys2s.model.service.caixa.CaixaService;

import java.math.BigDecimal;

public class CaixaServiceImpl implements CaixaService {

    private Caixa caixa =
            new Caixa(BigDecimal.ZERO);

    @Override
    public Caixa abrirCaixa(
            BigDecimal valor) {

        caixa.setSaldo(valor);

        return caixa;
    }

    @Override
    public Caixa registrarDespesa(
            BigDecimal valor) {

        caixa.setSaldo(
                caixa.getSaldo().subtract(valor)
        );

        return caixa;
    }

    @Override
    public Caixa obterCaixa() {
        return caixa;
    }
}