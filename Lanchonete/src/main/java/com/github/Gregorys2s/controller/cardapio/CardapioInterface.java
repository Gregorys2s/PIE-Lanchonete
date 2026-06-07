package com.github.Gregorys2s.controller.cardapio;

import com.github.Gregorys2s.model.entity.Cardapio;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;

public interface CardapioInterface {
    public void adicionarItem(String nome, String tipo, BigDecimal valor);

    public void removerItem(Cardapio item);

    public String retornarNome(Integer id);

    public void atualizarItem(Integer id,String nome, String tipo, BigDecimal valor);

    public Cardapio produtoSelecionadoId(Integer id);

    public List<Cardapio> produtoSelecionadoNomeLista(String nome);

    public List<Cardapio> produtoSelecionadoTipoLista(String nome);

    public List<Cardapio> obterLista();


    public void verificarInput(String campoTable, Consumer<String> setter, String valor);

}
