package com.github.Gregorys2s.repositories;

import com.github.Gregorys2s.entity.Ingredientes;
import jakarta.persistence.EntityManager;

import java.util.List;

public class IngredienteRepository {

        private final EntityManager em;

        public IngredienteRepository(EntityManager em) {
            this.em = em;

        }

        public void salvar(Ingredientes ingredientes) {
            em.persist(ingredientes);
        }

        public Ingredientes buscarPorId(Long id){
            return em.find(Ingredientes.class, id);
        }

        public List<Ingredientes> buscarTodos() {
            return em.createQuery("SELECT i FROM IngrdientesEntity i", Ingredientes.class).getResultList();

        }

        public void atualizar(Ingredientes ingredientes) {
            em.merge(ingredientes);

        }

        public void excluir(Long id) {
            Ingredientes ingredientes = buscarPorId(id);
            if (ingredientes != null) {
                em.remove(ingredientes);
            }


        }

}



