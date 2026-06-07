// model/entity/Caixa.java
package com.github.Gregorys2s.model.entity;

import java.math.BigDecimal;

public class Caixa {

    private BigDecimal dinheiroEmCaixa = BigDecimal.ZERO;
    private boolean aberto = false;

    public Caixa() {}

    public BigDecimal getDinheiroEmCaixa() {
        return dinheiroEmCaixa;
    }

    public void setDinheiroEmCaixa(BigDecimal dinheiroEmCaixa) {
        this.dinheiroEmCaixa = dinheiroEmCaixa;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }
}