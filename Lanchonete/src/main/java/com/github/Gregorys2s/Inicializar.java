package com.github.Gregorys2s;

import com.github.Gregorys2s.controller.CaixaController;
import com.github.Gregorys2s.controller.LeitoresController;

import java.util.Scanner;

public class Inicializar {

    public void inicializarSistema()
    {

        CaixaController caixa = new CaixaController();
        LeitoresController leitor = new LeitoresController();
        Integer escolha = 0;
        Scanner sc = new Scanner(System.in);

        caixa.iniciarCaixa(sc);
        do{
            menuPrincipal();
            escolha = leitor.leitorInteger(sc);


                switch (escolha) {
                    case 1 -> {
                        System.out.println("\nINICIANDO PEDIDO");
                    }
                    case 2 -> {
                        System.out.println("\n");
                    }
                    case 3 -> {
                        System.out.println("\nEstoque");
                    }
                    case 4 -> { System.out.println("Saindo do sistema");
                        caixa.encerrarCaixa();
                    }
                    default -> System.out.println("Opção inválida! Tente novamente.");
                }

        }while (escolha != 4);

    }

    void menuPrincipal()
    {
        System.out.println("Seja bem-vido");
        System.out.println("1. Inciar Pedidos");
        System.out.println("2. ");//ver o que colocar aqui o se for necessario
        System.out.println("3. Estoque");
        System.out.println("4. Sair");


    }

}
