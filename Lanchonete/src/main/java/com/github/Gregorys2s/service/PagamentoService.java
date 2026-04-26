package com.github.Gregorys2s.service;

import com.github.Gregorys2s.dto.PagamentoDto;
import com.github.Gregorys2s.entity.PagamentoEntity;

public interface PagamentoService {
    PagamentoEntity processar(PagamentoDto pagamentoDto);
}
