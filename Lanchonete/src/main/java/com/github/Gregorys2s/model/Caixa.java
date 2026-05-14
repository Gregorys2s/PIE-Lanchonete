package com.github.Gregorys2s.model;


import com.github.Gregorys2s.exceptions.CaixaModelException;

import java.math.BigDecimal;

public class Caixa {
    private BigDecimal dinheiroEmCaixa = BigDecimal.ZERO;
    private Boolean caixaDoSistema = false;

    public void abrir(BigDecimal valorInicial)
    {
        if(!caixaDoSistema)
        {
            this.dinheiroEmCaixa = valorInicial;
            this.caixaDoSistema = true;
        }
    }

    public void fechar()
    {
        if(caixaDoSistema)
        {
            caixaDoSistema = false;
            System.out.println("Caixa Fechada com R$ " + getdinheiroEmCaixa());
        }

    }

    public BigDecimal getdinheiroEmCaixa()
    {
        return dinheiroEmCaixa;
    }

    public void subtrair(BigDecimal valor) {

        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new CaixaModelException("Valor invalido!");
        }

        if (!caixaDoSistema) {
            throw new CaixaModelException("Caixa fechado!");
        }

        if (dinheiroEmCaixa.compareTo(valor) < 0) {
            throw new CaixaModelException("Saldo insuficiente no caixa!");
        }

        this.dinheiroEmCaixa =
                this.dinheiroEmCaixa.subtract(valor);
    }

    public void adicionarNaCaixa(BigDecimal valor)
    {
        this.dinheiroEmCaixa = this.dinheiroEmCaixa.add(valor);
    }
}



//System.out.println("Valor na caixa");
//        System.out.println("Lucro do dia");
//        System.out.println("Valor gerado");
//aqui ele deve comprovar se nao teve furo da caixa
//colocar aqui o total feito no dia, os lucro e o valor que ficou na caixa.