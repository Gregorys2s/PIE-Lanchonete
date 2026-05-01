package com.github.Gregorys2s.service.metodo;

//import java.math.BigDecimal;

public enum MetodoPagamentoEnum {
    PIX {
        /*@Override
        public BigDecimal calcularTaxa(BigDecimal valor) {
            return BigDecimal.ZERO;
        }*/
    },

    CREDITO {
        /*@Override
        public BigDecimal calcularTaxa(BigDecimal valor) {
            //return valor.multiply(new BigDecimal("0.02"));
            return BigDecimal.ZERO;
        }*/
    },

    DEBITO {
        /*@Override
        public BigDecimal calcularTaxa(BigDecimal valor) {
            return valor.multiply(new BigDecimal("0.05"));
        }*/
    },

    DINHEIRO{
        /*@Override
        public BigDecimal calcularTaxa(BigDecimal valor){
            return BigDecimal.ZERO;
        }*/
    }

    //public abstract BigDecimal calcularTaxa(BigDecimal valor);
}
