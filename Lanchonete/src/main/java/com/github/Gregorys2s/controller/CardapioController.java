package com.github.Gregorys2s.controller;

import com.github.Gregorys2s.controller.Leitores;
import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.repositories.CardapioRepository;
import com.github.Gregorys2s.service.CardapioService;
import com.github.Gregorys2s.view.CardapioView;

import java.util.List;
import java.util.Scanner;

public class CardapioController {

    private CardapioView cardapioView;
    public void menuCardapio(Scanner sc)
    {
        //cardapio completo opcao 1
        //filtros opcao 2
        //alteracoes opcao 3
        Integer opcao = Leitores.leitorInteger(sc);
        switch (opcao) {
            case 1: cardapioView.mostrarCardapio(); break;
            case 2: cardapioView.menuAlteracoes();

            break;
        }
    }

    private void menuAlteracoes(Scanner sc)
    {
        Integer opcao = Leitores.leitorInteger(sc);
        switch (opcao) {
            case 1://em processo
        }
    }
}
