package com.github.Gregorys2s.controller;

import java.math.BigDecimal;
import java.util.Scanner;

public class Leitores {

    public BigDecimal leitoresDecimais(Scanner sc)
    {
        while(true) {
            try {
                String entrada = sc.nextLine().replace(",", ".");
                BigDecimal valor = new BigDecimal(entrada);
                return valor;
            } catch (Exception e) {
                System.out.println("Error\n");
                System.out.println("Digite um valor em numeros");
            }
        }
    }



}
