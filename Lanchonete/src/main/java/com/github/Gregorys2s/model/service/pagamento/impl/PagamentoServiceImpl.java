package com.github.Gregorys2s.model.service.pagamento.impl;

import com.github.Gregorys2s.controller.pagamento.dto.PagamentoDto;
import com.github.Gregorys2s.model.entity.Pagamento;
import com.github.Gregorys2s.model.entity.Pedidos;
import com.github.Gregorys2s.model.repositories.PagamentoRepository;
import com.github.Gregorys2s.model.service.pagamento.metodo.StatusPagamentoEnum;
import com.github.Gregorys2s.model.service.pagamento.metodo.MetodoPagamentoEnum;
import com.github.Gregorys2s.model.service.pagamento.PagamentoService;

import java.math.BigDecimal;

public class PagamentoServiceImpl implements PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoServiceImpl(PagamentoRepository pagamentoRepository){
        this.pagamentoRepository = pagamentoRepository;
    }

    @Override
    public Pagamento processar(PagamentoDto pagamentoDto){

        if(pagamentoDto ==  null){
            throw new IllegalArgumentException("pagamento nao pode ser nulo");
        }

        Integer idPedido = pagamentoDto.getIdPedido();
        String metodoPagamento = pagamentoDto.getMetodoPagamento();
        BigDecimal valor =  pagamentoDto.getValor();

        if (valor == null){
            throw new IllegalArgumentException("valor nao pode ser nulo");
        }

        if (valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("valor deve ser maior que zero");
        }

        if (metodoPagamento == null || metodoPagamento.isBlank()){
            throw new IllegalArgumentException("metodo de pagamento nao pode ser vazio");
        }

        if (idPedido == null){
            throw new IllegalArgumentException("id do pedido nao pode ser nulo");
        }

        MetodoPagamentoEnum metodoEnum;

        try {
            metodoEnum = MetodoPagamentoEnum.valueOf(
                    metodoPagamento.toUpperCase()
            );
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("metodo invalido");
        }

        // Otimização: Vincula o ID diretamente ao objeto Pedidos
        Pedidos pedido = new Pedidos();
        pedido.setId(idPedido);

        // Como o NFC foi removido, definimos o status diretamente como PAGO ao processar
        StatusPagamentoEnum status = StatusPagamentoEnum.PAGO;

        Pagamento pagamento = new Pagamento(
                valor,
                metodoEnum,
                status,
                pedido
        );

        // Removido o setPedido duplicado, pois já está sendo passado no construtor acima
        pagamentoRepository.salvar(pagamento);

        return pagamento;
    }
}