package com.github.Gregorys2s;


import com.github.Gregorys2s.dto.PagamentoDto;
import com.github.Gregorys2s.entity.Pagamento;
import com.github.Gregorys2s.repositories.PagamentoRepository;
import com.github.Gregorys2s.controller.PagamentoController;
import com.github.Gregorys2s.service.PagamentoServiceImpl;
import com.github.Gregorys2s.service.PagamentoService;

//import com.github.Gregorys2s.config.AppConfig;
//import com.github.Gregorys2s.view.Inicializar;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Inicializar init = AppConfig.configSistema();
        //init.inicializarSistema();

        Scanner sc = new Scanner(System.in);
        PagamentoRepository repository = new PagamentoRepository();
        PagamentoService service = new PagamentoServiceImpl(repository);
        PagamentoController pagamentoController = new PagamentoController(service);

        try{
            System.out.println("Digite o id do pedido: ");
            String idInput = sc.nextLine();

            if (idInput.isBlank()){
                throw new IllegalArgumentException("id do pedido nao pode estar vazio");
            }

            Integer idPedido = Integer.parseInt(idInput);

            System.out.println("Digite o valor do pedido");
            String valorInput = sc.nextLine();

            if (valorInput == null || valorInput.isBlank()){
                throw new IllegalArgumentException("valor nao pode ser vazio");
            }

            BigDecimal valor = new BigDecimal(valorInput);

            System.out.println("Digite o metodo de pagamento");
            String metodoInput = sc.nextLine();

            PagamentoDto dto = new PagamentoDto(idPedido, valor, metodoInput);

            Pagamento pagamento = pagamentoController.realizarPagamento(dto);

            System.out.println("Realizar Pagamento...");
            System.out.println("id pagamento: " + pagamento.getIdPagamento());
            System.out.println("Id do pedido: " + pagamento.getPedido().getId());
            System.out.println("metodo: " + pagamento.getPagamentoEnum());
            System.out.println("valor original: " + pagamento.getValorOriginal());
            System.out.println("status: " + pagamento.getStatus());
            System.out.println("data: " + pagamento.getDataPagamento());
            //System.out.println("taxa: " + pagamento.getTaxa());
            //System.out.println("valor final: " + pagamento.getValorFinal());

        }catch (NumberFormatException e){
            System.out.println("erro: valor invalido");
        }catch (IllegalArgumentException e){
            System.out.println("erro: " + e.getMessage());
        }
        sc.close();
    }
}