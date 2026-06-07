package com.github.Gregorys2s.model.service.despesas;

import com.github.Gregorys2s.model.entity.Despesas;
import com.github.Gregorys2s.exceptions.DespesasServiceException;
import com.github.Gregorys2s.model.repositories.DespesasRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DespesasServicelmpl implements DespesasService {
    private final DespesasRepository despesasRepository;
    public DespesasServicelmpl(DespesasRepository despesasRepository) {
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
