package com.github.Gregorys2s.model.service.plugpag;

public enum TipoPagamentoPlugPag {

    DEBITO("A_VISTA", 1),
    CREDITO("CREDITO_1", 2),
    PIX("PIX", 5);

    private final String nomePlugPag;
    private final int codigoInt;

    TipoPagamentoPlugPag(String nomePlugPag, int codigoInt) {
        this.nomePlugPag = nomePlugPag;
        this.codigoInt   = codigoInt;
    }

    public String getCodigoPlugPag() { return nomePlugPag; }
    public int getCodigoInt() { return codigoInt; }

    public static TipoPagamentoPlugPag deMetodoExistente(String metodo) {
        return switch (metodo.toUpperCase().trim()) {
            case "DEBITO"  -> DEBITO;
            case "CREDITO" -> CREDITO;
            case "PIX"     -> PIX;
            default -> throw new IllegalArgumentException(
                    "Método '" + metodo + "' não pode ser processado pela maquininha. " +
                            "Use DEBITO, CREDITO ou PIX.");
        };
    }
}