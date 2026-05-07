package com.github.Gregorys2s.controller.entries;

import com.github.Gregorys2s.exceptions.DespesasControllerException;

public enum InputEnum {
    CONTINUAR,
    CANCELAR,
    NOVO_VALOR;

    public static InputEnum verifyInput(String input)
    {
        if(input == null)
        {
            throw new DespesasControllerException("Entrada inválida.");
        }

        String texto = input.trim().toLowerCase();

        if(texto.equals("continuar"))
        {
            return CONTINUAR;
        }

        if(texto.equals("cancelar"))
        {
            return CANCELAR;
        }

        if(texto.matches("^[0-9]+([.,][0-9]+)?$")){
            return NOVO_VALOR;
        }

        throw new DespesasControllerException("Entrada inválida. Operação cancelada.");
    }


}
