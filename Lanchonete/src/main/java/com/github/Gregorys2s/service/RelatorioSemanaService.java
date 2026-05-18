package com.github.Gregorys2s.service;

import com.github.Gregorys2s.entity.RelatorioDiario;
import com.github.Gregorys2s.entity.RelatorioSemanal;
import com.github.Gregorys2s.repositories.RelatorioDiarioRepository;
import com.github.Gregorys2s.repositories.RelatorioSemanaRepository;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class RelatorioSemanaService {
    private final RelatorioSemanaRepository relatorioSemanaRepository;
    private final RelatorioDiarioRepository relatorioDiarioRepository;

    public RelatorioSemanaService(RelatorioSemanaRepository relatorioSemanaRepository, RelatorioDiarioRepository relatorioDiarioRepository) {
        this.relatorioSemanaRepository = relatorioSemanaRepository;
        this.relatorioDiarioRepository = relatorioDiarioRepository;
    }


    public RelatorioSemanal gerarRelatorioSemanal(LocalDate dataDaSemana) {
        // Encontra a segunda-feira daquela semana
        LocalDate inicioSemana = dataDaSemana.with(DayOfWeek.MONDAY);
        LocalDate fimSemana = dataDaSemana.with(DayOfWeek.SUNDAY);

        int totalPedidosSemana = 0;
        BigDecimal lucroTotalSemana = BigDecimal.ZERO;
        BigDecimal despesasTotalSemana = BigDecimal.ZERO;

        // Loop pelos 7 dias da semana buscando os relatórios diários existentes
        for (LocalDate data = inicioSemana; !data.isAfter(fimSemana); data = data.plusDays(1)) {
            var relatorioDiarioOpt = relatorioDiarioRepository.buscarPorData(data);

            if (relatorioDiarioOpt.isPresent()) {
                RelatorioDiario diario = relatorioDiarioOpt.get();
                totalPedidosSemana += diario.getQuantidadePedidos();
                lucroTotalSemana = lucroTotalSemana.add(diario.getLucroTotal());
                despesasTotalSemana = despesasTotalSemana.add(diario.getDespesas());
            }
        }

        return new RelatorioSemanal(inicioSemana, totalPedidosSemana, lucroTotalSemana, despesasTotalSemana);
    }
}
