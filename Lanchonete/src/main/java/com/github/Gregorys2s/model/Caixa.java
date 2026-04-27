package com.github.Gregorys2s.model;


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
}



//System.out.println("Valor na caixa");
//        System.out.println("Lucro do dia");
//        System.out.println("Valor gerado");
//aqui ele deve comprovar se nao teve furo da caixa
//colocar aqui o total feito no dia, os lucro e o valor que ficou na caixa.