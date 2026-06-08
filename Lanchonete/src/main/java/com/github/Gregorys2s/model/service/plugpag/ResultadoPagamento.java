package com.github.Gregorys2s.model.service.plugpag;

public class ResultadoPagamento {

    public enum Status { APROVADO, RECUSADO, ERRO }

    private final Status status;
    private final String nsu;
    private final String codigoAutorizacao;
    private final String mensagem;

    private ResultadoPagamento(Status status, String nsu, String codigoAutorizacao, String mensagem) {
        this.status = status;
        this.nsu = nsu;
        this.codigoAutorizacao = codigoAutorizacao;
        this.mensagem = mensagem;
    }

    public static ResultadoPagamento aprovado(String nsu, String codigoAutorizacao) {
        return new ResultadoPagamento(Status.APROVADO, nsu, codigoAutorizacao, "");
    }

    public static ResultadoPagamento recusado(String mensagem) {
        return new ResultadoPagamento(Status.RECUSADO, "", "", mensagem);
    }

    public static ResultadoPagamento erro(String mensagem) {
        return new ResultadoPagamento(Status.ERRO, "", "", mensagem);
    }

    public boolean foiAprovado() { return status == Status.APROVADO; }

    public Status getStatus() { return status; }
    public String getNsu() { return nsu; }
    public String getCodigoAutorizacao() { return codigoAutorizacao; }
    public String getMensagem() { return mensagem; }

    @Override
    public String toString() {
        return "ResultadoPagamento{status=" + status +
                ", nsu='" + nsu + '\'' +
                ", codigoAutorizacao='" + codigoAutorizacao + '\'' +
                ", mensagem='" + mensagem + '\'' + '}';
    }
}