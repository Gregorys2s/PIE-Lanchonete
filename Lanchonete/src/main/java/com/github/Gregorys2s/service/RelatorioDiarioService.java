package com.github.Gregorys2s.service;

import com.github.Gregorys2s.entity.Pedidos;
import com.github.Gregorys2s.entity.RelatorioDiario;
import com.github.Gregorys2s.repositories.PedidosRepository;
import com.github.Gregorys2s.repositories.RelatorioDiarioRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class RelatorioDiarioService {

    private final RelatorioDiarioRepository relatorioRepository;
    private final PedidosRepository pedidosRepository;

    public RelatorioDiarioService(RelatorioDiarioRepository relatorioRepository,
                                  PedidosRepository pedidosRepository) {
        this.relatorioRepository = relatorioRepository;
        this.pedidosRepository = pedidosRepository;
    }


    public RelatorioDiario gerarRelatorioDiario(BigDecimal despesas, BigDecimal lucroTotal) {
        LocalDate hoje = LocalDate.now();

        // Busca pedidos concluídos do dia pelo data_hora
        List<Pedidos> pedidosDoDia = pedidosRepository.buscarPedidosFinalizadosDoDia(hoje);

        int quantidadePedidos = pedidosDoDia.size();

        RelatorioDiario relatorio = new RelatorioDiario(hoje, quantidadePedidos, despesas, lucroTotal);
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
