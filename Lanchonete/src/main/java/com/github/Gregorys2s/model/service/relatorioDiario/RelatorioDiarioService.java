package com.github.Gregorys2s.model.service.relatorioDiario;

import com.github.Gregorys2s.model.entity.RelatorioDiario;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface RelatorioDiarioService {

    public RelatorioDiario gerarRelatorioDiario(BigDecimal despesas, BigDecimal lucroTotal) ;

    public void exibirRelatorio(RelatorioDiario relatorio);

    public LocalDateTime[] calcularPeriodoTurno(LocalDateTime agora);
}
