package com.github.Gregorys2s.model.repositories.caixa;

import com.github.Gregorys2s.model.entity.Caixa.Caixa;

import java.math.BigDecimal;

public interface CaixaRepository {

    Caixa obterCaixaAtual();

    Caixa abrirCaixa(BigDecimal valorInicial);

    Caixa registrarEntrada(BigDecimal valor);

    Caixa registrarDespesa(BigDecimal valor);
}