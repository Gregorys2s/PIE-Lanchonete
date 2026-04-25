package com.github.Gregorys2s.service;

import com.github.Gregorys2s.entity.CaixaEntity;
import com.github.Gregorys2s.exceptions.ServiceCaixaException;

import java.math.BigDecimal;

public class CaixaService {
    private CaixaEntity caixa = new CaixaEntity();

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

    public CaixaEntity getCaixa()
    {
        return caixa;
    }
}
