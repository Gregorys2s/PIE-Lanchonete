package com.github.Gregorys2s;

import com.github.Gregorys2s.controller.pagamento.PagamentoController;
import com.github.Gregorys2s.controller.pagamento.dto.PagamentoDto;
import com.github.Gregorys2s.model.entity.Pagamento;
import com.github.Gregorys2s.model.service.pagamento.metodo.MetodoPagamentoEnum;

import java.math.BigDecimal;
import java.util.Scanner;

public class testeDePagamento {
    PagamentoController controller;

    public testeDePagamento(PagamentoController controller) {
        this.controller = controller;
    }

    void test(){
        int opcao=0;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("1 pagar pedido");
            System.out.println("Insira o valor");

            String entrada = sc.nextLine().replace(",", ".");

            BigDecimal dinheiro = new BigDecimal(entrada);

            MetodoPagamentoEnum metodo = MetodoPagamentoEnum.PIX;

            PagamentoDto valor = new PagamentoDto(1,dinheiro, "PIX");

            controller.realizarPagamento(valor);

        }while(opcao == 5 );

    }

}
