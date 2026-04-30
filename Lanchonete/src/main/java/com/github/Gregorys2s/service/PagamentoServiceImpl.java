package com.github.Gregorys2s.service;

import com.github.Gregorys2s.dto.PagamentoDto;
import com.github.Gregorys2s.entity.Pagamento;
import com.github.Gregorys2s.repositories.PagamentoRepository;
import com.github.Gregorys2s.service.metodo.StatusPagamentoEnum;
import com.github.Gregorys2s.service.metodo.MetodoPagamentoEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PagamentoServiceImpl implements PagamentoService{

    private final PagamentoRepository pagamentoRepository;

    public PagamentoServiceImpl(PagamentoRepository pagamentoRepository){
    this.pagamentoRepository = pagamentoRepository;
}

    @Override
    public Pagamento processar(PagamentoDto pagamentoDto){

       if(pagamentoDto ==  null){
           throw new IllegalArgumentException("pagamento nao pode ser nulo");
       }

       if (pagamentoDto.getValor() == null){
           throw new IllegalArgumentException("valor nao pode ser nulo");
       }

       if (pagamentoDto.getValor().compareTo(BigDecimal.ZERO) <= 0){
           throw new IllegalArgumentException("valor deve ser maior que zero");
       }

       if (pagamentoDto.getMetodoPagamento() == null || pagamentoDto.getMetodoPagamento().isBlank()){
           throw new IllegalArgumentException("metodo de pagamento nao pode ser vazio");
        }

       Integer IdPedido = pagamentoDto.getIdPedido();
       String MetodoPagamento = pagamentoDto.getMetodoPagamento();
       BigDecimal valor = pagamentoDto.getValor();

       MetodoPagamentoEnum metodoEnum;

       try {
           metodoEnum = MetodoPagamentoEnum.valueOf(
                   MetodoPagamento.toUpperCase()
           );
       }catch (IllegalArgumentException e){
           throw new IllegalArgumentException("metodo invalido");
       }

       BigDecimal taxa = metodoEnum.calcularTaxa(valor)
               .setScale(2, RoundingMode.HALF_UP);
       BigDecimal valoFinal = valor.add(taxa)
               .setScale(2, RoundingMode.HALF_UP);

       Pagamento pagamento = new Pagamento(
               valor,
               taxa,
               valoFinal,
               metodoEnum,
               StatusPagamentoEnum.PAGO
       );

       pagamentoRepository.salvar(pagamento);

       return pagamento;
    }
}
