package com.github.Gregorys2s.model;


import com.github.Gregorys2s.exceptions.CaixaModelException;

import java.math.BigDecimal;

public class Caixa {
    private BigDecimal dinheiroEmCaixa;
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
        }

    }

    public BigDecimal getdinheiroEmCaixa()
    {
        return dinheiroEmCaixa;
    }

    public void subtrair(BigDecimal valor) {
        if (caixaDoSistema && dinheiroEmCaixa.compareTo(valor) >= 0) {
            this.dinheiroEmCaixa = this.dinheiroEmCaixa.subtract(valor);
        } else if (!caixaDoSistema) {
            throw new CaixaModelException("Caixa fechado!");
        } else {
            throw new CaixaModelException("Saldo insuficiente no caixa!");
        }
    }
}



//System.out.println("Valor na caixa");
//        System.out.println("Lucro do dia");
//        System.out.println("Valor gerado");
//aqui ele deve comprovar se nao teve furo da caixa
//colocar aqui o total feito no dia, os lucro e o valor que ficou na caixa.