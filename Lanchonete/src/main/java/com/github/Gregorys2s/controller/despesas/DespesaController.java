package com.github.Gregorys2s.controller.despesas;

import com.github.Gregorys2s.controller.caixa.CaixaController;
import com.github.Gregorys2s.controller.entries.InputEnum;
import com.github.Gregorys2s.exceptions.DespesasControllerException;
import com.github.Gregorys2s.model.service.despesas.DespesasService;

import java.math.BigDecimal;

public class DespesaController {
    private final DespesasService despesasService;
    public DespesaController(DespesasService despesasService) {
        this.despesasService = despesasService;
    }

    public void novaDespesa(BigDecimal valorDespesa)
    {
        despesasService.novaDespesa(valorDespesa);
    }

    public void verificarInput(String valorInput, BigDecimal valor) {
        try {
            InputEnum input = InputEnum.verifyInput(valorInput);
            switch (input) {
                case CONTINUAR -> {
                    // Subtrai o valor total da despesa do caixa
                    System.out.println("Todo valor removido do caixa físico.");
                    novaDespesa(valor);
                }
                case CANCELAR -> {
                    System.out.println("Despesa registrada sem afetar o saldo do caixa físico.");
                }
                case NOVO_VALOR -> {
                    // Sao tres souts gregory nao tem problema o que importa eh que funciona
                    String limpo = valorInput.replaceAll("[^0-9,. ]", "").trim();
                    limpo = limpo.replace(",", ".");
                    BigDecimal valorCustomizado = new BigDecimal(limpo);
                    System.out.println("Valor customizado de R$ " + valorCustomizado + " removido do caixa");
                }
            }
        }catch(DespesasControllerException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
