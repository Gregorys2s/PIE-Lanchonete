package com.github.Gregorys2s.view;

import com.github.Gregorys2s.controller.IngredientesController;
import javax.swing.JOptionPane;

public class IngredientesView {

    private IngredientesController controller = new IngredientesController();

    public void exibirTelaSalvarIngrediente() {

        String nome = JOptionPane.showInputDialog("Digite o nome do ingrediente");
        if (nome == null) {
            return;
        }

        String estoqueTexto = JOptionPane.showInputDialog("Digite a quantidade em estoque do ingrediente");
        if (estoqueTexto == null) {
            return;
        }

        try {

            int estoque = Integer.parseInt(estoqueTexto);

            String respostaDoSistema = controller.salvarIngrediente(nome, estoque);

            JOptionPane.showMessageDialog(null, respostaDoSistema);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: Você precisa digitar um número válido para o estoque");
        }


    }

}
