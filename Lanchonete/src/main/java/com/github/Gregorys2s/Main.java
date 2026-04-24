package com.github.Gregorys2s;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import com.github.Gregorys2s.entity.ProdutoEntity;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        org.flywaydb.core.Flyway flyway = org.flywaydb.core.Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/Lanchonete", "postgres", "admin")
                .load();

        flyway.migrate();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurantePU");
        EntityManager em = emf.createEntityManager();

        try {
            ProdutoEntity p = new ProdutoEntity();
            p.setNome("Hambúrguer Artesanal");
            p.setPreco(new BigDecimal("35.00"));

            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();

            System.out.println("Deu boa Tropa " + p.getId());

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Levei ERRO " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}