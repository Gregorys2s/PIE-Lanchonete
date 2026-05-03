package com.github.Gregorys2s.controller.entries;

public enum InputEnum {
    CONTINUAR,
    CANCELAR,
    NOVO_VALOR;

    public static InputEnum verifyInput(String input)
    {
        if(input.equalsIgnoreCase("CONTINUAR")) return CONTINUAR;
        if(input.equalsIgnoreCase("CANCELAR") || input == null) return CANCELAR;
        return NOVO_VALOR;
    }
}
