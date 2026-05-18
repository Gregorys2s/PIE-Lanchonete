package com.github.Gregorys2s.controller;

import com.github.Gregorys2s.entity.RelatorioDiario;
import com.github.Gregorys2s.entity.RelatorioSemanal;
import com.github.Gregorys2s.service.RelatorioDiarioService;
import com.github.Gregorys2s.service.RelatorioSemanaService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class RelatorioController {

    private final RelatorioDiarioService relatorioDiarioService;
    private final RelatorioSemanaService relatorioSemanaService;

    public RelatorioController(RelatorioDiarioService relatorioDiarioService) {
        this.relatorioDiarioService = relatorioDiarioService;
    }

    public RelatorioDiario gerarRelatorioDiario(BigDecimal despesas, BigDecimal lucroTotal) {
        return relatorioDiarioService.gerarRelatorioDiario(despesas, lucroTotal);
    }

    public List<RelatorioDiario> listarTodos() {
        return relatorioDiarioService.listarTodos();
    }

    public Optional<RelatorioDiario> buscarPorData(LocalDate data) {
        return relatorioDiarioService.buscarPorData(data);
    }

    public RelatorioSemanal gerarRelatorioSemanal(LocalDate data) {
        return relatorioSemanaService.gerarRelatorioSemanal(data);
    }
}
