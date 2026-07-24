package com.github.Gregorys2s.model.repositories.RelatiorioSemanal;

import com.github.Gregorys2s.model.entity.RelatorioSemanal;
import java.time.LocalDate;
import java.util.List;

public interface RelatorioSemanalRepository {

    void salvar(RelatorioSemanal relatorio);

    void atualizar(RelatorioSemanal relatorio);

    void excluir(LocalDate semanaInicio);

    RelatorioSemanal buscarPorSemana(LocalDate semanaInicio);

    List<RelatorioSemanal> listarTodos();
}