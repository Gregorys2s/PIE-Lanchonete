package com.github.Gregorys2s.model.service.pagamento;

import com.github.Gregorys2s.controller.pagamento.dto.PagamentoDto;
import com.github.Gregorys2s.model.entity.Pagamento;

public interface PagamentoService {
    Pagamento processar(PagamentoDto pagamentoDto);
}
