package com.github.Gregorys2s.model.service.relatorioSemanal;

import com.github.Gregorys2s.controller.relatoriosSemanal.DTO.RelatoriosSemanalesDTO;
import com.github.Gregorys2s.model.entity.RelatorioSemanal;
import com.github.Gregorys2s.model.repositories.RelatiorioSemanal.RelatorioSemanalRepositoryImpl;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class RelatorioSemanalServiceImpl implements RelatorioSemanalService {

    private final RelatorioSemanalRepositoryImpl repository;

    public RelatorioSemanalServiceImpl(RelatorioSemanalRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public void salvar(RelatoriosSemanalesDTO dto) {

        RelatorioSemanal relatorio = new RelatorioSemanal();

        relatorio.setSemanaInicio(dto.getSemanaInicio());
        relatorio.setTotalPedidos(dto.getTotalPedidos());
        relatorio.setLucroTotal(dto.getLucroTotal());
        relatorio.setDespesasTotal(dto.getDespesasTotal());

        repository.salvar(relatorio);
    }

    @Override
    public void atualizar(RelatoriosSemanalesDTO dto) {

        RelatorioSemanal relatorio = new RelatorioSemanal();

        relatorio.setSemanaInicio(dto.getSemanaInicio());
        relatorio.setTotalPedidos(dto.getTotalPedidos());
        relatorio.setLucroTotal(dto.getLucroTotal());
        relatorio.setDespesasTotal(dto.getDespesasTotal());

        repository.atualizar(relatorio);
    }

    @Override
    public void excluir(LocalDate semanaInicio) {
        repository.excluir(semanaInicio);
    }

    @Override
    public RelatoriosSemanalesDTO buscarPorSemana(LocalDate semanaInicio) {

        RelatorioSemanal relatorio = repository.buscarPorSemana(semanaInicio);

        if (relatorio == null)
            return null;

        RelatoriosSemanalesDTO dto = new RelatoriosSemanalesDTO();

        dto.setSemanaInicio(relatorio.getSemanaInicio());
        dto.setTotalPedidos(relatorio.getTotalPedidos());
        dto.setLucroTotal(relatorio.getLucroTotal());
        dto.setDespesasTotal(relatorio.getDespesasTotal());

        return dto;
    }

    @Override
    public List<RelatoriosSemanalesDTO> listarTodos() {

        return repository.listarTodos()
                .stream()
                .map(relatorio -> {
                    RelatoriosSemanalesDTO dto = new RelatoriosSemanalesDTO();

                    dto.setSemanaInicio(relatorio.getSemanaInicio());
                    dto.setTotalPedidos(relatorio.getTotalPedidos());
                    dto.setLucroTotal(relatorio.getLucroTotal());
                    dto.setDespesasTotal(relatorio.getDespesasTotal());

                    return dto;
                })
                .collect(Collectors.toList());
    }
}