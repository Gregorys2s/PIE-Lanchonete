package com.github.Gregorys2s.model.service.caixa.Impl;

import com.github.Gregorys2s.model.entity.Caixa.Caixa;
import com.github.Gregorys2s.model.repositories.caixa.CaixaRepository;
import com.github.Gregorys2s.model.service.caixa.CaixaService;

import java.math.BigDecimal;

public class CaixaServiceImpl implements CaixaService {

    private final CaixaRepository caixaRepository;

    public CaixaServiceImpl(CaixaRepository caixaRepository) {
        this.caixaRepository = caixaRepository;
    }

    @Override
    public Caixa abrirCaixa(BigDecimal valorInicial) {
        validarValor(valorInicial);

        if (isAberto()) {
            throw new IllegalStateException("O caixa já está aberto.");
        }

        return caixaRepository.abrirCaixa(valorInicial);
    }

    @Override
    public Caixa registrarReceita(BigDecimal valor) {
        validarCaixaAberto();
        validarValor(valor);

        return caixaRepository.registrarEntrada(valor);
    }

    @Override
    public Caixa registrarDespesa(BigDecimal valor) {
        validarCaixaAberto();
        validarValor(valor);

        Caixa caixaAtual = caixaRepository.obterCaixaAtual();

        if (valor.compareTo(caixaAtual.getSaldo()) > 0) {
            throw new IllegalArgumentException("Saldo insuficiente no caixa para registrar essa despesa.");
        }

        return caixaRepository.registrarDespesa(valor);
    }

    @Override
    public Caixa obterCaixa() {
        return caixaRepository.obterCaixaAtual();
    }

    @Override
    public boolean isAberto() {
        return caixaRepository.obterCaixaAtual().isAberto();
    }

    private void validarCaixaAberto() {
        if (!isAberto()) {
            throw new IllegalStateException("Abra o caixa antes de realizar essa operação.");
        }
    }

    private void validarValor(BigDecimal valor) {
        if (valor == null) {
            throw new IllegalArgumentException("Valor não pode ser nulo.");
        }

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor precisa ser maior que zero.");
        }
    }
}