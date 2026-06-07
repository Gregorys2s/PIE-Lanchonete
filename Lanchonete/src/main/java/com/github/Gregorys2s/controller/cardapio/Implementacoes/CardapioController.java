package com.github.Gregorys2s.controller.cardapio.Implementacoes;

import com.github.Gregorys2s.controller.cardapio.CardapioInterface;
import com.github.Gregorys2s.controller.entries.InputEnum;
import com.github.Gregorys2s.model.entity.Cardapio;
import com.github.Gregorys2s.exceptions.CardapioControllerException;
import com.github.Gregorys2s.model.service.cardapio.CardapioServiceImpl;
import java.math.BigDecimal;

import java.util.List;
import java.util.function.Consumer;

public class CardapioController implements CardapioInterface {

    private final CardapioServiceImpl cardapioService;

    public CardapioController(CardapioServiceImpl cardapioService) {
        this.cardapioService = cardapioService;
    }

    @Override
    public void adicionarItem(String nome, String tipo, BigDecimal valor)
    {
        cardapioService.salvarItem(cardapioService.transformarEmItemNovo(nome, tipo, valor));
    }

    @Override
    public void removerItem(Cardapio item){
        if(item != null){
            cardapioService.deletarItem(item);
        } else {
            throw new CardapioControllerException("Operacao cancelada, id invalido");
        }
    }

    @Override
    public String retornarNome(Integer id)
    {
        if(id == null){ throw new CardapioControllerException("Id invalido");}
        
        return cardapioService.acharID(id).getNome();
    }

    @Override
    public void atualizarItem(Integer id,String nome, String tipo, BigDecimal valor)
    {
            cardapioService.atualizarItem(cardapioService.tranformarEmItemExistente(id, nome, tipo, valor));
    }
    @Override

    public Cardapio produtoSelecionadoId(Integer id)
    {
        return cardapioService.acharID(id);
    }

    @Override
    public List<Cardapio> produtoSelecionadoNomeLista(String nome)
    {
        return cardapioService.obterItemPorNomeLista(nome);
    }

    @Override
    public List<Cardapio> produtoSelecionadoTipoLista(String nome)
    {
        return cardapioService.acharListaTipo(nome);
    }

    @Override
    public List<Cardapio> obterLista()
    {
        List<Cardapio> cardapios = cardapioService.obterListaInteira();
        if(cardapios.isEmpty()){
            throw new CardapioControllerException("Operacao cancelada");
        } else {
            return cardapios;
        }
    }

    @Override
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




