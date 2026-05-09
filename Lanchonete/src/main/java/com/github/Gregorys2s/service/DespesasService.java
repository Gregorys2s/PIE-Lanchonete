package com.github.Gregorys2s.service;

import com.github.Gregorys2s.entity.Despesas;
import com.github.Gregorys2s.exceptions.DespesasServiceException;
import com.github.Gregorys2s.repositories.DespesasRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DespesasService {
    private final DespesasRepository despesasRepository;
    public DespesasService(DespesasRepository despesasRepository) {
        this.despesasRepository = despesasRepository;
    }

    public void novaDespesa(BigDecimal valorDespesa) {
        if (valorDespesa == null) {throw new DespesasServiceException("Erro inesperado, operacao cancelada");}
        Despesas despesas = new Despesas();
        despesas.setDataHora(LocalDateTime.now());
        despesas.setValorDespesa(valorDespesa);
        try{
            despesasRepository.save(despesas);
        } catch(DespesasServiceException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
