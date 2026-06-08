package com.github.Gregorys2s.model.service.pagamento.impl;

public class PagamentoRecusadoException extends RuntimeException {

    public PagamentoRecusadoException(String mensagem) {
        super(mensagem);
    }

    public PagamentoRecusadoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}