package com.github.Gregorys2s.model.service.relatorioSemanal;

import com.github.Gregorys2s.controller.relatoriosSemanal.DTO.RelatoriosSemanalesDTO;
import com.github.Gregorys2s.model.service.relatorioSemanal.RelatorioSemanalService;

import java.time.LocalDate;
import java.util.List;

public interface RelatorioSemanalService {

    void salvar(RelatoriosSemanalesDTO dto);

    void atualizar(RelatoriosSemanalesDTO dto);

    void excluir(LocalDate semanaInicio);

    RelatoriosSemanalesDTO buscarPorSemana(LocalDate semanaInicio);

    List<RelatoriosSemanalesDTO> listarTodos();
}