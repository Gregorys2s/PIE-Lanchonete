package com.github.Gregorys2s.service;

import java.math.BigDecimal;

public interface PagamentoService {
    void processar(BigDecimal valor, String metodoPagemento);
}
