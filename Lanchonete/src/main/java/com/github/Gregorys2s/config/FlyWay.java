package com.github.Gregorys2s.config;

import org.flywaydb.core.Flyway;

public class FlyWay {

    public static void migrate() {
        Flyway flyway = Flyway.configure()
                .dataSource(
                        "jdbc:postgresql://localhost:5432/Lanchonete",
                        "postgres",
                        "admin"
                )
                // Mude para FALSE para ele não pular a criação das tabelas (V1)
                .baselineOnMigrate(false)
                .load();

        flyway.migrate();
    }
}