package com.github.Gregorys2s.service.metodo;

import com.github.Gregorys2s.repositories.PagamentoRepository;
import com.github.Gregorys2s.service.PagamentoServiceImpl;

public class Dinheiro extends PagamentoServiceImpl {
    public Dinheiro(PagamentoRepository pagamentoRepository) {
        super(pagamentoRepository);
    }
}
