package com.github.Gregorys2s.service;

import com.github.Gregorys2s.dto.PagamentoDto;
import com.github.Gregorys2s.entity.Pagamento;
import com.github.Gregorys2s.repositories.PagamentoRepository;
import java.math.BigDecimal;

public class PagamentoServiceImpl implements PagamentoService{
    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository){
        this.pagamentoRepository = PagamentoRepository;
    }

    @Override
    public Pagamento processar(PagamentoDto pagamentoDto){
        BigDecimal valor = pagamentoDto.getValor();
        String metodo = pagamentoDto.getMetodoPagamento().toLowerCase();

        BigDecimal taxa = BigDecimal.ZERO;

        if(metodo.equals("credito")){
            taxa = valor.multiply(new BigDecimal("0.05"));
        } else if (metodo.equals("debito")) {
            taxa = valor.multiply(new BigDecimal(0.02));
        } else if (metodo.equals("pix")) {
            taxa = BigDecimal.ZERO;
        }else if (metodo.equals("dinheiro")){
            taxa = BigDecimal.ZERO;
        }else {
            throw new IllegalArgumentException("metodo invalido");
        }
        BigDec
    }
}
