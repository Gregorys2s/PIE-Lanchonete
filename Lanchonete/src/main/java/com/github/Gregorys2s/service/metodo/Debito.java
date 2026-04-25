package com.github.Gregorys2s.service.metodo;

import com.github.Gregorys2s.repositories.PagamentoRepository;
import com.github.Gregorys2s.service.PagamentoServiceImpl;

public class Debito extends PagamentoServiceImpl {
    public Debito(PagamentoRepository pagamentoRepository) {
        super(pagamentoRepository);
    }
}
