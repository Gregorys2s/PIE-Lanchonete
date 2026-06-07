package com.github.Gregorys2s.controller.relatorios.Implementacoes;

import com.github.Gregorys2s.controller.relatorios.RelatoriosInterface;
import com.github.Gregorys2s.model.entity.RelatorioDiario;
import com.github.Gregorys2s.model.service.relatorioDiario.RelatorioDiarioServiceLmpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class RelatorioController implements RelatoriosInterface {

    private final RelatorioDiarioServiceLmpl service;

    public RelatorioController(RelatorioDiarioServiceLmpl service) {
        this.service = service;
    }
    @Override
    public RelatorioDiario gerarRelatorioDiario(BigDecimal despesas, BigDecimal lucroTotal) {
        return service.gerarRelatorioDiario(despesas, lucroTotal);
    }
    @Override
    public List<RelatorioDiario> listarTodos() {
        return service.listarTodos();
    }
    @Override
    public Optional<RelatorioDiario> buscarPorData(LocalDate data) {
        return service.buscarPorData(data);
    }
}
