package com.github.Gregorys2s.repositories;

import com.github.Gregorys2s.config.DatabaseConfig;
import com.github.Gregorys2s.entity.IngredientesEntity;
import com.github.Gregorys2s.exceptions.EstoqueRepositoryException;
import jakarta.persistence.EntityManager;

import java.util.List;

public class IngredienteRepository {

        private final EntityManager em;

        public IngredienteRepository(EntityManager em) {
            this.em = em;

        }

        public void salvar(IngredientesEntity ingredientes) {
            em.persist(ingredientes);
        }

        public IngredientesEntity buscarPorId(Long id){
            return em.find(IngredientesEntity.class, id);
        }

        public List<IngredientesEntity> buscarTodos() {
            return em.createQuery("SELECT i FROM IngrdientesEntity i",IngredientesEntity.class).getResultList();

        }

        public void atualizar(IngredientesEntity ingredientes) {
            em.merge(ingredientes);

        }

        public void excluir(Long id) {
            IngredientesEntity ingredientes = buscarPorId(id);
            if (ingredientes != null) {
                em.remove(ingredientes);
            }


        }

}

