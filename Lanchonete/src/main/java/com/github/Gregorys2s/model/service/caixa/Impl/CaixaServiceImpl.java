package com.github.Gregorys2s.model.service.caixa.Impl;

import com.github.Gregorys2s.model.entity.Caixa;
import com.github.Gregorys2s.model.service.caixa.CaixaService;

import java.math.BigDecimal;

public class CaixaServiceImpl implements CaixaService {

    private Caixa caixa =
            new Caixa(BigDecimal.ZERO);

    @Override
    public Caixa abrirCaixa(BigDecimal valor) {

        validarValor(valor);

        caixa.setSaldo(
                caixa.getSaldo().add(valor)
        );

        return caixa;
    }

    @Override
    public Caixa registrarDespesa(BigDecimal valor) {

        validarValor(valor);

        caixa.setSaldo(
                caixa.getSaldo().subtract(valor)
        );

        return caixa;
    }

    @Override
    public Caixa obterCaixa() {
        return caixa;
    }

    private void validarValor(BigDecimal valor) {
        if (valor == null) {
            throw new IllegalArgumentException("Valor não pode ser nulo.");
        }

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor precisa ser maior que zero.");
        }
    }
}