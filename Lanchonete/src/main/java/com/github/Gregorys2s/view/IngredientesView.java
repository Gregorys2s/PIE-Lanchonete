package com.github.Gregorys2s.view;

import com.github.Gregorys2s.controller.IngredientesController;
import com.github.Gregorys2s.controller.Leitores;
import com.github.Gregorys2s.entity.Ingredientes;

import java.util.List;
import java.util.Scanner;

public class IngredientesView {

    private final IngredientesController controller; // NOVO

    public IngredientesView(IngredientesController controller) { // NOVO
        this.controller = controller;
    }

    // NOVO — método principal chamado pelo Inicializar
    public void menuIngredientes(Scanner sc) {
        int opcao;
        do {
            exibirMenu();
            opcao = Leitores.leitorInteger(sc);

            switch (opcao) {
                case 1 -> {
                    Ingredientes criado = controller.criarIngrediente();
                    exibirSucesso("Ingrediente cadastrado com sucesso!");
                    exibirIngrediente(criado);
                }
                case 2 -> {
                    Ingredientes encontrado = controller.buscarIngrediente();
                    exibirIngrediente(encontrado);
                }
                case 3 -> {
                    List<Ingredientes> todos = controller.listarIngredientes();
                    exibirLista(todos);
                }
                case 4 -> {
                    Ingredientes atualizado = controller.atualizarIngrediente();
                    exibirSucesso("Ingrediente atualizado com sucesso!");
                    exibirIngrediente(atualizado);
                }
                case 5 -> {
                    controller.excluirIngrediente();
                    exibirSucesso("Ingrediente excluído com sucesso!");
                }
                case 6 -> {
                    Ingredientes comEstoque = controller.adicionarEstoque();
                    exibirSucesso("Estoque adicionado com sucesso!");
                    exibirIngrediente(comEstoque);
                }
                case 7 -> {
                    Ingredientes semEstoque = controller.removerEstoque();
                    exibirSucesso("Estoque removido com sucesso!");
                    exibirIngrediente(semEstoque);
                }
                case 8 -> {
                    List<Ingredientes> baixo = controller.listarEstoqueBaixo();
                    exibirLista(baixo);
                }
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> exibirAviso("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);
    }

    // — os métodos abaixo são os mesmos que já existiam —

    public void exibirMenu() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║    GESTÃO DE INGREDIENTES          ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ 1. Cadastrar Ingrediente           ║");
        System.out.println("║ 2. Buscar Ingrediente              ║");
        System.out.println("║ 3. Listar Todos                    ║");
        System.out.println("║ 4. Atualizar Ingrediente           ║");
        System.out.println("║ 5. Excluir Ingrediente             ║");
        System.out.println("║ 6. Adicionar Estoque               ║");
        System.out.println("║ 7. Remover Estoque                 ║");
        System.out.println("║ 8. Listar Estoque Baixo            ║");
        System.out.println("║ 0. Voltar                          ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.print("Escolha uma opção: ");
    }

    public void exibirSucesso(String mensagem) {
        System.out.println("\n✓ " + mensagem);
    }

    public void exibirErro(String mensagem) {
        System.err.println("\n✗ ERRO: " + mensagem);
    }

    public void exibirAviso(String mensagem) {
        System.out.println("\n⚠ AVISO: " + mensagem);
    }

    public void exibirIngrediente(Ingredientes ingrediente) {
        System.out.println("\n┌──────────────────────────────────┐");
        System.out.println("│ DETALHES DO INGREDIENTE          │");
        System.out.println("├──────────────────────────────────┤");
        System.out.printf("│ ID:      %-23d │%n", ingrediente.getId());
        System.out.printf("│ Nome:    %-23s │%n", ingrediente.getNome());
        System.out.printf("│ Estoque: %-23d │%n", ingrediente.getEstoque());

        if (ingrediente.getEstoque() == 0) {
            System.out.println("│ Status:  ESGOTADO             │");
        } else if (ingrediente.getEstoque() <= 10) {
            System.out.println("│ Status:  BAIXO                │");
        } else {
            System.out.println("│ Status:  DISPONÍVEL           │");
        }

        System.out.println("└──────────────────────────────────┘");
    }

    public void exibirLista(List<Ingredientes> ingredientes) {
        if (ingredientes.isEmpty()) {
            System.out.println("\nNenhum ingrediente encontrado.");
            return;
        }

        System.out.println("\n╔═════════════════════════════════════════════════════════╗");
        System.out.println("║              LISTA DE INGREDIENTES                      ║");
        System.out.println("╠═════╦════════════════════════╦══════════╦═══════════════╣");
        System.out.println("║ ID  ║ Nome                   ║ Estoque  ║ Status        ║");
        System.out.println("╠═════╬════════════════════════╬══════════╬═══════════════╣");

        for (Ingredientes ing : ingredientes) {
            String status;
            if (ing.getEstoque() == 0) {
                status = "ESGOTADO";
            } else if (ing.getEstoque() <= 10) {
                status = "BAIXO";
            } else {
                status = "OK";
            }

            System.out.printf("║ %-3d ║ %-22s ║ %-8d ║ %-13s ║%n",
                    ing.getId(),
                    truncarTexto(ing.getNome(), 22),
                    ing.getEstoque(),
                    status
            );
        }

        System.out.println("╚═════╩════════════════════════╩══════════╩═══════════════╝");
        System.out.printf("\nTotal: %d ingrediente(s)%n", ingredientes.size());
    }

    public void exibirEstatisticas(List<Ingredientes> ingredientes) {
        if (ingredientes.isEmpty()) {
            System.out.println("\nNenhum dado para exibir.");
            return;
        }

        int totalEstoque = ingredientes.stream()
                .mapToInt(Ingredientes::getEstoque)
                .sum();

        long esgotados = ingredientes.stream()
                .filter(i -> i.getEstoque() == 0)
                .count();

        long estoqueBaixo = ingredientes.stream()
                .filter(i -> i.getEstoque() > 0 && i.getEstoque() <= 10)
                .count();

        System.out.println("\n┌─────────────────────────────────┐");
        System.out.println("│ ESTATÍSTICAS DO ESTOQUE         │");
        System.out.println("├─────────────────────────────────┤");
        System.out.printf("│ Total de ingredientes: %-8d │%n", ingredientes.size());
        System.out.printf("│ Estoque total:         %-8d │%n", totalEstoque);
        System.out.printf("│ Esgotados:             %-8d │%n", esgotados);
        System.out.printf("│ Estoque baixo:         %-8d │%n", estoqueBaixo);
        System.out.println("└─────────────────────────────────┘");
    }

    private String truncarTexto(String texto, int tamanho) {
        if (texto == null) return "";
        if (texto.length() <= tamanho) return texto;
        return texto.substring(0, tamanho - 3) + "...";
    }
}