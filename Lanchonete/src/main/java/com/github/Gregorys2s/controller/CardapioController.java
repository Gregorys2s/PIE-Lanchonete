package com.github.Gregorys2s.controller;

import com.github.Gregorys2s.controller.entries.InputEnum;
import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.exceptions.CardapioControllerException;
import com.github.Gregorys2s.service.CardapioService;
import java.math.BigDecimal;

import java.util.List;
import java.util.function.Consumer;

public class CardapioController {

    private final CardapioService cardapioService;

    public CardapioController(CardapioService cardapioService) {
        this.cardapioService = cardapioService;
    }

    public void adicionarItem(String nome, String tipo, BigDecimal valor)
    {
        cardapioService.salvarItem(cardapioService.transformarEmItemNovo(nome, tipo, valor));
    }
    public void removerItem(Cardapio item){
        if(item != null){
            cardapioService.deletarItem(item);
        } else {
            throw new CardapioControllerException("Operacao cancelada, id invalido");
        }
    }
    public String retornarNome(Integer id)
    {
        if(id == null){ throw new CardapioControllerException("Id invalido");}
        
        return cardapioService.acharID(id).getNome();
    }
    public void atualizarItem(Integer id,String nome, String tipo, BigDecimal valor)
    {
            cardapioService.atualizarItem(cardapioService.tranformarEmItemExistente(id, nome, tipo, valor));
    }
    public Cardapio produtoSelecionadoId(Integer id)
    {
        return cardapioService.acharID(id);
    }

    public List<Cardapio> produtoSelecionadoNomeLista(String nome)
    {
        return cardapioService.obterItemPorNomeLista(nome);
    }
    public List<Cardapio> produtoSelecionadoTipoLista(String nome)
    {
        return cardapioService.acharListaTipo(nome);
    }

    public List<Cardapio> obterLista()
    {
        List<Cardapio> cardapios = cardapioService.obterListaInteira();
        if(cardapios.isEmpty()){
            throw new CardapioControllerException("Operacao cancelada");
        } else {
            return cardapios;
        }
    }

    public void verificarInput(String campoTable, Consumer<String> setter, String valor)
    {
        InputEnum input = InputEnum.verifyInput(valor);
        switch (input) {
            case CONTINUAR-> System.out.println("Mantendo campo " + campoTable + " nao alterado");
            case CANCELAR -> throw new CardapioControllerException("Operacao cancelada");
            case  NOVO_VALOR -> setter.accept(valor);
        }
    }
}




