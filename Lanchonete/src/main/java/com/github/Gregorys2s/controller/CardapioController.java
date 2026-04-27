package com.github.Gregorys2s.controller;

import com.github.Gregorys2s.controller.Leitores;
import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.exceptions.CardapioControllerException;
import com.github.Gregorys2s.repositories.CardapioRepository;
import com.github.Gregorys2s.service.CardapioService;
import com.github.Gregorys2s.view.CardapioView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class CardapioController {

    private CardapioView cardapioView;
    private  CardapioService cardapioService;
    public void menuCardapio(Scanner sc)
    {
        //cardapio completo opcao 1
        //filtros opcao 2
        //alteracoes opcao 3
        Integer opcao = Leitores.leitorInteger(sc);
        switch (opcao) {
            case 1: cardapioView.mostrarCardapio(); break;
            case 2: cardapioView.menuPesquisas(); break;
            case 3:
                cardapioView.menuAlteracoes();//mostra o menu
                menuAlteracoes(sc);//coleta os dados
            break;
            default: throw new CardapioControllerException("Opcao invalida");
        }
    }

    private void menuAlteracoes(Scanner sc)
    {
        Integer opcao = Leitores.leitorInteger(sc);
        //opc 1 adicionar item
        //opc 2 remover item
        //opc 3 atualizar item (nome, preco, tipo)
        //opc 4 atualizar ingredientes do item (fk_ingrediente_id)
        //opc 4 mexer mais pra frente
        switch (opcao) {
            case 1: adicionarItem(sc); break;
            case 2: removerItem(sc); break;
            case 3: atualizarItem(sc); break;
            default: throw new CardapioControllerException("Opcao invalida");
        }
    }
    private void adicionarItem(Scanner sc)
    {
        try {
            Cardapio cardapio = new Cardapio();
            System.out.println("Digite o nome do produto: ");
            String nome = Leitores.leitorTextos(sc);
            if(nome.isEmpty()){
                throw new CardapioControllerException("Operacao cancelada");
            }
            System.out.println("Digite o valor do produto: ");
            BigDecimal preco = Leitores.leitorDecimais(sc);
            if(preco.compareTo(BigDecimal.ZERO)<=0){
                throw new CardapioControllerException("Operacao cancelada");
            }
            System.out.println("Digite o tipo do produto: ");
            String tipo = Leitores.leitorTextos(sc);
            if(tipo.isEmpty()){
                throw new CardapioControllerException("Operacao cancelada");
            }
            cardapio.setNome(nome);
            cardapio.setPreco(preco);
            cardapio.setTipo(tipo);
            cardapioService.salvarItem(cardapio);

        } catch (CardapioControllerException e) {
            System.out.println(e.getMessage());
        }

    }

    private void removerItem(Scanner sc)
    {
        try {
            cardapioView.mostrarCardapioIds();
            System.out.println("Digite o id do produto: ");
            Integer id = Leitores.leitorInteger(sc);
            Cardapio removido = cardapioService.acharID(id);
            if(removido != null){
                cardapioService.deletarItem(removido);
            } else {
                throw new CardapioControllerException("Operacao cancelada, id invalido");
            }
        } catch (CardapioControllerException e) {
            System.out.println(e.getMessage());
        }
    }

    private void atualizarItem(Scanner sc)
    {
        try {
            cardapioView.mostrarCardapioIds();
            System.out.println("Digite o id do produto: ");
            Integer id = Leitores.leitorInteger(sc);
            Cardapio atualizar = cardapioService.acharID(id);
            if(atualizar != null){
                System.out.println("Digite o nome do produto ou " +
                        "digite continuar para \"atualizar\" o preco: ");
                String nome = Leitores.leitorTextos(sc);
                if(nome.isEmpty()){
                    throw new CardapioControllerException("Operacao cancelada");
                }
                System.out.println("Digite o valor do produto: ");
                BigDecimal preco = Leitores.leitorDecimais(sc);
                if(preco.compareTo(BigDecimal.ZERO)<=0){throw new CardapioControllerException("Operacao cancelada");}
                System.out.println("Digite o tipo do produto: ");
                String tipo = Leitores.leitorTextos(sc);
                if(tipo.isEmpty()){throw new CardapioControllerException("Operacao cancelada");}
                atualizar.setNome(nome);
                atualizar.setPreco(preco);
                atualizar.setTipo(tipo);
                cardapioService.atualizarItem(atualizar);
            }
        } catch (CardapioControllerException e) {
            System.out.println(e.getMessage());
        }
    }
                     //trocar o nome, mas serve como referencia para um teste
    public Cardapio produtoSelecionado(Integer id)
    {
        return cardapioService.acharID(id);
    }

}
