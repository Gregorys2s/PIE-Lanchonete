package com.github.Gregorys2s.controller;

import com.github.Gregorys2s.entity.RelatorioDiario;
import com.github.Gregorys2s.service.RelatorioDiarioService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class RelatorioController {

    private final RelatorioDiarioService service;

    public RelatorioController(RelatorioDiarioService service) {
        this.service = service;
    }

    public RelatorioDiario gerarRelatorioDiario(BigDecimal despesas, BigDecimal lucroTotal) {
        return service.gerarRelatorioDiario(despesas, lucroTotal);
    }

    public List<RelatorioDiario> listarTodos() {
        return service.listarTodos();
    }

    public Optional<RelatorioDiario> buscarPorData(LocalDate data) {
        return service.buscarPorData(data);
    }
}
