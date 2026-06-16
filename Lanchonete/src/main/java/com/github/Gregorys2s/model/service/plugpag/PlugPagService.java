package com.github.Gregorys2s.model.service.plugpag;

import br.uol.pagseguro.client.plugpag.PlugPag;
import java.io.File;

public class PlugPagService {

    private static final String MAC_MODERNINHA = "AA:BB:CC:DD:EE:FF"; // troque pelo seu MAC
    private PlugPag plugPag;

    public PlugPagService() {
        String libsPath = "C:\\Users\\felip\\OneDrive\\Desktop\\lanchonete-projeto\\Lanchonete\\libs";
        System.load(libsPath + "\\BTSerial.dll");
        System.load(libsPath + "\\PPPagSeguro.dll");
        System.load(libsPath + "\\PlugPag.dll");
        plugPag = new PlugPag();
    }

    public void conectar(String portaCOM) {
        plugPag.InitBTConnection(portaCOM); // ex: "COM3"
        System.out.println("Conectado em: " + portaCOM);
    }

    public ResultadoPagamento pagarCredito(double valorReais, String referencia) {
        int valorCentavos = (int)(valorReais * 100);
        String valorStr = String.valueOf(valorCentavos); // "1000" para R$10,00

        int ret = plugPag.SimplePaymentTransaction(
                PlugPag.CREDIT,
                PlugPag.A_VISTA,
                1,
                valorStr,      // VALOR aqui
                referencia     // REFERENCIA aqui
        );

        return new ResultadoPagamento(
                ret == PlugPag.RET_OK,
                ret,
                plugPag.getTransactionCode(),
                plugPag.getHostNsu(),
                plugPag.getCardBrand(),
                plugPag.getMessage()
        );
    }

    public ResultadoPagamento pagarDebito(double valorReais, String referencia) {
        int valorCentavos = (int)(valorReais * 100);

        int ret = plugPag.SimplePaymentTransaction(
                PlugPag.DEBIT,
                valorCentavos,
                1,
                referencia,
                String.valueOf(PlugPag.A_VISTA)
        );

        return new ResultadoPagamento(
                ret == PlugPag.RET_OK,
                ret,
                plugPag.getTransactionCode(),
                plugPag.getHostNsu(),
                plugPag.getCardBrand(),
                plugPag.getMessage()
        );
    }

    public void desconectar() {
        plugPag.UnloadDriverConnection();
    }

    public record ResultadoPagamento(
            boolean aprovado,
            int codigoRetorno,
            String codigoTransacao,
            String nsu,
            String bandeira,
            String mensagem
    ) {}
}