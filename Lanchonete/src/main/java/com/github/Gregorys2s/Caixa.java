package com.github.Gregorys2s;

import com.github.Gregorys2s.controller.Leitores;
import java.math.BigDecimal;
import java.util.Scanner;

public class Caixa {
    BigDecimal dinheiroEmCaixa;
    static Boolean caixaDoSistema = false;
    Scanner sc = new Scanner(System.in);
    Leitores leitores = new Leitores();


    void abrirCaixa()
    {
        if(caixaDoSistema == false)
        {
            caixaDoSistema  = true;
            while(true){
                try {
                    System.out.println("Digite o valor inicial da caixa");
                    dinheiroEmCaixa = leitores.leitorDecimais(sc);
                    break;
                }catch(Exception e)
                {
                    System.out.println("Erro inesperado");
                }
            }
        }
    }

    void fecharCaixa()
    {
        System.out.println("Valor na caixa");
        System.out.println("Lucro do dia");
        System.out.println("Valor gerado");
        //aqui ele deve comprovar se nao teve furo da caixa
        //colocar aqui o total feito no dia, os lucro e o valor que ficou na caixa.

    }
}

