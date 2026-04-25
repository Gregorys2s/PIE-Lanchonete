package com.github.Gregorys2s.config;

public class DatabaseConfig {
    private static jakarta.persistence.EntityManagerFactory emf;

    public static void iniciarFlyway() {
       org.flywaydb.core.Flyway flyway = org.flywaydb.core.Flyway.configure()
               .dataSource("jdbc:postgresql://localhost:5432/Lanchonete", "postgres", "admin")
               .schemas("public")
               .load();
       flyway.migrate();

    }

    public static void iniciarJPA() {

        emf = jakarta.persistence.Persistence.createEntityManagerFactory("Lanchonete");

    }

    public static jakarta.persistence.EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}