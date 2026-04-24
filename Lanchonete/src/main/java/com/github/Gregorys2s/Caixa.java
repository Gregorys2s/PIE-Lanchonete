package com.github.Gregorys2s;

import com.github.Gregorys2s.controller.Leitores;
import java.math.BigDecimal;
import java.util.Scanner;

public class Caixa {
    static Boolean caixaDoSistema = false;
    Scanner sc = new Scanner(System.in);
    Leitores leitor = new Leitores();


    void abrirCaixa()
    {
        if(caixaDoSistema == false)
        {
            caixaDoSistema  = true;
            while(true){
                try {
                    System.out.println("Digite o valor inicial da caixa");
                    BigDecimal dinheiroEmCaixa = leitor.leitoresDecimais(sc);
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
        //colocar aqui o total feito no dia, os lucro e o valor que ficou na caixa.

    }
}
