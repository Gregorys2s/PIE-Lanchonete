package com.github.Gregorys2s.service;

import com.github.Gregorys2s.entity.Pedidos;
import com.github.Gregorys2s.entity.RelatorioDiario;
import com.github.Gregorys2s.repositories.PedidosRepository;
import com.github.Gregorys2s.repositories.RelatorioDiarioRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class RelatorioDiarioService {

    private static final LocalTime INICIO_TURNO = LocalTime.of(18, 0);
    private static final LocalTime FIM_TURNO    = LocalTime.of(6, 0);

    private final RelatorioDiarioRepository relatorioRepository;
    private final PedidosRepository pedidosRepository;

    public RelatorioDiarioService(RelatorioDiarioRepository relatorioRepository,
                                  PedidosRepository pedidosRepository) {
        this.relatorioRepository = relatorioRepository;
        this.pedidosRepository = pedidosRepository;
    }


    private LocalDateTime[] calcularPeriodoTurno(LocalDateTime agora) {
        LocalDateTime inicio;
        LocalDateTime fim;

        if (agora.toLocalTime().isBefore(FIM_TURNO)) {
            // Madrugada: turno começou ontem às 18:00
            inicio = agora.toLocalDate().minusDays(1).atTime(INICIO_TURNO);
            fim    = agora.toLocalDate().atTime(FIM_TURNO);
        } else {
            // Noite: turno começa hoje às 18:00 e termina amanhã às 06:00
            inicio = agora.toLocalDate().atTime(INICIO_TURNO);
            fim    = agora.toLocalDate().plusDays(1).atTime(FIM_TURNO);
        }

        return new LocalDateTime[]{inicio, fim};
    }


    public RelatorioDiario gerarRelatorioDiario(BigDecimal despesas, BigDecimal lucroTotal) {
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime[] periodo = calcularPeriodoTurno(agora);
        LocalDateTime inicioPeriodo = periodo[0];
        LocalDateTime fimPeriodo    = periodo[1];

        List<Pedidos> pedidosDoDia = pedidosRepository
                .buscarPedidosFinalizadosPorPeriodo(inicioPeriodo, fimPeriodo);

        int quantidadePedidos = pedidosDoDia.size();

        LocalDate dataTurno = inicioPeriodo.toLocalDate();

        RelatorioDiario relatorio = new RelatorioDiario(
                dataTurno, quantidadePedidos, despesas, lucroTotal);

        relatorioRepository.salvar(relatorio);
        return relatorio;
    }

    public void exibirRelatorio(RelatorioDiario relatorio) {
        System.out.println("========== RELATÓRIO DIÁRIO ==========");
        System.out.println("Data              : " + relatorio.getData());
        System.out.println("Qtd. de Pedidos   : " + relatorio.getQuantidadePedidos());
        System.out.printf( "Despesas          : R$ %.2f%n", relatorio.getDespesas());
        System.out.printf( "Lucro Total       : R$ %.2f%n", relatorio.getLucroTotal());
        if (relatorio.getEstoqueFinal() != null) {
            System.out.printf("Estoque Final     : R$ %.2f%n", relatorio.getEstoqueFinal());
        }
        System.out.println("======================================");
    }
}
