package com.github.Gregorys2s.controller.relatoriosSemanal;

import com.github.Gregorys2s.controller.relatoriosSemanal.DTO.RelatoriosSemanalesDTO;

import java.time.LocalDate;
import java.util.List;

public interface RelatoriosSemanalesInterface {

    void salvar(RelatoriosSemanalesDTO dto);

    void atualizar(RelatoriosSemanalesDTO dto);

    void excluir(LocalDate semanaInicio);

    RelatoriosSemanalesDTO buscarPorSemana(LocalDate semanaInicio);

    List<RelatoriosSemanalesDTO> listarTodos();
}