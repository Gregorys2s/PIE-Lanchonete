package com.github.Gregorys2s;
//
//import com.github.Gregorys2s.config.AppConfig;
//import com.github.Gregorys2s.view.Inicializar;
import com.github.Gregorys2s.view.MenuPrincipal;

import com.github.Gregorys2s.config.AppConfig;
import com.github.Gregorys2s.controller.IngredientesController;
import com.github.Gregorys2s.service.IngredientesService;
import com.github.Gregorys2s.view.IngredientePanel;
import javax.swing.SwingUtilities;
//import com.github.Gregorys2s.view.Inicializar;

import javax.swing.*;
//import com.github.Gregorys2s.entity.Pagamento;

//import com.github.Gregorys2s.config.AppConfig;
import com.github.Gregorys2s.config.FlyWay;
import com.github.Gregorys2s.config.JPAUtil;
//import com.github.Gregorys2s.view.Inicializar;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
//        Inicializar init = AppConfig.configSistema();

        IngredientesService service = new IngredientesService();
        IngredientesController controller = new IngredientesController(service);

        SwingUtilities.invokeLater(() -> {
            IngredientePanel tela = new IngredientePanel(controller);
            tela.setVisible(true);
        });

//
//        Inicializar init = AppConfig.configSistema();
//        init.inicializarSistema();
//
//    Pagamento pagamento = new Pagamento();

//        FlyWay.migrate();
//        EntityManager em = JPAUtil.getEntityManager();


//        Inicializar init = AppConfig.configSistema();
        //init.inicializarSistema();
//        SwingUtilities.invokeLater(() -> {
//            new MenuPrincipal(em).setVisible(true);
//        });


    }


}