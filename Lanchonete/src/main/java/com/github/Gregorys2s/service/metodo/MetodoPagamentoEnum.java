package com.github.Gregorys2s.service.metodo;

import java.math.BigDecimal;

public enum MetodoPagamentoEnum {
    PIX {
        public BigDecimal calcularTaxa(BigDecimal valor) {
            return BigDecimal.ZERO;
        }
    },

    CREDITO {
        public BigDecimal calcularTaxa(BigDecimal valor) {
            return valor.multiply(new BigDecimal("0.02"));
        }
    },

    DEBITO {
        public BigDecimal calcularTaxa(BigDecimal valor) {
            return valor.multiply(new BigDecimal("0.05"));
        }
    },

    DINHEIRO{
        public BigDecimal calcularTaxa(BigDecimal valor){
            return BigDecimal.ZERO;
        }
    };
    public abstract BigDecimal calcularTaxa(BigDecimal valor);
}
