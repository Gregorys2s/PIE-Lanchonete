package com.github.Gregorys2s.controller;

import com.github.Gregorys2s.entity.CaixaEntity;

import java.math.BigDecimal;
import java.util.Scanner;

public class CaixaController {
    CaixaEntity caixaEntity = new CaixaEntity();
    LeitoresController leitor = new LeitoresController();

    public void iniciarCaixa(Scanner sc) {
        while (true) {
            try {
                System.out.println("Digite o valor inicial da caixa:");
                BigDecimal valor = leitor.leitorDecimais(sc);
                caixaEntity.abrirCaixa(valor);
                System.out.println("Caixa aberta com: " + caixaEntity.getdinheiroEmCaixa());
                break;
            } catch (Exception e) {
                System.out.println("Error\n");
                System.out.println("Digite um valor em numeros");
            }
        }
    }
        public void encerrarCaixa()
    {
        System.out.println("Valor na caixa: "/*aqui estara os valores que ficaram na caixa e a lista de lucro e tal*/);
        System.out.println();
        System.out.println();

        caixaEntity.fecharCaixa();
        System.out.println("Caixa encerrada com sucesso");
    }

}
