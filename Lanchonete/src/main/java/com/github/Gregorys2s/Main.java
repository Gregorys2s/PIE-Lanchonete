package com.github.Gregorys2s;
//
//import com.github.Gregorys2s.config.AppConfig;
//import com.github.Gregorys2s.view.Inicializar;
import com.github.Gregorys2s.view.MenuPrincipal;

import javax.swing.*;
//import com.github.Gregorys2s.entity.Pagamento;

//import com.github.Gregorys2s.config.AppConfig;
import com.github.Gregorys2s.config.FlyWay;
import com.github.Gregorys2s.config.JPAUtil;
//import com.github.Gregorys2s.view.Inicializar;
import jakarta.persistence.EntityManager;

public class    Main {
    public static void main(String[] args) {
//
//        Inicializar init = AppConfig.configSistema();
//        init.inicializarSistema();
//
//    Pagamento pagamento = new Pagamento();

        FlyWay.migrate();
        EntityManager em = JPAUtil.getEntityManager();


//        Inicializar init = AppConfig.configSistema();
        //init.inicializarSistema();
        SwingUtilities.invokeLater(() -> {
            new MenuPrincipal(em).setVisible(true);
        });

        
    }


}