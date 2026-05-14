package com.github.Gregorys2s.view;

import com.github.Gregorys2s.controller.IngredientesController;
import com.github.Gregorys2s.controller.Leitores;
import com.github.Gregorys2s.entity.Ingredientes;
import java.util.List;
import java.util.Scanner;

public class IngredientesView {

    IngredientesController ingredientescontroller;

    public IngredientesView(IngredientesController ingredientescontroller) {
        this.ingredientescontroller = ingredientescontroller;
    }

    public void menuPrincipal(Scanner sc)
    {
        int escolha;
        do
        {
            exibirMenu();
            escolha = Leitores.leitorInteger(sc);
            switch (escolha)
            {
                case 1 ->{
                    criarIngrediente(sc);
                }
                case 2 ->{
                    buscarIngrediente(sc);
                }
                case 3 ->{
                    exibirLista();
                }
                case 4 ->{
                    atualizarIngrediente(sc);
                }
                case 5 ->{
                    excluirIngrediente(sc);
                }
                case 6 ->{
                    adicionarEstoque(sc);
                }
                case 7 ->{
                    removerEstoque(sc);
                }
                case 8 ->{
                    listarEstoqueBaixo(sc);
                }
                case 0 ->{}

            }
        }while(escolha != 0);

    }


    void exibirMenu() {
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


     void exibirSucesso(String mensagem) {
        System.out.println("\n✓ " + mensagem);
    }

     void exibirErro(String mensagem) {
        System.err.println("\n✗ ERRO: " + mensagem);
    }

     void exibirAviso(String mensagem) {
        System.out.println("\n⚠ AVISO: " + mensagem);
    }


     void exibirIngrediente(Ingredientes ingrediente) {
        System.out.println("\n┌──────────────────────────────────┐");
        System.out.println("│ DETALHES DO INGREDIENTE          │");
        System.out.println("├──────────────────────────────────┤");
        System.out.printf("│ ID:      %-23d │%n", ingrediente.getId());
        System.out.printf("│ Nome:    %-23s │%n", ingrediente.getNome());
        System.out.printf("│ Estoque: %-23d │%n", ingrediente.getEstoque());

        // Indicador visual de estoque
        if (ingrediente.getEstoque() == 0) {
            System.out.println("│ Status:  ESGOTADO             │");
        } else if (ingrediente.getEstoque() <= 10) {
            System.out.println("│ Status:  BAIXO                │");
        } else {
            System.out.println("│ Status:  DISPONÍVEL           │");
        }

        System.out.println("└──────────────────────────────────┘");
    }


     void exibirLista() {

        List<Ingredientes> ingredientes = ingredientescontroller.listarIngredientes();
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

    // Dados dos Ingredientes

     void exibirEstatisticas(List<Ingredientes> ingredientes) {
        if (ingredientes.isEmpty()) {
            System.out.println("\nNenhum dado para exibir.");
            return;
        }

        int totalEstoque = ingredientes.stream()
                .mapToInt(Ingredientes::getEstoque)
                .sum();

        int esgotados = (int) ingredientes.stream()
                .filter(i -> i.getEstoque() == 0)
                .count();

        int estoqueBaixo = (int) ingredientes.stream()
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
        if (texto == null) {
            return "";
        }
        if (texto.length() <= tamanho) {
            return texto;
        }
        return texto.substring(0, tamanho - 3) + "...";
    }

    void criarIngrediente(Scanner sc) {
        System.out.print("Nome do ingrediente: ");
        String nome = Leitores.leitorTextos(sc);

        System.out.print("Quantidade em estoque: ");
        int estoque = Leitores.leitorInteger(sc);

        Ingredientes ingrediente = new Ingredientes(nome, estoque);

        ingredientescontroller.cadastrarIngrediente(ingrediente);
    }

    void buscarIngrediente(Scanner sc) {
        System.out.print("ID do ingrediente: ");
        int id = Leitores.leitorInteger(sc);

        Ingredientes ingrediente = ingredientescontroller.buscarId(id);
        exibirIngrediente(ingrediente);
    }

    void atualizarIngrediente(Scanner sc) {
        System.out.print("ID do ingrediente para atualizar: ");
        int id = Leitores.leitorInteger(sc);

        System.out.print("Novo nome: ");
        String novoNome = Leitores.leitorTextos(sc);

        System.out.print("Nova quantidade em estoque: ");
        int novoEstoque = Leitores.leitorInteger(sc);

        Ingredientes ingredienteAtualizado = new Ingredientes(novoNome, novoEstoque);

        ingredientescontroller.atualizarIngrediente(id,ingredienteAtualizado);
    }

    void excluirIngrediente(Scanner sc) {
        System.out.print("ID do ingrediente para excluir: ");
        int id = Leitores.leitorInteger(sc);

        ingredientescontroller.excluirIngrediente(id);
    }

    void adicionarEstoque(Scanner sc) {
        System.out.print("ID do ingrediente: ");
        int id = Leitores.leitorInteger(sc);

        System.out.print("Quantidade a adicionar: ");
        int quantidade = Leitores.leitorInteger(sc);

        ingredientescontroller.adicionarEstoque(id,quantidade);
    }

    public void removerEstoque(Scanner sc) {
        System.out.print("ID do ingrediente: ");
        int id = Leitores.leitorInteger(sc);

        System.out.print("Quantidade a remover: ");
        Integer quantidade = Leitores.leitorInteger(sc);

        ingredientescontroller.removerEstoque(id,quantidade);
    }

    public void listarEstoqueBaixo(Scanner sc) {
        System.out.print("Limite mínimo de estoque: ");
        int limite = Leitores.leitorInteger(sc);

        List<Ingredientes> estoqueBaixo = ingredientescontroller.listarEstoqueBaixo(limite);
        exibirEstatisticas(estoqueBaixo);
    }

}