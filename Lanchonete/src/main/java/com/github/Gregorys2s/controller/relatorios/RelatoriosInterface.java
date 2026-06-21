package com.github.Gregorys2s.controller.relatorios;

import com.github.Gregorys2s.model.entity.RelatorioDiario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RelatoriosInterface {

    public RelatorioDiario gerarRelatorioDiario(BigDecimal despesas, BigDecimal lucroTotal);

    public List<RelatorioDiario> listarTodos();

    public Optional<RelatorioDiario> buscarPorData(LocalDate data);
}
