package com.github.Gregorys2s.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
//mover o que esta na dataBaseConfig aqui, nao misturar responsabilidades
public class ManagerEntity {

    public class JPAUtil {

        private static final EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("LanchonetePU");

        public static EntityManager getEntityManager() {
            return emf.createEntityManager();
        }

        public static void close() {
            emf.close();
        }
    }
}
