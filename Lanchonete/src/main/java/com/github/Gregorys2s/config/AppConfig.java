package com.github.Gregorys2s.config;

import com.github.Gregorys2s.controller.CaixaController;
import com.github.Gregorys2s.controller.PedidosController;
import com.github.Gregorys2s.repositories.PedidosRepository;
import com.github.Gregorys2s.service.PedidosService;
import com.github.Gregorys2s.view.Inicializar;
import jakarta.persistence.EntityManager;

public class AppConfig {
    public static Inicializar configSistema()
    {
        FlyWay.migrate();
        EntityManager em = JPAUtil.getEntityManager();

        // ordem pra chamar
        //repository
         //service
         //controller
        PedidosRepository pedidosRepo = new PedidosRepository(em);
        PedidosService pedidosService = new PedidosService(pedidosRepo);
        PedidosController pedidosController = new PedidosController(pedidosService);

        CaixaController caixa = new CaixaController();

        return new Inicializar(pedidosController,caixa);
    }
}
