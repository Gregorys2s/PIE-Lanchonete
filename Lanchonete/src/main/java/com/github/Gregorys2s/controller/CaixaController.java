package com.github.Gregorys2s.controller;


import com.github.Gregorys2s.exceptions.CaixaControllerException;
import com.github.Gregorys2s.service.CaixaService;

import java.math.BigDecimal;

public class CaixaController {
    private CaixaService service = new CaixaService();

    public void iniciarCaixa(BigDecimal valor) {
        service.abrirCaixa(valor);
    }

    public void encerrarCaixa()
    {
        service.fecharCaixa();
    }

    public BigDecimal getsaldo()
    {
        return service.getCaixa().getdinheiroEmCaixa();
    }

    public void removerValor(BigDecimal valor) {
        if(valor.compareTo(BigDecimal.ZERO) == 0){throw new CaixaControllerException("Valor invalido");}
        service.subtrairDoCaixa(valor);
    }
}
