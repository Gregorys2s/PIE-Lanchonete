package com.github.Gregorys2s.controller;

import java.math.BigDecimal;
import java.util.Scanner;

public class Leitores {

    //testar todos os leitores, avisar

    public BigDecimal leitorDecimais(Scanner sc)
    {
        while(true) {
            try {
                String entrada = sc.nextLine().replace(",", ".");
                BigDecimal valor = new BigDecimal(entrada);
                if (valor.compareTo(BigDecimal.ZERO) <= 0){throw new Exception("A caixa nao pode abrir com 0");}
                return valor;
            } catch (Exception e) {
                System.out.println("Error\n");
                System.out.println("Digite um valor em numeros");
            }
        }
    }

    public String leitorTextos(Scanner sc)
    {
        while (true)
        {
            try
            {
                String entrada = sc.nextLine();
                if (entrada.isEmpty())
                {
                    System.out.println("Digite alguma coisa");
                }else
                {
                    return entrada;
                }

            }catch(Exception e)
            {
                e.printStackTrace();
            }

        }

    }
    
    public Integer leitorInteger(Scanner sc) {
        while (true)
        {
            try {
                Integer entrada = 0;
                while (!sc.hasNextInt())
                {
                    System.out.println("Error\n digite um numero");
                    sc.next();
                }
                return entrada;

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }



}
