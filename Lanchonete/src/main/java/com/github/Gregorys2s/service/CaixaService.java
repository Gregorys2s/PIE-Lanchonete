package com.github.Gregorys2s.service;

import com.github.Gregorys2s.model.Caixa;
import com.github.Gregorys2s.exceptions.ServiceCaixaException;

import java.math.BigDecimal;

public class CaixaService {
    private final Caixa caixa;

    public CaixaService(Caixa caixa) {
        this.caixa = caixa;
    }

    public void abrirCaixa (BigDecimal valor)
    {
        if (valor.compareTo(BigDecimal.ZERO) <= 0)
        {
            throw new ServiceCaixaException("Erro, o valor tem que ser maior que zero");
        }

        caixa.abrir(valor);
    }

    public void fecharCaixa ()
    {

        caixa.fechar();
    }

    public Caixa getCaixa()
    {
        return caixa;
    }

    public void subtrairDoCaixa(BigDecimal valor) {
        caixa.subtrair(valor);
    }

    public void adicionarValor(BigDecimal valor)
    {
        caixa.adicionarNaCaixa(valor);
    }
}
