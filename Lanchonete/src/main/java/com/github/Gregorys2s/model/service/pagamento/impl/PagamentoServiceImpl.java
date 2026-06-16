package com.github.Gregorys2s.model.service.pagamento.impl;

import com.github.Gregorys2s.controller.pagamento.dto.PagamentoDto;
import com.github.Gregorys2s.model.entity.Pagamento;
import com.github.Gregorys2s.model.entity.Pedidos;
import com.github.Gregorys2s.model.repositories.PagamentoRepository;
import com.github.Gregorys2s.model.service.pagamento.PagamentoService;
import com.github.Gregorys2s.model.service.pagamento.metodo.MetodoPagamentoEnum;
import com.github.Gregorys2s.model.service.pagamento.metodo.StatusPagamentoEnum;

import java.math.BigDecimal;

public class PagamentoServiceImpl implements PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoServiceImpl(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @Override
    public Pagamento processar(PagamentoDto pagamentoDto) {

        if (pagamentoDto == null)
            throw new IllegalArgumentException("pagamento não pode ser nulo");
        if (pagamentoDto.getValor() == null)
            throw new IllegalArgumentException("valor não pode ser nulo");
        if (pagamentoDto.getValor().compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("valor deve ser maior que zero");
        if (pagamentoDto.getMetodoPagamento() == null || pagamentoDto.getMetodoPagamento().isBlank())
            throw new IllegalArgumentException("método de pagamento não pode ser vazio");
        if (pagamentoDto.getIdPedido() == null)
            throw new IllegalArgumentException("id do pedido não pode ser nulo");

        MetodoPagamentoEnum metodoEnum;
        try {
            metodoEnum = MetodoPagamentoEnum.valueOf(
                    pagamentoDto.getMetodoPagamento().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("método inválido: " + pagamentoDto.getMetodoPagamento());
        }

        BigDecimal valor   = pagamentoDto.getValor();
        Integer idPedido   = pagamentoDto.getIdPedido();

        StatusPagamentoEnum status = StatusPagamentoEnum.AGUARDANDO;

        if (metodoEnum == MetodoPagamentoEnum.DINHEIRO) {
            status = StatusPagamentoEnum.PAGO;
        }else if(metodoEnum == MetodoPagamentoEnum.CREDITO){
            status = StatusPagamentoEnum.PENDENTE;
        }

        Pedidos pedido = new Pedidos();

        pedido.setId(idPedido);

        Pagamento pagamento = new Pagamento(valor, metodoEnum, status, pedido);

        pagamentoRepository.salvar(pagamento);
        return pagamento;
    }
}