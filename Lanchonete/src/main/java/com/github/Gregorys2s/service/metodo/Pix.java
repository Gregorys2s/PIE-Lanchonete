package com.github.Gregorys2s.service.metodo;

import com.github.Gregorys2s.repositories.PagamentoRepository;
import com.github.Gregorys2s.service.PagamentoServiceImpl;

public class Pix extends PagamentoServiceImpl {
    public Pix(PagamentoRepository pagamentoRepository) {
        super(pagamentoRepository);
    }
}
