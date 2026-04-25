package com.github.Gregorys2s.view;

import com.github.Gregorys2s.config.ManagerEntity;
import com.github.Gregorys2s.controller.CaixaController;
import com.github.Gregorys2s.controller.Leitores;
import com.github.Gregorys2s.controller.ProdutoController;
import com.github.Gregorys2s.repositories.CardapioRepository;
import com.github.Gregorys2s.service.CardapioService;
import com.github.Gregorys2s.service.ProdutoService;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.Scanner;

public class Inicializar {
    CaixaController caixa = new CaixaController();
    EntityManager em = ManagerEntity.JPAUtil.getEntityManager();
    Leitores leitor = new Leitores();

    public void inicializarSistema()
    {

        Integer escolha = 0;
        Scanner sc = new Scanner(System.in);

        iniciarCaixa(sc);
        do{
            menuPrincipal();
            escolha = leitor.leitorInteger(sc);


                switch (escolha) {
                    case 1 -> {
                        System.out.println("\nINICIANDO PEDIDO");
                        menuPedido();
                    }
                    case 2 -> {
                        System.out.println("\nEstoque");
                    }
                    case 3 -> { System.out.println("Saindo do sistema");
                        caixa.encerrarCaixa();
                    }
                    default -> System.out.println("Opção inválida! Tente novamente.");
                }

        }while (escolha != 4);

        fechamentoCaixa();

    }

    void menuPrincipal()
    {
        System.out.println("Seja bem-vido" +
                "\n1. Iniciar Pedidos" +
                "\n2. Cardapio" +
                "\n3. Sair");
    }

    void menuPedido()
    {
        System.out.println("1. Adicionar item ao pedido" +
                "\n2. Adicionais" +
                "\n3. Visualizar pedido" +
                "\n4. Finalizar pedido");
    }

    public void iniciarCaixa(Scanner sc) {
        while (true) {
            try {
                System.out.println("Digite o valor inicial da caixa:");
                BigDecimal valor = leitor.leitorDecimais(sc);
                caixa.iniciarCaixa(valor);
                System.out.println("Caixa aberta com: " + caixa.getsaldo());
                break;
            } catch (Exception e) {
                System.out.println("Error\n");
                System.out.println("Digite um valor em numeros");
            }
        }
    }

    public void fechamentoCaixa ()
    {
        caixa.encerrarCaixa();
    }

    void iniciarPedido()
    {
        System.out.println("Produtos");

        //aqui uma funcao que vai receber os valores que o usuario vai passar
    }

}
