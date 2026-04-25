package com.github.Gregorys2s.service;


import com.github.Gregorys2s.entity.Cardapio;
import com.github.Gregorys2s.exceptions.PersistenciaProdutoRepositoryException;
import com.github.Gregorys2s.exceptions.ServiceCardapioException;
import com.github.Gregorys2s.repositories.CardapioRepository;

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
}
