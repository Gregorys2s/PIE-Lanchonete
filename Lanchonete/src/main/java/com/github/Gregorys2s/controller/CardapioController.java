package com.github.Gregorys2s.controller;

import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.exceptions.CardapioControllerException;
import com.github.Gregorys2s.service.CardapioService;

import java.util.List;

public class CardapioController {

    private final CardapioService cardapioService;

    public CardapioController(CardapioService cardapioService) {
        this.cardapioService = cardapioService;
    }

    public void EidolhaDoMenu(int id, Cardapio item)
    {
        menuAlteracoes(id,item);
    }

    public void menuAlteracoes(int opcao, Cardapio item)
    {
        //opc 1 adicionar item
        //opc 2 remover item
        //opc 3 atualizar item (nome, preco, tipo)
        //opc 4 atualizar ingredientes do item (fk_ingrediente_id)
        //opc 4 mexer mais pra frente
        switch (opcao) {
            case 1: adicionarItem(item); break;
            case 2: removerItem(item); break;
            case 3: //atualizarItem(item) ; break;
            default: throw new CardapioControllerException("Opcao invalida");
        }
    }
    private void adicionarItem(Cardapio item)
    {
            cardapioService.salvarItem(item);
    }
    private void removerItem(Cardapio item){
        if(item != null){
            cardapioService.deletarItem(item);
        } else {
            throw new CardapioControllerException("Operacao cancelada, id invalido");
        }
    }

    private void atualizarItem(Cardapio item)
    {

            cardapioService.atualizarItem(item);

    }
                     //trocar o nome, mas serve como referencia para um teste
    public Cardapio produtoSelecionadoId(Integer id)
    {
        return cardapioService.acharID(id);
    }

    public Cardapio produtoSelecionadoNome(String nome)
    {
        return cardapioService.obterItemPorNome(nome);
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
}




