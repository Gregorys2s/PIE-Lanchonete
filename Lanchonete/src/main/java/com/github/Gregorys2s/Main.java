package com.github.Gregorys2s;

import com.github.Gregorys2s.config.AppConfig;
import com.github.Gregorys2s.config.FlyWay;
import com.github.Gregorys2s.view.inicializacao.MenuInicial;
import com.github.Gregorys2s.view.inicializacao.MenuPrincipal;
import com.github.Gregorys2s.model.service.plugpag.PlugPagService;


public class Main {
    public static void main(String[] args) {
       // FlyWay.migrate();
        //AppConfig config = new AppConfig();
        try {

            System.out.println("Iniciando...");
            PlugPagService service = new PlugPagService();
            System.out.println("PlugPag criado!");
            service.conectar("COM4");
            System.out.println("Conectado!");
            PlugPagService.ResultadoPagamento resultado = service.pagarCredito(10.00, "PEDIDO-001");
            System.out.println("Aprovado: " + resultado.aprovado());
            System.out.println("Codigo retorno: " + resultado.codigoRetorno());
            System.out.println("Mensagem: " + resultado.mensagem());
            System.out.println("NSU: " + resultado.nsu());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
        /*PlugPagService service = new PlugPagService();
        service.conectarDemo();

        PlugPagService.ResultadoPagamento resultado = service.pagarCredito(10.00, "PEDIDO-001");
        System.out.println("Aprovado: " + resultado.aprovado());
        System.out.println("Mensagem: " + resultado.mensagem());
        System.out.println("NSU: " + resultado.nsu());
        // 2. Run the UI on the Event Dispatch Thread (Swing standard)
        java.awt.EventQueue.invokeLater(() -> {
            try {
                java.awt.EventQueue.invokeLater(() -> {
                    new MenuInicial(config.getCardapioController(),config.getPedidosController()).setVisible(true);
                });
                testeDePagamento teste = new testeDePagamento(config.getPagamentoController());
                teste.test();

            } catch (Exception e) {//fazer a coletanea de erros depois
                e.printStackTrace();
            }
        });

         */
        }
