package com.github.Gregorys2s.model.service.cardapio;

import com.github.Gregorys2s.model.entity.Cardapio;

import java.math.BigDecimal;
import java.util.List;

public interface CardapioService {


        public void salvarItem(Cardapio cardapio);

        public void deletarItem(Cardapio cardapio);
        public void atualizarItem(Cardapio cardapio);


        public List<Cardapio> acharListaTipo(String tipo);


        public Cardapio acharID(Integer idCardapio);

        public List<Cardapio> obterItemPorNomeLista(String nome);
        public List<Cardapio> obterListaInteira();


        public Cardapio transformarEmItemNovo(String nome, String tipo, BigDecimal valor);


        public Cardapio tranformarEmItemExistente(Integer id, String nome, String tipo, BigDecimal valor);

}
