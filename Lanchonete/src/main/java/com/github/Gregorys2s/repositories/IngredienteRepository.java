package com.github.Gregorys2s.repositories;

import com.github.Gregorys2s.config.DatabaseConfig;
import com.github.Gregorys2s.entity.IngredientesEntity;
import com.github.Gregorys2s.exceptions.EstoqueRepositoryException;
import jakarta.persistence.EntityManager;

    public class IngredienteRepository {

        public void salvar(IngredientesEntity ingredientes){

            EntityManager em = DatabaseConfig.getEntityManager();

            try{
                em.getTransaction().begin();

                em.persist(ingredientes);

                em.getTransaction().commit();
            } catch(Exception e){

                if(em.getTransaction().isActive()){
                    em.getTransaction().rollback();
                }
                throw new EstoqueRepositoryException("Erro ao tentar salvar no banco de dados.");

            } finally {
                em.close();
            }

        }

}

