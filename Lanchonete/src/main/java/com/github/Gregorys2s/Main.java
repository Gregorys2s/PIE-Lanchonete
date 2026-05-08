package com.github.Gregorys2s;

import com.github.Gregorys2s.entity.Pagamento;

import com.github.Gregorys2s.config.AppConfig;
import com.github.Gregorys2s.config.FlyWay;
import com.github.Gregorys2s.config.JPAUtil;
import com.github.Gregorys2s.controller.CardapioController;
import com.github.Gregorys2s.repositories.CardapioRepository;
import com.github.Gregorys2s.service.CardapioService;
import com.github.Gregorys2s.view.CardapioFrame;
import com.github.Gregorys2s.view.CardapioView;
import com.github.Gregorys2s.view.Inicializar;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
//
//        Inicializar init = AppConfig.configSistema();
//        init.inicializarSistema();
//
//    Pagamento pagamento = new Pagamento();

        FlyWay.migrate();
        EntityManager em = JPAUtil.getEntityManager();


        CardapioRepository cardapioRepository = new CardapioRepository(em);
        CardapioService cardapioService = new CardapioService(cardapioRepository);

        CardapioController cardapioController = new CardapioController(cardapioService);
        //arrumar amanha
        
        CardapioView cardapioView = new CardapioView(cardapioController.obterLista());//Nesse caso precisei por o view antes do control
        CardapioFrame cFrame = new CardapioFrame(cardapioController);
            java.awt.EventQueue.invokeLater(() -> {
                                    cFrame.setVisible(true);
                                });
    }
    

}