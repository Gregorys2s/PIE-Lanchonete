package com.github.Gregorys2s.controller.relatoriosSemanal.Implementacoes;

import com.github.Gregorys2s.controller.relatoriosSemanal.DTO.RelatoriosSemanalesDTO;
import com.github.Gregorys2s.controller.relatoriosSemanal.RelatoriosSemanalesInterface;
import com.github.Gregorys2s.model.service.relatorioSemanal.RelatorioSemanalService;

import java.time.LocalDate;
import java.util.List;

public class RelatoriosSemanalesController implements RelatoriosSemanalesInterface {

    private final RelatorioSemanalService service;

    public RelatoriosSemanalesController(RelatorioSemanalService service) {
        this.service = service;
    }

    @Override
    public void salvar(RelatoriosSemanalesDTO dto) {
        service.salvar(dto);
    }

    @Override
    public void atualizar(RelatoriosSemanalesDTO dto) {
        service.atualizar(dto);
    }

    @Override
    public void excluir(LocalDate semanaInicio) {
        service.excluir(semanaInicio);
    }

    @Override
    public RelatoriosSemanalesDTO buscarPorSemana(LocalDate semanaInicio) {
        return service.buscarPorSemana(semanaInicio);
    }

    @Override
    public List<RelatoriosSemanalesDTO> listarTodos() {
        return service.listarTodos();
    }
}