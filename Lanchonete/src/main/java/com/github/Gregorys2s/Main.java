package com.github.Gregorys2s;
//
//import com.github.Gregorys2s.config.AppConfig;
//import com.github.Gregorys2s.view.Inicializar;

import com.github.Gregorys2s.config.AppConfig;
import com.github.Gregorys2s.view.inicializacao.MenuPrincipal;
//import com.github.Gregorys2s.view.Inicializar;

//import com.github.Gregorys2s.entity.Pagamento;

//import com.github.Gregorys2s.config.AppConfig;
//import com.github.Gregorys2s.view.Inicializar;


public class Main {
    public static void main(String[] args) {

        AppConfig config = new AppConfig();
        // 2. Run the UI on the Event Dispatch Thread (Swing standard)
        java.awt.EventQueue.invokeLater(() -> {
            try {
                // 3. Instantiate MenuPrincipal passing the EntityManager
                MenuPrincipal menu = new MenuPrincipal(
                        config.getCardapioController(),
                        config.getPedidosController()
                );
                
                // 4. Make it visible
                menu.setVisible(true);

            } catch (Exception e) {//fazer a coletanea de erros depois
                e.printStackTrace();
            }
        });
        

    }


}