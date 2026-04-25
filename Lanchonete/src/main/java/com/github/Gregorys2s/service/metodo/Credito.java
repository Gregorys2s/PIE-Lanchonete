package com.github.Gregorys2s.service.metodo;

import com.github.Gregorys2s.repositories.PagamentoRepository;
import com.github.Gregorys2s.service.PagamentoServiceImpl;

public class Credito extends PagamentoServiceImpl {
    public Credito(PagamentoRepository pagamentoRepository) {
        super(pagamentoRepository);
    }
}
