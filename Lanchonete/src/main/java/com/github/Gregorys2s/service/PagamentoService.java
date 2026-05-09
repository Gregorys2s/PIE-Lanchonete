package com.github.Gregorys2s.service;

import com.github.Gregorys2s.dto.PagamentoDto;
import com.github.Gregorys2s.entity.Pagamento;

public interface PagamentoService {
    Pagamento processar(PagamentoDto pagamentoDto);
}
