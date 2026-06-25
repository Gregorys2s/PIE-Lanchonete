package com.github.Gregorys2s.controller.caixa.DTO;

import java.math.BigDecimal;
import java.util.List;

public record CaixaResponse(
        boolean aberto,
        BigDecimal saldo,
        BigDecimal valorAbertura,
        BigDecimal totalEntradas,
        BigDecimal totalDespesas,
        List<MovimentoCaixaResponse> movimentos
) {
}