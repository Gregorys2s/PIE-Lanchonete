package com.github.Gregorys2s;

import com.github.Gregorys2s.controller.Leitores;

import java.util.Scanner;

public class Inicializar {

    public void inicializarSystema()
    {

        Caixa cax = new Caixa();
        Scanner sc = new Scanner(System.in);
        Leitores leitor = new Leitores();
        Integer escolha = 0;

        cax.abrirCaixa();
        do{
            escolha = leitor.leitorInteger(sc);
            switch (escolha)
            {

            }
            cax.fecharCaixa();
        }while (escolha != 8);

    }

    void menuPrincipal()
    {
        System.out.println("Seja bem-vido");
        System.out.println("1.");
        System.out.println("2.");
        System.out.println("3.");
        System.out.println("4.");
        System.out.println("5.");
        System.out.println("6.");
        System.out.println("7.");
        System.out.println("8.");


    }

}
