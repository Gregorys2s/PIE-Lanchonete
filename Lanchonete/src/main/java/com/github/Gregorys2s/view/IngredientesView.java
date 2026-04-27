/*package com.github.Gregorys2s.view;

import com.github.Gregorys2s.controller.IngredientesController;
import com.github.Gregorys2s.entity.Ingredientes;

import java.util.Scanner;

public class IngredientesView {

    private IngredientesController controller = new IngredientesController();

    private Scanner scanner = new Scanner(System.in);

    public void exibirMenuSalvar() {
        System.out.print("=== CADASTRAR NOVO INGREDIENTE ===");

        System.out.println("Digite o nome do ingrediente:");
        String nome = scanner.nextLine();

        System.out.println("Digite a quantidade em estoque para" + nome + "? ");
        String quantidade = scanner.nextLine();

        try{
            int estoque = Integer.parseInt(quantidade);

            String respostaDoSistema = controller.salvarIngrediente(nome, estoque);

            System.out.println(">> " + respostaDoSistema);
        } catch (NumberFormatException e) {
            System.out.println("Erro de digitação: Voce precisa digitar um numero inteiro valido para o estoque!");
        }
    }

    private void exibirMenuAlterar() {
        System.out.print("=== ESTOQUE ATUAL ===");

        java.util.List<Ingredientes> list = controller.listarIngredientes();

        if (list.isEmpty()) {
            System.out.println("Nenhum ingrediente encontrado!");
        } else {
            for (Ingredientes item  : list) {
                System.out.println("ID: " + item.getId() + "| Nome: " + item.getNome() + "| Quantidade: " + item.getEstoque());
            }

            }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
    }




}


 */