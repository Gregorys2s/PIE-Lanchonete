package com.github.Gregorys2s.view;

import com.github.Gregorys2s.controller.DespesaController;
import com.github.Gregorys2s.controller.Leitores;

import java.math.BigDecimal;
import java.util.Scanner;

public class DespesasView {
    private final DespesaController despesasController;
    public DespesasView(DespesaController despesasController) {
        this.despesasController = despesasController;
    }
    protected void menuDespesas(Scanner sc){
        System.out.println("1. Nova Despesa" +
                "\n2. Voltar");
        Integer opc = Leitores.leitorInteger(sc);
        switch(opc){
            case 1:
                System.out.println("Digite quanto foi gasto: \n");
                BigDecimal valor_despesa = Leitores.leitorDecimais(sc);
                despesasController.novaDespesa(valor_despesa);
                removidoDoCaixa(sc, valor_despesa);
                break;
            case 2: return;
            default:
                System.out.println("Escolha uma opcao");
        }
    }

    private void removidoDoCaixa(Scanner sc, BigDecimal valorDespesa){
        System.out.println("O valor de R$ " + valorDespesa + " foi retirado do DINHEIRO FÍSICO do caixa?" +
                "\nDigite 'continuar' para SIM (subtrair do caixa)" +
                "\nDigite 'cancelar' para NÃO (pagamento externo/cartão)" +
                "\nOu digite um NOVO VALOR caso tenha retirado apenas uma parte:");
        despesasController.verificarInput(Leitores.leitorTextos(sc), valorDespesa);

    }
}
