package com.github.Gregorys2s.service;


import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.exceptions.PersistenciaProdutoRepositoryException;
import com.github.Gregorys2s.exceptions.ServiceCardapioException;
import com.github.Gregorys2s.repositories.CardapioRepository;

import java.util.List;

//service usa o repository NAO ESQUECER
public class CardapioService {
    private CardapioRepository  cardapioRepository;

    public void salvarItem(Cardapio cardapio) {
        try{
            if(cardapio == null){ throw new ServiceCardapioException("Erro inesperado no sistema cancelando operacao");}
            cardapioRepository.save(cardapio);
        } catch (ServiceCardapioException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void deletarItem(Cardapio cardapio) {
        try{
            if(cardapio == null){throw new ServiceCardapioException("Erro inesperado no sistema cancelando operacao");}
            cardapioRepository.delete(cardapio);
        } catch (ServiceCardapioException | PersistenciaProdutoRepositoryException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void atualizarItem(Cardapio cardapio) {
        try {
            if(cardapio == null){throw new ServiceCardapioException("Erro inesperado no sistema cancelando operacao");}
            cardapioRepository.update(cardapio);
        }  catch (ServiceCardapioException | PersistenciaProdutoRepositoryException e)
        {
            System.out.println(e.getMessage());
        }
    }
    //daqui para baixo os metodos tem a mesma logica
    //verifica se o parametro eh valido, se a variavel eh valida, coleta erros com try catch


    public List<Cardapio> acharListaTipo(String tipo) {
        try
        {
            //verifica se a string eh valida
            if(tipo == null) {throw new ServiceCardapioException("Erro inesperado no sistema cancelando operacao");}
            List<Cardapio> cardapio= cardapioRepository.findByType(tipo);
            //^pega a lista com o repository de cardapio^
            //∨ Verifica se a lista retornou algo ∨
            if(cardapio == null) {throw new ServiceCardapioException("Erro inesperado no sistema cancelando operacao");}
            return cardapio; //se sim ela retorna a var
        } catch (ServiceCardapioException | PersistenciaProdutoRepositoryException e) {
            System.out.println(e.getMessage());
            return null; //se ocorrer qualquer erro retorna nulo
        }
    }


    public Cardapio acharID(Integer idCardapio) {
        try {
            if(idCardapio == null)  {throw new ServiceCardapioException("Erro inesperado no sistema cancelando operacao");}
            Cardapio cardapio = cardapioRepository.findById(idCardapio);
            if(cardapio == null) {throw new ServiceCardapioException("Erro inesperado no sistema cancelando operacao");}
            return cardapio;
        } catch (ServiceCardapioException | PersistenciaProdutoRepositoryException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<Cardapio> obterItemPorNome(String nome) {
        try {
            if(nome == null){throw new ServiceCardapioException("Erro inesperado no sistema cancelando operacao0");}
            List<Cardapio> cardapio = cardapioRepository.findByName(nome);
            if(cardapio == null){throw new ServiceCardapioException("Erro inesperado no sistema cancelando operacao");}
            return cardapio;
        } catch (ServiceCardapioException | PersistenciaProdutoRepositoryException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<Cardapio> obterListaInteira() {
        try {
            List<Cardapio> cardapio= cardapioRepository.findAll();
            if (cardapio == null) {throw new ServiceCardapioException("Erro inesperado no sistema cancelando operacao");}
            return cardapio;
        } catch (ServiceCardapioException | PersistenciaProdutoRepositoryException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
