package com.github.Gregorys2s.controller.caixa.DTO;

import java.math.BigDecimal;

public record AbrirCaixaRequest(
        BigDecimal valorInicial
) {}