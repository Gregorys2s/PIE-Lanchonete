package com.github.Gregorys2s.model.entity.Caixa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MovimentoCaixa(
        Long id,
        LocalDateTime dataHora,
        TipoMovimentoCaixa tipo,
        BigDecimal valor,
        BigDecimal saldoAposMovimento
) {

    public enum TipoMovimentoCaixa {
        ABERTURA,
        ENTRADA,
        DESPESA
    }
}