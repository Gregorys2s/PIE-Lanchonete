/*package com.github.Gregorys2s.controller;

import com.github.Gregorys2s.entity.Ingredientes;
import com.github.Gregorys2s.service.IngredientesService;
import com.github.Gregorys2s.exceptions.EstoqueRepositoryException;

public class IngredientesController {

    private IngredientesService service = new IngredientesService();

    public String salvarIngrediente(String nome, Integer estoque){
       try {
           Ingredientes novoIngrediente = new Ingredientes(nome, estoque);

           service.salvar(novoIngrediente);

           return "Ingrediente" + nome + " salvo com sucesso!";
       } catch (EstoqueRepositoryException e) {
           return "Erro:" + e.getMessage();
       } catch (Exception e) {
           return "Erro crítico:" + e.getMessage();
       }

    }
    public java.util.List<Ingredientes> listarIngredientes(){
        try {
            return service.buscarTodos();
        } catch (Exception e) {

            System.out.println("Erro ao buscar o estoque: " + e.getMessage());
            return new java.util.ArrayList<>();

        }

    }



}
 */