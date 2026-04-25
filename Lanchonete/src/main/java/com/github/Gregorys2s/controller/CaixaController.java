package com.github.Gregorys2s.controller;


import com.github.Gregorys2s.service.CaixaService;

import java.math.BigDecimal;

public class CaixaController {
    private CaixaService service = new CaixaService();
    Leitores leitor = new Leitores();

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

}
