package com.github.Gregorys2s.model.entity;

import java.math.BigDecimal;

public class Caixa {
    private BigDecimal saldo;

    public Caixa(){
        this.saldo = BigDecimal.ZERO;
    }

    public Caixa(BigDecimal saldo){
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
