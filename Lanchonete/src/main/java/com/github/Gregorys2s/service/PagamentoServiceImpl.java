package com.github.Gregorys2s.service;

import com.github.Gregorys2s.dto.PagamentoDto;
import com.github.Gregorys2s.entity.Pagamento;
import com.github.Gregorys2s.repositories.PagamentoRepository;
import java.math.BigDecimal;

public class PagamentoServiceImpl implements PagamentoService{
    private final PagamentoRepository pagamentoRepository;

    public PagamentoServiceImpl(PagamentoRepository pagamentoRepository){
        this.pagamentoRepository = pagamentoRepository;
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
        BigDecimal valorFinal = valor.add(taxa);

        //Foi trocado o nome de todas as entidades com nome de "Pagamento" para "PagamentoEntity"
        // Para que essa parte funcionasse, tive que criar novos construtores na entidade "PagamentoEntity"
        Pagamento pagamento = new Pagamento(
                pagamentoDto.getIdPedido(),
                valor,
                taxa,
                valorFinal,
                metodo,
                "APROVADO"
        );

        pagamentoRepository.salvar(pagamento);

        return pagamento;
    }
}
