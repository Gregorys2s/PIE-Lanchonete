package com.github.Gregorys2s.model.service.caixa;

import com.github.Gregorys2s.model.entity.Caixa;

import java.math.BigDecimal;

public interface CaixaService {

    Caixa abrirCaixa(BigDecimal valor);

    Caixa registrarDespesa(BigDecimal valor);

    Caixa registrarReceita(BigDecimal valor);

    Caixa obterCaixa();
}