package com.github.Gregorys2s.controller.caixa.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MovimentoCaixaResponse(
        LocalDateTime dataHora,
        String tipo,
        BigDecimal valor,
        BigDecimal saldoAposMovimento
) {
}